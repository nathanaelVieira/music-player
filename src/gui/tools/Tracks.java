package gui.tools;

import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Tracks {
	private final String[] EXTENSIONS = { "*.mp3", "*.mp3", "*.wav", "*.aiff", "*.au", "*.midi" };
	private static FileChooser fileChooser;
	private List<File> musics;

	public Tracks() {
	}

	public List<File> rescueTackList(Stage stage) {
		fileChooser = new FileChooser();
		desiredExtensions();
		musics = fileChooser.showOpenMultipleDialog(stage);
		return musics;
	}

	private void desiredExtensions() {
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Extensão para reprodução.",
				EXTENSIONS);
		fileChooser.getExtensionFilters().add(extensionFilter);
	}

}
