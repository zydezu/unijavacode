package exercise;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QTreeAssetManagerTest {

	IAsset[] assets;
	QTreeAssetManager manager;

	@Before
	/**
	 * This is used to set up the series of assets to be used for testing.
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		assets = new IAsset[5];
		assets[0] = new Asset("A1", new BoundingBox(40, 32, 50, 32));
		assets[1] = new Asset("A2", new BoundingBox(96, 96, 96, 64));
		assets[2] = new Asset("A3", new BoundingBox(110, 140, 40, 32));
		assets[3] = new Asset("A4", new BoundingBox(224, 224, 132, 90));
		assets[4] = new Asset("A5", new BoundingBox(32, 416, 50, 70));

		manager = new QTreeAssetManager(null, new BoundingBox(0, 0, 512, 512));

		for (final IAsset asset : assets) {
			manager.addAsset(asset);
		}
		System.out.println(manager);
	}

	@Test
	/**
	 * Checks that method getAssets(BoundingBox) returns all assets in a tree 
	 * when the given bounding box covers all area of the tree. 
	 */
	public void testGetAssetsBoundingBox1() {
		final List<IAsset> lst = new ArrayList<>(manager.getAssets(new BoundingBox(0, 0, 512, 512)));
		assertEquals(5, lst.size());
		for (final IAsset asset : assets) {
			assertTrue(lst.contains(asset));
		}
	}

	@Test
	/**
	 * Checks that method getAssets(BoundingBox) returns all assets
	 * intersecting the given bounding box.
	 */
	public void testGetAssetsBoundingBox3() {
		final List<IAsset> lst = new ArrayList<>(manager.getAssets(new BoundingBox(0, 0, 128, 128)));
		assertEquals(2, lst.size());
		assertTrue(lst.contains(assets[0]));
		assertTrue(lst.contains(assets[1]));
	}

}
