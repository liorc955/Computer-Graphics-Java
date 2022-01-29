package elements;
import java.awt.Color;
import Primitives.*;

public class AmbientLight extends Light {
	private double _ka;
	
	public AmbientLight() {
		super();
		this.set_ka(0.1);
	}
	
	public AmbientLight(double _ka, Color _intensity) {
		this.set_ka(_ka);
		this._intensity = _intensity;
	}

	@Override
	public
	Color getIntensity(Point3D point) {
		return Util.multColor(this._intensity, this._ka);
	}

	@Override
	public
	Vector getL(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	public double get_ka() {
		return _ka;
	}

	public void set_ka(double _ka) {
		this._ka = _ka;
	}
	
	public String toString() {
		return "the ka is:" + this._ka;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof AmbientLight) { return true;}
		else { return false;}
	}

}
