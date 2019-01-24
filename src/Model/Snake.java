package Model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> points;

    public Snake(Point startPoint) {
        head = startPoint;
        this.points = new LinkedList<>();
    }

    public Point getHead() {
        return head;
    }
}
