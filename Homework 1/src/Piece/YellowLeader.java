package Piece;

import java.awt.*;

public class YellowLeader {

    private int row;
    private int col;

    public YellowLeader(int row, int col){

        this.row = row;
        this.col = col;
    }

    public void render (Graphics g){
        g.setColor(Color.YELLOW);
        g.drawRect(row,col,50,50);
        g.setColor(Color.YELLOW);
        g.fillRect(row,col,50,50);
    }


}
