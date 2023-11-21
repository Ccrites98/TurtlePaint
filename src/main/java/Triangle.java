import java.awt.*;
public class Triangle extends Shapes implements Paint {
    private double length, width, left, left2;

    public Triangle(Turtle turtle, double x, double y, int color, int borderWidth, double length, double width, double left, double left2) {
        super(turtle, x, y, String.valueOf(color), borderWidth);
        this.left = left;
        this.left2 = left2;
        this.length = length;
        this.width = width;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double Length) {
        this.length = length;
    }
    public void paint(){
        Turtle turtle = getTurtle();
        switch(this.getColor()){
            case "1":
                turtle.setColor(Color.GREEN);
                break;
            case "2":
                turtle.setColor(Color.YELLOW);
                break;
            case "3":
                turtle.setColor(Color.RED);
                break;
            case "4":
                turtle.setColor(Color.ORANGE);
                break;
            case "5":
                turtle.setColor(Color.BLUE);
                break;
        }
        turtle.setPenWidth(getBorderWidth());
        turtle.goTo(this.getX(), this.getY());
        turtle.penDown();
        turtle.forward(length);
        turtle.turnLeft(left);
        turtle.forward(width);
        turtle.turnLeft(left2);
        turtle.goTo(this.getX(), this.getY());
        turtle.penUp();
    }
    @Override
    public String toString() {
        return "Triangle," + this.getX() + "," + this.getY() + "," + this.getColor() + "," + this.getBorderWidth() + "," + this.getWidth() + "," + this.getLength() + "," + this.getLeft() + "," + this.getLeft2();

    }
    private String getLeft2() {
        String m = null;
        return m;
    }
    private String getLeft() {
        String l = null;
        return l;
    }}