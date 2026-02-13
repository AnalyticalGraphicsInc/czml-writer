package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.EnumHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public class TestCesiumFormattingHelper {
    public final void testClockRangeToString(@Nonnull ClockRange value) {
        String s = CesiumFormattingHelper.clockRangeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testClockRangeToString$Test() {
        for (final ClockRange value : EnumHelper.getValues(ClockRange.class)) {
            testClockRangeToString(value);
        }
    }

    public final void testClockStepToString(@Nonnull ClockStep value) {
        String s = CesiumFormattingHelper.clockStepToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testClockStepToString$Test() {
        for (final ClockStep value : EnumHelper.getValues(ClockStep.class)) {
            testClockStepToString(value);
        }
    }

    public final void testColorBlendModeToString(@Nonnull CesiumColorBlendMode value) {
        String s = CesiumFormattingHelper.colorBlendModeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testColorBlendModeToString$Test() {
        for (final CesiumColorBlendMode value : EnumHelper.getValues(CesiumColorBlendMode.class)) {
            testColorBlendModeToString(value);
        }
    }

    public final void testCornerTypeToString(@Nonnull CesiumCornerType value) {
        String s = CesiumFormattingHelper.cornerTypeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testCornerTypeToString$Test() {
        for (final CesiumCornerType value : EnumHelper.getValues(CesiumCornerType.class)) {
            testCornerTypeToString(value);
        }
    }

    public final void testExtrapolationTypeToString(@Nonnull CesiumExtrapolationType value) {
        String s = CesiumFormattingHelper.extrapolationTypeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testExtrapolationTypeToString$Test() {
        for (final CesiumExtrapolationType value : EnumHelper.getValues(CesiumExtrapolationType.class)) {
            testExtrapolationTypeToString(value);
        }
    }

    public final void testHeightReferenceToString(@Nonnull CesiumHeightReference value) {
        String s = CesiumFormattingHelper.heightReferenceToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testHeightReferenceToString$Test() {
        for (final CesiumHeightReference value : EnumHelper.getValues(CesiumHeightReference.class)) {
            testHeightReferenceToString(value);
        }
    }

    public final void testHorizontalOriginToString(@Nonnull CesiumHorizontalOrigin value) {
        String s = CesiumFormattingHelper.horizontalOriginToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testHorizontalOriginToString$Test() {
        for (final CesiumHorizontalOrigin value : EnumHelper.getValues(CesiumHorizontalOrigin.class)) {
            testHorizontalOriginToString(value);
        }
    }

    public final void testInterpolationAlgorithmToString(@Nonnull CesiumInterpolationAlgorithm value) {
        String s = CesiumFormattingHelper.interpolationAlgorithmToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testInterpolationAlgorithmToString$Test() {
        for (final CesiumInterpolationAlgorithm value : EnumHelper.getValues(CesiumInterpolationAlgorithm.class)) {
            testInterpolationAlgorithmToString(value);
        }
    }

    public final void testLabelStyleToString(@Nonnull CesiumLabelStyle value) {
        String s = CesiumFormattingHelper.labelStyleToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testLabelStyleToString$Test() {
        for (final CesiumLabelStyle value : EnumHelper.getValues(CesiumLabelStyle.class)) {
            testLabelStyleToString(value);
        }
    }

    public final void testSensorVolumePortionToDisplayToString(@Nonnull CesiumSensorVolumePortionToDisplay value) {
        String s = CesiumFormattingHelper.sensorVolumePortionToDisplayToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testSensorVolumePortionToDisplayToString$Test() {
        for (final CesiumSensorVolumePortionToDisplay value : EnumHelper.getValues(CesiumSensorVolumePortionToDisplay.class)) {
            testSensorVolumePortionToDisplayToString(value);
        }
    }

    public final void testShadowModeToString(@Nonnull CesiumShadowMode value) {
        String s = CesiumFormattingHelper.shadowModeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testShadowModeToString$Test() {
        for (final CesiumShadowMode value : EnumHelper.getValues(CesiumShadowMode.class)) {
            testShadowModeToString(value);
        }
    }

    public final void testStripeOrientationToString(@Nonnull CesiumStripeOrientation value) {
        String s = CesiumFormattingHelper.stripeOrientationToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testStripeOrientationToString$Test() {
        for (final CesiumStripeOrientation value : EnumHelper.getValues(CesiumStripeOrientation.class)) {
            testStripeOrientationToString(value);
        }
    }

    public final void testVerticalOriginToString(@Nonnull CesiumVerticalOrigin value) {
        String s = CesiumFormattingHelper.verticalOriginToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testVerticalOriginToString$Test() {
        for (final CesiumVerticalOrigin value : EnumHelper.getValues(CesiumVerticalOrigin.class)) {
            testVerticalOriginToString(value);
        }
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