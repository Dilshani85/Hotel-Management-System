import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat; 
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtId; 
	public JComboBox<String> txtGuestName;
	public JComboBox<String> txtRoomType;
	
	private JDateChooser dateChooserCheckin;
	private JDateChooser dateChooserCheckout;
	private JTable table;
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
					Reservation frame = new Reservation();
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
	public Reservation() {
		
		   
        
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 670);
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
            	home.setLocationRelativeTo(null); 
            	home.loadReservationTable();
				 
			     dispose();
				
			}
		});
		button.setBackground(new Color(204, 204, 255));
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
		
		JLabel lblGuestName = new JLabel("Guest Name");
		lblGuestName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGuestName.setBounds(84, 45, 168, 23);
		panel_3.add(lblGuestName);
		
		JLabel lblReservation = new JLabel("RESERVATION");
		lblReservation.setFont(new Font("Calibri", Font.BOLD, 25));
		lblReservation.setBounds(369, 11, 158, 23);
		panel_3.add(lblReservation);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRoomType.setBounds(541, 45, 168, 23);
		panel_3.add(lblRoomType);
		
		JLabel lblCheckoutDate = new JLabel("Checkout Date");
		lblCheckoutDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCheckoutDate.setBounds(541, 108, 151, 23);
		panel_3.add(lblCheckoutDate);
		
		JLabel lblCheckingDate = new JLabel("Checkin Date");
		lblCheckingDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCheckingDate.setBounds(84, 108, 158, 23);
		panel_3.add(lblCheckingDate);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(29, 255, 60, 28);
		panel_3.add(txtId);
		
		JButton button_6 = new JButton("Insert");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String reservationIdText = txtId.getText().trim();
			    Object guestSelectedItem = txtGuestName.getSelectedItem();
			    Object roomSelectedItem = txtRoomType.getSelectedItem();
			    String guestName = (guestSelectedItem != null) ? guestSelectedItem.toString() : "";
			    String roomType = (roomSelectedItem != null) ? roomSelectedItem.toString() : "";

			 // Get Date from JDateChooser
			    Date checkInDate = dateChooserCheckin.getDate();
			    Date checkOutDate = dateChooserCheckout.getDate();

			    if (checkInDate == null || checkOutDate == null) {
			        JOptionPane.showMessageDialog(null, 
			            "Please select both Check-in and Check-out dates.", 
			            "Missing Date", 
			            JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // Format date for SQL insertion
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    String sqlCheckIn = sdf.format(checkInDate);
			    String sqlCheckOut = sdf.format(checkOutDate);

			    // Validate required fields
			    if (guestName.isEmpty() || roomType.isEmpty() || checkInDate == null || checkOutDate == null) {
			        JOptionPane.showMessageDialog(null,
			                "Guest Name, Room Type, Check-in, and Check-out dates are required!",
			                "Input Error",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }
			    
			    String remark = ""; // Optional field

			    
 
			    // Validate that check-out is after check-in
			    if (checkOutDate.before(checkInDate)) {
			        JOptionPane.showMessageDialog(null,
			                "Check-out date must be after Check-in date.",
			                "Invalid Date",
			                JOptionPane.WARNING_MESSAGE);
			        return;
			    }

			    // SQL Insert Query
			    String sql = "INSERT INTO tbl_reservation " +
			                 "(RESERVATION_ID, GUEST_NAME, ROOM_TYPE, CHECK_IN_DATE, CHECK_OUT_DATE, STATUS) " +
			                 "VALUES (?, ?, ?, ?, ?, ?)";

			    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			         PreparedStatement pstmt = conn.prepareStatement(sql)) {

			        // Set Reservation ID (optional)
			        if (reservationIdText.isEmpty()) {
			            pstmt.setNull(1, Types.INTEGER); // Allow auto-increment
			        } else {
			            try {
			                int reservationId = Integer.parseInt(reservationIdText);
			                pstmt.setInt(1, reservationId);
			            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null,
			                        "Reservation ID must be a valid number.",
			                        "Input Error",
			                        JOptionPane.WARNING_MESSAGE);
			                return;
			            }
			        }

			        pstmt.setString(2, guestName);
			        pstmt.setString(3, roomType);
			        pstmt.setString(4, sqlCheckIn);
			        pstmt.setString(5, sqlCheckOut);
			        pstmt.setString(6, "Pending"); 

			        int rowsInserted = pstmt.executeUpdate();
			        if (rowsInserted > 0) {
			            JOptionPane.showMessageDialog(null,
			                    "Reservation saved successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE);

			            clearForm();
			            loadReservationTable(); 
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
		button_6.setBounds(450, 247, 151, 36);
		panel_3.add(button_6);
		
		JButton button_7 = new JButton("Update");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int selectedRow = table.getSelectedRow();

				    if (selectedRow == -1) {
				        JOptionPane.showMessageDialog(null, "Please select a reservation to update.");
				        return;
				    }

				    String reservationIdStr = model.getValueAt(selectedRow, 0).toString();
				    int reservationId;
				    try {
				        reservationId = Integer.parseInt(reservationIdStr);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null, "Invalid Reservation ID.");
				        return;
				    }

				    Object guestSelectedItem = txtGuestName.getSelectedItem();
				    Object roomSelectedItem = txtRoomType.getSelectedItem();
				    String guestName = (guestSelectedItem != null) ? guestSelectedItem.toString() : "";
				    String roomType = (roomSelectedItem != null) ? roomSelectedItem.toString() : "";

				    Date checkInDate = dateChooserCheckin.getDate();
				    Date checkOutDate = dateChooserCheckout.getDate();

				    if (guestName.isEmpty() || roomType.isEmpty() || checkInDate == null || checkOutDate == null) {
				        JOptionPane.showMessageDialog(null,
				                "Guest Name, Room Type, Check-in, and Check-out dates are required!",
				                "Input Error",
				                JOptionPane.WARNING_MESSAGE);
				        return;
				    }

				    if (checkOutDate.before(checkInDate)) {
				        JOptionPane.showMessageDialog(null,
				                "Check-out date must be after Check-in date.",
				                "Invalid Date",
				                JOptionPane.WARNING_MESSAGE);
				        return;
				    }

				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    String sqlCheckIn = sdf.format(checkInDate);
				    String sqlCheckOut = sdf.format(checkOutDate);

				    String sql = "UPDATE tbl_reservation SET " +
				                 "GUEST_NAME = ?, ROOM_TYPE = ?, CHECK_IN_DATE = ?, CHECK_OUT_DATE = ? " +
				                 "WHERE RESERVATION_ID = ?";

				    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				         PreparedStatement pstmt = conn.prepareStatement(sql)) {

				        pstmt.setString(1, guestName);
				        pstmt.setString(2, roomType);
				        pstmt.setString(3, sqlCheckIn);
				        pstmt.setString(4, sqlCheckOut);
				        pstmt.setInt(5, reservationId);

				        int rowsUpdated = pstmt.executeUpdate();

				        if (rowsUpdated > 0) {
				            JOptionPane.showMessageDialog(null,
				                    "Reservation updated successfully!",
				                    "Success",
				                    JOptionPane.INFORMATION_MESSAGE);

				            loadReservationTable(); 
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
		button_7.setBounds(611, 247, 151, 36);
		panel_3.add(button_7);
		
		JButton button_8 = new JButton("Delete");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
			    int selectedRow = table.getSelectedRow();

			    if (selectedRow == -1) {
			        JOptionPane.showMessageDialog(null, "Please select a reservation to delete.");
			        return;
			    }
 
			    int confirm = JOptionPane.showConfirmDialog(null,
			            "Are you sure you want to delete this reservation?",
			            "Confirm Deletion",
			            JOptionPane.YES_NO_OPTION);

			    if (confirm != JOptionPane.YES_OPTION) {
			        return; 
			    }
 
			    String reservationIdStr = model.getValueAt(selectedRow, 0).toString();
			    int reservationId;

			    try {
			        reservationId = Integer.parseInt(reservationIdStr);
			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "Invalid Reservation ID.");
			        return;
			    }
 
			    String sql = "DELETE FROM tbl_reservation WHERE RESERVATION_ID = ?";

			    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			         PreparedStatement pstmt = conn.prepareStatement(sql)) {

			        pstmt.setInt(1, reservationId);

			        int rowsDeleted = pstmt.executeUpdate();

			        if (rowsDeleted > 0) {
			            JOptionPane.showMessageDialog(null,
			                    "Reservation deleted successfully!",
			                    "Success",
			                    JOptionPane.INFORMATION_MESSAGE);
 
			            model.removeRow(selectedRow);
 
			            txtGuestName.setSelectedIndex(-1);
			            txtRoomType.setSelectedIndex(-1);
			            dateChooserCheckin.setDate(null);
			            dateChooserCheckout.setDate(null);

			        } else {
			            JOptionPane.showMessageDialog(null,
			                    "No reservation found with the given ID.",
			                    "Not Found",
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
		button_8.setBounds(771, 247, 151, 36);
		panel_3.add(button_8);
		
		 
		txtGuestName = new JComboBox<>();
		txtGuestName.setBounds(84, 69, 329, 30);
		panel_3.add(txtGuestName);

		txtRoomType = new JComboBox<>();
		txtRoomType.setBounds(541, 69, 329, 30);
		panel_3.add(txtRoomType);
		 
         
		
		
		
		 dateChooserCheckin = new JDateChooser();
		dateChooserCheckin.setBounds(84, 133, 329, 28);
		panel_3.add(dateChooserCheckin); 
		
		 dateChooserCheckout = new JDateChooser();
		dateChooserCheckout.setBounds(541, 133, 329, 28);
		panel_3.add(dateChooserCheckout);
		

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
		  
		String[] columns = {"Reservation ID", "Guest Name", "Room Type", "Check-in Date", "Check-out Date", "Status"};
		model = new DefaultTableModel(columns, 0);
		table = new JTable(model);
 
		JScrollPane scrollPane = new JScrollPane(table); 
		 
		scrollPane.setBounds(42, 304, 893, 292);
		panel_3.add(scrollPane);
 
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow != -1) {  
		        	 
		            String id = model.getValueAt(selectedRow, 0).toString();  
		            String guestName = model.getValueAt(selectedRow, 1).toString(); 
		            String roomType = model.getValueAt(selectedRow, 2).toString();  
		            String checkInStr = model.getValueAt(selectedRow, 3).toString(); 
		            String checkOutStr = model.getValueAt(selectedRow, 4).toString();  
 
		            txtGuestName.setSelectedItem(guestName);
		            txtRoomType.setSelectedItem(roomType);
		            txtId.setText(id);
		             
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            try {
		                Date checkInDate = sdf.parse(checkInStr);
		                Date checkOutDate = sdf.parse(checkOutStr);

		                dateChooserCheckin.setDate(checkInDate);
		                dateChooserCheckout.setDate(checkOutDate);

		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error parsing date format.");
		                ex.printStackTrace();
		            }
		        }
		    }
		});
	    scrollPane.setBounds(42, 304, 893, 292);  
 
	    panel_3.add(scrollPane);
		
	    loadGuestNames();
         loadRoomNumbers();
	     loadReservationTable();
		
		
	}
	 
	
	private void clearForm() {
	    txtId.setText(""); 
	    dateChooserCheckin.setDate(null);
	    dateChooserCheckout.setDate(null);
	    loadGuestNames();
	    loadRoomNumbers();
	    
	}
	
	public void loadGuestNames() {
	    String query = "SELECT FIRST_NAME, LAST_NAME FROM tbl_guest";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	         txtGuestName.removeAllItems(); 

	        while (rs.next()) {
	            String firstName = rs.getString("FIRST_NAME");
	            String lastName = rs.getString("LAST_NAME");
	            txtGuestName.addItem(firstName + " " + lastName);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error loading guests: " + ex.getMessage());
	    }
	}
	
	public void loadRoomNumbers() {
	    String query = "SELECT ROOM_NUMBER FROM tbl_room ORDER BY ROOM_NUMBER";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	        txtRoomType.removeAllItems();

	        while (rs.next()) {
	            String roomNumber = rs.getString("ROOM_NUMBER");
	            if (roomNumber != null && !roomNumber.trim().isEmpty()) {
	                txtRoomType.addItem(roomNumber.trim());
	            }
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error loading room numbers: " + ex.getMessage());
	    }
	}
	
	
	public void loadReservationTable() {
	    
	    model.setRowCount(0);  
	   
	    String query = "SELECT * FROM tbl_reservation";

	    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {

	        while (rs.next()) {
	            int reservationId = rs.getInt("RESERVATION_ID");
	            String guestName = rs.getString("GUEST_NAME");
	            String roomType = rs.getString("ROOM_TYPE"); 
	            
	            Date checkInDate = rs.getDate("CHECK_IN_DATE");
	            Date checkOutDate = rs.getDate("CHECK_OUT_DATE");

	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            String checkInStr = (checkInDate != null) ? sdf.format(checkInDate) : "";
	            String checkOutStr = (checkOutDate != null) ? sdf.format(checkOutDate) : "";
	            
	            String status = rs.getString("STATUS");

	          

	            model.addRow(new Object[]{
	                reservationId,
	                guestName,
	                roomType,
	                checkInStr,
	                checkOutStr,
	                status
	            });
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null,
	                "Error loading reservation data: " + ex.getMessage(),
	                "Database Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
}
