
public class Comment {
	private String gameName;
	private String commentId;
	private String parentCommentId;
	private String content;
	private int like;

	public Comment(String gameName, String commentId, String parentCommentId, String content, int like) {
		super();
		this.gameName = gameName;
		this.commentId = commentId;
		this.parentCommentId = parentCommentId;
		this.content = content;
		this.like = like;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

}
