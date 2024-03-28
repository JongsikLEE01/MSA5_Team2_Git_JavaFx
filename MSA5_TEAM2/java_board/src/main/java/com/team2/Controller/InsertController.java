package com.team2.Controller;

import java.io.IOException;

import com.team2.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML
    private TextArea tContent;

    @FXML
    private TextField tTtile;

    @FXML
    private TextField tWriter;

    // 글쓰기 -> 목록
    @FXML
    void moveToInsert(ActionEvent event) throws IOException {

        App.setRoot("board/list");
    }

    // 글쓰기 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }
}
