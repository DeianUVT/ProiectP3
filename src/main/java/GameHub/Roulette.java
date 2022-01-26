package GameHub;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Roulette {

	public JFrame frame;
	JLabel labelCoinValue;
	JLabel labelSpin;
	JLabel labelBets;
	JLabel labelSpinResult;
	JLabel labelCash;
	JButton bRestart;
	
	static int cash = 1000;
	int betCoinValue = 1;
	static int []cashOn = new int[49];
	
	Random random = new Random();

	/**
	 * Launch the application for Roulette.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roulette window = new Roulette();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application for Roulette.
	 */
	public Roulette() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame for Roulette.
	 */
	private void initialize() {
		assignRoulette(MainMenu.conn);
		
		final Map<Integer,String> colorMap = new HashMap<Integer,String>();
		colorMap.put(0,"green");
		colorMap.put(1,"red");
		colorMap.put(2,"black");
		colorMap.put(3,"red");
		colorMap.put(4,"black");
		colorMap.put(5,"red");
		colorMap.put(6,"black");
		colorMap.put(7,"red");
		colorMap.put(8,"black");
		colorMap.put(9,"red");
		colorMap.put(10,"black");
		colorMap.put(11,"black");
		colorMap.put(12,"red");
		colorMap.put(13,"black");
		colorMap.put(14,"red");
		colorMap.put(15,"black");
		colorMap.put(16,"red");
		colorMap.put(17,"black");
		colorMap.put(18,"red");
		colorMap.put(19,"red");
		colorMap.put(20,"black");
		colorMap.put(21,"red");
		colorMap.put(22,"black");
		colorMap.put(23,"red");
		colorMap.put(24,"black");
		colorMap.put(25,"red");
		colorMap.put(26,"black");
		colorMap.put(27,"red");
		colorMap.put(28,"black");
		colorMap.put(29,"black");
		colorMap.put(30,"red");
		colorMap.put(31,"black");
		colorMap.put(32,"red");
		colorMap.put(33,"black");
		colorMap.put(34,"red");
		colorMap.put(35,"black");
		colorMap.put(36,"red");
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setResizable(false);
		frame.setTitle("Roulette");
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - 1000 / 2, center.y - 750 / 2, 1000, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JButton b1 = new JButton("1");
		b1.setFocusable(false);
		b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.RED);
		b1.setBounds(70, 200, 70, 70);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b1);
			}
		});
		frame.getContentPane().add(b1);
		
		final JButton b2 = new JButton("2");
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Tahoma", Font.BOLD, 18));
		b2.setFocusable(false);
		b2.setBackground(Color.BLACK);
		b2.setBounds(70, 130, 70, 70);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b2);
			}
		});
		frame.getContentPane().add(b2);
		
		final JButton b3 = new JButton("3");
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Tahoma", Font.BOLD, 18));
		b3.setFocusable(false);
		b3.setBackground(Color.RED);
		b3.setBounds(70, 60, 70, 70);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b3);
			}
		});
		frame.getContentPane().add(b3);
		
		final JButton b4 = new JButton("4");
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Tahoma", Font.BOLD, 18));
		b4.setFocusable(false);
		b4.setBackground(Color.BLACK);
		b4.setBounds(140, 200, 70, 70);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b4);
			}
		});
		frame.getContentPane().add(b4);
		
		final JButton b5 = new JButton("5");
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Tahoma", Font.BOLD, 18));
		b5.setFocusable(false);
		b5.setBackground(Color.RED);
		b5.setBounds(140, 130, 70, 70);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b5);
			}
		});
		frame.getContentPane().add(b5);
		
		final JButton b6 = new JButton("6");
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Tahoma", Font.BOLD, 18));
		b6.setFocusable(false);
		b6.setBackground(Color.BLACK);
		b6.setBounds(140, 60, 70, 70);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b6);
			}
		});
		frame.getContentPane().add(b6);
		
		final JButton b7 = new JButton("7");
		b7.setForeground(Color.WHITE);
		b7.setFont(new Font("Tahoma", Font.BOLD, 18));
		b7.setFocusable(false);
		b7.setBackground(Color.RED);
		b7.setBounds(210, 200, 70, 70);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b7);
			}
		});
		frame.getContentPane().add(b7);
		
		final JButton b8 = new JButton("8");
		b8.setForeground(Color.WHITE);
		b8.setFont(new Font("Tahoma", Font.BOLD, 18));
		b8.setFocusable(false);
		b8.setBackground(Color.BLACK);
		b8.setBounds(210, 130, 70, 70);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b8);
			}
		});
		frame.getContentPane().add(b8);
		
		final JButton b9 = new JButton("9");
		b9.setForeground(Color.WHITE);
		b9.setFont(new Font("Tahoma", Font.BOLD, 18));
		b9.setFocusable(false);
		b9.setBackground(Color.RED);
		b9.setBounds(210, 60, 70, 70);
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b9);
			}
		});
		frame.getContentPane().add(b9);
		
		final JButton b10 = new JButton("10");
		b10.setForeground(Color.WHITE);
		b10.setFont(new Font("Tahoma", Font.BOLD, 18));
		b10.setFocusable(false);
		b10.setBackground(Color.BLACK);
		b10.setBounds(280, 200, 70, 70);
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b10);
			}
		});
		frame.getContentPane().add(b10);
		
		final JButton b11 = new JButton("11");
		b11.setForeground(Color.WHITE);
		b11.setFont(new Font("Tahoma", Font.BOLD, 18));
		b11.setFocusable(false);
		b11.setBackground(Color.BLACK);
		b11.setBounds(280, 130, 70, 70);
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b11);
			}
		});
		frame.getContentPane().add(b11);
		
		final JButton b12 = new JButton("12");
		b12.setForeground(Color.WHITE);
		b12.setFont(new Font("Tahoma", Font.BOLD, 18));
		b12.setFocusable(false);
		b12.setBackground(Color.RED);
		b12.setBounds(280, 60, 70, 70);
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b12);
			}
		});
		frame.getContentPane().add(b12);
		
		final JButton b13 = new JButton("13");
		b13.setForeground(Color.WHITE);
		b13.setFont(new Font("Tahoma", Font.BOLD, 18));
		b13.setFocusable(false);
		b13.setBackground(Color.BLACK);
		b13.setBounds(350, 200, 70, 70);
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b13);
			}
		});
		frame.getContentPane().add(b13);
		
		final JButton b14 = new JButton("14");
		b14.setForeground(Color.WHITE);
		b14.setFont(new Font("Tahoma", Font.BOLD, 18));
		b14.setFocusable(false);
		b14.setBackground(Color.RED);
		b14.setBounds(350, 130, 70, 70);
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b14);
			}
		});
		frame.getContentPane().add(b14);
		
		final JButton b15 = new JButton("15");
		b15.setForeground(Color.WHITE);
		b15.setFont(new Font("Tahoma", Font.BOLD, 18));
		b15.setFocusable(false);
		b15.setBackground(Color.BLACK);
		b15.setBounds(350, 60, 70, 70);
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b15);
			}
		});
		frame.getContentPane().add(b15);
		
		final JButton b16 = new JButton("16");
		b16.setForeground(Color.WHITE);
		b16.setFont(new Font("Tahoma", Font.BOLD, 18));
		b16.setFocusable(false);
		b16.setBackground(Color.RED);
		b16.setBounds(420, 200, 70, 70);
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b16);
			}
		});
		frame.getContentPane().add(b16);
		
		final JButton b17 = new JButton("17");
		b17.setForeground(Color.WHITE);
		b17.setFont(new Font("Tahoma", Font.BOLD, 18));
		b17.setFocusable(false);
		b17.setBackground(Color.BLACK);
		b17.setBounds(420, 130, 70, 70);
		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b17);
			}
		});
		frame.getContentPane().add(b17);
		
		final JButton b18 = new JButton("18");
		b18.setForeground(Color.WHITE);
		b18.setFont(new Font("Tahoma", Font.BOLD, 18));
		b18.setFocusable(false);
		b18.setBackground(Color.RED);
		b18.setBounds(420, 60, 70, 70);
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b18);
			}
		});
		frame.getContentPane().add(b18);
		
		final JButton b19 = new JButton("19");
		b19.setForeground(Color.WHITE);
		b19.setFont(new Font("Tahoma", Font.BOLD, 18));
		b19.setFocusable(false);
		b19.setBackground(Color.RED);
		b19.setBounds(490, 200, 70, 70);
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b19);
			}
		});
		frame.getContentPane().add(b19);
		
		final JButton b20 = new JButton("20");
		b20.setForeground(Color.WHITE);
		b20.setFont(new Font("Tahoma", Font.BOLD, 18));
		b20.setFocusable(false);
		b20.setBackground(Color.BLACK);
		b20.setBounds(490, 130, 70, 70);
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b20);
			}
		});
		frame.getContentPane().add(b20);
		
		final JButton b21 = new JButton("21");
		b21.setForeground(Color.WHITE);
		b21.setFont(new Font("Tahoma", Font.BOLD, 18));
		b21.setFocusable(false);
		b21.setBackground(Color.RED);
		b21.setBounds(490, 60, 70, 70);
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b21);
			}
		});
		frame.getContentPane().add(b21);
		
		final JButton b22 = new JButton("22");
		b22.setForeground(Color.WHITE);
		b22.setFont(new Font("Tahoma", Font.BOLD, 18));
		b22.setFocusable(false);
		b22.setBackground(Color.BLACK);
		b22.setBounds(560, 200, 70, 70);
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b22);
			}
		});
		frame.getContentPane().add(b22);
		
		final JButton b23 = new JButton("23");
		b23.setForeground(Color.WHITE);
		b23.setFont(new Font("Tahoma", Font.BOLD, 18));
		b23.setFocusable(false);
		b23.setBackground(Color.RED);
		b23.setBounds(560, 130, 70, 70);
		b23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b23);
			}
		});
		frame.getContentPane().add(b23);
		
		final JButton b24 = new JButton("24");
		b24.setForeground(Color.WHITE);
		b24.setFont(new Font("Tahoma", Font.BOLD, 18));
		b24.setFocusable(false);
		b24.setBackground(Color.BLACK);
		b24.setBounds(560, 60, 70, 70);
		b24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b24);
			}
		});
		frame.getContentPane().add(b24);
		
		final JButton b25 = new JButton("25");
		b25.setForeground(Color.WHITE);
		b25.setFont(new Font("Tahoma", Font.BOLD, 18));
		b25.setFocusable(false);
		b25.setBackground(Color.RED);
		b25.setBounds(630, 200, 70, 70);
		b25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b25);
			}
		});
		frame.getContentPane().add(b25);
		
		final JButton b26 = new JButton("26");
		b26.setForeground(Color.WHITE);
		b26.setFont(new Font("Tahoma", Font.BOLD, 18));
		b26.setFocusable(false);
		b26.setBackground(Color.BLACK);
		b26.setBounds(630, 130, 70, 70);
		b26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b26);
			}
		});
		frame.getContentPane().add(b26);
		
		final JButton b27 = new JButton("27");
		b27.setForeground(Color.WHITE);
		b27.setFont(new Font("Tahoma", Font.BOLD, 18));
		b27.setFocusable(false);
		b27.setBackground(Color.RED);
		b27.setBounds(630, 60, 70, 70);
		b27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b27);
			}
		});
		frame.getContentPane().add(b27);
		
		final JButton b28 = new JButton("28");
		b28.setForeground(Color.WHITE);
		b28.setFont(new Font("Tahoma", Font.BOLD, 18));
		b28.setFocusable(false);
		b28.setBackground(Color.BLACK);
		b28.setBounds(700, 200, 70, 70);
		b28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b28);
			}
		});
		frame.getContentPane().add(b28);
		
		final JButton b29 = new JButton("29");
		b29.setForeground(Color.WHITE);
		b29.setFont(new Font("Tahoma", Font.BOLD, 18));
		b29.setFocusable(false);
		b29.setBackground(Color.BLACK);
		b29.setBounds(700, 130, 70, 70);
		b29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b29);
			}
		});
		frame.getContentPane().add(b29);
		
		final JButton b30 = new JButton("30");
		b30.setForeground(Color.WHITE);
		b30.setFont(new Font("Tahoma", Font.BOLD, 18));
		b30.setFocusable(false);
		b30.setBackground(Color.RED);
		b30.setBounds(700, 60, 70, 70);
		b30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b30);
			}
		});
		frame.getContentPane().add(b30);
		
		final JButton b31 = new JButton("31");
		b31.setForeground(Color.WHITE);
		b31.setFont(new Font("Tahoma", Font.BOLD, 18));
		b31.setFocusable(false);
		b31.setBackground(Color.BLACK);
		b31.setBounds(770, 200, 70, 70);
		b31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b31);
			}
		});
		frame.getContentPane().add(b31);
		
		final JButton b32 = new JButton("32");
		b32.setForeground(Color.WHITE);
		b32.setFont(new Font("Tahoma", Font.BOLD, 18));
		b32.setFocusable(false);
		b32.setBackground(Color.RED);
		b32.setBounds(770, 130, 70, 70);
		b32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b32);
			}
		});
		frame.getContentPane().add(b32);
		
		final JButton b33 = new JButton("33");
		b33.setForeground(Color.WHITE);
		b33.setFont(new Font("Tahoma", Font.BOLD, 18));
		b33.setFocusable(false);
		b33.setBackground(Color.BLACK);
		b33.setBounds(770, 60, 70, 70);
		b33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b33);
			}
		});
		frame.getContentPane().add(b33);
		
		final JButton b34 = new JButton("34");
		b34.setForeground(Color.WHITE);
		b34.setFont(new Font("Tahoma", Font.BOLD, 18));
		b34.setFocusable(false);
		b34.setBackground(Color.RED);
		b34.setBounds(840, 200, 70, 70);
		b34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b34);
			}
		});
		frame.getContentPane().add(b34);
		
		final JButton b35 = new JButton("35");
		b35.setForeground(Color.WHITE);
		b35.setFont(new Font("Tahoma", Font.BOLD, 18));
		b35.setFocusable(false);
		b35.setBackground(Color.BLACK);
		b35.setBounds(840, 130, 70, 70);
		b35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b35);
			}
		});
		frame.getContentPane().add(b35);
		
		final JButton b36 = new JButton("36");
		b36.setForeground(Color.WHITE);
		b36.setFont(new Font("Tahoma", Font.BOLD, 18));
		b36.setFocusable(false);
		b36.setBackground(Color.RED);
		b36.setBounds(840, 60, 70, 70);
		b36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b36);
			}
		});
		frame.getContentPane().add(b36);
		
		final JButton b0 = new JButton("0");
		b0.setFocusable(false);
		b0.setBackground(new Color(0, 128, 0));
		b0.setFont(new Font("Tahoma", Font.BOLD, 20));
		b0.setForeground(Color.WHITE);
		b0.setBounds(10, 60, 60, 210);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeBet(b0);
			}
		});
		frame.getContentPane().add(b0);
		
		final JButton bFirstLine = new JButton("2:1");
		bFirstLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[37] += betCoinValue;
					printBets();
				}
			}
		});
		bFirstLine.setForeground(Color.WHITE);
		bFirstLine.setFont(new Font("Tahoma", Font.BOLD, 18));
		bFirstLine.setFocusable(false);
		bFirstLine.setBackground(new Color(0, 128, 0));
		bFirstLine.setFocusable(false);
		bFirstLine.setBounds(910, 60, 70, 70);
		frame.getContentPane().add(bFirstLine);
		
		final JButton bSecondLine = new JButton("2:1");
		bSecondLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[38] += betCoinValue;
					printBets();
				}
			}
		});
		bSecondLine.setForeground(Color.WHITE);
		bSecondLine.setFont(new Font("Tahoma", Font.BOLD, 18));
		bSecondLine.setFocusable(false);
		bSecondLine.setBackground(new Color(0, 128, 0));
		bSecondLine.setBounds(910, 130, 70, 70);
		frame.getContentPane().add(bSecondLine);
		
		final JButton bThirdLine = new JButton("2:1");
		bThirdLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[39] += betCoinValue;
					printBets();
				}
			}
		});
		bThirdLine.setForeground(Color.WHITE);
		bThirdLine.setFont(new Font("Tahoma", Font.BOLD, 18));
		bThirdLine.setFocusable(false);
		bThirdLine.setBackground(new Color(0, 128, 0));
		bThirdLine.setBounds(910, 200, 70, 70);
		frame.getContentPane().add(bThirdLine);
		
		final JButton b1st12 = new JButton("1st 12");
		b1st12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[40] += betCoinValue;
					printBets();
				}
			}
		});
		b1st12.setForeground(Color.WHITE);
		b1st12.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1st12.setFocusable(false);
		b1st12.setBackground(new Color(0, 128, 0));
		b1st12.setBounds(70, 270, 280, 70);
		frame.getContentPane().add(b1st12);
		
		final JButton b2nd12 = new JButton("2nd 12");
		b2nd12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[41] += betCoinValue;
					printBets();
				}
			}
		});
		b2nd12.setForeground(Color.WHITE);
		b2nd12.setFont(new Font("Tahoma", Font.BOLD, 18));
		b2nd12.setFocusable(false);
		b2nd12.setBackground(new Color(0, 128, 0));
		b2nd12.setBounds(350, 270, 280, 70);
		frame.getContentPane().add(b2nd12);
		
		final JButton b3rd12 = new JButton("3rd 12");
		b3rd12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[42] += betCoinValue;
					printBets();
				}
			}
		});
		b3rd12.setForeground(Color.WHITE);
		b3rd12.setFont(new Font("Tahoma", Font.BOLD, 18));
		b3rd12.setFocusable(false);
		b3rd12.setBackground(new Color(0, 128, 0));
		b3rd12.setBounds(630, 270, 280, 70);
		frame.getContentPane().add(b3rd12);
		
		final JButton b1to18 = new JButton("1-18");
		b1to18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[43] += betCoinValue;
					printBets();
				}
			}
		});
		b1to18.setForeground(Color.WHITE);
		b1to18.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1to18.setFocusable(false);
		b1to18.setBackground(new Color(0, 128, 0));
		b1to18.setBounds(70, 340, 140, 70);
		frame.getContentPane().add(b1to18);
		
		final JButton bEven = new JButton("Even");
		bEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[44] += betCoinValue;
					printBets();
				}
			}
		});
		bEven.setForeground(Color.WHITE);
		bEven.setFont(new Font("Tahoma", Font.BOLD, 18));
		bEven.setFocusable(false);
		bEven.setBackground(new Color(0, 128, 0));
		bEven.setBounds(210, 340, 140, 70);
		frame.getContentPane().add(bEven);
		
		final JButton bRed = new JButton("");
		bRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[45] += betCoinValue;
					printBets();
				}
			}
		});
		bRed.setForeground(Color.WHITE);
		bRed.setFont(new Font("Tahoma", Font.BOLD, 18));
		bRed.setFocusable(false);
		bRed.setBackground(Color.RED);
		bRed.setBounds(350, 340, 140, 70);
		frame.getContentPane().add(bRed);
		
		final JButton bBlack = new JButton("");
		bBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[46] += betCoinValue;
					printBets();
				}
			}
		});
		bBlack.setForeground(Color.WHITE);
		bBlack.setFont(new Font("Tahoma", Font.BOLD, 18));
		bBlack.setFocusable(false);
		bBlack.setBackground(Color.BLACK);
		bBlack.setBounds(490, 340, 140, 70);
		frame.getContentPane().add(bBlack);
		
		final JButton bOdd = new JButton("Odd");
		bOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[47] += betCoinValue;
					printBets();
				}
			}
		});
		bOdd.setForeground(Color.WHITE);
		bOdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		bOdd.setFocusable(false);
		bOdd.setBackground(new Color(0, 128, 0));
		bOdd.setBounds(630, 340, 140, 70);
		frame.getContentPane().add(bOdd);
		
		final JButton b19to36 = new JButton("19-36");
		b19to36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cash - betCoinValue >= 0) {
					cash -= betCoinValue;
					cashOn[48] += betCoinValue;
					printBets();
				}
			}
		});
		b19to36.setForeground(Color.WHITE);
		b19to36.setFont(new Font("Tahoma", Font.BOLD, 18));
		b19to36.setFocusable(false);
		b19to36.setBackground(new Color(0, 128, 0));
		b19to36.setBounds(770, 340, 140, 70);
		frame.getContentPane().add(b19to36);
		
		JLabel labelTitle = new JLabel("Roulette",SwingConstants.CENTER);
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
		labelTitle.setBounds(30, 10, 930, 39);
		frame.getContentPane().add(labelTitle);
		
		labelCash = new JLabel("");
		labelCash.setText(cash+"$");
		labelCash.setFont(new Font("Dubai", Font.BOLD, 15));
		labelCash.setForeground(Color.BLACK);
		labelCash.setBounds(10, 11, 250, 38);
		frame.getContentPane().add(labelCash);
		
		final JButton bMinus = new JButton("-");
		bMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(betCoinValue == 500)
					betCoinValue = 100;
				else if(betCoinValue == 100)
					betCoinValue = 50;
				else if(betCoinValue == 50)
					betCoinValue = 10;
				else if(betCoinValue == 10)
					betCoinValue = 5;
				else if(betCoinValue == 5)
					betCoinValue = 1;
				labelCoinValue.setText(""+betCoinValue);
			}
		});
		bMinus.setForeground(Color.BLACK);
		bMinus.setFocusable(false);
		bMinus.setFont(new Font("Tahoma", Font.BOLD, 20));
		bMinus.setBounds(120, 470, 50, 50);
		frame.getContentPane().add(bMinus);
		
		JLabel labelCoinValueTitle = new JLabel("Bet coin value:",SwingConstants.CENTER);
		labelCoinValueTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelCoinValueTitle.setForeground(Color.BLACK);
		labelCoinValueTitle.setBounds(70, 440, 280, 30);
		frame.getContentPane().add(labelCoinValueTitle);
		
		labelCoinValue = new JLabel("1",SwingConstants.CENTER);
		labelCoinValue.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelCoinValue.setForeground(Color.BLACK);
		labelCoinValue.setBounds(180, 470, 60, 50);
		frame.getContentPane().add(labelCoinValue);
		
		final JButton bPlus = new JButton("+");
		bPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(betCoinValue == 1)
					betCoinValue = 5;
				else if(betCoinValue == 5)
					betCoinValue = 10;
				else if(betCoinValue == 10)
					betCoinValue = 50;
				else if(betCoinValue == 50)
					betCoinValue = 100;
				else if(betCoinValue == 100)
					betCoinValue = 500;
				labelCoinValue.setText(""+betCoinValue);
			}
		});
		bPlus.setForeground(Color.BLACK);
		bPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		bPlus.setFocusable(false);
		bPlus.setBounds(250, 470, 50, 50);
		frame.getContentPane().add(bPlus);
		
		final JButton bSpin = new JButton("SPIN");
		bSpin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean proceedSpin = false;
				for(int i=0;i<49;i++) {
					if(cashOn[i]!=0) {
						proceedSpin = true;
						break;
					}
				}
				if(proceedSpin) {
					labelSpin.setText("");
					labelSpinResult.setText("");
					
					final int spinnedNumber = random.nextInt(37);
					
					final int initialCash = cash;
					
					if(cashOn[spinnedNumber] != 0) {
						cash += cashOn[spinnedNumber]*36;
					}
					
					if(cashOn[37]!=0 && spinnedNumber%3==0) {
						cash += cashOn[37]*3;
					}
					if(cashOn[38]!=0 && (spinnedNumber+1)%3==0) {
						cash += cashOn[38]*3;
					}
					if(cashOn[39]!=0 && (spinnedNumber+2)%3==0) {
						cash += cashOn[39]*3;
					}
					
					if(cashOn[40]!=0 && spinnedNumber>=1 && spinnedNumber<=12) {
						cash += cashOn[40]*3;
					}
					if(cashOn[41]!=0 && spinnedNumber>=13 && spinnedNumber<=24) {
						cash += cashOn[41]*3;
					}
					if(cashOn[42]!=0 && spinnedNumber>=25 && spinnedNumber<=36) {
						cash += cashOn[42]*3;
					}
					
					if(cashOn[43]!=0 && spinnedNumber>=1 && spinnedNumber<=18) {
						cash += cashOn[43]*2;
					}
					if(cashOn[48]!=0 && spinnedNumber>=19 && spinnedNumber<=36) {
						cash += cashOn[48]*2;
					}
					
					if(cashOn[44]!=0 && spinnedNumber%2==0) {
						cash += cashOn[44]*2;
					}
					if(cashOn[47]!=0 && spinnedNumber%2==1) {
						cash += cashOn[47]*2;
					}
					
					if(cashOn[45]!=0 && colorMap.get(spinnedNumber)=="red") {
						cash += cashOn[45]*2;
					}
					if(cashOn[46]!=0 && colorMap.get(spinnedNumber)=="black") {
						cash += cashOn[46]*2;
					}
					cashOn = new int[49];
					if(cash == 0) {
						bRestart.setVisible(true);
					}
					
					Thread t1 = new Thread(new Runnable() {
			            public void run() {
			                for(int i = 0; i < 36; i++){
			                    try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
			                    if(i==0) b1.setBackground(Color.WHITE);
			                    else if(i==1) b2.setBackground(Color.WHITE);
			                    else if(i==2) b3.setBackground(Color.WHITE);
			                    else if(i==3) b4.setBackground(Color.WHITE);
			                    else if(i==4) b5.setBackground(Color.WHITE);
			                    else if(i==5) b6.setBackground(Color.WHITE);
			                    else if(i==6) b7.setBackground(Color.WHITE);
			                    else if(i==7) b8.setBackground(Color.WHITE);
			                    else if(i==8) b9.setBackground(Color.WHITE);
			                    else if(i==9) b10.setBackground(Color.WHITE);
			                    else if(i==10) b11.setBackground(Color.WHITE);
			                    else if(i==11) b12.setBackground(Color.WHITE);
			                    else if(i==12) b13.setBackground(Color.WHITE);
			                    else if(i==13) b14.setBackground(Color.WHITE);
			                    else if(i==14) b15.setBackground(Color.WHITE);
			                    else if(i==15) b16.setBackground(Color.WHITE);
			                    else if(i==16) b17.setBackground(Color.WHITE);
			                    else if(i==17) b18.setBackground(Color.WHITE);
			                    else if(i==18) b19.setBackground(Color.WHITE);
			                    else if(i==19) b20.setBackground(Color.WHITE);
			                    else if(i==20) b21.setBackground(Color.WHITE);
			                    else if(i==21) b22.setBackground(Color.WHITE);
			                    else if(i==22) b23.setBackground(Color.WHITE);
			                    else if(i==23) b24.setBackground(Color.WHITE);
			                    else if(i==24) b25.setBackground(Color.WHITE);
			                    else if(i==25) b26.setBackground(Color.WHITE);
			                    else if(i==26) b27.setBackground(Color.WHITE);
			                    else if(i==27) b28.setBackground(Color.WHITE);
			                    else if(i==28) b29.setBackground(Color.WHITE);
			                    else if(i==29) b30.setBackground(Color.WHITE);
			                    else if(i==30) b31.setBackground(Color.WHITE);
			                    else if(i==31) b32.setBackground(Color.WHITE);
			                    else if(i==32) b33.setBackground(Color.WHITE);
			                    else if(i==33) b34.setBackground(Color.WHITE);
			                    else if(i==34) b35.setBackground(Color.WHITE);
			                    else if(i==35) b36.setBackground(Color.WHITE);
			                }
			            }
			        });		
					t1.start();
					
					Thread t2 = new Thread(new Runnable() {
			            public void run() {
			                for(int i = 35; i >= 0; i--){
			                    try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
			                    if(i==0) {
			                    	b1.setBackground(Color.RED);
				                    if(colorMap.get(spinnedNumber)=="red") labelSpin.setForeground(Color.red);
									else if(colorMap.get(spinnedNumber)=="black") labelSpin.setForeground(Color.black);
									else labelSpin.setForeground(Color.yellow);
									labelSpin.setText(spinnedNumber+"");
									if(cash-initialCash>0) {
										labelSpinResult.setText("You won " + (int)(cash-initialCash) + "$");
									}
									else {
										labelSpinResult.setText("No win");
									}
									printBets();
			                    }
			                    else if(i==1) b2.setBackground(Color.BLACK);
			                    else if(i==2) b3.setBackground(Color.RED);
			                    else if(i==3) b4.setBackground(Color.BLACK);
			                    else if(i==4) b5.setBackground(Color.RED);
			                    else if(i==5) b6.setBackground(Color.BLACK);
			                    else if(i==6) b7.setBackground(Color.RED);
			                    else if(i==7) b8.setBackground(Color.BLACK);
			                    else if(i==8) b9.setBackground(Color.RED);
			                    else if(i==9) b10.setBackground(Color.BLACK);
			                    else if(i==10) b11.setBackground(Color.BLACK);
			                    else if(i==11) b12.setBackground(Color.RED);
			                    else if(i==12) b13.setBackground(Color.BLACK);
			                    else if(i==13) b14.setBackground(Color.RED);
			                    else if(i==14) b15.setBackground(Color.BLACK);
			                    else if(i==15) b16.setBackground(Color.RED);
			                    else if(i==16) b17.setBackground(Color.BLACK);
			                    else if(i==17) b18.setBackground(Color.RED);
			                    else if(i==18) b19.setBackground(Color.RED);
			                    else if(i==19) b20.setBackground(Color.BLACK);
			                    else if(i==20) b21.setBackground(Color.RED);
			                    else if(i==21) b22.setBackground(Color.BLACK);
			                    else if(i==22) b23.setBackground(Color.RED);
			                    else if(i==23) b24.setBackground(Color.BLACK);
			                    else if(i==24) b25.setBackground(Color.RED);
			                    else if(i==25) b26.setBackground(Color.BLACK);
			                    else if(i==26) b27.setBackground(Color.RED);
			                    else if(i==27) b28.setBackground(Color.BLACK);
			                    else if(i==28) b29.setBackground(Color.BLACK);
			                    else if(i==29) b30.setBackground(Color.RED);
			                    else if(i==30) b31.setBackground(Color.BLACK);
			                    else if(i==31) b32.setBackground(Color.RED);
			                    else if(i==32) b33.setBackground(Color.BLACK);
			                    else if(i==33) b34.setBackground(Color.RED);
			                    else if(i==34) {b35.setBackground(Color.BLACK);b36.setBackground(Color.RED);}
			                    else if(i==35) {
			                    	try {Thread.sleep(3700);} catch (InterruptedException e) {e.printStackTrace();}
			                    }
			                }
			            }
			        });		
					t2.start();
					
				}
				else {
					labelSpinResult.setText("No bet");
				}
			}

			
		});
		
		bSpin.setForeground(Color.BLACK);
		bSpin.setFocusable(false);
		bSpin.setFont(new Font("Tahoma", Font.BOLD, 20));
		bSpin.setBounds(630, 470, 280, 50);
		frame.getContentPane().add(bSpin);
		
		labelSpin = new JLabel("",SwingConstants.CENTER);
		labelSpin.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelSpin.setBounds(630, 538, 280, 40);
		frame.getContentPane().add(labelSpin);
		
		labelBets = new JLabel("",SwingConstants.CENTER);
		labelBets.setForeground(Color.BLACK);
		labelBets.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelBets.setBounds(350, 410, 270, 310);
		frame.getContentPane().add(labelBets);
		
		labelSpinResult = new JLabel("", SwingConstants.CENTER);
		labelSpinResult.setForeground(Color.BLACK);
		labelSpinResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelSpinResult.setBounds(630, 589, 280, 40);
		frame.getContentPane().add(labelSpinResult);
		
		final JButton bClearBet = new JButton("Clear bet");
		bClearBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<49; i++) {
					if(cashOn[i] != 0) {
						cash += cashOn[i];
					}
				}
				cashOn = new int[49];
				printBets();
			}
		});
		bClearBet.setFocusable(false);
		bClearBet.setFont(new Font("Tahoma", Font.BOLD, 14));
		bClearBet.setForeground(Color.BLACK);
		bClearBet.setBounds(120, 538, 180, 40);
		frame.getContentPane().add(bClearBet);
		
		bRestart = new JButton("Restart");
		bRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cash = 1000;
				bRestart.setVisible(false);
				printBets();
			}
		});
		bRestart.setVisible(false);
		bRestart.setForeground(Color.BLACK);
		bRestart.setFont(new Font("Tahoma", Font.BOLD, 14));
		bRestart.setFocusable(false);
		bRestart.setBounds(120, 589, 180, 40);
		frame.getContentPane().add(bRestart);
		if(cash == 0) {
			bRestart.setVisible(true);
		}
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<49;i++) {
					cash += cashOn[i];
					cashOn[i] = 0;
				}
				insertRoulette(MainMenu.conn,cash);
				MainMenu.main(null);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(10, 675, 80, 25);
		frame.getContentPane().add(btnNewButton);
	}

	/**
	 * This method populates the cashOn array with the ammount of money on every position
	 * 
	 * @param button Anybutton from 0 to 36
	 */
	protected void placeBet(final JButton button) {
		if(cash - betCoinValue >= 0) {
			cash -= betCoinValue;
			cashOn[Integer.parseInt(button.getText())] += betCoinValue;
			printBets();
		}
	}
	
	/**
	 * This method returns the number of bets that have been placed
	 * 
	 * @return number of bets
	 */
	public static int getNumberOfBets() {
		int numberOfBets = 0;
		for(int i=0; i<49; i++) {
			if(cashOn[i] != 0) {
				numberOfBets++;
			}
		}
		return numberOfBets;
	}
	
	
	/**
	 * This method returns the number of bets that have been placed
	 * 
	 * @param cashOn Bets placed on every position array
	 * @return number of bets
	 */
	public static int getNumberOfBetsForTest(int[] cashOn) {
		int numberOfBets = 0;
		for(int i=0; i<49; i++) {
			if(cashOn[i] != 0) {
				numberOfBets++;
			}
		}
		insertRoulette(MainMenu.conn,cash);
		return numberOfBets;
	}
	
	/**
	 * This method prints on a label the bets that have been placed
	 */
	private void printBets() {
		insertRoulette(MainMenu.conn,cash);
		if(getNumberOfBets() < 5) {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 17));
		}
		if(getNumberOfBets() < 10) {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 15));
		}
		else if(getNumberOfBets() < 15) {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 13));
		}
		else if(getNumberOfBets() < 20) {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 11));
		}
		else if(getNumberOfBets() < 25) {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 7));
		}
		else {
			labelBets.setFont(new Font(labelBets.getName(), Font.BOLD, 5));
		}
		labelCash.setText(cash+"$");
		labelBets.setText("");
		for(int i=0; i<49; i++) {
			if(cashOn[i] != 0) {
				if(i<37) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on " + i);
				}
				else if(i==37) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on first line");
				}
				else if(i==38) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on second line");
				}
				else if(i==39) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on third line");
				}
				else if(i==40) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on 1 to 12");
				}
				else if(i==41) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on 13 to 24");
				}
				else if(i==42) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on 25 to 36");
				}
				else if(i==43) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on 1 to 18");
				}
				else if(i==44) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on even number");
				}
				else if(i==45) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on red");
				}
				else if(i==46) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on black");
				}
				else if(i==47) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on odd number");
				}
				else if(i==48) {
					labelBets.setText(labelBets.getText() + "<html><br/>" + cashOn[i] + "$ on 19 to 36");
				}
			}
		}
	}
	
	private static void assignRoulette(Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM roulette_bd");
			while (rs.next()) {
				cash = rs.getInt("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void insertRoulette(Connection conn, int x) {
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("INSERT INTO roulette_bd VALUES (" + x + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/*
1-36 -> doar numere (x36)
37 -> linia 1 (x3)
38 -> linia 2 (x3)
39 -> linia 3 (x3)
40 -> 1 to 12 (x3)
41 -> 13 to 24 (x3)
42 -> 25 to 36 (x3)
43 -> 1 to 18 (x2)
44 -> even (x2)
45 -> red (x2)
46 -> black (x2)
47 -> odd (x2)
48 -> 19 to 36 (x2)
*/
