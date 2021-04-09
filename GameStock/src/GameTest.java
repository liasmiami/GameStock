import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void testGetName() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        assertEquals(game.getName(), "Grand Theft Auto V");
    }

    @Test
    void testGetGenre() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        assertEquals(game.getGenre(), "Action-adventure");
    }

    @Test
    void testGetDate() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        assertEquals(game.getDate(), "9/17/2013");
    }

    @Test
    void testGetPlatform() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        assertEquals(game.getPlatform(), "PlayStation");
    }

    @Test
    void testGetCompany() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        assertEquals(game.getCompany(), "RockStar Games");
    }

    @Test
    void testSetName() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        game.setName("name");
        assertEquals(game.getName(), "name");
    }

    @Test
    void testSetGenre() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        game.setGenre("genre");
        assertEquals(game.getGenre(), "genre");
    }

    @Test
    void testSetDate() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        game.setDate("1/11/2021");
        assertEquals(game.getDate(), "1/11/2021");
    }

    @Test
    void testSetPlatform() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        game.setPlatform("platform");
        assertEquals(game.getPlatform(), "platform");
    }

    @Test
    void testSetCompany() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games");
        game.setCompany("company");
        assertEquals(game.getCompany(), "company");
    }

}
