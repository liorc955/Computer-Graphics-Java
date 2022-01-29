package Primitives;
import java.lang.Math;

public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;
	
	public Point3D() { // default constructor
		this.x = new Coordinate();
		this.y = new Coordinate();
		this.z = new Coordinate();
	}
	
	public Point3D(double x, double y, double z) { // constructor with arguments
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}
	
	public Point3D(Point3D point3D) { // copy constructor
		this.x = new Coordinate(point3D.x);
		this.y = new Coordinate(point3D.y);
		this.z = new Coordinate(point3D.z);
	}
	/* get and set methods */
	public Coordinate getX() {
		return x;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public Coordinate getY() {
		return y;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	public Coordinate getZ() {
		return z;
	}
	public void setZ(Coordinate z) {
		this.z = z;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Point3D) { return true;}
		else { return false;}
	}
	
	public Point3D add(Vector v) { // add vector and point3D
		double resultOfx = this.getX().getCoordinate() + v.getHead().getX().getCoordinate();
		double resultOfy = this.getY().getCoordinate() + v.getHead().getY().getCoordinate();
		double resultOfz = this.getZ().getCoordinate() + v.getHead().getZ().getCoordinate();
		return new Point3D(resultOfx,resultOfy,resultOfz);
	}
	
	public Vector subtract(Point3D other) { // subtract two point
		double resultOfx = this.getX().getCoordinate() - other.getX().getCoordinate();
		double resultOfy = this.getY().getCoordinate() - other.getY().getCoordinate();
		double resultOfz = this.getZ().getCoordinate() - other.getZ().getCoordinate();
		if (resultOfx == 0 && resultOfy == 0 && resultOfz == 0) {
			throw new IllegalArgumentException();
		}
		return new Vector(resultOfx,resultOfy,resultOfz);
	}
	public double distance(Point3D other) { // calculate distance between points
		int pow = 2;
		double resulOfx = Math.pow(this.getX().getCoordinate() - other.getX().getCoordinate(), pow);
		double resultOfy = Math.pow(this.getY().getCoordinate() - other.getY().getCoordinate(), pow);
		double resultOfz = Math.pow(this.getZ().getCoordinate() - other.getZ().getCoordinate(), pow);
		return Math.sqrt(resulOfx+resultOfy+resultOfz);
	}
	public String toString() {return "( " + x + ", " + y + ", " + z + " )";}
	
}
