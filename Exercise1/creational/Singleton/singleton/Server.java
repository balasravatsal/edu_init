package singleton;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private static Server instance;
    private List<String> requestLog = new ArrayList<>();
    private int load = 0;
    private boolean isMaintenanceMode = false;

    private Server() {
        System.out.println("Server started...");
    }

    public static Server getInstance() {
        if (instance == null) {
            synchronized (Server.class) {
                if (instance == null) {
                    instance = new Server();
                }
            }
        }
        return instance;
    }

    public void processRequest(String request) {
        if (isMaintenanceMode) {
            System.out.println("Server is in maintenance mode. Request denied: " + request);
        } else {
            load++;
            requestLog.add(request);
            System.out.println("Processing request: " + request);
        }
    }

    public void enableMaintenanceMode() {
        isMaintenanceMode = true;
        System.out.println("Server is now in Maintenance Mode.");
    }

    public void disableMaintenanceMode() {
        isMaintenanceMode = false;
        System.out.println("Server is now Operational.");
    }

    public void printRequestLog() {
        System.out.println("Request Log: " + requestLog);
    }

    public void printServerLoad() {
        System.out.println("Total requests processed: " + load);
    }
}
