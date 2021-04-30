  
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JDialog {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	
	static UserList userList = new UserList("users.csv"); 
	private JTextField textField_comfirm;
  
	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setTitle("Register"); 
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register for Game Library");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 17));
		lblNewLabel.setBounds(88, 24, 250, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(78, 96, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_username = new JTextField();
		textField_username.setBounds(194, 93, 175, 21);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(78, 139, 70, 15);
		contentPane.add(lblNewLabel_1_1);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(194, 136, 175, 21);
		contentPane.add(textField_password);
		
		JButton btnRegister = new JButton("Save");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =textField_username.getText().trim();
				String password=textField_password.getText().trim();
				String comfirm =textField_comfirm.getText().trim(); 
				
				if("".equals(username)|| "".equals(password) || "".equals(comfirm))
				{
					JOptionPane.showMessageDialog(null, "Please input all the field.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(!password.equals(comfirm))
				{
					JOptionPane.showMessageDialog(null, "The two passwords are inconsistent.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(userList.addUser(username, password))
				{
					JOptionPane.showMessageDialog(null, "Register successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
					userList.save();
				}else {
					JOptionPane.showMessageDialog(null, "Register failed.", "Success", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
			}
		});
		btnRegister.setBounds(78, 228, 291, 23);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Comfirm password");
		lblNewLabel_1_1_1.setBounds(78, 177, 106, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_comfirm = new JTextField();
		textField_comfirm.setColumns(10);
		textField_comfirm.setBounds(194, 174, 175, 21);
		contentPane.add(textField_comfirm);
	}
}
