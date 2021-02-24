import java.awt.*;

public class Pixel {

    private int row;
    private int col;
    public static int pixType;
    public static int pixSize = 9;
    Color color;

    public Pixel(int row, int col, int pixType,Color color){
        this.row     = row;
        this.col     = col;
        this.pixType = pixType;
        this.color   = color;

    }

    public void render (Graphics g){
        int tileX = this.col*pixSize;
        int tileY = this.row*pixSize;
        g.setColor(this.color);
        g.fillRect(tileX,tileY,pixSize,pixSize);
    }

}
