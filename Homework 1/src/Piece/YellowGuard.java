package Piece;

import java.awt.*;

public class YellowGuard {

    private int row;
    private int col;

    public YellowGuard(int row, int col){

        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){

        g.setColor(Color.GREEN);
        g.drawOval(row,col,40,40);
        g.setColor(Color.YELLOW);
        g.fillOval(row,col,40,40);
    }

}
