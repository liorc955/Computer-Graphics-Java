package Primitives;
import java.lang.Math;

public class Vector {
	private Point3D head;
	private double x,y,z;
	
	public Vector() { // default constructor
		this.head = new Point3D();
		this.x = this.getHead().getX().getCoordinate();
		this.y = this.getHead().getY().getCoordinate();
		this.z = this.getHead().getZ().getCoordinate();
	}
	
	public Vector(double x, double y, double z) { // constructor with arguments
		this.head = new Point3D(x,y,z);
		if (x==0 && y==0 && z==0)
			throw new IllegalArgumentException("Zero vector is not allowed");

		this.x = this.getHead().getX().getCoordinate();
		this.y = this.getHead().getY().getCoordinate();
		this.z = this.getHead().getZ().getCoordinate();
	}
	
	public Vector(Point3D p) {
		if (p.getX().getCoordinate() == 0 && p.getY().getCoordinate() == 0 && p.getZ().getCoordinate() == 0)
			throw new IllegalArgumentException("Zero vector is not allowed");
		head = new Point3D(p);
	}

	
	public Vector(Vector vector) { // copy constructor
		this.head = new Point3D(vector.head);
	}
	/* get and set methods */
	public Point3D getHead() {
		return head;
	}

	public void setHead(Point3D head) {
		this.head = head;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Vector) { return true;}
		else { return false;}
	}
	
	public double length() { // calculate length of vector
		int pow = 2;
		double resultOfx = Math.pow(this.x, pow);
		double resultOfy = Math.pow(this.y, pow);
		double resultOfz = Math.pow(this.z, pow);
		return Math.sqrt(resultOfx+resultOfy+resultOfz);
	}
	
	public Vector normalize() { // calculate normalize of vector
		double resultOfx = this.x / this.length();
		double resultOfy = this.y / this.length();
		double resultOfz = this.z / this.length();
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	
	public Vector add(Vector other) throws IllegalArgumentException { // calculate add of two vectors
		double resultOfx = this.x + other.getHead().getX().getCoordinate();
		double resultOfy = this.y + other.getHead().getY().getCoordinate();
		double resultOfz = this.z + other.getHead().getZ().getCoordinate();
		if (resultOfx == 0 && resultOfy == 0 && resultOfz == 0) {
			throw new IllegalArgumentException();
		}
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	
	public Vector subtract(Vector other) throws IllegalArgumentException { // calculate subtract of two vectors
		double resultOfx = this.x - other.getHead().getX().getCoordinate();
		double resultOfy = this.y - other.getHead().getY().getCoordinate();
		double resultOfz = this.z - other.getHead().getZ().getCoordinate();
		if (resultOfx == 0 && resultOfy == 0 && resultOfz == 0) {
			throw new IllegalArgumentException();
		}
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	
	public Vector scale(double scalar) throws IllegalArgumentException { // calculate scale of vector
		if (scalar == 0) {
			throw new IllegalArgumentException();
		}
		double resultOfx = this.x * scalar;
		double resultOfy = this.y * scalar;
		double resultOfz = this.z * scalar;
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	
	public Vector crossProduct(Vector other) { // calculate crossProduct of vector
		double resultOfx = this.y * other.getHead().getZ().getCoordinate();
		resultOfx -= z * other.getHead().getY().getCoordinate();
		double resultOfy = z * other.getHead().getX().getCoordinate();
		resultOfy -= x * other.getHead().getZ().getCoordinate();
		double resultOfz = x * other.getHead().getY().getCoordinate();
		resultOfz -= y * other.getHead().getX().getCoordinate();
		if (resultOfx == 0 && resultOfy == 0 && resultOfz == 0) {
			throw new IllegalArgumentException();
		}
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	
	public double dotProduct(Vector other) { // calculate dotProduct of vector
		double resultOfx = this.x * other.getHead().getX().getCoordinate();
		double resultOfy = this.y * other.getHead().getY().getCoordinate();
		double resultOfz = this.z * other.getHead().getZ().getCoordinate();
		return resultOfx + resultOfy + resultOfz;
	}
	
	public String toString() {return " Head point:" + head;}
	
}
