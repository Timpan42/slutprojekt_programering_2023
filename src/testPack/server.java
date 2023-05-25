package testPack;

import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.*;

public class server {
    public String host = "localhost";
    public int port = 12345;
    public ServerSocket server;
    public Socket clients;
    public ObjectOutputStream serverOut;
    public ObjectInputStream serverIn;

    /*
    try {

        } catch (IOException e){
            System.err.println("");
            e.printStackTrace();
         }
            System.err.println("");
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

    public void getStreams(){
        try {
            serverIn = new ObjectInputStream(clients.getInputStream());
            serverOut = new ObjectOutputStream(clients.getOutputStream());
        } catch (IOException e){
            System.err.println("Server: Did not get clients streams!");
            e.printStackTrace();
        }
        System.err.println("Server: Have server clients ...");
    }

    public void runProtocol(){
        try {
            String messageOut = "Hej clients";
            serverOut.writeObject(messageOut);
            serverOut.flush();
        } catch (IOException e){
            System.err.println("Server: Kunde inte skicka msg!");
            e.printStackTrace();
        }
        System.err.println("Server: Kunde skicka msg ...");

    }



    public static void main(String[] args) throws Exception {
        server s = new server();
       // s.acceptClients();
        System.out.println(InetAddress.getByName(s.host));



        /*
        String host = "localhost";
        int port = 12345;

        ServerSocket server = new ServerSocket(port,50, InetAddress.getByName(host));
        System.out.println("Server started");
        Socket client = new Socket(host, port);
        System.out.println("Connecting to testPack.server");
        Socket connection = server.accept();
        System.out.println("Connection established.");

        ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
        ObjectOutputStream serverOut = new ObjectOutputStream(connection.getOutputStream());
        ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
        ObjectInputStream serverIn = new ObjectInputStream(connection.getInputStream());

        System.out.println("Communication is ready.");

        String messageOut = "Nej";
        clientOut.writeObject(messageOut);
        clientOut.flush();
        System.out.println("Send to testPack.server: " + messageOut);

        String messageIn = (String) serverIn.readObject();
        System.out.println("Server got: " + messageIn);

        clientOut.close();
        serverOut.close();
        System.out.println("Connections closed.");

        server.close();
        System.out.println("Server terminated.");

        System.out.println(InetAddress.getByName(host));
*/
    }
}
