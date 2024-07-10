package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstApp {

	private JFrame frame;
	private JTextField tfInput;
	private JTextField tfOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstApp window = new FirstApp();
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
	public FirstApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("재민 프로그램");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("입력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText("메롱");
			}
		});
		btnNewButton.setBounds(18, 18, 202, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("지우기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfInput.setText("");
				tfOutput.setText("");
			}
		});
		btnNewButton_1.setBounds(306, 18, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("복사");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tfInput.getText();
				tfOutput.setText(text);
			}
		});
		btnNewButton_2.setBounds(105, 77, 254, 113);
		frame.getContentPane().add(btnNewButton_2);
		
		tfInput = new JTextField();
		tfInput.setBounds(167, 191, 130, 26);
		frame.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		tfOutput = new JTextField();
		tfOutput.setBounds(167, 229, 130, 26);
		frame.getContentPane().add(tfOutput);
		tfOutput.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("지우기");
		btnNewButton_1_1.setBounds(306, 46, 117, 29);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("입력");
		btnNewButton_3.setBounds(18, 46, 202, 29);
		frame.getContentPane().add(btnNewButton_3);
	}
}
