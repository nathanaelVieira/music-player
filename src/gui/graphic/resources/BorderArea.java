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

		Stop[] stops = new Stop[] { new Stop(0, Color.valueOf("#48484a")), new Stop(0.10, Color.valueOf("#b9b9bd")),
				new Stop(0.16, Color.valueOf("#717174")), new Stop(0.20, Color.valueOf("#565659")),
				new Stop(0.28, Color.valueOf("#29292c")), new Stop(0.40, Color.valueOf("#17171b")),
				new Stop(0.45, Color.valueOf("#38383b")), new Stop(0.60, Color.valueOf("#54555A")),
				new Stop(0.67, Color.valueOf("#1E1E20")), new Stop(0.79, Color.valueOf("#959599")),
				new Stop(0.95, Color.valueOf("#b8b8be")), new Stop(0.99, Color.valueOf("#48484a")) };
		LinearGradient gradient = new LinearGradient(0, 0, 0.6, 0.5, true, CycleMethod.REFLECT, stops);

//		shape.setFill(gradient);
		shape.setFill(Color.valueOf("#1E1E20"));
//		shape.setEffect(innerShadow());
		shape.setStroke(Color.rgb(52, 52, 52, 0.9));
		shape.setStrokeWidth(0.8);
		shape.setEffect(new Glow());

		return shape;
	}
}
