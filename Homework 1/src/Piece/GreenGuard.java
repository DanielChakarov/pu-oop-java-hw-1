package Piece;

import java.awt.*;

public class GreenGuard {

    private int row;
    private int col;


    public GreenGuard(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){

        g.setColor(Color.yellow);
        g.drawOval(row,col,40,40);
        g.setColor(Color.GREEN);
        g.fillOval(row,col,40,40);
    }
}
