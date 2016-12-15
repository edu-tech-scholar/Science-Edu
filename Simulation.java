package simulation;


import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import application.MainMenu;
import application.MoonAndConstellation;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulation extends MoonAndConstellation{

	private JPanel contentPane;
	private  int x=480; //moon's location  x-coordinate
	private int y=220; //moon's location  y-coordinate
	private int i=500; // value of JSlider
	private int count=1; // number of picture (moon's phases)
	private double pi=3.141592; 
	private JPanel panel;
	private JFrame simulation_frame;
	

	/**
	 * Create the frame.
	 */
	public Simulation() 
	{
		simulation_frame = new JFrame();
		simulation_frame.setTitle("Moon and Constellation");
		simulation_frame.setResizable(true);
		simulation_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simulation_frame.setBounds(100, 100, 1206, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		simulation_frame.setContentPane(contentPane);
		




		
		
		panel = new JPanel(){
			public void paintComponent(Graphics g){
				g.setColor(Color.black);
				g.fillRect(0, 0, 1700, 1700);

				Image sun = new ImageIcon("sun.jpg").getImage();
				g.drawImage(sun, 0, 0, this);

				Image earth = new ImageIcon("earth.jpg").getImage();
				g.drawImage(earth, 300, 170, this);
				
				//moon's picture around the earth. it moves around the picture of earth by using its location x and y
				Image moon = new ImageIcon("moon.jpg").getImage();
				g.drawImage(moon, (int)x, (int)y, this);
				
				//26 moon phases pictures from new moon to full moon
				Image[] img = new Image[26];
				for(int i = 0; i<img.length; i++){
					 img[i] = new ImageIcon("moon_simulation/"+(i+1)+".jpg").getImage();
				}
				
				//Each picture changes according to the change of the value of JSlider
				for(int i=0;i<26;i++){
					if(count == i+1){
						g.drawImage(img[i], 700, 50, this);
					}
				}
			}
		};
		
		JSlider slider = new JSlider();
		slider.setMaximum(1000); // I've set this value to make the movement of the picture detail
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
													//take i value from slider and convert it to the value what I want 
				i = (slider.getValue()+500)%1000; //value of JSlider from 500->999->1->500
				x=(int) ((1+Math.cos(i*2*pi/1000))*140)+200; //moon's location (it moves around the earth) I use mathematical method sin and cos function.
				y=(int) ((1-Math.sin(i*2*pi/1000))*140)+70;	// moon's location
				count = (int) ((slider.getValue()*25)/1000)+1; // number of picture
				
				panel.repaint();
			}
		});
		
		JButton sim_but = new JButton("MENU"); //this button goes to MainMenu
		sim_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.mainMenuStart();
				simulation_frame.dispose();
			}
		});
		 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1186, GroupLayout.PREFERRED_SIZE)
							.addGap(17))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
							.addGap(176)
							.addComponent(sim_but)
							.addGap(54))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sim_but))
					.addContainerGap())
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 1186, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 549, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}



	@Override
	public void run() { // run this class
		simulation_frame.setVisible(true);
	}
	
}