package view.windows;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameWindowLayout extends WindowLayout {

  private File myLevel;

  public GameWindowLayout(Stage stage, Scene scene, File level) {
    super(stage, scene);
    myLevel = level;
  }

  @Override
  public void initializeWindow() {

  }

  @Override
  public void initializeButtons() {

  }
}
