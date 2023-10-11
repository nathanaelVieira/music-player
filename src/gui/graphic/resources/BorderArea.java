package gui.graphic.resources;

import javafx.scene.effect.Glow;
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
		Rectangle rectangleSmaller = new Rectangle(3, 3.2, 545, 268);
		rectangleSmaller.setArcHeight(15);
		rectangleSmaller.setArcWidth(15);
		shape = Path.subtract(rectangleLarger, rectangleSmaller);

		Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("#093561")),new Stop(0.20, Color.valueOf("#01a8fd")), new Stop(0.17, Color.valueOf("#078e89")),
				new Stop(0.54, Color.valueOf("#4fdafc")), new Stop(0.86, Color.valueOf("#0482ca")),
				new Stop(1, Color.valueOf("#093561")) };
		LinearGradient gradient = new LinearGradient(0, 0, 0.6, 0.5, true, CycleMethod.REFLECT, stops);
		
		
		shape.setFill(gradient);
		shape.setStroke(Color.rgb(9, 53, 97, 0.9));
		shape.setStrokeWidth(0.8);
		shape.setEffect(new Glow());

		return shape;
	}
}
