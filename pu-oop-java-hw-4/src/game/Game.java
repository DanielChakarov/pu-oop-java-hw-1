package game;

import game.Boxes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class Game extends JFrame implements MouseListener {

    Random random = new Random();
    private boxes[][] fields = new boxes[8][8];
    boxes selectedBox;

    public Game()  {
        gameView();
        super.addMouseListener(this);
        generateBoxes();
    }

    /**
     * Метод визуализиращ играта
     */
    private void gameView(){
        super.setSize(800, 800);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < fields.length; row++) {
            for (int col = 0; col < fields[row].length; col++) {
                boxes field = fields[row][col];
                try {
                    field.render(g);
                } catch (Exception exception) {
                    continue;
                }
            }
        }
    }

    /**
     * Метод генериращ полетата
     */
    private void generateBoxes() {
        generateStartingPosition(random);
        generateBlueBoxesTerritory(random);
        generateGreenBoxesTerritory(random);
        generateRedBoxesTerritory(random);
    }

    /**
     * Метод генериращ случайни полета
     */
    private boxes generateRandomField(int row, int col){
        return  random.nextInt(100)<20? new blueBoxes(row,col,Color.BLUE):new yellowBoxes(row,col, Color.YELLOW,"");
    }

    /**
     * Метод генериращ неоткритите полета "червен" в играта
     */
    private void generateRedBoxesTerritory(Random random) {

        int row;
        int col;

        for (int i = 0; i < 51; i++) {

            row = random.nextInt(8);
            col = random.nextInt(8);

            if (fields[row][col] != null) {
                i--;
                continue;
            }
            fields[row][col] = new redBoxes(row, col, Color.RED);
        }
    }

    /**
     * Метод генериращ непроходимте полета "сини" в играта
     */
    private void generateBlueBoxesTerritory(Random random) {

        int row;
        int col;

        for (int i = 0; i < 5; i++) {
            row = random.nextInt(8);
            col = random.nextInt(8);

            if (fields[row][col] != null) {
                i--;
                continue;
            }
            fields[row][col] = new blueBoxes(row, col, Color.BLUE);
        }
    }

    /**
     * Метод генериращ залените полета "зелени" в играта
     */
    private void generateGreenBoxesTerritory(Random random) {

        int row;
        int col;

        for (int j = 0; j < 8; j++) {
            row = random.nextInt(8);
            col = random.nextInt(8);

            if (fields[row][col] != null) {
                j--;
                continue;
            }
            greenBoxes coordinates = new greenBoxes(row, col, Color.GREEN);

            if (j == 5) {
                coordinates.setEnding(true);
            }
            fields[row][col] = coordinates;
        }
    }

    /**
     * Метод генериращ случайна стартова позиция
     */
    private void generateStartingPosition(Random random) {

        int[] randomStartPos = {0, 7};
        int randomCol = randomStartPos[random.nextInt(2)];
        int randomRow = randomStartPos[random.nextInt(2)];


        fields[randomRow][randomCol] = new yellowBoxes(randomRow, randomCol, Color.YELLOW,"");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = e.getY() / 100;
        int col = e.getX() / 100;

        boxes selected = fields[row][col];

        if (isValid(row, col)) {
            if (selectedBox != null) {

                if(selectedBox != selected){
                    return;
                }
                selectedBox      = null;
                fields[row][col] = generateRandomField(row,col);
            } else {

                if (!(selected instanceof blueBoxes)) {
                    selectedBox      = new yellowBoxes(row, col, Color.YELLOW,"?");
                    fields[row][col] = selectedBox;
                }

                if (selected instanceof greenBoxes) {
                    greenBoxes greenField=(greenBoxes) selected;
                    if (greenField.isEnding()) {
                        displayEnding();
                        selectedBox = null;

                    }
                }
            }
        }
        super.repaint();

    }

    /**
     * Метод показващ дисплей след края на играта
     */
    private void displayEnding() {

        JDialog dialog = new JDialog(this);

        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("Край на играта!"));

        dialog.setSize(250,250);
        dialog.setVisible(true);

        JButton restartButton = new JButton("Рестартиране");
        restartButton.addActionListener((i)-> gameRestarting());

        JButton closeButton = new JButton("Затваряне");
        closeButton.addActionListener((l)->System.exit(0));

        dialog.add(restartButton);
        dialog.add(closeButton);


    }

    /**
     * Метод рестартиращ играта
     */
    private void gameRestarting() {
        this.fields = new boxes[8][8];
        this.gameView();
        super.repaint();
        this.generateBoxes();
    }


    /**
     * Мвтод проверяващ дали движението е валидно
     */
    private boolean isValid(int row, int col) {

        int[][]coordinates ={{col,row - 1}, {col,row + 1}, {col + 1, row}, {col - 1, row}};

        for (int i = 0; i < coordinates.length; i++) {
            int nextPos = 0;

            int x = coordinates[i][nextPos];
            int y = coordinates[i][nextPos+1];

            try{
                if(fields[y][x] instanceof yellowBoxes){
                    return true;
                }
            }catch (Exception ignored){ }
        }


        return false;
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
}