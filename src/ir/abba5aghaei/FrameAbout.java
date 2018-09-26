package ir.abba5aghaei;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class FrameAbout extends JFrame {
	
	private static final long serialVersionUID = -3700337089293812201L;
	JTextPane titraj;

	FrameAbout() {
		
		setTitle("About App");
		setBounds(550, 160, 180, 150);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		String content = "    Data Structures\n       Version 1.0\n   (Build 29/3/2017)\n      Programmer:\n  Seyed abbas aghaei\n       (using Java)\nContact: @abba5aghaei";
		
		titraj = new JTextPane();
		titraj.setFont(new Font("Tohama", Font.PLAIN, 13));
		titraj.setBounds(20, 160, 150, 140);
		titraj.setText(content);
		titraj.setEditable(false);
		titraj.setBackground(Color.DARK_GRAY);
		titraj.setForeground(Color.white);
		
		Timer time = new Timer();
		
		Mover mover = new Mover();
		
		time.schedule(mover, 0, 50);
		
		JButton approv = new JButton("OK");
		approv.setFocusTraversalKeysEnabled(false);
		approv.setBounds(55, 120, 70, 25);
		approv.setBackground(Color.DARK_GRAY);
		approv.setForeground(Color.white);
		approv.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				
				time.cancel();
				
				dispose();
			}});
		
		getContentPane().add(titraj);
		getContentPane().add(approv);
	}
	public class Mover extends TimerTask {

		public void run() {
			
			titraj.setBounds(20, titraj.getY()-1, 150, 140);
			
			if(titraj.getY() == -130)
				titraj.setBounds(20, 160, 150, 140);;
		}}
}
