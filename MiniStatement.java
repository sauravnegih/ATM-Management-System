import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.*;
public class MiniStatement extends JFrame{

	String pinnumber;
	
	MiniStatement(String pinnumber)
	 {
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		setTitle("Mini Statement");
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400,200 );
		add(mini);
		
		JLabel bank  = new JLabel("Indan Bank");
		bank.setBounds(150,20, 100, 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		try {
			Conn conn = new Conn();
			
			ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: " +rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12));
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if(rs.getString("type").equals("withdrawl")) 
				{
					bal -= Integer.parseInt(rs.getString("amount"));
				
				}else
				{
					bal +=Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("your current account balance is Rs:" +bal);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MiniStatement("");

	}

}
