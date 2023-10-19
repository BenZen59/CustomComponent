module fr.fs.controllertextfield {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fs.customcomponent to javafx.fxml;
    exports fr.fs.customcomponent;
}