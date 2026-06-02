import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;




public class Users extends JFrame {

	private JPanel contentPane;
	 
	private JTextField txtUsername;
	private JTextField txtTelephone;
	private JTextField txtRole;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel model;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/HMSYSTEM";
	private static final String DB_USER = "root";  
	private static final String DB_PASSWORD = "Abc@1234"; 
	private JTextField txtId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Users frame = new Users();
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
	public Users() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1181, 632);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 153));
		panel_2.setBounds(10, 0, 1172, 23);
		panel.add(panel_2);
		
		JLabel label_2 = new JLabel("WELCOME TO HOTEL MANAGEMENT SYSTEM");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Calibri", Font.BOLD, 15));
		label_2.setBounds(10, 0, 301, 23);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(214, 25, 968, 607);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		// Define columns and model
		String[] columns = {"User ID", "Username", "Password", "Telephone", "Email", "Role"};
		model = new DefaultTableModel(columns, 0);
		table = new JTable(model);
 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(42, 304, 893, 292); 
		panel_3.add(scrollPane);
 
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) {  
		            String id = model.getValueAt(selectedRow, 0).toString();  
		            String username = model.getValueAt(selectedRow, 1).toString();
		            String password = model.getValueAt(selectedRow, 2).toString();
		            String telephone = model.getValueAt(selectedRow, 3).toString();
		            String email = model.getValueAt(selectedRow, 4).toString();
		            String role = model.getValueAt(selectedRow, 5).toString();
 
		            txtId.setText(id);
		            txtUsername.setText(username);
		            txtPassword.setText(password);
		            txtTelephone.setText(telephone);
		            txtEmail.setText(email);
		            txtRole.setText(role);
		        }
		    }
		});
		 
		panel_3.add(scrollPane);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(97, 80, 329, 28);
		panel_3.add(txtUsername);
		
		JLabel label_3 = new JLabel("UserName");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_3.setBounds(97, 55, 67, 23);
		panel_3.add(label_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String userId = txtId.getText();

			        // Confirm deletion
			        int confirm = JOptionPane.showConfirmDialog(null, 
			                "Are you sure you want to delete this user?", 
			                "Confirm Deletion", 
			                JOptionPane.YES_NO_OPTION);

			        if (confirm != JOptionPane.YES_OPTION) {
			            return;  
			        }
 
			        String sql = "DELETE FROM tbl_user WHERE USER_ID = ?";

			        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			             PreparedStatement pstmt = conn.prepareStatement(sql)) {

			            pstmt.setString(1, userId);

			            int rowsDeleted = pstmt.executeUpdate();
			            if (rowsDeleted > 0) {
			                JOptionPane.showMessageDialog(null, "User deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
 
			                refreshTable();
 
			                txtId.setText("");
			                txtUsername.setText("");
			                txtPassword.setText("");
			                txtTelephone.setText("");
			                txtEmail.setText("");
			                txtRole.setText("");
			            } else {
			                JOptionPane.showMessageDialog(null, "No user found with this ID.", "Not Found", JOptionPane.WARNING_MESSAGE);
			            }

			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			        }
				
			}
		});
		btnDelete.setBounds(784, 257, 151, 36);
		panel_3.add(btnDelete);
		
		JLabel lblUsers = new JLabel("USERS");
		lblUsers.setFont(new Font("Calibri", Font.BOLD, 25));
		lblUsers.setBounds(425, 21, 67, 23);
		panel_3.add(lblUsers);
		
		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(97, 143, 329, 28);
		panel_3.add(txtTelephone);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTelephone.setBounds(97, 118, 67, 23);
		panel_3.add(lblTelephone);
		
		txtRole = new JTextField();
		txtRole.setColumns(10);
		txtRole.setBounds(97, 207, 329, 28);
		panel_3.add(txtRole);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRole.setBounds(97, 182, 67, 23);
		panel_3.add(lblRole);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(554, 80, 329, 28);
		panel_3.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPassword.setBounds(554, 55, 67, 23);
		panel_3.add(lblPassword);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(554, 143, 329, 28);
		panel_3.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmail.setBounds(554, 118, 67, 23);
		panel_3.add(lblEmail);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
		        String id = txtId.getText();
		        String username = txtUsername.getText();
		        String password = new String(txtPassword.getText());  
		        String telephone = txtTelephone.getText();
		        String email = txtEmail.getText();
		        String role = txtRole.getText();

		        if (id.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "User ID, Username, Password, and Role are required!", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        String sql = "UPDATE tbl_user SET USERNAME = ?, PASSWORD_HASH = ?, TELEPHONE = ?, EMAIL = ?, ROLE = ? WHERE USER_ID = ?";

		        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {

		            pstmt.setString(1, username);
		            pstmt.setString(2, password); 
		            pstmt.setString(3, telephone);
		            pstmt.setString(4, email);
		            pstmt.setString(5, role);
		            pstmt.setString(6, id);

		            int rowsUpdated = pstmt.executeUpdate();
		            if (rowsUpdated > 0) {
		                JOptionPane.showMessageDialog(null, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		                refreshTable();

		                txtId.setText("");
		                txtUsername.setText("");
		                txtPassword.setText("");
		                txtTelephone.setText("");
		                txtEmail.setText("");
		                txtRole.setText("");
		            } else {
		                JOptionPane.showMessageDialog(null, "No user found with this ID.", "Not Found", JOptionPane.WARNING_MESSAGE);
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnUpdate.setBounds(624, 257, 151, 36);
		panel_3.add(btnUpdate);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				String username = txtUsername.getText().trim();
				String password = new String(txtPassword.getText()).trim(); // Better for JPasswordField
				String telephone = txtTelephone.getText().trim();
				String email = txtEmail.getText().trim();
				String role = txtRole.getText().trim();
 
				if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
				    JOptionPane.showMessageDialog(null,
				            "Username, Password, and Role are required!",
				            "Input Error",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}
 
				if (!isValidEmail(email)) {
				    JOptionPane.showMessageDialog(null,
				            "Please enter a valid email address.",
				            "Invalid Email",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}
 
				if (!telephone.isEmpty() && !telephone.matches("\\d{10}")) {
				    JOptionPane.showMessageDialog(null,
				            "Telephone must be 10 digits if provided.",
				            "Invalid Telephone",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}
 
				String sql = "INSERT INTO tbl_user (USERNAME, PASSWORD_HASH, TELEPHONE, EMAIL, ROLE) VALUES (?, ?, ?, ?, ?)";

				try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				     PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
				    pstmt.setString(1, username);
				    pstmt.setString(2, password);  
				    pstmt.setString(3, telephone);
				    pstmt.setString(4, email);
				    pstmt.setString(5, role);
 
				    int rowsInserted = pstmt.executeUpdate();
				    if (rowsInserted > 0) {
				        JOptionPane.showMessageDialog(null, "User inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				        refreshTable();
				        txtUsername.setText("");
				        txtPassword.setText("");
				        txtTelephone.setText("");
				        txtEmail.setText("");
				        txtRole.setText("");
				    }

				} catch (SQLException ex) {
				    ex.printStackTrace();
				    JOptionPane.showMessageDialog(null,
				            "Database Error: " + ex.getMessage(),
				            "Error",
				            JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnInsert.setBounds(463, 257, 151, 36);
		panel_3.add(btnInsert);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(42, 265, 60, 28);
		panel_3.add(txtId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(10, 25, 203, 607);
		panel.add(panel_1);
		
		JButton button = new JButton("RESERVATION");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reservation home = new Reservation();
            	home.setVisible(true); 
            	home.loadRoomNumbers();
            	home.loadGuestNames();
            	home.loadReservationTable();
            	home.setLocationRelativeTo(null); 
			     dispose();
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 252, 183, 36);
		panel_1.add(button);
		
		JButton button_1 = new JButton("ROOMS");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Rooms home = new Rooms();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshRoomTable();
				 home.setLocationRelativeTo(null); 
			     dispose();
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(10, 299, 183, 36);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("USERS");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users home = new Users();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshTable(); 
			     dispose();
				
			}
		});
		button_2.setBackground(new Color(204, 204, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(10, 389, 183, 36);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("GUEST");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guest home = new Guest();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshGuestTable();
			     dispose();
				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBounds(10, 342, 183, 36);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("EXIT");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login home = new Login();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
			     dispose();
				
			}
		});
		button_4.setBounds(10, 560, 183, 36);
		panel_1.add(button_4);
		
		JLabel label = new JLabel("ADMIN");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(77, 119, 45, 23);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel((Icon) null);
		label_1.setBounds(49, 26, 106, 92);
		panel_1.add(label_1);


		JLabel imageLabel = new JLabel(new ImageIcon("C:/Users/ANURADHA/workspace/HotelManagementSystem/Image/admin.png"));
		imageLabel.setBounds(49, 26, 106, 92);
		panel_1.add(imageLabel);
		ImageIcon originalIcon = new ImageIcon("C:/Users/ANURADHA/workspace/HotelManagementSystem/Image/admin.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(
		    imageLabel.getWidth(), 
		    imageLabel.getHeight(), 
		    Image.SCALE_SMOOTH
		);
		ImageIcon scaledIcon = new ImageIcon(scaledImage); 
		imageLabel.setIcon(scaledIcon);
		
		JButton button_5 = new JButton("HOME");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Home home = new Home();
        	home.setVisible(true);   
		     dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_5.setBounds(10, 207, 183, 36);
		panel_1.add(button_5);
		
		refreshTable();
	}
	
	
	///email validation
	private boolean isValidEmail(String email) {
	    if (email == null || email.isEmpty()) return false; 
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    return email.matches(emailRegex);
	}
	
	public void refreshTable() {
	    model.setRowCount(0);  

	    String query = "SELECT USER_ID, USERNAME, PASSWORD_HASH, TELEPHONE, EMAIL, ROLE FROM tbl_user";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	        while (rs.next()) {
	            int userId = rs.getInt("USER_ID");
	            String username = rs.getString("USERNAME");
	            String password = rs.getString("PASSWORD_HASH");
	            String telephone = rs.getString("TELEPHONE");
	            String email = rs.getString("EMAIL");
	            String role = rs.getString("ROLE");

	            model.addRow(new Object[]{userId, username, password, telephone, email, role});
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
