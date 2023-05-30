import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class server {
    public String host = "localhost";
    public int port = 12345;
    public ServerSocket server;
    public Socket clients;
    public ObjectOutputStream serverOut;
    public ObjectInputStream serverIn;
    public String message;
    public int[] bordInfo = {0,0};
    public String playerInfoIn;

    /*
    try {

        } catch (IOException e){
            System.err.println("");
            e.printStackTrace();
         }
            System.out.println("");
    */

    public server() {
        try {
            server = new ServerSocket(port, 50, InetAddress.getByName(host));
        } catch (IOException e){
            System.err.println("Server: Kunde inte starta!");
            e.printStackTrace();
        }
        System.out.println("Server: Servern är startad ...");
    }

    // ta i mot clients
    public void acceptClients(){
        try {
            clients = server.accept();
            System.out.println(InetAddress.getByName(host));
        } catch (IOException e){
            System.err.println("Server: Did not accept clients!");
            e.printStackTrace();
        }
        System.out.println("Server: Clients accepted ...");
    }

    // Hämnta streams
    public void getStreams(){
        try {
            serverOut = new ObjectOutputStream(clients.getOutputStream());
            serverIn = new ObjectInputStream(clients.getInputStream());
        } catch (IOException e){
            System.err.println("Server: Did not get clients streams!");
            e.printStackTrace();
        }
        System.out.println("Server: Have server clients ...");
    }

    // Sätter meddelandet som ska skickas till client
    public void setMessage(String msg){
        message = msg;
    }

    // Skicka meddelandet till client
    public void sendMessage(){
        try {
            serverOut.writeObject(message);
            serverOut.flush();
        } catch (IOException e){
            System.err.println("Server: Kunde inte skicka msg!");
            e.printStackTrace();
        }
        System.out.println("Server: Kunde skicka msg ...");
    }

    // ta i mot playerInfon från client
    public void receivePlayerInfo(){
        try {
            if (serverIn.readObject() instanceof Integer[]){
                bordInfo = (int[]) serverIn.readObject();
            } else {
                playerInfoIn = (String) serverIn.readObject();
            }
            System.out.println(playerInfoIn);
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Server: Could not get PlayerInfo!");
            e.printStackTrace();
        }
        System.out.println("Server: Gott playerInfo ...");
    }
}
