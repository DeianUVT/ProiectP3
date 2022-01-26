package GameHub;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Xand0TwoPlayers {
	private JFrame frame;
	
	/**
	 * Launch the application for X and 0 two players.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xand0TwoPlayers window = new Xand0TwoPlayers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for X and 0 two players.
	 */
	public Xand0TwoPlayers() {
		initialize();
	}

	
	Random random = new Random();
	Boolean turnOfPlayerOne = random.nextBoolean();
	JLabel labelPlayerTurn;
	int playerOneChoice[] = new int[10];
	int playerTwoChoice[] = new int[10];
	JButton buttonPos1;
	JButton buttonPos2;
	JButton buttonPos3;
	JButton buttonPos4;
	JButton buttonPos5;
	JButton buttonPos6;
	JButton buttonPos7;
	JButton buttonPos8;
	JButton buttonPos9;
	JButton buttonRestart;
	static int playerOne = 0, playerTwo = 0, draws = 0;
	JLabel labelStats;
	
	/**
	 * Initialize the contents of the frame for X and 0 two players.
	 */
	private void initialize() {
		assignXand0twoPlayers(MainMenu.conn);
		
		frame = new JFrame();
		frame.setTitle("X and 0");
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		frame.setSize(500,500);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 500 / 2, center.y - 500 / 2, 500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonPos1 = new JButton("");
		buttonPos1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos1.setForeground(Color.BLACK);
		buttonPos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos1,1);
			}
		});
		buttonPos1.setBounds(80, 60, 100, 100);
		frame.getContentPane().add(buttonPos1);
		
		buttonPos2 = new JButton("");
		buttonPos2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos2.setForeground(Color.BLACK);
		buttonPos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos2,2);
			}
		});
		buttonPos2.setBounds(190, 60, 100, 100);
		frame.getContentPane().add(buttonPos2);
		
		buttonPos3 = new JButton("");
		buttonPos3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos3.setForeground(Color.BLACK);
		buttonPos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos3,3);
			}
		});
		buttonPos3.setBounds(300, 60, 100, 100);
		frame.getContentPane().add(buttonPos3);
		
		buttonPos4 = new JButton("");
		buttonPos4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos4.setForeground(Color.BLACK);
		buttonPos4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos4,4);
			}
		});
		buttonPos4.setBounds(80, 171, 100, 100);
		frame.getContentPane().add(buttonPos4);
		
		buttonPos5 = new JButton("");
		buttonPos5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos5.setForeground(Color.BLACK);
		buttonPos5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos5,5);
			}
		});
		buttonPos5.setBounds(190, 171, 100, 100);
		frame.getContentPane().add(buttonPos5);
		
		buttonPos6 = new JButton("");
		buttonPos6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos6.setForeground(Color.BLACK);
		buttonPos6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos6,6);
			}
		});
		buttonPos6.setBounds(300, 171, 100, 100);
		frame.getContentPane().add(buttonPos6);
		
		buttonPos7 = new JButton("");
		buttonPos7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos7.setForeground(Color.BLACK);
		buttonPos7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos7,7);
			}
		});
		buttonPos7.setBounds(80, 282, 100, 100);
		frame.getContentPane().add(buttonPos7);
		
		buttonPos8 = new JButton("");
		buttonPos8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos8.setForeground(Color.BLACK);
		buttonPos8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos8,8);
			}
		});
		buttonPos8.setBounds(190, 282, 100, 100);
		frame.getContentPane().add(buttonPos8);
		
		buttonPos9 = new JButton("");
		buttonPos9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos9.setForeground(Color.BLACK);
		buttonPos9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verification(buttonPos9,9);
			}
		});
		buttonPos9.setBounds(300, 282, 100, 100);
		frame.getContentPane().add(buttonPos9);
		
		labelPlayerTurn = new JLabel("Player 1 turn",SwingConstants.CENTER);
		if(!turnOfPlayerOne)
			labelPlayerTurn.setText("Player 2 turn");
		labelPlayerTurn.setForeground(Color.BLACK);
		labelPlayerTurn.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelPlayerTurn.setBounds(10, 10, 474, 38);
		frame.getContentPane().add(labelPlayerTurn);
		
		buttonRestart = new JButton("Restart");
		buttonRestart.setFocusable(false);
		buttonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerOneChoice = new int[10];
				playerTwoChoice = new int[10];
				enable_buttons();
				turnOfPlayerOne = random.nextBoolean();
				if(turnOfPlayerOne)
					labelPlayerTurn.setText("Player 1 turn");
				else
					labelPlayerTurn.setText("Player 2 turn");
				buttonRestart.setVisible(false);
			}
		});
		buttonRestart.setVisible(false);
		buttonRestart.setForeground(Color.BLACK);
		buttonRestart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonRestart.setBounds(190, 410, 100, 50);
		frame.getContentPane().add(buttonRestart);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setFocusable(false);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Xand0SelectMenu.main(null);
				frame.setVisible(false);	
				frame.dispose();
			}
		});
		buttonBack.setBounds(10, 10, 80, 25);
		frame.getContentPane().add(buttonBack);
		
		labelStats = new JLabel("Player wins: 0",SwingConstants.CENTER);
		labelStats.setForeground(Color.BLACK);
		labelStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStats.setText("<html>Player wins: " + playerOne + "<br/>Computer wins: " + playerTwo + "<br/>Draws: " + draws + "</html>");
		labelStats.setBounds(-10, 393, 190, 67);
		frame.getContentPane().add(labelStats);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					playerOne = 0;
					playerTwo = 0;
					draws = 0;
					labelStats.setText("<html>Player wins: " + playerOne + "<br/>Computer wins: " + playerTwo + "<br/>Draws: " + draws + "</html>");
					insertXand0twoPlayers(MainMenu.conn,playerOne,playerTwo,draws);
			}
		});
		buttonReset.setFocusable(false);
		buttonReset.setBounds(394, 10, 80, 25);
		frame.getContentPane().add(buttonReset);
	}

	/**
	 * This method checks if the game can continue, otherwise it gives the verdict
	 * 
	 * @param button Pressed button
	 * @param position Of the pressed button
	 */
	protected void verification(JButton button,int position) {
		if(turnOfPlayerOne)
		{
			button.setText("X");
			turnOfPlayerOne = false;
			button.setEnabled(false);
			labelPlayerTurn.setText("Player 2 turn");
			playerOneChoice[position] = 1;
		}
		else
		{
			button.setText("0");
			turnOfPlayerOne = true;
			button.setEnabled(false);
			labelPlayerTurn.setText("Player 1 turn");
			playerTwoChoice[position] = 1;
		}
		if(playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3] == 3 || playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6] == 3 || playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[4]+playerOneChoice[7] == 3 || playerOneChoice[2]+playerOneChoice[5]+playerOneChoice[8] == 3 || playerOneChoice[3]+playerOneChoice[6]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[5]+playerOneChoice[9] == 3 || playerOneChoice[3]+playerOneChoice[5]+playerOneChoice[7] == 3)
		{
			labelPlayerTurn.setText("Player 1 win!");
			buttonRestart.setVisible(true);
			disable_buttons();
			playerOne++;
		}
		else if(playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3] == 3 || playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6] == 3 || playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[4]+playerTwoChoice[7] == 3 || playerTwoChoice[2]+playerTwoChoice[5]+playerTwoChoice[8] == 3 || playerTwoChoice[3]+playerTwoChoice[6]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[5]+playerTwoChoice[9] == 3 || playerTwoChoice[3]+playerTwoChoice[5]+playerTwoChoice[7] == 3)
		{
			labelPlayerTurn.setText("Player 2 win!");
			buttonRestart.setVisible(true);
			disable_buttons();
			playerTwo++;
		}
		else if(playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3]+playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6]+playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9]+playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3]+playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6]+playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9]==9)
		{
			labelPlayerTurn.setText("Draw!");
			buttonRestart.setVisible(true);
			disable_buttons();
			draws++;
		}
		labelStats.setText("<html>Player wins: " + playerOne + "<br/>Computer wins: " + playerTwo + "<br/>Draws: " + draws + "</html>");
		insertXand0twoPlayers(MainMenu.conn,playerOne,playerTwo,draws);
	}

	/**
	 * This method disables all buttons
	 */
	protected void disable_buttons() {
		buttonPos1.setEnabled(false);
		buttonPos2.setEnabled(false);
		buttonPos3.setEnabled(false);
		buttonPos4.setEnabled(false);
		buttonPos5.setEnabled(false);
		buttonPos6.setEnabled(false);
		buttonPos7.setEnabled(false);
		buttonPos8.setEnabled(false);
		buttonPos9.setEnabled(false);
	}
	
	/**
	 * This method enables all buttons
	 */
	protected void enable_buttons() {
		buttonPos1.setEnabled(true);
		buttonPos2.setEnabled(true);
		buttonPos3.setEnabled(true);
		buttonPos4.setEnabled(true);
		buttonPos5.setEnabled(true);
		buttonPos6.setEnabled(true);
		buttonPos7.setEnabled(true);
		buttonPos8.setEnabled(true);
		buttonPos9.setEnabled(true);
		buttonPos1.setText("");
		buttonPos2.setText("");
		buttonPos3.setText("");
		buttonPos4.setText("");
		buttonPos5.setText("");
		buttonPos6.setText("");
		buttonPos7.setText("");
		buttonPos8.setText("");
		buttonPos9.setText("");
	}
	
	private static void assignXand0twoPlayers(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM xand0_two_players");
			while (rs.next()) {
				playerOne = rs.getInt("player_one");
				playerTwo = rs.getInt("player_two");
				draws = rs.getInt("draws");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insertXand0twoPlayers(Connection conn, int a, int b, int c) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO xand0_two_players VALUES (" + a + "," + b + "," + c + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
