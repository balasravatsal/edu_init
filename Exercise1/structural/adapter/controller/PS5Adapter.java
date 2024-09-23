package com.designpatterns.adapter.controller;

import com.designpatterns.adapter.platform.PS5Controller;

public class PS5Adapter implements GameController {
    private PS5Controller ps5Controller;

    public PS5Adapter(PS5Controller ps5Controller) {
        this.ps5Controller = ps5Controller;
    }

    @Override
    public void pressButton(String button) {
        ps5Controller.pressPS5Button(button);
    }
}
