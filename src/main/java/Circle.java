import java.awt.*;
public class Circle extends Shapes {
    private double radius;
    public Circle(Turtle turtle, int border, Color color, double radius) {
        super(turtle, border, color);
        this.radius = radius;
    }
    public Circle(Turtle turtle, double coordinate, double coordinate1, int color, int width, double radius) {
        super(turtle, coordinate, coordinate1, color, width, radius);
    }
    public void paint(){
        Turtle turtle = null;
        turtle.setColor(Color.decode(this.getColor()));
        turtle.setPenWidth(this.border);
        turtle.penUp();
        turtle.penDown();
        int sides = 360;
        double angle = 360.0 / sides;
        double distance = 2 * Math.PI * radius / sides;
        for (int i = 0; i < sides; i++) {
            turtle.forward(distance);
            turtle.turnRight(angle);
        }}}