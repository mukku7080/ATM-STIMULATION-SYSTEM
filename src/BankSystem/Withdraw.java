package BankSystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener{
	JTextField amount;
	JButton withdraw,Exit;
	String pin3,card;
	public Withdraw(String pin3,String cardw)
	
	{
		
		this.pin3=pin3;
		this.card=cardw;
		//System.out.println(pin2);
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i1=i.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1);
		JLabel screen=new JLabel(i2);
		screen.setBounds(0,0,900,900);
		add(screen);
		JLabel head= new JLabel("Enter the amount you wnat to withdraw");
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
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(365,480,150,30);
		withdraw.setFont(new Font("System",Font.BOLD,16));
		screen.add(withdraw);
		withdraw.addActionListener(this);
		Exit=new JButton("Exit");
		Exit.setBounds(365,515,150,30);
		Exit.setFont(new Font("System",Font.BOLD,16));
		screen.add(Exit);
		Exit.addActionListener(this);
		setSize(900,900);
		setLocation(230,0);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String money=amount.getText();
		if(ae.getSource()==withdraw)
		{
			//String Amount=amount.getText();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime ldt = LocalDateTime.now();
			//LocalDateTime dtm = LocalDateTime.now();
			//12System.out.println("The date is: " + dtm.toLocalDate()); 
			String pin4=pin3;
			String card33=card;
			//String money=amount.getText();
			Conn c=new Conn();
			try {
				if(money.equals(""))
				{
					JOptionPane.showMessageDialog(null, "plz enter amount");
				}else
				{
					int balance=0;
					String Query1=String.format("select * from bank where (Pin='%s')",pin4);
					System.out.println(pin4);
					
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
					if(balance<Integer.parseInt(money))
					{
						JOptionPane.showMessageDialog(null,"! insufficient balance");
					}
					else {
					
				String query=String.format("insert into bank values('%s','%s','%s','%s','%s')", pin4,dtf.format(ldt),"Withdrawl",money,card33);
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs."+money+" successfuly withdrawl");
				setVisible(false);
				new Transiction(pin4,card33).setVisible(true);
					}
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==Exit)
		{
			System.exit(0);
			
		}
	}
public static void main(String args[])
{
	new Withdraw("","");
}
}
