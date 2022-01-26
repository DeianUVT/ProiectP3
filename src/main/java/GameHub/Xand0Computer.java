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

public class Xand0Computer {

	private JFrame frame;
	static Random random = new Random();
	Boolean turnOfPlayerOne = random.nextBoolean();
	Boolean finished = false;
	JLabel labelGameInfo;
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
	static int playerWins = 0;
	static int computerWins = 0;
	static int draws = 0;
	static int playerWinsHard = 0;
	static int computerWinsHard = 0;
	static int drawsHard = 0;
	JLabel labelStats;
	JLabel labelStatsHard;
	JLabel labelEasy;
	JLabel labelHard;

	/**
	 * Launch the application for X and 0 computer.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xand0Computer window = new Xand0Computer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for X and 0 computer.
	 */
	public Xand0Computer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame for X and 0 computer.
	 */
	private void initialize() {
		assignXand0computer(MainMenu.conn);
		assignXand0computerHard(MainMenu.conn);
		
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
				assignBlocks(1,1);
			}
		});
		buttonPos1.setBounds(80, 60, 100, 100);
		frame.getContentPane().add(buttonPos1);
		
		buttonPos2 = new JButton("");
		buttonPos2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos2.setForeground(Color.BLACK);
		buttonPos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(2,1);
			}
		});
		buttonPos2.setBounds(190, 60, 100, 100);
		frame.getContentPane().add(buttonPos2);
		
		buttonPos3 = new JButton("");
		buttonPos3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos3.setForeground(Color.BLACK);
		buttonPos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(3,1);
			}
		});
		buttonPos3.setBounds(300, 60, 100, 100);
		frame.getContentPane().add(buttonPos3);
		
		buttonPos4 = new JButton("");
		buttonPos4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos4.setForeground(Color.BLACK);
		buttonPos4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(4,1);
			}
		});
		buttonPos4.setBounds(80, 171, 100, 100);
		frame.getContentPane().add(buttonPos4);
		
		buttonPos5 = new JButton("");
		buttonPos5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos5.setForeground(Color.BLACK);
		buttonPos5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(5,1);
			}
		});
		buttonPos5.setBounds(190, 171, 100, 100);
		frame.getContentPane().add(buttonPos5);
		
		buttonPos6 = new JButton("");
		buttonPos6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos6.setForeground(Color.BLACK);
		buttonPos6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(6,1);
			}
		});
		buttonPos6.setBounds(300, 171, 100, 100);
		frame.getContentPane().add(buttonPos6);
		
		buttonPos7 = new JButton("");
		buttonPos7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos7.setForeground(Color.BLACK);
		buttonPos7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(7,1);
			}
		});
		buttonPos7.setBounds(80, 282, 100, 100);
		frame.getContentPane().add(buttonPos7);
		
		buttonPos8 = new JButton("");
		buttonPos8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos8.setForeground(Color.BLACK);
		buttonPos8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(8,1);
			}
		});
		buttonPos8.setBounds(190, 282, 100, 100);
		frame.getContentPane().add(buttonPos8);
		
		buttonPos9 = new JButton("");
		buttonPos9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPos9.setForeground(Color.BLACK);
		buttonPos9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignBlocks(9,1);
			}
		});
		buttonPos9.setBounds(300, 282, 100, 100);
		frame.getContentPane().add(buttonPos9);
		
		labelGameInfo = new JLabel("You are X",SwingConstants.CENTER);
		labelGameInfo.setForeground(Color.BLACK);
		labelGameInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelGameInfo.setBounds(10, 10, 474, 38);
		frame.getContentPane().add(labelGameInfo);
		
		buttonRestart = new JButton("Restart");
		buttonRestart.setFocusable(false);
		buttonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
		buttonRestart.setVisible(false);
		buttonRestart.setForeground(Color.BLACK);
		buttonRestart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonRestart.setBounds(190, 410, 100, 40);
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
		labelStats.setText("<html>Player wins: " + playerWins + "<br/>Computer wins: " + computerWins + "<br/>Draws: " + draws + "</html>");
		labelStats.setBounds(-10, 393, 190, 67);
		frame.getContentPane().add(labelStats);
		
		labelStatsHard = new JLabel("<html>Player wins: 0<br/>Computer wins: 0<br/>Draws: 0</html>", SwingConstants.CENTER);
		labelStatsHard.setForeground(Color.BLACK);
		labelStatsHard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelStatsHard.setText("<html>Player wins: " + playerWinsHard + "<br/>Computer wins: " + computerWinsHard + "<br/>Draws: " + drawsHard + "</html>");
		labelStatsHard.setBounds(300, 393, 190, 67);
		frame.getContentPane().add(labelStatsHard);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Xand0SelectMenu.dificultyEasy) {
					playerWins = 0;
					computerWins = 0;
					draws = 0;
					labelStats.setText("<html>Player wins: " + playerWins + "<br/>Computer wins: " + computerWins + "<br/>Draws: " + draws + "</html>");
					insertXand0computer(MainMenu.conn,playerWins,computerWins,draws);
				} else {
					playerWinsHard = 0;
					computerWinsHard = 0;
					drawsHard = 0;
					labelStatsHard.setText("<html>Player wins: " + playerWinsHard + "<br/>Computer wins: " + computerWinsHard + "<br/>Draws: " + drawsHard + "</html>");
					insertXand0computerHard(MainMenu.conn,playerWinsHard,computerWinsHard,drawsHard);
				}
			}
		});
		buttonReset.setFocusable(false);
		buttonReset.setBounds(394, 10, 80, 25);
		frame.getContentPane().add(buttonReset);
		
		labelEasy = new JLabel("Easy",SwingConstants.CENTER);
		labelEasy.setForeground(Color.BLACK);
		labelEasy.setBounds(10, 370, 60, 20);
		frame.getContentPane().add(labelEasy);
		
		labelHard = new JLabel("Hard", SwingConstants.CENTER);
		labelHard.setForeground(Color.BLACK);
		labelHard.setBounds(414, 373, 60, 20);
		frame.getContentPane().add(labelHard);
		restart();
	}

	/**
	 * This method clears all the boxes and make the game ready for a new match
	 */
	protected void restart() {
		playerOneChoice = new int[10];
		playerTwoChoice = new int[10];
		enable_buttons();
		turnOfPlayerOne = random.nextBoolean();
		if(!turnOfPlayerOne)
			computerChoice();
		finished = false;
		labelGameInfo.setText("You are X");
		buttonRestart.setVisible(false);
	}

	/**
	 * This method makes the choice for the computer based on difficulty
	 */
	private void computerChoice() {
		int choice;
		if(Xand0SelectMenu.dificultyEasy==true)
			choice = random.nextInt(9)+1;
		else
			choice = intelligent_choice();
		assignBlocks(choice,2);
	}

	/**
	 * This method makes the smart choice for the computer
	 */
	private int intelligent_choice() {
		//On line finishing
		if(playerTwoChoice[1] == 1 && playerTwoChoice[2] == 1 && playerOneChoice[3] == 0)
			return 3;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[3] == 1 && playerOneChoice[2] == 0)
			return 2;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[3] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[6] == 0)
			return 6;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[4] == 0)
			return 4;
		else if(playerTwoChoice[7] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[7] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[8] == 0)
			return 8;
		else if(playerTwoChoice[8] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[7] == 0)
			return 7;
		//On column finishing
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[4] == 1 && playerOneChoice[7] == 0)
			return 7;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[4] == 0)
			return 4;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[8] == 0)
			return 8;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[2] == 0)
			return 2;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[6] == 0)
			return 6;
		else if(playerTwoChoice[6] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[3] == 0)
			return 3;
		//On diagonal finishing
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[7] == 0)
			return 7;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[3] == 0)
			return 3;
		// On line blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[2] == 1 && playerTwoChoice[3] == 0)
			return 3;
		else if(playerOneChoice[1] == 1 && playerOneChoice[3] == 1 && playerTwoChoice[2] == 0)
			return 2;
		else if(playerOneChoice[2] == 1 && playerOneChoice[3] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[4] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[6] == 0)
			return 6;
		else if(playerOneChoice[4] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[4] == 0)
			return 4;
		else if(playerOneChoice[7] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[7] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[8] == 0)
			return 8;
		else if(playerOneChoice[8] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[7] == 0)
			return 7;
		//On column blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[4] == 1 && playerTwoChoice[7] == 0)
			return 7;
		else if(playerOneChoice[1] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[4] == 0)
			return 4;
		else if(playerOneChoice[4] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[2] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[8] == 0)
			return 8;
		else if(playerOneChoice[2] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[2] == 0)
			return 2;
		else if(playerOneChoice[3] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[3] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[6] == 0)
			return 6;
		else if(playerOneChoice[6] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[3] == 0)
			return 3;
		//On diagonal blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[1] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[3] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[7] == 0)
			return 7;
		else if(playerOneChoice[3] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[3] == 0)
			return 3;
		else if(playerOneChoice[5] == 0 && playerTwoChoice[5] == 0)
			return 5;
		else
			return random.nextInt(9)+1;
	}
	
	/**
	 * This method makes the smart choice for the computer
	 * 
	 * @param playerOneChoice All boxes occupied by the player 1
	 * @param playerTwoChoice All boxes occupied by computer
	 * @return the number of the selected box 
	 */
	public static int intelligentChoiceForTests(int[] playerOneChoice,int[] playerTwoChoice) {
		//On line finishing
		if(playerTwoChoice[1] == 1 && playerTwoChoice[2] == 1 && playerOneChoice[3] == 0)
			return 3;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[3] == 1 && playerOneChoice[2] == 0)
			return 2;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[3] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[6] == 0)
			return 6;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[4] == 0)
			return 4;
		else if(playerTwoChoice[7] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[7] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[8] == 0)
			return 8;
		else if(playerTwoChoice[8] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[7] == 0)
			return 7;
		//On column finishing
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[4] == 1 && playerOneChoice[7] == 0)
			return 7;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[4] == 0)
			return 4;
		else if(playerTwoChoice[4] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[8] == 0)
			return 8;
		else if(playerTwoChoice[2] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[8] == 1 && playerOneChoice[2] == 0)
			return 2;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[6] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[6] == 0)
			return 6;
		else if(playerTwoChoice[6] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[3] == 0)
			return 3;
		//On diagonal finishing
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[9] == 0)
			return 9;
		else if(playerTwoChoice[1] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[9] == 1 && playerOneChoice[1] == 0)
			return 1;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[5] == 1 && playerOneChoice[7] == 0)
			return 7;
		else if(playerTwoChoice[3] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[5] == 0)
			return 5;
		else if(playerTwoChoice[5] == 1 && playerTwoChoice[7] == 1 && playerOneChoice[3] == 0)
			return 3;
		// On line blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[2] == 1 && playerTwoChoice[3] == 0)
			return 3;
		else if(playerOneChoice[1] == 1 && playerOneChoice[3] == 1 && playerTwoChoice[2] == 0)
			return 2;
		else if(playerOneChoice[2] == 1 && playerOneChoice[3] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[4] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[6] == 0)
			return 6;
		else if(playerOneChoice[4] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[4] == 0)
			return 4;
		else if(playerOneChoice[7] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[7] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[8] == 0)
			return 8;
		else if(playerOneChoice[8] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[7] == 0)
			return 7;
		//On column blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[4] == 1 && playerTwoChoice[7] == 0)
			return 7;
		else if(playerOneChoice[1] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[4] == 0)
			return 4;
		else if(playerOneChoice[4] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[2] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[8] == 0)
			return 8;
		else if(playerOneChoice[2] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[8] == 1 && playerTwoChoice[2] == 0)
			return 2;
		else if(playerOneChoice[3] == 1 && playerOneChoice[6] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[3] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[6] == 0)
			return 6;
		else if(playerOneChoice[6] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[3] == 0)
			return 3;
		//On diagonal blocking
		else if(playerOneChoice[1] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[9] == 0)
			return 9;
		else if(playerOneChoice[1] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[9] == 1 && playerTwoChoice[1] == 0)
			return 1;
		else if(playerOneChoice[3] == 1 && playerOneChoice[5] == 1 && playerTwoChoice[7] == 0)
			return 7;
		else if(playerOneChoice[3] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[5] == 0)
			return 5;
		else if(playerOneChoice[5] == 1 && playerOneChoice[7] == 1 && playerTwoChoice[3] == 0)
			return 3;
		else if(playerOneChoice[5] == 0 && playerTwoChoice[5] == 0)
			return 5;
		else
			return random.nextInt(9)+1;
	}

	/**
	 * This method assigns the specified box to the specified player if this thing is possible
	 * 
	 * @param choice Box to be assigned
	 * @param player Number of the player(palyer or computer)
	 */
	private void assignBlocks(int choice,int player) {
		if(playerOneChoice[choice] != 1 && playerTwoChoice[choice] != 1)
		{
			if(player == 1)
			{
				if(choice == 1) {buttonPos1.setText("X");buttonPos1.setEnabled(false);}
				else if(choice == 2) {buttonPos2.setText("X");buttonPos2.setEnabled(false);}
				else if(choice == 3) {buttonPos3.setText("X");buttonPos3.setEnabled(false);}
				else if(choice == 4) {buttonPos4.setText("X");buttonPos4.setEnabled(false);}
				else if(choice == 5) {buttonPos5.setText("X");buttonPos5.setEnabled(false);}
				else if(choice == 6) {buttonPos6.setText("X");buttonPos6.setEnabled(false);}
				else if(choice == 7) {buttonPos7.setText("X");buttonPos7.setEnabled(false);}
				else if(choice == 8) {buttonPos8.setText("X");buttonPos8.setEnabled(false);}
				else if(choice == 9) {buttonPos9.setText("X");buttonPos9.setEnabled(false);}
				playerOneChoice[choice] = 1;
				turnOfPlayerOne = false;
				verification();
				if(!finished)
					computerChoice();
			}
			else
			{
				if(choice == 1) {buttonPos1.setText("0");buttonPos1.setEnabled(false);}
				else if(choice == 2) {buttonPos2.setText("0");buttonPos2.setEnabled(false);}
				else if(choice == 3) {buttonPos3.setText("0");buttonPos3.setEnabled(false);}
				else if(choice == 4) {buttonPos4.setText("0");buttonPos4.setEnabled(false);}
				else if(choice == 5) {buttonPos5.setText("0");buttonPos5.setEnabled(false);}
				else if(choice == 6) {buttonPos6.setText("0");buttonPos6.setEnabled(false);}
				else if(choice == 7) {buttonPos7.setText("0");buttonPos7.setEnabled(false);}
				else if(choice == 8) {buttonPos8.setText("0");buttonPos8.setEnabled(false);}
				else if(choice == 9) {buttonPos9.setText("0");buttonPos9.setEnabled(false);}
				playerTwoChoice[choice] = 1;
				turnOfPlayerOne = true;
				verification();
			}
		}
		else computerChoice();
	}

	/**
	 * This method checks if the game can continue, otherwise it gives the verdict
	 */
	protected void verification() {
		if(!finished && playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3] == 3 || playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6] == 3 || playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[4]+playerOneChoice[7] == 3 || playerOneChoice[2]+playerOneChoice[5]+playerOneChoice[8] == 3 || playerOneChoice[3]+playerOneChoice[6]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[5]+playerOneChoice[9] == 3 || playerOneChoice[3]+playerOneChoice[5]+playerOneChoice[7] == 3)
		{
			if(Xand0SelectMenu.dificultyEasy)
				playerWins++;
			else
				playerWinsHard++;
			labelGameInfo.setText("You won!");
			buttonRestart.setVisible(true);
			disable_buttons();
			finished = true;
		}
		if(!finished && playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3] == 3 || playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6] == 3 || playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[4]+playerTwoChoice[7] == 3 || playerTwoChoice[2]+playerTwoChoice[5]+playerTwoChoice[8] == 3 || playerTwoChoice[3]+playerTwoChoice[6]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[5]+playerTwoChoice[9] == 3 || playerTwoChoice[3]+playerTwoChoice[5]+playerTwoChoice[7] == 3)
		{
			if(Xand0SelectMenu.dificultyEasy)
				computerWins++;
			else
				computerWinsHard++;
			labelGameInfo.setText("You lost!");
			buttonRestart.setVisible(true);
			disable_buttons();
			finished = true;
		}
		if(!finished && playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3]+playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6]+playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9]+playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3]+playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6]+playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9]==9)
		{
			if(Xand0SelectMenu.dificultyEasy)
				draws++;
			else
				drawsHard++;
			labelGameInfo.setText("Draw!");
			buttonRestart.setVisible(true);
			disable_buttons();
			finished = true;
		}
		labelStats.setText("<html>Player wins: " + playerWins + "<br/>Computer wins: " + computerWins + "<br/>Draws: " + draws + "</html>");
		labelStatsHard.setText("<html>Player wins: " + playerWinsHard + "<br/>Computer wins: " + computerWinsHard + "<br/>Draws: " + drawsHard + "</html>");
		insertXand0computer(MainMenu.conn,playerWins,computerWins,draws);
		insertXand0computerHard(MainMenu.conn,playerWinsHard,computerWinsHard,drawsHard);
	}
	
	/**
	 * This method checks if the game can continue, otherwise it gives the verdict
	 * 
	 * @param playerOneChoice All boxes occupied by the player 1
	 * @param playerTwoChoice All boxes occupied by computer
	 * @return string with current state of the game
	 */
	public static String verificationForTest(int[] playerOneChoice,int[] playerTwoChoice) {
		if(playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3] == 3 || playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6] == 3 || playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[4]+playerOneChoice[7] == 3 || playerOneChoice[2]+playerOneChoice[5]+playerOneChoice[8] == 3 || playerOneChoice[3]+playerOneChoice[6]+playerOneChoice[9] == 3 || playerOneChoice[1]+playerOneChoice[5]+playerOneChoice[9] == 3 || playerOneChoice[3]+playerOneChoice[5]+playerOneChoice[7] == 3)
			return "You won!";
		else if(playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3] == 3 || playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6] == 3 || playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[4]+playerTwoChoice[7] == 3 || playerTwoChoice[2]+playerTwoChoice[5]+playerTwoChoice[8] == 3 || playerTwoChoice[3]+playerTwoChoice[6]+playerTwoChoice[9] == 3 || playerTwoChoice[1]+playerTwoChoice[5]+playerTwoChoice[9] == 3 || playerTwoChoice[3]+playerTwoChoice[5]+playerTwoChoice[7] == 3)
			return "You lost!";
		else if(playerOneChoice[1]+playerOneChoice[2]+playerOneChoice[3]+playerOneChoice[4]+playerOneChoice[5]+playerOneChoice[6]+playerOneChoice[7]+playerOneChoice[8]+playerOneChoice[9]+playerTwoChoice[1]+playerTwoChoice[2]+playerTwoChoice[3]+playerTwoChoice[4]+playerTwoChoice[5]+playerTwoChoice[6]+playerTwoChoice[7]+playerTwoChoice[8]+playerTwoChoice[9]==9)
			return "Draw";
		return "Game continues";
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
	
	private static void assignXand0computer(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM xand0_computer");
			while (rs.next()) {
				playerWins = rs.getInt("playerwins");
				computerWins = rs.getInt("computerwins");
				draws = rs.getInt("draws");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void assignXand0computerHard(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM xand0_computer_hard");
			while (rs.next()) {
				playerWinsHard = rs.getInt("playerwins");
				computerWinsHard = rs.getInt("computewins");
				drawsHard = rs.getInt("draws");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insertXand0computer(Connection conn, int a, int b, int c) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO xand0_computer VALUES (" + a + "," + b + "," + c + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private static void insertXand0computerHard(Connection conn, int a, int b, int c) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO xand0_computer_hard VALUES (" + a + "," + b + "," + c + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
