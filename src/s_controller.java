public class s_controller {
    public server server;
    public draw bord;

    public s_controller(){
        bord = new draw("server", false);

        server = new server();
        server.acceptClients();
        server.setMessage("Hello");
        server.sendMessage();
    }
}
