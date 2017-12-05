package agi.foundation.compatibility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.annotation.Nonnull;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Represents a delegate, which is a data structure that refers to a static method or to a
 * class instance and an instance method of that class.
 *
 * Each subclass must provide an invoke method that either directly contains the
 * implementation (in the case of an anonymous delegate), or dispatches to an instance or
 * static method, passing parameters through and returning the result.
 */
public abstract class Delegate {
    @Internal
    protected interface MulticastDelegate<T extends Delegate> {
        MulticastList<T> list();
    }

    @Internal
    protected static final class MulticastList<T extends Delegate> {
        private ArrayList<T> list;

        @SuppressWarnings("unchecked")
        public MulticastList(T a, T b) {
            list = new ArrayList<>();

            if (a instanceof MulticastDelegate<?>) {
                list.addAll(((MulticastDelegate<T>) a).list().list);
            } else {
                list.add(a);
            }

            if (b instanceof MulticastDelegate<?>) {
                list.addAll(((MulticastDelegate<T>) b).list().list);
            } else {
                list.add(b);
            }
        }

        public MulticastList(ArrayList<T> list) {
            this.list = list;
        }

        public MulticastList<T> removeLast(T t) {
            ArrayList<T> resultList = new ArrayList<>(list);
            for (int i = resultList.size() - 1; i >= 0; i--) {
                if (resultList.get(i).equals(t)) {
                    resultList.remove(i);
                    break;
                }
            }
            return new MulticastList<>(resultList);
        }

        public ArrayList<T> list() {
            return list;
        }

        public T last() {
            return list.get(list.size() - 1);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;

            if (!(obj instanceof MulticastList<?>))
                return false;

            MulticastList<?> that = (MulticastList<?>) obj;
            return list.equals(that.list);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + list.hashCode();
            return result;
        }
    }

    /**
     * Finder to locate the method we are a delegate to.
     */
    @Nonnull
    private final CachingMethodFinder methodFinder;

    /**
     * Finder to locate our own invoke method for use by dynamicInvoke.
     */
    @Nonnull
    private final CachingMethodFinder invokeFinder = new CachingMethodFinder(this);

    /**
     * Called from anonymous delegates. No external target or method.
     */
    protected Delegate() {
        methodFinder = invokeFinder;
    }

    /**
     * Initializes a delegate that invokes the specified static method from the specified
     * class.
     *
     * Used by delegate references to static methods.
     *
     * @param targetClass
     *            The class that defines the method.
     * @param methodName
     *            The name of the static method that the delegate represents.
     * @param methodParameterClasses
     *            The classes of all method parameters.
     */
    protected Delegate(@Nonnull Class<?> targetClass, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        this.methodFinder = new CachingMethodFinder(targetClass, methodName, methodParameterClasses);
    }

    /**
     * Initializes a delegate that invokes the specified instance method on the specified
     * class instance.
     *
     * Used by delegate references to instance methods.
     *
     * @param targetObject
     *            The class instance on which the delegate will invoke the method.
     * @param methodName
     *            The name of the instance method that the delegate represents.
     * @param methodParameterClasses
     *            The classes of all method parameters.
     */
    protected Delegate(@Nonnull Object targetObject, @Nonnull String methodName, @Nonnull Class<?>[] methodParameterClasses) {
        this.methodFinder = new CachingMethodFinder(targetObject, methodName, methodParameterClasses);
    }

    /**
     * Dynamically invokes (late-bound) the method represented by the current delegate.
     *
     * @param args
     *            An array of objects that are the arguments to pass to the method
     *            represented by the current delegate, or null, if the method represented
     *            by the current delegate does not require arguments.
     * @return The object returned by the method represented by the delegate.
     */
    public Object dynamicInvoke(Object... args) {
        Method method = invokeFinder.findMethod();
        if (!method.isAccessible())
            method.setAccessible(true);

        try {
            return method.invoke(this, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeIllegalAccessException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeInvocationTargetException(e);
        }
    }

    /**
     * Gets the method represented by the delegate.
     *
     * If this delegate invokes one or more methods, this returns the last method in the
     * invocation list.
     *
     * @return An object describing the method represented by the delegate.
     */
    public Method getMethod() {
        return methodFinder.findMethod();
    }

    /**
     * Gets the class instance on which the current delegate invokes the instance method.
     *
     * If this delegate invokes one or more instance methods, this returns the target of
     * the last instance method in the invocation list.
     *
     * @return The object on which the current delegate invokes the instance method, if
     *         the delegate represents an instance method; a null reference if the
     *         delegate represents a static method.
     */
    public Object getTarget() {
        return methodFinder.getTargetObject();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Delegate))
            return false;

        // C# spec:
        // Two delegate instances are considered equal as follows:
        // * If either of the delegate instances is null, they are equal if and only if
        // both are null.
        // * If the delegates have different run-time type they are never equal.

        // Second point is checked by equals override in subclasses

        Delegate that = (Delegate) obj;
        return methodFinder.equals(that.methodFinder);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + methodFinder.hashCode();
        return result;
    }
}
