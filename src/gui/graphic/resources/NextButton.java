package gui.graphic.resources;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;

public class NextButton extends Group {

	public NextButton() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/graphic/resources/NextButton.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
