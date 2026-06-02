import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/HMSYSTEM";
    private static final String DB_USER = "root";  
    private static final String DB_PASSWORD = "Abc@1234";   
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 729, 431);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(10, 11, 349, 409);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("C:/Users/ANURADHA/workspace/HotelManagementSystem/Image/22.jpg");
		lblNewLabel_1.setBounds(0, 0, 349, 409);
		panel_1.add(lblNewLabel_1); 
		ImageIcon originalIcon = new ImageIcon("C:/Users/ANURADHA/workspace/HotelManagementSystem/Image/22.jpg");
		Image scaledImage = originalIcon.getImage().getScaledInstance(
				lblNewLabel_1.getWidth(), 
				lblNewLabel_1.getHeight(), 
		    Image.SCALE_SMOOTH
		);
		ImageIcon scaledIcon = new ImageIcon(scaledImage); 
		lblNewLabel_1.setIcon(scaledIcon);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(369, 11, 349, 409);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(146, 56, 67, 23);
		panel_2.add(lblNewLabel);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(10, 125, 329, 28);
		panel_2.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblUsername.setBounds(10, 100, 67, 23);
		panel_2.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPassword.setBounds(10, 164, 67, 23);
		panel_2.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 189, 329, 28);
		panel_2.add(txtPassword);
		
		final JButton btnNewButton = new JButton("LOGIN");
		 
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
  	        
				String username = txtUserName.getText();
				String password = new String(txtPassword.getText());

				if (authenticate(username, password)) {
				    JOptionPane.showMessageDialog(Login.this, "Login successful!");

				    Home home = new Home();
				    home.setVisible(true);
				    home.setLocationRelativeTo(null);  
				    dispose();
				} else {
				    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}
		        
		        
			}
		});
		btnNewButton.setBounds(10, 235, 329, 36);
		panel_2.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     dispose();

			}
		});
		btnExit.setBounds(10, 282, 329, 36);
		panel_2.add(btnExit);
		
		
		
		
		
	}
	
	private boolean authenticate(String username, String password) {
	    String query = "SELECT * FROM tbl_user WHERE USERNAME = ? AND PASSWORD_HASH = ?";
	    Connection conn = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        pst = conn.prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, password);
	        rs = pst.executeQuery();

	        return rs.next(); // true if match found
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    } finally {
	        // Close resources in finally block
	        try {
	            if (rs != null) rs.close();
	        } catch (SQLException e) { /* Ignore */ }

	        try {
	            if (pst != null) pst.close();
	        } catch (SQLException e) { /* Ignore */ }

	        try {
	            if (conn != null) conn.close();
	        } catch (SQLException e) { /* Ignore */ }
	    }
	}
}
