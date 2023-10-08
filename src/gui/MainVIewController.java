package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.graphic.resources.BorderArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainVIewController implements Initializable {

	private static Point2D pointAnchorage;
	private static Point2D pointPreviousLocation;

	@FXML
	private Group backgroundArea;

	@FXML
	private Rectangle rectangledArea;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu file;

	@FXML
	private MenuItem close;

	@FXML
	private ListView<File> listView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		startMoveScene();
		backgroundArea.getChildren().add(BorderArea.getBorder());

		close.setStyle("-fx-text-fill: white;");
		menuBar.setStyle("-fx-text-fill: white;");

//		close.setOnAction(event -> Platform.exit());
	}

	public void onFileChooserSelected() {
		FileChooser chooser = new FileChooser();
		File selectedFile = chooser.showOpenDialog(Main.getPRIMARY_STAGE());
		if (selectedFile != null) {
			System.out.println("Arquivo selecionado: " + selectedFile.getName());
		}
	}

	private void startMoveScene() {
		menuBar.setOnMousePressed(event -> {
			pointAnchorage = new Point2D(event.getScreenX(), event.getScreenY());
		});

		menuBar.setOnMouseDragged(event -> {
			if (pointAnchorage != null && pointPreviousLocation != null) {
				getStageMain().setX(pointPreviousLocation.getX() + event.getScreenX() - pointAnchorage.getX());
				getStageMain().setY(pointPreviousLocation.getY() + event.getScreenY() - pointAnchorage.getY());
			}
		});

		menuBar.setOnMouseReleased(event -> {
			pointPreviousLocation = new Point2D(getStageMain().getX(), getStageMain().getY());
		});

		Main.getPRIMARY_STAGE().addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent windowEvent) -> {
			pointPreviousLocation = new Point2D(getStageMain().getX(), getStageMain().getY());
		});
	}

	private static Stage getStageMain() {
		return Main.getPRIMARY_STAGE();
	}

}
