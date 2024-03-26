package com.team2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.team2.App;
import com.team2.DTO.Board;
import com.team2.Service.BoardService;
import com.team2.Service.BoardServiceImpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController implements Initializable {
	@FXML
	public TableView<Board> boardTableView;

	@FXML
	public TableColumn<Board, Integer> colNo;
	@FXML
	public TableColumn<Board, String> colTitle;
	@FXML
	public TableColumn<Board, String> colWriter;
	@FXML
	public TableColumn<Board, String> colRegDate;
	@FXML
	public TableColumn<Board, String> colView;
	@FXML
	public TextField BoardSelectNo;

	public int BSN;

	private BoardService boardService = new BoardServiceImpl();

	// 글 쓰기
	@FXML
	void moveToInsert(ActionEvent event) throws IOException {
		App.setRoot("board/insert");
	}

	// 글 조회
	@FXML
	void moveToSelect(ActionEvent event) throws IOException {
		// boardService.select(getBSN());
		App.setRoot("board/select");
	}

	// 글 삭제
	@FXML
	void moveToDelete(ActionEvent event) throws IOException {
		Alert alertDel = new Alert(AlertType.CONFIRMATION);
		alertDel.setTitle("게시글 삭제");
		alertDel.setHeaderText("정말 삭제하시겠습니까?");
		alertDel.setContentText("삭제된 내용은 되돌릴 수 없습니다.");
		Optional<ButtonType> result = alertDel.showAndWait();
		if (result.get() == ButtonType.OK) {
			String BoardNo = BoardSelectNo.getText();
			int bNo = Integer.parseInt(BoardNo);

			boardService.delete(bNo);
			System.out.println("삭제 완료");
			App.setRoot("board/list");
		} else {
			Alert alertBack = new Alert(AlertType.INFORMATION);
			alertBack.setContentText("삭제가 취소되었습니다.");
			alertBack.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 게시글 목록 조회
		List<Board> boardList = boardService.list();

		colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		colView.setCellValueFactory(new PropertyValueFactory<>("View"));

		// 테이블뷰에 데이터 추가하기
		ObservableList<Board> list = FXCollections.observableArrayList(
				boardList);

		boardTableView.setItems(list);
	}
}
