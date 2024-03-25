package com.team2.Controller;

import java.io.IOException;

import com.team2.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SelectController {

    @FXML
    private TextArea tContent;
    @FXML
    private TextField tTtile;
    @FXML
    private TextField tWriter;

    // db 데이터

    // 글 수정 -> 목록
    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // 글 삭제 -> 목록
    @FXML
    void moveToDelete(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // 수정 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

}
