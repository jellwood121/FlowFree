package view.windows;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LevelSelectWindowLayout extends WindowLayout{

  public static final ResourceBundle SELECT_WINDOW_CONFIG = ResourceBundle.getBundle("view.resources.levelSelectWindowConfig");
  public static final String LEVELS_PATH = "levels/";
  public static final double MENU_TEXT_SCALE = Double.parseDouble(SELECT_WINDOW_CONFIG.getString("MenuTextScaling"));
  public static final double MENU_TITLE_OFFSET = Double.parseDouble(SELECT_WINDOW_CONFIG.getString("MenuTitleOffset"));

  public LevelSelectWindowLayout(Stage stage, Scene scene) {
    super(stage, scene);
  }

  @Override
  public void initializeWindow() {
    Text levelSelectText = new Text(SELECT_WINDOW_CONFIG.getString("LevelSelectText"));
    levelSelectText.getStyleClass().add("menu-text");
    levelSelectText.setScaleX(MENU_TEXT_SCALE);
    levelSelectText.setScaleY(MENU_TEXT_SCALE);
    setTop(levelSelectText);
    BorderPane.setAlignment(levelSelectText, Pos.BOTTOM_CENTER);
    initializeButtons();
  }

  @Override
  public void initializeButtons() {
    List<File> levels = getLevels();
    FlowPane levelButtons = new FlowPane();
    for(File level : levels){
      Button levelButton = new Button(level.getName().split("\\.")[0]);
      levelButton.setOnAction(e -> changeScene(new GameWindowLayout(getStage(), getScene(), level)));
      levelButtons.getChildren().add(levelButton);
    }
    setCenter(levelButtons);
    BorderPane.setAlignment(levelButtons, Pos.BOTTOM_CENTER);
  }

  private List<File> getLevels() {
    Path levels = null;
    try {
      levels = Paths.get(getClass().getClassLoader().getResource(LEVELS_PATH).toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    assert levels != null;
    return Arrays.asList(Objects.requireNonNull(levels.toFile().listFiles()));
  }

}
