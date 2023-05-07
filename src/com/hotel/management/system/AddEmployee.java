package com.hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
	
	
	JTextField tfname, tfemail , tfphone , tfage, tfsalary , tfaadhar;
	JRadioButton rbmale , rbfemale ;
	JButton submit;
	JComboBox cbjob;
	
	
	//contructor
	AddEmployee(){
		setLayout(null);
		
		//label 1 name
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60,30,120,30);
		lblname.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblname);
		
		//text 1 for name
		tfname = new JTextField();
		tfname.setBounds(200,30,150,30);
		add(tfname);
		
		//label 2 age
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60,80,120,30);
		lblage.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblage);
		
		//text 2 for age
		tfage = new JTextField();
		tfage.setBounds(200,80,150,30);
		add(tfage);
		
		//label 3 gender
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60,130,120,30);
		lblgender.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblgender);
		
		//radiobutton1 for gender male 
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200,130,70,30);
		rbmale.setFont(new Font("Tahoma" , Font.PLAIN, 14));
		rbmale.setBackground(Color.white);
		add(rbmale);
		
		
		//radiobutton2 for gender female 
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280,130,70,30);
		rbfemale.setFont(new Font("Tahoma" , Font.PLAIN, 14));
		rbfemale.setBackground(Color.white);
		add(rbfemale);
		
		//male ya female me se ek hi select hoga
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(rbmale);
	    bg.add(rbfemale);
	    
		
		//label 4 job
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60,180,120,30);
		lbljob.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lbljob);
		
		//dropdown for jobs categories
		String str[] = { "Front Desk Clerk" , "Porter" , "HouseKeeping" , "Kitchen Staff" , "Room Service" , "Chefs" ,"Waiter/Waitress","Manager","Accountant"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200,180,150,30);
		cbjob.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		cbjob.setBackground(Color.white);
		add(cbjob);
		
		//label 5 salary
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60,230,120,30);
		lblsalary.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblsalary);
		
		//text 5 for salary
		tfsalary = new JTextField();
		tfsalary.setBounds(200,230,150,30);
		add(tfsalary);
		
		//label 6 phone
		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(60,280,120,30);
		lblphone.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblphone);
		
		//text 6 for phone
		tfphone = new JTextField();
		tfphone.setBounds(200,280,150,30);
		add(tfphone);
		
		
		//label 7 email
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60,330,120,30);
		lblemail.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblemail);
		
		//text 7 for email
		tfemail = new JTextField();
		tfemail.setBounds(200,330,150,30);
		add(tfemail);
		
		
		//label 8 aadhar
		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setBounds(60,380,120,30);
		lblaadhar.setFont(new Font("Tahoma" , Font.PLAIN, 17));
		add(lblaadhar);
		
		//text 8 for aadhar
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200,380,150,30);
		add(tfaadhar);
		
		
		//button
		submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(200,430,150,30);
		submit.addActionListener(this);
		add(submit);
		
		//image
		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		image.setBounds(380,60,450,370);
//		add(image);
		
		
		//to change color of frame
		getContentPane().setBackground(Color.yellow);
		
		setBounds(350,200,850,540);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();
		
		String gender = null;
		
		//validation for name
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name Should not be empty");
			return;
		}
		
		if(rbmale.isSelected()) {
			gender = "Male";
		}else if(rbfemale.isSelected()) {
			gender = "Female";
		}
		
		String job = (String)cbjob.getSelectedItem();
		
		try {
			Conn conn = new Conn();
			
			String query  = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			
			conn.s.executeUpdate(query);
			
			//for pop-up
			JOptionPane.showMessageDialog(null,"Employee added successfully");
			
			setVisible(false);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	public static void main(String[] args) {
		new AddEmployee();
		

	}

}

