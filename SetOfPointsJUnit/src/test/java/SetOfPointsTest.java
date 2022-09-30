import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SetOfPointsTest {

    @org.junit.jupiter.api.Test
    void getMinRemote() {
        SetOfPoints set = new SetOfPoints();
        ArrayList<Point2D.Double> points = new ArrayList<>();
        points.add(new Point2D.Double(-1, 0));
        points.add(new Point2D.Double(2, 2));
        points.add(new Point2D.Double(2, 20));

        set.addPoints(points, 1, 1, 1);
        double actual = set.getMinRemote();
        assertEquals(actual, 0.0);
    }

    @org.junit.jupiter.api.Test
    void getMaxRemote() {
        SetOfPoints set = new SetOfPoints();
        ArrayList<Point2D.Double> points = new ArrayList<>();
        points.add(new Point2D.Double(-1, 0));
        points.add(new Point2D.Double(2, 2));
        points.add(new Point2D.Double(2, 20));

        set.addPoints(points, 1, 1, 1);
        double actual = set.getMaxRemote();
        assertEquals(actual, 16.263455967290593);
    }

}