package com.team2.Controller;

import java.io.IOException;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
        Board board = new Board(tTtile.getText(), tWriter.getText(), tContent.getText());

        // 알림창
        Alert alertDel = new Alert(AlertType.CONFIRMATION);
        Alert alertBack = new Alert(AlertType.INFORMATION);
        alertDel.setTitle("게시글 수정");
        alertDel.setHeaderText("정말 수정하시겠습니까?");
        alertDel.setContentText("수정된 내용은 되돌릴 수 없습니다.");

        int result = boardService.insert(board);
        if (result > 0) {
            alertBack.setContentText("글이 작성되었습니다.");
            alertBack.show();
        } else {
            alertBack.setContentText("글쓰기가 취소되었습니다.");
            alertBack.show();
        }

        // }
        App.setRoot("board/list");
    }

    // 글쓰기 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
    }
}