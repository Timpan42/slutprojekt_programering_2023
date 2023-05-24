package testPack;

import javax.swing.*;
import java.awt.*;

public class draw extends Canvas {

    private int canvasX = 400;
    private int canvasY = 400;

    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        Canvas canvas = new draw();
        canvas.setSize(400,400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.setBackground(new Color(69,72,100));
    }
    public void paint(Graphics gra){
        // brädans linjer X
        linsX(gra,50);
        linsX(gra,100);
        linsX(gra,150);
        linsX(gra,200);
        linsX(gra,250);
        linsX(gra,300);
        linsX(gra,350);
        linsX(gra,400);

        //brädans linjer Y
        linsY(gra,50);
        linsY(gra,100);
        linsY(gra,150);
        linsY(gra,200);
        linsY(gra,250);
        linsY(gra,300);
        linsY(gra,350);
        linsY(gra,400);

        // spelarnas karaktär
        players(gra,55, 55, 1);
        players(gra,55, 105, 2);
        players(gra,55, 155, 3);

        players(gra,155, 55, 4);
        players(gra,155, 105, 5);
        players(gra,155, 155, 6);

        players(gra,55, 305, 7);
        players(gra,105, 305, 8);
        players(gra,155, 305, 9);

        players(gra,5, 255, 10);
        players(gra,205, 255, 11);



    }

    public void linsX (Graphics gra, int x){
        gra.fillRect(x, 0, 5, canvasY);
    }

    public void linsY (Graphics gra, int y){
        gra.fillRect(0, y, canvasX, 5);
    }

    public void players(Graphics gra, int x, int y, int id){
        int playerId = id;
        gra.setColor(new Color(140,50,150));
        gra.fillRect(x,y,45,45);
    }

}
