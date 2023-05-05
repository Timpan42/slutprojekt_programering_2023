import javax.swing.*;
import java.util.Locale;

public class client extends tank{
    String n = "\n";
    public client() {
        super();
    }

    public void needMore(){
        System.out.println("need more warpoints!" + n);
    }

    public void movePlayer() {
        if (getWarPoints() >= 1) {
            move();
            boolean move = true;
            if (move) {
                int x = getX();
                int y = getY();
                String input = JOptionPane.showInputDialog("Input w || a || s || d");
                input = input.toLowerCase();
                if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
                    if (input.equals("w")) {
                        setY(y - 1);
                    } else if (input.equals("a")) {
                        setX(x - 1);
                    } else if (input.equals("s")) {
                        setY(y + 1);

                    } else {
                        setX(x + 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong input");
                }
            } else {
                // could not move
                setWarPoints(1);
            }
        } else {
            needMore();
        }
    }

    public void healPlayer() {
        if (getHp() < 3 ){
            if (getWarPoints() >= 2){
                heal();
            }else {
                needMore();
            }
        } else {
            System.out.println("you are full health!" + n);
        }
    }
}
