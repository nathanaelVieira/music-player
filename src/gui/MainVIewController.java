package gui;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;

import application.Main;
import gui.graphic.resources.BorderArea;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;

public class MainVIewController implements Initializable {

	static {
		Font.loadFont(MainVIewController.class
				.getResourceAsStream("/resource/fonts/AR_One_Sans/static/AROneSans-Regular.ttf"), 10);
	}

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
	private ListView<File> listView = new ListView<>();

	@FXML
	private JFXSlider slider;

	@FXML
	private ImageView closeButtonImageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		startMoveScene();
		onClosingPlatform();
		backgroundArea.getChildren().add(BorderArea.getBorder());

		close.setStyle("-fx-text-fill: white;");
		menuBar.setStyle("-fx-text-fill: white;");

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

	public void onFileChooserSelected() {
		FileChooser chooser = new FileChooser();
//		File selectedFile = chooser.showOpenDialog(Main.getPRIMARY_STAGE());
		List<File> selectedFile = chooser.showOpenMultipleDialog(Main.getPRIMARY_STAGE());

		ObservableList<File> listMusics = FXCollections.observableArrayList(selectedFile);
		listView.getItems().addAll(listMusics);

		listView.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {

			@Override
			public ListCell<File> call(ListView<File> param) {
				Label lead = new Label();
				Tooltip tooltip = new Tooltip();
				ListCell<File> cell = new ListCell<>() {
					protected void updateItem(File item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							lead.setText(item.getName());
							setText(item.getName());
							tooltip.setText(item.getName());
							setTooltip(tooltip);
							setStyle("-fx-background-color: black; -fx-text-fill: white;");

						} else {
							setStyle("-fx-background-color: black;");
						}
					};
				};

				return cell;
			}
		});

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
