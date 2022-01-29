package Geometries;
import java.awt.Color;
import java.util.List;
import Primitives.*;

public  abstract class Geometry {
	protected Color _emission;
	public abstract List<GeoPoint> findIntersections(Ray ray);
	public abstract Vector getNormal(Point3D point);
	protected Material _material;
	
	public Material getMaterial() {
		return this._material;
	}
	public void setMaterial(Material material) {
		this._material = material;
	}
	public Color get_emission() {
		return _emission;
	}
	public void setColor_emission(Color color_emission) {
		this._emission = color_emission;
	}
	
}
