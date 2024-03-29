package com.team2.Controller;

import java.io.IOException;
import java.util.List;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

    @FXML
    private TextField tid;
    @FXML
    private TextField tpwd;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    // 필요한 객체 생성
    static List<Board> boardList = null; // 게시글 목록

    // 비지니스 로직 계층의 객체 생성
    static BoardService boardService = new BoardServiceImpl();

    @FXML
    void moveToJoin(ActionEvent event) throws IOException {
        App.setRoot("board/join");
    }

    @FXML
    void moveToList(ActionEvent event) throws IOException {
        System.out.println("");
        login();
    }

    public void login() throws IOException {
        // 변수로 받아오기
        String id = tid.getText();
        String pw = tpwd.getText();

        int count = boardService.login(id, pw);
        if (count != 0) {
            System.err.println("로그인 성공");
            App.setRoot("board/list");
        } else {
            System.out.println("로그인 실패");
            // 경고창 띄우기
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("경고창");
            alert.setHeaderText("아이디/비밀번호가 틀렸습니다.");
            alert.setContentText("다시 입력해주세요.");
            alert.showAndWait();
        }
    }
}
