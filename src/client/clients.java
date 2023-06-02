package client;

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
            System.out.println("");
    */

public class clients extends client {
    public Socket server;
    public ObjectOutputStream clientOut;
    public ObjectInputStream clientIn;

    public int port = 12345;
    public String ip = "127.0.0.1";

    public String playerInfo = "R";
    public int[] bordXY = {0,0};

    public clients(){
        super();
        try {
            server = new Socket(ip, port);
        } catch (IOException e){
            System.err.println("Clients: Kunde inte koppla till servern!");
            e.printStackTrace();
        }
        System.out.println("Clients: kopplad till servern ...");
    }

    // Hämnta streams
    public void getStreams(){
        try {
            clientOut = new ObjectOutputStream(server.getOutputStream());
            clientIn = new ObjectInputStream(server.getInputStream());
        } catch (IOException e){
            System.err.println("Client: Did not get server.server streams!");
            e.printStackTrace();
        }
        System.out.println("Client: Have server.server streams ...");
    }


    // Sätter meddelandet som ska skickas till servern
    public void setPayerInfo(String info){
        playerInfo = info;
    }

    // Hämntar playerInfo
    public String getPlayerInfo(){
        return playerInfo;
    }

    // Skicka playerInfo till servern
    public void sendInfo(){
        try {
            clientOut.writeObject(playerInfo);
            clientOut.flush();
        } catch (IOException e){
            System.err.println("Clients: PlayerInfo Kunde inte skickas!");
            e.printStackTrace();
        }
        System.out.println("Clients: PlayerInfo kunde skickas ...");
    }

    // Sätter spelbrädan som ska skickas till servern
    public void setBordXY(int x, int y){
        bordXY = new int[]{x, y};
    }

    // Skicka spelbrädan till servern
    public void sendBordInfo(){
        try {
            clientOut.writeObject(bordXY);
            clientOut.flush();
        } catch (IOException e){
            System.err.println("Clients: BordInfo kunde inte skickas!");
            e.printStackTrace();
        }
        System.out.println("Clients: BordInfo kunde skickas ...");
    }

    // Hämntar meddelandet som servern som skickade
    public void serverMessage(){
        try {
            int msgIn = (int) clientIn.readObject();
            System.out.println(msgIn);
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Could not get msg");
            e.printStackTrace();
        }
        System.out.println("Gott msg");
    }
}

/* kode som inte funkar.
Object input = clientIn.readObject();
            if (input instanceof Integer[]) {
                serverIntArray = (int[]) input;
                System.out.println(serverIntArray);
            } else if (input instanceof Integer) {
                serverInt = (int) clientIn.readObject();
                System.out.println(serverInt);
            } else if (input instanceof String){
                serverString = (String) input;
                System.out.println(serverString);
            }
*/
