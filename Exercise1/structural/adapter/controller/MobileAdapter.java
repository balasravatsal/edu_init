package com.designpatterns.adapter.controller;

import com.designpatterns.adapter.platform.MobileController;

public class MobileAdapter implements GameController {
    private MobileController mobileController;

    public MobileAdapter(MobileController mobileController) {
        this.mobileController = mobileController;
    }

    @Override
    public void pressButton(String button) {
        mobileController.tapMobileButton(button);
    }
}
