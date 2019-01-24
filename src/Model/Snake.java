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

    public Snake(Point startPoint) {
        head = startPoint;
        points = new LinkedList<>();
        points.add(startPoint);
        xSpeed = 0;
        ySpeed = 0;

    }

    public void move() {
        head.translate(xSpeed, ySpeed);
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
