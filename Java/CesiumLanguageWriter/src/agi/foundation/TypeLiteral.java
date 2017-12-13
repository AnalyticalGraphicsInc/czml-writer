/*
 * Created: May-August, 2007
 *
 * Evaluating Software Design Patterns
 * - the "Gang of Four" patterns implemented in Java 6
 *
 * Gunni Rode - http://www.rode.dk
 *
 * Master's Thesis, Computer Science
 * Department of Computer Science,
 * The Faculty of Science,
 * University of Copenhagen
 *
 * Feel free to use and/or modify the Java 6 source code
 * developed for this thesis AT YOUR OWN RISK, but note
 * that the source code comes WITHOUT ANY - and I do mean
 * WITHOUT ANY - form of warranty WHAT SO EVER!
 *
 * The original thesis and source code are available at
 * http://www.rode.dk/thesis
 *
 */
package agi.foundation;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * Represents the <i>type</i> realised as the type parameter {@code T}, where {@code T}
 * may be a generic type that need not be <i>reifiable</i>.
 * <p>
 *
 * The type of {@code T} can be retrieved with the {@link #getType()} method. It can
 * represent a class, a type variable, a wild-card type, a component type of a generic
 * type array, or a type parameter of a parameterised type with a single type parameter
 * (also called a component type).
 * <p>
 *
 * The <i>raw type</i> of {@code T} can be retrieved with the {@link #getRawType()} method
 * if {@code T} does <b>not</b> represent a type variable, a wild-card, or a generic array
 * type storing type variables.
 * <p>
 *
 * A type literal can also represent <i>non-reifiable types</i>. Hence, there can be
 * inconsistencies between {@code T} and the actual type represented by the literal
 * because of <i>erasure</i>: though {@code T} may seem to represent a known type in the
 * literal, say {@code Integer} as in {@code
 * TypeLiteral<Integer>}, the actual type can represent a type variable, say {@code S}, as
 * is illustrated in the examples below (see for example {@code
 * literal5}). This is normally not an issue if type literals are created explicitly and
 * not by generic methods or through extended inheritance.
 * <p>
 *
 * <b>Examples</b>:
 *
 * <pre>
 *
 * // Standard creation...
 *
 * // T = Integer, type = class, raw type = Integer class
 * TypeLiteral&lt;Integer&gt; literal1 = new TypeLiteral&lt;Integer&gt;(){};
 *
 * // T = Object[], type = generic array type, raw type = Object class
 * TypeLiteral&lt;Object[]&gt; literal2 = new TypeLiteral&lt;Object[]&gt;(){};
 *
 * // T = Class&lt;String&gt;[], type = generic array type, raw type = Class class
 * TypeLiteral&lt;Class&lt;String&gt;[]&gt; literal3 = new TypeLiteral&lt;Class&lt;String&gt;[]&gt;(){};
 *
 * // T = List&lt;?&gt;, type = class, raw type = List interface
 * TypeLiteral&lt;List&lt;?&gt;&gt; literal4 = new TypeLiteral&lt;List&lt;?&gt;&gt;(){};
 *
 * // Factory creation...
 *
 * // Generic factory methods...
 * public static &lt;S&gt; TypeLiteral&lt;S&gt; create1(S value) {
 *   return new TypeLiteral&lt;S&gt;(){};
 * }
 * public static &lt;R&gt; TypeLiteral&lt;Comparable&lt;R&gt;&gt; create2(R value) {
 *     return new TypeLiteral&lt;Comparable&lt;R&gt;(){};
 * }
 *
 * // Potential trouble: T = Integer, type = type variable (S), raw type = null
 * TypeLiteral&lt;Integer&gt; literal5 = create1(new Integer(1));
 *
 * // Potential trouble: T = Class&lt;Integer&gt;, type = type variable (S), raw type = null
 * TypeLiteral&lt;Class&lt;Integer&gt;&gt; literal6 = create1(Integer.class);
 *
 * // Potential trouble: T = Class&lt;Integer&gt;, type = type variable (S), raw type = null
 * TypeLiteral&lt;Class&lt;Integer&gt;&gt; literal7 = create1(null);
 *
 * // Potential trouble: T = Comparable&lt;Long&gt;,
 * //                        type = parameterised type (with type parameter R), raw type = Comparable interface
 * TypeLiteral&lt;Comparable&lt;Long&gt;&gt; literal8 = create2(Long.class);
 *
 * // Potential trouble: T = Comparable&lt;Object&gt;,
 * //                        type = parameterised type (with type parameter R), raw type = Comparable interface
 * TypeLiteral&lt;Comparable&lt;Object&gt;&gt; literal9 = create2(null);
 *
 * // Inheritance...
 *
 * class Foo extends TypeLiteral&lt;ArrayList&lt;?&gt;&gt;{};
 * class FooFoo extends TypeLiteral&lt;CharSequence&gt;{};
 * class Bar extends Foo {};
 * class Goo&lt;K,V&gt; extends TypeLiteral&lt;Map&lt;K,V&gt;&gt;{};
 * class FooGoo&lt;K,V&gt; extends TypeLiteral&lt;Map&lt;Long,Void&gt;&gt;{};
 * class FooBar extends Goo&lt;String,Void&gt; {};
 *
 * // T = ArrayList&lt;?&gt;, type = parameterised type, raw type = ArrayList class
 * Foo literal10 = new Foo();
 *
 * // T = CharSequence, type = class, raw type = CharSequence interface
 * FooFoo literal11 = new FooFoo();
 *
 * // Potential trouble: T = Map&lt;K,V&gt;, type = parameterised type, raw type = Map interface
 * Goo literal12 = new Goo&lt;String,Integer&gt;();
 *
 * // T = Map&lt;Long,Void&gt;, type = parameterised type, raw type = Map interface
 * FooGoo literal13 = new FooGoo&lt;String,Integer&gt;();
 *
 * // Throws illegal argument exception: Bar has no immediate generic super type
 * Bar literal14 = new Bar();
 *
 * // Potential trouble: FooBar's immediate generic super type has two type parameters:
 * // &lt;String,Void&gt;, and so the first, e.g. {@code String}, is used.
 * FooBar literal15 = new FooBar();
 * </pre>
 *
 * <b>Implementation notes</b>:<br>
 * Based on <i>Gafter's Gadget</i>, an idea by Neal Gafter [
 * <a href="http://www.rode.dk/thesis/Bibliography.htm#Gafter06" target=
 * "thesis-bibliography">Gafter06</a>].
 * <p>
 *
 * See [<a href="http://www.rode.dk/thesis/Bibliography.htm#Langer06" target=
 * "thesis-bibliography">Langer06</a>], for example technical details <a href=
 * "http://www.angelikalanger.com/GenericsFAQ/FAQSections/TechnicalDetails.html#FAQ106" >
 * FAQ106</a>, for an easily understandable discussion on <i>reifiable types</i> and
 * <i>erasure</i>. It contains condensed information from <i>The Java Language
 * Specification, Third Edition</i> [
 * <a href="http://www.rode.dk/thesis/Bibliography.htm#Gosling05" target=
 * "thesis-bibliography">Gosling05</a>] about
 * <a href= "http://java.sun.com/docs/books/jls/third_edition/html/typesValues.html#4.7" >
 * reifiable</a> types.
 *
 * @author Gunni Rode / <a href="http://www.rode.dk">rode.dk</a>
 *
 * @see #getComponentType(Type)
 * @see #getRawType(Type)
 *
 * @param <T>
 *            The type represented by this type literal.
 */
public abstract class TypeLiteral<T> {

    /**
     * The actual {@code Type} object representing the type realised as the type parameter
     * {@code T}.
     * <p>
     *
     * Never null.
     */
    protected final Type type;

    /**
     * Constructor, which creates this type literal to represent the type represented by
     * the type parameter {@code T}.
     *
     * @throws IllegalArgumentException
     *             If this class is not generic.
     */
    protected TypeLiteral() {
        Class<?> clazz = this.getClass();
        // The generic superclass will be this class unless the
        // inheritance hierarchy is even deeper!
        Type superClass = clazz.getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            this.type = getComponentType(superClass);

            // If sub-classes are not generic...
        } else {
            throw new IllegalArgumentException("Class is not generic: " + clazz);
        }
    }

    /**
     * Constructor, which creates this type literal to represent the <i>component type</i>
     * of the type supplied as {@code type}.
     *
     * @param type
     *            The type; cannot be null.
     * @throws NullPointerException
     *             If {@code type} is null.
     * @throws IllegalArgumentException
     *             If {@code type} is a parameterised type with no type parameter (if more
     *             than one, the first is used). Zero type parameters can occur if
     *             {@code type} type represents a non-parameterised type nested within a
     *             parameterised type.
     * @see #getComponentType(Type)
     */
    private TypeLiteral(Type type) {
        this.type = getComponentType(type);
    }

    /**
     * Copy constructor, which creates this type literal based on the type represented by
     * {@code typeLiteral}.
     *
     * @param typeLiteral
     *            The type literal to copy; cannot be null.
     * @throws NullPointerException
     *             If {@code typeLiteral} is null.
     */
    public TypeLiteral(TypeLiteral<T> typeLiteral) {
        this.type = typeLiteral.type;
    }

    /**
     * Returns a type literal representing the generic super-type of class supplied as
     * {@code clazz}.
     * <p>
     *
     * @param <S>
     *            The type of {@code clazz}.
     * @param clazz
     *            The class literal representing the type; cannot be null.
     * @return A type literal representing the generic super-type; never null.
     * @throws NullPointerException
     *             If {@code clazz} is null.
     * @see #create(Type)
     */
    public static <S> TypeLiteral<?> create(Class<S> clazz) {
        // S is needed to construct an instance, cannot use wild-card.
        return new TypeLiteral<S>(clazz.getGenericSuperclass()) {/* magic */};
    }

    /**
     * Returns a type literal representing the generic super-type of class of
     * {@code object}.
     *
     * @param object
     *            The object to supply the class; cannot be null.
     * @return A type literal representing the generic super-type of the class of
     *         {@code object}; never null.
     * @throws NullPointerException
     *             If {@code object} is null.
     */
    public static TypeLiteral<?> create(Object object) {
        return create(object.getClass());
    }

    /**
     * Returns a type literal representing the <i>component type</i> supplied via
     * {@code type}.
     *
     * @param type
     *            The type; cannot be null.
     * @return A type literal representing the component type of {@code type}; never null.
     * @throws NullPointerException
     *             If {@code type} is null.
     * @see #getComponentType(Type)
     * @see #create(Class)
     */
    public static TypeLiteral<?> create(Type type) {
        return new TypeLiteral<Object>(type) {/* magic */};
    }

    /**
     * Returns a <i>view</i> of the {@link #getType() type} represented by this type
     * literal as a class literal if and only if the type has a {@link #getRawType() raw
     * type}.
     * <p>
     *
     * Note, that if the type is generic, the returned <b>class literal actually
     * represents the raw type</b>!
     *
     * @return A class literal, or null.
     * @see #asClass(Class)
     * @see #asType(TypeLiteral)
     */
    public Class<T> asClass() {
        Class<?> clazz = this.getRawType();
        if (clazz == null) {
            return null;
        }
        // See JavaDoc above...
        @SuppressWarnings("unchecked")
        Class<T> c = (Class<T>) clazz;
        return c;
    }

    /**
     * Returns a <i>view</i> of the class represented by {@code clazz} as the
     * {@link #getType() type} represented by this type literal, if possible.
     * <p>
     *
     * This type must have a {@link #getRawType() raw type} for this method to have a
     * chance of succeeding.
     * <p>
     *
     * Note, that if the type is generic, the returned <b>class literal actually
     * represents the raw type</b>!
     *
     * @param clazz
     *            The class to view as the type represented by this type literal; cannot
     *            be null.
     * @return A class literal; never null.
     * @throws NullPointerException
     *             If {@code clazz} is null.
     * @throws ClassCastException
     *             If {@code clazz} cannot be viewed as the type represented by this type
     *             literal.
     * @see #asClass()
     * @see #asType(TypeLiteral)
     */
    public Class<T> asClass(Class<?> clazz) {
        return this.asType(create(clazz)).asClass();
    }

    /**
     * Returns a <i>view</i> of {@code typeLiteral} as the type represented by this type
     * literal, {@code T} instead of {@code S}, if possible.
     * <p>
     *
     * If a cast from {@code S} to {@code T} is not possible, a class cast exception is
     * thrown. If the {@link #getType() type} represented by this type literal does not
     * have a {@link #getRawType() raw type}, a class cast exception will also be thrown.
     * Two will card types will cause a class cast exception, as a simple cast will
     * suffice.
     * <p>
     *
     * The test for matching types is done recursively, including test for generic array
     * and parameter types with bounded and/or unbounded wild-cards.
     * <p>
     *
     * @param <S>
     *            The type represented by {@code typeLiteral}.
     * @param typeLiteral
     *            The type literal; cannot be null.
     * @return {@code typeLiteral} casted to represent {@code T} instead of {@code S}, if
     *         possible; never null.
     * @throws NullPointerException
     *             If {@code typeLiteral} is null.
     * @throws IllegalArgumentException
     *             If either {@code T} or {@code S} recursively do not represent a
     *             parameterised type.
     * @throws ClassCastException
     *             If {@code typeLiteral} cannot represent {@code T}.
     * @see #getComponentType(Type)
     * @see #asClass()
     * @see #asClass(Class)
     */
    public <S> TypeLiteral<T> asType(TypeLiteral<S> typeLiteral) {
        if ((this.type instanceof TypeVariable<?>) || (this.type instanceof WildcardType)) {
            throw new ClassCastException();
        }
        // Invariant: all other types have a raw type!

        // Raw type...
        if (isAssignableFrom(this.getRawType(), typeLiteral.getRawType(), false)) {
            // Type parameters, if any...
            if (isAssignableFrom(this.type, typeLiteral.type, true)) {
                // Known to succeed because of the above checks...
                @SuppressWarnings("unchecked")
                TypeLiteral<T> tl = (TypeLiteral<T>) typeLiteral;
                return tl;
            }
        }
        throw new ClassCastException(this.toString() + " !> " + typeLiteral);
    }

    /**
     * Returns true if {@code a} is recursively assignable from {@code b}, false if not.
     * <p>
     *
     * The test will always returns false if either {@code a} or {@code b} are a type
     * variable. For generic array and parameterised types, the test will recurse. Wild
     * cards bounds are handled as well.
     * <p>
     *
     * Two unbounded wild card types will return false!
     *
     * @param a
     *            The first type; cannot be null.
     * @param b
     *            The second type; cannot be null.
     * @param equal
     *            True if a class match is determined using {@code
     *            equals(Object)} instead of {@code isAssignableFrom(Class)}.
     * @return True if {@code a} is recursively assignable from {@code b}, false if not.
     * @see #getComponentType(Type)
     */
    private static boolean isAssignableFrom(Type a, Type b, boolean equal) {
        if (a instanceof TypeVariable<?>) {
            return false;
        } else if (a instanceof Class<?>) {
            if (b instanceof Class<?>) {
                if (equal) {
                    return a.equals(b);
                } else {
                    return ((Class<?>) a).isAssignableFrom((Class<?>) b);
                }
            } else if (b instanceof ParameterizedType) {
                return isAssignableFrom(a, getComponentType(b), true);
            }
        } else if (a instanceof ParameterizedType) {
            if (b instanceof ParameterizedType) {
                ParameterizedType aa = (ParameterizedType) a;
                ParameterizedType bb = (ParameterizedType) b;
                if (isAssignableFrom(getRawType(aa), getRawType(bb), false)) {
                    return isAssignableFrom(getComponentType(aa), getComponentType(bb), true);
                }
            } else if (b instanceof Class<?>) {
                return isAssignableFrom(a, ((Class<?>) b).getGenericSuperclass(), true);
            }
        } else if (a instanceof GenericArrayType) {
            if (b instanceof GenericArrayType) {
                return isAssignableFrom(getComponentType(a), getComponentType(b), true);
            }
        } else if (a instanceof WildcardType) {
            WildcardType wt = (WildcardType) a;
            for (Type t : wt.getLowerBounds()) {
                if (!isAssignableFrom(b, t, false)) {
                    return false;
                }
            }
            for (Type t : wt.getUpperBounds()) {
                if (!isAssignableFrom(t, b, false)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the type represented by this type literal.
     *
     * @return The type; never null.
     * @see #getComponentType(Type)
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Returns the <i>component type</i> of the type supplied as {@code type} if a
     * parameterised type or generic array type, otherwise {@code type} itself.
     * <p>
     *
     * If there are more than one parameter types, the <b>first</b> one is used, and the
     * additional ones ignored.
     * <p>
     *
     * The component type may be a generic type.
     *
     * @param type
     *            The type to supply the component type, if any; cannot be null.
     * @return The (component) type; never null.
     * @throws NullPointerException
     *             If {@code type} is null.
     * @throws IllegalArgumentException
     *             If {@code type} is a parameterised type with no type parameters (if
     *             more than one, the first one is used). Zero type parameters can occur
     *             if {@code type} type represents a non-parameterised type nested within
     *             a parameterised type.
     */
    public static Type getComponentType(Type type) {
        // Parameterised type...
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) type).getActualTypeArguments();
            if (types.length == 0) {
                throw new IllegalArgumentException("No type parameters: " + type);
            } else if (types.length > 1) {
                // LogFactory.getLog(TypeLiteral.class).println("Using first type
                // parameter of: ",
                // Arrays.asList(types));
            }
            return types[0]; // use first

            // Generic array type - recurse...
        } else if (type instanceof GenericArrayType) {
            return getComponentType(((GenericArrayType) type).getGenericComponentType());

        } else if (type == null) {
            throw new NullPointerException("Type cannot be null");
        }

        return type;
    }

    /**
     * Returns the raw type represented by this type literal, if any.
     * <p>
     *
     * A raw type cannot be returned if this type literal represents a type variable, a
     * wild-card, or a generic array type storing type variables.
     * <p>
     *
     * The raw type may be the same as {@link #getType()}.
     *
     * @return The raw type or null.
     * @see #getRawType(Type)
     */
    public Class<?> getRawType() {
        return getRawType(this.type);
    }

    /**
     * Returns the raw type represented by the type supplied as {@code type}, if any.
     * <p>
     *
     * A raw type cannot be returned if {@code type} is a type variable, a wild card, or a
     * generic array type storing type variables.
     * <p>
     *
     * @param type
     *            The type to use; cannot be null.
     * @return The raw type or null.
     * @throws NullPointerException
     *             If {@code type} is null.
     */
    public static Class<?> getRawType(Type type) {
        // Class...
        if (type instanceof Class<?>) {
            return (Class<?>) type;

            // Parameterised type...
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            return (Class<?>) pt.getRawType(); // class, enum, or interface

            // Generic array type - recurse...
        } else if (type instanceof GenericArrayType) {
            return getRawType(((GenericArrayType) type).getGenericComponentType());

        } else if (type == null) {
            throw new NullPointerException("Type cannot be null");
        }
        // No raw type could be established...
        return null;
    }

    /**
     * Return the hash code of this type literal.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return this.type.hashCode();
    }

    /**
     * Returns true of {@code object} is a type literal representing the same
     * {@link #getType() type} as this type literal, false if not.
     *
     * @param object
     *            The object to test; can be null.
     * @return True if equal, false if not.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypeLiteral<?>)) {
            return false;
        }
        TypeLiteral<?> tl = (TypeLiteral<?>) object;
        return this.type.equals(tl.type);
    }

    /**
     * Returns the string representation of this type literal.
     *
     * @return The string representation; never null.
     */
    @Override
    public String toString() {
        return this.type.toString();
    }

}
