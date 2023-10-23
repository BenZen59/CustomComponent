package fr.fs.customcomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
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
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            bean.filter(newValue);
        });

    }

    public void setList(List<T> disponibleList, List<T> selectedList) {
        bean.setList(disponibleList, selectedList);
    }

    public void select() {
        T selectedItem = disponibleList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            bean.select(selectedItem);
        }
    }

    public void unSelect() {
        T selectedItem = selectionneList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            bean.unSelect(selectedItem);
        }
    }

    public void selectAll() {
        bean.selectAll();
    }

    public void unSelectAll() {
        bean.unSelectAll();
    }

    public void filter(KeyEvent event) {
        String filterText = filterField.getText();
        bean.filter(filterText);
        disponibleList.refresh();
        selectionneList.refresh();
    }

    public void itemClick() {
        disponibleList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                select();
            }
            if (event.getClickCount() == 3) {
                selectAll();
            }

        });
    }

    public void unItemClick() {
        selectionneList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                unSelect();
            }
            if (event.getClickCount() == 3) {
                unSelectAll();
            }

        });
    }

    public void dragStart() {
        disponibleList.setOnDragDetected(DragEvent -> {
            T selectedItem = disponibleList.getSelectionModel().getSelectedItem();
            final Dragboard dragboard = disponibleList.startDragAndDrop(TransferMode.MOVE);
            final ClipboardContent content = new ClipboardContent();
            content.putString(selectedItem.toString());
            dragboard.setContent(content);
            DragEvent.consume();
        });
    }

    public void dragOver() {
        selectionneList.setOnDragOver(DragEvent -> {
            if (DragEvent.getGestureSource() == disponibleList &&
                    disponibleList.getSelectionModel().getSelectedItems().size() == 1) {
                DragEvent.acceptTransferModes(TransferMode.MOVE);
            }
            DragEvent.consume();
        });
    }

    public void dragDrop() {
        selectionneList.setOnDragDropped(DragEvent -> {
            Dragboard dragboard = DragEvent.getDragboard();
            boolean success = false;

            if (dragboard.hasString()) {
                String text = dragboard.getString();
                select();

                success = true;
            }

            DragEvent.setDropCompleted(success);
            DragEvent.consume();
        });
    }

    public void dragStartSelect() {
        selectionneList.setOnDragDetected(DragEvent -> {
            T selectedItem = selectionneList.getSelectionModel().getSelectedItem();
            final Dragboard dragboard = selectionneList.startDragAndDrop(TransferMode.MOVE);
            final ClipboardContent content = new ClipboardContent();
            content.putString(selectedItem.toString());
            dragboard.setContent(content);
            DragEvent.consume();
        });
    }

    public void dragOverSelect() {
        disponibleList.setOnDragOver(DragEvent -> {
            if (DragEvent.getGestureSource() == selectionneList &&
                    selectionneList.getSelectionModel().getSelectedItems().size() == 1) {
                DragEvent.acceptTransferModes(TransferMode.MOVE);
            }
            DragEvent.consume();
        });
    }

    public void dragDropSelect() {
        disponibleList.setOnDragDropped(DragEvent -> {
            Dragboard dragboard = DragEvent.getDragboard();
            boolean success = false;

            if (dragboard.hasString()) {
                String text = dragboard.getString();
                unSelect();
                success = true;
            }

            DragEvent.setDropCompleted(success);
            DragEvent.consume();
        });
    }

}

