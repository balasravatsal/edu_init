package com.designpatterns.adapter.controller;

import com.designpatterns.adapter.platform.XboxController;

public class XboxAdapter implements GameController {
    private XboxController xboxController;

    public XboxAdapter(XboxController xboxController) {
        this.xboxController = xboxController;
    }

    @Override
    public void pressButton(String button) {
        xboxController.pressXboxButton(button);
    }
}
