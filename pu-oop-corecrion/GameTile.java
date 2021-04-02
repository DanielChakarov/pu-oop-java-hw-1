package Game;

import java.awt.*;

public class GameTile {

    private int row;
    private int col;

    public GameTile(int row, int col) {

        this.row = row;
        this.col = col;
    }

    public void render(Graphics g) {

        for (int col = 1; col <= 12; col++) {
            for (int row = 1; row <= 12; row++) {
                g.setColor(Color.white );
            }
            g.drawRect(row, this.col, 80, 80);
            g.fillRect(row, this.col, 80 - 3, 80 - 3);

        }
    }
}