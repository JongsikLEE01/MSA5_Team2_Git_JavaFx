package com.team2.Controller;

import java.io.IOException;

import com.team2.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class JoinController {

    @FXML
    private TextField tid;
    @FXML
    private TextField tpwd;

    @FXML
    void cansle(ActionEvent event) throws IOException {
        App.setRoot("board/login");
    }

    
    @FXML
    void moveToLogin(ActionEvent event) throws IOException {
        App.setRoot("board/login");
     
            //변수 받기
            String id = tid.getText();
            String pw = tpwd.getText();
            String dbId =""; 
            String dbPw ="";
    
            if(id.equals(dbId)){
                System.out.println("중복된 아이디입니다.");
                
            }

            
        }
        
    }
    


        