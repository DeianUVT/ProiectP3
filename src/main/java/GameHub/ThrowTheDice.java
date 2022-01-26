package GameHub;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ThrowTheDice {

	private JFrame frame;
	Random random = new Random();
	JLabel labelGameStats;
	static int face1=0,face2=0,face3=0,face4=0,face5=0,face6=0;
	
	Icon iconFace1 = new ImageIcon(((new ImageIcon(
            "dice_face_a.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));
	Icon iconFace2 = new ImageIcon(((new ImageIcon(
            "dice_face_b.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));
	Icon iconFace3 = new ImageIcon(((new ImageIcon(
            "dice_face_c.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));
	Icon iconFace4 = new ImageIcon(((new ImageIcon(
            "dice_face_d.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));
	Icon iconFace5 = new ImageIcon(((new ImageIcon(
            "dice_face_e.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));
	Icon iconFace6 = new ImageIcon(((new ImageIcon(
            "dice_face_f.png").getImage()
            .getScaledInstance(100, 100,
                    java.awt.Image.SCALE_SMOOTH))));

	/**
	 * Launch the application for Throw The Dice.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThrowTheDice window = new ThrowTheDice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for Throw The Dice.
	 */
	public ThrowTheDice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame for Throw The Dice.
	 */
	private void initialize() {
		assignThrowTheDice(MainMenu.conn);
		
		
		frame = new JFrame();
		frame.setTitle("Throw the dice");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		frame.setSize(500,500);
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 500 / 2, center.y - 500 / 2, 500, 500);
		frame.setResizable(false);
		
		final JButton buttonShowTheDice = new JButton(new ImageIcon(((new ImageIcon(
	            "QuestionMark.png").getImage()
	            .getScaledInstance(100, 100,
	                    java.awt.Image.SCALE_SMOOTH)))));
		buttonShowTheDice.setBounds(190, 30, 100, 100);
		buttonShowTheDice.setBorderPainted(false);
		buttonShowTheDice.setFocusPainted(false);
		buttonShowTheDice.setContentAreaFilled(false);
		frame.getContentPane().add(buttonShowTheDice);
		
		JButton buttonRoll = new JButton("ROLL");
		buttonRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand = random.nextInt(6) + 1;
				if(rand == 1) {face1++;buttonShowTheDice.setIcon(iconFace1);}
				else if(rand == 2) {face2++;buttonShowTheDice.setIcon(iconFace2);}
				else if(rand == 3) {face3++;buttonShowTheDice.setIcon(iconFace3);}
				else if(rand == 4) {face4++;buttonShowTheDice.setIcon(iconFace4);}
				else if(rand == 5) {face5++;buttonShowTheDice.setIcon(iconFace5);}
				else if(rand == 6) {face6++;buttonShowTheDice.setIcon(iconFace6);}
				labelGameStats.setText("<html>Face 1: " + face1 + "<br/>Face 2: " + face2 + "<br/>Face 3: " + face3 + "<br/>Face 4: " + face4 + "<br/>Face 5: " + face5 + "<br/>Face 6: " + face6 + "</html>");
				insertThrowTheDice(MainMenu.conn,face1,face2,face3,face4,face5,face6);
			}
		});
		buttonRoll.setFocusable(false);
		buttonRoll.setBounds(190, 200, 100, 30);
		frame.getContentPane().add(buttonRoll);
		
		labelGameStats = new JLabel("New label",SwingConstants.CENTER);
		labelGameStats.setForeground(Color.BLACK);
		labelGameStats.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelGameStats.setBounds(190, 266, 100, 200);
		labelGameStats.setText("<html>Face 1: " + face1 + "<br/>Face 2: " + face2 + "<br/>Face 3: " + face3 + "<br/>Face 4: " + face4 + "<br/>Face 5: " + face5 + "<br/>Face 6: " + face6 + "</html>");
		frame.getContentPane().add(labelGameStats);
		
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
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				face1=0;
				face2=0;
				face3=0;
				face4=0;
				face5=0;
				face6=0;
				labelGameStats.setText("<html>Face 1: " + face1 + "<br/>Face 2: " + face2 + "<br/>Face 3: " + face3 + "<br/>Face 4: " + face4 + "<br/>Face 5: " + face5 + "<br/>Face 6: " + face6 + "</html>");
				insertThrowTheDice(MainMenu.conn,face1,face2,face3,face4,face5,face6);
			}
		});
		buttonReset.setFocusable(false);
		buttonReset.setBounds(10, 430, 80, 25);
		frame.getContentPane().add(buttonReset);
	}
	
	private static void assignThrowTheDice(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM throw_the_dice_bd");
			while (rs.next()) {
				face1 = rs.getInt("face1");
				face2 = rs.getInt("face2");
				face3 = rs.getInt("face3");
				face4 = rs.getInt("face4");
				face5 = rs.getInt("face5");
				face6 = rs.getInt("face6");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insertThrowTheDice(Connection conn, int a, int b, int c, int d, int e, int f) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO throw_the_dice_bd VALUES (" + a + "," + b + "," + c + "," + d +  "," + e + "," + f + ")");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
