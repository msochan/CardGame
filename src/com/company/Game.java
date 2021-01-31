package com.company;

import java.util.ArrayList;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private DeckOfCards allCards;
    private ArrayList<Integer> discardedCards;

    public Game() {
        allCards = new DeckOfCards();
        allCards.createDeck();
        allCards.shuffleDeck();

        discardedCards = new ArrayList<>();
        playerOne = new Player(allCards.splitDeck(0, 20, 2),
                1);
        playerTwo = new Player(allCards.splitDeck(20, 40, 2),
                2);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void discardCards(int card1, int card2, Player player) {
        discardedCards.add(card1);
        discardedCards.add(card2);
        player.addCardToDiscardPile(discardedCards);
        discardedCards.clear();
    }

    public void gameTurn(int p1Card, int p2Card) {
        if (p1Card > p2Card) {
            discardCards(p1Card, p2Card, playerOne);
            System.out.println("Player 1 wins this round \n");

        } else if (p2Card > p1Card) {
            discardCards(p1Card, p2Card, playerTwo);
            System.out.println("Player 2 wins this round \n");

        } else if (p1Card == p2Card) {
            discardedCards.add(p1Card);
            discardedCards.add(p2Card);
            System.out.println("DRAW! No winner in this round!\n");
        }
    }

    public int winCondition() {
        if (playerOne.getDiscardPile().cards.isEmpty() && playerOne.getDrawPile().cards.isEmpty()) {
            System.out.println("PLAYER 2 WINS");
            return 2;
        } else if (playerTwo.getDiscardPile().cards.isEmpty() && playerTwo.getDrawPile().cards.isEmpty()) {
            System.out.println("PLAYER 1 WINS");
            return 1;
        } else return 0;
    }
}