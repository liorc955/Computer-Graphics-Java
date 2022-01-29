package elements;
import java.awt.Color;
import Primitives.*;

public class SpotLight extends PointLight {
	
	private Vector _direction;
	
	public SpotLight() {
		super();
		this._direction = new Vector();
	}
	
	public SpotLight(Vector _direction, Color _intensity) {
		this._direction = _direction.normalize();
		this._intensity = _intensity;
	}

	public SpotLight(Color color, Point3D point3d, Vector vector, double i, double d, double e) {
		this._direction = vector.normalize();
		this._intensity = color;
		this._kc = i;
		this._kl = d;
		this._kq = e;
		this._position = point3d;
	}

	@Override
	public
	Color getIntensity(Point3D point) {
		double d = this._position.distance(point);
		Vector l = this.getL(point);
		double m = this._direction.dotProduct(l);
		double k = 1/(this._kc + (this._kl*d) + (this._kq*Math.pow(d, 2)));
		return Util.multColor(this._intensity, Math.max(0,m) * k);
	}

	@Override
	public
	Vector getL(Point3D point) {
		return this._position.subtract(point).normalize();
	}

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction.normalize();
	}
	
	public String toString() {
		return this._direction.toString();
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof SpotLight) { return true;}
		else { return false;}
	}

}
