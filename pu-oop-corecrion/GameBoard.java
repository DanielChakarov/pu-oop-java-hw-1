package Game;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {


    public GameBoard() {

        this.setTitle("Pharon Game");
        this.setSize(975, 975);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        for (int col = 0; col < 12; col++) {
            for (int row = 0; row < 12; row++) {

                GameTile tile = new GameTile(row * 80, col * 80);
                tile.render(g);

            }
        }
    }
}

