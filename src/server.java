import java.io.*;
import java.lang.reflect.Executable;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    public String host = "localhost";
    public int port = 12345;

    public ServerSocket server;
    public Socket client;

    public ObjectOutputStream serverOut;
    public ObjectInputStream serverIn;

    public String message;
    public int[] bordInfo = {0,0};
    public String playerInfoIn;

    public ArrayList<s_clientHandler> clients = new ArrayList<>();
    public ExecutorService pool = Executors.newFixedThreadPool(8);

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
            while (true){
                client = server.accept();
                s_clientHandler clientHandler = new s_clientHandler(client);
                clients.add(clientHandler);
                pool.execute(clientHandler);

            }
        } catch (IOException e){
            System.err.println("Server: Did not accept clients!");
            e.printStackTrace();
        }
        System.out.println("Server: Clients accepted ...");
    }

    // Hämnta streams
    /*
    public void getStreams(){
        try {
            serverOut = new ObjectOutputStream(clients.getOutputStream());
            serverIn = new ObjectInputStream(clients.getInputStream());
        } catch (IOException e){
            System.err.println("Server: Did not get clients streams!");
            e.printStackTrace();
        }
        System.out.println("Server: Have server streams ...");
    }
*/

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
                System.out.println("Funkar? 2");
                bordInfo = (int[]) serverIn.readObject();
            } else {
                System.out.println("Funkar? 3");
                playerInfoIn = (String) serverIn.readObject();
            }
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Server: Could not get PlayerInfo!");
            e.printStackTrace();
        }
        System.out.println("Server: Gott playerInfo ...");
    }

    public void playerRequest(){
        if(playerInfoIn.equals("M")){
            System.out.println("Server: "+ bordInfo + " ...");
        } else if (playerInfoIn.equals("A")){
            System.out.println("Server: Attack ...");
        } else if (playerInfoIn.equals("H")){
            System.out.println("Server: Heal ... ");
        } else {
            System.out.println("Server: Player achieved nothing ...");
        }
    }

    public void sendBord(){

    }
}
