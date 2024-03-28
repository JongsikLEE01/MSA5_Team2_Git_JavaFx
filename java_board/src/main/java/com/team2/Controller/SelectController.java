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

        // 수정할 게시글 번호와 수정될 게시글의 번호가 맞는지 확인
        // if (board.getNo() == srcNo) {
        board.setNo(srcNo);
        int result = boardService.update(board);
        if (result > 0) {
            System.out.println("게시글이 수정이 실패했습니다.");

        } else {
            System.out.println("게시글이 수정이 실패했습니다.");
        }

        // }
        App.setRoot("board/list");
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

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1) {
    // // int no = Integer.valueOf(tTtile.getText());
    // // sm.read(no);
    // }

}