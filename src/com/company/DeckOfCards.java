package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    ArrayList<Integer> cards;


    public DeckOfCards() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Integer> getCards() {
        return cards;
    }

    public DeckOfCards(ArrayList<Integer> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void createDeck() {
        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 4; j++)
                this.cards.add(i);
    }

    public void shuffleDeck() {
        if (!cards.isEmpty()) {
            int firstIndex = 0;
            int lastIndex = cards.size() - 1;
            int range = (lastIndex - firstIndex) + firstIndex;

            while (lastIndex > 0) {
                int randIndex = (int) (Math.random() * range) + firstIndex;
                Collections.swap(cards, lastIndex, randIndex);
                lastIndex = lastIndex - 1;
            }
        }
    }

    public DeckOfCards splitDeck(int startIndex, int endIndex, int forPlayer) {
        if (forPlayer == 1) {
            startIndex = startIndex;
            endIndex = endIndex;
        } else {
            startIndex = startIndex;
            endIndex = endIndex;
        }
        ArrayList<Integer> splittedCards = new ArrayList<>(cards.subList(startIndex, endIndex));
        Collections.reverse(splittedCards);
        DeckOfCards splittedDeck = new DeckOfCards(splittedCards);

        return splittedDeck;
    }
}