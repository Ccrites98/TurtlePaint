import java.awt.*;
import java.awt.geom.Point2D;
public class Square extends Shapes {
    private Point2D location;
    public Square(Turtle turtle, double border, Color color) {
        super(turtle, (int) border, color);
    }

    public Square(Turtle turtle, double coordinate, double coordinate1, int color, int width, double sideLength) {
        super(turtle, coordinate, coordinate1, color, width, sideLength);
    }

    public void paint(){
        Turtle turtle = null;
        getTurtle().setColor(Color.decode(this.getColor()));
        turtle.setPenWidth(this.border);
        turtle.penUp();
        turtle.goTo(this.location);
        turtle.penDown();
        turtle.setDelay(1);
        for (int i = 0; i < 4; i++) {
            turtle.forward(200);
            turtle.turnRight(90);
        }
    }
}