module fr.fs.controllertextfield {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fs.controllertextfield to javafx.fxml;
    exports fr.fs.controllertextfield;
}