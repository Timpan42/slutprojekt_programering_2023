package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
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
    public int[] bordInfo = {0, 0};
    public String playerInfoIn;

    public ArrayList<s_clientHandler> clients = new ArrayList<>();
    public int clientNumber;
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
        } catch (IOException e) {
            System.err.println("Server: Kunde inte starta!");
            e.printStackTrace();
        }
        System.out.println("Server: Servern är startad ...");
    }

    // ta i mot client.clients
    public void acceptClients() {
        try {
            while (true) {
                client = server.accept();
                s_clientHandler cH = new s_clientHandler(client, clientNumber);
                clients.add(cH);
                pool.execute(cH);
                clientNumber += 1;
                System.out.println("Server: Clients accepted ...");
            }
        } catch (IOException e) {
            System.err.println("Server: Did not accept client.clients!");
            e.printStackTrace();
        }
    }

    // Hämnta streams
    /*
    public void getStreams(){
        try {
            serverOut = new ObjectOutputStream(client.clients.getOutputStream());
            serverIn = new ObjectInputStream(client.clients.getInputStream());
        } catch (IOException e){
            System.err.println("Server: Did not get client.clients streams!");
            e.printStackTrace();
        }
        System.out.println("Server: Have server.server streams ...");
    }
*/

    // Sätter meddelandet som ska skickas till client.client
    public void setMessage(String msg) {
        message = msg;
    }

    // Skicka meddelandet till client.client
    public void sendMessage() {
        try {
            serverOut.writeObject(message);
            serverOut.flush();
        } catch (IOException e) {
            System.err.println("Server: Kunde inte skicka msg!");
            e.printStackTrace();
        }
        System.out.println("Server: Kunde skicka msg ...");
    }
}