package Unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import elements.Camera;


public class testCamera {

    
    @Test
    public void testConstructRayThroughPixel() {
        Camera camera = new Camera(new Point3D(), new Vector(0, 0, 1), new Vector(0, -1, 0));
        // ============ Equivalence Partitions Tests ==============
        // TC01: 3X3 Corner (0,0)
       
                System.out.println(camera.constructRayThroughPixel(3, 3, 0, 0, 1, 9, 9));
        
        // TC02: 4X4 Corner (0,0)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(-3, -3, 10).normalize()),
                camera.constructRayThroughPixel(4, 4, 0, 0, 10, 8, 8));

        // TC03: 4X4 Side (0,1)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(-1, -3, 10).normalize()),
                camera.constructRayThroughPixel(4, 4, 1, 0, 10, 8, 8));

        // TC04: 4X4 Inside (1,1)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(-1, -1, 10).normalize()),
                camera.constructRayThroughPixel(4, 4, 1, 1, 10, 8, 8));
        
        // =============== Boundary Values Tests ==================
        // TC11: 3X3 Center (1,1)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(0, 0, 10).normalize()),
                camera.constructRayThroughPixel(3, 3, 1, 1, 10, 6, 6));

        // TC12: 3X3 Center of Upper Side (0,1)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(0, -2, 10).normalize()),
                camera.constructRayThroughPixel(3, 3, 1, 0, 10, 6, 6));

        // TC13: 3X3 Center of Left Side (1,0)
        assertEquals("Bad ray", new Ray(new Point3D(), new Vector(-2, 0, 10).normalize()),
                camera.constructRayThroughPixel(3, 3, 0, 1, 10, 6, 6));
        
        
    }

}
