package view;

import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.windows.StartWindowLayout;

public class FlowFreeApplication extends Application {

  public static final ResourceBundle WINDOW_CONFIGURATION = ResourceBundle.getBundle("view.resources.windowConfiguration");
  public static final String STYLESHEET_FOLDER = "/stylesheets/";

  public static final double WIDTH = Double.parseDouble(WINDOW_CONFIGURATION.getString("Width"));
  public static final double HEIGHT = Double.parseDouble(WINDOW_CONFIGURATION.getString("Height"));
  public static final String DEFAULT_THEME = WINDOW_CONFIGURATION.getString("DefaultTheme");

  private Stage myStage;
  private BorderPane myRoot;
  private Scene myScene;

  @Override
  public void start(Stage primaryStage) {
    myStage = primaryStage;
    myRoot = new BorderPane();
    myScene = new Scene(myRoot, WIDTH, HEIGHT);
    myScene.getStylesheets().add(getClass().getResource(STYLESHEET_FOLDER + DEFAULT_THEME).toExternalForm());
    StartWindowLayout startWindow = new StartWindowLayout(myStage, myScene);
    startWindow.changeScene(startWindow);
  }

}
