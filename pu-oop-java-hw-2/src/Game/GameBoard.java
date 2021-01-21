package Game;
import Piece.greenGuard;
import Piece.greenLeader;
import Piece.yellowGuard;
import Piece.yellowLeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Даниел Чакъров
 * Клас, имплиментиращ логиката на играта, дижението на  иралните фигури
 * */

public class GameBoard extends JFrame implements MouseListener {

    public final int TILE_COUNT = 5;

    private Object[][] pieceCollection;

    public GameBoard() {
        this.pieceCollection = new Object[TILE_COUNT][TILE_COUNT];

        //  позиции на зелени фиури
        this.pieceCollection[0][0] = (new greenGuard(0, 0));
        this.pieceCollection[0][1] = (new greenGuard(0, 1));
        this.pieceCollection[0][2] = (new greenGuard(0, 2));
        this.pieceCollection[0][3] = (new greenGuard(0, 3));
        this.pieceCollection[0][4] = (new greenLeader(0, 4));

        // позиции на жълти фигури
        this.pieceCollection[4][0] = (new yellowLeader(4, 0));
        this.pieceCollection[4][1] = (new yellowGuard(4, 1));
        this.pieceCollection[4][2] = (new yellowGuard(4, 2));
        this.pieceCollection[4][3] = (new yellowGuard(4, 3));
        this.pieceCollection[4][4] = (new yellowGuard(4, 4));


        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println( this.figureCoordinates(e.getX()));
        System.out.println( + this.figureCoordinates(e.getY()));

        int row = this.figureCoordinates(e.getY());
        int col = this.figureCoordinates(e.getX());

        if (this.selectedPosition != null) {
            greenGuard gGuard = (greenGuard) this.selectedPosition;
            gGuard.moveFigure(row, col);
            this.selectedPosition = null;
            this.repaint();
        }

        if (this.selectedPosition != null) {
            yellowGuard yGuard = (yellowGuard) this.selectedPosition;
            yGuard.moveFigure(row, col);
            this.selectedPosition = null;
            this.repaint();
        }

        if (this.selectedPosition != null) {
            greenLeader greenLeader = (greenLeader) this.selectedPosition;
            greenLeader.moveFigure(row, col);
            this.selectedPosition = null;
            this.repaint();
        }

        if (this.selectedPosition != null) {
            yellowLeader yLeader = (yellowLeader) this.selectedPosition;
            yLeader.moveFigure(row, col);
            this.selectedPosition = null;
            this.repaint();
        }

       if( this.hasBoardPosition(row,col)){
        this.selectedPosition = this.getBoardPosition(row,col);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Метод чрез който се оцветяват
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                GameTile tile = new GameTile(row * 100, col * 100);
                tile.render(g);

                for (int a = 0; a < 4; a++) {
                    yellowGuard yellowGuard = new yellowGuard(32, ((a * 100) + 132));
                    yellowGuard.render(g);
                }
                yellowLeader yellowLeader = new yellowLeader(25, 25);
                yellowLeader.render(g);

                for (int b = -1; b < 3; b++) {
                    greenGuard greenGuard = new greenGuard(430, (b * 100) + 130);
                    greenGuard.render(g);
                }

                greenLeader greenLeader = new greenLeader(425, 425);
                greenLeader.render(g);


                g.drawOval(230, 230, 41, 41);
                g.setColor(Color.DARK_GRAY);
                g.fillOval(230, 230, 41, 41);
            }
        }
    }

    private Object selectedPosition;

    /**
     * Метод за провеяване дали изпраната позиция е заета
     */
    private boolean hasBoardPosition(int row, int col) {
        return this.getBoardPosition(row, col) != null;
    }


    private Object getBoardPosition(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private int figureCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }



}
