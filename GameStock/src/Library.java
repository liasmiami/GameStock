
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;

public class Library extends JFrame {
	static GameList gameList = new GameList("../src/games.csv"); //read from src directory
	static CommentList commentList = new CommentList("../src/comments.csv"); 

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Library() {
		setTitle("Game Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 10, 409, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = textField.getText().toString().trim();
				loadGameList(table, gameList.searchByKeyword(keyword));
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton.setBounds(428, 8, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddGame dialog = new AddGame();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);

				dialog.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowClosing(WindowEvent e) {
						loadGameList(table, gameList.getGameList());
						dialog.dispose();
					}

					@Override
					public void windowClosed(WindowEvent e) {
						loadGameList(table, gameList.getGameList());
						dialog.dispose();
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub

					}
				});

				dialog.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton_1.setBounds(676, 10, 93, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 862, 205);
		contentPane.add(scrollPane);

		table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Game List");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 49, 82, 15);
		contentPane.add(lblNewLabel);

		JLabel lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblComments.setBounds(10, 301, 82, 15);
		contentPane.add(lblComments);

		JButton btnNewButton_1_1 = new JButton("Comment");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a game.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String gameName = table.getValueAt(table.getSelectedRow(), 0).toString();
					String commentID = "-1";

					CommentNode node = (CommentNode) tree.getLastSelectedPathComponent();
					if (node == null) {
						commentID = "-1";
					} else {
						commentID = node.getID();
					}

					AddComment addComment = new AddComment(commentID.equals("-1") ? "Game: " : "Comment: ",
							gameName, commentID.equals("-1") ? gameName : node.getUserObject().toString(),commentID);
					addComment.setModal(true);
					addComment.setVisible(true);
					addComment.addWindowListener(new WindowListener() {

						@Override
						public void windowOpened(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowIconified(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeiconified(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeactivated(WindowEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowClosing(WindowEvent e) {
							showComments();
						}

						@Override
						public void windowClosed(WindowEvent e) {
							showComments();
						}

						@Override
						public void windowActivated(WindowEvent e) {
							// TODO Auto-generated method stub

						}
					});
				}
			}
		});

		btnNewButton_1_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(676, 530, 93, 23);
		contentPane.add(btnNewButton_1_1);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnRemove.setBounds(779, 10, 93, 23);
		contentPane.add(btnRemove);

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = table.getValueAt(table.getSelectedRow(), 0).toString();
				gameList.removeGame(name);
				gameList.save();
				loadGameList(table, gameList.getGameList());
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 326, 862, 194);
		contentPane.add(scrollPane_1);

		tree = new JTree();
		tree.setModel(new DefaultTreeModel(new CommentNode("-1", "No Comments")));
		setChangeTreeUI(tree);

		scrollPane_1.setViewportView(tree);

		JButton btnNewButton_like = new JButton("Like");
		btnNewButton_like.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton_like.setBounds(779, 530, 93, 23);
		contentPane.add(btnNewButton_like);
		
		btnNewButton_like.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CommentNode node = (CommentNode) tree.getLastSelectedPathComponent();
				String commentID="-1";
				if (node == null) {
					commentID= "-1";
				} else {
					commentID = node.getID();
				}
				if(commentID.equals("-1"))
				{
					JOptionPane.showMessageDialog(null, "Please select a comment.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					Library.commentList.addLike(commentID);
					Library.commentList.save();
					showComments();
				}
			}
		});

		loadGameList(table, gameList.getGameList());

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnRefresh.setBounds(528, 9, 93, 23);
		contentPane.add(btnRefresh);

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGameList(table, gameList.getGameList());
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			@Override
			public void valueChanged(ListSelectionEvent e) { 
				showComments();
			}
		});
	}

	private void showComments() {
		if (table.getSelectedRow() == -1) {
			tree.setModel(new DefaultTreeModel(new CommentNode("-1", "No Comments") {
			}));
		} else { 
			String name = table.getValueAt(table.getSelectedRow(), 0).toString();

			CommentNode rootNode = new CommentNode("-1", "Comments to "+name);

			tree.setModel(
					new DefaultTreeModel(getChildCommentNodes(rootNode, commentList.getCommentsByGamename(name))));
		}
		expandTree(tree);
	}

	private static CommentNode getChildCommentNodes(CommentNode commentNode, List<Comment> comments) {
		for (Comment comment : comments) {
			if (comment.getParentCommentId().equals(commentNode.getID())) {
			    // garbled code here, changed to likes
				CommentNode commentChildNode = new CommentNode(comment.getCommentId(), comment.getContent() + "Likes: " + comment.getLike());
				commentNode.add(getChildCommentNodes(commentChildNode, comments)); 
			}
		}
		return commentNode;
	}

	private void loadGameList(JTable table, List<Game> games) {

		Vector<String> vectorName = new Vector<String>();
		vectorName.add("Name");
		vectorName.add("Genre");
		vectorName.add("Release Date");
		vectorName.add("Platform");
		vectorName.add("Company");
		Vector<Vector<String>> vectorData = new Vector<Vector<String>>();

		for (Game game : games) {
			Vector<String> vdata = new Vector<String>();
			vdata.add(game.getName());
			vdata.add(game.getGenre());
			vdata.add(game.getDate());
			vdata.add(game.getPlatform());
			vdata.add(game.getCompany());

			vectorData.add(vdata);
		}

		table.setModel(new DefaultTableModel(vectorData, vectorName));
	}

	public static void setChangeTreeUI(JTree tree) {

		tree.setShowsRootHandles(true);

		Icon CollapsedIcon = new ImageIcon("image/tree_elbow_add.png");
		Icon LeafIcon = new ImageIcon("image/user.png");
		Icon ClosedIcon = new ImageIcon("image/user.png");
		Icon OpenedIcon = new ImageIcon("image/user.png");

		DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) (tree.getCellRenderer());
		render.setLeafIcon(LeafIcon);
		render.setClosedIcon(ClosedIcon);
		render.setOpenIcon(OpenedIcon);

		BasicTreeUI ui = (BasicTreeUI) (tree.getUI());
		ui.setCollapsedIcon(CollapsedIcon);
		expandTree(tree);
	}

	public static void expandTree(JTree tree) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		expandAll(tree, new TreePath(root), true);
	}

	private static void expandAll(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}

		// Expansion or collapse must be done bottom-up
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}

}
