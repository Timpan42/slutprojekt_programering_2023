import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class c_controller {
    clients clients;
    draw bord;
    int id;
    int x;
    int y;
    public c_controller(){
        clients = new clients();
        bord = new draw("clients", true);
        bord.setpId(1);
        bord.setpX(55);
        bord.setpY(55);
        clients.setWarPoints(3);



        bord.getButtonMove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateMovment();
                bord.repaint();

            }
        });

        clients.getStreams();
        clients.runProtocol();
        clients.msg();
    }

    public void UpdateMovment(){
        x = bord.getpX();
        y = bord.getpY();

        clients.setX(x);
        clients.setY(y);

        clients.playerMove();

        x = clients.getX();
        y = clients.getY();

        bord.setpX(x);
        bord.setpY(y);
    }
}
