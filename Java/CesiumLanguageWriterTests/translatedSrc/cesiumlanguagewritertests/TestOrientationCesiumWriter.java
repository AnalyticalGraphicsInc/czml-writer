package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOrientationCesiumWriter extends TestCesiumInterpolatablePropertyWriter<OrientationCesiumWriter> {
	@Override
	protected CesiumPropertyWriter<OrientationCesiumWriter> createPropertyWriter(String propertyName) {
		return new OrientationCesiumWriter(propertyName);
	}

	@Test
	@Ignore
	public final void sandbox() {
		JulianDate date = new JulianDate(2451545.0);
		{
			StringWriter sw = new StringWriter();
			try {
				CesiumOutputStream output = new CesiumOutputStream(sw);
				output.setPrettyFormatting(true);
				CesiumStreamWriter writer = new CesiumStreamWriter();
				{
					PacketCesiumWriter packet = writer.openPacket(output);
					try {
						packet.writeId("MyID");
						packet.writeAvailability(date, date.addDays(1.0));
						{
							PositionCesiumWriter position = packet.openPositionProperty();
							try {
								{
									CesiumIntervalListWriter<cesiumlanguagewriter.PositionCesiumWriter> intervalList = position.openMultipleIntervals();
									try {
										{
											PositionCesiumWriter interval = intervalList.openInterval();
											try {
												interval.writeInterval(new TimeInterval(date, date.addDays(1.0)));
												interval.writeCartesian(new Cartesian(1.0, 2.0, 3.0));
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
										{
											PositionCesiumWriter interval = intervalList.openInterval(date.addDays(1.0), date.addDays(2.0));
											try {
												ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
												ArrayList<cesiumlanguagewriter.Cartographic> positions = new ArrayList<cesiumlanguagewriter.Cartographic>();
												dates.add(date.addDays(1.0));
												positions.add(Cartographic.getZero());
												dates.add(date.addDays(1.5));
												positions.add(new Cartographic(1.0, 0.0, 0.0));
												dates.add(date.addDays(2.0));
												positions.add(new Cartographic(0.0, 1.0, 0.0));
												interval.writeCartographicRadians(dates, positions);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
									} finally {
										DisposeHelper.dispose(intervalList);
									}
								}
							} finally {
								DisposeHelper.dispose(position);
							}
						}
						{
							OrientationCesiumWriter orientation = packet.openOrientationProperty();
							try {
								{
									CesiumIntervalListWriter<cesiumlanguagewriter.OrientationCesiumWriter> intervalList = orientation.openMultipleIntervals();
									try {
										{
											OrientationCesiumWriter interval = intervalList.openInterval();
											try {
												interval.writeInterval(new TimeInterval(date, date.addDays(1.0)));
												interval.writeUnitQuaternion(new UnitQuaternion(1D, 0D, 0D, 0D));
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
										{
											OrientationCesiumWriter interval = intervalList.openInterval();
											try {
												interval.writeInterpolationAlgorithm(CesiumInterpolationAlgorithm.LINEAR);
												interval.writeInterpolationDegree(1);
												ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
												ArrayList<cesiumlanguagewriter.UnitQuaternion> orientations = new ArrayList<cesiumlanguagewriter.UnitQuaternion>();
												dates.add(date.addDays(1.0));
												orientations.add(UnitQuaternion.getIdentity());
												dates.add(date.addDays(1.5));
												orientations.add(new UnitQuaternion(0.0, 1.0, 0.0, 0.0));
												dates.add(date.addDays(2.0));
												orientations.add(new UnitQuaternion(0.0, 0.0, 1.0, 0.0));
												interval.writeUnitQuaternion(dates, orientations);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
									} finally {
										DisposeHelper.dispose(intervalList);
									}
								}
							} finally {
								DisposeHelper.dispose(orientation);
							}
						}
					} finally {
						DisposeHelper.dispose(packet);
					}
				}
				ConsoleHelper.writeLine(sw.toString());
			} finally {
				DisposeHelper.dispose(sw);
			}
		}
	}

	private TestContextRule rule$testContext = new TestContextRule();

	@Rule
	public TestContextRule getRule$testContext() {
		return rule$testContext;
	}
}