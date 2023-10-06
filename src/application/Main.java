package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application {

	private static Stage PRIMARY_STAGE;
	private static Point2D pointAnchorage;
	private static Point2D pointPreviousLocation;

	@Override
	public void start(Stage primaryStage) {
		try {
			PRIMARY_STAGE = primaryStage;
			PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);

			Parent root = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));

			Scene scene = new Scene(root, 551, 275, Color.rgb(0, 0, 0, 0));
			PRIMARY_STAGE.setScene(scene);

			startMoveScene();
			PRIMARY_STAGE.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void startMoveScene() {
		Scene scene = PRIMARY_STAGE.getScene();
		scene.setOnMousePressed(event -> {
			pointAnchorage = new Point2D(event.getScreenX(), event.getScreenY());
		});

		scene.setOnMouseDragged(event -> {
			if (pointAnchorage != null && pointPreviousLocation != null) {
				PRIMARY_STAGE.setX(pointPreviousLocation.getX() + event.getScreenX() - pointAnchorage.getX());
				PRIMARY_STAGE.setY(pointPreviousLocation.getY() + event.getScreenY() - pointAnchorage.getY());
			}
		});

		scene.setOnMouseReleased(event -> {
			pointPreviousLocation = new Point2D(PRIMARY_STAGE.getX(), PRIMARY_STAGE.getY());
		});

		PRIMARY_STAGE.addEventHandler(WindowEvent.WINDOW_SHOWN, (WindowEvent windowEvent) -> {
			pointPreviousLocation = new Point2D(PRIMARY_STAGE.getX(), PRIMARY_STAGE.getY());
		});
	}

}
