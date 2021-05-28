package agi.foundation.compatibility;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import agi.foundation.TypeLiteral;

/**
 * Stores information describing a method, and when requested can find that method using
 * reflection and cache the result.
 */
class CachingMethodFinder {
    /**
     * Encapsulates the required information and mechanism for actually finding the
     * method.
     */
    @Nonnull
    private final Strategy strategy;
    /**
     * The cached method after finding it.
     */
    @Nullable
    private Method method;

    /**
     * Finds an method named "invoke" directly on a delegate-like object (which is a
     * subclass of {@link Delegate}).
     */
    public CachingMethodFinder(@Nonnull Object delegateObject) {
        strategy = new DelegateInvokeStrategy(delegateObject);
    }

    /**
     * Finds a static method on a target class.
     */
    public CachingMethodFinder(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        strategy = new StaticMethodStrategy(targetClass, methodName, methodParameterClasses);
    }

    /**
     * Finds an instance method on a target object.
     */
    public CachingMethodFinder(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        strategy = new InstanceMethodStrategy(targetObject, methodName, methodParameterClasses);
    }

    /**
     * Find the method referred to and memoize the result.
     */
    @Nonnull
    public Method findMethod() {
        if (method != null)
            return method;

        method = strategy.findMethod();

        if (method != null)
            return method;

        throw new RuntimeException("Unable to find method for delegate: " + strategy.getMethodName());
    }

    /**
     * The actual search algorithm, called by the strategy.
     */
    private static Method searchForMethod(@Nonnull String methodName, @Nonnull Class<?> classToSearch, @Nonnull EnumSet<SearchCriteria> searchCriteria,
                                          @Nonnull Class<?>... methodParameterClasses) {
        for (Method method : classToSearch.getDeclaredMethods()) {
            int modifers = method.getModifiers();

            // check that method is correctly static/instance as asked.
            boolean isStatic = Modifier.isStatic(modifers);
            if (isStatic && searchCriteria.contains(SearchCriteria.INSTANCE_METHODS_ONLY))
                continue;

            if (!isStatic && searchCriteria.contains(SearchCriteria.STATIC_METHODS_ONLY))
                continue;

            // Always check the method name.
            if (!methodName.equals(method.getName()))
                continue;

            // Only check the parameter types if we are asked to.
            if (searchCriteria.contains(SearchCriteria.CHECK_PARAMETER_TYPES) && !parametersMatch(method, methodParameterClasses))
                continue;

            // at this point, name and types (if checked) matched, so we have
            // found the method and we're done.
            return method;
        }

        // if method was not found to be declared on the specified class,
        // then search superclasses recursively.
        Class<?> superclass = classToSearch.getSuperclass();
        if (superclass != null) {
            return searchForMethod(methodName, superclass, searchCriteria, methodParameterClasses);
        }

        // otherwise, not found.
        return null;
    }

