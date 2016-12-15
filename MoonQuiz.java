package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class MoonQuiz extends Contents {

	private JPanel contentPane;

	private JFrame quizFrame = new JFrame();

	/**
	 * Launch the application.
	 */

	@Override
	public void run() {
		quizFrame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MoonQuiz() {
		quizFrame.setTitle("Moon and Constellation");
		quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		quizFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contents example = new MoonExample();
				example.run();
				quizFrame.dispose();

			}

		});
		btnNewButton.setBounds(588, 72, 89, 37);
		contentPane.add(btnNewButton);

		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu mainmenu = new MainMenu();
				mainmenu.mainMenuStart();
				quizFrame.dispose();

			}

		});
		btnMenu.setBounds(0, 72, 103, 37);
		contentPane.add(btnMenu);

		JLabel lblQuiz = new JLabel("Quiz");
		lblQuiz.setFont(new Font("Arial", Font.BOLD, 17));
		lblQuiz.setForeground(Color.WHITE);
		lblQuiz.setBounds(281, 10, 99, 29);
		contentPane.add(lblQuiz);

		JLabel lblWhichTwoMoons = new JLabel("Which two moons are also called half moons?");
		lblWhichTwoMoons.setForeground(Color.WHITE);
		lblWhichTwoMoons.setBounds(108, 130, 536, 37);
		contentPane.add(lblWhichTwoMoons);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Waning Crescent & Waxing Crescent");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Wrong! Try again", "Quiz", JOptionPane.INFORMATION_MESSAGE);

				rdbtnNewRadioButton.setSelected(false);

			}

		});
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(108, 190, 424, 37);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("First Quarter & Third Quarter");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Correct! The answer is First Quarter & Third Quarter ", "Quiz",
						JOptionPane.INFORMATION_MESSAGE);

				rdbtnNewRadioButton_1.setSelected(false);

			}

		});
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(108, 260, 331, 37);
		contentPane.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Waxing Crescent & First Quarter");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Wrong! Try again", "Quiz", JOptionPane.INFORMATION_MESSAGE);

				rdbtnNewRadioButton_2.setSelected(false);

			}

		});

		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(108, 335, 375, 37);
		contentPane.add(rdbtnNewRadioButton_2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 677, 449);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("back.jpg"));
		panel.add(lblNewLabel);
	}
}