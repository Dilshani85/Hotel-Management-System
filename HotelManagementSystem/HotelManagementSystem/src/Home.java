import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel panelChange;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1207, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(10, 25, 203, 607);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUsers = new JButton("RESERVATION");
		btnUsers.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Reservation home = new Reservation();
            	home.setVisible(true); 
            	home.loadRoomNumbers();
            	home.loadGuestNames();
            	home.loadReservationTable();
            	home.setLocationRelativeTo(null); 
			     dispose();
            }
        });
		 
		btnUsers.setBounds(10, 252, 183, 36);
		panel_1.add(btnUsers);
		
		JButton btnRooms = new JButton("ROOMS");
		btnRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rooms home = new Rooms();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshRoomTable();
			     dispose();
				
			}
		});
		btnRooms.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRooms.setBounds(10, 299, 183, 36);
		panel_1.add(btnRooms);
		
		JButton button_1 = new JButton("USERS");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users home = new Users();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshTable(); 
			     dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(10, 389, 183, 36);
		panel_1.add(button_1);
		
		JButton btnGuest = new JButton("GUEST");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Guest home = new Guest();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
				 home.refreshGuestTable();
			     dispose();
			}
		});
		btnGuest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuest.setBounds(10, 342, 183, 36);
		panel_1.add(btnGuest);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login home = new Login();
				 home.setVisible(true); 
				 home.setLocationRelativeTo(null); 
			     dispose();
			}
		});
		btnExit.setBounds(10, 560, 183, 36);
		panel_1.add(btnExit);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAdmin.setBounds(77, 119, 45, 23);
		panel_1.add(lblAdmin);
		
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
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Home home = new Home();
            	home.setVisible(true); 
            	home.setLocationRelativeTo(null); 
			     dispose();
				
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHome.setBounds(10, 205, 183, 36);
		panel_1.add(btnHome);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 0, 1172, 23);
		panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 51, 153));
		
		JLabel lblWelcomeTo = new JLabel("WELCOME TO HOTEL MANAGEMENT SYSTEM");
		lblWelcomeTo.setForeground(new Color(255, 255, 255));
		lblWelcomeTo.setBounds(10, 0, 301, 23);
		panel_3.add(lblWelcomeTo);
		lblWelcomeTo.setFont(new Font("Calibri", Font.BOLD, 15));
		
		JPanel pannelChange = new JPanel();
		pannelChange.setBackground(new Color(0, 255, 255));
		pannelChange.setBounds(214, 25, 968, 607);
		panel.add(pannelChange);
		 
		
		
	}
	 
	
	
}
