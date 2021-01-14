package Game;
import Piece.GreenGuard;
import Piece.GreenLeader;
import Piece.YellowGuard;
import Piece.YellowLeader;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame{

    public GameBoard(){

        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);


        for (int row = 0; row < 5; row++){
            for (int col = 0; col < 5;col++){

                GameTile tile = new GameTile(row * 100,col * 100);
                tile.render(g);

               for ( int a = 0; a < 4; a++ ){
                   YellowGuard yellowGuard = new YellowGuard(32,((a*100)+132));
                   yellowGuard.render(g);
               }
                YellowLeader yellowLeader = new YellowLeader(25,25);
               yellowLeader.render(g);

               for (int b = -1; b < 3;b++){
                   GreenGuard greenGuard = new GreenGuard(430,(b*100)+130);
                   greenGuard.render(g);
               }

                GreenLeader greenLeader = new GreenLeader(425,425);
               greenLeader.render(g);





                g.drawOval(230,230,41,41);
                g.setColor(Color.DARK_GRAY);
                g.fillOval(230,230,41,41);
            }
        }
    }
}
