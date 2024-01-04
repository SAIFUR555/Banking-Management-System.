import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class LoginPage extends JFrame{
	private final Container c;
	private final ImageIcon icon;
    private final JLabel usernameLabel;
	private final JLabel passwordLabel;
	private JLabel errorLabel;
	private JTextField usernameText;
	private JPasswordField passText;
	private final JButton loginButton;
	private final JButton cancelButton;
	private   int count = 0;
	LoginPage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundColor = new Color(133,172,233);
		Font labelFont, errorFont;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("User Login");
		this.setBounds(x,y, 1000,1000);
		this.setResizable(false);
		this.c = this.getContentPane();
		this.c.setLayout(null);
		this.c.setBackground(backgroundColor);  
		this.icon = new ImageIcon(getClass().getResource("images/icon.png"));
		this.setIconImage(icon.getImage());
		/**************************************************/

		ImageIcon bankImg = new ImageIcon(getClass().getResource("images/bank.png"));
		JLabel bankIcon = new JLabel(bankImg);
		bankIcon.setBounds(175,125,150,150);
		c.add(bankIcon);

		JLabel welcome = new JLabel("USER LOGIN");
		welcome.setForeground(Color.BLACK);
		welcome.setFont(new Font("Didot",Font.BOLD,65));
		welcome.setBounds(325, 135, 600,150);
		c.add(welcome);

		//label
		usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Ariel",Font.BOLD,25));
		usernameLabel.setBounds(250,350,400,50);
		c.add(usernameLabel);
		//textFiled
		usernameText = new JTextField();
		usernameText.setFont(new Font("Gotham",Font.PLAIN,20));
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		usernameText.setBounds(250, 410, 500,50);
		c.add(usernameText);


		//Label
		passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setFont(new Font("Ariel",Font.BOLD,25));
		passwordLabel.setBounds(250,480,400,50);
		c.add(passwordLabel);
		
		//TextField
		passText = new JPasswordField();
		passText.setFont(new Font("Gotham",Font.PLAIN,20));
		passText.setHorizontalAlignment(JTextField.CENTER);
		passText.setBounds(250,540,500,50);
		c.add(passText);


	 	errorLabel = new JLabel("");
	 	errorLabel.setFont(new Font("Ariel", Font.ITALIC+Font.BOLD,15));
	 	errorLabel.setForeground(new Color(204,0,0));
		errorLabel.setBounds(325, 600, 350,50);
		c.add(errorLabel);
		
		//Button
		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Didot",Font.BOLD,25));
		loginButton.setBackground(new Color(10,93,201));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBounds(250, 700, 200,70);
		c.add(loginButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Didot",Font.BOLD,25));
		cancelButton.setBackground(new Color(204,0,0));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(550, 700, 200, 70);
		c.add(cancelButton);

		loginButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				if(count==4)
				{
					Point point = getLocation();
					int x = (int)point.getX(); int y = (int)point.getY();
					HoldPage hold = new HoldPage(x,y);
					hold.setVisible(true);
					dispose();	
				}
				
				Username username = new Username(usernameText.getText());
				if(username.exists())
				{
					String password = String.valueOf(passText.getPassword());
					User user;
					try{
						ObjectInputStream file = new ObjectInputStream(new FileInputStream("users/"+username.get()+".dat"));
						user = (User)file.readObject();
						if(password.equals(user.getPassword()))
						{
							Point point = getLocation();
							int x = (int)point.getX(); int y = (int)point.getY();
							UserPage userpage = new UserPage(user,x,y);
							userpage.setVisible(true);
							dispose();
						}
						else{
							errorLabel.setText("Username or password not matched");
							count++;
						}
						
					}
					catch(IOException | ClassNotFoundException ex)
					{
						System.out.println("An error occured");
						System.out.println(ex.toString());
					}
				}
				else
				{
					errorLabel.setText("Username or password not matched"); // IF Username not exist;
					count++;
				}
				
		
				
				
			}
		});

		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				Point point = getLocation();
				int x = (int)point.getX(); int y = (int)point.getY();
				MainPage main = new MainPage(x,y);
				main.setVisible(true);
				dispose();


			}
		});
		
	}
}
