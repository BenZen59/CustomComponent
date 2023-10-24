package fr.fs.customcomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
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

    public void setList(List<T> disponibleList, List<T> selectionneList) {
        this.selectionneList.addAll(selectionneList);
        for (T elementLu : disponibleList) {
            if (!this.selectionneList.contains(elementLu)) {
                this.disponibleList.add(elementLu);
            }
        }
    }

    public void select(T item) {
        selectionneList.add(item);
        disponibleList.remove(item);
    }

    public void unSelect(T item) {
        disponibleList.add(item);
        selectionneList.remove(item);
    }

    public void selectAll() {
        selectionneList.addAll(disponibleFiltered);
        disponibleList.removeAll(disponibleFiltered);
    }

    public void unSelectAll() {
        disponibleList.addAll(selectionneFiltered);
        selectionneList.removeAll(selectionneFiltered);
    }

    public void filter(String filterText) {
        String filterTextLower = filterText.toLowerCase();
        disponibleFiltered.setPredicate(item -> {
            return item.toString().toLowerCase().contains(filterTextLower);
        });

        selectionneFiltered.setPredicate(item -> {
            return item.toString().toLowerCase().contains(filterTextLower);
        });
    }

    public ObservableList<T> getDisponibleList() {
        return disponibleFiltered;
    }

    public ObservableList<T> getSelectionneList() {
        return selectionneFiltered;
    }
}
