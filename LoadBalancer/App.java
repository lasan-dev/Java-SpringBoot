package LoadBalancer;

import java.util.ArrayList;
import java.util.List;

class App {
    public static void main (String[] args ) {
        // Create servers
        List<Server> servers = List.of(new Server("127.1.1.1"), new Server("127.1.1.2"), new Server("127.1.1.3"));  
        
        // Create LB
        LoadBalancer lb = new LoadBalancer(servers);

        var requests = createRequests(10);

        // iterate requests and send them to be handled by server
        requests.stream().forEach(req -> lb.handleRequest(req));


    }

    private static List<String> createRequests(int numberOfRequests) {
        var requests = new ArrayList<String>();
        for(int i = 1; i < numberOfRequests; i++) {
            requests.add("Request: " + i);
        }
        return requests;
    }
}