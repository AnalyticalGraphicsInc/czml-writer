package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BoundingRectangle;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.CartographicExtent;
import cesiumlanguagewriter.CesiumColorBlendMode;
import cesiumlanguagewriter.CesiumCornerType;
import cesiumlanguagewriter.CesiumHeightReference;
import cesiumlanguagewriter.CesiumHorizontalOrigin;
import cesiumlanguagewriter.CesiumLabelStyle;
import cesiumlanguagewriter.CesiumResource;
import cesiumlanguagewriter.CesiumShadowMode;
import cesiumlanguagewriter.CesiumStripeOrientation;
import cesiumlanguagewriter.CesiumVerticalOrigin;
import cesiumlanguagewriter.NearFarScalar;
import cesiumlanguagewriter.Rectangular;
import cesiumlanguagewriter.Spherical;
import cesiumlanguagewriter.UnitCartesian;
import cesiumlanguagewriter.UnitQuaternion;
import cesiumlanguagewriter.UnitSpherical;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code CustomProperty} to a {@link CesiumOutputStream}.  A {@code CustomProperty} is a custom property.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CustomPropertyCesiumWriter extends CesiumInterpolatablePropertyWriter<CustomPropertyCesiumWriter> {
    /**
    *  
    The name of the {@code boolean} property.
    

    */
    public static final String BooleanPropertyName = "boolean";
    /**
    *  
    The name of the {@code boundingRectangle} property.
    

    */
    public static final String BoundingRectanglePropertyName = "boundingRectangle";
    /**
    *  
    The name of the {@code cartesian} property.
    

    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    *  
    The name of the {@code cartographicRadians} property.
    

    */
    public static final String CartographicRadiansPropertyName = "cartographicRadians";
    /**
    *  
    The name of the {@code cartographicDegrees} property.
    

    */
    public static final String CartographicDegreesPropertyName = "cartographicDegrees";
    /**
    *  
    The name of the {@code cartesian2} property.
    

    */
    public static final String Cartesian2PropertyName = "cartesian2";
    /**
    *  
    The name of the {@code unitCartesian} property.
    

    */
    public static final String UnitCartesianPropertyName = "unitCartesian";
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
    The name of the {@code rgba} property.
    

    */
    public static final String RgbaPropertyName = "rgba";
    /**
    *  
    The name of the {@code rgbaf} property.
    

    */
    public static final String RgbafPropertyName = "rgbaf";
    /**
    *  
    The name of the {@code colorBlendMode} property.
    

    */
    public static final String ColorBlendModePropertyName = "colorBlendMode";
    /**
    *  
    The name of the {@code cornerType} property.
    

    */
    public static final String CornerTypePropertyName = "cornerType";
    /**
    *  
    The name of the {@code heightReference} property.
    

    */
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    *  
    The name of the {@code horizontalOrigin} property.
    

    */
    public static final String HorizontalOriginPropertyName = "horizontalOrigin";
    /**
    *  
    The name of the {@code labelStyle} property.
    

    */
    public static final String LabelStylePropertyName = "labelStyle";
    /**
    *  
    The name of the {@code number} property.
    

    */
    public static final String NumberPropertyName = "number";
    /**
    *  
    The name of the {@code nearFarScalar} property.
    

    */
    public static final String NearFarScalarPropertyName = "nearFarScalar";
    /**
    *  
    The name of the {@code unitQuaternion} property.
    

    */
    public static final String UnitQuaternionPropertyName = "unitQuaternion";
    /**
    *  
    The name of the {@code shadowMode} property.
    

    */
    public static final String ShadowModePropertyName = "shadowMode";
    /**
    *  
    The name of the {@code string} property.
    

    */
    public static final String StringPropertyName = "string";
    /**
    *  
    The name of the {@code stripeOrientation} property.
    

    */
    public static final String StripeOrientationPropertyName = "stripeOrientation";
    /**
    *  
    The name of the {@code wsen} property.
    

    */
    public static final String WsenPropertyName = "wsen";
    /**
    *  
    The name of the {@code wsenDegrees} property.
    

    */
    public static final String WsenDegreesPropertyName = "wsenDegrees";
    /**
    *  
    The name of the {@code uri} property.
    

    */
    public static final String UriPropertyName = "uri";
    /**
    *  
    The name of the {@code verticalOrigin} property.
    

    */
    public static final String VerticalOriginPropertyName = "verticalOrigin";
    private Lazy<ICesiumValuePropertyWriter<Boolean>> m_asBoolean;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asBoundingRectangle;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgba;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgbaf;
    private Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>> m_asColorBlendMode;
    private Lazy<ICesiumValuePropertyWriter<CesiumCornerType>> m_asCornerType;
    private Lazy<ICesiumValuePropertyWriter<CesiumHeightReference>> m_asHeightReference;
    private Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
    private Lazy<ICesiumValuePropertyWriter<CesiumLabelStyle>> m_asLabelStyle;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Double>> m_asNumber;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<NearFarScalar>> m_asNearFarScalar;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
    private Lazy<ICesiumValuePropertyWriter<CesiumShadowMode>> m_asShadowMode;
    private Lazy<ICesiumValuePropertyWriter<String>> m_asString;
    private Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsen;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsenDegrees;
    private Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asUri;
    private Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;

    /**
    *  
    Initializes a new instance.
    

    */
    public CustomPropertyCesiumWriter(String propertyName) {
        super(propertyName);
        m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
                "createBooleanAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
                return createBooleanAdaptor();
            }
        }, false);
        m_asBoundingRectangle = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createBoundingRectangleAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
                        return createBoundingRectangleAdaptor();
                    }
                }, false);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
                        return createCartesian2Adaptor();
                    }
                }, false);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
        m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
                        return createSphericalAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asRgba = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
                this, "createRgbaAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
                return createRgbaAdaptor();
            }
        }, false);
        m_asRgbaf = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
                this, "createRgbafAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
                return createRgbafAdaptor();
            }
        }, false);
        m_asColorBlendMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(this, "createColorBlendModeAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode> invoke() {
                        return createColorBlendModeAdaptor();
                    }
                }, false);
        m_asCornerType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(
                this, "createCornerTypeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType> invoke() {
                return createCornerTypeAdaptor();
            }
        }, false);
        m_asHeightReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(this, "createHeightReferenceAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference> invoke() {
                        return createHeightReferenceAdaptor();
                    }
                }, false);
        m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
                        return createHorizontalOriginAdaptor();
                    }
                }, false);
        m_asLabelStyle = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(
                this, "createLabelStyleAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle> invoke() {
                return createLabelStyleAdaptor();
            }
        }, false);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
                        return createNumberAdaptor();
                    }
                }, false);
        m_asNearFarScalar = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(this, "createNearFarScalarAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar> invoke() {
                        return createNearFarScalarAdaptor();
                    }
                }, false);
        m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
                        return createUnitQuaternionAdaptor();
                    }
                }, false);
        m_asShadowMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(
                this, "createShadowModeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode> invoke() {
                return createShadowModeAdaptor();
            }
        }, false);
        m_asString = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createStringAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
                        return createStringAdaptor();
                    }
                }, false);
        m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
                        return createStripeOrientationAdaptor();
                    }
                }, false);
        m_asWsen = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
                        return createWsenAdaptor();
                    }
                }, false);
        m_asWsenDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
                        return createWsenDegreesAdaptor();
                    }
                }, false);
        m_asUri = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
                "createUriAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
                return createUriAdaptor();
            }
        }, false);
        m_asVerticalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(this, "createVerticalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin> invoke() {
                        return createVerticalOriginAdaptor();
                    }
                }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CustomPropertyCesiumWriter(CustomPropertyCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
                "createBooleanAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
                return createBooleanAdaptor();
            }
        }, false);
        m_asBoundingRectangle = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createBoundingRectangleAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
                        return createBoundingRectangleAdaptor();
                    }
                }, false);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
                        return createCartesian2Adaptor();
                    }
                }, false);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
        m_asSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical>>(this, "createSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Spherical> invoke() {
                        return createSphericalAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asRgba = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
                this, "createRgbaAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
                return createRgbaAdaptor();
            }
        }, false);
        m_asRgbaf = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color>>(
                this, "createRgbafAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Color> invoke() {
                return createRgbafAdaptor();
            }
        }, false);
        m_asColorBlendMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(this, "createColorBlendModeAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode> invoke() {
                        return createColorBlendModeAdaptor();
                    }
                }, false);
        m_asCornerType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(
                this, "createCornerTypeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType> invoke() {
                return createCornerTypeAdaptor();
            }
        }, false);
        m_asHeightReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(this, "createHeightReferenceAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference> invoke() {
                        return createHeightReferenceAdaptor();
                    }
                }, false);
        m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
                        return createHorizontalOriginAdaptor();
                    }
                }, false);
        m_asLabelStyle = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(
                this, "createLabelStyleAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle> invoke() {
                return createLabelStyleAdaptor();
            }
        }, false);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
                        return createNumberAdaptor();
                    }
                }, false);
        m_asNearFarScalar = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(this, "createNearFarScalarAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar> invoke() {
                        return createNearFarScalarAdaptor();
                    }
                }, false);
        m_asUnitQuaternion = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(this, "createUnitQuaternionAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> invoke() {
                        return createUnitQuaternionAdaptor();
                    }
                }, false);
        m_asShadowMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(
                this, "createShadowModeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode> invoke() {
                return createShadowModeAdaptor();
            }
        }, false);
        m_asString = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createStringAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
                        return createStringAdaptor();
                    }
                }, false);
        m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
                        return createStripeOrientationAdaptor();
                    }
                }, false);
        m_asWsen = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
                        return createWsenAdaptor();
                    }
                }, false);
        m_asWsenDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(this, "createWsenDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<CartographicExtent> invoke() {
                        return createWsenDegreesAdaptor();
                    }
                }, false);
        m_asUri = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource>>(this,
                "createUriAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumResource> invoke() {
                return createUriAdaptor();
            }
        }, false);
        m_asVerticalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(this, "createVerticalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin> invoke() {
                        return createVerticalOriginAdaptor();
                    }
                }, false);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public CustomPropertyCesiumWriter clone() {
        return new CustomPropertyCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code boolean}, which is the property specified as a boolean value.
    
    

    * @param value The value.
    */
    public final void writeBoolean(boolean value) {
        final String PropertyName = BooleanPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    
    

    * @param value The value.
    */
    public final void writeBoundingRectangle(@Nonnull BoundingRectangle value) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values) {
        writeBoundingRectangle(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    
    

    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians.
    
    

    * @param value The interval.
    */
    public final void writeCartographicRadians(@Nonnull Cartographic value) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicRadians(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees.
    
    

    * @param value The interval.
    */
    public final void writeCartographicDegrees(@Nonnull Cartographic value) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicDegrees(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    
    

    * @param value The value.
    */
    public final void writeCartesian2(@Nonnull Rectangular value) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian2(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeCartesian2(double x, double y) {
        writeCartesian2(new Rectangular(x, y));
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
        writeCartesian2(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    
    

    * @param value The value.
    */
    public final void writeUnitCartesian(@Nonnull UnitCartesian value) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        writeUnitCartesian(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param value The value.
    */
    public final void writeSpherical(@Nonnull Spherical value) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeSpherical(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values) {
        writeSpherical(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param value The value.
    */
    public final void writeUnitSpherical(@Nonnull UnitSpherical value) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        writeUnitSpherical(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    
    

    * @param color The color.
    */
    public final void writeRgba(@Nonnull Color color) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), color);
    }

    /**
    *  
    Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    
    
    
    
    

    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeRgba(int red, int green, int blue, int alpha) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), red, green, blue, alpha);
    }

    /**
    *  
    Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> values) {
        writeRgba(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgba(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    
    

    * @param color The color.
    */
    public final void writeRgbaf(@Nonnull Color color) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), color);
    }

    /**
    *  
    Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    
    
    
    
    

    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeRgbaf(float red, float green, float blue, float alpha) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), red, green, blue, alpha);
    }

    /**
    *  
    Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> values) {
        writeRgbaf(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgbaf(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code colorBlendMode}, which is the property specified as a color blend mode.
    
    

    * @param value The blend mode.
    */
    public final void writeColorBlendMode(@Nonnull CesiumColorBlendMode value) {
        final String PropertyName = ColorBlendModePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.colorBlendModeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code cornerType}, which is the property specified as a corner style.
    
    

    * @param value The style of a corner.
    */
    public final void writeCornerType(@Nonnull CesiumCornerType value) {
        final String PropertyName = CornerTypePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.cornerTypeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code heightReference}, which is the property specified as a height reference.
    
    

    * @param value The height reference.
    */
    public final void writeHeightReference(@Nonnull CesiumHeightReference value) {
        final String PropertyName = HeightReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.heightReferenceToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code horizontalOrigin}, which is the property specified as a horizontal origin.
    
    

    * @param value The horizontal origin.
    */
    public final void writeHorizontalOrigin(@Nonnull CesiumHorizontalOrigin value) {
        final String PropertyName = HorizontalOriginPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.horizontalOriginToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code labelStyle}, which is the property specified as a label style.
    
    

    * @param value The label style.
    */
    public final void writeLabelStyle(@Nonnull CesiumLabelStyle value) {
        final String PropertyName = LabelStylePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.labelStyleToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the property specified as a number.
    
    

    * @param value The value.
    */
    public final void writeNumber(double value) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the property specified as a number.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values) {
        writeNumber(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the property specified as a number.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeDouble(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    

    * @param value The value.
    */
    public final void writeNearFarScalar(@Nonnull NearFarScalar value) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeNearFarScalar(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
        writeNearFarScalar(new NearFarScalar(nearDistance, nearValue, farDistance, farValue));
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values) {
        writeNearFarScalar(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeNearFarScalar(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    

    * @param value The value.
    */
    public final void writeUnitQuaternion(@Nonnull UnitQuaternion value) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values) {
        writeUnitQuaternion(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code shadowMode}, which is the property specified as a shadow mode.
    
    

    * @param value The shadow mode.
    */
    public final void writeShadowMode(@Nonnull CesiumShadowMode value) {
        final String PropertyName = ShadowModePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.shadowModeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code string}, which is the property specified as a string.
    
    

    * @param value The value.
    */
    public final void writeString(String value) {
        final String PropertyName = StringPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code stripeOrientation}, which is the property specified as an orientation of stripes in the stripe material.
    
    

    * @param value The orientation.
    */
    public final void writeStripeOrientation(@Nonnull CesiumStripeOrientation value) {
        final String PropertyName = StripeOrientationPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.stripeOrientationToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    
    

    * @param value The value.
    */
    public final void writeWsen(CartographicExtent value) {
        final String PropertyName = WsenPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    
    
    
    
    

    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsen(double west, double south, double east, double north) {
        writeWsen(new CartographicExtent(west, south, east, north));
    }

    /**
    *  
    Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsen(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsen(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWsen(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        final String PropertyName = WsenPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographicExtent(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    
    

    * @param value The value.
    */
    public final void writeWsenDegrees(CartographicExtent value) {
        final String PropertyName = WsenDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    
    
    
    
    

    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsenDegrees(double west, double south, double east, double north) {
        writeWsenDegrees(new CartographicExtent(west, south, east, north));
    }

    /**
    *  
    Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsenDegrees(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        final String PropertyName = WsenDegreesPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographicExtent(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    

    * @param resource A resource object describing external data.
    */
    public final void writeUri(CesiumResource resource) {
        writeUri(resource.getUri(), resource.getBehavior());
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        writeUri(uri.toString(), resourceBehavior);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.getResourceUri(uri, resourceBehavior));
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    
    

    * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(URI uri, ICesiumUriResolver resolver) {
        writeUri(uri.toString(), resolver);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    
    

    * @param uri The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(String uri, ICesiumUriResolver resolver) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(resolver.resolveUri(uri));
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    

    * @param image The image.  A data URI will be created for this image, using PNG encoding.
    */
    public final void writeUri(RenderedImage image) {
        writeUri(image, CesiumImageFormat.PNG);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    
    
    

    * @param image The image.  A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeUri(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.imageToDataUri(image, imageFormat));
    }

    /**
    *  
    Writes the value expressed as a {@code verticalOrigin}, which is the property specified as a vertical origin.
    
    

    * @param value The vertical origin.
    */
    public final void writeVerticalOrigin(@Nonnull CesiumVerticalOrigin value) {
        final String PropertyName = VerticalOriginPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.verticalOriginToString(value));
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Boolean} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Boolean> asBoolean() {
        return m_asBoolean.getValue();
    }

    private final ICesiumValuePropertyWriter<Boolean> createBooleanAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, Boolean>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Boolean>() {
                    public void invoke(CustomPropertyCesiumWriter me, Boolean value) {
                        me.writeBoolean(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code BoundingRectangle} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> asBoundingRectangle() {
        return m_asBoundingRectangle.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> createBoundingRectangleAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.BoundingRectangle>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
                    public void invoke(CustomPropertyCesiumWriter me, BoundingRectangle value) {
                        me.writeBoundingRectangle(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
                        me.writeBoundingRectangle(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Cartesian} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartesian> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartesian> createCartesianAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartesian>() {
                    public void invoke(CustomPropertyCesiumWriter me, Cartesian value) {
                        me.writeCartesian(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartesian>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
                        me.writeCartesian(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code CartographicRadians} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicRadiansAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(CustomPropertyCesiumWriter me, Cartographic value) {
                        me.writeCartographicRadians(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
                        me.writeCartographicRadians(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code CartographicDegrees} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicDegreesAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(CustomPropertyCesiumWriter me, Cartographic value) {
                        me.writeCartographicDegrees(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
                        me.writeCartographicDegrees(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Cartesian2} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Rectangular> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Rectangular> createCartesian2Adaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Rectangular>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Rectangular>() {
                    public void invoke(CustomPropertyCesiumWriter me, Rectangular value) {
                        me.writeCartesian2(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Rectangular>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
                        me.writeCartesian2(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code UnitCartesian} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<UnitCartesian> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<UnitCartesian> createUnitCartesianAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitCartesian>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
                    public void invoke(CustomPropertyCesiumWriter me, UnitCartesian value) {
                        me.writeUnitCartesian(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
                        me.writeUnitCartesian(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Spherical} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Spherical> asSpherical() {
        return m_asSpherical.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Spherical> createSphericalAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Spherical>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Spherical>() {
                    public void invoke(CustomPropertyCesiumWriter me, Spherical value) {
                        me.writeSpherical(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.Spherical>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
                        me.writeSpherical(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code UnitSpherical} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<UnitSpherical> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<UnitSpherical> createUnitSphericalAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitSpherical>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
                    public void invoke(CustomPropertyCesiumWriter me, UnitSpherical value) {
                        me.writeUnitSpherical(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
                        me.writeUnitSpherical(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Rgba} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Color> asRgba() {
        return m_asRgba.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Color> createRgbaAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>() {
                    public void invoke(CustomPropertyCesiumWriter me, Color value) {
                        me.writeRgba(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
                        me.writeRgba(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Rgbaf} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Color> asRgbaf() {
        return m_asRgbaf.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Color> createRgbafAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>() {
                    public void invoke(CustomPropertyCesiumWriter me, Color value) {
                        me.writeRgbaf(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Color>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
                        me.writeRgbaf(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code ColorBlendMode} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumColorBlendMode> asColorBlendMode() {
        return m_asColorBlendMode.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumColorBlendMode> createColorBlendModeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumColorBlendMode>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumColorBlendMode>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumColorBlendMode value) {
                        me.writeColorBlendMode(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code CornerType} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumCornerType> asCornerType() {
        return m_asCornerType.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumCornerType> createCornerTypeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumCornerType>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumCornerType>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumCornerType value) {
                        me.writeCornerType(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code HeightReference} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumHeightReference> asHeightReference() {
        return m_asHeightReference.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumHeightReference> createHeightReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumHeightReference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumHeightReference>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumHeightReference value) {
                        me.writeHeightReference(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code HorizontalOrigin} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> asHorizontalOrigin() {
        return m_asHorizontalOrigin.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> createHorizontalOriginAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumHorizontalOrigin value) {
                        me.writeHorizontalOrigin(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code LabelStyle} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumLabelStyle> asLabelStyle() {
        return m_asLabelStyle.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumLabelStyle> createLabelStyleAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumLabelStyle>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumLabelStyle>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumLabelStyle value) {
                        me.writeLabelStyle(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Number} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Double> asNumber() {
        return m_asNumber.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Double> createNumberAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, Double>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Double>() {
                    public void invoke(CustomPropertyCesiumWriter me, Double value) {
                        me.writeNumber(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, Double>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<Double> values, int startIndex, int length) {
                        me.writeNumber(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code NearFarScalar} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<NearFarScalar> asNearFarScalar() {
        return m_asNearFarScalar.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<NearFarScalar> createNearFarScalarAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.NearFarScalar>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.NearFarScalar>() {
                    public void invoke(CustomPropertyCesiumWriter me, NearFarScalar value) {
                        me.writeNearFarScalar(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.NearFarScalar>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
                        me.writeNearFarScalar(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code UnitQuaternion} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> asUnitQuaternion() {
        return m_asUnitQuaternion.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> createUnitQuaternionAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitQuaternion>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
                    public void invoke(CustomPropertyCesiumWriter me, UnitQuaternion value) {
                        me.writeUnitQuaternion(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.UnitQuaternion>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
                        me.writeUnitQuaternion(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code ShadowMode} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumShadowMode> asShadowMode() {
        return m_asShadowMode.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumShadowMode> createShadowModeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumShadowMode>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumShadowMode>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumShadowMode value) {
                        me.writeShadowMode(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code String} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<String> asString() {
        return m_asString.getValue();
    }

    private final ICesiumValuePropertyWriter<String> createStringAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, String>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, String>() {
            public void invoke(CustomPropertyCesiumWriter me, String value) {
                me.writeString(value);
            }
        });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code StripeOrientation} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumStripeOrientation> asStripeOrientation() {
        return m_asStripeOrientation.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumStripeOrientation> createStripeOrientationAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumStripeOrientation value) {
                        me.writeStripeOrientation(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Wsen} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<CartographicExtent> asWsen() {
        return m_asWsen.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<CartographicExtent> createWsenAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
                    public void invoke(CustomPropertyCesiumWriter me, CartographicExtent value) {
                        me.writeWsen(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
                        me.writeWsen(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code WsenDegrees} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<CartographicExtent> asWsenDegrees() {
        return m_asWsenDegrees.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<CartographicExtent> createWsenDegreesAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
                    public void invoke(CustomPropertyCesiumWriter me, CartographicExtent value) {
                        me.writeWsenDegrees(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CartographicExtent>() {
                    public void invoke(CustomPropertyCesiumWriter me, List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
                        me.writeWsenDegrees(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Uri} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumResource> asUri() {
        return m_asUri.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumResource> createUriAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumResource>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumResource>() {
                    public void invoke(CustomPropertyCesiumWriter me, CesiumResource value) {
                        me.writeUri(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code VerticalOrigin} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumVerticalOrigin> asVerticalOrigin() {
        return m_asVerticalOrigin.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumVerticalOrigin> createVerticalOriginAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CustomPropertyCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>() {
                    public void invoke(CustomPropertyCesiumWriter me, @Nonnull CesiumVerticalOrigin value) {
                        me.writeVerticalOrigin(value);
                    }
                });
    }
}