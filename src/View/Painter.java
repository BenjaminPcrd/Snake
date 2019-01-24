package View;

import Model.Grid;
import javafx.scene.canvas.GraphicsContext;

public class Painter {
    public static void paint(Grid grid, GraphicsContext context) {
        context.setFill(grid.COLOR);
        context.fillRect(0, 0, grid.getWidth(), grid.getHeight());
    }
}
