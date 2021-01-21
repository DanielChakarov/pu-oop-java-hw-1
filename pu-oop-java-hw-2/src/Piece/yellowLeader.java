package Piece;
import java.awt.*;

/**
 * @author Даниел Чакъров
 * Клас имплиментиращ разполоцението на фигурите  (зелени пазачи) и техния цввят върху игралната дъска
 */

public class yellowLeader {

    private int row;
    private int col;

    public yellowLeader(int row, int col){

        this.row = row;
        this.col = col;
    }

    public void render (Graphics g){
        g.setColor(Color.YELLOW);
        g.drawRect(row,col,50,50);
        g.setColor(Color.YELLOW);
        g.fillRect(row,col,50,50);
    }

    public void moveFigure(int row, int col){
        this.row=row;
        this.col=col;
    }

}
