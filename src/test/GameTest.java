package test;

import com.company.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;
    private ArrayList<Integer> p1cardsInput;
    private ArrayList<Integer> p2cardsInput;

    @BeforeEach
    public void setUp() {
        this.game = new Game();
        p1cardsInput = new ArrayList<>();
        p2cardsInput = new ArrayList<>();
    }

    @Test
    public void shouldHigherCardWin() {
        p1cardsInput.add(5);
        p2cardsInput.add(6);
        game.gameTurn(p1cardsInput.get(0), p2cardsInput.get(0));

        if (p1cardsInput.get(0) > p2cardsInput.get(0)) {
            assertEquals(2,
                    game.getPlayerOne().getDiscardPile().getCards().size(),
                    "There must be a DRAW");
            System.out.println("P1 card is higher and won. Cards won: " + game.getPlayerOne().getDiscardPile().getCards());
        }
        else {
            assertEquals(2,
                    game.getPlayerTwo().getDiscardPile().getCards().size(),
                    "There must be a DRAW");

            System.out.println("P2 card is higher and won. Cards won: " + game.getPlayerTwo().getDiscardPile().getCards());
        }
    }

    @Test
    public void shouldWon4CardsFromNextRound() {
        //First round with draw
        p1cardsInput.add(1);
        p2cardsInput.add(1);

        //Next round where Player2 won
        p1cardsInput.add(2);
        p2cardsInput.add(8);

        int expectedAmountOfCards = 4;

        for(int i=0; i<p1cardsInput.size(); i++){
            game.gameTurn(p1cardsInput.get(i),p2cardsInput.get(i));
        }
        assertEquals(expectedAmountOfCards,
                game.getPlayerTwo().getDiscardPile().getCards().size(),
                "Player2 discard pile doesn't have 4 cards");

        System.out.println("P1 Cards won: " + game.getPlayerOne().getDiscardPile().getCards());
        System.out.println("P2 Cards won: " + game.getPlayerTwo().getDiscardPile().getCards());
    }
}