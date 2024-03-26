package com.team2.Controller;

import java.io.IOException;

import com.team2.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//  implements Initializable
public class SelectController {

    ListController LC = new ListController();

    @FXML
    private TextArea tContent;
    @FXML
    private TextField tNo;
    @FXML
    private TextField tTtile;
    @FXML
    private TextField tWriter;

    // private BoardService boardService = new BoardServiceImpl();

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
    // int bno = LC.getBSN();
    // tNo.setText(Integer.toString(bno));
    // }
}
