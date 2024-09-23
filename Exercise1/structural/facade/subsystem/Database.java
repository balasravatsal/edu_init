package com.designpatterns.facade.subsystem;

public class Database {
    public void createDatabase() {
        System.out.println("Creating the database...");
    }

    public void defineTable(String tableName) {
        System.out.println("Defining table: " + tableName);
    }

    public void establishRelationship(String table1, String table2) {
        System.out.println("Establishing relationship between " + table1 + " and " + table2);
    }
}
