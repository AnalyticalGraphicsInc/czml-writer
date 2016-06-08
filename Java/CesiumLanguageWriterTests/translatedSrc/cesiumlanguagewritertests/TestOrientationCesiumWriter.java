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
	public final void testCompleteExample() {
		{
			StringWriter stringWriter = new StringWriter();
			try {
				cesiumlanguagewriter.JulianDate date = new JulianDate(2451545.0);
				String id = "MyID";
				cesiumlanguagewriter.TimeInterval availability = new TimeInterval(date, date.addDays(2.0));
				cesiumlanguagewriter.TimeInterval interval1 = new TimeInterval(date, date.addDays(1.0));
				cesiumlanguagewriter.Cartesian interval1Position = new Cartesian(1.0, 2.0, 3.0);
				cesiumlanguagewriter.UnitQuaternion interval1Orientation = new UnitQuaternion(1D, 0D, 0D, 0D);
				cesiumlanguagewriter.TimeInterval interval2 = new TimeInterval(date.addDays(1.0), date.addDays(2.0));
				ArrayList<cesiumlanguagewriter.JulianDate> tempCollection_0 = new ArrayList<cesiumlanguagewriter.JulianDate>();
				tempCollection_0.add(date.addDays(1.0));
				tempCollection_0.add(date.addDays(1.5));
				tempCollection_0.add(date.addDays(2.0));
				ArrayList<cesiumlanguagewriter.JulianDate> interval2SampleDates = tempCollection_0;
				ArrayList<cesiumlanguagewriter.Cartographic> tempCollection_1 = new ArrayList<cesiumlanguagewriter.Cartographic>();
				tempCollection_1.add(Cartographic.getZero());
				tempCollection_1.add(new Cartographic(1.0, 0.0, 0.0));
				tempCollection_1.add(new Cartographic(0.0, 1.0, 0.0));
				ArrayList<cesiumlanguagewriter.Cartographic> interval2SamplePositions = tempCollection_1;
				ArrayList<cesiumlanguagewriter.UnitQuaternion> tempCollection_2 = new ArrayList<cesiumlanguagewriter.UnitQuaternion>();
				tempCollection_2.add(UnitQuaternion.getIdentity());
				tempCollection_2.add(new UnitQuaternion(0.0, 1.0, 0.0, 0.0));
				tempCollection_2.add(new UnitQuaternion(0.0, 0.0, 1.0, 0.0));
				ArrayList<cesiumlanguagewriter.UnitQuaternion> interval2SampleOrientations = tempCollection_2;
				CesiumInterpolationAlgorithm orientationInterpolationAlgorithm = CesiumInterpolationAlgorithm.LINEAR;
				int orientationInterpolationDegree = 1;
				CesiumOutputStream temp_0 = new CesiumOutputStream(stringWriter);
				temp_0.setPrettyFormatting(true);
				cesiumlanguagewriter.CesiumOutputStream outputStream = temp_0;
				cesiumlanguagewriter.CesiumStreamWriter writer = new CesiumStreamWriter();
				{
					cesiumlanguagewriter.PacketCesiumWriter packet = writer.openPacket(outputStream);
					try {
						packet.writeId(id);
						packet.writeAvailability(availability);
						{
							cesiumlanguagewriter.PositionCesiumWriter positionWriter = packet.openPositionProperty();
							try {
								{
									cesiumlanguagewriter.CesiumIntervalListWriter<cesiumlanguagewriter.PositionCesiumWriter> intervalListWriter = positionWriter.openMultipleIntervals();
									try {
										{
											cesiumlanguagewriter.PositionCesiumWriter interval = intervalListWriter.openInterval();
											try {
												interval.writeInterval(interval1);
												interval.writeCartesian(interval1Position);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
										{
											cesiumlanguagewriter.PositionCesiumWriter interval = intervalListWriter.openInterval(interval2.getStart(), interval2.getStop());
											try {
												interval.writeCartographicRadians(interval2SampleDates, interval2SamplePositions);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
									} finally {
										DisposeHelper.dispose(intervalListWriter);
									}
								}
							} finally {
								DisposeHelper.dispose(positionWriter);
							}
						}
						{
							cesiumlanguagewriter.OrientationCesiumWriter orientationWriter = packet.openOrientationProperty();
							try {
								{
									cesiumlanguagewriter.CesiumIntervalListWriter<cesiumlanguagewriter.OrientationCesiumWriter> intervalListWriter = orientationWriter.openMultipleIntervals();
									try {
										{
											cesiumlanguagewriter.OrientationCesiumWriter interval = intervalListWriter.openInterval();
											try {
												interval.writeInterval(interval1);
												interval.writeUnitQuaternion(interval1Orientation);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
										{
											cesiumlanguagewriter.OrientationCesiumWriter interval = intervalListWriter.openInterval(interval2.getStart(), interval2.getStop());
											try {
												interval.writeInterpolationAlgorithm(orientationInterpolationAlgorithm);
												interval.writeInterpolationDegree(orientationInterpolationDegree);
												interval.writeUnitQuaternion(interval2SampleDates, interval2SampleOrientations);
											} finally {
												DisposeHelper.dispose(interval);
											}
										}
									} finally {
										DisposeHelper.dispose(intervalListWriter);
									}
								}
							} finally {
								DisposeHelper.dispose(orientationWriter);
							}
						}
					} finally {
						DisposeHelper.dispose(packet);
					}
				}
				ConsoleHelper.writeLine(stringWriter.toString());
			} finally {
				DisposeHelper.dispose(stringWriter);
			}
		}
	}

	private TestContextRule rule$testContext = new TestContextRule();

	@Rule
	public TestContextRule getRule$testContext() {
		return rule$testContext;
	}
}