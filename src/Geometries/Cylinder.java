package Geometries;
import java.awt.Color;
import java.util.List;

import Primitives.*;

public class Cylinder extends Geometry {
	private double radius;
	private Ray axis;
	private double height;
	
	public Cylinder() { // default constructor 
		this.radius = 0;
		this.axis = new Ray();
		this.height = 0;
		this._emission = new Color(255,0,0);
	}
	
	public Cylinder(double radius, Ray axis, double height, Color color) {  // constructor with arguments
		this.radius = radius;
		this.axis = axis;
		this.height = height;
		this._emission = color;
	}
	
	public Cylinder(Cylinder cylinder) { // copy constructor
		this.radius = cylinder.radius;
		this.height = cylinder.height;
		this.axis = new Ray(cylinder.axis);
		this._emission = cylinder._emission;
	}
	/* get and set method */
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Ray getAxis() {
		return axis;
	}
	public void setAxis(Ray axis) {
		this.axis = axis;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Cylinder) { return true;}
		else { return false;}
	}
	
	public String toString() {return "||Cylinder|| radius:" + radius + " axis:" + axis + " height:" + height + " color:" + this._emission;}

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
	
}
