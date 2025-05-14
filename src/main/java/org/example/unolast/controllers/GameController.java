package org.example.unolast.controllers;

import org.example.unolast.models.Card;
import org.example.unolast.models.Deck;
import org.example.unolast.models.Game;
import org.example.unolast.models.Player;

import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Objects;

import java.io.IOException;

public class GameController {

    @FXML
    private Label labelNickname;

    @FXML
    private ListView<Card> listViewHumanHand;

    @FXML
    private ListView<Card> listViewComputerHand;

    @FXML
    private ImageView imageViewTopCard;

    Game game = new Game();
    Deck deck = new Deck();
    private Player human;
    private Player computer;
    Card topCard;

    public void setHuman(Player human) {
        this.human = human;
        initializeHumanHandView();
        showLabelNickname();
    }

    public void setTopCard(Card card) {
        this.topCard = card;
        showImageViewTopCard(topCard);
    }

    private void showImageViewTopCard(Card topCard) {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(
                "/org/example/unolast/" + topCard.getImagePath())).toExternalForm());
        imageViewTopCard.setImage(image);
    }

    private void initializeHumanHandView() {
        listViewHumanHand.setOrientation(Orientation.HORIZONTAL);
        listViewHumanHand.setItems(human.getHand());

        listViewHumanHand.setCellFactory(lv -> new ListCell<Card>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);
                if (empty || card == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    imageView.setPreserveRatio(true);

                    Image image = new Image(Objects.requireNonNull(getClass().getResource(
                            "/org/example/unolast/" + card.getImagePath())).toExternalForm());
                    imageView.setImage(image);

                    setText(null);
                    setGraphic(imageView);
                }
            }
        });
    }

    public void setComputer(Player computer) {
        this.computer = computer;
        initializeComputerHandView();
    }

    private void initializeComputerHandView() {
        listViewComputerHand.setOrientation(Orientation.HORIZONTAL);
        listViewComputerHand.setItems(computer.getHand());

        listViewComputerHand.setCellFactory(lv -> new ListCell<Card>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);
                if (empty || card == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    imageView.setPreserveRatio(true);

                    Image image = new Image(Objects.requireNonNull(getClass().getResource(
                            "/org/example/unolast/images/cards/card_uno.png")).toExternalForm());
                    imageView.setImage(image);

                    setText(null);
                    setGraphic(imageView);
                }
            }
        });
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void showLabelNickname() {
        labelNickname.setText(human.getNickname());
    }

    @FXML
    void onActionButtonPrint(ActionEvent event) throws IOException {
        deck.printDeck();
        System.out.println("***********human hand:");
        human.printHand();
        System.out.println("***********computer hand");
        computer.printHand();
    }

}