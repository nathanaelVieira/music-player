package gui;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;

import application.Main;
import gui.graphic.resources.CustomizedCell;
import gui.graphic.resources.NextButton;
import gui.graphic.resources.PreviousButton;
import gui.tools.Tracks;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class MainVIewController implements Initializable {

	static {
		Font.loadFont(MainVIewController.class
				.getResourceAsStream("/resource/fonts/AR_One_Sans/static/AROneSans-Regular.ttf"), 10);
	}

	private static Point2D pointAnchorage;
	private static Point2D pointPreviousLocation;
	private List<File> musicList;

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
	private ListView<File> listView = new ListView<>();

	@FXML
	private JFXSlider slider;

	@FXML
	private ImageView closeButtonImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println(rectangledArea.getWidth() / 2);

		startMoveScene();
		onClosingPlatform();
//		backgroundArea.getChildren().add(BorderArea.getBorder());

		close.setStyle("-fx-text-fill: white;");
		menuBar.setStyle("-fx-text-fill: white;");

		NextButton nextButton = new NextButton();
		PreviousButton previousButton = new PreviousButton();
		backgroundArea.getChildren().add(nextButton);
		backgroundArea.getChildren().add(previousButton);

		previousButton.setLayoutX(185);
		previousButton.setLayoutY(238);

		nextButton.setLayoutX(285);
		nextButton.setLayoutY(238);

		previousButton.setScaleY(0.6);
		nextButton.setScaleY(0.6);

	}

	public void onClosingPlatform() {
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), closeButtonImageView);
		scaleTransition.setFromX(1.0);
		scaleTransition.setFromY(1.0);
		scaleTransition.setToX(1.2);
		scaleTransition.setToY(1.2);
		scaleTransition.setCycleCount(2);
		scaleTransition.autoReverseProperty();
		scaleTransition.setOnFinished(eventFinished -> Platform.exit());

		closeButtonImageView.setOnMouseClicked(event -> scaleTransition.play());
	}

	@FXML
	public void onFileChooserSelected() {
		Tracks tracks = new Tracks();
		musicList = tracks.rescueTackList(getStageMain());

		ObservableList<File> listMusics = FXCollections.observableArrayList(musicList);
		listView.getItems().addAll(listMusics);

		listView.setCellFactory(new CustomizedCell());
	}

	private void assignPlaybackMusic() {

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
