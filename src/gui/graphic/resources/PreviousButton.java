package gui.graphic.resources;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;

public class PreviousButton extends Group {

	public PreviousButton() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/graphic/resources/PreviousButton.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
