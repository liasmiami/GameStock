import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

public class CommentList {
	private ArrayList<Comment> comments;
	static Scanner in = null;

	public CommentList(String file) {
		try {
			in = new Scanner(new File(file));
			comments = new ArrayList<Comment>();
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if ("".equals(line)) {
					continue;
				}
				String[] split = line.split(",");
				String name = split[0];
				String commentId = split[1];
				String parentCommentId = split[2];
				String content = split[3];
				int like =Integer.valueOf( split[4]);
				String user=split[5];
				Comment comment = new Comment(name, commentId, parentCommentId, content, like, user);
				comments.add(comment);
			}
		} catch (Exception e) {
			System.out.println("Error reading file");
		}
		in.close();
	}

	public void addComment(String name, String commentId, String parentCommentId, String content, String user) {
		Comment comment = new Comment(name, commentId, parentCommentId, content, 0, user);
		comments.add(comment);
	}
	
	public void addLike( String commentId  ) {
		 for(int i =0;i<comments.size();i++)
		 {
			 if(comments.get(i).getCommentId().equals(commentId))
			 {
				 comments.get(i).setLike(comments.get(i).getLike()+1);
			 }
		 }
	}

	public List<Comment> getCommentsByGamename(String gameName) {
		gameName = gameName.toLowerCase();
		List<Comment> result = new ArrayList<Comment>();
		for (Comment comment : comments) {
			if (comment.getGameName().toLowerCase().equals(gameName)) {
				result.add(comment);
			}
		}
		return result;
	} 
 
	public void save() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("comments.csv"));
		} catch (Exception ex) {
			System.out.println("Error reading file");
		}
		StringBuilder builder = new StringBuilder();
		for (Comment comment : comments) {
			builder.append(comment.getGameName() + "," + comment.getCommentId() + "," + comment.getParentCommentId() + "," +comment.getContent()
			+ "," + comment.getLike()+ ","+comment.getUser()+"\n");
		}
		pw.write(builder.toString());
		pw.close();
	}

}
