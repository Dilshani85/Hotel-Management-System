import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
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
import javax.swing.JTable;

public class Guest extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtTelephone;
	private JTextField txtAddress;
	private JTextField txtId;

	private DefaultTableModel model; 
	private JTable table;
	
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
					Guest frame = new Guest();
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
	public Guest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1181, 632);
		contentPane.add(panel);
		
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
		
		JButton button_5 = new JButton("HOME");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Home home = new Home();
            	home.setVisible(true);   
			     dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_5.setBounds(10, 205, 183, 36);
		panel_1.add(button_5);
		
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
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblFirstName.setBounds(101, 45, 67, 23);
		panel_3.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(101, 70, 329, 28);
		panel_3.add(txtFirstName);
		
		JLabel lblGuest = new JLabel("GUEST");
		lblGuest.setFont(new Font("Calibri", Font.BOLD, 25));
		lblGuest.setBounds(404, 11, 114, 23);
		panel_3.add(lblGuest);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblLastName.setBounds(558, 45, 67, 23);
		panel_3.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(558, 70, 329, 28);
		panel_3.add(txtLastName);
		
		JLabel label_6 = new JLabel("Email");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_6.setBounds(558, 108, 67, 23);
		panel_3.add(label_6);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(558, 133, 329, 28);
		panel_3.add(txtEmail);
		
		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(101, 133, 329, 28);
		panel_3.add(txtTelephone);
		
		JLabel label_7 = new JLabel("Telephone");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_7.setBounds(101, 108, 67, 23);
		panel_3.add(label_7);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(101, 197, 329, 28);
		panel_3.add(txtAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAddress.setBounds(101, 172, 67, 23);
		panel_3.add(lblAddress);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(46, 255, 60, 28);
		panel_3.add(txtId);
		// Define columns and table model
		String[] columns = {"Guest ID", "First Name", "Last Name", "Email", "Phone", "Address"};
		model = new DefaultTableModel(columns, 0);
		table = new JTable(model);

		 
		// Wrap table in JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(42, 304, 893, 292); 

		// Add scroll pane to panel ONCE
		panel_3.add(scrollPane);

		// --- 🔥 Add MouseListener TO THE TABLE, NOT the JScrollPane ---
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) { // A row is selected
		            // Get values from the MODEL (important!)
		            String guestId = model.getValueAt(selectedRow, 0).toString();
		            String firstName = model.getValueAt(selectedRow, 1).toString();
		            String lastName = model.getValueAt(selectedRow, 2).toString();
		            String email = model.getValueAt(selectedRow, 3).toString();
		            String phone = model.getValueAt(selectedRow, 4).toString();
		            String address = model.getValueAt(selectedRow, 5).toString();

		            // Set values to text fields
		            txtId.setText(guestId);
		            txtFirstName.setText(firstName);
		            txtLastName.setText(lastName);
		            txtEmail.setText(email);
		            txtTelephone.setText(phone);
		            txtAddress.setText(address);
		        }
		    }
		});
	  
		
		JButton brnSave = new JButton("Insert");
		brnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				// Retrieve values from text fields
				String guestIdText = txtId.getText().trim(); // Optional if auto-increment
				String firstName = txtFirstName.getText().trim();
				String lastName = txtLastName.getText().trim();
				String telephone = txtTelephone.getText().trim();
				String email = txtEmail.getText().trim();
				String address = txtAddress.getText().trim();

				// --- Validation ---

				if (firstName.isEmpty() || lastName.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
				    JOptionPane.showMessageDialog(null,
				            "First Name, Last Name, Telephone, and Email are required!",
				            "Input Error",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}

				// Validate phone number (e.g., 10–15 digits only)
				if (!telephone.matches("\\d{10,15}")) {
				    JOptionPane.showMessageDialog(null,
				            "Phone number must be 10–15 digits.",
				            "Invalid Telephone",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}

				// Validate email format
				if (!isValidEmail(email)) {
				    JOptionPane.showMessageDialog(null,
				            "Please enter a valid email address.",
				            "Invalid Email",
				            JOptionPane.WARNING_MESSAGE);
				    return;
				}

				// SQL Insert Query
				String sql = "INSERT INTO tbl_guest (FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS) VALUES (?, ?, ?, ?, ?)";

				try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				     PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				    pstmt.setString(1, firstName);
				    pstmt.setString(2, lastName);
				    pstmt.setString(3, email);
				    pstmt.setString(4, telephone);
				    pstmt.setString(5, address);

				    int rowsInserted = pstmt.executeUpdate();

				    if (rowsInserted > 0) {
				        // Optionally get auto-generated guest ID
				        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				            if (generatedKeys.next()) {
				                int newGuestId = generatedKeys.getInt(1);
				                txtId.setText(String.valueOf(newGuestId)); // Show new ID in txtId field
				            }
				        }

				        JOptionPane.showMessageDialog(null,
				                "Guest inserted successfully!",
				                "Success",
				                JOptionPane.INFORMATION_MESSAGE);
				        
				        refreshGuestTable();
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
		brnSave.setBounds(467, 247, 151, 36);
		panel_3.add(brnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get values from text fields
			    String guestIdText = txtId.getText().trim();
			    String firstName = txtFirstName.getText().trim();
			    String lastName = txtLastName.getText().trim();
			    String email = txtEmail.getText().trim();
			    String telephone = txtTelephone.getText().trim();
			    String address = txtAddress.getText().trim();

			    // --- Validation ---
			    if (guestIdText.isEmpty()) {
			        JOptionPane.showMessageDialog(null,
			                "Guest ID is required to update the record.",
			                "Missing Guest ID",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    if (firstName.isEmpty() || lastName.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
			        JOptionPane.showMessageDialog(null,
			                "First Name, Last Name, Telephone, and Email are required!",
			                "Input Error",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // Validate phone number (e.g., 10–15 digits only)
			    if (!telephone.matches("\\d{10,15}")) {
			        JOptionPane.showMessageDialog(null,
			                "Phone number must be 10–15 digits.",
			                "Invalid Telephone",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // Validate email format
			    if (!isValidEmail(email)) {
			        JOptionPane.showMessageDialog(null,
			                "Please enter a valid email address.",
			                "Invalid Email",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    int guestId;
			    try {
			        guestId = Integer.parseInt(guestIdText);
			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null,
			                "Invalid Guest ID. Must be a number.",
			                "Input Error",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // SQL UPDATE Query
			    String sql = "UPDATE tbl_guest SET "
			               + "FIRST_NAME = ?, "
			               + "LAST_NAME = ?, "
			               + "EMAIL = ?, "
			               + "PHONE = ?, "
			               + "ADDRESS = ? "
			               + "WHERE GUEST_ID = ?";

			    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			         PreparedStatement pstmt = conn.prepareStatement(sql)) {

			        // Set parameters
			        pstmt.setString(1, firstName);
			        pstmt.setString(2, lastName);
			        pstmt.setString(3, email);
			        pstmt.setString(4, telephone);
			        pstmt.setString(5, address);
			        pstmt.setInt(6, guestId);

			        int rowsUpdated = pstmt.executeUpdate();

			        if (rowsUpdated > 0) {
			            JOptionPane.showMessageDialog(null,
			                    "Guest updated successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE);

			            // Optional: Refresh table to show updated data
			            refreshGuestTable();

			        } else {
			            JOptionPane.showMessageDialog(null,
			                    "No guest found with the given ID.",
			                    "Update Failed",
			                    JOptionPane.WARNING_MESSAGE);
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
		btnUpdate.setBounds(628, 247, 151, 36);
		panel_3.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get Guest ID from txtId field
			    String guestIdText = txtId.getText().trim();

			    // --- Validation ---
			    if (guestIdText.isEmpty()) {
			        JOptionPane.showMessageDialog(null,
			                "Please select a guest from the table to delete.",
			                "No Guest Selected",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    int guestId;
			    try {
			        guestId = Integer.parseInt(guestIdText);
			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null,
			                "Invalid Guest ID. Must be a number.",
			                "Input Error",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // Confirm deletion with user
			    int confirm = JOptionPane.showConfirmDialog(null,
			            "Are you sure you want to delete this guest?",
			            "Confirm Deletion",
			            JOptionPane.YES_NO_OPTION);

			    if (confirm != JOptionPane.YES_OPTION) {
			        return; // User canceled deletion
			    }

			    // SQL DELETE Query
			    String sql = "DELETE FROM tbl_guest WHERE GUEST_ID = ?";

			    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			         PreparedStatement pstmt = conn.prepareStatement(sql)) {

			        pstmt.setInt(1, guestId);

			        int rowsDeleted = pstmt.executeUpdate();

			        if (rowsDeleted > 0) {
			            JOptionPane.showMessageDialog(null,
			                    "Guest deleted successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE);

			            // Clear form fields
			            clearGuestForm();

			            // Refresh guest table to reflect changes
			            refreshGuestTable();

			        } else {
			            JOptionPane.showMessageDialog(null,
			                    "No guest found with the given ID.",
			                    "Delete Failed",
			                    JOptionPane.WARNING_MESSAGE);
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
		btnDelete.setBounds(788, 247, 151, 36);
		panel_3.add(btnDelete);
		
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
		
	}
	
	private boolean isValidEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    return email != null && email.matches(emailRegex);
	}
	
	public void refreshGuestTable() {
	    model.setRowCount(0);  

	    String query = "SELECT GUEST_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ADDRESS FROM tbl_guest";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	        while (rs.next()) {
	            model.addRow(new Object[]{
	                rs.getString("GUEST_ID"),
	                rs.getString("FIRST_NAME"),
	                rs.getString("LAST_NAME"),
	                rs.getString("EMAIL"),
	                rs.getString("PHONE"),
	                rs.getString("ADDRESS")
	            });
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, 
	            "Error loading guest data: " + ex.getMessage(), 
	            "Database Error", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	public void clearGuestForm() {
	    txtId.setText("");
	    txtFirstName.setText("");
	    txtLastName.setText("");
	    txtEmail.setText("");
	    txtTelephone.setText("");
	    txtAddress.setText("");
	}
	
	
	
	
	
	
	
	
	
}
