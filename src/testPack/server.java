package testPack;

import com.sun.corba.se.spi.activation.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
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

    }
}
