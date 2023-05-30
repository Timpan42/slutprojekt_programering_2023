import javax.swing.*;
import java.awt.*;

public class draw extends Canvas {

    private int canvasX = 600;
    private int canvasY = 600;

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;

    public Canvas canvas;
    public Button buttonReady;
    public Button buttonHeal;
    public Button buttonMove;
    public Button buttonAttack;

    public int pX;
    public int pY;
    public int pId;

    public draw(String frameName, Boolean visible){
        JFrame frame = new JFrame(frameName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        canvas = new Canvas(){
            public void paint(Graphics gra){
                super.paint(gra);
                // brädans linjer X
                drawLinX(gra);
                //brädans linjer Y
                drawLinY(gra);
                // spelarnas karaktär
                drawPlayers(gra,pX,pY,pId);
            }
        };
        canvas.setSize(canvasX,canvasY);
        canvas.setBackground(new Color(69,72,100));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,20,0,20);
        frame.add(canvas, constraints);


        buttonReady = new Button("Ready");
        if (shouldWeightX) {
            constraints.weightx = 0.5;
        }
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonReady,constraints);

        buttonHeal = new Button("Heal");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonHeal, constraints);

        buttonMove = new Button("Move");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonMove, constraints);

        buttonAttack = new Button("Attack");
        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.insets = new Insets(10,100,10,100);
        frame.add(buttonAttack, constraints);

        frame.pack();
        frame.setVisible(visible);
        frame.setLocationRelativeTo(null);

    }

    public void startRepaint(){
        boolean startRepaint = true;
        if(startRepaint == true){
            System.out.println("För guds skull");
            repaint();
            startRepaint = false;
        }
    }


    public void drawLinX(Graphics gra){
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

    }

    public void drawLinY(Graphics gra){
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

    }

    public void drawPlayers(Graphics gra, int x, int y, int id){
        players(gra,x, y, id);

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

    public Button getButtonReady(){
        return buttonReady;
    }

    public Button getButtonMove(){
        return buttonMove;
    }

    public Button getButtonHeal(){
        return buttonHeal;
    }

    public Button getButtonAttack(){
        return buttonAttack;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int x) {
        this.pX = x;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int y) {
        this.pY = y;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int id) {
        this.pId = id;
    }
}
