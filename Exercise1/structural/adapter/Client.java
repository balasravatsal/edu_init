package com.designpatterns.adapter;

import com.designpatterns.adapter.controller.*;
import com.designpatterns.adapter.platform.MobileController;
import com.designpatterns.adapter.platform.PCController;
import com.designpatterns.adapter.platform.PS5Controller;
import com.designpatterns.adapter.platform.XboxController;

public class Client {
    public static void main(String[] args) {
        GameController ps5 = new PS5Adapter(new PS5Controller());
        GameController xbox = new XboxAdapter(new XboxController());
        GameController pc = new PCAdapter(new PCController());
        GameController mobile = new MobileAdapter(new MobileController());

        ps5.pressButton("X");
        xbox.pressButton("A");
        pc.pressButton("Space");
        mobile.pressButton("Swipe");
    }
}
