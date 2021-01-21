package Game;
import java.awt.*;

/**
 * @author Даниел Чакъров
 * Клас, имплиментиращ изчертаванет и оцветяването на полето за игра
 */

public class GameTile {

    private int row;
    private int col;
    public static int TILE_SIZE;

        public GameTile(int row, int col){

            this.row       = row;
            this.col       = col;
            this.TILE_SIZE = 100;

        }


    /**
     * Метод за позициониране и изчертаване на фигурите и запъване с конкретният цвят
     */
     public void render(Graphics g){

            if (((col == 0 || col == 400)&& row == 0) || ((col == 100 || col == 300)&& row == 400)){
                g.setColor(Color.RED);
            }else if (((col == 100 || col == 300)&& row == 0) || ((col == 0 || col == 400)&& row == 400)){
                g.setColor(Color.darkGray);
            }else if ((col == 0 || col == 100 || col == 300 || col == 400)&& (row == 100 || row == 300 )){
                g.setColor(Color.gray);
            }else{
                g.setColor(Color.WHITE);
            }

// изчертаване на квадратната решетка
        g.drawRect(row,col,100,100);
        g.fillRect(row,col,100-1,100-1);

     }
    }


