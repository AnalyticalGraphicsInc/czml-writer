package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A CZML writer for a property.  The property may be defined over a
 single interval or over multiple intervals.
 * @param <TDerived> The type of the class derived from this one.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public abstract class CesiumPropertyWriter<TDerived extends CesiumPropertyWriter<TDerived>> extends CesiumElementWriter implements ICesiumPropertyWriter {
    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    protected CesiumPropertyWriter(@Nonnull String propertyName) {
        this();
        if (propertyName == null) {
            throw new ArgumentNullException("propertyName");
        }
        m_propertyName = propertyName;
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CesiumPropertyWriter(@Nonnull CesiumPropertyWriter<TDerived> existingInstance) {
        this();
        if (existingInstance == null) {
            throw new ArgumentNullException("existingInstance");
        }
        m_propertyName = existingInstance.m_propertyName;
    }

    private CesiumPropertyWriter() {
        m_multipleIntervals = new Lazy<cesiumlanguagewriter.CesiumIntervalListWriter<TDerived>>(new Func1<cesiumlanguagewriter.CesiumIntervalListWriter<TDerived>>(this, "createIntervalListWriter") {
            public cesiumlanguagewriter.CesiumIntervalListWriter<TDerived> invoke() {
                return createIntervalListWriter();
            }
        }, false);
        m_interval = new Lazy<TDerived>(new Func1<TDerived>(this, "copyForInterval") {
            public TDerived invoke() {
                return copyForInterval();
            }
        }, false);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Nonnull
    public abstract TDerived clone();

    @Nonnull
    private final CesiumIntervalListWriter<TDerived> createIntervalListWriter() {
        return new CesiumIntervalListWriter<TDerived>((TDerived) this);
    }

    /**
    * Gets the name of the property written by this instance.
    */
    @Nonnull
    public final String getPropertyName() {
        return m_propertyName;
    }

    /**
    * Gets a value indicating whether this instance represents an open interval.
    */
    public final boolean getIsInterval() {
        return m_elementType == ElementType.INTERVAL || m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL;
    }

    /**
    * Gets a writer for intervals of this property.  The returned instance must be opened by calling
    the {@link ICesiumElementWriter#open} method before it can be used for writing.  Consider
    calling the {@link #openInterval(JulianDate,JulianDate)} or {@link #openMultipleIntervals} method, which will automatically
    open the writer, instead of accessing this property directly.
    */
    public final TDerived getIntervalWriter() {
        return m_interval.getValue();
    }

    /**
    * Gets a value indicating whether this instance should always open an interval.
    */
    public final boolean getForceInterval() {
        return backingField$ForceInterval;
    }

    /**
    * Sets a value indicating whether this instance should always open an interval.
    */
    public final void setForceInterval(boolean value) {
        backingField$ForceInterval = value;
    }

    /**
    * Opens a writer that is used to write information about this property for a single interval.
    * @return The writer.
    */
    @Nonnull
    public final TDerived openInterval() {
        return openAndReturn(m_interval.getValue());
    }

    /**
    * Opens a writer that is used to write information about this property for a single interval.
    * @param start The start of the interval of time covered by this interval element.
    * @param stop The end of the interval of time covered by this interval element.
    * @return The writer.
    */
    @Nonnull
    public final TDerived openInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop) {
        TDerived result = openAndReturn(m_interval.getValue());
        result.writeInterval(start, stop);
        return result;
    }

    /**
    * Opens a writer that is used to write information about this property for multiple discrete intervals.
    * @return The writer.
    */
    @Nonnull
    public final CesiumIntervalListWriter<TDerived> openMultipleIntervals() {
        return openAndReturn(m_multipleIntervals.getValue());
    }

    /**
    * Writes the actual interval of time covered by this CZML interval.
    * @param start The first date of the interval.
    * @param stop The last date of the interval.
    */
    public final void writeInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop) {
        writeInterval(new TimeInterval(start, stop));
    }

    /**
    * Writes the actual interval of time covered by this CZML interval.
    * @param interval The interval.
    */
    public final void writeInterval(@Nonnull TimeInterval interval) {
        if (interval == null) {
            throw new ArgumentNullException("interval");
        }
        openIntervalIfNecessary();
        getOutput().writePropertyName("interval");
        getOutput().writeValue(CesiumFormattingHelper.toIso8601Interval(interval.getStart(), interval.getStop(), getOutput().getPrettyFormatting() ? Iso8601Format.EXTENDED : Iso8601Format.COMPACT));
    }

    /**
    * When overridden in a derived class, writes content to the stream immediately after opening the writer on it.
    */
    @Override
    protected final void onOpen() {
        if (m_elementType == ElementType.INTERVAL || m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL) {
            getOutput().writeStartObject();
        } else {
            getOutput().writePropertyName(m_propertyName);
        }
    }

    /**
    * When overridden in a derived class, writes content to the stream immediately before closing the writer on it.
    */
    @Override
    protected final void onClose() {
        if (m_elementType == ElementType.INTERVAL || m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL) {
            getOutput().writeEndObject();
            if (m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL) {
                m_elementType = ElementType.PROPERTY;
            }
        }
    }

    /**
    * Opens an interval for this property if one is not already open.
    */
    protected final void openIntervalIfNecessary() {
        if (m_elementType == ElementType.PROPERTY) {
            m_elementType = ElementType.PROPERTY_CONVERTED_TO_INTERVAL;
            onOpen();
        }
    }

    @Nonnull
    private final TDerived copyForInterval() {
        TDerived result = clone();
        CesiumPropertyWriter<TDerived> cesiumPropertyWriter = result;
        cesiumPropertyWriter.m_elementType = ElementType.INTERVAL;
        return result;
    }

    @Nonnull
    private String m_propertyName;
    @Nonnull
    private Lazy<CesiumIntervalListWriter<TDerived>> m_multipleIntervals;
    @Nonnull
    private Lazy<TDerived> m_interval;
    @Nonnull
    private ElementType m_elementType = ElementType.PROPERTY;

    private static enum ElementType implements Enumeration {
        PROPERTY(0),
        INTERVAL(1),
        PROPERTY_CONVERTED_TO_INTERVAL(2);
        private final int value;

        ElementType(int value) {
            this.value = value;
        }

        /**
        * Get the numeric value associated with this enum constant.
        * @return A numeric value.
        */
        @Override
        public int getValue() {
            return value;
        }

        /**
        * Get the enum constant that is associated with the given numeric value.
        * @return The enum constant associated with value.
        * @param value a numeric value.
        */
        @Nonnull
        public static ElementType getFromValue(int value) {
            switch (value) {
            case 0:
                return PROPERTY;
            case 1:
                return INTERVAL;
            case 2:
                return PROPERTY_CONVERTED_TO_INTERVAL;
            default:
                throw new IllegalArgumentException("Undefined enum value.");
            }
        }

        /**
        * Get the enum constant that is considered to be the default.
        * @return The default enum constant.
        */
        @Nonnull
        public static ElementType getDefault() {
            return PROPERTY;
        }
    }

    private boolean backingField$ForceInterval;
}