import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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



public class Rooms extends JFrame {
	private JTable table; 

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtRoomNumber;
	private JTextField txtPrice;
	private JTextField txtDescription;  
	private JComboBox<String> comboBoxType;
	private JComboBox<String> comboBoxStatus;

	private DefaultTableModel model;
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
					Rooms frame = new Rooms();
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
	public Rooms() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 666);
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
		button_1.setBackground(new Color(204, 204, 255));
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
		


		String[] columns = {"Room ID", "Room Number", "Type", "Price", "Status", "Description"};
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
		            String roomNumber = model.getValueAt(selectedRow, 1).toString();
		            String type = model.getValueAt(selectedRow, 2).toString();
		            String price = model.getValueAt(selectedRow, 3).toString();
		            String status = model.getValueAt(selectedRow, 4).toString();
		            String description = model.getValueAt(selectedRow, 5).toString();


		            txtId.setText(id);
		            txtRoomNumber.setText(roomNumber);
		            txtPrice.setText(price);
		            txtDescription.setText(description);


		            if (comboBoxType != null)
		                comboBoxType.setSelectedItem(type);
		            if (comboBoxStatus != null)
		                comboBoxStatus.setSelectedItem(status);
		        }
		    }
		});
		
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(28, 255, 60, 28);
		panel_3.add(txtId);
		
		JButton btnSave = new JButton("Insert");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String roomId = txtId.getText().trim();
			        String roomNumber = txtRoomNumber.getText().trim(); 
			        String type = (String) comboBoxType.getSelectedItem();   
			        String status = (String) comboBoxStatus.getSelectedItem(); 
			        String priceStr = txtPrice.getText().trim();
			        String description = txtDescription.getText().trim();
			       // JOptionPane.showMessageDialog(null, status);
			        
 			        if (roomNumber.isEmpty() || type == null || status == null || priceStr.isEmpty()) {
			            JOptionPane.showMessageDialog(null, 
			                "Room Number, Type, Status, and Price are required!", 
			                "Input Error", 
			                JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        double price;
			        try {
			            price = Double.parseDouble(priceStr);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, 
			                "Please enter a valid number for Price.", 
			                "Invalid Price", 
			                JOptionPane.ERROR_MESSAGE);
			            return;
			        }
 
			        String sql;

			        if (roomId.isEmpty()) { 
			            sql = "INSERT INTO tbl_room (ROOM_NUMBER, TYPE, PRICE_PER_NIGHT, STATUS, DESCRIPTION) VALUES (?, ?, ?, ?, ?)";
			        } else { 
			            sql = "UPDATE tbl_room SET ROOM_NUMBER = ?, TYPE = ?, PRICE_PER_NIGHT = ?, STATUS = ?, DESCRIPTION = ? WHERE ROOM_ID = ?";
			        }

			        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			             PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
			            pstmt.setString(1, roomNumber);
			            pstmt.setString(2, type);
			            pstmt.setDouble(3, price);
			            pstmt.setString(4, status);
			            pstmt.setString(5, description);
 
			            if (!roomId.isEmpty()) {
			                pstmt.setInt(6, Integer.parseInt(roomId));
			            }

			            int rowsAffected = pstmt.executeUpdate();
			            if (rowsAffected > 0) {
			                JOptionPane.showMessageDialog(null, 
			                    roomId.isEmpty() ? "Room added successfully!" : "Room updated successfully!",
			                    "Success", 
			                    JOptionPane.INFORMATION_MESSAGE);

			                refreshRoomTable();  
 
			                txtId.setText("");
			                txtRoomNumber.setText("");
			                comboBoxType.setSelectedIndex(0);
			                comboBoxStatus.setSelectedIndex(0);
			                txtPrice.setText("");
			                txtDescription.setText("");
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
		btnSave.setBounds(449, 247, 151, 36);
		panel_3.add(btnSave);
		
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
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = txtId.getText().trim();
		        String roomNumber = txtRoomNumber.getText().trim();
		        String type = (String) comboBoxType.getSelectedItem();
		        String status = (String) comboBoxStatus.getSelectedItem();
		        String priceStr = txtPrice.getText().trim();
		        String description = txtDescription.getText().trim();
 
		        if (id.isEmpty() || roomNumber.isEmpty() || type == null || status == null || priceStr.isEmpty()) {
		            JOptionPane.showMessageDialog(null,
		                    "Please fill in all required fields.",
		                    "Input Error",
		                    JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        double price;
		        try {
		            price = Double.parseDouble(priceStr);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null,
		                    "Please enter a valid number for Price.",
		                    "Invalid Price",
		                    JOptionPane.ERROR_MESSAGE);
		            return;
		        }
 
		        String sql = "UPDATE tbl_room SET ROOM_NUMBER = ?, TYPE = ?, PRICE_PER_NIGHT = ?, STATUS = ?, DESCRIPTION = ? WHERE ROOM_ID = ?";

		        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {

		            // Set parameters
		            pstmt.setString(1, roomNumber);
		            pstmt.setString(2, type);
		            pstmt.setDouble(3, price);
		            pstmt.setString(4, status);
		            pstmt.setString(5, description);
		            pstmt.setString(6, id);

		            int rowsUpdated = pstmt.executeUpdate();

		            if (rowsUpdated > 0) {
		                JOptionPane.showMessageDialog(null, "Room updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
 
		                refreshRoomTable();
 
		                txtId.setText("");
		                txtRoomNumber.setText("");
		                txtPrice.setText("");
		                txtDescription.setText("");
		                comboBoxType.setSelectedIndex(0);
		                comboBoxStatus.setSelectedIndex(0);
		            } else {
		                JOptionPane.showMessageDialog(null, "No room found with this ID.", "Not Found", JOptionPane.WARNING_MESSAGE);
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
		btnUpdate.setBounds(610, 247, 151, 36);
		panel_3.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String roomId = txtId.getText().trim();

		        // Confirm deletion with user
		        int confirm = JOptionPane.showConfirmDialog(null,
		                "Are you sure you want to delete this room?",
		                "Confirm Deletion",
		                JOptionPane.YES_NO_OPTION);

		        if (confirm != JOptionPane.YES_OPTION) {
		            return;  
		        }
 
		        String sql = "DELETE FROM tbl_room WHERE ROOM_ID = ?";

		        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {

		            pstmt.setString(1, roomId);

		            int rowsDeleted = pstmt.executeUpdate();
		            if (rowsDeleted > 0) {
		                JOptionPane.showMessageDialog(null, "Room deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		                // Refresh table
		                refreshRoomTable();

		                // Clear input fields
		                txtId.setText("");
		                txtRoomNumber.setText("");
		                txtPrice.setText("");
		                txtDescription.setText("");
		                comboBoxType.setSelectedIndex(0);
		                comboBoxStatus.setSelectedIndex(0);
		            } else {
		                JOptionPane.showMessageDialog(null, "No room found with this ID.", "Not Found", JOptionPane.WARNING_MESSAGE);
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
		btnDelete.setBounds(770, 247, 151, 36);
		panel_3.add(btnDelete);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblStatus.setBounds(540, 108, 67, 23);
		panel_3.add(lblStatus);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblType.setBounds(540, 45, 67, 23);
		panel_3.add(lblType);
		
		JLabel lblRooms = new JLabel("ROOMS");
		lblRooms.setFont(new Font("Calibri", Font.BOLD, 25));
		lblRooms.setBounds(395, 11, 113, 23);
		panel_3.add(lblRooms);
		
		txtRoomNumber = new JTextField();
		txtRoomNumber.setColumns(10);
		txtRoomNumber.setBounds(83, 70, 329, 28);
		panel_3.add(txtRoomNumber);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRoomNumber.setBounds(83, 45, 151, 23);
		panel_3.add(lblRoomNumber);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(83, 133, 329, 28);
		panel_3.add(txtPrice);
		
		JLabel lblPricePreNight = new JLabel("Price Pre Night");
		lblPricePreNight.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPricePreNight.setBounds(83, 108, 151, 23);
		panel_3.add(lblPricePreNight);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(83, 197, 329, 28);
		panel_3.add(txtDescription);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblDescription.setBounds(83, 172, 120, 23);
		panel_3.add(lblDescription);
		
		
		comboBoxType = new JComboBox<>();
		comboBoxType.addItem("Single Room");
		comboBoxType.addItem("Double Room");
		comboBoxType.addItem("Family Room"); 
		comboBoxType.setBounds(540, 67, 262, 30);
		panel_3.add(comboBoxType);
		
		comboBoxStatus = new JComboBox<>();
		comboBoxStatus.addItem("Avaliable");
		comboBoxStatus.addItem("Not Avaliable"); 
		comboBoxStatus.setBounds(540, 132, 262, 30);
		panel_3.add(comboBoxStatus);
		 
		
		 
	}
	
	 
	public void refreshRoomTable() {
	    model.setRowCount(0);  

	    String query = "SELECT ROOM_ID, ROOM_NUMBER, TYPE, PRICE_PER_NIGHT, STATUS, DESCRIPTION FROM tbl_room";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	    	while (rs.next()) {
	            model.addRow(new Object[]{
	                rs.getString("ROOM_ID"),
	                rs.getString("ROOM_NUMBER"),
	                rs.getString("TYPE"),
	                rs.getString("PRICE_PER_NIGHT"),
	                rs.getString("STATUS"),
	                rs.getString("DESCRIPTION")
	            });
	        }

	    } catch (SQLException ex) {
	    	  ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, 
		            "Error loading room data: " + ex.getMessage(), 
		            "Database Error", 
		            JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
}
