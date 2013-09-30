/*------------------------------------------------------------------------------
 * Drawing Hermite and Bezier Curves
 * Advanced Computer Graphics
 * Written by: Kevin T. Duraj
 */
package graphics3;

public class Shading {

    public static void main(String[] args) {

        int width  = 640;
        int height = 640;
        
        Triangle tr = new Triangle(width, height, 0,0,0);
        
        int[] point1 = { 100, 170 };
        int[] point2 = { 330, 240 };
        int[] point3 = { 190, 320 };
        
        int[] color1 = { 255, 0 ,0};
        int[] color2 = { 0, 255, 0 };
        int[] color3 = { 0, 0, 255 };
        
        tr.bresenhamLine(point1[0], point1[1],  point2[0], point2[1]
                , color1[0], color1[1], color1[2]
                , color2[0], color2[1], color2[2]);
        
        tr.bresenhamLine(point1[0], point1[1],  point3[0], point3[1]
                , color1[0], color1[1], color1[2]
                , color3[0], color3[1], color3[2]);
        
        tr.bresenhamLine(point2[0], point2[1], point3[0], point3[1]
                , color2[0], color2[1], color2[2]
                , color3[0], color3[1], color3[2]);
        
        //tr.display_values1();
        tr.find_left_point();
        
        tr.write("/Users/ktd/Desktop/triangle.png");      
    }
}