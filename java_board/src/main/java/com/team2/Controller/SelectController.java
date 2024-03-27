package com.team2.Controller;

import java.io.IOException;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// implements Initializable
public class SelectController {

    @FXML
    public TextArea tContent;
    @FXML
    public TextField tTtile;
    @FXML
    public TextField tWriter;

    private BoardService boardService = new BoardServiceImpl();

    // 글 조회
    public void read(int boardNo) {
        System.out.println("read - boardNo : " + boardNo);
        Board board = boardService.select(boardNo);

        tTtile.setText(board.getTitle());
        tWriter.setText(board.getWriter());
        tContent.setText(board.getContent());
    }

    // 글 수정 완료 -> 목록
    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // 수정 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    // // int no = Integer.valueOf(tTtile.getText());
    // // sm.read(no);
    // }

}