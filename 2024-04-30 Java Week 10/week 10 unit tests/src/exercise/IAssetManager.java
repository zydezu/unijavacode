package exercise;
import java.util.Set;

public abstract class IAssetManager {
	
	/**
	 * Adds an asset to the AssetManager.
	 * 
	 * @param asset
	 *            The asset to be added to the AssetManager
	 * 
	 * @throws IllegalArgumentException
	 *             if the area covered by the asset is outside or partly outside
	 *             the area of the AssetManager.
	 */
	public abstract void addAsset(IAsset asset);

	/**
	 * Return all assets managed by the asset manager, i.e. asset added via the
	 * addAsset method. An empty set if the asset manager does not have any
	 * asset.
	 * 
	 * @return all assets managed by the asset manager, an empty set if the
	 *         asset manager does not have any asset.
	 */
	public Set<IAsset> getAssets(){
		return null;
	}

	/**
	 * Return all assets managed by the asset manager (i.e. asset added via the
	 * addAsset method) that intersect the BoundingBox region. The asset just
	 * need to intersect the region to be returned, it does not need to be fully
	 * contained in region. Returns an empty set if the asset manager does not
	 * have any asset intersecting that region.
	 * 
	 * @param region
	 *            a bounding box representing the area to be search for existing
	 *            asset
	 * 
	 * @return all assets managed by the asset manager that intersect the
	 *         BoundingBox region, an empty set if the asset manager does not
	 *         have any asset intersecting the BoundingBox region.
	 */
	public Set<IAsset> getAssets(BoundingBox region){
		return null;
	}
}
