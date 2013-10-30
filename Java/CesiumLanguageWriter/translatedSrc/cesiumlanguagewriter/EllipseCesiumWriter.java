package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>Ellipse</code> to a  {@link CesiumOutputStream}.  A <code>Ellipse</code> defines an ellipse, which is a closed curve on the surface of the Earth
 

 */
public class EllipseCesiumWriter extends CesiumPropertyWriter<EllipseCesiumWriter> {
	/**
	 *  
	The name of the <code>semiMajorAxis</code> property.
	

	 */
	public static final String SemiMajorAxisPropertyName = "semiMajorAxis";
	/**
	 *  
	The name of the <code>semiMinorAxis</code> property.
	

	 */
	public static final String SemiMinorAxisPropertyName = "semiMinorAxis";
	/**
	 *  
	The name of the <code>rotation</code> property.
	

	 */
	public static final String RotationPropertyName = "rotation";
	private Lazy<DoubleCesiumWriter> m_semiMajorAxis = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(SemiMajorAxisPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_semiMinorAxis = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(SemiMinorAxisPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_rotation = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RotationPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public EllipseCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected EllipseCesiumWriter(EllipseCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public EllipseCesiumWriter clone() {
		return new EllipseCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>semiMajorAxis</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>semiMajorAxis</code> property defines the length of the ellipse's semi-major axis in meters.
	

	 */
	public final DoubleCesiumWriter getSemiMajorAxisWriter() {
		return m_semiMajorAxis.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>semiMajorAxis</code> property.  The <code>semiMajorAxis</code> property defines the length of the ellipse's semi-major axis in meters.
	

	 */
	public final DoubleCesiumWriter openSemiMajorAxisProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getSemiMajorAxisWriter());
	}

	/**
	 *  
	Writes a value for the <code>semiMajorAxis</code> property as a <code>number</code> value.  The <code>semiMajorAxis</code> property specifies the length of the ellipse's semi-major axis in meters.
	
	

	 * @param value The value.
	 */
	public final void writeSemiMajorAxisProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSemiMajorAxisProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>semiMajorAxis</code> property as a <code>number</code> value.  The <code>semiMajorAxis</code> property specifies the length of the ellipse's semi-major axis in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeSemiMajorAxisProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSemiMajorAxisProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>semiMinorAxis</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>semiMinorAxis</code> property defines the length of the ellipse's semi-minor axis in meters.
	

	 */
	public final DoubleCesiumWriter getSemiMinorAxisWriter() {
		return m_semiMinorAxis.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>semiMinorAxis</code> property.  The <code>semiMinorAxis</code> property defines the length of the ellipse's semi-minor axis in meters.
	

	 */
	public final DoubleCesiumWriter openSemiMinorAxisProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getSemiMinorAxisWriter());
	}

	/**
	 *  
	Writes a value for the <code>semiMinorAxis</code> property as a <code>number</code> value.  The <code>semiMinorAxis</code> property specifies the length of the ellipse's semi-minor axis in meters.
	
	

	 * @param value The value.
	 */
	public final void writeSemiMinorAxisProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSemiMinorAxisProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>semiMinorAxis</code> property as a <code>number</code> value.  The <code>semiMinorAxis</code> property specifies the length of the ellipse's semi-minor axis in meters.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeSemiMinorAxisProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSemiMinorAxisProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>rotation</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>rotation</code> property defines the angle from north (clockwise) in radians.
	

	 */
	public final DoubleCesiumWriter getRotationWriter() {
		return m_rotation.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>rotation</code> property.  The <code>rotation</code> property defines the angle from north (clockwise) in radians.
	

	 */
	public final DoubleCesiumWriter openRotationProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRotationWriter());
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the angle from north (clockwise) in radians.
	
	

	 * @param value The value.
	 */
	public final void writeRotationProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the angle from north (clockwise) in radians.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRotationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRotationProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}