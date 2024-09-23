
package com.designpatterns.memento.service;

import com.designpatterns.memento.memento.DrawingMemento;
import com.designpatterns.memento.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class DrawingApp {
    private List<Shape> shapes = new ArrayList<>();
    private DrawingMemento savedState;

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public String getDrawing() {
        StringBuilder drawing = new StringBuilder();
        for (Shape shape : shapes) {
            drawing.append(shape.getDetails()).append("; ");
        }
        return drawing.toString();
    }

    public void save() {
        savedState = new DrawingMemento(new ArrayList<>(shapes));
    }

    public void undo() {
        if (savedState != null) {
            shapes = new ArrayList<>(savedState.getShapes());
        }
    }
}
