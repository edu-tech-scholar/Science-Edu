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
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simulation_c extends MoonAndConstellation {

	private JPanel contentPane;
	private JPanel panel_1;
	private static int x=190;//moon's location  x-coordinate
	private static int y=208; //moon's location  y-coordinate
	private static int i=500;// value of JSlider
	private static int count=1;// number of picture (moon's phases)
	private double pi=3.141592;
	static Simulation_c con_sim_frame;
	private JButton sim_con_but;
	
	private JFrame mainFrame = new JFrame();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Simulation_c() {
		mainFrame.setTitle("Moon and Constellation");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 900, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setContentPane(contentPane);

		
		JPanel panel = new JPanel(){
			
			public void paintComponent(Graphics g){
				
				
					g.setColor(Color.black);
					g.fillRect(0, 0, 900, 900);

					Image constellation = new ImageIcon("Constellation_pic/Constellation.jpg").getImage();
					g.drawImage(constellation, 0, 0, this);

					//moon's picture around the earth. it moves around the picture of earth by using its location x and y
					
					Image earth = new ImageIcon("Constellation_pic/earth2.jpg").getImage();
					g.drawImage(earth, (int)x, (int)y, this);
					

				
			}	
		};
		

		JSlider slider_1 = new JSlider();
		slider_1.setMaximum(1000);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				i = (slider_1.getValue()+500)%1000;
				x=(int) ((1+Math.cos(i*2*pi/1000))*40)+195;
				y=(int) ((1-Math.sin(i*2*pi/1000))*50)+158;
				panel.repaint();
			
				count = (int) ((slider_1.getValue()*59)/1000)+1;
				panel_1.repaint();
				
			}
		});
		
		
		panel_1 = new JPanel(){
			@Override
			public void paintComponent(Graphics g){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 900, 900);
			
			
			Image[] img = new Image[12];
			for(int i = 0; i<img.length; i++){
				img[i] = new ImageIcon("Constellation_pic/"+i+".jpg").getImage();
			}
			
			//Each picture changes according to the change of the value of JSlider
			
			for(int i=0; i<60; i++){
				if(count == i){
					g.drawImage( img[(int)(i/5)], (30-(i%5)*10), 0, this);
					}
			}
			}
		};
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		sim_con_but = new JButton("MENU");
		sim_con_but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu main = new MainMenu();
				main.mainMenuStart();
				mainFrame.dispose();
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(248, Short.MAX_VALUE)
					.addComponent(sim_con_but)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(386, Short.MAX_VALUE)
					.addComponent(sim_con_but)
					.addGap(45))
		);
		panel_1.setLayout(gl_panel_1);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(321, Short.MAX_VALUE)
					.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(388, Short.MAX_VALUE)
					.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	public void run() {
		try {
			
			mainFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}