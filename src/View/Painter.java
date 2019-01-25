package View;

import Model.Food;
import Model.Grid;
import Model.Point;
import Model.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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

        paintScore(grid, context);
    }

    private static void paintPoint(Point point, GraphicsContext context) {
        context.fillRect(point.getX() * Grid.SIZE, point.getY() * Grid.SIZE, Grid.SIZE, Grid.SIZE);
    }

    public static void paintLoseMessage(GraphicsContext context) {
        context.setFill(Color.WHITE);
        context.fillText("PERDU - Appuyez sur ENTRER pour recommencer", 10, 20);
    }

    public static void paintPauseMessage(GraphicsContext context) {
        context.setFill(Color.WHITE);
        context.fillText("PAUSE - Appuyez sur ENTRER pour continuer", 10, 20);
    }

    private static void paintScore(Grid grid, GraphicsContext context) {
        context.setFill(Color.WHITE);
        context.fillText("SCORE : " + ((grid.getSnake().getLength() * 100) - 100), 20, grid.getHeight() - 20);
    }
}
