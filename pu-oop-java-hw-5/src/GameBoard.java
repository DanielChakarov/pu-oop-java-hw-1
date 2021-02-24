import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {

    Random random = new Random();
    private Object[][] pixels;

    public void gameBoard(){
        Color color       = null;
        int typeOfPixels  = random.nextInt(3);
        int generatePixel = random.nextInt(3);

        this.pixels = new Object[64][64];

        for (int row = 0; row < 64; row++){
            for (int col = 0; col < 64; col++){

                switch (generatePixel) {
                    case 0:
                        this.pixels[row][col] = new Pixel(row,col,typeOfPixels,color.GREEN);
                    break;

                    case 1:
                        this.pixels[row][col] = new Pixel(row,col,typeOfPixels,color.RED);
                    break;

                    case 2:
                        this.pixels[row][col] = new Pixel(row,col,typeOfPixels,color.BLUE);
                    break;
                }
                generatePixel = random.nextInt(3);
                typeOfPixels  = random.nextInt(3);
            }
        }


        this.setTitle("Pixels Game");
        this.setSize(600,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.update(g);
        for (int row = 0; row < 64; row++){
            for (int col = 0; col < 64; col++){
                Pixel p = (Pixel) this.getPixel(row,col);
                p.render(g);
            }
        }
    }

    private  Object getPixel(int row, int col){
        return this.pixels[row][col];
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
