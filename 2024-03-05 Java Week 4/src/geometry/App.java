package geometry;

public class App {
    public static void main(String[] args) {
        Shape testShape = new Shape("blue", false);
        System.err.println(testShape.toString());

        Circle testCircle = new Circle(12.0, "purple", false);
        System.err.println(testCircle.toString());

        Rectangle testRect = new Rectangle(5.0, 2.0, "aqua", true);
        System.err.println(testRect.toString());

        Square testSquare = new Square(4.0, "yellow", false);
        System.err.println(testSquare.toString());
        testSquare.setLength(10.0);
        System.err.println(testSquare.getArea());
    }    
}
