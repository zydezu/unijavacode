package exercise;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QTreeAssetManager extends IAssetManager {

	public static final int DEFAULT_MAX_DEPTH = 5;

	QTreeAssetManager parent = null;
	BoundingBox region;
	List<IAsset> assets;
	QTreeAssetManager sw, se, nw, ne;
	int depth;

	public QTreeAssetManager(QTreeAssetManager parent, BoundingBox region) {
		this.parent = parent;
		if (this.parent == null) {
			this.depth = 0;
		} else {
			this.depth = parent.depth + 1;
		}
		this.region = region;
		this.assets = new ArrayList<>();
		this.sw = null;
		this.se = null;
		this.nw = null;
		this.ne = null;
	}

	@Override
	/**
	 * Returns a String representation of the quadtree in the format below. The
	 * children order is ne, nw, sw and se.
	 * --+ [A4]
	 * |
	 * +--+ []
	 * |
	 * +--+ [A2, A3]
	 * | |
	 * | +--+ []
	 * | |
	 * | +--+ [A1]
	 * | |
	 * | +--+ []
	 * | |
	 * | +--+ []
	 * |
	 * +--+ []
	 * |
	 * +--+ []
	 */
	public String toString() {
		StringBuffer output = new StringBuffer();
		toString("", output);
		return output.toString();
	}

	/**
	 * NOT NEEDED FOR THE EXERCISE.
	 * Convenience method to return the list of assets into a string. Used by
	 * the toString(String, String) method.
	 * 
	 * @return
	 */
	private String listAssets() {
		String output = "[";
		for (IAsset abstractAsset : assets) {
			output += abstractAsset.getContent() + ", ";
		}
		if (output.length() > 1) {
			output = output.substring(0, output.length() - 2);
		}
		return output += "]";
	}

	/**
	 * NOT NEEDED FOR THE EXERCISE.
	 * Convenience method for the recursive construction of the String
	 * representation of the tree. Used by the toString() method.
	 * 
	 * @param prefix
	 * @param output
	 */
	private void toString(String prefix, StringBuffer output) {
		if (prefix.length() == 0) {
			output.append(prefix + "--+ " + listAssets() + "\n");
		} else {
			output.append(prefix.substring(0, prefix.length() - 1) + "+--+ " + listAssets() + "\n");
		}
		if (ne != null || nw != null || se != null || sw != null) {
			output.append(prefix + "  |\n");
		} else {
			output.append(prefix + "\n");
			return;
		}
		if (ne != null) {
			String newPrefix = prefix + "  |";
			ne.toString(newPrefix, output);
		} else {
			output.append(prefix + "--<ne> \n");
		}
		if (nw != null) {
			String newPrefix = prefix + "  |";
			nw.toString(newPrefix, output);
		} else {
			output.append(prefix + "--<nw> \n");
		}
		if (sw != null) {
			String newPrefix = prefix + "  |";
			sw.toString(newPrefix, output);
		} else {
			output.append(prefix + "--<se> \n");
		}
		if (se != null) {
			String newPrefix = prefix + "   ";
			se.toString(newPrefix, output);
		} else {
			output.append(prefix + "--<sw> \n");
		}
	}

	private void subdivide() throws Exception {
		if (this.region.width <= 1 || this.region.height <= 1) {
			throw new Exception("Cannot do subdivision, box too small.");
		} else if (this.depth >= DEFAULT_MAX_DEPTH) {
			throw new Exception("Maximum depth reached.");
		}

		int width = this.region.width / 2;
		int height = this.region.height / 2;

		BoundingBox regionNW = new BoundingBox(this.region.x, this.region.y, width, height);

		this.nw = new QTreeAssetManager(this, regionNW);

		BoundingBox regionNE = new BoundingBox(this.region.x + width, this.region.y, width, height);

		this.ne = new QTreeAssetManager(this, regionNE);

		BoundingBox regionSW = new BoundingBox(this.region.x, this.region.y + height, width, height);

		this.sw = new QTreeAssetManager(this, regionSW);

		BoundingBox regionSE = new BoundingBox(this.region.x + width, this.region.y + height, width, height);

		this.se = new QTreeAssetManager(this, regionSE);
	}

	private BoundingBox getNEBoundingBox() {
		int width = this.region.width / 2;
		int height = this.region.height / 2;
		return new BoundingBox(this.region.x + width, this.region.y, width, height);
	}

	private BoundingBox getNWBoundingBox() {
		int width = this.region.width / 2;
		int height = this.region.height / 2;
		return new BoundingBox(this.region.x, this.region.y, width, height);
	}

	private BoundingBox getSEBoundingBox() {
		int width = this.region.width / 2;
		int height = this.region.height / 2;
		return new BoundingBox(this.region.x + width, this.region.y + height, width, height);
	}

	private BoundingBox getSWBoundingBox() {
		int width = this.region.width / 2;
		int height = this.region.height / 2;
		return new BoundingBox(this.region.x, this.region.y + height, width, height);
	}

	private boolean isLeaf() {
		return ne == null && nw == null && se == null && sw == null;
	}

	@Override
	public void addAsset(IAsset asset) {

		// If the asset is not contained in that node region, this means we
		// cannot add the asset to that node. This is an error and the parameter
		// value is illegal.
		if (!asset.isContainedIn(this.region)) {
			throw new InvalidParameterException("Asset outside region of interest.");
		}

		// If we are at the maximum depth, then we cannot subdivide anymore.
		// Therefore, adds the asset to that node.
		if (this.depth == DEFAULT_MAX_DEPTH) {
			this.assets.add(asset);
			return;
		}

		if (!(asset.isContainedIn(getNEBoundingBox()) || asset.isContainedIn(getNWBoundingBox())
				|| asset.isContainedIn(getSEBoundingBox()) || asset.isContainedIn(getSWBoundingBox()))) {
			// asset covers more than one sub-region so must be added to
			// this level
			this.assets.add(asset);
			return;
		}
		// If we are here, it means that we need to add the asset to one of
		// the four sub-quadrants. We must create the four quadrants if it has
		// not been done yet, e.g. the node is a leaf.
		if (isLeaf()) {
			try {
				subdivide();
			} catch (Exception e) {
				this.assets.add(asset);
				return;
			}
		}

		// Check which quadrant contains the asset and add the asset to the
		// quadrant
		if (asset.isContainedIn(this.ne.region)) {
			this.ne.addAsset(asset);
		} else if (asset.isContainedIn(this.nw.region)) {
			this.nw.addAsset(asset);
		} else if (asset.isContainedIn(this.se.region)) {
			this.se.addAsset(asset);
		} else if (asset.isContainedIn(this.sw.region)) {
			this.sw.addAsset(asset);
		}
	}

	public Set<IAsset> getAssets() {
		Set<IAsset> allAssets = new HashSet<IAsset>();
		ArrayList<QTreeAssetManager> toDoList = new ArrayList<>();
		toDoList.add(this);
		while (!toDoList.isEmpty()) {
			QTreeAssetManager current = toDoList.get(0);
			toDoList.remove(0);

			for (IAsset iAsset : current.assets) {
				allAssets.add(iAsset);
			}
			if (current.ne != null)
				toDoList.add(current.ne);
			if (current.nw != null)
				toDoList.add(current.nw);
			if (current.se != null)
				toDoList.add(current.se);
			if (current.sw != null)
				toDoList.add(current.sw);
		}
		return allAssets;
	}

	public Set<IAsset> getAssets(BoundingBox region) {
		Set<IAsset> allAssets = new HashSet<IAsset>();
		ArrayList<QTreeAssetManager> toDoList = new ArrayList<>();
		toDoList.add(this);
		while (!toDoList.isEmpty()) {
			QTreeAssetManager current = toDoList.get(0);
			toDoList.remove(0);

			for (IAsset iAsset : current.assets) {
				if (iAsset.intersects(region)) {
					allAssets.add(iAsset);
				}
			}
			if (current.ne != null)
				if (region.intersects(current.getNEBoundingBox()))
					toDoList.add(current.ne);
			if (current.nw != null)
				if (region.intersects(current.getNWBoundingBox()))
					toDoList.add(current.nw);
			if (current.se != null)
				if (region.intersects(current.getSEBoundingBox()))
					toDoList.add(current.se);
			if (current.sw != null)
				if (region.intersects(current.getSWBoundingBox()))
					toDoList.add(current.sw);
		}
		return allAssets;
	}

	public static void main(String[] args) {
		QTreeAssetManager parent = new QTreeAssetManager(null, new BoundingBox(0, 0, 512, 512));
		parent.addAsset(new Asset("A1", new BoundingBox(40, 32, 50, 32)));
		parent.addAsset(new Asset("A2", new BoundingBox(96, 96, 96, 64)));
		parent.addAsset(new Asset("A3", new BoundingBox(110, 140, 40, 32)));
		parent.addAsset(new Asset("A4", new BoundingBox(224, 224, 132, 90)));
		parent.addAsset(new Asset("A5", new BoundingBox(0, 0, 512, 512)));

		// System.err.println(parent);
		parent.getAssets();
	}
}
