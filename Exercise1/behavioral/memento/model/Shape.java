
package com.designpatterns.memento.model;

public class Shape {
    private String type;
    private String color;
    private int x;
    private int y;

    public Shape(String type, String color, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getDetails() {
        return type + " (" + color + ") at [" + x + ", " + y + "]";
    }
}
