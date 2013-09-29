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
        
        tr.bresenhamLine(150, 159, 400, 250, 96, 96, 96, 224, 224, 224);
        tr.bresenhamLine(150, 159, 200, 400, 96, 96, 96, 96, 96, 96);
        tr.bresenhamLine(200, 400, 400, 250, 96, 96, 96, 224, 224, 224);
        
        tr.write("/Users/ktd/Desktop/triangle.png");      
    }
}