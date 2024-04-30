package exercise;
public interface IAsset {

	public String getContent();

	public BoundingBox getArea();

	public Boolean intersects(BoundingBox area);
	
	public Boolean isContainedIn(BoundingBox area);
}
