package BankSystem;

import java.awt.Color;
import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;


public class Fastcash extends JFrame implements ActionListener {
	JButton o1,o2,o3,o4,o5,o6,Exit,Menue;
	String pin8,card;
	public Fastcash(String pin8,String cardf)
	{
		this.pin8=pin8;
		this.card=cardf;
		//System.out.println(pin);
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel screen =new JLabel(i2);
		screen.setBounds(0,0,900,900);
		add(screen);
		JLabel head=new JLabel("Please select your Transaction");
		head.setBounds(230,300,400,30);
		head.setFont(new Font("Raleway",Font.BOLD,16));
		head.setForeground(Color.white);
		screen.add(head);
		o1 =new JButton("Rs.1000");
		o1.setBounds(175,400,150,30);
		o1.setFont(new Font("Raleway",Font.BOLD,17));
		screen.add(o1);
		o1.addActionListener(this);
		o2 =new JButton("Rs.2000");
		o2.setBounds(175,440,150,30);
		o2.setFont(new Font("Raleway",Font.BOLD,17));
		screen.add(o2);
		o2.addActionListener(this);
		
		o3 =new JButton("Rs.4000");
		o3.setBounds(175,480,150,30);
		o3.setFont(new Font("Raleway",Font.BOLD,17));
		o3.addActionListener(this);
		screen.add(o3);
		o4 =new JButton("Rs.5000");
		o4.setBounds(355,400,150,30);
		o4.setFont(new Font("Raleway",Font.BOLD,17));
		o4.addActionListener(this);
		screen.add(o4);
		o5 =new JButton("Rs.8000");
		o5.setBounds(355,440,150,30);
		o5.setFont(new Font("Raleway",Font.BOLD,17));
		o5.addActionListener(this);
		screen.add(o5);
		o6 =new JButton("Rs.10000");
		o6.setBounds(355,480,150,30);
		o6.setFont(new Font("Raleway",Font.BOLD,17));
		o6.addActionListener(this);
		screen.add(o6);
		Exit =new JButton("Exit");
		Exit.setBounds(175,515,150,30);
		Exit.setFont(new Font("Raleway",Font.BOLD,17));
		Exit.addActionListener(this);
		screen.add(Exit);
		 Menue=new JButton("Main Menue");
		 Menue.setBounds(355,515,150,30);
		 Menue.setFont(new Font("Raleway",Font.BOLD,17));
		 Menue.addActionListener(this);
		screen.add(Menue);
		
		setSize(900,900);
		setLocation(230,0);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String money="";
		String pinf=pin8;
		String card44=card;
		if(ae.getSource()==o1)
		{
			 money="1000";
		}
		else if(ae.getSource()==o2)
		{
			 money="2000";
		}
		else if(ae.getSource()==o3)
		{
			money="4000";
		}
		else if(ae.getSource()==o4)
		{
			money="5000";
		}
		else if(ae.getSource()==o5)
		{
			money="8000";
		}
		else if(ae.getSource()==o6)
		{
			money="10000";
		}
		else if(ae.getSource()==Exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==Menue)
		{
			setVisible(false);
			new Transiction(pinf,card44).setVisible(true);
		}
		
		try {
			Conn c=new Conn();
			LocalDateTime dtm = LocalDateTime.now();
			String amount=money;
			
			int balance=0;
			String Query1=String.format("select * from bank where (Pin='%s'and card_detail='%s')",pinf,card44);
			
			ResultSet rs=c.st.executeQuery(Query1);
			while(rs.next())
			{
				if(rs.getString("TransactionType").equals("Deposite"))
				{
				balance+=Integer.parseInt(rs.getString("Amount"));
				}
				else {
					balance-=Integer.parseInt(rs.getString("Amount"));
				}
			}
			if(balance<Integer.parseInt(amount))
			{
				JOptionPane.showMessageDialog(null,"! insufficient balance");
			}
			else {
				String query=String.format("Insert into bank values('%s','%s','%s','%s','%s')", pinf,dtm.toLocalDate(),"Withdraw",amount,card44);
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs."+amount+"Successfuly Withdraw");
				setVisible(false);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String args[])
	{
		new Fastcash("","");
	}

}
