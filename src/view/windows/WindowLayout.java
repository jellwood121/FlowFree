package view.windows;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class WindowLayout extends BorderPane {

  private Stage myStage;
  private Scene myScene;

  public WindowLayout(Stage stage, Scene scene){
    myStage = stage;
    myScene = scene;
    getStyleClass().add("background");
    initializeWindow();
  }

  public abstract void initializeWindow();

  public abstract void initializeButtons();

  public void changeScene(BorderPane newRoot){
    myScene.setRoot(newRoot);
    myStage.setScene(myScene);
    myStage.show();
  }

  public Stage getStage() {
    return myStage;
  }

}
