package fr.fs.customcomponent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestApplication extends Application {
    @Override
    public void start(Stage stage) {

        ListSelection controllerListSelected = new ListSelection();
        List<Couleur> disponibleList = new ArrayList<>();
        disponibleList.add(new Couleur("Abricot"));
        disponibleList.add(new Couleur("Acajou"));
        disponibleList.add(new Couleur("Aigue-marine"));
        disponibleList.add(new Couleur("Amande"));
        disponibleList.add(new Couleur("Amarante"));
        disponibleList.add(new Couleur("Bleu"));
        disponibleList.add(new Couleur("Bleu marine"));
        List<Couleur> selectedList = new ArrayList<>();
        selectedList.add(new Couleur("Aurore"));
        selectedList.add(new Couleur("Avocat"));

        controllerListSelected.setList(disponibleList, selectedList);
        VBox rootLayout = new VBox();
        rootLayout.getChildren().add(controllerListSelected);
        Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Custom Component");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}