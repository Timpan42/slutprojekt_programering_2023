import javax.swing.*;
import java.util.Locale;

public class client extends tank{
    String n = "\n";
    String name = "";
    int healTimer;
    public client() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void needMore(){
        System.out.println("need more warpoints!" + n);
    }

    public void playerMove() {
        if (getWarPoints() >= 1) {
            // ska fixas senare
            boolean move = true;

            if (move) {
                move();
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
            }else {
                System.out.println("cant move!");
            }
        } else {
            needMore();
        }
    }

    // klar
    public void playerHeal() {
        if (getHp() < 3 ){
            // ska fixa
            if (healTimer > 0) {
                if (getWarPoints() >= 2) {
                    heal();
                    healTimer = 2;
                } else {
                    needMore();
                }
            } else {
                System.out.println("can heal in " + healTimer + " rounds!");
            }
        } else {
            System.out.println("you are full health!" + n);
        }
    }

    public void playerShot() {
        // ska fixas senare
        boolean canShot = true;
        if (canShot) {
            if (getWarPoints() >= 2) {
                shot();
            } else {
                needMore();
            }
        } else {
            System.out.println("could not shoot!");
        }
    }

    public void playerWasShot(){
        // ska fixas senare
        boolean gottShot = true;
        if(gottShot){
            takeDamage();
        }
    }

    public void playerDead(){
        if (getHp() <= 0){
            setLiving(false);
        }
    }
}
