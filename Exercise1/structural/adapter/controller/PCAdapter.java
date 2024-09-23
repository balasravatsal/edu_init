package com.designpatterns.adapter.controller;

import com.designpatterns.adapter.platform.PCController;

public class PCAdapter implements GameController {
    private PCController pcController;

    public PCAdapter(PCController pcController) {
        this.pcController = pcController;
    }

    @Override
    public void pressButton(String button) {
        pcController.pressPCButton(button);
    }
}