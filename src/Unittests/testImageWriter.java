package Unittests;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import renderer.ImageWriter;

class testImageWriter {

    @Test
    public void test() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 == 0 || i % 50 == 0 ? new Color(255,0,0) : new Color(255,255,0));
        
        imageWriter.writeToImage();
    }
    
    @Test
    public void test2() {
        ImageWriter imageWriter = new ImageWriter("imgWriterTest2", 1600, 1000, 800, 500);
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i, Color.black);
        
        for (int i = 40; i < 500; ++i)
        	for (int j = 40 ; j < 730; ++j)
                imageWriter.writePixel(j,i, Color.white);
        
        for (int i = 130; i < 135; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 100; i < 165; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 200; i < 265; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 300; i < 365; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 400; i < 465; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 500; i < 565; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 600; i < 665; ++i)
        	for (int j = 0 ; j < 300; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 230; i < 235; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 330; i < 335; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 430; i < 435; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 530; i < 535; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
       
        for (int i = 630; i < 635; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
        
        for (int i = 630; i < 635; ++i)
        	for (int j = 0 ; j < 500; ++j)
                imageWriter.writePixel(i,j, Color.black);
      
      
       
        
        imageWriter.writeToImage();
    }
}
