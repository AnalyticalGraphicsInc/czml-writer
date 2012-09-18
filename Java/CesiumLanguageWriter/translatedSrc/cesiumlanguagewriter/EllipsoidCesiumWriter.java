package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>Ellipsoid</code> to a  {@link CesiumOutputStream}.  A <code>Ellipsoid</code> an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.
 

 */
public class EllipsoidCesiumWriter extends CesiumPropertyWriter<EllipsoidCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>radii</code> property.
	

	 */
	public static final String RadiiPropertyName = "radii";
	/**
	 *  
	The name of the <code>material</code> property.
	

	 */
	public static final String MaterialPropertyName = "material";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asRadii;
	private Lazy<MaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
		public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
			return new MaterialCesiumWriter(MaterialPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public EllipsoidCesiumWriter(String propertyName) {
		super(propertyName);
		m_asRadii = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createRadiiAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createRadiiAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected EllipsoidCesiumWriter(EllipsoidCesiumWriter existingInstance) {
		super(existingInstance);
		m_asRadii = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createRadiiAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createRadiiAdaptor();
					}
				}, false);
	}

	@Override
	public EllipsoidCesiumWriter clone() {
		return new EllipsoidCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the ellipsoid is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the ellipsoid is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the ellipsoid is shown.
	
	

	 * @param value The value.
	 */
	public final void writeShowProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	

	 * @param value The value.
	 */
	public final void writeRadii(Cartesian value) {
		String PropertyName = RadiiPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeRadii(List<JulianDate> dates, List<Cartesian> values) {
		writeRadii(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRadii(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		String PropertyName = RadiiPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
	

	 */
	public final MaterialCesiumWriter getMaterialWriter() {
		return m_material.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
	

	 */
	public final MaterialCesiumWriter openMaterialProperty() {
		openIntervalIfNecessary();
		return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Radii</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Cartesian> asRadii() {
		return m_asRadii.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Cartesian> createRadiiAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.EllipsoidCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.EllipsoidCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(EllipsoidCesiumWriter me, Cartesian value) {
						me.writeRadii(value);
					}
				}, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.EllipsoidCesiumWriter, cesiumlanguagewriter.Cartesian>() {
					public void invoke(EllipsoidCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
						me.writeRadii(dates, values, startIndex, length);
					}
				});
	}
}