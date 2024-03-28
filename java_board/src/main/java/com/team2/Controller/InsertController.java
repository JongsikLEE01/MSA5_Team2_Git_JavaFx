package com.team2.Controller;

import java.io.IOException;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML
    private TextArea tContent;

    @FXML
    private TextField tTtile;

    @FXML
    private TextField tWriter;

    private BoardService boardService = new BoardServiceImpl();

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

    // 글쓰기
    public void insert(ActionEvent event) throws IOException {
        Board board = new Board (tTtile.getText(), tWriter.getText(), tContent.getText());
        int result = boardService.insert(board);

        if(result > 0) {
            System.out.println("글쓰기 처리 성공");
            App.setRoot("board/list");
        }
    }
}
