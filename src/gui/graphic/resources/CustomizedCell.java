package gui.graphic.resources;

import java.io.File;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class CustomizedCell implements Callback<ListView<File>, ListCell<File>> {

	@Override
	public ListCell<File> call(ListView<File> param) {
		Label lead = new Label();
		Tooltip tooltip = new Tooltip();
		ListCell<File> cell = new ListCell<>() {
			protected void updateItem(File item, boolean empty) {
				super.updateItem(item, empty);
				if (item != null) {
					lead.setText(item.getName());
					setGraphic(ctt(item.getName()));
					tooltip.setText(item.getName());
					setTooltip(tooltip);

				} else {
					setStyle("-fx-background-color: black;");
				}
			};
		};
		return cell;
	}

	private Node ctt(String nameFile) {

		HBox box = new HBox();
		Text title = new Text(nameFile);
		title.setFill(Color.WHITE);

		HBox.setHgrow(title, Priority.ALWAYS);
		box.setSpacing(5);

		Image image = new Image(getClass().getResourceAsStream("/resource/images/nota-musical.png"));
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(20);
		imageView.setFitHeight(20);

		box.getChildren().addAll(imageView, title);

		box.setOnMouseEntered(event -> {
			Glow glow = new Glow();
			glow.setLevel(10);
			title.setEffect(glow);
		});

		box.setOnMouseExited(event -> {
			title.setEffect(null);
		});

		return box;

	}

}
