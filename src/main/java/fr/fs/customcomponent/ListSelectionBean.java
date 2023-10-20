package fr.fs.customcomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.List;

public class ListSelectionBean<T> {
    private ObservableList<T> disponibleList;
    private ObservableList<T> selectionneList;

    private FilteredList<T> disponibleFiltered;
    private FilteredList<T> selectionneFiltered;

    public ListSelectionBean() {
        this.disponibleList = FXCollections.observableArrayList();
        this.selectionneList = FXCollections.observableArrayList();
        this.disponibleFiltered = new FilteredList<>(disponibleList);
        this.selectionneFiltered = new FilteredList<>(selectionneList);
    }

    public void setList(List<T> disponibleList, List<T> selectionneList){
        this.selectionneList.addAll(selectionneList);
        for(T elemenentLu: disponibleList){
            if(!this.selectionneList.contains(elemenentLu)){
                this.disponibleList.add(elemenentLu);
            }
        }
    }

    public ObservableList<T> getDisponibleList() {
        return disponibleList;
    }

    public ObservableList<T> getSelectionneList() {
        return selectionneList;
    }
}
