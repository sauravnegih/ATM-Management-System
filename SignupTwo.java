
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo implements ActionListener{

	JFrame frame = new JFrame();
	long random;
	JTextField pantext,aadhartext;
	JButton next;
	JRadioButton eyes,eno,sno,syes;
	JComboBox religionbox,categorybox,occupationbox,educationbox,incomebox;
	String formno;
	SignupTwo(String formno)
	{
		this.formno=formno;
		frame.setLayout(null);
		frame.setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionaldetails = new JLabel("Page 2:Additional Details");
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,28));
		additionaldetails.setBounds(280,80,600,40);
		frame.add(additionaldetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,18));
		religion.setBounds(100,140,600,40);
		frame.add( religion);
		
		String religioncategory[]={"","Hindu","Muslim","Sikh","Christian","Other"};
		 religionbox = new JComboBox(religioncategory);
		religionbox.setBounds(300, 140, 400, 30);
		religionbox.setBackground(Color.white);
		frame.add(religionbox);
		
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,18));
		category.setBounds(100,190,600,40);
		frame.add(category);
		
		String valcategory[] = {"","General","OBC","SC","ST"};
		 categorybox = new JComboBox(valcategory);
		categorybox.setBounds(300, 190, 400, 30);
		frame.add(categorybox);
		
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,18));
		income.setBounds(100,240,600,40);
		frame.add(income);
		
		String incomecategory[]= {"","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
		 incomebox = new JComboBox(incomecategory);
		incomebox.setBounds(300, 240, 400, 30);
		frame.add(incomebox);
		
		
		JLabel education= new JLabel("Educational:");
		education.setFont(new Font("Raleway",Font.BOLD,18));
		education.setBounds(100,290,600,40);
		frame.add(education);
		String educationcategory[]= {"","10th","12th","Graduation","Post Graduation","phd"};
		 educationbox = new JComboBox(educationcategory);
		educationbox.setBounds(300, 290, 400, 30);
		frame.add(educationbox);
	
		
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,18));
		occupation.setBounds(100,330,600,40);
		frame.add(occupation);
		String occupationcategory[]= {"","Salaried","Self Employedd","Bussinessman","Student","Retiered","Others"};
		 occupationbox = new JComboBox(occupationcategory);
		occupationbox.setBounds(300, 330, 400, 30);
		frame.add(occupationbox);

		
		
		JLabel pan = new JLabel("PAN no:");
		pan.setFont(new Font("Raleway",Font.BOLD,18));
		pan.setBounds(100,370,600,40);
		frame.add(pan);
	
		pantext = new JTextField();
		pantext.setFont(new Font("Raleway",Font.BOLD,14));
		pantext.setBounds(300, 370, 400, 30);
		frame.add(pantext);
			
		JLabel aadhar = new JLabel("Aadhar No:");
		aadhar.setFont(new Font("Raleway",Font.BOLD,18));
		aadhar.setBounds(100,410,600,40);
		frame.add(aadhar);
		
		aadhartext = new JTextField();
		aadhartext.setFont(new Font("Raleway",Font.BOLD,14));
		aadhartext.setBounds(300, 410, 400, 30);
		frame.add(aadhartext);
		
		
		JLabel senior= new JLabel("Senior Citizen:");
		senior.setFont(new Font("Raleway",Font.BOLD,18));
		senior.setBounds(100,450,600,40);
		frame.add(senior);
		 
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 450, 60, 30);
		syes.setBackground(Color.white);
		frame.add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(400, 450, 140, 30);
		sno.setBackground(Color.white);
		frame.add(sno);
		
		ButtonGroup seniorgroup = new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
			
		
		
		
		JLabel existing = new JLabel("Existing Account:");
		existing.setFont(new Font("Raleway",Font.BOLD,18));
		existing.setBounds(100,490,600,40);
		frame.add(existing);
		 
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 490, 60, 30);
		eyes.setBackground(Color.white);
		frame.add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(400, 490, 140, 30);
		eno.setBackground(Color.white);
		frame.add(eno);
		
		ButtonGroup existinggroup = new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JButton next = new JButton("Next");
		next.setBounds(620,560,80,30);
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.addActionListener(this);
		frame.add(next);
		
		
		
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(850, 800);
		frame.setLocation(350, 10);
		frame.setVisible(true);
	}
		
		
		public void actionPerformed(ActionEvent ae) 
		{
			//String formno = "" +random;//random is integer here
			String religion = (String) religionbox.getSelectedItem();
			String category = (String) categorybox.getSelectedItem();
			String income=(String) incomebox.getSelectedItem();
			String education = (String) educationbox.getSelectedItem();
			String senior = null;
			if(syes.isSelected()) {
				senior="Yes";
			}else if(sno.isSelected()) {
				senior="No";
			}
			
			String existing=null;
			
			if(eyes.isSelected()) {
				existing="Yes";
			}else if (eno.isSelected()) {
				existing="No";
			}
			
			String pan =pantext.getText();
			String aadhar =aadhartext.getText();
			
			
			
			try {
				
					Conn c = new Conn();
					String query="insert into signuptwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+pan+"','"+aadhar+"','"+senior+"','"+existing+"')";
					c.s.executeUpdate(query);
				
		
					frame.setVisible(false);
					SignupThree signupthree = new SignupThree(formno);
					signupthree.setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	
	public static void main(String[] args)
	{
	new SignupTwo("");	

	}
}