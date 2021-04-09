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
import java.awt.event.ActionEvent;

public class AddGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_name;
	private JTextField textField_genre;
	private JTextField textField_releaseDate;
	private JTextField textField_platform;
	private JTextField textField_company; 

	/**
	 * Create the dialog.
	 */
	public AddGame() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Add Game");
		setBounds(100, 100, 346, 252);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(5, 2, 20, 10));
		{
			JLabel lblNewLabel_1 = new JLabel("Name  ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_name = new JTextField();
			contentPanel.add(textField_name);
			textField_name.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Genre  ");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField_genre = new JTextField();
			contentPanel.add(textField_genre);
			textField_genre.setColumns(10);
		}
		{
			JLabel lblNewLabel_releaseDate = new JLabel("Release Date  ");
			lblNewLabel_releaseDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_releaseDate.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_releaseDate);
		}
		{
			textField_releaseDate = new JTextField();
			contentPanel.add(textField_releaseDate);
			textField_releaseDate.setColumns(10);
		}
		{
			JLabel lblNewLabel_platform = new JLabel("Platform  ");
			lblNewLabel_platform.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_platform.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_platform);
		}
		{
			textField_platform = new JTextField();
			contentPanel.add(textField_platform);
			textField_platform.setColumns(10);
		}
		{
			JLabel lblNewLabel_company = new JLabel("Company  ");
			lblNewLabel_company.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_company.setFont(new Font("Consolas", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel_company);
		}
		{
			textField_company = new JTextField();
			contentPanel.add(textField_company);
			textField_company.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Library.gameList.addGame(textField_name.getText().trim(), textField_genre.getText().trim(),
								textField_releaseDate.getText().trim(), textField_platform.getText().trim(),
								textField_company.getText().trim());
						Library.gameList.save();
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
