package com.designpatterns.facade.subsystem;

public class UserInterface {
    public void designUI() {
        System.out.println("Designing the user interface...");
    }

    public void addComponent(String component) {
        System.out.println("Adding component: " + component);
    }

    public void previewUI() {
        System.out.println("Previewing the user interface...");
    }
}
