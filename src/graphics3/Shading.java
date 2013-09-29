/*------------------------------------------------------------------------------
 * Drawing Hermite and Bezier Curves
 * Advanced Computer Graphics
 * Written by: Kevin T. Duraj
 */
package graphics3;

public class Shading {

    public static void main(String[] args) {

        int width = 600;
        int height = 600;
        
        Triangle tr = new Triangle(width, height, 0,0,0);
        
        tr.bresenhamLine(100, 100, 500, 355, 0, 0, 0, 255, 255, 255);
        //tr.bresenhamLine(150, 159, 200, 400, 255, 255, 255, 128, 128, 128);
        //tr.bresenhamLine(200, 400, 400, 250, 255, 255, 255, 128, 128, 128);
        
        tr.write("/Users/ktd/Desktop/triangle.png");      
    }
}