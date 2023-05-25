public class test_s {
    public static void main(String[] args) {
        server s = new server();
        s.acceptClients();
        s.getStreams();
        s.runProtocol();
        s.msg();

    }
}
