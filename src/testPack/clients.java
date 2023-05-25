package testPack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
    try {

        } catch (IOException e){
            System.err.println("");
            e.printStackTrace();
         }
            System.err.println("");
    */

public class clients {
    public Socket server;
    public ObjectOutputStream clientOut;
    public ObjectInputStream clientIn;

    public int port = 12345;
    public String ip = "127.0.0.1";

    public clients(){
        try {
            server = new Socket(ip, port);

        } catch (IOException e){
            System.err.println("Clients: Kunde inte koppla till servern!");
            e.printStackTrace();
        }
        System.err.println("Clients: kopplad till servern ...");
    }

    public void getStreams(){
        try {
            clientIn = new ObjectInputStream(server.getInputStream());
            clientOut = new ObjectOutputStream(server.getOutputStream());
        } catch (IOException e){
            System.err.println("Client: Did not get server streams!");
            e.printStackTrace();
        }
        System.err.println("Client: Have server streams ...");
    }
    public void runProtocol(){
        try {
            String messageOut = "Hej server";
            clientOut.writeObject(messageOut);
            clientOut.flush();
        } catch (IOException e){
            System.err.println("Clients: Kunde inte skicka msg!");
            e.printStackTrace();
        }
        System.err.println("Clients: Kunde skicka msg ...");

    }

}
