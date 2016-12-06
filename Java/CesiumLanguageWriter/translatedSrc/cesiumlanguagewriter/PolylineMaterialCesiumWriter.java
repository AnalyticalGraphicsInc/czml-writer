package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.GridMaterialCesiumWriter;
import cesiumlanguagewriter.ImageMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineArrowMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter;
import cesiumlanguagewriter.SolidColorMaterialCesiumWriter;
import cesiumlanguagewriter.StripeMaterialCesiumWriter;

/**
 *  
 Writes a {@code PolylineMaterial} to a  {@link CesiumOutputStream}.  A {@code PolylineMaterial} is a definition of how a polyline is colored or shaded.
 

 */
public class PolylineMaterialCesiumWriter extends CesiumPropertyWriter<PolylineMaterialCesiumWriter> {
    /**
    *  
    The name of the {@code solidColor} property.
    

    */
    public static final String SolidColorPropertyName = "solidColor";
    /**
    *  
    The name of the {@code polylineOutline} property.
    

    */
    public static final String PolylineOutlinePropertyName = "polylineOutline";
    /**
    *  
    The name of the {@code polylineArrow} property.
    

    */
    public static final String PolylineArrowPropertyName = "polylineArrow";
    /**
    *  
    The name of the {@code polylineGlow} property.
    

    */
    public static final String PolylineGlowPropertyName = "polylineGlow";
    /**
    *  
    The name of the {@code image} property.
    

    */
    public static final String ImagePropertyName = "image";
    /**
    *  
    The name of the {@code grid} property.
    

    */
    public static final String GridPropertyName = "grid";
    /**
    *  
    The name of the {@code stripe} property.
    

    */
    public static final String StripePropertyName = "stripe";
    private Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>() {
        public cesiumlanguagewriter.SolidColorMaterialCesiumWriter invoke() {
            return new SolidColorMaterialCesiumWriter(SolidColorPropertyName);
        }
    }, false);
    private Lazy<PolylineOutlineMaterialCesiumWriter> m_polylineOutline = new Lazy<cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter>(
            new Func1<cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter>() {
                public cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter invoke() {
                    return new PolylineOutlineMaterialCesiumWriter(PolylineOutlinePropertyName);
                }
            }, false);
    private Lazy<PolylineArrowMaterialCesiumWriter> m_polylineArrow = new Lazy<cesiumlanguagewriter.PolylineArrowMaterialCesiumWriter>(
            new Func1<cesiumlanguagewriter.PolylineArrowMaterialCesiumWriter>() {
                public cesiumlanguagewriter.PolylineArrowMaterialCesiumWriter invoke() {
                    return new PolylineArrowMaterialCesiumWriter(PolylineArrowPropertyName);
                }
            }, false);
    private Lazy<PolylineGlowMaterialCesiumWriter> m_polylineGlow = new Lazy<cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter>() {
        public cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter invoke() {
            return new PolylineGlowMaterialCesiumWriter(PolylineGlowPropertyName);
        }
    }, false);
    private Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.ImageMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.ImageMaterialCesiumWriter>() {
        public cesiumlanguagewriter.ImageMaterialCesiumWriter invoke() {
            return new ImageMaterialCesiumWriter(ImagePropertyName);
        }
    }, false);
    private Lazy<GridMaterialCesiumWriter> m_grid = new Lazy<cesiumlanguagewriter.GridMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.GridMaterialCesiumWriter>() {
        public cesiumlanguagewriter.GridMaterialCesiumWriter invoke() {
            return new GridMaterialCesiumWriter(GridPropertyName);
        }
    }, false);
    private Lazy<StripeMaterialCesiumWriter> m_stripe = new Lazy<cesiumlanguagewriter.StripeMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.StripeMaterialCesiumWriter>() {
        public cesiumlanguagewriter.StripeMaterialCesiumWriter invoke() {
            return new StripeMaterialCesiumWriter(StripePropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public PolylineMaterialCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PolylineMaterialCesiumWriter(PolylineMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public PolylineMaterialCesiumWriter clone() {
        return new PolylineMaterialCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code solidColor} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code solidColor} property defines a material that fills the line with a solid color, which may be translucent.
    

    */
    public final SolidColorMaterialCesiumWriter getSolidColorWriter() {
        return m_solidColor.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code solidColor} property.  The {@code solidColor} property defines a material that fills the line with a solid color, which may be translucent.
    

    */
    public final SolidColorMaterialCesiumWriter openSolidColorProperty() {
        openIntervalIfNecessary();
        return this.<SolidColorMaterialCesiumWriter> openAndReturn(getSolidColorWriter());
    }

    /**
    *  Gets the writer for the {@code polylineOutline} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code polylineOutline} property defines a material that fills the line with a color and outline.
    

    */
    public final PolylineOutlineMaterialCesiumWriter getPolylineOutlineWriter() {
        return m_polylineOutline.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code polylineOutline} property.  The {@code polylineOutline} property defines a material that fills the line with a color and outline.
    

    */
    public final PolylineOutlineMaterialCesiumWriter openPolylineOutlineProperty() {
        openIntervalIfNecessary();
        return this.<PolylineOutlineMaterialCesiumWriter> openAndReturn(getPolylineOutlineWriter());
    }

    /**
    *  Gets the writer for the {@code polylineArrow} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code polylineArrow} property defines a material that fills the line with an arrow.
    

    */
    public final PolylineArrowMaterialCesiumWriter getPolylineArrowWriter() {
        return m_polylineArrow.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code polylineArrow} property.  The {@code polylineArrow} property defines a material that fills the line with an arrow.
    

    */
    public final PolylineArrowMaterialCesiumWriter openPolylineArrowProperty() {
        openIntervalIfNecessary();
        return this.<PolylineArrowMaterialCesiumWriter> openAndReturn(getPolylineArrowWriter());
    }

    /**
    *  Gets the writer for the {@code polylineGlow} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code polylineGlow} property defines a material that fills the line with a glowing color.
    

    */
    public final PolylineGlowMaterialCesiumWriter getPolylineGlowWriter() {
        return m_polylineGlow.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code polylineGlow} property.  The {@code polylineGlow} property defines a material that fills the line with a glowing color.
    

    */
    public final PolylineGlowMaterialCesiumWriter openPolylineGlowProperty() {
        openIntervalIfNecessary();
        return this.<PolylineGlowMaterialCesiumWriter> openAndReturn(getPolylineGlowWriter());
    }

    /**
    *  Gets the writer for the {@code image} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code image} property defines a material that fills the line with an image.
    

    */
    public final ImageMaterialCesiumWriter getImageWriter() {
        return m_image.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code image} property.  The {@code image} property defines a material that fills the line with an image.
    

    */
    public final ImageMaterialCesiumWriter openImageProperty() {
        openIntervalIfNecessary();
        return this.<ImageMaterialCesiumWriter> openAndReturn(getImageWriter());
    }

    /**
    *  Gets the writer for the {@code grid} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code grid} property defines a material that fills the line with a grid.
    

    */
    public final GridMaterialCesiumWriter getGridWriter() {
        return m_grid.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code grid} property.  The {@code grid} property defines a material that fills the line with a grid.
    

    */
    public final GridMaterialCesiumWriter openGridProperty() {
        openIntervalIfNecessary();
        return this.<GridMaterialCesiumWriter> openAndReturn(getGridWriter());
    }

    /**
    *  Gets the writer for the {@code stripe} property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code stripe} property defines a material that fills the line with alternating colors.
    

    */
    public final StripeMaterialCesiumWriter getStripeWriter() {
        return m_stripe.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code stripe} property.  The {@code stripe} property defines a material that fills the line with alternating colors.
    

    */
    public final StripeMaterialCesiumWriter openStripeProperty() {
        openIntervalIfNecessary();
        return this.<StripeMaterialCesiumWriter> openAndReturn(getStripeWriter());
    }
}