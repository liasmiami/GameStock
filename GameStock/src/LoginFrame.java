import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	
	static UserList userList = new UserList("users.csv"); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Game Library");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 17));
		lblNewLabel.setBounds(107, 24, 221, 33);
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
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =textField_username.getText().trim();
				String password=textField_password.getText().trim();
				if(userList.login(username, password))
				{
					Library library=new Library();
					library.setVisible(true);
				    setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Login failed.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(78, 192, 291, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame=new RegisterFrame();
				registerFrame.setModal(true);
				registerFrame.setVisible(true); 
			}
		});
		btnRegister.setBounds(78, 228, 291, 23);
		contentPane.add(btnRegister);
	}
}
