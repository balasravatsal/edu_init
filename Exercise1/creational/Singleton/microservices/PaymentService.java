package microservices;

import singleton.Server;

public class PaymentService implements ServiceHealth {
    private Server server = Server.getInstance();

    public void handlePaymentRequest() {
        server.processRequest("Payment request handled by PaymentService");
    }

    @Override
    public void healthCheck() {
        System.out.println("PaymentService is healthy.");
    }
}
