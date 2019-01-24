package View;

import Model.Food;
import Model.Grid;
import Model.Point;
import Model.Snake;
import javafx.scene.canvas.GraphicsContext;

public class Painter {
    public static void paint(Grid grid, GraphicsContext context) {
        context.setFill(Grid.COLOR);
        context.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        context.setFill(Food.COLOR);
        paintPoint(grid.getFood().getPoint(), context);

        context.setFill(Snake.COLOR);
        for(Point p : grid.getSnake().getPoints()) {
            paintPoint(p, context);
        }
    }

    private static void paintPoint(Point point, GraphicsContext context) {
        context.fillRect(point.getX() * Grid.SIZE, point.getY() * Grid.SIZE, Grid.SIZE, Grid.SIZE);
    }
}
