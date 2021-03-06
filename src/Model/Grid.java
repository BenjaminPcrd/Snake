package Model;

import javafx.scene.paint.Color;

import java.util.Random;

public class Grid {
    public static final int SIZE = 20;
    public static final Color COLOR= Color.BLACK;

    private final int rows;
    private final int cols;

    private Snake snake;
    private Food food;

    public Grid(double width, double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

        snake = new Snake(new Point(rows/2, cols/2), this);

        food = new Food(getRandomPoint());
    }

    public void update() {
        if(food.getPoint().equals(snake.getHead())) {
            snake.extend();
            food.setPoint(getRandomPoint());
        } else {
            snake.move();
        }
    }

    public Point wrap(Point point) {
        int x = point.getX();
        int y = point.getY();
        if(x >= rows) x = 0;
        if(y >= cols) y = 0;
        if(x < 0) x = rows - 1;
        if(y < 0) y = cols - 1;
        return new Point(x, y);
    }

    private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols));
        } while(point.equals(snake.getHead()));
        return point;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    public Food getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }
}