    /**
     * Determine if a candidate method's parameters have the the required classes.
     */
    private static boolean parametersMatch(@Nonnull Method method, @Nonnull Class<?>[] methodParameterClasses) {
        Type[] parameterTypes = method.getGenericParameterTypes();

        int index = 0;
        while (index < parameterTypes.length) {
            // skip any TypeLiteral parameters that are at the start.
            Type type = parameterTypes[index];
            if (type instanceof ParameterizedType) {
                if (TypeLiteral.class.equals(((ParameterizedType) type).getRawType())) {
                    ++index;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if ((parameterTypes.length - index) != methodParameterClasses.length)
            return false;

        for (int i = index, j = 0; i < parameterTypes.length && j < methodParameterClasses.length; ++i, ++j) {
            Type parameterType = parameterTypes[i];

            // don't compare type variables, i.e. parameters of type T.
            if (parameterType instanceof TypeVariable<?>)
                continue;

            // The Class object in methodParameterClasses will be the raw type, so
            // get the raw type from parameterType as well.
            if (parameterType instanceof ParameterizedType) {
                parameterType = ((ParameterizedType) parameterType).getRawType();
            }

            if (!parameterType.equals(methodParameterClasses[j]))
                return false;
        }

        return true;
    }

    public Object getTargetObject() {
        return strategy.getTargetObject();
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

        // If two invocation list entries both refer to the same static method then the
        // entries are equal.

        // If two invocation list entries both refer to the same non-static method on
        // the same target object (as defined by the reference equality operators) then
        // the entries are equal.

        // Invocation list entries produced from evaluation of semantically identical
        // anonymous-function-expressions with the same (possibly empty) set of captured
        // outer variable instances are permitted (but not required) to be equal.

        // (end C# spec)

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

        return strategy.equals(that.strategy);
    }

    @Override
    public int hashCode() {
        return strategy.hashCode();
    }

    private enum SearchCriteria {
        STATIC_METHODS_ONLY,
        INSTANCE_METHODS_ONLY,
        CHECK_PARAMETER_TYPES,
    }

    /**
     * Encapsulates the required information and mechanism for actually finding the
     * method.
     */
    private interface Strategy {
        Method findMethod();

        String getMethodName();

        Object getTargetObject();

        @Override
        boolean equals(Object obj);

        @Override
        int hashCode();
    }

    /**
     * Finds an method named "invoke" directly on a delegate-like object (which is a
     * subclass of {@link Delegate}).
     */
    private static final class DelegateInvokeStrategy implements Strategy {
        @Nonnull
        private static final EnumSet<SearchCriteria> searchCriteria = EnumSet.of(SearchCriteria.INSTANCE_METHODS_ONLY);
        @Nonnull
        private static final String invokeMethodName = "invoke";
        @Nonnull
        private final Object delegateObject;

        public DelegateInvokeStrategy(@Nonnull Object delegateObject) {
            this.delegateObject = delegateObject;
        }

        @Override
        public Method findMethod() {
            return searchForMethod(invokeMethodName, delegateObject.getClass(), searchCriteria);
        }

        @Override
        public String getMethodName() {
            return invokeMethodName;
        }

        @Override
        public Object getTargetObject() {
            return null;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            // see commentary in CachingMethodFinder.equals
            return false;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(this);
        }
    }

    /**
     * Finds a static method on a target class.
     */
    private static final class StaticMethodStrategy implements Strategy {
        @Nonnull
        private static final EnumSet<SearchCriteria> searchCriteria = EnumSet.of(SearchCriteria.STATIC_METHODS_ONLY, SearchCriteria.CHECK_PARAMETER_TYPES);
        /**
         * The class that defines the static method.
         */
        @Nonnull
        private final Class<?> targetClass;
        /**
         * The name of the method to find.
         */
        @Nonnull
        private final String methodName;
        /**
         * The classes of all method parameters, in order.
         */
        @Nonnull
        private final Class<?>[] methodParameterClasses;

        public StaticMethodStrategy(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
            this.targetClass = targetClass;
            this.methodName = methodName;
            this.methodParameterClasses = methodParameterClasses;
        }

        @Override
        public Method findMethod() {
            return searchForMethod(methodName, targetClass, searchCriteria, methodParameterClasses);
        }

        @Override
        public String getMethodName() {
            return methodName;
        }

        @Override
        public Object getTargetObject() {
            return null;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof StaticMethodStrategy))
                return false;

            StaticMethodStrategy that = (StaticMethodStrategy) obj;

            // see commentary in CachingMethodFinder.equals
            return Objects.equals(targetClass, that.targetClass) && //
                    Objects.equals(methodName, that.methodName) && //
                    Arrays.equals(methodParameterClasses, that.methodParameterClasses);
        }

        @Override
        public int hashCode() {
            return HashCodeHelper.combine(Objects.hashCode(targetClass), Objects.hashCode(methodName), Arrays.hashCode(methodParameterClasses));
        }
    }

    /**
     * Finds an instance method on a target object.
     */
    private static final class InstanceMethodStrategy implements Strategy {
        @Nonnull
        private static final EnumSet<SearchCriteria> searchCriteria = EnumSet.of(SearchCriteria.INSTANCE_METHODS_ONLY, SearchCriteria.CHECK_PARAMETER_TYPES);
        /**
         * The object on which to find the instance method.
         */
        @Nonnull
        private final Object targetObject;
        /**
         * The name of the method to find.
         */
        @Nonnull
        private final String methodName;
        /**
         * The classes of all method parameters, in order.
         */
        @Nonnull
        private final Class<?>[] methodParameterClasses;

        public InstanceMethodStrategy(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
            this.targetObject = targetObject;
            this.methodName = methodName;
            this.methodParameterClasses = methodParameterClasses;
        }

        @Override
        public Method findMethod() {
            return searchForMethod(methodName, targetObject.getClass(), searchCriteria, methodParameterClasses);
        }

        @Override
        public String getMethodName() {
            return methodName;
        }

        @Override
        public Object getTargetObject() {
            return targetObject;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof InstanceMethodStrategy))
                return false;

            InstanceMethodStrategy that = (InstanceMethodStrategy) obj;

            // see commentary in CachingMethodFinder.equals
            return ObjectHelper.referenceEquals(targetObject, that.targetObject) && //
                    Objects.equals(methodName, that.methodName) && //
                    Arrays.equals(methodParameterClasses, that.methodParameterClasses);
        }

        @Override
        public int hashCode() {
            return HashCodeHelper.combine(System.identityHashCode(targetObject), Objects.hashCode(methodName), Arrays.hashCode(methodParameterClasses));
        }
    }
}
