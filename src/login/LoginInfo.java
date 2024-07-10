package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import db.DbBasic;

public class LoginInfo {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField textField_3;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JTable table;
	private Connection conn;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInfo window = new LoginInfo();
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
	public LoginInfo() {
		initialize();
		conn = DbBasic.init();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(16, 62, 12, 22);
		frame.getContentPane().add(lblNewLabel);
		
		tfId = new JTextField();
		tfId.setBounds(81, 60, 130, 26);
		frame.getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(16, 88, 63, 22);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(16, 113, 63, 22);
		frame.getContentPane().add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(81, 86, 130, 26);
		frame.getContentPane().add(tfUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(81, 111, 130, 26);
		frame.getContentPane().add(tfPassword);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//infoSave();
				//
			}

			
		});
		btnNewButton.setBounds(6, 201, 87, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(6, 231, 87, 29);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setBounds(6, 261, 87, 29);
		frame.getContentPane().add(btnDelete);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(97, 194, 114, 114);
		frame.getContentPane().add(textArea_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 6, 176, 27);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(0, 34, 211, 27);
		frame.getContentPane().add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(188, 5, 178, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.setBounds(367, 5, 94, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("load data");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM LoginInfo";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					ResultSet rs = statement.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(1));
						System.out.println(rs.getString(2));
						System.out.println(rs.getString(3));
						System.out.println(rs.getString(4));
					}
					
					statement.close();
					rs.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(455, 5, 124, 29);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblGrade = new JLabel("grade");
		lblGrade.setBounds(16, 165, 63, 22);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblDept = new JLabel("dept");
		lblDept.setBounds(16, 140, 63, 22);
		frame.getContentPane().add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(81, 138, 130, 26);
		frame.getContentPane().add(tfDept);
		
		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		tfGrade.setBounds(81, 163, 130, 26);
		frame.getContentPane().add(tfGrade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(223, 39, 356, 269);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public JFrame getFrame() {
		return frame;
	}
	
	private void infoSave(JTextArea textArea) {
		String textId = tfId.getText();
		String textUsername = tfUsername.getText();
		String textPassword = tfPassword.getText();
		String textDept = tfDept.getText();
		String textGrade = tfGrade.getText();
		textArea.append(textId+" "+textUsername+" "+textPassword+" "+textDept+" "+textGrade+"\n");
		tfId.setText("");
		tfUsername.setText("");
		tfPassword.setText("");
		tfDept.setText("");
		tfGrade.setText("");
	}
}
