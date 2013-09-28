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
        tr.bresenhamLine(150, 159, 400, 250, 255, 255, 255);
        tr.bresenhamLine(150, 159, 200, 400, 255, 255, 255);
        tr.bresenhamLine(200, 400, 400, 250, 255, 255, 255);
        tr.write("/Users/ktd/Desktop/triangle.png");
        
        /*        
         * System.out.println("Processing Bezier Curve ...");
         * Bezier bezier = new Bezier(image_width, image_height, 0, 0, 0);
         * 
         * int[] Point0 = { 93,  239 };
         * int[] Point1 = { 207, 150 };
         * int[] Point2 = { 150, 350 };
         * int[] Point3 = { 339, 249 };
         * 
         * bezier.steps(Point0, Point1, Point2, Point3, Step);
         * bezier.write("/Users/ktd/Desktop/bezier.png"); */       
    }
}