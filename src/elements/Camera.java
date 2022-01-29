package elements;

import Primitives.*;

public class Camera {
 private Point3D _P0;
 private Vector _vup;
 private Vector _vto;
 private Vector _vright;

public Camera() { //default constructor
	this._P0 = new Point3D(0,0,0);
	this._vto = new Vector(0,0,0);
	this._vup = new Vector(0,0,0);
	this._vright = new Vector(0,0,0);
}

public Camera(Point3D _P0, Vector vTo, Vector vUp) {
	this._P0 = _P0;
	this._vto = vTo;
	this._vup = vUp;
	this._vright = vTo.crossProduct(vUp);
}

public Point3D get_P0() {
	return _P0;
}

public void set_P0(Point3D _P0) {
	this._P0 = _P0;
}

public Vector get_vup() {
	return _vup;
}

public void set_vup(Vector _vup) {
	this._vup = _vup;
}


public Vector get_vto() {
	return _vto;
}

public void set_vto(Vector _vto) {
	this._vto = _vto;
}

public void set_vRight(Vector _vright) {
	this._vright = _vright;
}

public Vector get_vRight() {
	return this._vright;
}

public boolean equals(Object otherObject) { // checking equal of object
	if(otherObject instanceof Camera) { return true;}
	else { return false;}
}
public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight) {
	// image center
	Point3D pointCenter = this._P0.add(this._vto.scale(screenDistance));
	// Ratio (pixel width & height)
	double Ry = screenHeight / nY;
	double Rx = screenWidth / nX;
	// Pixel[i,j] center
	double yI = (i-nY/2)*Ry + Ry/2;
	double xJ = (j-nX/2)*Rx + Rx/2;
	Point3D pIJ = pointCenter.add(this._vright.scale(xJ).subtract(this._vup.scale(yI)));
	pIJ = pointCenter;
	if (xJ != 0) pIJ = pIJ.add(_vright.scale(xJ));
	if (yI != 0) pIJ = pIJ.add(_vup.scale(-yI));
	Vector _direction = pIJ.subtract(this._P0).normalize();
	return new Ray(this._P0,_direction);
}

public String toString() {
	return "_P0:" + this._P0 + " _vup:" + this._vup + " _vright:" + this._vright + " _vto:" + this._vto;
}

}
