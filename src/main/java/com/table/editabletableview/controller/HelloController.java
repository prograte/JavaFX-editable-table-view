package com.table.editabletableview.controller;

import com.table.editabletableview.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public static TableView<User> table_info_app;
    public static ObservableList<User> data_table;
    @FXML
    private TableView<User> table_info;
    @FXML
    private TableColumn<User, String> column_id, column_name, column_email, column_notes;
    @FXML
    private TableColumn<User, Button> col_update;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_info_app = table_info;

        initializeCols();
        loadData();
    }

    private void initializeCols() {
        // User.java => id, name, email, notes;

        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        column_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        column_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        col_update.setCellValueFactory(new PropertyValueFactory<>("update"));
        editableCols();
    }

    private void editableCols() {
        column_id.setCellFactory(TextFieldTableCell.forTableColumn());
        column_id.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue()));

        column_name.setCellFactory(TextFieldTableCell.forTableColumn());
        column_name.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue()));

        column_email.setCellFactory(TextFieldTableCell.forTableColumn());
        column_email.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue()));

        column_notes.setCellFactory(TextFieldTableCell.forTableColumn());
        column_notes.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setNotes(e.getNewValue()));

        table_info.setEditable(true);
    }

    private void loadData() {
        data_table = FXCollections.observableArrayList();

        for (int x = 1; x < 12; x++) {
            data_table.add(new User(String.valueOf(x), "name " + x, "email " + x, "notes " + x, new Button("update")));
        }

        table_info.setItems(data_table);
    }
}