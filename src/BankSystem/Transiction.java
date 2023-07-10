package BankSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Transiction extends JFrame implements ActionListener{
	JButton Deposite,FastCash,PinChange,CashWithdraw,MiniStatement,BalanceEnquiry,Exit;
	String pin,card;
	public Transiction(String pin,String cardt)
	{
		this.pin=pin;
		this.card=cardt;
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
		Deposite =new JButton("Deposit");
		Deposite.setBounds(175,418,150,30);
		Deposite.setFont(new Font("Raleway",Font.BOLD,17));
		screen.add(Deposite);
		Deposite.addActionListener(this);
		FastCash =new JButton("Fast Cash");
		FastCash.setBounds(175,455,150,30);
		FastCash.setFont(new Font("Raleway",Font.BOLD,17));
		FastCash.addActionListener(this);
		screen.add(FastCash);
		
		PinChange =new JButton("Pin Change");
		PinChange.setBounds(175,492,150,30);
		PinChange.setFont(new Font("Raleway",Font.BOLD,17));
		PinChange.addActionListener(this);
		screen.add(PinChange);
		CashWithdraw =new JButton("CashWithdraw");
		CashWithdraw.setBounds(355,418,150,30);
		CashWithdraw.setFont(new Font("Raleway",Font.BOLD,17));
		CashWithdraw.addActionListener(this);
		screen.add(CashWithdraw);
		MiniStatement =new JButton("E-Statement");
		MiniStatement.setBounds(355,455,150,30);
		MiniStatement.setFont(new Font("Raleway",Font.BOLD,17));
		MiniStatement.addActionListener(this);
		screen.add(MiniStatement);
		BalanceEnquiry =new JButton("BlcEnquiry");
		BalanceEnquiry.setBounds(355,492,150,30);
		BalanceEnquiry.setFont(new Font("Raleway",Font.BOLD,17));
		BalanceEnquiry.addActionListener(this);
		screen.add(BalanceEnquiry);
		Exit =new JButton("Exit");
		Exit.setBounds(265,529,150,20);
		Exit.setFont(new Font("Raleway",Font.BOLD,17));
		Exit.addActionListener(this);
		screen.add(Exit);
		
		setSize(900,900);
		setLocation(230,0);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		String pin2=pin;
		String card2=card;
		if(ae.getSource()==Exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==Deposite)
		{
			//String pin2=pin;
			setVisible(false);
			new Deposit1(pin2,card2).setVisible(true);
		}
		else if(ae.getSource()==CashWithdraw)
		{
			//String pin3=pin;
			setVisible(false);
			new Withdraw(pin2,card2).setVisible(true);
		}
		else if(ae.getSource()==FastCash)
		{
			//String pin7=pin;
			setVisible(false);
			new Fastcash(pin2,card2).setVisible(true);
		}
		else if(ae.getSource()==PinChange)
		{
			setVisible(false);
			new PinChange(pin2,card2).setVisible(true);
		}
		else if(ae.getSource()==BalanceEnquiry) {
			int balance=0;
			Conn c=new Conn();
			try {
String Query1=String.format("select * from bank where (Pin='%s'and card_detail='%s')",pin2,card2);
			
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
		}catch(Exception e) 
			{
			e.printStackTrace();
		}
			setVisible(false);
			new BalanceOne(pin2,card2).setVisible(true);
		}
		if(ae.getSource()==MiniStatement) {
			setVisible(false);
			new MiniStatement(pin2,card2).setVisible(true);;
		}
		
		
	}
	public static void main(String args[])
	{
		new Transiction("","");
	}

}
