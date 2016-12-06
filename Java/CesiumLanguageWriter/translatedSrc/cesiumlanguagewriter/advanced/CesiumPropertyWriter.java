package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.*;

/**
 *  
 A CZML writer for a property.  The property may be defined over a
 single interval or over multiple intervals.
 
 

 * @param <TDerived> The type of the class derived from this one.
 */
public abstract class CesiumPropertyWriter<TDerived extends CesiumPropertyWriter<TDerived>> extends CesiumElementWriter implements ICesiumPropertyWriter {
    private String m_propertyName;
    private Lazy<CesiumIntervalListWriter<TDerived>> m_multipleIntervals;
    private Lazy<TDerived> m_interval;
    private ElementType m_elementType = ElementType.PROPERTY;

    private static enum ElementType implements Enumeration {
        PROPERTY(0), INTERVAL(1), PROPERTY_CONVERTED_TO_INTERVAL(2);
        private final int value;

        ElementType(int value) {
            this.value = value;
        }

        /**
        * Get the numeric value associated with this enum constant.
        * @return A numeric value.
        */
        public int getValue() {
            return value;
        }

        /**
        * Get the enum constant that is associated with the given numeric value.
        * @return The enum constant associated with value.
        * @param value a numeric value.
        */
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
        public static ElementType getDefault() {
            return PROPERTY;
        }
    }

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    protected CesiumPropertyWriter(String propertyName) {
        m_propertyName = propertyName;
        m_multipleIntervals = new Lazy<cesiumlanguagewriter.CesiumIntervalListWriter<TDerived>>(new Func1<cesiumlanguagewriter.CesiumIntervalListWriter<TDerived>>(this, "createIntervalListWriter",
                new Class[] {}) {
            public cesiumlanguagewriter.CesiumIntervalListWriter<TDerived> invoke() {
                return createIntervalListWriter();
            }
        }, false);
        m_interval = new Lazy<TDerived>(new Func1<TDerived>(this, "copyForInterval", new Class[] {}) {
            public TDerived invoke() {
                return copyForInterval();
            }
        }, false);
    }

    private final CesiumIntervalListWriter<TDerived> createIntervalListWriter() {
        return new CesiumIntervalListWriter<TDerived>((TDerived) this);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CesiumPropertyWriter(CesiumPropertyWriter<TDerived> existingInstance) {
        this(existingInstance.m_propertyName);
    }

    /**
    *  Gets the name of the property written by this instance.
    

    */
    public final String getPropertyName() {
        return m_propertyName;
    }

    /**
    *  Gets a value indicating whether this instance represents an open interval.
    

    */
    public final boolean getIsInterval() {
        return m_elementType == ElementType.INTERVAL || m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL;
    }

    /**
    *  Gets a writer for intervals of this property.  The returned instance must be opened by calling
    the  {@link ICesiumElementWriter#open} method before it can be used for writing.  Consider
    calling the  {@link #openInterval(JulianDate,JulianDate)} or  {@link #openMultipleIntervals} method, which will automatically
    open the writer, instead of accessing this property directly.
    

    */
    public final TDerived getIntervalWriter() {
        return m_interval.getValue();
    }

    /**
    *  Gets a value indicating whether this instance should always open an interval.
    

    */
    public final boolean getForceInterval() {
        return backingField$ForceInterval;
    }

    /**
    *  Sets a value indicating whether this instance should always open an interval.
    

    */
    public final void setForceInterval(boolean value) {
        backingField$ForceInterval = value;
    }

    /**
    *  
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    public abstract TDerived clone();

    /**
    *  
    Opens a writer that is used to write information about this property for a single interval.
    
    

    * @return The writer.
    */
    public final TDerived openInterval() {
        return openAndReturn(m_interval.getValue());
    }

    /**
    *  
    Opens a writer that is used to write information about this property for a single interval.
    
    
    
    

    * @param start The start of the interval of time covered by this interval element.
    * @param stop The end of the interval of time covered by this interval element.
    * @return The writer.
    */
    public final TDerived openInterval(JulianDate start, JulianDate stop) {
        TDerived result = openAndReturn(m_interval.getValue());
        result.writeInterval(start, stop);
        return result;
    }

    /**
    *  
    Opens a writer that is used to write information about this property for multiple discrete intervals.
    
    

    * @return The writer.
    */
    public final CesiumIntervalListWriter<TDerived> openMultipleIntervals() {
        return openAndReturn(m_multipleIntervals.getValue());
    }

    /**
    *  
    Writes the actual interval of time covered by this CZML interval.
    
    
    

    * @param start The first date of the interval.
    * @param stop The last date of the interval.
    */
    public final void writeInterval(JulianDate start, JulianDate stop) {
        writeInterval(new TimeInterval(start, stop));
    }

    /**
    *  
    Writes the actual interval of time covered by this CZML interval.
    
    

    * @param interval The interval.
    */
    public final void writeInterval(TimeInterval interval) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("interval");
        getOutput().writeValue(CesiumFormattingHelper.toIso8601Interval(interval.getStart(), interval.getStop(), getOutput().getPrettyFormatting() ? Iso8601Format.EXTENDED : Iso8601Format.COMPACT));
    }

    @Override
    protected final void onOpen() {
        if (m_elementType == ElementType.INTERVAL || m_elementType == ElementType.PROPERTY_CONVERTED_TO_INTERVAL) {
            getOutput().writeStartObject();
        } else {
            getOutput().writePropertyName(m_propertyName);
        }
    }

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
    *  
    Opens an interval for this property if one is not already open.
    

    */
    protected final void openIntervalIfNecessary() {
        if (m_elementType == ElementType.PROPERTY) {
            m_elementType = ElementType.PROPERTY_CONVERTED_TO_INTERVAL;
            onOpen();
        }
    }

    private final TDerived copyForInterval() {
        TDerived result = clone();
        CesiumPropertyWriter<TDerived> cesiumPropertyWriter = result;
        cesiumPropertyWriter.m_elementType = ElementType.INTERVAL;
        return result;
    }

    private boolean backingField$ForceInterval;
}