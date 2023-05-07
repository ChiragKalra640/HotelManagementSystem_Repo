package com.hotel.management.system;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateRoom extends JFrame implements ActionListener{
	
	Choice ccustomer;
	JTextField tfroom,tfavailable,tfstatus;
	JButton check,update,back;
	
	UpdateRoom(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//--------------------------------------------
		//------LABEL 0 heading UPDATE ROOM STATUS--------
		
		JLabel text = new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma",Font.BOLD,25));
		text.setBounds(30,20,270,30);
		text.setForeground(Color.BLUE);
		add(text);
		
		
		//--------------------------------------------
		
		//------LABEL 1 Customer id--------
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,20);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------------
		//------LABEL 2 Room Number --------
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,130,100,20);
		add(lblroom);
		
		tfroom = new JTextField();
		tfroom.setBounds(200,130,150,25);
		add(tfroom);
		
		//-------------------------------------------------
		//------LABEL 3 Availability --------
				
		
		JLabel lblavailable = new JLabel("Availability");
		lblavailable.setBounds(30,180,100,20);
		add(lblavailable);
		
		tfavailable = new JTextField();
		tfavailable.setBounds(200,180,150,25);
		add(tfavailable);
		
		//-------------------------------------------------
		//------LABEL 4 Cleaning Status --------
		
		
		JLabel lblstatus = new JLabel("Cleaning Status");
		lblstatus.setBounds(30,230,100,20);
		add(lblstatus);
		
		tfstatus = new JTextField();
		tfstatus.setBounds(200,230,150,25);
		add(tfstatus);
		
		//-------------------------------------------------
		
		
		
		//-------------------------------------------------
	
		//Button 1
		
		check = new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.addActionListener(this);
		check.setBounds(30,300,100,30);
		add(check);
		
		
		//Button 2
		update = new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setBounds(150,300,100,30);
		add(update);
		
		//Button 3
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(270,300,100,30);
		add(back);
		
		
		//---------------------------------------------------
		//--------IMAGE-----------
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(400,50,500,300);
//		add(image);
		
		

		//-------------------------------------------------
		setBounds(300,200,980,450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== check) {
			
			String id = ccustomer.getSelectedItem();
			
			String query = "select * from customer where number = '"+id+"'";
			
			try {
				
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfroom.setText(rs.getString("room"));
					
					
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
				while(rs2.next()) {
					tfavailable.setText(rs2.getString("availablity"));
					tfstatus.setText(rs2.getString("cleaning_status"));

				}



				}
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
		} else if(ae.getSource()== update) {
			
			String number = ccustomer.getSelectedItem();
			String room = tfroom.getText();
			String available = tfavailable.getText();
			String status = tfstatus.getText();
			
			try {
				
				Conn c = new Conn();
				c.s.executeUpdate("update room set availablity = '"+available+"',cleaning_status = '"+status+"'where roomnumber ='"+room+"'");
				JOptionPane.showMessageDialog(null,"Data Updated Successfully");
				
				setVisible(false);
				new Reception();
				
			}catch(Exception e) {
				e.printStackTrace();
			}


		} else{
			setVisible(false);
			new Reception();
			
		}
	}

	public static void main(String[] args) {
		new UpdateRoom();
		

	}

}

