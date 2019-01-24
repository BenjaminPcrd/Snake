package Model;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public static final Color COLOR = Color.BEIGE;
    private Point head;
    private List<Point> points;

    public Snake(Point startPoint) {
        head = startPoint;
        points = new LinkedList<>();
        points.add(startPoint);

    }

    public Point getHead() {
        return head;
    }

    public List<Point> getPoints() {
        return points;
    }
}
