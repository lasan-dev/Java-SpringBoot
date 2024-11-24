package LoadBalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer {

    private List<Server> servers;
    private AtomicInteger currentServerIndex = new AtomicInteger(0);

    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
    }

    public void handleRequest(String request) {
        if (servers.isEmpty()) {
            System.out.println("No servers available to handle the request.");
            return;
        }
        // Round Robin logic
        Server server = servers.get(currentServerIndex.getAndUpdate(i -> (i+1) % servers.size()));
        server.processRequest(request);
    }
}
