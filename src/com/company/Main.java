package com.company;

public class Main {

    public static void main(String[] args) {
        int gameloop = 0;
        Game game = new Game();

        while (gameloop == 0) {
            game.gameTurn(game.getPlayerOne().playCard(),game.getPlayerTwo().playCard());
            gameloop = game.winCondition();
        }
    }
}
