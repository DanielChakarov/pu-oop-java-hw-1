package Piece;
import java.awt.*;

/**
 * @author Даниел Чакъров
 * Клас имплиментиращ разполоцението на фигурите (зелени пазачи) и техния цвят върху игралната дъска
 */
public class greenGuard {

    private int row;
    private int col;


    public greenGuard(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void render(Graphics g){

        g.setColor(Color.yellow);
        g.drawOval(row,col,40,40);
        g.setColor(Color.GREEN);
        g.fillOval(row,col,40,40);
    }

    public void moveFigure(int row, int col){
        this.row = row;
        this.col = col;
    }
}
