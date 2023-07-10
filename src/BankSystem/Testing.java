package BankSystem;


import java.util.Random;

public class Testing {
	String card;
	String pin;
	Random ran,ran1;
	public Testing()
	{
		Random ran=new Random();
		int num=Math.abs(1+ran.nextInt(2)*1000)+ran.nextInt(9999);
		pin=String.valueOf(num);
		//System.out.println(pin);
		 ran1=new Random();
		long num1=Math.abs(1+ran.nextInt(2)*10000000)+ran.nextLong(99999999);
		card="70802268"+String.valueOf(num1);
		//System.out.println(card);
	}
	public static void main(String args[])
	{
		new Testing();
		}

}

