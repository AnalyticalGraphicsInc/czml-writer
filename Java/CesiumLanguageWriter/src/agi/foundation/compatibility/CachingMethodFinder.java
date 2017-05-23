package agi.foundation.compatibility;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.EnumSet;

import javax.annotation.Nonnull;

import agi.foundation.TypeLiteral;

/**
 * Stores information describing a method, and when requested can find that method using
 * reflection and cache the result.
 */
class CachingMethodFinder {
    private enum SearchCriteria {
        STATIC_METHODS_ONLY,
        INSTANCE_METHODS_ONLY,
        CHECK_PARAMETER_TYPES
    }

    @Nonnull
    private static final EnumSet<SearchCriteria> delegateObjectSearchCriteria;
    @Nonnull
    private static final EnumSet<SearchCriteria> instanceMethodSearchCriteria;
    @Nonnull
    private static final EnumSet<SearchCriteria> staticMethodSearchCriteria;

    static {
        delegateObjectSearchCriteria = EnumSet.of(SearchCriteria.INSTANCE_METHODS_ONLY);
        instanceMethodSearchCriteria = EnumSet.of(SearchCriteria.INSTANCE_METHODS_ONLY, SearchCriteria.CHECK_PARAMETER_TYPES);
        staticMethodSearchCriteria = EnumSet.of(SearchCriteria.STATIC_METHODS_ONLY, SearchCriteria.CHECK_PARAMETER_TYPES);
    }

    private final Object delegateObject;
    private final Object targetObject;
    private final Class<?> targetClass;
    private final String methodName;
    private final Class<?>[] methodParameterClasses;
    private Method cachedMethod;

    /**
     * finds an "invoke" method directly on a delegate-like object (either Delegate or
     * DelegateInvocation)
     */
    public CachingMethodFinder(Object delegateObject) {
        this.delegateObject = delegateObject;
        this.targetObject = null;
        this.targetClass = null;
        this.methodName = null;
        this.methodParameterClasses = null;
    }

    /**
     * Find a static method on a target class.
     */
    public CachingMethodFinder(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        this.delegateObject = null;
        this.targetObject = null;
        this.targetClass = targetClass;
        this.methodName = methodName;
        this.methodParameterClasses = methodParameterClasses;
    }

    /**
     * Find an instance method on a target object.
     */
    public CachingMethodFinder(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        this.delegateObject = null;
        this.targetObject = targetObject;
        this.targetClass = null;
        this.methodName = methodName;
        this.methodParameterClasses = methodParameterClasses;
    }

    /**
     * Find the method referred to and memoize the result.
     */
    public Method findMethod() {
        if (cachedMethod == null) {
            if (delegateObject != null) {
                cacheMethod("invoke", delegateObject.getClass(), delegateObjectSearchCriteria);
            } else if (targetObject != null) {
                // if we have a target object, then we are a delegate to an
                // instance method on that object
                cacheMethod(methodName, targetObject.getClass(), instanceMethodSearchCriteria);
            } else if (targetClass != null) {
                // if we have a target class, then we are a delegate to an
                // static method on that class
                cacheMethod(methodName, targetClass, staticMethodSearchCriteria);
            }
        }
        return cachedMethod;
    }

    private void cacheMethod(String name, Class<?> classToSearch, EnumSet<SearchCriteria> searchCriteria) {
        for (Method method : classToSearch.getDeclaredMethods()) {
            int modifers = method.getModifiers();

            boolean isStatic = Modifier.isStatic(modifers);
            if (isStatic && searchCriteria.contains(SearchCriteria.INSTANCE_METHODS_ONLY))
                continue;

            if (!isStatic && searchCriteria.contains(SearchCriteria.STATIC_METHODS_ONLY))
                continue;

            if (name.equals(method.getName())) {
                if (searchCriteria.contains(SearchCriteria.CHECK_PARAMETER_TYPES)) {
                    if (!parametersMatch(method))
                        continue;
                }

                // at this point, name and types (if checked) matched
                cachedMethod = method;
                return;
            }
        }

        // if method was not found to be declared on the specified class,
        // then try superclasses
        Class<?> superclass = classToSearch.getSuperclass();
        if (superclass != null)
            cacheMethod(name, superclass, searchCriteria);
    }

