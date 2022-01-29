package Geometries;
import java.awt.Color;
import java.util.List;
import Primitives.*;

public class Sphere extends Geometry {
	private Point3D center;
	private double radius;
	
	public Sphere() { // default constructor
		this.center = new Point3D();
		this.radius = 0;
		this._emission = new Color(255,0,0);
	}
	
	public Sphere(double radius, Point3D center, Color color) {   // constructor with arguments
		this.radius = radius;
		this.center = center;
		this._emission = color;
	}
	
	public Sphere(Sphere sphere) {  // copy constructor
		this.center = new Point3D(sphere.center);
		this.radius = sphere.radius;
		this._emission = sphere._emission;
	}
	/* get and set methods */
	public Point3D getCenter() {
		return center;
	}
	public void setCenter(Point3D center) {
		this.center = center;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double raduis) {
		this.radius = raduis;
	}

	public boolean equals(Object otherObject) {// checking equal of object
		if(otherObject instanceof Sphere) { return true;}
		else { return false;}
	}
	
	public String toString() {return "||Sphere|| center:" + center + " radious:" + radius + " color:" +this._emission;}

	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		Vector u = center.subtract(ray.getP00());
		double tM = ray.getDirection().dotProduct(u);
		      Point3D p0 = ray.getP00();
		       Point3D uHead=u.getHead();
		       double lengthSquared=uHead.getX().getCoordinate() * uHead.getX().getCoordinate() + //
		       uHead.getY().getCoordinate() * uHead.getY().getCoordinate() + //
		       uHead.getZ().getCoordinate() * uHead.getZ().getCoordinate();
		       double dSquared = Util.isZero(tM) ? lengthSquared : lengthSquared - tM * tM;
		       double thSquared = Util.alignZero(radius * radius - dSquared);
		       if (thSquared <= 0) return null;
		       double th = Math.sqrt(thSquared);
		       if (Util.isZero(th)) return null;
		       double t1 = Util.alignZero(tM + th);
		       if (t1 <= 0) return null;
		       double t2 = Util.alignZero(tM - th);
		if (t2 > 0)
		return Util.listOf(new GeoPoint(this,new Point3D(p0).add(ray.getDirection().scale(t1))),new GeoPoint(this,new Point3D(p0).add(ray.getDirection().scale(t2))));
		else
		return Util.listOf(new GeoPoint(this,new Point3D(p0).add(ray.getDirection().scale(t1))));
		}

	@Override
	public Vector getNormal(Point3D point) {
		
		return point.subtract(center).normalize();
	}
}
