package geometry;

public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(Double side) {
        super(side, side);
    }

    public Square(Double side, String color, Boolean filled) {
        super(side, side, color, filled);
    }

    public Double getSide() {
        return this.getLength();
    }

    public void setSide(Double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(Double side) {
        this.setSide(side);
    }

    public void setWidth(Double side) {
        this.setSide(side);
    }

    @Override
    public String toString() {
        return "A Square with side=" + this.getWidth() + ", which is a subclass of " +
        super.toString();
    }
}
