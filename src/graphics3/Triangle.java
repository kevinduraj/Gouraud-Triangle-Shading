package graphics3;

public class Triangle extends Bresenham {

    public Triangle(int width, int height, int red, int green, int blue) {
        super(width, height, red, green, blue);

    }

    public void display_values1() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                
                
                System.out.print(image_final[0][i][j] + " ");
                
            }
            System.out.println();
        }
    }
}
