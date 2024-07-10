package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MyChat {

	private JFrame frame;
	private JTextField tfInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyChat window = new MyChat();
					window.frame.setLocationRelativeTo(null);
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
	public MyChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 22, 288, 322);
		frame.getContentPane().add(scrollPane);
		
		JTextArea taOutput = new JTextArea();
		taOutput.setLineWrap(true);
		scrollPane.setViewportView(taOutput);
		taOutput.setEditable(false);
		
		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(taOutput);
			}

			
		});
		tfInput.setBounds(6, 348, 220, 37);
		frame.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(taOutput);
			}
		});
		btnNewButton.setBounds(232, 348, 62, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("x");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taOutput.setText("");
			}
		});
		btnNewButton_1.setBounds(264, -5, 30, 29);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	private void sendMessage(JTextArea taOutput) {
		String text = tfInput.getText();
		taOutput.append("재민 : "+text+"\n");
		tfInput.setText("");
		tfInput.setFocusable(true);
		tfInput.requestFocus();
	}
}
