import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class s_clientHandler implements Runnable {
    private Socket clients;
    private ObjectOutputStream serverOut;
    private ObjectInputStream serverIn;
    public int[] bordInfo = {0, 0};
    public String playerInfoIn;

    public s_clientHandler(Socket clientsSocket) throws IOException {
        this.clients = clientsSocket;
        serverIn = new ObjectInputStream(clients.getInputStream());
        serverOut = new ObjectOutputStream(clients.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                receivePlayerInfo();
                playerRequest();
            }
        } finally {
            try {
                serverOut.close();
                serverIn.close();
            } catch (IOException e) {

            }
        }

    }

    public void receivePlayerInfo() {
        try {
            if (serverIn.readObject() instanceof Integer[]) {
                System.out.println("Funkar? 2");
                bordInfo = (int[]) serverIn.readObject();
            } else {
                System.out.println("Funkar? 3");
                playerInfoIn = (String) serverIn.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Server: Could not get PlayerInfo!");
            e.printStackTrace();
        }
        System.out.println("Server: Gott playerInfo ...");
    }

    public void playerRequest() {
        if (playerInfoIn.equals("M")) {
            System.out.println("Server: " + bordInfo + " ...");
        } else if (playerInfoIn.equals("A")) {
            System.out.println("Server: Attack ...");
        } else if (playerInfoIn.equals("H")) {
            System.out.println("Server: Heal ... ");
        } else {
            System.out.println("Server: Player achieved nothing ...");
        }
    }
}
