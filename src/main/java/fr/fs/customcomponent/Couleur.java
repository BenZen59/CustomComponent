package fr.fs.customcomponent;

import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Couleur {
    private String name;

    public Couleur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

