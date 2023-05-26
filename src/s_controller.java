import javax.swing.*;
import java.awt.*;

public class s_controller {
    public server server;
    public draw bord;

    public s_controller(){
        bord = new draw("server", false);

        server = new server();
        server.acceptClients();
        server.getStreams();
        server.runProtocol();
        server.msg();
    }

}
