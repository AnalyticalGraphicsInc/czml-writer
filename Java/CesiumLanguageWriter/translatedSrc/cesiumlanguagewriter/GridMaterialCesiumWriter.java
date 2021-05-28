package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.LineCountCesiumWriter;
import cesiumlanguagewriter.LineOffsetCesiumWriter;
import cesiumlanguagewriter.LineThicknessCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code GridMaterial} to a {@link CesiumOutputStream}. A {@code GridMaterial} is a material that fills the surface with a two-dimensional grid.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class GridMaterialCesiumWriter extends CesiumPropertyWriter<GridMaterialCesiumWriter> {
    /**
    * The name of the {@code color} property.
    */
    @Nonnull
    public static final String ColorPropertyName = "color";
    /**
    * The name of the {@code cellAlpha} property.
    */
    @Nonnull
    public static final String CellAlphaPropertyName = "cellAlpha";
    /**
    * The name of the {@code lineCount} property.
    */
    @Nonnull
    public static final String LineCountPropertyName = "lineCount";
    /**
    * The name of the {@code lineThickness} property.
    */
    @Nonnull
    public static final String LineThicknessPropertyName = "lineThickness";
    /**
    * The name of the {@code lineOffset} property.
    */
    @Nonnull
    public static final String LineOffsetPropertyName = "lineOffset";
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
        public ColorCesiumWriter invoke() {
            return new ColorCesiumWriter(ColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_cellAlpha = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
        public DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(CellAlphaPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<LineCountCesiumWriter> m_lineCount = new Lazy<LineCountCesiumWriter>(new Func1<LineCountCesiumWriter>() {
        public LineCountCesiumWriter invoke() {
            return new LineCountCesiumWriter(LineCountPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<LineThicknessCesiumWriter> m_lineThickness = new Lazy<LineThicknessCesiumWriter>(new Func1<LineThicknessCesiumWriter>() {
        public LineThicknessCesiumWriter invoke() {
            return new LineThicknessCesiumWriter(LineThicknessPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<LineOffsetCesiumWriter> m_lineOffset = new Lazy<LineOffsetCesiumWriter>(new Func1<LineOffsetCesiumWriter>() {
        public LineOffsetCesiumWriter invoke() {
            return new LineOffsetCesiumWriter(LineOffsetPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public GridMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected GridMaterialCesiumWriter(@Nonnull GridMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public GridMaterialCesiumWriter clone() {
        return new GridMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code color} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code color} property defines the color of the surface. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getColorWriter() {
        return m_color.getValue();
    }

    /**
    * Opens and returns the writer for the {@code color} property. The {@code color} property defines the color of the surface. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorProperty(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeColorProperty(int red, int green, int blue, int alpha) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgba} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgba(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeColorPropertyRgbaf(@Nonnull Color color) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(color);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(red, green, blue, alpha);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code rgbaf} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeRgbaf(dates, colors, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(Reference value) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeColorPropertyReference(String value) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String propertyName) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code color} property as a {@code reference} value. The {@code color} property specifies the color of the surface. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
        {
            ColorCesiumWriter writer = openColorProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code cellAlpha} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code cellAlpha} property defines the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    */
    @Nonnull
    public final DoubleCesiumWriter getCellAlphaWriter() {
        return m_cellAlpha.getValue();
    }

    /**
    * Opens and returns the writer for the {@code cellAlpha} property. The {@code cellAlpha} property defines the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    */
    @Nonnull
    public final DoubleCesiumWriter openCellAlphaProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getCellAlphaWriter());
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code number} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param value The value.
    */
    public final void writeCellAlphaProperty(double value) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code number} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCellAlphaProperty(List<JulianDate> dates, List<Double> values) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code number} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCellAlphaProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code reference} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param value The reference.
    */
    public final void writeCellAlphaPropertyReference(Reference value) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code reference} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param value The reference.
    */
    public final void writeCellAlphaPropertyReference(String value) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code reference} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeCellAlphaPropertyReference(String identifier, String propertyName) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code cellAlpha} property as a {@code reference} value. The {@code cellAlpha} property specifies the alpha value for the space between grid lines. This will be combined with the color alpha. If not specified, the default value is 0.1.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeCellAlphaPropertyReference(String identifier, String[] propertyNames) {
        {
            DoubleCesiumWriter writer = openCellAlphaProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code lineCount} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code lineCount} property defines the number of grid lines along each axis. If not specified, the default value is [8, 8].
    */
    @Nonnull
    public final LineCountCesiumWriter getLineCountWriter() {
        return m_lineCount.getValue();
    }

    /**
    * Opens and returns the writer for the {@code lineCount} property. The {@code lineCount} property defines the number of grid lines along each axis. If not specified, the default value is [8, 8].
    */
    @Nonnull
    public final LineCountCesiumWriter openLineCountProperty() {
        openIntervalIfNecessary();
        return this.<LineCountCesiumWriter> openAndReturn(getLineCountWriter());
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code cartesian2} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param value The value.
    */
    public final void writeLineCountProperty(@Nonnull Rectangular value) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code cartesian2} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeLineCountProperty(double x, double y) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code cartesian2} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLineCountProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code cartesian2} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLineCountProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code reference} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param value The reference.
    */
    public final void writeLineCountPropertyReference(Reference value) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code reference} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param value The reference.
    */
    public final void writeLineCountPropertyReference(String value) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code reference} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLineCountPropertyReference(String identifier, String propertyName) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineCount} property as a {@code reference} value. The {@code lineCount} property specifies the number of grid lines along each axis. If not specified, the default value is [8, 8].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLineCountPropertyReference(String identifier, String[] propertyNames) {
        {
            LineCountCesiumWriter writer = openLineCountProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code lineThickness} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code lineThickness} property defines the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    */
    @Nonnull
    public final LineThicknessCesiumWriter getLineThicknessWriter() {
        return m_lineThickness.getValue();
    }

    /**
    * Opens and returns the writer for the {@code lineThickness} property. The {@code lineThickness} property defines the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    */
    @Nonnull
    public final LineThicknessCesiumWriter openLineThicknessProperty() {
        openIntervalIfNecessary();
        return this.<LineThicknessCesiumWriter> openAndReturn(getLineThicknessWriter());
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code cartesian2} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param value The value.
    */
    public final void writeLineThicknessProperty(@Nonnull Rectangular value) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code cartesian2} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeLineThicknessProperty(double x, double y) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code cartesian2} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLineThicknessProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code cartesian2} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLineThicknessProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code reference} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param value The reference.
    */
    public final void writeLineThicknessPropertyReference(Reference value) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code reference} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param value The reference.
    */
    public final void writeLineThicknessPropertyReference(String value) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code reference} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLineThicknessPropertyReference(String identifier, String propertyName) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineThickness} property as a {@code reference} value. The {@code lineThickness} property specifies the thickness of grid lines along each axis, in pixels. If not specified, the default value is [1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLineThicknessPropertyReference(String identifier, String[] propertyNames) {
        {
            LineThicknessCesiumWriter writer = openLineThicknessProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Gets the writer for the {@code lineOffset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code lineOffset} property defines the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final LineOffsetCesiumWriter getLineOffsetWriter() {
        return m_lineOffset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code lineOffset} property. The {@code lineOffset} property defines the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    */
    @Nonnull
    public final LineOffsetCesiumWriter openLineOffsetProperty() {
        openIntervalIfNecessary();
        return this.<LineOffsetCesiumWriter> openAndReturn(getLineOffsetWriter());
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code cartesian2} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param value The value.
    */
    public final void writeLineOffsetProperty(@Nonnull Rectangular value) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeCartesian2(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code cartesian2} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeLineOffsetProperty(double x, double y) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeCartesian2(x, y);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code cartesian2} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLineOffsetProperty(List<JulianDate> dates, List<Rectangular> values) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeCartesian2(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code cartesian2} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLineOffsetProperty(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeCartesian2(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code reference} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writeLineOffsetPropertyReference(Reference value) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code reference} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param value The reference.
    */
    public final void writeLineOffsetPropertyReference(String value) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code reference} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLineOffsetPropertyReference(String identifier, String propertyName) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code lineOffset} property as a {@code reference} value. The {@code lineOffset} property specifies the offset of grid lines along each axis, as a percentage from 0 to 1. If not specified, the default value is [0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLineOffsetPropertyReference(String identifier, String[] propertyNames) {
        {
            LineOffsetCesiumWriter writer = openLineOffsetProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}