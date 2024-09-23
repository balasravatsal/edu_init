
package com.designpatterns.memento;

import com.designpatterns.memento.model.Shape;
import com.designpatterns.memento.service.DrawingApp;

public class Client {
    public static void main(String[] args) {
        DrawingApp drawingApp = new DrawingApp();

        // Adding shapes
        drawingApp.addShape(new Shape("Circle", "Red", 10, 10));
        drawingApp.addShape(new Shape("Square", "Blue", 20, 20));
        System.out.println("Current drawing: " + drawingApp.getDrawing());

        // Saving state
        drawingApp.save();

        // Adding more shapes
        drawingApp.addShape(new Shape("Triangle", "Green", 30, 30));
        System.out.println("Current drawing: " + drawingApp.getDrawing());

        // Undoing to previous state
        drawingApp.undo();
        System.out.println("After undo: " + drawingApp.getDrawing());
    }
}
