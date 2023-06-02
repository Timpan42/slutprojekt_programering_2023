package client;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import javax.swing.*;

public class client extends tank {
    String n = "\n";
    String name = "";
    int healTimer;
    boolean move = true;
    boolean canShot = false;
    boolean gottShot = true;


    public client() {
        super();
    }

    public int getHealTimer() {
        return healTimer;
    }

    public void setHealTimer(int healTimer) {
        this.healTimer = healTimer;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isCanShot() {
        return canShot;
    }

    public void setCanShot(boolean canShot) {
        this.canShot = canShot;
    }

    public boolean isGottShot() {
        return gottShot;
    }

    public void setGottShot(boolean gottShot) {
        this.gottShot = gottShot;
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

    public void work(String w){
        System.out.println(w + n);
    }

    public void playerMove() {
        if (getWarPoints() >= 1) {
            // ska fixas senare
            move = true;
            if (move) {
                move();
                int x = getX();
                int y = getY();
                String input = JOptionPane.showInputDialog("Input w || a || s || d");
                input = input.toLowerCase();
                if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
                    if (input.equals("w")) {
                        setY(y - 50);
                        work("w Works");
                    } else if (input.equals("a")) {
                        setX(x - 50);
                        work("a Works");
                    } else if (input.equals("s")) {
                        setY(y + 50);
                        work("s Works");
                    } else {
                        setX(x + 50);
                        work("d Works");
                    }
                    move = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong input");
                }
            } else {
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
        canShot = true;
        if (canShot) {
            if (getWarPoints() >= 2) {
                shot();
                canShot = false;
            } else {
                needMore();
            }
        } else {
            System.out.println("could not shoot!");
        }
    }

    public void playerWasShot(){
        // ska fixas senare
        gottShot = true;
        if(gottShot){
            takeDamage();
            gottShot = false;
        }
    }

    public void playerDead(){
        if (getHp() <= 0){
            setLiving(false);
        }
    }
}
