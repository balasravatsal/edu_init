package com.designpatterns.facade.facade;

import com.designpatterns.facade.subsystem.Database;
import com.designpatterns.facade.subsystem.Deployment;
import com.designpatterns.facade.subsystem.UserInterface;

public class NoCodePlatformFacade {
    private UserInterface ui;
    private Database db;
    private Deployment deployment;

    public NoCodePlatformFacade() {
        this.ui = new UserInterface();
        this.db = new Database();
        this.deployment = new Deployment();
    }

    public void createApplication() {
        System.out.println("Starting the application creation process...");
        ui.designUI();
        db.createDatabase();
        deployment.configureEnvironment("production");
        System.out.println("Application created successfully!");
    }

    public void addComponentToUI(String component) {
        ui.addComponent(component);
        ui.previewUI();
    }

    public void defineDatabaseTable(String tableName) {
        db.defineTable(tableName);
    }

    public void establishDatabaseRelationship(String table1, String table2) {
        db.establishRelationship(table1, table2);
    }

    public void deployApplication() {
        deployment.deployApp();
        deployment.monitorDeployment();
    }
}
