package elements;
import java.awt.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class DirectionalLight extends Light {
	private Vector _direction;
	
	public DirectionalLight() {
	
		this._direction = new Vector();
	}
	
	public DirectionalLight(Vector _direction, Color _intensity) {
		this._direction = _direction.normalize();
		this._intensity = _intensity;
	}
	
	public void set_direction(Vector _direction) {
		this._direction = _direction.normalize();
	}
	
	public Vector get_direction() {
		return this._direction;
	}
	
	@Override
	public
	Color getIntensity(Point3D point) {
		return this._intensity;
	}

	@Override
	public
	Vector getL(Point3D point) {
		return this._direction;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof DirectionalLight) { return true;}
		else { return false;}
	}
	
	public String toString() {
		return this._direction.toString();
	}

}
