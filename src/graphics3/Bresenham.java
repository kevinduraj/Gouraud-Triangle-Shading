/*
 * Drawing Line using Bresenham Algorithm
 * Advanced Computer Graphics
 * Written by: Kevin T. Duraj
 */
package graphics3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Bresenham Image Class
 */
public class Bresenham {

    int height;
    int width;
    
    public int[][][] image_final;
    public int[][][] image;

    public Bresenham(int width_p, int height_p, int r, int g, int b) {
        System.out.println("Superclass ...");
        this.width  = width_p;
        this.height = height_p;
        
        /*---------------- Image Final ------------------*/
        image_final = new int[3][height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                image_final[0][i][j] = -1; //(byte) r;
                image_final[1][i][j] = -1; //(byte) g;
                image_final[2][i][j] = -1; //(byte) b;

            }
        }
        /*---------------- Image 1 ------------------*/
        image = new int[3][height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                image[0][i][j] = (byte) r;
                image[1][i][j] = (byte) g;
                image[2][i][j] = (byte) b;

            }
        }
    }

    /*--------------------------------------------------------------------------
     * Drawing Line using Bresenham Algorithm
     */
    public void bresenhamLine(
                 int x0, int y0, int x1, int y1
                ,int red1, int green1, int blue1
                ,int red2, int green2, int blue2
            ) 
    {
        
        int delta_width = x1 - x0;
        int delta_height = y1 - y0;
        
        int dx0 = 0;
        int dy0 = 0;
        int dx1 = 0;
        int dy1 = 0;
        
        if (delta_width < 0) {
            dx0 = -1;
        } else if (delta_width > 0) {
            dx0 = 1;
        }
        if (delta_height < 0) {
            dy0 = -1;
        } else if (delta_height > 0) {
            dy0 = 1;
        }
        if (delta_width < 0) {
            dx1 = -1;
        } else if (delta_width > 0) {
            dx1 = 1;
        }
        
        int longest = Math.abs(delta_width);
        int shortest = Math.abs(delta_height);
        
        if (!(longest > shortest)) {
            longest = Math.abs(delta_height);
            shortest = Math.abs(delta_width);
            if (delta_height < 0) {
                dy1 = -1;
            } else if (delta_height > 0) {
                dy1 = 1;
            }
            dx1 = 0;
        }
        int numerator = longest >> 1;
        
        float r_step = (float) (red2-red1) / longest;
        float g_step = (float) (green2 - green1) / longest;
        float b_step = (float) (blue2 - blue1) / longest;
        
        //System.out.println("r_step=" + r_step + " g_step=" + g_step + " b_step=" + b_step);
        
        for (int i = 0; i <= longest; i++) {
            
            //System.out.println("Shortest=" + shortest);
            //System.out.println("Longest=" + longest + "\n");
            
            /*----------------------------------------------------------------*/
            /*                     Color Computation                          */
            double r = red1   + r_step * i;
            double g = green1 + g_step * i;
            double b = blue1  + b_step * i;
            
            //System.out.println("i=" + i + " red=" + r + " green=" + g + " blue=" + b);       
            set_pixel_final(x0, y0, (int)Math.abs(r), (int)Math.abs(g), (int)Math.abs(b));
            /*---------------------------------------------------------------*/
            
            numerator += shortest;
            if (!(numerator < longest)) {
                numerator -= longest;
                x0 += dx0;
                y0 += dy0;
            } else {
                x0 += dx1;
                y0 += dy1;
            }
        }
    }

    /*------------------------------------------------------------------------*/
    protected void set_pixel_final(int x, int y, int r, int g, int b) {
        
        //System.out.println("set_pixel(red=" + r + " green=" + g + " blue=" + b + ")"); 
        
        try {
            //System.out.println("y=" + x + " x=" + y);
            if (y > -1 && x > -1 && y < height && x < width) {
                image_final[0][y][x] =  r;
                image_final[1][y][x] =  g;
                image_final[2][y][x] =  b;
            }
        } catch (Exception e) {
            System.err.println("Exception: y=" + y + " x=" + x);
        }
    }
    
    /*--------------------------------------------------------------------------
     *  Move image_final into BufferedImage object then write Image into the File
     */
    public void write(String filename) {
        
        System.out.println("Writing image into: " + filename);
        
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    int pixel = (image_final[0][i][j] << 16) | (image_final[1][i][j] << 8) | (image_final[2][i][j]);
                    bi.setRGB(j, i, pixel);
                }
            }
            File outputfile = new File(filename);
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            System.out.println("Image write error");
        }
        System.out.println("Sucessfull");
    }
}
