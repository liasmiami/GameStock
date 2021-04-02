import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	public GUI() {
			
		JFrame frame = new JFrame();
			
		JButton button = new JButton("View List of Games");
			
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 20, 60));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
			
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GAME STOCK");
		frame.pack();
		frame.setVisible(true);
			
	}
		
	public static void main(String[] args) {
		new GUI();
	}
}
