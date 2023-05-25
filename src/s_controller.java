import javax.swing.*;
import java.awt.*;

public class s_controller {
    public server server;
    public draw bord;

    public s_controller(){
        bord = new draw("server");

        server = new server();
    }

}
