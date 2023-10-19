package fr.fs.controllertextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestApplication extends Application {
    @Override
    public void start(Stage stage) {
        ControllerTextField controllerTextField = new ControllerTextField();
        VBox rootLayout = new VBox();
        rootLayout.getChildren().add(controllerTextField);
        Scene scene = new Scene(rootLayout);
        controllerTextField.setLabelText("Téléphone : ");
        controllerTextField.setLabelError("OK !");
        controllerTextField.setTextFieldWidth(90);
        controllerTextField.setHorizontale(false);
        controllerTextField.setParameters("Ok !","Erreur !","(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).{8,15}$");
        stage.setTitle("ControllerTextField");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}