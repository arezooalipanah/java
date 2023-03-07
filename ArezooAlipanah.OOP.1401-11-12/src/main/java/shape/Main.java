package shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----whit default constructor-----");
        Shape shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        System.out.println(shape.getColor());
        System.out.println(shape.isFilled());
        System.out.println(shape.toString());

        System.out.println("-----whit default constructor and setters-----");
        shape = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        shape.setColor("red");
        shape.setFilled(false);
        System.out.println(shape.getColor());
        System.out.println(shape.isFilled());
        System.out.println(shape.toString());

        System.out.println("-----without default constructor and setters-----");
        shape = new Shape("blue", false) {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };
        System.out.println(shape.getColor());
        System.out.println(shape.isFilled());
        System.out.println(shape.toString());

        System.out.println("-----calculate area and perimeter-----");
        Shape circle = new Circle(2.0);
        System.out.println("circle area is: " + circle.getArea());
        System.out.println("circle perimeter is: " + circle.getPerimeter());

        Shape rectangle = new Rectangle(5.0, 5.0);
        System.out.println("rectangle area is: " + rectangle.getArea());
        System.out.println("rectangle perimeter is: " + rectangle.getPerimeter());

        System.out.println("-----polymorphism-----");
        System.out.println("-----circle-----");
        circle = new Circle("yellow", true, 3.0);
        System.out.println("area is: " + circle.getArea());
        System.out.println("perimeter is: " + circle.getPerimeter());
        System.out.println(circle.toString());

        System.out.println("-----rectangle-----");
        rectangle = new Rectangle(3.0, 4.0);
        System.out.println("area is: " + rectangle.getArea());
        System.out.println("perimeter is: " + rectangle.getPerimeter());
        System.out.println(rectangle.toString());

        System.out.println("-----square-----");
        try {
            Shape square = new Square(5.0, 6.0);
            System.out.println("area is: " + square.getArea());
            System.out.println("perimeter is: " + square.getPerimeter());
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}