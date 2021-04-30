import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void testGetName() {
        Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getName(), "Grand Theft Auto V");
    }

    @Test
    void testGetGenre() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getGenre(), "Action-adventure");
    }

    @Test
    void testGetDate() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getDate(), "9/17/2013");
    }

    @Test
    void testGetPlatform() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getPlatform(), "PlayStation");
    }

    @Test
    void testGetCompany() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getCompany(), "RockStar Games");
    }
    
    @Test
    void testGetRating() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        assertEquals(game.getRating(), "4.5/5");
    }

    @Test
    void testSetName() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setName("name");
        assertEquals(game.getName(), "name");
    }

    @Test
    void testSetGenre() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setGenre("genre");
        assertEquals(game.getGenre(), "genre");
    }

    @Test
    void testSetDate() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setDate("1/11/2021");
        assertEquals(game.getDate(), "1/11/2021");
    }

    @Test
    void testSetPlatform() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setPlatform("platform");
        assertEquals(game.getPlatform(), "platform");
    }

    @Test
    void testSetCompany() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setCompany("company");
        assertEquals(game.getCompany(), "company");
    }
    
    @Test
    void testSetRating() {
    	 Game game = new Game("Grand Theft Auto V", "Action-adventure", "9/17/2013", "PlayStation", "RockStar Games", "4.5/5");
        game.setRating("3/5");
        assertEquals(game.getRating(), "3/5");
    }
    
    

}
