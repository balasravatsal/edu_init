package microservices;

import singleton.Server;

public class UserService implements ServiceHealth {
    private Server server = Server.getInstance();

    public void handleUserRequest() {
        server.processRequest("User request handled by UserService");
    }

    @Override
    public void healthCheck() {
        System.out.println("UserService is healthy.");
    }
}
