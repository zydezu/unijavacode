package geometry;

public class Shape {
    private String color;
    private Boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;    
    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;    
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return this.filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "A Shape with color of " + this.color + " and " + (this.filled ? "" : "Not ") + "filled";
    }
}

