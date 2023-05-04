import javax.swing.*;
import java.util.Locale;

public class client extends tank{

    public client() {
        super();
    }
    public void movePlayer(){
        move();
        boolean move = true;
        if (move){
            int x = getX();
            int y = getY();
           String input = JOptionPane.showInputDialog("Input w || a || s || d");
           input = input.toLowerCase();
           if(input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
               if (input.equals("w")) {
                  setY(y-1);}
               else if (input.equals("a")) {
                   setX(x-1);
               }
               else if (input.equals("s")) {
                   setY(y+1);

               } else {
                   setX(x+1);
               }
           }else {
               JOptionPane.showMessageDialog(null,"Wrong input");
           }
        } else {
            setWarPoints(1);
        }
    }
}
