
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {

    Random random         = new Random();
    boolean isPhoneBroken = false;
    int amountOfBrokenPix = 0;
    private Object[][] pixels;

    String[] goodConditionPhone = new String[1];
    String[] badConditionPhone  = new String[1];
    char [] phoneNumber         = new char [10];
    String serialNumberSymbols  = "wk48u3hh1k";

    /**
     * Method visualising pixels in the game board
     */
    public void gameBoard(){
        this.pixels = new Object[64][64];
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
        this.setSize(585,585);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    /**
     * Method which paint paint the pixels in the game board
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
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

    /**
     * This method takes the coordinates of pixels
     */
    private int coordinates(int pixCoordinates){
        return pixCoordinates / Pixel.pixSize;
    }


    /**
     * Method which decide if pixel is broken or not
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(this.coordinates((e.getX())));
        System.out.println(this.coordinates((e.getY())));

        int col     = this.coordinates(e.getY());
        int row     = this.coordinates(e.getX());
        Color color = null;

        if (e.getClickCount() == 3){
            Random random = new Random();
            int ifPixIsBlack = random.nextInt(20);

            if (ifPixIsBlack %2 == 0){
                this.pixels[row][col] = new Pixel(row,col, Pixel.pixType,Color.BLACK);
                this.repaint();
                amountOfBrokenPix++;
            }
        }
            if (amountOfBrokenPix >= 2024){
                isPhoneBroken = true;
            }
    }

    public  void phoneCoondition (){
        if (isPhoneBroken){
            badConditionPhone[0] = serialNumberSymbols;
            System.out.println("The phone" +serialNumberSymbols+ "is broken");
        }else {
            goodConditionPhone[0] = serialNumberSymbols;
            System.out.println("The phone" +serialNumberSymbols+ "is good");
        }
    }

    /**
     * Method generated serial number for phones
     */
    public String serialNumberSetter(){
        int randomNum;
        for (int counter = 0; counter <= 10; counter++){
            randomNum = this.random.nextInt(10);
            this.phoneNumber[counter] = this.serialNumberSymbols.charAt(randomNum);
        }
        return new String(this.phoneNumber);
    }
}
