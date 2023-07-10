package BankSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
public class Deposit1 extends JFrame implements ActionListener{
	JTextField amount;
	JButton Deposit,Back;
	String pin2,card;
	public Deposit1(String pin2,String cardd)
	
	{
		this.card=cardd;
		this.pin2=pin2;
		//System.out.println(pin2);
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel screen=new JLabel(i2);
		screen.setBounds(0,0,900,900);
		add(screen);
		JLabel head= new JLabel("Enter the amount you wnat Deposit");
		head.setBounds(200,300,400,30);
		head.setFont(new Font("System",Font.BOLD,16));
		head.setForeground(Color.white);
		screen.add(head);
		amount=new JTextField();
		amount.setBounds(200,360,270,35);
		amount.setBackground(Color.black);
		amount.setForeground(Color.white);
		amount.setFont(new Font("System",Font.BOLD,16));
		screen.add(amount);
		
		Deposit=new JButton("Deposit");
		Deposit.setBounds(365,480,150,30);
		Deposit.setFont(new Font("System",Font.BOLD,16));
		screen.add(Deposit);
		Deposit.addActionListener(this);
		Back=new JButton("Back");
		Back.setBounds(365,515,150,30);
		Back.setFont(new Font("System",Font.BOLD,16));
		screen.add(Back);
		Back.addActionListener(this);
		setSize(900,900);
		setLocation(230,0);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}

	

	



	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Deposit)
		{
			String Amount=amount.getText();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime ldt = LocalDateTime.now();
			//LocalDateTime dtm = LocalDateTime.now();
			//12System.out.println("The date is: " + dtm.toLocalDate()); 
			String pin3=pin2;
			String card22=card;
			String money=amount.getText();
			Conn c=new Conn();
			try {
				if(money.equals(""))
				{
					JOptionPane.showMessageDialog(null, "plz enter amount");
				}else
				{
				String query=String.format("insert into bank values('%s','%s','%s','%s','%s')", pin3,dtf.format(ldt),"Deposite",money,card22);
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, money+" successfuly deposited");
				setVisible(false);
				new Transiction(pin3,card22).setVisible(true);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==Back)
		{
			setVisible(false);
			new Transiction(pin2,card).setVisible(true);
		}
	}
public static void main(String args[])
{
	new Deposit1("","");
}
}
