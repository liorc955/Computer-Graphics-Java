package Unittests;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import elements.*;
import Geometries.*;
import Primitives.*;
import renderer.*;
import Scene.Scene;

class testLights {
	
	private Scene scene;
	private Geometry sphere;

	void sphereTests()
	{
		scene = new Scene("Test scene");
		scene.set_camera(new Camera(new Point3D(0, 0, -200), new Vector(0, 0, 1), new Vector(0, -1, 0)));
		scene.setDistance(200); //
		scene.set_background(Color.BLACK);
		scene.setAmbientLight(new AmbientLight(0.15,Color.WHITE));

		sphere = new Sphere(500, new Point3D(0, 0, 500),Color.BLUE); 
		sphere.setMaterial(new Material(1,1,100));
		scene.addGeometry(sphere);

	}

	/**
	 * Produce a picture of a sphere lighted by a Ambient Light only
	 */
	@Test
	public void sphereAmbient() {
		sphereTests();
		ImageWriter imageWriter = new ImageWriter("sphereAmbient", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene, imageWriter);
		render.renderImage();
	}

	/**
	 * Produce a picture of a sphere lighted by a directional light
	 */
	@Test
	public void sphereDirectional() {
		sphereTests();
		
		scene.addLight(new DirectionalLight(new Vector(5,-100,-40), new Color(255, 100, 100)));
		ImageWriter imageWriter = new ImageWriter("sphereDirectional", 500, 500, 500, 500);
		
		Renderer render = new Renderer(scene, imageWriter);
		render.renderImage();
	}

	/**
		 * Produce a picture of a sphere lighted by a point light
		 */
		@Test
		public void spherePoint() {
			sphereTests();

			scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),  1, 0.00001, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("spherePoint", 500, 500, 500, 500);
			
			Renderer render = new Renderer(scene, imageWriter);
			render.renderImage();
		}
		/**
		 * Produce a picture of a sphere lighted by a spot light
		 */
		@Test
		public void sphereSpot() {
			sphereTests();
			
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),new Vector(-80,-10,-90),  1, 0.00001, 0.000005));
		
			ImageWriter imageWriter = new ImageWriter("sphereSpot", 500, 500, 500, 500);
			
			Renderer render = new Renderer(scene, imageWriter);
			render.renderImage();
		}
		
		@Test
		void sphereTests1()
		{
			scene = new Scene("Test scene");
			scene.set_camera(new Camera(new Point3D(0, 0, -200), new Vector(0, 0, 1), new Vector(0, -1, 0)));
			scene.setDistance(200); //
			scene.set_background(Color.BLACK);
			scene.setAmbientLight(new AmbientLight(0.15,Color.WHITE));
			sphere = new Sphere(500, new Point3D(0, 0, 600),new Color(255,102,0));
			Sphere sphere1 = new Sphere(150, new Point3D(-100, 80, 100),new Color(255,0,0));
			Sphere sphere2 = new Sphere(140, new Point3D(200, 80, 170),Color.BLUE);
			sphere.setMaterial(new Material(1,1,200));
			scene.addGeometry(sphere);
			sphere1.setMaterial(new Material(1,1,1));
			scene.addGeometry(sphere1);
			sphere2.setMaterial(new Material(0,1,1));
			scene.addGeometry(sphere2);
			scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),  1, 0.00001, 0.000005));
			scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, 200, -250),new Vector(-80,-10,-90),  1, 0.00001, 0.000005));
			scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 300, 20),  1, 0.00001, 0.000005));
			Triangle triangle = new Triangle(new Point3D(-200, 400, 260),
					 new Point3D(-225, 400, 260),
					 new Point3D(-225, 400, 270),
					 new Color (0, 0, 100));
			Material m2=new Material(1,1,4);
			triangle.setMaterial(m2);
			scene.addGeometry(triangle);
			
	

			
				ImageWriter imageWriter = new ImageWriter("sphereSpot12", 500, 500, 500, 500);
				
				Renderer render = new Renderer(scene, imageWriter);
				render.renderImage();
			}
		
	}

