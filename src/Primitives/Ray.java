package Primitives;

public class Ray  {
	private Point3D P00;
	private Vector direction;
	
	public Ray() { // default constructor
		this.P00 = new Point3D(); 
		this.direction = new Vector();
	}
	
	public Ray(Point3D p00, Vector direction) { // constructor with arguments
		this.P00 = p00;
		this.direction = direction.normalize();
	}
	
	public Ray(Ray ray) { // copy constructor
		this.P00 = new Point3D(ray.P00);
		this.direction = new Vector(ray.direction);
	}
	/* get and set methods */
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	public Point3D getP00() {
		return P00;
	}
	public void setP00(Point3D p00) {
		P00 = p00;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Ray) { return true;}
		else { return false;}
	}
	
	public String toString() {return "P00:" + P00 + "" + direction;}
	
}
