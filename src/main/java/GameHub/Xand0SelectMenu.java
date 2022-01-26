package GameHub;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Xand0SelectMenu {

	private JFrame frame;
	static boolean dificultyEasy;

	/**
	 * Launch the application for X and 0 Menu.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xand0SelectMenu window = new Xand0SelectMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for X and 0 Menu.
	 */
	public Xand0SelectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame for X and 0 Menu.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setTitle("X and 0");
		frame.setSize(500,500);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 500 / 2, center.y - 500 / 2, 500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelSelectDificulty = new JLabel("Select dificulty:",SwingConstants.CENTER);
		labelSelectDificulty.setForeground(Color.WHITE);
		labelSelectDificulty.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelSelectDificulty.setBounds(0, 25, 474, 52);
		labelSelectDificulty.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(labelSelectDificulty);
		
		JButton buttonTwoPlayers = new JButton("Two players");
		buttonTwoPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xand0TwoPlayers.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonTwoPlayers.setForeground(Color.BLACK);
		buttonTwoPlayers.setBackground(Color.ORANGE);
		buttonTwoPlayers.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonTwoPlayers.setFocusable(false);
		buttonTwoPlayers.setBounds(40, 90, 400, 50);
		frame.getContentPane().add(buttonTwoPlayers);
		
		JButton buttonVsComputerEasy = new JButton("Vs computer(easy)");
		buttonVsComputerEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xand0Computer.main(null);
				dificultyEasy = true;
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonVsComputerEasy.setForeground(Color.BLACK);
		buttonVsComputerEasy.setBackground(Color.ORANGE);
		buttonVsComputerEasy.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonVsComputerEasy.setFocusable(false);
		buttonVsComputerEasy.setBounds(40, 151, 400, 50);
		frame.getContentPane().add(buttonVsComputerEasy);
		
		JButton buttonVsComputerHard = new JButton("Vs computer(hard)");
		buttonVsComputerHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xand0Computer.main(null);
				dificultyEasy = false;
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonVsComputerHard.setForeground(Color.BLACK);
		buttonVsComputerHard.setBackground(Color.ORANGE);
		buttonVsComputerHard.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		buttonVsComputerHard.setFocusable(false);
		buttonVsComputerHard.setBounds(40, 212, 400, 50);
		frame.getContentPane().add(buttonVsComputerHard);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonBack.setFocusable(false);
		buttonBack.setBounds(10, 10, 80, 25);
		frame.getContentPane().add(buttonBack);
	}
}
