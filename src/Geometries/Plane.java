package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.*;

public class Plane extends Geometry {
	private Point3D q;
	private Vector n;
	
	public Plane() { // default constructor 
		this.q = new Point3D();
		this.n = new Vector();
		this._emission = new Color(255,0,0);
	}
	
	public Plane(Point3D q, Vector n, Color color) { // constructor with arguments
		this.q = new Point3D(q);
		this.n = n.normalize();
		this._emission = color;
	}
	
	public Plane(Plane plane) { // copy constructor
		this.q = new Point3D(plane.q); 
		this.n = new Vector(plane.n); 
		this._emission = plane._emission;
	}
	
	public Plane(Point3D p1, Point3D p2, Point3D p3) {
        // if p1=p2 or p1=p3 - an exception will be thrown
        Vector v1 = p1.subtract(p2);
        Vector v2 = p1.subtract(p3);

      // if the points are in the same line - X-product will throw an exception
        n = v1.crossProduct(v2).normalize();
        q = new Point3D(p1);
    }
	
	
	/* get and set methods */
	public Point3D getQ() {
		return q;
	}
	public void setQ(Point3D q) {
		this.q = q;
	}
	public Vector getN() {
		return n;
	}
	public void setN(Vector n) {
		this.n = n;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Plane) { return true;}
		else { return false;}
	}
	
	public String toString() {return "||Plane|| q:" + q + " n:" + n +" color:" + this._emission;}

	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		double numerator;
		try {
		numerator = n.dotProduct(this.q.subtract(ray.getP00()));
		} catch (IllegalArgumentException e) { return null; }
		double denominator = n.dotProduct(ray.getDirection());
		double t = numerator / denominator;
		if (t<0 || denominator == 0 || t==0 ) { return null;}
		Point3D point = ray.getP00().add(ray.getDirection().scale(t));
		List<GeoPoint> listOfPoints = new ArrayList<GeoPoint>();
		listOfPoints.add(new GeoPoint(this,point));
		return listOfPoints;
	}

	@Override
	public Vector getNormal(Point3D point) {
		return n;
	}

}
