package LoadBalancer;

public class Server {

    private String ip;

    public Server(String ip) {
        this.ip = ip;
    }

    public void processRequest(String request){
        try {
            Thread.sleep(1000);
            System.out.println("Server: " + ip + " Received -  " + request);
            
        } catch (Exception e) {
            System.out.println("Error Processing");
        }
    }
}
