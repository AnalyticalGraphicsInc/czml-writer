package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class TestCesiumInterpolatablePropertyWriter<TDerived extends CesiumInterpolatablePropertyWriter<TDerived>> extends TestCesiumPropertyWriter<TDerived> {
    @Test
    public final void interpolationAlgorithmValueWritesInterpolationAlgorithmProperty() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeInterpolationAlgorithm(CesiumInterpolationAlgorithm.HERMITE);
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interpolationAlgorithm\":\"HERMITE\"}", getStringWriter().toString());
    }

    @Test
    public final void interpolationDegreeValueWritesInterpolationDegreeProperty() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeInterpolationDegree(3);
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interpolationDegree\":3}", getStringWriter().toString());
    }

    @Test
    public final void writesForwardExtrapolationType() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeForwardExtrapolationType(CesiumExtrapolationType.EXTRAPOLATE);
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"forwardExtrapolationType\":\"EXTRAPOLATE\"}", getStringWriter().toString());
    }

    @Test
    public final void writesBackwardExtrapolationType() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeBackwardExtrapolationType(CesiumExtrapolationType.EXTRAPOLATE);
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"backwardExtrapolationType\":\"EXTRAPOLATE\"}", getStringWriter().toString());
    }

    @Test
    public final void writesForwardExtrapolationDuration() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeForwardExtrapolationDuration(Duration.fromSeconds(12D));
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"forwardExtrapolationDuration\":12}", getStringWriter().toString());
    }

    @Test
    public final void writesBackwardExtrapolationDuration() {
        CesiumPropertyWriter<TDerived> property = createPropertyWriter("foo");
        property.open(getOutputStream());
        {
            TDerived interval = property.openInterval();
            try {
                interval.writeBackwardExtrapolationDuration(Duration.fromSeconds(12D));
            } finally {
                DisposeHelper.dispose(interval);
            }
        }
        Assert.assertEquals("{\"foo\":{\"backwardExtrapolationDuration\":12}", getStringWriter().toString());
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}