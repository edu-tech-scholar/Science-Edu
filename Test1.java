package application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

public class Test1 extends MoonAndConstellation {

	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();

	private static JFrame myFrame = new JFrame();

	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		try {
			// Create frame

			myFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Test1() {

		// create the title of frame
		myFrame.setTitle("Moon and Constellation");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		myFrame.setContentPane(contentPane);

		// put background picture into panel
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("background.jpg").getImage();
				g.drawImage(img, 0, 0, this);

			}
		};

		//
		JLabel lblNewLabel_4 = new JLabel(
				"Q1. Which of the following \r\ndoes not match the picture \r\nand it's name?");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("test/crescent.jpg"));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("test/fullmoon.jpg"));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Crescent moon");
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == rdbtnNewRadioButton) {

					JOptionPane.showMessageDialog(null, "Wrong answer! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		buttonGroup.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Full moon");
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == rdbtnNewRadioButton_1) {

					JOptionPane.showMessageDialog(null, "Wrong answer! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("test/gibbous.JPG"));

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Oval moon");
		rdbtnNewRadioButton_2.setForeground(Color.BLACK);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == rdbtnNewRadioButton_2) {

					JOptionPane.showMessageDialog(null, "Correct! This is Gibbous moon ! Go to next step!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("test/half.JPG"));

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Half moon");
		rdbtnNewRadioButton_3.setForeground(Color.BLACK);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (ae.getSource() == rdbtnNewRadioButton_3) {

					JOptionPane.showMessageDialog(null, "Wrong answer! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		buttonGroup.add(rdbtnNewRadioButton_3);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu();
				menu.mainMenuStart();
				myFrame.dispose();

			}
		});

		JButton btnNext = new JButton("Next ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				Test2 test = new Test2();
				test.run();
				myFrame.dispose();

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel
								.createSequentialGroup().addGroup(gl_panel.createParallelGroup(
										Alignment.LEADING)
										.addGroup(
												gl_panel.createSequentialGroup().addGap(12).addComponent(lblNewLabel_4))
										.addGroup(gl_panel.createSequentialGroup().addGap(35)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 132,
																Short.MAX_VALUE)
														.addComponent(rdbtnNewRadioButton)
														.addComponent(rdbtnNewRadioButton_2)
														.addComponent(lblNewLabel_2, 0, 0, Short.MAX_VALUE))
												.addGap(53)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(rdbtnNewRadioButton_3)
														.addComponent(rdbtnNewRadioButton_1)
														.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnNext, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnMainMenu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addContainerGap(27, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addComponent(lblNewLabel_4).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(10)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_1, 0, 0, Short.MAX_VALUE).addComponent(
														lblNewLabel, GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnNewRadioButton).addComponent(rdbtnNewRadioButton_1))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_2)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(rdbtnNewRadioButton_2))
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(rdbtnNewRadioButton_3))))
								.addGroup(gl_panel.createSequentialGroup().addGap(40).addComponent(btnMainMenu)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNext)))
						.addContainerGap(17, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}
}

class Test2 {
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	static JFrame myFrame = new JFrame();

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			Test2 frame = new Test2();
			myFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Test2() {
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		myFrame.setContentPane(contentPane);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("background.jpg").getImage();
				g.drawImage(img, 0, 0, this);

			}
		};
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE));

		JLabel lblQWhichOf = new JLabel("Q2. Which of the following does match the picture and it's name?");
		lblQWhichOf.setFont(new Font("Arial", Font.BOLD, 13));
		lblQWhichOf.setForeground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("test/Cancer.JPG"));

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("test/Gemini.JPG"));

		JRadioButton rdbtnCancer = new JRadioButton("Cancer");
		buttonGroup.add(rdbtnCancer);
		rdbtnCancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == rdbtnCancer) {

					JOptionPane.showMessageDialog(null, "Correct!!", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Girls");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == rdbtnNewRadioButton) {

					JOptionPane.showMessageDialog(null, "Wrong answer! This is Gemini! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("test/Libra.JPG"));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("test/Virgo.JPG"));

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Scale");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnNewRadioButton_1) {

					JOptionPane.showMessageDialog(null, "Wrong answer! This is Libra! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Athena");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnNewRadioButton_2) {

					JOptionPane.showMessageDialog(null, "Wrong answer! This is Virgo! Try again!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnMainmenu = new JButton("Main Menu");
		btnMainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu();
				menu.mainMenuStart();
				myFrame.dispose();

			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQWhichOf).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
										.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(rdbtnCancer))
										.addComponent(lblNewLabel_2)
										.addGroup(gl_panel.createSequentialGroup().addGap(10)
												.addComponent(rdbtnNewRadioButton_1)))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNewRadioButton_2)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 167,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnNewRadioButton)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 162,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(btnMainmenu, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
				.addContainerGap(40, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addComponent(lblQWhichOf)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1, 0, 0, Short.MAX_VALUE).addComponent(lblNewLabel,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnCancer)
										.addComponent(rdbtnNewRadioButton))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3, 0, 0, Short.MAX_VALUE).addComponent(lblNewLabel_2))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(rdbtnNewRadioButton_1).addComponent(rdbtnNewRadioButton_2))
								.addContainerGap(38, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addGap(27).addComponent(btnMainmenu)
								.addPreferredGap(ComponentPlacement.UNRELATED).addContainerGap()))));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
