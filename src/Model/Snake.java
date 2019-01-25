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
    private int length;
    private boolean collision;
    private Grid grid;

    public Snake(Point startPoint, Grid grid) {
        head = startPoint;
        points = new LinkedList<>();
        points.add(startPoint);
        xSpeed = 0;
        ySpeed = 0;
        length = 1;
        collision = false;
        this.grid = grid;
    }

    private void growTo(Point point) {
        length++;
        checkAndAdd(point);
    }

    private void checkAndAdd(Point point) {
        point = grid.wrap(point);
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
        if(ySpeed != 1 || length == 1) {
            xSpeed = 0;
            ySpeed = -1;
        }
    }

    public void setDown() {
        if(ySpeed != -1 || length == 1) {
            xSpeed = 0;
            ySpeed = 1;
        }
    }

    public void setLeft() {
        if(xSpeed != 1 || length == 1) {
            xSpeed = -1;
            ySpeed = 0;
        }
    }

    public void setRight() {
        if(xSpeed != -1 || length == 1) {
            xSpeed = 1;
            ySpeed = 0;
        }
    }
}
