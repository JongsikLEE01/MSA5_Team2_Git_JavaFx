package com.team2.Controller;

import java.io.IOException;
import java.util.Optional;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SelectController {

    @FXML
    private TextField SearchT;

    @FXML
    public TextArea tContent;
    @FXML
    public TextField tTtile;
    @FXML
    public TextField tWriter;

    private BoardService boardService = new BoardServiceImpl();

    // 글 수정 완료 -> 목록
    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        int srcNo = 0;
        SearchT.getText();
        srcNo = Integer.parseInt(SearchT.getText());

        Board board = new Board(tTtile.getText(), tWriter.getText(), tContent.getText());

        // 알림창
        Alert alertDel = new Alert(AlertType.CONFIRMATION);
        Alert alertBack = new Alert(AlertType.INFORMATION);
        alertDel.setTitle("게시글 수정");
        alertDel.setHeaderText("정말 수정하시겠습니까?");
        alertDel.setContentText("수정된 내용은 되돌릴 수 없습니다.");
        Optional<ButtonType> result1 = alertDel.showAndWait();

        // 수정 확인
        if (result1.get() == ButtonType.OK) {
            board.setNo(srcNo);
            int result = boardService.update(board);
            alertBack.setContentText("수정이 되었습니다.");
            alertBack.show();
            App.setRoot("board/list");
        } else {
            alertBack.setContentText("수정이 취소되었습니다.");
            alertBack.show();
        }

        // 수정할 게시글 번호와 수정될 게시글의 번호가 맞는지 확인
        // if (board.getNo() == srcNo) {

    }

    // 수정 취소 -> 목록
    @FXML
    void moveToList(ActionEvent event) throws IOException {
        App.setRoot("board/list");
        System.out.println(1);
    }

    // 조회
    @FXML
    void searchBtn(ActionEvent event) {
        int srcNo = 0;
        SearchT.getText();
        srcNo = Integer.parseInt(SearchT.getText());

        boardService.select(srcNo);

        Board board = new Board();
        board = boardService.select(srcNo);
        // srcNo = boardService.updateView(srcNo);
        tTtile.setText(board.getTitle());
        tWriter.setText(board.getWriter());
        tContent.setText(board.getContent());
    }
}