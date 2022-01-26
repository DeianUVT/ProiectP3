package GameHub;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RockPaperScissors {

	private JFrame frame;
	Random random = new Random();
	static int computerScoreCounter;
	static int playerScoreCounter;
	static int drawCounter;
	JLabel labelYouWonOrLost;
	JLabel labelGameStats;

	/**
	 * Launch the application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissors window = new RockPaperScissors();
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
	public RockPaperScissors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		assignRockPaperScissors(MainMenu.conn);
		
		frame = new JFrame();
		frame.setTitle("Rock, paper, scissors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 500 / 2, center.y - 500 / 2, 500, 500);
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		final Icon iconRock = new ImageIcon(((new ImageIcon(
	            "rock.png").getImage()
	            .getScaledInstance(100, 100,
	                    java.awt.Image.SCALE_SMOOTH))));
		final Icon iconPaper = new ImageIcon(((new ImageIcon(
	            "paper.png").getImage()
	            .getScaledInstance(100, 100,
	                    java.awt.Image.SCALE_SMOOTH))));
		final Icon iconScissors = new ImageIcon(((new ImageIcon(
	            "scissors.png").getImage()
	            .getScaledInstance(100, 100,
	                    java.awt.Image.SCALE_SMOOTH))));
		
		JLabel labelComputerTurn = new JLabel("Computer choice:",SwingConstants.CENTER);
		labelComputerTurn.setForeground(Color.BLACK);
		labelComputerTurn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelComputerTurn.setBounds(0, 10, 474, 25);
		frame.getContentPane().add(labelComputerTurn);
		
		final JButton buttonComputerChoice = new JButton(new ImageIcon(((new ImageIcon(
	            "QuestionMark.png").getImage()
	            .getScaledInstance(100, 100,
	                    java.awt.Image.SCALE_SMOOTH)))));
		buttonComputerChoice.setFocusable(false);
		buttonComputerChoice.setBorderPainted(false);
		buttonComputerChoice.setFocusPainted(false);
		buttonComputerChoice.setContentAreaFilled(false);
		buttonComputerChoice.setBounds(190, 50, 100, 100);
		frame.getContentPane().add(buttonComputerChoice);
		
		JButton buttonRock = new JButton(iconRock);
		buttonRock.setFocusable(false);
		buttonRock.setFocusPainted(false);
		buttonRock.setContentAreaFilled(false);
		buttonRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand_computer = random.nextInt(3) + 1;
			    if (rand_computer == 1) {
			    	labelYouWonOrLost.setText("Draw");
			    	drawCounter++;
			    	buttonComputerChoice.setIcon(iconRock);
			    } else if (rand_computer == 2) {
			    	labelYouWonOrLost.setText("Win");
			    	buttonComputerChoice.setIcon(iconScissors);
			    	playerScoreCounter++;
			    } else if (rand_computer == 3) {
			    	labelYouWonOrLost.setText("Lost");
			    	buttonComputerChoice.setIcon(iconPaper);
			    	computerScoreCounter++;
			    }
			    labelGameStats.setText("<html>Player wins: "+playerScoreCounter+"<br/>Computer wins: "+computerScoreCounter+"<br/>Draws: "+drawCounter+"</html>");
			    insertRockPaperScissors(MainMenu.conn,playerScoreCounter,computerScoreCounter,drawCounter);
			}
		});
		buttonRock.setBounds(80, 216, 100, 100);
		frame.getContentPane().add(buttonRock);
		
		JButton buttonPaper = new JButton(iconPaper);
		buttonPaper.setFocusable(false);
		buttonPaper.setFocusPainted(false);
		buttonPaper.setContentAreaFilled(false);
		buttonPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand_computer = random.nextInt(3) + 1;
			    if (rand_computer == 1){
			    	labelYouWonOrLost.setText("Win");
			    	buttonComputerChoice.setIcon(iconRock);
			    	playerScoreCounter++;
			    } else if (rand_computer == 2){
			    	labelYouWonOrLost.setText("Lost");
			    	buttonComputerChoice.setIcon(iconScissors);
			    	computerScoreCounter++;
			    } else if (rand_computer == 3){
			    	labelYouWonOrLost.setText("Draw");
			    	buttonComputerChoice.setIcon(iconPaper);
			    	drawCounter++;
			    }
			    labelGameStats.setText("<html>Player wins: "+playerScoreCounter+"<br/>Computer wins: "+computerScoreCounter+"<br/>Draws: "+drawCounter+"</html>");
			    insertRockPaperScissors(MainMenu.conn,playerScoreCounter,computerScoreCounter,drawCounter);
			}
		});
		buttonPaper.setBounds(190, 216, 100, 100);
		frame.getContentPane().add(buttonPaper);
		
		JButton buttonScissors = new JButton(iconScissors);
		buttonScissors.setFocusable(false);
		buttonScissors.setFocusPainted(false);
		buttonScissors.setContentAreaFilled(false);
		buttonScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand_computer = random.nextInt(3) + 1;
			    if (rand_computer == 1) {
			    	labelYouWonOrLost.setText("Lost");
			    	buttonComputerChoice.setIcon(iconRock);
			    	computerScoreCounter++;
			    } else if (rand_computer == 2) {
			    	labelYouWonOrLost.setText("Draw");
			    	buttonComputerChoice.setIcon(iconScissors);
			    	drawCounter++;
			    } else if (rand_computer == 3) {
			    	labelYouWonOrLost.setText("Win");
			    	buttonComputerChoice.setIcon(iconPaper);
			    	playerScoreCounter++;
			    }
			    labelGameStats.setText("<html>Player wins: "+playerScoreCounter+"<br/>Computer wins: "+computerScoreCounter+"<br/>Draws: "+drawCounter+"</html>");
			    insertRockPaperScissors(MainMenu.conn,playerScoreCounter,computerScoreCounter,drawCounter);
			}
		});
		buttonScissors.setBounds(300, 216, 100, 100);
		frame.getContentPane().add(buttonScissors);
	
		
		JLabel labelYourTurn = new JLabel("Your choice:", SwingConstants.CENTER);
		labelYourTurn.setForeground(Color.BLACK);
		labelYourTurn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelYourTurn.setBounds(0, 180, 474, 25);
		frame.getContentPane().add(labelYourTurn);
		
		labelYouWonOrLost = new JLabel("", SwingConstants.CENTER);
		labelYouWonOrLost.setForeground(Color.BLACK);
		labelYouWonOrLost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelYouWonOrLost.setBounds(0, 333, 474, 45);
		frame.getContentPane().add(labelYouWonOrLost);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setFocusable(false);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonBack.setBounds(10, 10, 80, 25);
		frame.getContentPane().add(buttonBack);
		
		labelGameStats = new JLabel("<html>Player wins: "+playerScoreCounter+"<br/>Computer wins: "+computerScoreCounter+"<br/>Draws: "+drawCounter+"</html>", SwingConstants.CENTER);
		labelGameStats.setForeground(Color.BLACK);
		labelGameStats.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelGameStats.setBounds(0, 400, 490, 60);
		frame.getContentPane().add(labelGameStats);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computerScoreCounter = 0;
				playerScoreCounter = 0;
				drawCounter =0;
			    labelGameStats.setText("<html>Player wins: "+playerScoreCounter+"<br/>Computer wins: "+computerScoreCounter+"<br/>Draws: "+drawCounter+"</html>");
			    insertRockPaperScissors(MainMenu.conn,0,0,0);
			}
		});
		buttonReset.setFocusable(false);
		buttonReset.setBounds(10, 430, 80, 25);
		frame.getContentPane().add(buttonReset);
	}

	private static void assignRockPaperScissors(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM rock_paper_scissors_bd");
			while (rs.next()) {
				computerScoreCounter = rs.getInt("computer_wins");
				playerScoreCounter = rs.getInt("player_wins");
				drawCounter = rs.getInt("draws");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insertRockPaperScissors(Connection conn, int x, int y, int z) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO rock_paper_scissors_bd VALUES (" + x + "," + y +"," + z + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
