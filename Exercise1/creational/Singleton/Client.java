import microservices.PaymentService;
import microservices.UserService;
import singleton.Server;

public class Client {
    public static void main(String[] args) {
        // Initialize services
        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();

        // Handle some requests
        userService.handleUserRequest();
        paymentService.handlePaymentRequest();

        // Server health check
        userService.healthCheck();
        paymentService.healthCheck();

        // Enable Maintenance mode and attempt to handle requests
        Server server = Server.getInstance();
        server.enableMaintenanceMode();
        userService.handleUserRequest();  // Will be denied due to maintenance mode

        // Disable Maintenance mode and continue operations
        server.disableMaintenanceMode();
        paymentService.handlePaymentRequest();

        // Print server load and request log
        server.printServerLoad();
        server.printRequestLog();
    }
}
