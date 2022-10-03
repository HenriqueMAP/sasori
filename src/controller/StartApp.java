package controller;

import view.StartMainContainer;

import java.awt.*;

public class StartApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sasori - Starting Tool BT");
                StartMainContainer startMainContainer = new StartMainContainer();
                startMainContainer.start();

            }
        });
    }
}
