package Piece;
import java.awt.*;

/**
 * @author Даниел Чакъров
 * Клас имплиментиращ разполоцението на фигурите (зелен лидер) и техния цвят върху игралната дъска
 */
public class greenLeader {

    private int row;
    private int col;

    public greenLeader(int row, int col){

        this.row = row;
        this.col = col;
    }

    public void render (Graphics g){

        g.setColor(Color.GREEN);
        g.drawRect(row,col,50,50);
        g.setColor(Color.GREEN);
        g.fillRect(row,col,50,50);

    }

    public void moveFigure(int row, int col){
        this.row=row;
        this.col=col;
    }
}
