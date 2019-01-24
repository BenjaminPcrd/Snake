package Model;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public static final Color COLOR = Color.BEIGE;
    private Point head;
    private List<Point> points;
    private int xSpeed;
    private int ySpeed;
    private boolean collision;

    public Snake(Point startPoint) {
        head = startPoint;
        points = new LinkedList<>();
        points.add(startPoint);
        xSpeed = 0;
        ySpeed = 0;
        collision = false;
    }

    private void growTo(Point point) {
        checkAndAdd(point);
    }

    private void checkAndAdd(Point point) {


        if(points.contains(point)) {
            collision = true;
        }
        System.out.println(collision);
        points.add(point);
        head = point;
    }

    private void shiftTo(Point point) {
        checkAndAdd(point);
        points.remove(0);
    }

    public void move() {
        if(isStart()) {
            shiftTo(head.translate(xSpeed, ySpeed));
        }
    }

    public void extend() {
        if(isStart()) {
            growTo(head.translate(xSpeed, ySpeed));
        }
    }

    private boolean isStart() {
        return xSpeed != 0 || ySpeed != 0;
    }

    public Point getHead() {
        return head;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setUp() {
        xSpeed = 0;
        ySpeed = -1;
    }

    public void setDown() {
        xSpeed = 0;
        ySpeed = 1;
    }

    public void setLeft() {
        xSpeed = -1;
        ySpeed = 0;
    }

    public void setRight() {
        xSpeed = 1;
        ySpeed = 0;
    }
}
