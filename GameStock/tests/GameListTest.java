import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GameListTest {
    @Test
    void testGameList() {
        GameList gameList = new GameList("games.csv");
    }

    @Test
    void testAddGame() {
        GameList gameList = new GameList("games.csv");
        gameList.addGame("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        
    }

    @Test
    void testRemoveGame() {
        GameList gameList = new GameList("games.csv");
        gameList.removeGame("Super Mario Bros.");
    }

}
