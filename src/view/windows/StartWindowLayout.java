package view.windows;

import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartWindowLayout extends WindowLayout {

  public static final ResourceBundle START_WINDOW_CONFIG= ResourceBundle.getBundle("view.resources.startWindowConfig");
  public static final double MENU_TEXT_SCALE = Double.parseDouble(START_WINDOW_CONFIG.getString("MenuTextScaling"));
  public static final String START = START_WINDOW_CONFIG.getString("Start");

  public StartWindowLayout(Stage stage, Scene scene) {
    super(stage, scene);
  }

  @Override
  public void initializeWindow() {
    Text mainText = new Text(START_WINDOW_CONFIG.getString("FlowFreeText"));
    mainText.getStyleClass().add("menu-text");
    mainText.setScaleX(MENU_TEXT_SCALE);
    mainText.setScaleY(MENU_TEXT_SCALE);
    setCenter(mainText);
    initializeButtons();
  }

  @Override
  public void initializeButtons() {
    Button startButton = new Button(START);
    startButton.getStyleClass().add("button");
    startButton.setOnAction(e -> changeScene(new LevelSelectWindowLayout(getStage(), getScene())));
    setBottom(startButton);
    BorderPane.setAlignment(startButton, Pos.CENTER);
  }
}
