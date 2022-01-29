package Scene;
import elements.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Geometries.*;

public class Scene {
	private String nameOfpicture;
	private List<Geometry> geometries;
	private Camera _camera;
	private double _screenDistance;
	private Color _background;
	private AmbientLight _ambientLight;
	private List<Light> _lights;
	
	public Scene() {  // default constructor
		this.nameOfpicture = "";
		this.geometries = new ArrayList<Geometry>();
		this._screenDistance = 0;
		this._background = new Color(0,0,0);
		this._lights= new ArrayList<Light>();
		this._ambientLight = new AmbientLight();
	}
	
	public Scene(String nameOfpicture) {
		this.nameOfpicture = nameOfpicture;
		this.geometries = new ArrayList<Geometry>();
		this._background = new Color(0,0,0);
		this._screenDistance = 0;
		this._lights = new ArrayList<Light>();
		this._ambientLight = new AmbientLight();
	}
	public Scene(String nameOfpicture, List<Geometry> geometries, List<Light> _lights, Color color, double distance, AmbientLight _ambientLight) { // constructor with arguments
		this.nameOfpicture = nameOfpicture;
		this.geometries = geometries;
		this._background = color;
		this._screenDistance = distance;
		this._lights = _lights;
		this._ambientLight = _ambientLight;
	}
	
	public Scene(Scene scene) { // copy constructor
		this.nameOfpicture = scene.nameOfpicture;
		this.geometries = new ArrayList<Geometry>(scene.geometries);
		this._background = scene._background;
		this._screenDistance = scene._screenDistance;
		this._ambientLight = scene._ambientLight;
		this._lights = new ArrayList<Light>(scene._lights); 
	}
	
	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}
	
	public void addLight(Light light) {
		this._lights.add(light);
	}
	/* get and set methods */
	public List<Geometry> getGeometriesList(){
		return this.geometries;
	}

	public String getNameOfpicture() {
		return this.nameOfpicture;
	}

	public void setNameOfpicture(String nameOfpicture) {
		this.nameOfpicture = nameOfpicture;
	}
	
	public Camera get_camera() {
		return this._camera;
	}
	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}
	public boolean equals(Object otherObject) { // checking equal of object
		if(otherObject instanceof Scene) { return true;}
		else { return false;}
	}
	
	public String toString() {return "nameOfpicture:" + nameOfpicture + " geometries:" + Arrays.toString(geometries.toArray()) + " backg color:" + this._background + " distance:" + this._screenDistance;}

	public double getDistance() {
		return _screenDistance;
	}

	public void setDistance(double distance) {
		this._screenDistance = distance;
	}
	
	public void set_background(Color color) {
		this._background = color;
	}
	
	public Color get_background() {
		return this._background;
	}
	
	public AmbientLight getAmbientLight() {
		return this._ambientLight;
	}
	
	public void setAmbientLight(AmbientLight ambientLight) {
		this._ambientLight = ambientLight;
	}
	
	public List<Light> getLights(){
		return this._lights;
	}
	
	public void setLighs(List<Light> lights) {
		this._lights = lights;
	}
}
