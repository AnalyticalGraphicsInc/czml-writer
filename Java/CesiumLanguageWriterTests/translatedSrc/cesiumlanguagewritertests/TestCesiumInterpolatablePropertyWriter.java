package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeInterpolationAlgorithm(expectedInterpolationAlgorithm);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "interpolationAlgorithm", CesiumFormattingHelper.interpolationAlgorithmToString(expectedInterpolationAlgorithm));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void interpolationDegreeValueWritesInterpolationDegreeProperty() {
        final String expectedPropertyName = "foo";
        final int expectedInterpolationDegree = 3;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeInterpolationDegree(expectedInterpolationDegree);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "interpolationDegree", expectedInterpolationDegree);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesForwardExtrapolationType() {
        final String expectedPropertyName = "foo";
        final CesiumExtrapolationType expectedForwardExtrapolationType = CesiumExtrapolationType.EXTRAPOLATE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeForwardExtrapolationType(expectedForwardExtrapolationType);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "forwardExtrapolationType", CesiumFormattingHelper.extrapolationTypeToString(expectedForwardExtrapolationType));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesBackwardExtrapolationType() {
        final String expectedPropertyName = "foo";
        final CesiumExtrapolationType expectedBackwardExtrapolationType = CesiumExtrapolationType.EXTRAPOLATE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeBackwardExtrapolationType(expectedBackwardExtrapolationType);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "backwardExtrapolationType", CesiumFormattingHelper.extrapolationTypeToString(expectedBackwardExtrapolationType));
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesForwardExtrapolationDuration() {
        final String expectedPropertyName = "foo";
        Duration expectedForwardExtrapolationDuration = Duration.fromSeconds(12D);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeForwardExtrapolationDuration(expectedForwardExtrapolationDuration);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "forwardExtrapolationDuration", expectedForwardExtrapolationDuration);
        assertExpectedJson(expectedPropertyName, tempCollection$0);
    }

    @Test
    public final void writesBackwardExtrapolationDuration() {
        final String expectedPropertyName = "foo";
        Duration expectedBackwardExtrapolationDuration = Duration.fromSeconds(12D);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<CesiumPropertyWriter<TDerived>> using$1 = new Using<CesiumPropertyWriter<TDerived>>(createPropertyWriter(expectedPropertyName))) {
                final CesiumPropertyWriter<TDerived> propertyWriter = using$1.resource;
                propertyWriter.open(getOutputStream());
                try (Using<TDerived> using$2 = new Using<TDerived>(propertyWriter.openInterval())) {
                    final TDerived intervalWriter = using$2.resource;
                    intervalWriter.writeBackwardExtrapolationDuration(expectedBackwardExtrapolationDuration);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
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