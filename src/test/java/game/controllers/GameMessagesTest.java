package game.controllers;

import game.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameMessagesTest {

    Game game = new Game();
    GameMessages testObject = new GameMessages(game);

    @Test
    public void testFirstMessage() {
        assertEquals("Initialize game:", testObject.displayGameMessage());

    }
}