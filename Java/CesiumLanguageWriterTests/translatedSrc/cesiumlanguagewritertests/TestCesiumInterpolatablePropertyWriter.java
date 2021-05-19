package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class TestCesiumInterpolatablePropertyWriter<TDerived extends CesiumInterpolatablePropertyWriter<TDerived>> extends TestCesiumPropertyWriter<TDerived> {
    @Test
    public final void interpolationAlgorithmValueWritesInterpolationAlgorithmProperty() {
        final String expectedPropertyName = "foo";
        final CesiumInterpolationAlgorithm expectedInterpolationAlgorithm = CesiumInterpolationAlgorithm.HERMITE;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeInterpolationAlgorithm(expectedInterpolationAlgorithm);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "interpolationAlgorithm", CesiumFormattingHelper.interpolationAlgorithmToString(expectedInterpolationAlgorithm));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void interpolationDegreeValueWritesInterpolationDegreeProperty() {
        final String expectedPropertyName = "foo";
        final int expectedInterpolationDegree = 3;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeInterpolationDegree(expectedInterpolationDegree);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "interpolationDegree", expectedInterpolationDegree);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesForwardExtrapolationType() {
        final String expectedPropertyName = "foo";
        final CesiumExtrapolationType expectedForwardExtrapolationType = CesiumExtrapolationType.EXTRAPOLATE;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeForwardExtrapolationType(expectedForwardExtrapolationType);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "forwardExtrapolationType", CesiumFormattingHelper.extrapolationTypeToString(expectedForwardExtrapolationType));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesBackwardExtrapolationType() {
        final String expectedPropertyName = "foo";
        final CesiumExtrapolationType expectedBackwardExtrapolationType = CesiumExtrapolationType.EXTRAPOLATE;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeBackwardExtrapolationType(expectedBackwardExtrapolationType);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "backwardExtrapolationType", CesiumFormattingHelper.extrapolationTypeToString(expectedBackwardExtrapolationType));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesForwardExtrapolationDuration() {
        final String expectedPropertyName = "foo";
        Duration expectedForwardExtrapolationDuration = Duration.fromSeconds(12D);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeForwardExtrapolationDuration(expectedForwardExtrapolationDuration);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "forwardExtrapolationDuration", expectedForwardExtrapolationDuration);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesBackwardExtrapolationDuration() {
        final String expectedPropertyName = "foo";
        Duration expectedBackwardExtrapolationDuration = Duration.fromSeconds(12D);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    CesiumPropertyWriter<TDerived> propertyWriter = createPropertyWriter(expectedPropertyName);
                    try {
                        propertyWriter.open(getOutputStream());
                        {
                            TDerived intervalWriter = propertyWriter.openInterval();
                            try {
                                intervalWriter.writeBackwardExtrapolationDuration(expectedBackwardExtrapolationDuration);
                            } finally {
                                DisposeHelper.dispose(intervalWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(propertyWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, "backwardExtrapolationDuration", expectedBackwardExtrapolationDuration);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}