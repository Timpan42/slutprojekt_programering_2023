public class s_controller {
    public server server;
    public draw bord;

    public s_controller(){
        bord = new draw("server", false);

        server = new server();
        server.acceptClients();
        //server.getStreams();

        // server.setMessage("You got mail");
        //server.sendMessage();
        server.receivePlayerInfo();

        server.playerRequest();
    }
}
