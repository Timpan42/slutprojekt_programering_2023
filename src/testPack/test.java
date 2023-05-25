package testPack;

public class test {
    public static void main(String[] args) {
        server s = new server();
        clients c = new clients();

        s.acceptClients();

        s.getStreams();
        c.getStreams();

        c.runProtocol();
        s.runProtocol();
    }
}
