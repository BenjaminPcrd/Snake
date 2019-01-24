package Model;

import View.Painter;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    private final Grid grid;
    private final GraphicsContext context;
    private int frameRate;
    private float interval;
    private boolean paused;

    public GameLoop(Grid grid, GraphicsContext context) {
        this.grid = grid;
        this.context = context;
        frameRate = 10;
        interval = 1000.0f / frameRate;
        paused = false;
    }

    @Override
    public void run() {
        while (!paused) {
            float time = System.currentTimeMillis();

            grid.update();
            Painter.paint(grid, context);

            time = System.currentTimeMillis() - time;
            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            }
        }
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }
}
