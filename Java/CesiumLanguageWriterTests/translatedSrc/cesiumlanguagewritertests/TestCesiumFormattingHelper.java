package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArrayHelper;
import agi.foundation.compatibility.EnumHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public class TestCesiumFormattingHelper {
    public final void testClockRangeToString(@Nonnull ClockRange value) {
        String s = CesiumFormattingHelper.clockRangeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testClockRangeToString$TestCase1() {
        for (final ClockRange value : getClockRangeValues()) {
            testClockRangeToString(value);
        }
    }

    public static Iterable<ClockRange> getClockRangeValues() {
        return ArrayHelper.arrayAsList((ClockRange[]) EnumHelper.getValues(ClockRange.class));
    }

    public final void testClockStepToString(@Nonnull ClockStep value) {
        String s = CesiumFormattingHelper.clockStepToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testClockStepToString$TestCase1() {
        for (final ClockStep value : getClockStepValues()) {
            testClockStepToString(value);
        }
    }

    public static Iterable<ClockStep> getClockStepValues() {
        return ArrayHelper.arrayAsList((ClockStep[]) EnumHelper.getValues(ClockStep.class));
    }

    public final void testColorBlendModeToString(@Nonnull CesiumColorBlendMode value) {
        String s = CesiumFormattingHelper.colorBlendModeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testColorBlendModeToString$TestCase1() {
        for (final CesiumColorBlendMode value : getColorBlendModeValues()) {
            testColorBlendModeToString(value);
        }
    }

    public static Iterable<CesiumColorBlendMode> getColorBlendModeValues() {
        return ArrayHelper.arrayAsList((CesiumColorBlendMode[]) EnumHelper.getValues(CesiumColorBlendMode.class));
    }

    public final void testCornerTypeToString(@Nonnull CesiumCornerType value) {
        String s = CesiumFormattingHelper.cornerTypeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testCornerTypeToString$TestCase1() {
        for (final CesiumCornerType value : getCornerTypeValues()) {
            testCornerTypeToString(value);
        }
    }

    public static Iterable<CesiumCornerType> getCornerTypeValues() {
        return ArrayHelper.arrayAsList((CesiumCornerType[]) EnumHelper.getValues(CesiumCornerType.class));
    }

    public final void testExtrapolationTypeToString(@Nonnull CesiumExtrapolationType value) {
        String s = CesiumFormattingHelper.extrapolationTypeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testExtrapolationTypeToString$TestCase1() {
        for (final CesiumExtrapolationType value : getExtrapolationTypeValues()) {
            testExtrapolationTypeToString(value);
        }
    }

    public static Iterable<CesiumExtrapolationType> getExtrapolationTypeValues() {
        return ArrayHelper.arrayAsList((CesiumExtrapolationType[]) EnumHelper.getValues(CesiumExtrapolationType.class));
    }

    public final void testHeightReferenceToString(@Nonnull CesiumHeightReference value) {
        String s = CesiumFormattingHelper.heightReferenceToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testHeightReferenceToString$TestCase1() {
        for (final CesiumHeightReference value : getHeightReferenceValues()) {
            testHeightReferenceToString(value);
        }
    }

    public static Iterable<CesiumHeightReference> getHeightReferenceValues() {
        return ArrayHelper.arrayAsList((CesiumHeightReference[]) EnumHelper.getValues(CesiumHeightReference.class));
    }

    public final void testHorizontalOriginToString(@Nonnull CesiumHorizontalOrigin value) {
        String s = CesiumFormattingHelper.horizontalOriginToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testHorizontalOriginToString$TestCase1() {
        for (final CesiumHorizontalOrigin value : getHorizontalOriginValues()) {
            testHorizontalOriginToString(value);
        }
    }

    public static Iterable<CesiumHorizontalOrigin> getHorizontalOriginValues() {
        return ArrayHelper.arrayAsList((CesiumHorizontalOrigin[]) EnumHelper.getValues(CesiumHorizontalOrigin.class));
    }

    public final void testInterpolationAlgorithmToString(@Nonnull CesiumInterpolationAlgorithm value) {
        String s = CesiumFormattingHelper.interpolationAlgorithmToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testInterpolationAlgorithmToString$TestCase1() {
        for (final CesiumInterpolationAlgorithm value : getInterpolationAlgorithmValues()) {
            testInterpolationAlgorithmToString(value);
        }
    }

    public static Iterable<CesiumInterpolationAlgorithm> getInterpolationAlgorithmValues() {
        return ArrayHelper.arrayAsList((CesiumInterpolationAlgorithm[]) EnumHelper.getValues(CesiumInterpolationAlgorithm.class));
    }

    public final void testLabelStyleToString(@Nonnull CesiumLabelStyle value) {
        String s = CesiumFormattingHelper.labelStyleToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testLabelStyleToString$TestCase1() {
        for (final CesiumLabelStyle value : getLabelStyleValues()) {
            testLabelStyleToString(value);
        }
    }

    public static Iterable<CesiumLabelStyle> getLabelStyleValues() {
        return ArrayHelper.arrayAsList((CesiumLabelStyle[]) EnumHelper.getValues(CesiumLabelStyle.class));
    }

    public final void testSensorVolumePortionToDisplayToString(@Nonnull CesiumSensorVolumePortionToDisplay value) {
        String s = CesiumFormattingHelper.sensorVolumePortionToDisplayToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testSensorVolumePortionToDisplayToString$TestCase1() {
        for (final CesiumSensorVolumePortionToDisplay value : getSensorVolumePortionToDisplayValues()) {
            testSensorVolumePortionToDisplayToString(value);
        }
    }

    public static Iterable<CesiumSensorVolumePortionToDisplay> getSensorVolumePortionToDisplayValues() {
        return ArrayHelper.arrayAsList((CesiumSensorVolumePortionToDisplay[]) EnumHelper.getValues(CesiumSensorVolumePortionToDisplay.class));
    }

    public final void testShadowModeToString(@Nonnull CesiumShadowMode value) {
        String s = CesiumFormattingHelper.shadowModeToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testShadowModeToString$TestCase1() {
        for (final CesiumShadowMode value : getShadowModeValues()) {
            testShadowModeToString(value);
        }
    }

    public static Iterable<CesiumShadowMode> getShadowModeValues() {
        return ArrayHelper.arrayAsList((CesiumShadowMode[]) EnumHelper.getValues(CesiumShadowMode.class));
    }

    public final void testStripeOrientationToString(@Nonnull CesiumStripeOrientation value) {
        String s = CesiumFormattingHelper.stripeOrientationToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testStripeOrientationToString$TestCase1() {
        for (final CesiumStripeOrientation value : getStripeOrientationValues()) {
            testStripeOrientationToString(value);
        }
    }

    public static Iterable<CesiumStripeOrientation> getStripeOrientationValues() {
        return ArrayHelper.arrayAsList((CesiumStripeOrientation[]) EnumHelper.getValues(CesiumStripeOrientation.class));
    }

    public final void testVerticalOriginToString(@Nonnull CesiumVerticalOrigin value) {
        String s = CesiumFormattingHelper.verticalOriginToString(value);
        Assert.assertNotNull(s);
    }

    @Test
    public final void testVerticalOriginToString$TestCase1() {
        for (final CesiumVerticalOrigin value : getVerticalOriginValues()) {
            testVerticalOriginToString(value);
        }
    }

    public static Iterable<CesiumVerticalOrigin> getVerticalOriginValues() {
        return ArrayHelper.arrayAsList((CesiumVerticalOrigin[]) EnumHelper.getValues(CesiumVerticalOrigin.class));
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}