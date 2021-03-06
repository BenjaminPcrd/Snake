package View;

import Model.GameLoop;
import Model.Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    private Grid grid;
    private GameLoop loop;
    private GraphicsContext context;

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setFocusTraversable(true);
        context = canvas.getGraphicsContext2D();
        reset();

        canvas.setOnKeyPressed(key -> {
            switch(key.getCode()) {
                case UP:
                    System.out.println("UP");
                    grid.getSnake().setUp();
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    grid.getSnake().setDown();
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    grid.getSnake().setLeft();
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    grid.getSnake().setRight();
                    break;
                case ENTER:
                    System.out.println("ENTER");
                    if(loop.isPaused() && !grid.getSnake().isCollision()) {
                        loop.resume();
                        (new Thread(loop)).start();
                        System.out.println("resume");
                    } else if(loop.isPaused() && grid.getSnake().isCollision()) {
                        reset();
                        loop.resume();
                        (new Thread(loop)).start();
                        System.out.println("reset");
                    } else {
                        loop.pause();
                        Painter.paintPauseMessage(context);
                        System.out.println("pause");
                    }
                    break;
            }
        });


        (new Thread(loop)).start();

        Scene scene = new Scene(root);

        root.getChildren().add(canvas);

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void reset() {
        grid = new Grid(WIDTH, HEIGHT);
        loop = new GameLoop(grid, context);
        Painter.paint(grid, context);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
