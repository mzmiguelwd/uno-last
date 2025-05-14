package org.example.unolast;

import org.example.unolast.views.MenuView;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        MenuView menuView = MenuView.getInstance();
        menuView.show();
    }

    public static void main(String[] args) { launch(); }

}