package fr.fs.customcomponent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ControllerTextField extends BorderPane {
    @FXML
    private Label labelText;
    @FXML
    private TextField textField;
    @FXML
    private Label labelError;


    private boolean horizontale = true;

    private boolean correct;
    BorderPane borderPane;

    public ControllerTextField() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("controllertextfield.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            borderPane = fxmlLoader.load();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        labelText.setText("");
        labelError.setText("Erreur");
    }

    public void setLabelText(String labelText) {
        this.labelText.setText(labelText);
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void setLabelError(String labelError) {
        this.labelError.setText(labelError);
    }

    public void setTextFieldWidth(int textFieldWidth) {
        this.textField.setMinWidth(textFieldWidth);
    }

    public void setParameters(String correct, String incorrect, String expression) {

        textField.textProperty().addListener((obs, oldText, newText) -> matchExpression(correct, incorrect, expression, textField.getText()));
    }

    public void matchExpression(String correct, String incorrect, String expression, String text) {
        if (text.matches(expression)) {
            labelError.setText(correct);
            labelError.setTextFill(Color.GREEN);
        } else {
            labelError.setText(incorrect);
            labelError.setTextFill(Color.RED);
        }
    }

    public void setHorizontale(boolean bool) {
        BorderPane.setAlignment(labelText, Pos.CENTER_LEFT);
        BorderPane.setAlignment(labelError, Pos.CENTER_LEFT);
        if (bool) {
            borderPane.setTop(null);
            borderPane.setBottom(null);
            borderPane.setLeft(labelText);
            borderPane.setRight(labelError);
        } else {
            borderPane.setLeft(null);
            borderPane.setRight(null);
            borderPane.setTop(labelText);
            borderPane.setBottom(labelError);
        }
    }
}
