package Piece;

import java.awt.*;

public class GreenLeader {

    private int row;
    private int col;

    public GreenLeader(int row, int col){

        this.row = row;
        this.col = col;
    }

    public void render (Graphics g){

        g.setColor(Color.GREEN);
        g.drawRect(row,col,50,50);
        g.setColor(Color.GREEN);
        g.fillRect(row,col,50,50);

    }

}
