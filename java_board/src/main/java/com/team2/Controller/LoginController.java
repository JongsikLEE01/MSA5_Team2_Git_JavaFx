package com.team2.Controller;

import java.io.IOException;

import com.team2.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField tid;
    @FXML
    private TextField tpwd;

    @FXML
    void moveToJoin(ActionEvent event) throws IOException {
        App.setRoot("board/join");
    }

    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }
}