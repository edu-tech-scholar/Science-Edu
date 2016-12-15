package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Summary1 extends Contents {

	private JPanel contentPane;

	private JFrame summaryFrame = new JFrame();

	/**
	 * Launch the application.
	 */

	@Override
	public void run() {
		summaryFrame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Summary1() {
		summaryFrame.setTitle("Moon and Constellation");
		summaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		summaryFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		summaryFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contents quiz = new MoonQuiz();

				quiz.run();
				summaryFrame.dispose();

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
				summaryFrame.dispose();

			}

		});
		btnMenu.setBounds(0, 72, 103, 37);
		contentPane.add(btnMenu);

		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSummary.setForeground(Color.WHITE);
		lblSummary.setBounds(266, 10, 172, 29);
		contentPane.add(lblSummary);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 677, 449);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("oreo.png"));
		lblNewLabel_1.setBounds(112, 53, 461, 375);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("back.jpg"));
		lblNewLabel.setBounds(0, 0, 677, 449);
		panel.add(lblNewLabel);
	}

}
