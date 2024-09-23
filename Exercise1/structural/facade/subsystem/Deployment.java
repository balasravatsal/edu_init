package com.designpatterns.facade.subsystem;

public class Deployment {
    public void deployApp() {
        System.out.println("Deploying the application...");
    }

    public void configureEnvironment(String environment) {
        System.out.println("Configuring the " + environment + " environment...");
    }

    public void monitorDeployment() {
        System.out.println("Monitoring the deployment process...");
    }
}
