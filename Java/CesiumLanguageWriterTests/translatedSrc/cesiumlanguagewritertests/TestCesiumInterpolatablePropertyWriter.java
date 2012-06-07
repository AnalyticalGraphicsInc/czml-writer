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
}