package com.designpatterns.facade;

import com.designpatterns.facade.facade.NoCodePlatformFacade;

public class Client {
    public static void main(String[] args) {
        NoCodePlatformFacade facade = new NoCodePlatformFacade();

        // Create application
        facade.createApplication();

        // Add components to UI
        facade.addComponentToUI("Button");
        facade.addComponentToUI("TextField");

        // Define database tables and relationships
        facade.defineDatabaseTable("Users");
        facade.defineDatabaseTable("Orders");
        facade.establishDatabaseRelationship("Users", "Orders");

        // Deploy the application
        facade.deployApplication();
    }
}
