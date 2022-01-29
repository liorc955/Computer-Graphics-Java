package Unittests;
import Geometries.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.awt.Color;

//import static org.junit.jupiter.api.Assertions.*;
import Primitives.*;
import org.junit.jupiter.api.Test;

//import geometries.*;
class testPlane {
	    @Test
	    public void testGetNormalPoint3D() {
	        // ============ Equivalence Partitions Tests ==============
	        // TC01: There is a simple single test here
	        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
	        double sqrt3 = Math.sqrt(1d / 3);
	        assertEquals("Bad normal to plane", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
	    }

	    @Test
	    public void testfindIntersectionsRay() {
	        Plane pl = new Plane(new Point3D(0, 0, 1), new Vector(1, 1, 1), new Color(0,0,0));
	        Sphere sl = new Sphere(1d, new Point3D(1, 0, 0), new Color(0,0,0));
	        // ============ Equivalence Partitions Tests ==============
	        // TC01: Ray into plane
	        
	                System.out.println(pl.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(1, 0, 0))));
	                System.out.println(sl.findIntersections(new Ray(new Point3D(1, -1, 0), new Vector(1, 1, 0))));
	        // TC02: Ray out of plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1, 0, 0))));

	        // =============== Boundary Values Tests ==================
	        // TC11: Ray parallel to plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(0, 1, -1))));

	        // TC12: Ray in plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(0, 1, -1))));

	        
	        // TC13: Orthogonal ray into plane
	        assertEquals("Bad plane intersection", Util.listOf( new Point3D(1d / 3, 1d / 3, 1d / 3)),
	                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1))));

	        // TC14: Orthogonal ray out of plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))));

	        // TC15: Orthogonal ray out of plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))));

	        // TC16: Orthogonal ray from plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 1))));

	        // TC17: Ray from plane
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 0))));

	        // TC18: Ray from plane's Q point
	        assertNull("Must not be plane intersection",
	                pl.findIntersections(new Ray(new Point3D(0, 0, 1), new Vector(1, 1, 0))));
	               
	    }

	}
