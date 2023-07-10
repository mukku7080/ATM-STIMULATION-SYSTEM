package BankSystem;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
//import javax.swing.JLabel;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
	JTextField namet,fnamet,addresst,emailt,pint,cityt,statet;
	JRadioButton male,female,maried,unmaried,other;
	JButton next;
	long random;
	JDateChooser date;
	{
		Random ran=new Random();
		random=Math.abs(ran.nextLong()%9000+1000L);
		JLabel formno=new JLabel("Form No: " +random);
		formno.setBounds(400,10,200,30);
		formno.setFont(new Font("Raleway",Font.BOLD,22));
		add(formno);
		JLabel personaldetail=new JLabel("Page 1: Personal Detail");
		personaldetail.setBounds(160,60,300,30);
		personaldetail.setFont(new Font("Raleway",Font.BOLD,22));
		add(personaldetail);
		JLabel name=new JLabel("NAME:");
		name.setBounds(100,160,100,30);
		name.setFont(new Font("Raleway",Font.BOLD,18));
		add(name);
		namet=new JTextField();
		namet.setBounds(300,160,250,25);
		namet.setFont(new Font("Raleway",Font.BOLD,18));
		add(namet);
		JLabel fname=new JLabel("FATHER 'S NAME:");
		fname.setBounds(100,200,200,30);
		fname.setFont(new Font("Raleway",Font.BOLD,18));
		add(fname);
		fnamet=new JTextField();
		fnamet.setBounds(300,200,250,25);
		fnamet.setFont(new Font("Raleway",Font.BOLD,18));
		add(fnamet);
		JLabel gender=new JLabel("GENDER:");
		gender.setBounds(100,240,100,30);
		gender.setFont(new Font("Raleway",Font.BOLD,18));
		add(gender);
		male=new JRadioButton("Male");
		male.setBounds(300,240,75,25);
		male.setBackground(Color.white);
		add(male);
		female=new JRadioButton("Female");
		female.setBounds(400,240,75,25);
		female.setBackground(Color.white);
		add(female);
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		JLabel email=new JLabel("EMAIL:");
		email.setBounds(100,280,100,30);
		email.setFont(new Font("Raleway",Font.BOLD,18));
		add(email);
		emailt=new JTextField();
		emailt.setBounds(300,280,250,25);
		emailt.setFont(new Font("Raleway",Font.BOLD,18));
		add(emailt);
		JLabel dob=new JLabel("DOB:");
		dob.setBounds(100,320,200,30);
		dob.setFont(new Font("Raleway",Font.BOLD,18));
		add(dob);
		date=new JDateChooser();
		date.setBounds(300,320,250,25);
		add(date);
		JLabel marital=new JLabel("MARITAL STATUS:");
		marital.setBounds(100,360,200,30);
		marital.setFont(new Font("Raleway",Font.BOLD,18));
		add(marital);
		maried=new JRadioButton("maried");
		maried.setBounds(300,360,75,25);
		maried.setBackground(Color.white);
		add(maried);
		unmaried=new JRadioButton("unmaried");
		unmaried.setBounds(390,360,100,25);
		unmaried.setBackground(Color.white);
		add(unmaried);
		other=new JRadioButton("other");
		other.setBounds(500,360,75,25);
		other.setBackground(Color.white);
		add(other);
		ButtonGroup maritalgroup=new ButtonGroup();
		maritalgroup.add(maried);
		maritalgroup.add(unmaried);
		maritalgroup.add(other);
		JLabel address=new JLabel("ADDRESS");
		address.setBounds(100,400,100,30);
		address.setFont(new Font("Raleway",Font.BOLD,18));
		add(address);
		addresst=new JTextField();
		addresst.setBounds(300,400,250,25);
		addresst.setFont(new Font("Raleway",Font.BOLD,18));
		add(addresst);
		JLabel city = new JLabel("CITY:");
		city.setBounds(100,440,200,30);
		city.setFont(new Font("Raleway",Font.BOLD,18));
		add(city);
		cityt=new JTextField();
		cityt.setBounds(300,440,250,25);
		cityt.setFont(new Font("Raleway",Font.BOLD,18));
		add(cityt);
		
		JLabel state=new JLabel("STATE:");
		state.setBounds(100,480,100,30);
		state.setFont(new Font("Raleway",Font.BOLD,18));
		add(state);
		statet=new JTextField();
		statet.setBounds(300,480,250,25);
		statet.setFont(new Font("Raleway",Font.BOLD,18));
		add(statet);
		JLabel pin=new JLabel("PIN:");
		pin.setBounds(100,520,100,30);
		pin.setFont(new Font("Raleway",Font.BOLD,18));
		add(pin);
		pint=new JTextField();
		pint.setBounds(300,520,250,25);
		pint.setFont(new Font("Raleway",Font.BOLD,18));
		add(pint);
		next =new JButton("next");
		next.setBounds(350,590,100,30);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		add(next);
		next.addActionListener(this);
		getContentPane().setBackground(Color.WHITE);
		setSize(600,700);
		setLocation(300,00);
		setLayout(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) 
	{
		String form_no=""+random;
		String name=namet.getText();
		String father_name=fnamet.getText();
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="female";
		}
		String email=emailt.getText();
		String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
		String marital_status=null;
		if(maried.isSelected())
		{
			marital_status="maried";
		}
		else if(unmaried.isSelected())
		{
			marital_status="unmaried";
		}
		else if(other.isSelected())
		{
			marital_status="others";
		}
		String Address=addresst.getText();
		String city=cityt.getText();
		String state=statet.getText();
		String pin=pint.getText();
		try {
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "name is required");
			}
			else{
				
				Conn c=new  Conn();
				String querry=String.format("insert into personal_detail values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",form_no,name,father_name,gender,email,dob,marital_status,Address,city,state,pin);
				c.st.executeUpdate(querry);
				JOptionPane.showMessageDialog(null, "data sucessfully submited");
				setVisible(false);
				new AditionalD(form_no).setVisible(true);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
public static void main(String args[])
{
	new SignupOne();
}
}
