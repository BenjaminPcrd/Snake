package View;

import Model.GameLoop;
import Model.Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.setFocusTraversable(true);

        Grid grid = new Grid(WIDTH, HEIGHT);
        GameLoop loop = new GameLoop(grid, canvas.getGraphicsContext2D());

        canvas.setOnKeyPressed(key -> {
            switch(key.getCode()) {
                case UP:
                    System.out.println("UP");
                    break;
                case DOWN:
                    System.out.println("DOWN");
                    break;
                case LEFT:
                    System.out.println("LEFT");
                    break;
                case RIGHT:
                    System.out.println("RIGHT");
                    break;
                case ENTER:
                    System.out.println("ENTER");
                    if(loop.isPaused()) {
                        loop.resume();
                        (new Thread(loop)).start();
                        System.out.println("resume");
                    } else {
                        loop.pause();
                        System.out.println("pause");
                    }
                    break;
            }
        });


        (new Thread(loop)).start();

        Scene scene = new Scene(root);

        root.getChildren().add(canvas);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
