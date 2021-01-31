package com.company;

import java.util.ArrayList;

public class Player {
    private DeckOfCards drawPile;
    private DeckOfCards discardPile;
    private int playerNumber;


    public Player(DeckOfCards drawPile, int playerNumber) {
        this.drawPile = drawPile;
        this.playerNumber = playerNumber;
        this.discardPile = new DeckOfCards();
    }

    public DeckOfCards switchDrawPile() {
        discardPile.shuffleDeck();
        drawPile.cards = new ArrayList<>(discardPile.cards);
        discardPile.cards.clear();
        return drawPile;
    }

    public DeckOfCards getDrawPile() {
        return drawPile;
    }

    public DeckOfCards getDiscardPile() {
        return discardPile;
    }

    public int playCard() {
        if (drawPile.cards.isEmpty()) {
            int first = this.switchDrawPile().cards.get(0);
            showPlayerInfo();
            drawPile.cards.remove(0);
            return first;
        } else {
            int first = drawPile.cards.get(0);
            showPlayerInfo();
            drawPile.cards.remove(0);
            return first;
        }
    }

    public void addCardToDiscardPile(ArrayList<Integer> cardList) {
        for (int card : cardList) {
            discardPile.cards.add(card);
        }
    }

    public void showPlayerInfo() {
        System.out.println("Player " + this.playerNumber + "(" +
                (this.getDrawPile().cards.size() + this.getDiscardPile().cards.size()) + " cards): "
                + this.getDrawPile().cards.get(0) + " | " + "Draw Pile: "
                + this.getDrawPile().cards + ", " + "Discard Pile: "
                + this.getDiscardPile().cards);
    }
}