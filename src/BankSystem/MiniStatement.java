package BankSystem;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MiniStatement extends JFrame{
	String pinm,cardm,x="";
	public MiniStatement(String pin, String card) {
		this.pinm=pin;
		this.cardm=card;
		
		JLabel mini=new JLabel();
		JLabel Card=new JLabel();
		Card.setBounds(20,80,300,20);
		mini.setBounds(20,140,400,200);
		add(mini);
		add(Card);
		Conn c=new Conn();
		try {
			String query=String.format("select * from Card_detail where(Card_number='%s' and PIN_number='%s')",cardm,pinm);
			ResultSet rs=c.st.executeQuery(query);
		while(rs.next()) {
			Card.setText("Card Number :"+rs.getString("Card_number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_number").substring(12)
					);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int bal=0;
		
		try {
			Conn c1=new Conn();
String Query1=String.format("select * from bank where (Pin='%s'and card_detail='%s')",pinm,cardm);
		
		ResultSet rs=c1.st.executeQuery(Query1);
		while(rs.next())
		{
		 x = x+	rs.getString("date")+"     "+rs.getString("TransactionType")+"     "+rs.getString("Amount")+"\n";
		 
		//mini.setText("<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("TransactionType")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"</html>");	
		}
		mini.setText(x);
		//System.out.println(x);
	}catch(Exception e) 
		{
		e.printStackTrace();
	}
		
		setSize(400,600);
		setLocation(20,20);
		setTitle("MiniStatement");
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setUndecorated(true);
		setVisible(true);
		}
		
	public static void main(String args[]) {
		new MiniStatement("","");
		
	}
	

}
