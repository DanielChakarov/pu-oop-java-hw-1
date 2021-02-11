package game.Boxes;

import java.awt.*;

public abstract class boxes {

    private int y;
    private int x;
    private Color color;

    public boxes(int y, int x, Color color) {
        this.color = color;
        this.x = x * 100;
        this.y = y * 100;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 100, 100);
        g.setColor(Color.black);
        g.drawRect(x, y, 100, 100);
    }


}