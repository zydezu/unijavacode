package exercise;

public class Asset implements IAsset {
    String content;
    BoundingBox area;

    public Asset(String content, BoundingBox area) throws IllegalArgumentException {
        if (content == null) {
            throw new IllegalArgumentException("Content is null");
        }
        if (area == null) {
            throw new IllegalArgumentException("Area is null");
        }
        this.content = content;
        this.area = area;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Asset)) {
            return false;
        }
        Asset otherAsset = (Asset) other; // use a cast to continue
        if (otherAsset.content == this.content &&
                otherAsset.area.equals(this.area)) {
            return true;
        }
        return false;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public BoundingBox getArea() {
        return area;
    }

    @Override
    public Boolean intersects(BoundingBox area) {
        return area.intersects(this.area);
    }

    @Override
    public Boolean isContainedIn(BoundingBox area) {
        return area.contains(this.area);
    }
}
