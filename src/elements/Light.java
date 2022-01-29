package elements;
import java.awt.Color;
import Primitives.*;

public abstract class Light {
protected Color _intensity;

public Light() {
	this._intensity = new Color(0,0,0);
}

public Light(Color intensity) {
	this._intensity = intensity;
}

public Color getIntensityLight() {
	return this._intensity;
}

public void setIntensity(Color intensity) {
	this._intensity = intensity;
}

public abstract Color getIntensity(Point3D point);
public abstract Vector getL(Point3D point);
}
