package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CheckerboardMaterialCesiumWriter;
import cesiumlanguagewriter.GridMaterialCesiumWriter;
import cesiumlanguagewriter.ImageMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineArrowMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineDashMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter;
import cesiumlanguagewriter.SolidColorMaterialCesiumWriter;
import cesiumlanguagewriter.StripeMaterialCesiumWriter;
import javax.annotation.Nonnull;

/**
 * Writes a {@code PolylineMaterial} to a {@link CesiumOutputStream}. A {@code PolylineMaterial} is a definition of how a polyline is colored or shaded.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class PolylineMaterialCesiumWriter extends CesiumPropertyWriter<PolylineMaterialCesiumWriter> {
    /**
    * The name of the {@code solidColor} property.
    */
    @Nonnull
    public static final String SolidColorPropertyName = "solidColor";
    /**
    * The name of the {@code polylineOutline} property.
    */
    @Nonnull
    public static final String PolylineOutlinePropertyName = "polylineOutline";
    /**
    * The name of the {@code polylineArrow} property.
    */
    @Nonnull
    public static final String PolylineArrowPropertyName = "polylineArrow";
    /**
    * The name of the {@code polylineDash} property.
    */
    @Nonnull
    public static final String PolylineDashPropertyName = "polylineDash";
    /**
    * The name of the {@code polylineGlow} property.
    */
    @Nonnull
    public static final String PolylineGlowPropertyName = "polylineGlow";
    /**
    * The name of the {@code image} property.
    */
    @Nonnull
    public static final String ImagePropertyName = "image";
    /**
    * The name of the {@code grid} property.
    */
    @Nonnull
    public static final String GridPropertyName = "grid";
    /**
    * The name of the {@code stripe} property.
    */
    @Nonnull
    public static final String StripePropertyName = "stripe";
    /**
    * The name of the {@code checkerboard} property.
    */
    @Nonnull
    public static final String CheckerboardPropertyName = "checkerboard";
    @Nonnull
    private final Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<SolidColorMaterialCesiumWriter>(new Func1<SolidColorMaterialCesiumWriter>() {
        public SolidColorMaterialCesiumWriter invoke() {
            return new SolidColorMaterialCesiumWriter(SolidColorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineOutlineMaterialCesiumWriter> m_polylineOutline = new Lazy<PolylineOutlineMaterialCesiumWriter>(new Func1<PolylineOutlineMaterialCesiumWriter>() {
        public PolylineOutlineMaterialCesiumWriter invoke() {
            return new PolylineOutlineMaterialCesiumWriter(PolylineOutlinePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineArrowMaterialCesiumWriter> m_polylineArrow = new Lazy<PolylineArrowMaterialCesiumWriter>(new Func1<PolylineArrowMaterialCesiumWriter>() {
        public PolylineArrowMaterialCesiumWriter invoke() {
            return new PolylineArrowMaterialCesiumWriter(PolylineArrowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineDashMaterialCesiumWriter> m_polylineDash = new Lazy<PolylineDashMaterialCesiumWriter>(new Func1<PolylineDashMaterialCesiumWriter>() {
        public PolylineDashMaterialCesiumWriter invoke() {
            return new PolylineDashMaterialCesiumWriter(PolylineDashPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineGlowMaterialCesiumWriter> m_polylineGlow = new Lazy<PolylineGlowMaterialCesiumWriter>(new Func1<PolylineGlowMaterialCesiumWriter>() {
        public PolylineGlowMaterialCesiumWriter invoke() {
            return new PolylineGlowMaterialCesiumWriter(PolylineGlowPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<ImageMaterialCesiumWriter>(new Func1<ImageMaterialCesiumWriter>() {
        public ImageMaterialCesiumWriter invoke() {
            return new ImageMaterialCesiumWriter(ImagePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<GridMaterialCesiumWriter> m_grid = new Lazy<GridMaterialCesiumWriter>(new Func1<GridMaterialCesiumWriter>() {
        public GridMaterialCesiumWriter invoke() {
            return new GridMaterialCesiumWriter(GridPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<StripeMaterialCesiumWriter> m_stripe = new Lazy<StripeMaterialCesiumWriter>(new Func1<StripeMaterialCesiumWriter>() {
        public StripeMaterialCesiumWriter invoke() {
            return new StripeMaterialCesiumWriter(StripePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<CheckerboardMaterialCesiumWriter> m_checkerboard = new Lazy<CheckerboardMaterialCesiumWriter>(new Func1<CheckerboardMaterialCesiumWriter>() {
        public CheckerboardMaterialCesiumWriter invoke() {
            return new CheckerboardMaterialCesiumWriter(CheckerboardPropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PolylineMaterialCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PolylineMaterialCesiumWriter(@Nonnull PolylineMaterialCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PolylineMaterialCesiumWriter clone() {
        return new PolylineMaterialCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code solidColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code solidColor} property defines a material that fills the line with a solid color, which may be translucent.
    */
    @Nonnull
    public final SolidColorMaterialCesiumWriter getSolidColorWriter() {
        return m_solidColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code solidColor} property. The {@code solidColor} property defines a material that fills the line with a solid color, which may be translucent.
    */
    @Nonnull
    public final SolidColorMaterialCesiumWriter openSolidColorProperty() {
        openIntervalIfNecessary();
        return this.<SolidColorMaterialCesiumWriter> openAndReturn(getSolidColorWriter());
    }

    /**
    * Gets the writer for the {@code polylineOutline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polylineOutline} property defines a material that fills the line with a color and outline.
    */
    @Nonnull
    public final PolylineOutlineMaterialCesiumWriter getPolylineOutlineWriter() {
        return m_polylineOutline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polylineOutline} property. The {@code polylineOutline} property defines a material that fills the line with a color and outline.
    */
    @Nonnull
    public final PolylineOutlineMaterialCesiumWriter openPolylineOutlineProperty() {
        openIntervalIfNecessary();
        return this.<PolylineOutlineMaterialCesiumWriter> openAndReturn(getPolylineOutlineWriter());
    }

    /**
    * Gets the writer for the {@code polylineArrow} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polylineArrow} property defines a material that fills the line with an arrow.
    */
    @Nonnull
    public final PolylineArrowMaterialCesiumWriter getPolylineArrowWriter() {
        return m_polylineArrow.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polylineArrow} property. The {@code polylineArrow} property defines a material that fills the line with an arrow.
    */
    @Nonnull
    public final PolylineArrowMaterialCesiumWriter openPolylineArrowProperty() {
        openIntervalIfNecessary();
        return this.<PolylineArrowMaterialCesiumWriter> openAndReturn(getPolylineArrowWriter());
    }

    /**
    * Gets the writer for the {@code polylineDash} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polylineDash} property defines a material that fills the line with a pattern of dashes.
    */
    @Nonnull
    public final PolylineDashMaterialCesiumWriter getPolylineDashWriter() {
        return m_polylineDash.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polylineDash} property. The {@code polylineDash} property defines a material that fills the line with a pattern of dashes.
    */
    @Nonnull
    public final PolylineDashMaterialCesiumWriter openPolylineDashProperty() {
        openIntervalIfNecessary();
        return this.<PolylineDashMaterialCesiumWriter> openAndReturn(getPolylineDashWriter());
    }

    /**
    * Gets the writer for the {@code polylineGlow} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polylineGlow} property defines a material that fills the line with a glowing color.
    */
    @Nonnull
    public final PolylineGlowMaterialCesiumWriter getPolylineGlowWriter() {
        return m_polylineGlow.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polylineGlow} property. The {@code polylineGlow} property defines a material that fills the line with a glowing color.
    */
    @Nonnull
    public final PolylineGlowMaterialCesiumWriter openPolylineGlowProperty() {
        openIntervalIfNecessary();
        return this.<PolylineGlowMaterialCesiumWriter> openAndReturn(getPolylineGlowWriter());
    }

    /**
    * Gets the writer for the {@code image} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code image} property defines a material that fills the line with an image.
    */
    @Nonnull
    public final ImageMaterialCesiumWriter getImageWriter() {
        return m_image.getValue();
    }

    /**
    * Opens and returns the writer for the {@code image} property. The {@code image} property defines a material that fills the line with an image.
    */
    @Nonnull
    public final ImageMaterialCesiumWriter openImageProperty() {
        openIntervalIfNecessary();
        return this.<ImageMaterialCesiumWriter> openAndReturn(getImageWriter());
    }

    /**
    * Gets the writer for the {@code grid} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code grid} property defines a material that fills the line with a grid.
    */
    @Nonnull
    public final GridMaterialCesiumWriter getGridWriter() {
        return m_grid.getValue();
    }

    /**
    * Opens and returns the writer for the {@code grid} property. The {@code grid} property defines a material that fills the line with a grid.
    */
    @Nonnull
    public final GridMaterialCesiumWriter openGridProperty() {
        openIntervalIfNecessary();
        return this.<GridMaterialCesiumWriter> openAndReturn(getGridWriter());
    }

    /**
    * Gets the writer for the {@code stripe} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code stripe} property defines a material that fills the line with alternating colors.
    */
    @Nonnull
    public final StripeMaterialCesiumWriter getStripeWriter() {
        return m_stripe.getValue();
    }

    /**
    * Opens and returns the writer for the {@code stripe} property. The {@code stripe} property defines a material that fills the line with alternating colors.
    */
    @Nonnull
    public final StripeMaterialCesiumWriter openStripeProperty() {
        openIntervalIfNecessary();
        return this.<StripeMaterialCesiumWriter> openAndReturn(getStripeWriter());
    }

    /**
    * Gets the writer for the {@code checkerboard} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code checkerboard} property defines a material that fills the line with a checkerboard pattern.
    */
    @Nonnull
    public final CheckerboardMaterialCesiumWriter getCheckerboardWriter() {
        return m_checkerboard.getValue();
    }

    /**
    * Opens and returns the writer for the {@code checkerboard} property. The {@code checkerboard} property defines a material that fills the line with a checkerboard pattern.
    */
    @Nonnull
    public final CheckerboardMaterialCesiumWriter openCheckerboardProperty() {
        openIntervalIfNecessary();
        return this.<CheckerboardMaterialCesiumWriter> openAndReturn(getCheckerboardWriter());
    }
}