package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Test;

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
	public final void writesForwardExtrpolationType() {
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
	public final void writesBackwardExtrpolationType() {
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
	public final void writesForwardExtrpolationDuration() {
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
	public final void writesBackwardExtrpolationDuration() {
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
}