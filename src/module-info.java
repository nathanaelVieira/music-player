module music_player {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
