import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {

        Line lineFirst = new Line(1, "First");
        Line lineSecond = new Line(2, "Second");
        Line lineThird = new Line(3, "Third");

        stationIndex.addLine(lineFirst);
        stationIndex.addLine(lineSecond);
        stationIndex.addLine(lineThird);

        Station st1l1 = new Station("L1-ST-1", lineFirst);
        Station st2l1 = new Station("L1-ST-2", lineFirst);
        Station st3l1 = new Station("L1-ST-3", lineFirst);

        lineFirst.addStation(st1l1);
        lineFirst.addStation(st2l1);
        lineFirst.addStation(st3l1);

        Station st1l2 = new Station("L2-ST-1", lineSecond);
        Station st2l2 = new Station("L2-ST-2", lineSecond);
        Station st3l2 = new Station("L2-ST-3", lineSecond);

        lineSecond.addStation(st1l2);
        lineSecond.addStation(st2l2);
        lineSecond.addStation(st3l2);

        Station st1l3 = new Station("L3-ST-1", lineThird);
        Station st2l3 = new Station("L3-ST-2", lineThird);
        Station st3l3 = new Station("L3-ST-3", lineThird);

        lineThird.addStation(st1l3);
        lineThird.addStation(st2l3);
        lineThird.addStation(st3l3);

        stationIndex.addStation(st1l1);
        stationIndex.addStation(st2l1);
        stationIndex.addStation(st3l1);
        stationIndex.addStation(st1l2);
        stationIndex.addStation(st2l2);
        stationIndex.addStation(st3l2);
        stationIndex.addStation(st1l3);
        stationIndex.addStation(st2l3);
        stationIndex.addStation(st3l3);

        List<Station> connection1to2 = new ArrayList<>();
        connection1to2.add(st2l1);
        connection1to2.add(st2l2);

        List<Station> connection1to3 = new ArrayList<>();
        connection1to3.add(st3l1);
        connection1to3.add(st2l3);

        stationIndex.addConnection(connection1to2);
        stationIndex.addConnection(connection1to3);
    }

    public void testRouteOnTheLine() {

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("L2-ST-1"),
                stationIndex.getStation("L2-ST-2"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L2-ST-1"));
        expected.add(stationIndex.getStation("L2-ST-2"));
        assertEquals(expected, actual);
    }

    public void testRouteWithOneConnection() {

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("L1-ST-1"),
                stationIndex.getStation("L2-ST-1"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L1-ST-1"));
        expected.add(stationIndex.getStation("L1-ST-2"));
        expected.add(stationIndex.getStation("L2-ST-2"));
        expected.add(stationIndex.getStation("L2-ST-1"));
        assertEquals(expected, actual);
    }

    public void testRouteWithTwoConnections() {

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("L2-ST-3"),
                stationIndex.getStation("L3-ST-3"));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("L2-ST-3"));
        expected.add(stationIndex.getStation("L2-ST-2"));
        expected.add(stationIndex.getStation("L1-ST-2"));
        expected.add(stationIndex.getStation("L1-ST-3"));
        expected.add(stationIndex.getStation("L3-ST-2"));
        expected.add(stationIndex.getStation("L3-ST-3"));

        assertEquals(expected, actual);

    }

    public void testCalculateDuration() {

        double actual;
        double expected;

        actual = RouteCalculator.calculateDuration(routeCalculator.getShortestRoute
                (stationIndex.getStation("L2-ST-3"), stationIndex.getStation("L3-ST-3")));

        expected = 14.5;

        assertEquals(expected, actual);
    }
}
