module music_player {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires com.jfoenix;
	

	opens application to javafx.graphics, javafx.fxml;
	opens gui to javafx.graphics, javafx.fxml;
	opens gui.graphic.resources to javafx.graphics, javafx.fxml;
}
