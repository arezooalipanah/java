package shape;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        this.width = 1.0D;
        this.length = 1.0D;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return this.width == this.length ? this.width * this.width : this.length * this.width;
    }

    public double getPerimeter() {
        return this.width == this.length ? 4 * this.width : 2 * (this.width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + this.width + "and with length=" + this.length + ", which is a subclass of" + super.toString();
    }
}
