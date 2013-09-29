package graphics3;

public class Triangle extends Bresenham {

    int left_point_x;
    int left_point_y;
    int left_color_r;
    int left_color_g;
    int left_color_b;
    
    int right_point_x;
    int right_point_y;
    int right_color_r;
    int right_color_g;
    int right_color_b;

    public Triangle(int width, int height, int red, int green, int blue) {
        super(width, height, red, green, blue);

    }

    public void display_values1() {

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {

                /*---------------------------------------------*/
                if (image_final[0][i][j] != -1) {
                    System.out.print(image_final[0][i][j] + " ");
                } else {
                    System.out.print(" ");
                }
                /*---------------------------------------------*/

            }
            System.out.println();
        }
    }

    public void find_right_point(int y) {

        for (int x = width-1; x > -1; x--) {

            if (image_final[0][y][x] != -1) {

                right_point_y = y;
                right_point_x = x;
                
                right_color_r=image_final[0][y][x];
                right_color_g=image_final[1][y][x];
                right_color_b=image_final[2][y][x];
                
                System.out.println("right point(y=" + y + " x=" + x + ")\n");
                break;

            }
        }
    }

    public void find_left_point() {

        for (int y = 0; y < height; y++) {
            
            for (int x = 0; x < width; x++) {

                if (image_final[0][y][x] != -1) {

                    left_point_y = y;
                    left_point_x = x;
                    
                    left_color_r=image_final[0][y][x];
                    left_color_g=image_final[1][y][x];
                    left_color_b=image_final[2][y][x];
                    
                    System.out.println("left point(y=" + y + " x=" + x + ")");
                    find_right_point(y);
                    
                    bresenhamLine(left_point_x, left_point_y
                                  ,right_point_x, right_point_y
                                  ,left_color_r,left_color_g,left_color_b
                                  ,right_color_r,right_color_g,right_color_b);
                    break;
                }
            }
        }
    }
}
