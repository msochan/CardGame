package test;

import com.company.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckOfCardsTest {
    private DeckOfCards deck;

    @BeforeEach
    public void setUp() {
        this.deck = new DeckOfCards();
        this.deck.createDeck();
        //deck.shuffleDeck();
    }

    @Test
    public void shouldShuffleDeck() {

    }

    @Test
    public void shouldContain40Cards() {
        assertEquals(40, deck.getCards().size(), "Deck not containing required amount of cards");
    }

    public double random(){
        return Math.random();
    }
}