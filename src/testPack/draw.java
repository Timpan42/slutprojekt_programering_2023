package testPack;

import javax.swing.*;
import java.awt.*;

public class draw extends Canvas {

    private int canvasX = 600;
    private int canvasY = 600;
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;


    public static void main(String[] args) {
        int canvasX = 600;
        int canvasY = 600;
        JFrame frame = new JFrame("testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        if(shouldFill){
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }

        Canvas canvas = new draw();
        canvas.setSize(canvasX,canvasY);
        canvas.setBackground(new Color(69,72,100));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,20,0,20);
        frame.add(canvas, constraints);

        Button buttonReady = new Button("Ready");
        if (shouldWeightX) {
            constraints.weightx = 0.5;
        }
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonReady,constraints);

        Button buttonHeal = new Button("Heal");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonHeal, constraints);

        Button buttonMove = new Button("Move");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonMove, constraints);

        Button buttonAttack = new Button("Attack");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonAttack, constraints);

        frame.pack();
        frame.setVisible(true);

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
        linsX(gra,450);
        linsX(gra,500);
        linsX(gra,550);
        linsX(gra,600);

        //brädans linjer Y
        linsY(gra,50);
        linsY(gra,100);
        linsY(gra,150);
        linsY(gra,200);
        linsY(gra,250);
        linsY(gra,300);
        linsY(gra,350);
        linsY(gra,400);
        linsY(gra,450);
        linsY(gra,500);
        linsY(gra,550);
        linsY(gra,600);

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
