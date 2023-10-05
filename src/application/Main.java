package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	private static Stage PRIMARY_STAGE;
	private static Scene SCENE = null;

	@Override
	public void start(Stage primaryStage) {
		try {
			PRIMARY_STAGE = primaryStage;
			PRIMARY_STAGE.initStyle(StageStyle.TRANSPARENT);

			Parent root = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));

			Scene scene = new Scene(root, 551, 275, Color.rgb(0, 0, 0, 0));

			PRIMARY_STAGE.setScene(scene);
			PRIMARY_STAGE.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getPRIMARY_STAGE() {
		return PRIMARY_STAGE;
	}

}
