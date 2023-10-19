package fr.fs.customcomponent;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ControllerListSelected extends BorderPane {

    BorderPane borderPane;

    public ControllerListSelected() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("controllerlistselected.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            borderPane = fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
