package Geometries;
import java.awt.Color;
import java.util.*; 
import Primitives.*;
import Primitives.Vector;

public class Polygon extends Geometry {
	private List<Point3D> points;
	
	public Polygon() { // default constructor 
		this.points = new ArrayList<Point3D>();
		this._emission = new Color(255,0,0);
	}
	
	public Polygon(List<Point3D> points,Color color) { // constructor with arguments
		this.points = points;
		this._emission = color;
	}
	
	public Polygon(Polygon polygon) { // copy constructor
		this.points = new ArrayList<Point3D>(polygon.points);
		this._emission = polygon._emission;
	}
	/* get and set methods */
	public List<Point3D> getPoints() {
		return points;
	}

	public void setPoints(List<Point3D> points) {
		this.points = points;
	}

	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Polygon) { return true;}
		else { return false;}
	}
	
	public String toString() {return "||Polygon|| points:" + Arrays.toString(points.toArray()) + " color:" + this._emission;}

	@Override
	public List<GeoPoint> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Polygon(Point3D... vertices) {
		if (vertices.length < 3)
			throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
		List<Point3D> _vertices = Util.listOf(vertices);
		Plane _plane = new Plane(vertices[0], vertices[1], vertices[2]);
		if (vertices.length == 3)
			return; // no need for more tests for a Triangle

		Vector n = _plane.getNormal(new Point3D());

		Vector edge1 = vertices[vertices.length - 1].subtract(vertices[vertices.length - 2]);
		Vector edge2 = vertices[0].subtract(vertices[vertices.length - 1]);
		boolean positive = edge1.crossProduct(edge2).dotProduct(n) > 0;
		for (int i = 1; i < vertices.length; ++i) {
			if (!Util.isZero(vertices[i].subtract(vertices[0]).dotProduct(n)))
				throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
			edge1 = edge2;
			edge2 = vertices[i].subtract(vertices[i - 1]);
			if (positive != (edge1.crossProduct(edge2).dotProduct(n) > 0))
				throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
		}
	}

}
