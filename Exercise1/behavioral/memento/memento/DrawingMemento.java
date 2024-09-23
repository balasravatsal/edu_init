
package com.designpatterns.memento.memento;

import com.designpatterns.memento.model.Shape;

import java.util.List;

public class DrawingMemento {
    private final List<Shape> shapes;

    public DrawingMemento(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
