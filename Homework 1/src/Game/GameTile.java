package Game;

import java.awt.*;

public class GameTile {

    private int row;
    private int col;

        public GameTile(int row, int col){

            this.row = row;
            this.col = col;

        }
     public void render(Graphics g){

            if (((col == 0 || col == 400)&& row == 0) || ((col == 100 || col == 300)&& row == 400)){
                g.setColor(Color.RED);
            }else if (((col == 100 || col == 300)&& row == 0) || ((col == 0 || col == 400)&& row == 400)){
                g.setColor(Color.darkGray);
            }else if ((col == 0 || col == 100 || col == 300 || col == 400)&& (row == 100 || row == 300 )){
                g.setColor(Color.gray);
            }else{
                g.setColor(Color.WHITE);
            }


        g.drawRect(row,col,100,100);
        g.fillRect(row,col,100-1,100-1);

     }
    }


