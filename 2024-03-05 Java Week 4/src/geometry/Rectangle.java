package geometry;

public class Rectangle extends Shape {
    private Double width, length;

    public Rectangle() {
        super();
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(Double width, Double length) {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(Double width, Double length, String color, Boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return this.length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getArea() {
        return this.length * this.width;
    }

    public Double getPerimeter() {
        return (this.width * 2) + (this.length * 2);
    }

    @Override
    public String toString() {
        return "A Rectange with width=" + this.width + " and length=" + this.length + ", which is a subclass of " +
        super.toString();
    }
}
