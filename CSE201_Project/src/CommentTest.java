import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommentTest {

	@Test
    void testGetGameName() {
        Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);
        assertEquals(comment.getGameName(), "Madden NFL 21");
    }

    @Test
    void testGetCommentId() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	assertEquals(comment.getCommentId(), "comment");
    }

    @Test
    void testGetParentCommentId() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	assertEquals(comment.getParentCommentId(), "pComment");
    }

    @Test
    void testGetContent() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	assertEquals(comment.getContent(), "Great Game!");
    }

    @Test
    void testGetLike() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	assertEquals(comment.getLike(), 2);
    }

    @Test
    void testSetGameName() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	comment.setGameName("Animal Crossing: New Horizons");
        assertEquals(comment.getGameName(), "Animal Crossing: New Horizons");
    }

    @Test
    void testSetCommentId() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	comment.setCommentId("comment21");
        assertEquals(comment.getCommentId(), "comment21");
    }

    @Test
    void testSetParentCommentId() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	comment.setParentCommentId("pComment21");
        assertEquals(comment.getParentCommentId(), "pComment21");
    }

    @Test
    void testSetContent() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	comment.setContent("Bad Game!");
        assertEquals(comment.getContent(), "Bad Game!");
    }

    @Test
    void testSetLike() {
    	Comment comment = new Comment("Madden NFL 21", "comment", "pComment", "Great Game!", 2);        
    	comment.setLike(20000);
        assertEquals(comment.getLike(), 20000);
    }

}
