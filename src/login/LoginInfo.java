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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import db.DbBasic;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginInfo {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfSearch;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JTable table;
	private Connection conn;
	private final DefaultTableModel tableModel = new DefaultTableModel();
	private JComboBox cbCategory;
	private JComboBox cbName;
	

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
		conn = DbBasic.init();
		initialize();
		refreshTable();
		fillComboBox();
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
		tfId.setEditable(false);
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
				String sql = "INSERT INTO loginInfo (username, password, dept, grade) VALUES (?, ?, ?, ?)";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, tfUsername.getText()); // '김재민'
					statement.setString(2, tfPassword.getText());
					statement.setString(3, tfDept.getText());
					statement.setString(4, tfGrade.getText());
					statement.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					statement.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable();
				fillComboBox();
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
		
		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"id", "username", "password", "dept", "grade"}));
		cbCategory.setBounds(0, 6, 176, 27);
		frame.getContentPane().add(cbCategory);
		
		cbName = new JComboBox();
		cbName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = (String) cbName.getSelectedItem();
				System.out.println(username);
			}
		});
		cbName.setBounds(0, 34, 211, 27);
		frame.getContentPane().add(cbName);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
				//refreshTable();
			}

			
		});
		tfSearch.setBounds(188, 5, 178, 26);
		frame.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnNewButton_1.setBounds(367, 5, 94, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("load data");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
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
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getModel().getValueAt(row, 0).toString();
				
				String sql = "SELECT * FROM LoginInfo WHERE id = ?";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, id);
					ResultSet rs = statement.executeQuery();
					while(rs.next()) {
						tfId.setText(rs.getString(1));
						tfUsername.setText(rs.getString(2));
						tfPassword.setText(rs.getString(3));
						tfDept.setText(rs.getString(4));
						tfGrade.setText(rs.getString(5));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
	
	private void setTablefromDB(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData(); // 메타데이터 정보 가져오기
		
		Vector<String> columns = new Vector<String>(); // 컬럼 이름을 저장할 벡터
		int columnCount = metaData.getColumnCount(); 
		for (int i = 1; i <= columnCount; i++) {  
			columns.add(metaData.getColumnName(i)); // 이름 벡터에 메타정보로부터 컬럼 이름 가져와 추가하기
		}
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // 2차원 벡터 만들기
		while(rs.next()) {
			Vector<Object> vector = new Vector<Object>(); // 한 레코드를 담을 벡터
			for (int i = 1; i <= columnCount; i++) { 
				vector.add(rs.getObject(i)); // 벡터에 각 컬럼 데이터 추가하기
			}
			data.add(vector); // 레코드를 데이터 벡터에 추가
		}
		tableModel.setDataVector(data, columns); // 테이블모델에 데이터와 컬럼 추가
	}
	
	private void refreshTable() {
		String sql = "SELECT * FROM LoginInfo";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			setTablefromDB(rs);
			
			statement.close();
			rs.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void search() {
		String category = (String) cbCategory.getSelectedItem();
		String search = tfSearch.getText();
		String sql = "SELECT * from LoginInfo li WHERE " + category + " LIKE ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+search+"%");
			ResultSet rs = statement.executeQuery();
			setTablefromDB(rs);
			statement.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void fillComboBox() {
		cbName.removeAllItems();
		String sql = "select username from LoginInfo";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				cbName.addItem(rs.getString(1));
			}
			
			statement.close();
			rs.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
