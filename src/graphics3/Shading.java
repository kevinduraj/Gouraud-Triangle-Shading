/*------------------------------------------------------------------------------
 * Drawing Hermite and Bezier Curves
 * Advanced Computer Graphics
 * Written by: Kevin T. Duraj
 */
package graphics3;

public class Shading {

    public static void main(String[] args) {

        int width  = 250;
        int height = 250;
        
        Triangle tr = new Triangle(width, height, 0,0,0);
        
        tr.bresenhamLine(10, 20, 230, 140, 96, 96, 96, 224, 224, 224);
        tr.bresenhamLine(10, 20, 90, 220, 96, 96, 96, 96, 96, 96);
        tr.bresenhamLine(90, 220, 230, 140, 96, 96, 96, 224, 224, 224);
        
        tr.display_values1();
        
        tr.write("/Users/ktd/Desktop/triangle.png");      
    }
}