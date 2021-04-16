import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.UUID;
import java.awt.event.ActionEvent;

public class AddComment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_comment;
	private String parentCommentID;

	/**
	 * Create the dialog.
	 */
	public AddComment(String label2,String gameName,String labConent,String parentCommentID) {
		
		this.parentCommentID=parentCommentID;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Add Comment");
		setBounds(100, 100, 744, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel(label2);
			lblNewLabel_1.setBounds(5, 37, 150, 26);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Your comment: ");
			lblNewLabel_2.setBounds(5, 89, 150, 26);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_comment = new JTextField();
			textField_comment.setBounds(175, 89, 543, 26);
			contentPanel.add(textField_comment);
			textField_comment.setColumns(10);
		}
		{
			JLabel lblNewLabel_content = new JLabel(labConent);
			lblNewLabel_content.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_content.setFont(new Font("Consolas", Font.PLAIN, 16));
			lblNewLabel_content.setBounds(175, 37, 543, 26);
			contentPanel.add(lblNewLabel_content);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Library.commentList.addComment(gameName, UUID.randomUUID().toString(), parentCommentID, textField_comment.getText().trim());
						Library.commentList.save();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
