package Model;

import java.util.Random;

public class Grid {
    public static final int SIZE = 10;

    private final int rows;
    private final int cols;

    private Snake snake;
    private Food food;

    public Grid(double width, double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

        snake = new Snake(new Point(rows/2, cols/2));

        food = new Food(getRandomPoint());
    }

    private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols));
        } while(point.equals(snake.getHead()));
        return point;
    }
}
