package application;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javafx.application.Platform;
import simulation.PictureDragTest;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends Login {

	private JPanel contentPane;

	private JFrame jFrame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.run();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mainMenuStart() {
		

		jFrame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		Platform.setImplicitExit(false);
		jFrame.setTitle("Moon and Constellation");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jFrame.setContentPane(contentPane);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("background.jpg").getImage();
				g.drawImage(img, 0, 0, this);

			}
		};

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE));

		JButton btnConcept = new JButton("Concept");
		btnConcept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Select select = new Select();
				select.run();
				select.setFlag(2);
				jFrame.dispose();
				
			}
		});

		JButton btnQuiz = new JButton("Test");
		btnQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			Test1 test= new Test1();
				test.run();
				jFrame.dispose();
			}
		});

		JButton btnGame = new JButton("Game");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PictureDragTest picture_test = new PictureDragTest();
				picture_test.run();
				jFrame.dispose();

			}
		});

		JButton button = new JButton("Simulation ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select select = new Select();
				select.setFlag(1);
				select.run();
				jFrame.dispose();
			}
		});

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jFrame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(236).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnQuit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(btnGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnConcept, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(btnQuiz, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
						.addContainerGap(210, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(73).addComponent(btnConcept).addGap(18)
						.addComponent(btnQuiz).addGap(18).addComponent(button).addGap(18).addComponent(btnGame)
						.addGap(18).addComponent(btnQuit).addContainerGap(84, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}