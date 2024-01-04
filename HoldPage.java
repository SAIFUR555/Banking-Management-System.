i
	int time=9,x,y;
	HoldPage(int x, int y)
	{
		/*********************** Same Everywhere**********************/
		Color backgroundComport javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.Timer;
public class HoldPage extends JFrame{
	private Container c;
	private ImageIcon icon;
	private JLabel usernameLabel, passwordLabel, errorLabel;
	private JButton loginButton, cancelButton;
lor = new Color(133,172,233);
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

		//label



		usernameLabel = new JLabel("USERNAME:");
		usernameLabel.setFont(new Font("Ariel",Font.BOLD,25));
		usernameLabel.setForeground(new Color(96,96,96));
		usernameLabel.setBounds(250,350,400,50);
		c.add(usernameLabel);
		//textFiled
		JPanel usernameText = new JPanel();
		usernameText.setBackground(new Color(224,224,224));
		usernameText.setBounds(250, 410, 500,50);
		c.add(usernameText);


		//Label
		passwordLabel = new JLabel("PASSWORD:");
		passwordLabel.setForeground(new Color(96,96,96));
		passwordLabel.setFont(new Font("Ariel",Font.BOLD,25));
		passwordLabel.setBounds(250,480,400,50);
		c.add(passwordLabel);
		//TextField
		JPanel passText = new JPanel();
		passText.setBackground(new Color(224,224,224));
		passText.setBounds(250,540,500,50);
		c.add(passText);

		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(null);
		errorPanel.setBounds(250, 610, 500,75);
		errorPanel.setBackground(new Color(255,153,153));
		c.add(errorPanel);

	 	errorLabel = new JLabel("Wait [ "+time--+" ] second");
	 	errorLabel.setFont(new Font("Ariel",Font.BOLD,25));
		errorLabel.setBounds(125, 0, 500,75);
		errorPanel.add(errorLabel);

		
		//Button

		JButton zero = new JButton(); zero.setBounds(0,0,0,0); c.add(zero);

		loginButton = new JButton("LOGIN");
		loginButton.setFont(new Font("Didot",Font.BOLD,25));
		loginButton.setBackground(new Color(153,204,255));
		loginButton.setForeground(new Color(224,224,224));
		loginButton.setBounds(250, 700, 200,70);
		c.add(loginButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Didot",Font.BOLD,25));
		cancelButton.setBackground(new Color(255,153,153));
		cancelButton.setForeground(new Color(224,224,224));
		cancelButton.setBounds(550, 700, 200, 70);
		c.add(cancelButton);
		
		//("No attempt left. Retry waiting time: [ "+time+" ] second");

	     Timer timer = new Timer(1000, new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            errorLabel.setText("Wait [ "+time--+" ] second");
                if(time==0)
                {

                	Point point = getLocation();
					int x = (int)point.getX();  int y = (int)point.getY();
					LoginPage login = new LoginPage(x,y);
					login.setVisible(true);
		            dispose();
                }
                
            }
        });

	     if(time>=0)timer.start();
		 else timer.stop();		
	}
}

