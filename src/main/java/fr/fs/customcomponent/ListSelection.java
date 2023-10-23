package fr.fs.customcomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListSelection<T> extends BorderPane {
    @FXML
    private TextField filterField;
    @FXML
    private ListView<T> disponibleList;
    @FXML
    private ListView<T> selectionneList;
    @FXML
    private Button allSelectButton;
    @FXML
    private Button selectButton;
    @FXML
    private Button unAllSelectButton;
    @FXML
    private Button unSelectButton;

    private AnchorPane anchorPane;
    private BorderPane borderPane;
    ListSelectionBean bean;

    public ListSelection() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("controllerlistselected.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            borderPane = fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        bean = new ListSelectionBean<>();
        this.disponibleList.setItems(bean.getDisponibleList());
        this.selectionneList.setItems(bean.getSelectionneList());

    }

    public void setList(List<T> disponibleList, List<T> selectedList) {
        bean.setList(disponibleList, selectedList);
    }
    public void selectAll(){
        bean.selectAll();
    }

    public void unSelectAll(){
        bean.unSelectAll();
    }

}

