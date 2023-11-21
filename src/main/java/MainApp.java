import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world, -100, -100);
        turtle.penUp();
        System.out.println("Bonvenon.");
        int option;
        List<Shapes> shapeList = new ArrayList<>();

        do {
            printMenu();
            option = getOption();

            switch (option) {
                case 1:
                    shapeList.add(addImage(turtle));
                    break;
                case 2:
                    saveImage(shapeList);
                    break;
                case 0:
                    System.out.println("Quit.");
                    break;
                default:
                    System.out.println("No, wrong, stop it.");
                    break;
            }
        } while (option != 0);
    }
    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1) Add Image");
        System.out.println("2) Save Image");
        System.out.println("0) Exit");
        System.out.print("Your choice: ");
    }
    private static int getOption() {
        int option = -1;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        return option;
    }
    public static Shapes addImage(Turtle turtle) {
        int option;
        do {
            printShapeMenu();
            option = getOption();
            scanner.nextLine();
            switch (option) {
                case 1:
                    return addCircle(turtle);
                case 2:
                    return addTriangle(turtle);
                case 3:
                    return addSquare(turtle);
                default:
                    System.out.println("NOOOOOOOOOOOOOOO!");
                    break;
            }
        } while (true);
    }
    private static void printShapeMenu() {
        System.out.println("Which shape would you like to add?");
        System.out.println("1) Circle");
        System.out.println("2) Triangle");
        System.out.println("3) Square");
        System.out.print("Your choice: ");
    }
    private static Circle addCircle(Turtle turtle) {
        double[] coordinates = getCoordinates();
        int color = chooseColor();
        int width = getLineWidth();
        double radius = getDimension("radius");
        Circle circle = new Circle(turtle, coordinates[0], coordinates[1], color, width, radius);
        circle.paint();
        return circle;
    }
    private static Triangle addTriangle(Turtle turtle) {
        double[] coordinates = getCoordinates();
        int color = chooseColor();
        int width = getLineWidth();
        double length = getDimension("length");
        double height = getDimension("height");
        double angle1 = getAngle("first");
        double angle2 = getAngle("second");
        Triangle triangle = new Triangle(turtle, coordinates[0], coordinates[1], color, width, length, height, angle1, angle2);
        triangle.paint();
        return triangle;
    }
    private static Square addSquare(Turtle turtle) {
        double[] coordinates = getCoordinates();
        int color = chooseColor();
        int width = getLineWidth();
        double sideLength = getDimension("side length");
        Square square = new Square(turtle, coordinates[0], coordinates[1], color, width, sideLength);
        square.paint();
        return square;
    }
    private static double[] getCoordinates() {
        System.out.print("Enter the location (x, y): ");
        String[] inputs = scanner.nextLine().replaceAll("[() ]", "").split(",");
        return new double[]{Double.parseDouble(inputs[0]), Double.parseDouble(inputs[1])};
    }
    private static int chooseColor() {
        int color = 0;
        do {
            printColorMenu();
            color = getOption();
            switch (color) {
                case 1, 2, 3, 4, 5:
                    break;
                default:
                    System.out.println("NOOOOOOOOOOOOOOOOOO!");
                    color = 0;
                    break;
            }
        } while (color == 0);
        return color;
    }
    private static void printColorMenu() {
        System.out.println("Please choose a color!");
        System.out.println("1) Green");
        System.out.println("2) Yellow");
        System.out.println("3) Red");
        System.out.println("4) Orange");
        System.out.println("5) Blue");
        System.out.print("Your choice: ");
    }
    private static int getLineWidth() {
        System.out.print("Enter the border width (thickness of the lines): ");
        return scanner.nextInt();
    }
    private static double getDimension(String dimension) {
        System.out.print("Enter the " + dimension + " of the shape: ");
        return scanner.nextDouble();
    }
    private static double getAngle(String angle) {
        System.out.print("Enter the " + angle + " angle: ");
        return scanner.nextDouble();
    }
    public static void saveImage(List<Shapes> shapeList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Shapes.csv", true))) {
            for (Shapes shape : shapeList) {
                writer.write(shape.toString());
                writer.newLine();
            }
        }
    }
}
