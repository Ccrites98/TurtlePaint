import java.awt.*;
public abstract class Shapes implements Paint{
    protected double border;
    private Turtle turtle;
    private double x, y;
    private int color, borderWidth;
    public Shapes(Turtle turtle, double x, double y, String color, int borderWidth) {
        this.turtle = turtle;
        this.x = x;
        this.y = y;
        this.borderWidth = borderWidth;
        this.color = Integer.parseInt(color);
    }
    public Shapes(Turtle turtle, int border, Color color) {
    }
    public Shapes(Turtle turtle, double coordinate, double coordinate1, int color, int width, double radius) {
    }
    public String getColor() {
        return String.valueOf(color);
    }
    public void setColor(int color) {
        this.color = color;
    }
    public int getBorderWidth() {
        return borderWidth;
    }
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
    public Turtle getTurtle() {
        return turtle;
    }
    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public static Color parseColor(String colorString) {
        switch (colorString) {
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            case "red":
                return Color.RED;
            case "orange" :
                return Color.ORANGE;
            case "blue" :
                return Color.BLUE;
            default:
                return Color.BLACK;
        }}}