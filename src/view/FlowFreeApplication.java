package view;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FlowFreeApplication extends Application {

  public static final ResourceBundle windowConfiguration = ResourceBundle.getBundle("view.resources.windowConfiguration");

  public static final double WIDTH = Double.parseDouble(windowConfiguration.getString("Width"));
  public static final double HEIGHT = Double.parseDouble(windowConfiguration.getString("Height"));
  public static final Color BACKGROUND_COLOR = Color.valueOf(windowConfiguration.getString("BackgroundColor"));

  private Scene myScene;
  private Group myRoot = new Group();

  @Override
  public void start(Stage primaryStage) throws Exception {
    myScene = new Scene(myRoot, WIDTH, HEIGHT);
    myScene.setFill(BACKGROUND_COLOR);
    primaryStage.setScene(myScene);
    primaryStage.show();
  }
}
