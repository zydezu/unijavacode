package geometry;

class Circle extends Shape {
    private Double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }

    public Circle(Double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getArea() {
        return Math.PI * this.radius * this.radius; 
    }

    public Double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + this.radius + " which is a subclass of " +
        super.toString();
    }
}
