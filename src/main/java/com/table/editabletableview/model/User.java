package com.table.editabletableview.model;

import com.table.editabletableview.controller.HelloController;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class User {

    /*Add the strings and buttons to be used in the application*/
    String id, name, email, notes;

    Button update;

    /* Constructors */
    public User(String id, String name, String email, String notes, Button update) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.notes = notes;
        this.update = update;

        update.setOnAction(e -> {
            ObservableList<User> users = HelloController.table_info_app.getSelectionModel().getSelectedItems();

            for (User user : users) {
                if (user.getUpdate() == update) {
                    System.out.println("id: " + user.getId());
                    System.out.println("name: " + user.getName());
                    System.out.println("email: " + user.getEmail());
                    System.out.println("notes: " + user.getNotes());
                }
            }
        });
    }

    /* Getters and setters */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Button getUpdate() {
        return update;
    }
}
