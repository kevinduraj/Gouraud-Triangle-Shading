/*------------------------------------------------------------------------------
 * Drawing Hermite and Bezier Curves
 * Advanced Computer Graphics
 * Written by: Kevin T. Duraj
 */
package graphics3;

public class Shading {

    public static void main(String[] args) {

        int width  = 300;
        int height = 300;
        
        Triangle triangle = new Triangle(width, height, 0,0,0);
        
        int[] point1 = { 90, 43 };
        int[] point2 = { 105, 123 };
        int[] point3 = { 175, 76 };
        
        int[] color1 = { 128, 128 ,128};
        int[] color2 = { 255, 255, 255};
        int[] color3 = { 1, 1, 1 };
        
        //--- Rainbow colors
        //int[] color1 = { 255, 0 ,0};
        //int[] color2 = { 0, 255, 0 };
        //int[] color3 = { 0, 0, 255 };
        
        
        triangle.draw_triangle(point1, point2, point3, color1, color2,  color3);
        triangle.convert2background();
        triangle.write("/Users/ktd/Desktop/triangle.png");  
        
    }


}