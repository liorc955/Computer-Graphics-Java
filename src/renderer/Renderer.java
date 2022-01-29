package renderer;
import Scene.Scene;
import elements.Light;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Geometries.*;
import Primitives.*;

public class Renderer {
	private Scene _scene;
	private ImageWriter _imageWriter;
	private static final double EPS = 0.1;
	
	public Renderer() {
		this._scene = new Scene();
		this._imageWriter = new ImageWriter("", 0, 0, 0, 0);
	}
	
	public Renderer(Scene scene, ImageWriter imageWriter) {
		this._scene = scene;
		this._imageWriter = imageWriter;
	}
	
	
	public void renderImage() {
		int Nx = this._imageWriter.getNx();
		int Ny = this._imageWriter.getNy();
		
		for(int  i=0; i<Nx; i++) {
			for(int  j=0; j<Ny; j++) {
				Ray ray = this._scene.get_camera().constructRayThroughPixel(Nx, Ny, j, i, this._scene.getDistance(), this._imageWriter.getWidth(), this._imageWriter.getHeight());
					List<GeoPoint> intersectionPoints = getSceneRayIntersections(ray);
					if (intersectionPoints.isEmpty()) {
						_imageWriter.writePixel(j, i, this._scene.get_background());
					}else {
				     GeoPoint closestPoint = getClosestPoint(intersectionPoints);
				     _imageWriter.writePixel(j, i, calcColor(closestPoint));
					}
					
			}
		}
		_imageWriter.writeToImage();
	}
	
	private List<GeoPoint> getSceneRayIntersections(Ray ray){
		
		List<GeoPoint> intersectionPoints = new ArrayList<GeoPoint>();
		
		for  (Geometry geometry : this._scene.getGeometriesList()) {
			List<GeoPoint> geometryIntersectionPoints = geometry.findIntersections(ray);
			if (geometryIntersectionPoints == null) {} // not adding anything
			else {intersectionPoints.addAll(geometryIntersectionPoints);}
		}

		
		return intersectionPoints;
	}
	
	private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
		
		double distance = Double.MAX_VALUE;
		Point3D P0 = this._scene.get_camera().get_P0();
		GeoPoint minDistancePoint = null;
		for (GeoPoint point: intersectionPoints)
			if (P0.distance(point.getPoint()) < distance) {
				minDistancePoint = new GeoPoint(point.getGeometry(),new Point3D(point.getPoint()));
				distance = P0.distance(point.getPoint());
			}
				
		return minDistancePoint;
	}
	
	private Color calcColor(GeoPoint gp) {
		Color ambientLight = this._scene.getAmbientLight().getIntensity(gp.getPoint());
		Color emissionLight = gp.getGeometry().get_emission();
		Color diffuseLight = new Color(0,0,0);
		Color specularLight = new Color(0,0,0);
		List<Light> lights = this._scene.getLights();
		for (Light light: lights) {
			if(this.shaded(light, gp.getPoint(), light.getL(gp.getPoint()), gp.getGeometry().getNormal(gp.getPoint()))) {
			Color diffuseResult = this.calacDiffusiveComp(gp.getGeometry().getMaterial().getKd()
					, gp.getGeometry().getNormal(gp.getPoint())
					, light.getL(gp.getPoint()),
					light.getIntensity(gp.getPoint()));
			diffuseLight = Util.addColor(diffuseLight, diffuseResult);
			
			Color specularResult = this.calcSpecularComp(gp.getGeometry().getMaterial().getKs(),
					gp.getPoint().subtract(this._scene.get_camera().get_P0()).normalize(),
					gp.getGeometry().getNormal(gp.getPoint()),
					light.getL(gp.getPoint()), 
					gp.getGeometry().getMaterial().getShininess(), 
					light.getIntensity(gp.getPoint()));
			specularLight = Util.addColor(specularLight, specularResult);
			}
		}
		Color c1 = Util.addColor(ambientLight, emissionLight);
		Color c2 = Util.addColor(diffuseLight, specularLight);
		
		
		return Util.addColor(c1, c2);
	}
	
	private Color calacDiffusiveComp(double kd, Vector normal, Vector l, Color intensity){
		double m = normal.dotProduct(l);
		return Util.multColor(intensity, kd*m);
	}
	
	private Color calcSpecularComp(double ks,Vector v, Vector noraml ,Vector l,double n , Color intensity) {
		Vector r = l.subtract(((l.crossProduct(noraml)).crossProduct(noraml)).scale(2)).normalize();
		double m = Math.pow(v.dotProduct(r), n);
		return Util.multColor(intensity, ks*m);
	}
	
	private boolean shaded(Light light,Point3D point,Vector l,Vector n) {
		Vector lightDirection = l;
		Vector epsVector = n.scale(EPS);
		Point3D newPoint = point.add(epsVector);
		Ray shadowRay = new Ray(newPoint,lightDirection);
		List<GeoPoint> intersectionPoints = this.getSceneRayIntersections(shadowRay);
		if (intersectionPoints.isEmpty()) {
			return true;
		}
		else{return false;}
	}
	
	

	
	public ImageWriter get_imageWriter() {
		return _imageWriter;
	}
	public void set_imageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
	}
	public Scene get_scene() {
		return _scene;
	}
	public void set_scene(Scene _scene) {
		this._scene = _scene;
	}
	
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Renderer) { return true;}
		else { return false;}
	}
}
