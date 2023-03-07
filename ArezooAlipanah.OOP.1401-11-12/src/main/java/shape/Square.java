package shape;

public class Square extends Rectangle {

    public Square() {
        super();
    }

    public Square(double width, double length) throws InvalidInputException {
        super(width, length);
        if (!statesEquality()) {
            throw new InvalidInputException();
        }
    }

    public Square(String color, boolean filled, double width, double length) throws InvalidInputException {
        super(color, filled, width, length);
        if (!statesEquality()) {
            throw new InvalidInputException();
        }
    }


    private boolean statesEquality() {
        return super.getWidth() == super.getLength();
    }

    public double getArea() {
        return super.getArea();
    }


    public double getPerimeter() {
        return super.getPerimeter();
    }
}