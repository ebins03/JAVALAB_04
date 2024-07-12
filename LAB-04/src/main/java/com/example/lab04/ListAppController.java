package com.example.lab04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ListAppController {

    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    private ObservableList<String> listItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(listItems);
    }

    @FXML
    public void addButtonClicked(ActionEvent event) {
        String name = nameField.getText();
        if (isValidName(name)) {
            listItems.add(name);
            nameField.clear();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Name");
            alert.setContentText("Name must be at least 3 characters long, start with uppercase letter, and not be empty.");
            alert.showAndWait();
        }
    }

    @FXML
    public void deleteButtonClicked(ActionEvent event) {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            listItems.remove(selectedItem);
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.length() >= 3 && Character.isUpperCase(name.charAt(0));
    }
}