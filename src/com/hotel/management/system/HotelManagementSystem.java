package com.hotel.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;



public class HotelManagementSystem extends JFrame implements ActionListener {
	
	HotelManagementSystem(){

		
		setBounds(100,100,1366,565);
		setLayout(null);
		
		
		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
//		JLabel image = new JLabel(i1);
//		image.setBounds(0,0,1166,565);
//    	add(image);
		
		
		//label to show Hotel management system
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,90);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("serif" , Font.PLAIN, 50));
		add(text);
		
		
		//button NEXT
		
		JButton next = new JButton("Next");
		next.setBounds(1150 , 450 , 150 , 50);
		next.setBackground(Color.red);
		next.setForeground(Color.green);
		next.addActionListener(this); // is button pe event hona hai iske liye ye likha hai
		next.setFont(new Font("serif" , Font.PLAIN, 30));
		add(next);
		
		
		setVisible(true);
		
		
	    // is code se hum hotel maanagement system ko dipper krwa rhe hai
		while(true) {
			
			text.setVisible(false);
			
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
			
			
	 //button ke click pe ye hoga.
			
	public void actionPerformed(ActionEvent ae) {
		
		setVisible(false); //current frame close 
		new Login();       // new frame open (login wala frame)
		
		
	}

	public static void main(String[] args) {
		new HotelManagementSystem();
		

	}

}
