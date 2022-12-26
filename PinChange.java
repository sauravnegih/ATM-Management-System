import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

	JPasswordField pin,repin;
	JButton back,change;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT)	;
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,15);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		 pin = new JPasswordField();
		pin.setFont(new Font ("Raleway",Font.BOLD,16));
		pin.setBounds(330, 320, 180, 25);
		image.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setForeground(Color.white);
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		
		 repin = new JPasswordField();
		repin.setFont(new Font ("Raleway",Font.BOLD,16));
		repin.setBounds(330, 360, 180, 25);
		image.add(repin);
		
		 change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		 back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) 
		{
			try 
			{
				String npin= pin.getText();
				String rpin = repin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered Pin does not Correct");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter the pin");
					return;
				}
				Conn conn = new Conn();
				String query1="update bank set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
				String query2="update login set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
				String query3="update signupthree set pin_number = '"+rpin+"' where pin_number ='"+pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin changed successfully");
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
			else {
				setVisible(false);
				Transactions transaction = new Transactions(pinnumber);
				
			}
	}
	
	public static void main(String[] args) {
		new PinChange("");

	}

}
