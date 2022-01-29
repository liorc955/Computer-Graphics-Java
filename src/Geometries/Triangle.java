package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Primitives.*;

public class Triangle extends Geometry { 
	private Point3D p1;
	private Point3D p2;
	private Point3D p3;
	
	public Triangle() {  // default constructor 
		this.p1 = new Point3D();
		this.p2 = new Point3D();
		this.p3 = new Point3D();
		this._emission = new Color(255,0,0);
	}
	
	public Triangle(Point3D p1,Point3D p2,Point3D p3, Color color) { // constructor with arguments
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this._emission =  color;
	}
	
	public Triangle(Triangle triangle) { // copy constructor
		this.p1 = new Point3D(triangle.p1);
		this.p2 = new Point3D(triangle.p2);
		this.p3 = new Point3D(triangle.p3);
		this._emission = triangle._emission;
	}
	/* get and set methods */
	public Point3D getP1() {
		return p1;
	}
	public void setP1(Point3D p1) {
		this.p1 = p1;
	}
	public Point3D getP2() {
		return p2;
	}
	public void setP2(Point3D p2) {
		this.p2 = p2;
	}
	public Point3D getP3() {
		return p3;
	}
	public void setP3(Point3D p3) {
		this.p3 = p3;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Triangle) { return true;}
		else { return false;}
	}
	
	public String toString() {return "||Triangle|| Point 1: " + p1 + " Point 2:" + p2 + " Point 3:" + p3 + " color:" + this._emission;}

	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		Vector v1 = this.p1.subtract(ray.getP00());
		Vector v2 = this.p2.subtract(ray.getP00());
		Vector v3 = this.p3.subtract(ray.getP00());
		Vector n1 = v1.crossProduct(v2).normalize();
		Vector n2 = v2.crossProduct(v3).normalize();
		Vector n3 = v3.crossProduct(v1).normalize();
		double checkN1 = ray.getDirection().dotProduct(n1);
		double checkN2 = ray.getDirection().dotProduct(n2);
		double checkN3 = ray.getDirection().dotProduct(n3);
		// check if the point is in the triangle 
		if (checkN1 == 0 || checkN2 == 0 || checkN3 == 0) {return null;}
		if ((checkN1 > 0 && checkN2 > 0 && checkN3 > 0) || (checkN1 < 0 && checkN2 < 0 && checkN3 < 0)) {
		Point3D q = new Point3D(p1);
		Vector n = this.getNormal(p1);
		double t = (n.dotProduct(q.subtract(ray.getP00()))) / n.dotProduct(ray.getDirection());
		List<GeoPoint> points = new ArrayList<GeoPoint>();
		Point3D point = ray.getP00().add(ray.getDirection().scale(t));
		points.add(new GeoPoint(this,point));
		return points;
		} else { return null; }
	}

	@Override
	public Vector getNormal(Point3D point) {
		 Vector v1 = p1.subtract(p2);
	        Vector v2 = p1.subtract(p3);
	        
	      // if the points are in the same line - X-product will throw an exception
	        return v1.crossProduct(v2).normalize();
	}
}
