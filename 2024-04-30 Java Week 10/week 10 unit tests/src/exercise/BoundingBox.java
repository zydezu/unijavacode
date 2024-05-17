package exercise;

public class BoundingBox {
    public int x, y, width, height;

    public BoundingBox(int x, int y, int width, int height) throws IllegalArgumentException {
        if (!(width >= 1 || height >= 1)) {
            throw new IllegalArgumentException("Width or height is not greater or equal than 1");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean equals(Object other) {
        if (!(other instanceof BoundingBox)) {
            return false;
        }
        BoundingBox otherBB = (BoundingBox) other; // use a cast to continue
        if (otherBB.x == this.x && otherBB.y == this.y
                && otherBB.width == this.width && otherBB.height == this.height) {
            return true;
        }
        return false;
    }

    public Boolean contains(int x, int y) {
        int maxx = this.x + width;
        int maxy = this.y + height;
        if (x >= this.x && y >= this.y
                && x < maxx && y < maxy) { // landing on bottom and rightmost edge
                                           // doesn't count as being in the bounding box
            return true;
        }
        return false;
    }

    public Boolean contains(BoundingBox box) {
        int maxx = this.x + this.width;
        int maxy = this.y + this.height;

        int othermaxx = box.x + box.width;
        int othermaxy = box.y + box.height;
        if (box.x >= this.x && box.y >= this.y
                && othermaxx <= maxx && othermaxy <= maxy) {
            return true;
        }
        return false;
    }

    public Boolean intersects(BoundingBox box) {
        if (box.x + box.width <= this.x)
            return false;
        if (box.y + box.height <= this.y)
            return false;
        if (this.x + this.width <= box.x)
            return false;
        if (this.y + this.height <= box.y)
            return false;
        return true;
    }
}
