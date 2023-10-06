package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.graphic.resources.BorderArea;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;

public class MainVIewController implements Initializable {

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		backgroundArea.getChildren().add(BorderArea.getBorder());

		close.setOnAction(event -> Platform.exit());
	}

}
