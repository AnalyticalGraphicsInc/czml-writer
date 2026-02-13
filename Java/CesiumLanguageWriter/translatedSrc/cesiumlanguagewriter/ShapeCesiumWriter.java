package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Shape} to a {@link CesiumOutputStream}. A {@code Shape} is a list of two-dimensional positions defining a shape.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ShapeCesiumWriter extends CesiumPropertyWriter<ShapeCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian2ListValuePropertyWriter {
    /**
    * The name of the {@code cartesian2} property.
    */
    @Nonnull
    public static final String Cartesian2PropertyName = "cartesian2";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter>> m_asCartesian2;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ShapeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian2 = createAsCartesian2();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ShapeCesiumWriter(@Nonnull ShapeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian2 = createAsCartesian2();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ShapeCesiumWriter clone() {
        return new ShapeCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the list of positions specified as two-dimensional Cartesian values {@code [X, Y, X, Y, ...]}.
    * @param values The values.
    */
    public final void writeCartesian2(Iterable<Rectangular> values) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian2List(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian2ListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter>> createAsCartesian2() {
        return new Lazy<CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter>>(
                Func1.<CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter>> of(this::createCartesian2List, this, "createCartesian2List"), false);
    }

    @Nonnull
    private final CesiumCartesian2ListValuePropertyAdaptor<ShapeCesiumWriter> createCartesian2List() {
        return CesiumValuePropertyAdaptors.<ShapeCesiumWriter> createCartesian2List(this);
    }
}