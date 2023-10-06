package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.graphic.resources.BorderArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MainVIewController implements Initializable {

	@FXML
	private Group backgroundArea;

	@FXML
	private Rectangle rectangledArea;

	@FXML
	private Rectangle rectangledAreaBorder;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		backgroundArea.getChildren().add(BorderArea.getBorder());
	}

}
