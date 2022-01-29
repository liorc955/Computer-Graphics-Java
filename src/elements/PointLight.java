package elements;
import java.awt.Color;
import Primitives.Point3D;
import Primitives.Util;
import Primitives.Vector;

public class PointLight extends Light {
	
	protected Point3D _position;
	protected double _kc, _kl, _kq;
	
	public PointLight() {
		super();
		this._position = new Point3D();
		this._kc = 0;
		this._kl = 0;
		this._kq = 0;
	}
	
	public PointLight(Point3D _position, double _kc, double _kl, double _kq, Color _intensity) {
		this._position = _position;
		this._kc = _kc;
		this._kl = _kl;
		this._kq = _kq;
		this._intensity = _intensity;
	}
	

	public PointLight(Color color, Point3D point3d, int i, double d, double e) {
		this._position = point3d;
		this._kc = i;
		this._kl = d;
		this._kq = e;
		this._intensity = color;
	}

	@Override
	public
	Color getIntensity(Point3D point) {
		double d = this._position.distance(point);
		double k = 1/(this._kc + (this._kl*d) + (this._kq*Math.pow(d, 2)));
		return Util.multColor(this._intensity, k);
	}

	@Override
	public
	Vector getL(Point3D point) {
		return this._position.subtract(point).normalize();
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(double _kc) {
		this._kc = _kc;
	}

	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kl() {
		return _kl;
	}

	public void set_kl(double _kl) {
		this._kl = _kl;
	}

	public double get_kq() {
		return _kq;
	}

	public void set_kq(double _kq) {
		this._kq = _kq;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof PointLight) { return true;}
		else { return false;}
	}
	
	String toStirng() {
		return this._position.toString() + this._kc + this._kl + this._kq;
	}

}
