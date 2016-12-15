package application;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simulation.Simulation;
import simulation.Simulation_c;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select extends MoonAndConstellation {

	private JPanel contentPane;
	private JFrame selectFrame = new JFrame();
	
	private int flag;        // this variable roles indicator
	/**
	 * Launch the application.
	 */

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * Create the frame.
	 */
	public Select() {
	selectFrame.setTitle("Moon and Constellation");
		selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectFrame.setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		selectFrame.setContentPane(contentPane);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){		 
				super.paintComponent(g);
		        Image img =  new ImageIcon("background.jpg").getImage();
		        g.drawImage(img, 0, 0, this); 
				
			}
		};
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnConstellation = new JButton("Constellation");
		btnConstellation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag == 1){
					Simulation_c sim_c = new Simulation_c();  //if you see the simulation_c Class,
					sim_c.run();							  // flag sets to 1 , so if you click Constellation button
					selectFrame.dispose();					  // you can see Simulation_c class
				}
				
				if(flag == 2){
					Contents video = new ConstellationVideo(); //if you see ConstellationVideo Class
					video.run();							   //flag sets to 2, so if you click Constellation Button
					selectFrame.dispose();					   // you can see ConstellationVideo class.
				}
			}
		});
		
		JButton btnMoonPhase = new JButton("Moon Phase");
		btnMoonPhase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag == 1){
					Simulation sim = new Simulation(); //if you see Simulation Class
					sim.run();						   //flag sets to 1, so if you click Moon Phase Button
					selectFrame.dispose();			   // you can see ConstellationVideo class.
				}
				if(flag == 2){
					Contents video = new MoonVideo(); // if you see MoonVideo Class
					video.run();					  // flag sets to 2, so if you click Moon Phase Button
					selectFrame.dispose();			  // you can see MoonVideo Class
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(283)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnMoonPhase, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
						.addComponent(btnConstellation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(261))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(130)
					.addComponent(btnConstellation)
					.addGap(101)
					.addComponent(btnMoonPhase)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void run() {
		try {
			
			selectFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		
	}
}
}