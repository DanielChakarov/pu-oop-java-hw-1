
package game.Boxes;

import java.awt.*;

public class greenBoxes extends boxes {
    private boolean isEnding;

    public greenBoxes(int y, int x, Color color) {
        super(y, x, color);

    }

    public boolean isEnding() {
        return isEnding;
    }

    public greenBoxes setEnding(boolean ending) {
        isEnding = ending;
        return this;
    }
}