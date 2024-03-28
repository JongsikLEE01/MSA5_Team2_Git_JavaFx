package com.team2;

import java.io.IOException;

import com.team2.DAO.JDBConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

// 조회수 높이는 거 : 검색 버튼을 눌렀을때 조회수 1씩 증가
public class App extends Application {

    private static Scene scene;

    static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        scene = new Scene(loadFXML("board/login"));
        stage.setScene(scene);
        stage.show();
    }

    public static void exit() {
        window.close();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        //JDBConnection jdbc = new JDBConnection();
=======
        JDBConnection jdbc = new JDBConnection();
>>>>>>> 629ad16308f500e6bdf5053aa8f4348f06dd24c7
        launch();
    }
}