    private boolean parametersMatch(Method method) {
        Type[] parameterTypes = method.getGenericParameterTypes();

        int numberOfParameters = parameterTypes.length;
        int index = 0;
        while (index < numberOfParameters) {
            // skip any TypeLiteral parameters that are at the start.
            Type type = parameterTypes[index];
            if (type instanceof ParameterizedType) {
                ParameterizedType c = (ParameterizedType) type;
                if (TypeLiteral.class.equals(c.getRawType()))
                    ++index;
                else
                    break;
            } else {
                break;
            }
        }

        if ((numberOfParameters - index) != methodParameterClasses.length)
            return false;

        for (int i = index, j = 0; i < parameterTypes.length && j < methodParameterClasses.length; ++i, ++j) {
            Type type = parameterTypes[i];
            if (type instanceof TypeVariable<?>)
                // don't compare type variables, i.e. parameters of type T.
                continue;

            // the Class object in methodParams will be the raw type, so extract
            // it from the Type as well.
            if (type instanceof ParameterizedType)
                type = ((ParameterizedType) type).getRawType();

            if (!type.equals(methodParameterClasses[j]))
                return false;
        }

        return true;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof CachingMethodFinder))
            return false;

        CachingMethodFinder that = (CachingMethodFinder) obj;

        // C# spec:
        // The following rules govern the equality of invocation list entries:
        // * If two invocation list entries both refer to the same static method then the
        // entries are equal.
        // * If two invocation list entries both refer to the same non-static method on
        // the same target object (as defined by the reference equality operators) then
        // the entries are equal.
        // * Invocation list entries produced from evaluation of semantically identical
        // anonymous-function-expressions with the same (possibly empty) set of captured
        // outer variable instances are permitted (but not required) to be equal.

        if (targetClass != that.targetClass && (targetClass == null || !targetClass.equals(that.targetClass))) {
            // static method and classes don't match.
            return false;
        }

        if (targetObject != that.targetObject) {
            // non-static method and target objects don't match
            return false;
        }

        if (methodName != null) {
            // refers to a named method, check method name and parameters
            return methodName.equals(that.methodName) && Arrays.equals(methodParameterClasses, that.methodParameterClasses);
        }

        // refers to an anonymous function expression.

        // C# treats anonymous function expressions with the same body as equal only if
        // they do not close over any variables, though this is not strictly required by
        // the spec.

        // Currently we don't have a good way to determine whether variables are closed
        // over, so we have to take the conservative approach and return false.

        // e.g.

        // @formatter:off

        // private Action CreateActionDelegate()
        // {
        //    return () => { };
        // }

        // Action a = CreateActionDelegate();
        // Action b = CreateActionDelegate();
        // a.Equals(b)  // => true

        // Action a = () => {};
        // Action b = () => {};
        // a.Equals(b)  // => false
        
        // private Action CreateActionDelegate(bool b)
        // {
        //    return () => { if (b) { Foo(); } };
        // }

        // Action a = CreateActionDelegate(true);
        // Action b = CreateActionDelegate(true);
        // a.Equals(b)  // => false
        
        // @formatter:on

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;

        if (methodName == null)
            result = 31 * result + getClass().hashCode();
        else
            result = 31 * result + methodName.hashCode();

        result = 31 * result + (targetClass == null ? 0 : targetClass.hashCode());
        result = 31 * result + (targetObject == null ? 0 : targetObject.hashCode());
        result = 31 * result + Arrays.hashCode(methodParameterClasses);

        return result;
    }
}
