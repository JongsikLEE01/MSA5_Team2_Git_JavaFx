package com.team2.Controller;

import java.io.IOException;

import com.team2.App;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JoinController {

    private BoardService boardService = new BoardServiceImpl();

    @FXML
    private TextField tAge;

    @FXML
    private TextField tId;

    @FXML
    private TextField tNmae;

    @FXML
    private TextField tPwd;

    @FXML
    void cansle(ActionEvent event) throws IOException {
        App.setRoot("board/login");
    }

    @FXML
    void moveToLogin(ActionEvent event) throws IOException {
        // 회원가입
        String id = tId.getText();
        String pw = tPwd.getText();
        String name = tNmae.getText();
        int no = Integer.parseInt(tAge.getText());

        // 이름, 나이 검사
        if (tNmae.getText() == null || tAge.getText() == null) {
            name = "이름미입력";
            no = 0;
        }

        boardService.join(id, pw, name, no);

        App.setRoot("board/login");
    }
}