package exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoundingBoxTest {

	@Test
	/**
	 * Checks that the class constructor is working as expected.
	 */
	public void testBoundingBox() {
		BoundingBox b1 = new BoundingBox(11, 21, 31, 41);
		assertEquals(" Setting BoundingBox.x is incorrect", b1.x, 11);
		assertEquals(" Setting BoundingBox.y is incorrect", b1.y, 21);
		assertEquals(" Setting BoundingBox.width is incorrect", b1.width, 31);
		assertEquals(" Setting BoundingBox.height is incorrect", b1.height, 41);
	}

	@Test
	/**
	 * Checks method contains(int x, int y)
	 */
	public void testContains() {
		BoundingBox b1 = new BoundingBox(10, 10, 10, 10);
		assertEquals("(10, 10, 10, 10) contains (10, 10).", b1.contains(10, 10), true);
		assertEquals("(10, 10, 10, 10) contains (10, 10).", b1.contains(12, 5), false);
		assertEquals("(10, 10, 10, 10) contains (10, 10).", b1.contains(3, 13), false);
		assertEquals("(10, 10, 10, 10) contains (20, 25).", b1.contains(20, 25), false);
	}

	@Test
	/**
	 * Checks method contains(BoundingBox). Also test that a bounding box is
	 * contained within itself.
	 */
	public void testContainsBoundingBox() {
		BoundingBox b1 = new BoundingBox(10, 10, 10, 10);
		assertEquals("(10, 10, 10, 10) contains (10, 10, 10, 5).", b1.contains(new BoundingBox(10, 10, 10, 5)), true);
		assertEquals("(10, 10, 10, 10) contains (0, 0, 6, 16).", b1.contains(new BoundingBox(0, 0, 6, 16)), false);
	}

	@Test
	/**
	 * Checks method intersects(BoundingBox). In particular test intersection
	 * on the border of the bounding box.
	 */
	public void testIntersects() {
		BoundingBox b1 = new BoundingBox(10, 10, 10, 10);
		assertEquals("(10, 10, 10, 10) intersects (0, 0, 15, 11).", b1.intersects(new BoundingBox(0, 0, 15, 11)), true);
		assertEquals("(10, 10, 10, 10) intersects (0, 0, 9, 20).", b1.intersects(new BoundingBox(0, 0, 9, 20)), false);
	}

}
