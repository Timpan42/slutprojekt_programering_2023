package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_controller {
    clients clients;
    draw bord;

    public c_controller(String clientNamn){
        clients = new clients();
        bord = new draw(clientNamn, true);

        clients.setWarPoints(3);

        bord.setpId(1);
        bord.setpX(5);
        bord.setpY(5);

        clients.getStreams();


        bord.getButtonReady().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerIsReady();
                clients.serverMessage();
            }
        });

        bord.getButtonHeal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerHealed();
            }
        });


        bord.getButtonMove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateMovement();
                bord.startRepaint();
            }
        });
        bord.getButtonAttack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAttack();

            }
        });
    }

    // ska skicka en signal till servern som säger att spelaren är redo för nästa runda
    public void playerIsReady(){
        if (clients.getPlayerInfo().equals("M")){
            clients.sendBordInfo();
        }
        clients.sendInfo();
        bord.setGreyButton(false);
        System.out.println(clients.getPlayerInfo());
    }

    // ska ge HP till spelaren om den kan
    public void playerHealed(){
        clients.playerHeal();
        clients.setPayerInfo("H");
        bord.setGreyButton(false);
    }

    // ska skicka en signal till servern med information om vars spelaren har rört på sig
    public void UpdateMovement(){

        System.out.println("\n" + "new Movement");
        int x;
        int y;

        x = bord.getpX();
        System.out.println("bord x: " + x);
        y = bord.getpY();
        System.out.println("bord y: " + y);

        clients.setX(x);
        clients.setY(y);

        clients.playerMove();

        x = clients.getX();
        System.out.println("clients x: "+ x);
        y = clients.getY();
        System.out.println("clients y: " + y);

        bord.setpX(x);
        bord.setpY(y);

        x = bord.getpX();
        System.out.println("bord x: " + x);
        y = bord.getpY();
        System.out.println("bord y: " + y);

        clients.setBordXY(x,y);
        clients.setPayerInfo("M");
        bord.setGreyButton(false);
    }

    // ska skicka en signal till servern så den kan kolla om spelaren kan attackera någon annan.
    public void playerAttack(){
        clients.setPayerInfo("A");
        bord.setGreyButton(false);

    }
}
