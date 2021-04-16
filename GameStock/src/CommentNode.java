import javax.swing.tree.DefaultMutableTreeNode;

public class CommentNode extends DefaultMutableTreeNode {

	public String ID;

	public String getID() {
		return ID;
	}

	public CommentNode(String ID, String title) {
		setUserObject(title);
		this.ID = ID;
	}
}
