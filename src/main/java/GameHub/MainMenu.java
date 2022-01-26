package GameHub;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;
	
	/**
	 * Launch the application for Main Menu.
	 * @author Carlos Pera
	 * @author Deian Pauta
	 * @version 1.0
	 * @since 27.01.2022
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for Main Menu.
	 */
	public MainMenu() {
		initialize();
	}

	static Connection conn;
	
	/**
	 * Initialize the contents of the frame for Main Menu.
	 */
	private void initialize() {
		String DB_URL = "jdbc:derby://localhost:1527/exemplu";
		conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (!conn.isClosed()) {
				System.out.println("JDBC Successfully connected to Derby Server.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setTitle("The game hub");
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setSize(500,500);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 500 / 2, center.y - 500 / 2, 500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonRockPaperScissors = new JButton("Rock, paper, scissors");
		buttonRockPaperScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RockPaperScissors.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonRockPaperScissors.setBackground(Color.ORANGE);
		buttonRockPaperScissors.setFocusable(false);
		buttonRockPaperScissors.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonRockPaperScissors.setForeground(Color.BLACK);
		buttonRockPaperScissors.setBounds(150, 155, 200, 50);
		frame.getContentPane().add(buttonRockPaperScissors);
		
		JButton buttonThrowTheDice = new JButton("Throw the dice");
		buttonThrowTheDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThrowTheDice.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonThrowTheDice.setBackground(Color.ORANGE);
		buttonThrowTheDice.setFocusable(false);
		buttonThrowTheDice.setForeground(Color.BLACK);
		buttonThrowTheDice.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonThrowTheDice.setBounds(150, 215, 200, 50);
		frame.getContentPane().add(buttonThrowTheDice);
		
		JLabel labelTitle = new JLabel("THE GAME HUB",SwingConstants.CENTER);
		labelTitle.setForeground(Color.WHITE);
		labelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelTitle.setBounds(10, 70, 470, 40);
		frame.getContentPane().add(labelTitle);
		
		JButton buttonXand0 = new JButton("Tic Tac Toe");
		buttonXand0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xand0SelectMenu.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonXand0.setBackground(Color.ORANGE);
		buttonXand0.setFocusable(false);
		buttonXand0.setForeground(Color.BLACK);
		buttonXand0.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonXand0.setBounds(150, 276, 200, 50);
		frame.getContentPane().add(buttonXand0);
		
		JButton buttonSlotMachine = new JButton("Roulette");
		buttonSlotMachine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roulette.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonSlotMachine.setBackground(Color.ORANGE);
		buttonSlotMachine.setFocusable(false);
		buttonSlotMachine.setForeground(Color.BLACK);
		buttonSlotMachine.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonSlotMachine.setBounds(150, 337, 200, 50);
		frame.getContentPane().add(buttonSlotMachine);
	}
}
