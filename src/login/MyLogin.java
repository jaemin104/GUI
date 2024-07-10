package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyLogin {

	private JFrame frame;
	private JTextField tfUsername;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLogin window = new MyLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(179, 75, 66, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(179, 119, 66, 32);
		frame.getContentPane().add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(268, 78, 130, 26);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(267, 122, 130, 26);
		frame.getContentPane().add(tfPassword);
		
		JButton btnNewButton = new JButton("log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = "jaemin";
				String pw = "111";
				
				String textName = tfUsername.getText();
				String textPW = tfPassword.getText();
				
				if(name.equals(textName) && (pw.equals(textPW))) {
					LoginInfo loginInfo = new LoginInfo();
					loginInfo.getFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "username 또는 password가 잘못되었습니다.");
				}
				
			}
		});
		btnNewButton.setBounds(208, 163, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("/Users/kimjaemin/eclipse-workspace/GUI/src/images/logo.png"));
		
		lblNewLabel_1.setBounds(42, 67, 82, 84);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
