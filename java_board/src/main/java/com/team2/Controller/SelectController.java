package com.team2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.team2.App;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// implements Initializable
public class SelectController {

    @FXML
    private TextArea tContent;
    @FXML
    private TextField tTtile;
    @FXML
    private TextField tWriter;
    @FXML
    private TextField tNo;

    // private BoardService boardService = new BoardServiceImpl();

    // 글 수정 -> 목록
    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // 글 삭제 -> 목록
    @FXML
    void moveToDelete(ActionEvent event) throws IOException {
        // boardService.delete(Integer.parseInt(tNo));
        App.setRoot("board/list");
    }

    // 수정 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    // }

}
