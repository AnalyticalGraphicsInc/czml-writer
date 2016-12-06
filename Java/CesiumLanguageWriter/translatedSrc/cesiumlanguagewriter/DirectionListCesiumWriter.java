package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a {@code DirectionList} to a  {@link CesiumOutputStream}.  A {@code DirectionList} is a list of directions.
 

 */
public class DirectionListCesiumWriter extends CesiumPropertyWriter<DirectionListCesiumWriter> {
    /**
    *  
    The name of the {@code spherical} property.
    

    */
    public static final String SphericalPropertyName = "spherical";
    /**
    *  
    The name of the {@code unitSpherical} property.
    

    */
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    *  
    The name of the {@code cartesian} property.
    

    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    *  
    The name of the {@code unitCartesian} property.
    

    */
    public static final String UnitCartesianPropertyName = "unitCartesian";
    private Lazy<ICesiumValuePropertyWriter<Iterable<Spherical>>> m_asSpherical;
    private Lazy<ICesiumValuePropertyWriter<Iterable<UnitSpherical>>> m_asUnitSpherical;
    private Lazy<ICesiumValuePropertyWriter<Iterable<Cartesian>>> m_asCartesian;
    private Lazy<ICesiumValuePropertyWriter<Iterable<UnitCartesian>>> m_asUnitCartesian;

    /**
    *  
    Initializes a new instance.
    

    */
    public DirectionListCesiumWriter(String propertyName) {
        super(propertyName);
        m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(this, "createSphericalAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>> invoke() {
                        return createSphericalAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(this, "createCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected DirectionListCesiumWriter(DirectionListCesiumWriter existingInstance) {
        super(existingInstance);
        m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>>>(this, "createSphericalAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Spherical>> invoke() {
                        return createSphericalAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>>>(this, "createUnitSphericalAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitSpherical>> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(this, "createCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>>>(this, "createUnitCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<UnitCartesian>> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
    }

    @Override
    public DirectionListCesiumWriter clone() {
        return new DirectionListCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code spherical}, which is the list of directions specified as spherical values {@code [Clock, Cone, Magnitude, Clock, Cone, Magnitude, ...]}, with angles in radians and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param values The values.
    */
    public final void writeSpherical(Iterable<Spherical> values) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeSphericalList(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the list of directions specified as unit spherical values {@code [Clock, Cone, Clock, Cone, ...]}, in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param values The values.
    */
    public final void writeUnitSpherical(Iterable<UnitSpherical> values) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSphericalList(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the list of directions specified as three-dimensional Cartesian values {@code [X, Y, Z, X, Y, Z, ...]}, in world coordinates in meters.
    
    

    * @param values The values.
    */
    public final void writeCartesian(Iterable<Cartesian> values) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3List(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the list of directions specified as three-dimensional unit magnitude Cartesian values, {@code [X, Y, Z, X, Y, Z, ...]}, in world coordinates in meters.
    
    

    * @param values The values.
    */
    public final void writeUnitCartesian(Iterable<UnitCartesian> values) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3List(getOutput(), values);
    }

    /**
    *  
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code Spherical} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Spherical>> asSpherical() {
        return m_asSpherical.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Spherical>> createSphericalAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Spherical>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Spherical>>() {
                    public void invoke(DirectionListCesiumWriter me, Iterable<Spherical> value) {
                        me.writeSpherical(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code UnitSpherical} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<UnitSpherical>> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<UnitSpherical>> createUnitSphericalAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitSpherical>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitSpherical>>() {
                    public void invoke(DirectionListCesiumWriter me, Iterable<UnitSpherical> value) {
                        me.writeUnitSpherical(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code Cartesian} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Cartesian>> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Cartesian>> createCartesianAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Cartesian>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<Cartesian>>() {
                    public void invoke(DirectionListCesiumWriter me, Iterable<Cartesian> value) {
                        me.writeCartesian(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code UnitCartesian} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<UnitCartesian>> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<UnitCartesian>> createUnitCartesianAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitCartesian>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DirectionListCesiumWriter, Iterable<UnitCartesian>>() {
                    public void invoke(DirectionListCesiumWriter me, Iterable<UnitCartesian> value) {
                        me.writeUnitCartesian(value);
                    }
                });
    }
}