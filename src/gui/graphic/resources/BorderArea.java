package gui.graphic.resources;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BorderArea {

	private static Shape shape;

	private BorderArea() {
	}

	public static Shape getBorder() {
		Rectangle rectangleLarger = new Rectangle(551, 275);
		rectangleLarger.setArcHeight(25);
		rectangleLarger.setArcWidth(25);
		Rectangle rectangleSmaller = new Rectangle(4, 5, 543, 266);
		rectangleSmaller.setArcHeight(15);
		rectangleSmaller.setArcWidth(15);
		shape = Path.subtract(rectangleLarger, rectangleSmaller);

		Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("#e6c35c")), new Stop(0.11, Color.valueOf("#cb9d32")),
				new Stop(0.31, Color.valueOf("#b98215")), new Stop(0.45, Color.valueOf("#ddb64d")),
				new Stop(0.57, Color.valueOf("#e4c059")), new Stop(0.64, Color.valueOf("#dfcb90")),
				new Stop(0.74, Color.valueOf("#d1a43a")), new Stop(0.83, Color.valueOf("#b98215")),
				new Stop(0.97, Color.valueOf("#c8972c")) };
		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

		shape.setFill(gradient);
		shape.setStroke(Color.valueOf("#b98215"));
		shape.setStrokeWidth(0.8);

		return shape;
	}
}
