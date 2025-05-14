package org.example.unolast.controllers;

import org.example.unolast.models.Card;
import org.example.unolast.models.Deck;
import org.example.unolast.models.Player;
import org.example.unolast.views.GameView;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MenuController {

    @FXML
    private TextField textFieldNickname;

    @FXML
    void onActionButtonJugar(ActionEvent event) throws IOException {
        String nickname = textFieldNickname.getText();
        if (nickname.isBlank()) {
            nickname = "Jugador";
        }

        Player human = new Player("Jugador", true);
        human.setNickname(nickname);

        Deck deck = new Deck();
        Player computer = new Player("Computer", false);

        for (int i = 0; i < 5; i++) {
            human.drawCard(deck.drawCard());
            computer.drawCard(deck.drawCard());
        }

        Card topCard = deck.drawCard();
        deck.discardCard(topCard);

        GameView gameView = GameView.getInstance();
        gameView.show();

        gameView.getController().setHuman(human);
        gameView.getController().setComputer(computer);
        gameView.getController().setDeck(deck);
        gameView.getController().setTopCard(topCard);

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

}