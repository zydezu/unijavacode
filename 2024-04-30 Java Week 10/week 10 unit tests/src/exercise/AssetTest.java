package exercise;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssetTest {

	@Test
	/**
	 * Checks that the class constructor is working as expected.
	 */
	public void testAsset() {
		IAsset asset = new Asset("Warehouse 51", new BoundingBox(11, 21, 31, 41));
		BoundingBox b1 = asset.getArea();
		assertTrue("Setting Asset.content is incorrect.", asset.getContent().equals("Warehouse 51"));
		assertEquals("Setting Asset.x is incorrect.", b1.x, 11);
		assertEquals("Setting Asset.y is incorrect.", b1.y, 21);
		assertEquals("Setting Asset.width is incorrect.", b1.width, 31);
		assertEquals("  Setting Asset.height is incorrect.", b1.height, 41);
	}

	@Test(expected = IllegalArgumentException.class)
	/**
	 * Checks that the class' constructor throws an IllegalArgumentException 
	 * if the argument content is invalid, i.e. is null.
	 */
	public void testAssetConstructorError() {
		IAsset b1 = new Asset(null, new BoundingBox(10, 20, 30, 0));
	}

	@Test
	/**
	 * Checks method intersects(BoundingBox). In particular test 
	 * intersection on the border of the bounding box.
	 */
	public void testIntersects() {
		IAsset b1 = new Asset("c1", new BoundingBox(10, 10, 10, 10));
		assertEquals("(10, 10, 10, 10) intersects (0, 0, 30, 15).",
				b1.intersects(new BoundingBox(0, 0, 30, 15)), true);

		assertEquals("(10, 10, 10, 10) does not intersect  (20, 0, 1, 20).",
				b1.intersects(new BoundingBox(20, 0, 1, 20)), false);
	}

}
