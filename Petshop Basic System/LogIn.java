package bscs2b_group4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements ActionListener{
	JButton loginbtn;
	JLabel usernamelbl, passwordlbl;
	JTextField usernametf;
	JPasswordField passwordpf;
	//Icon loginicon;
	Container contentPane;
	String username, password;	
	public LogIn(){
		contentPane=getContentPane();
		//loginicon= new ImageIcon("loginicon.png");
		loginbtn=new JButton("LogIn");
		loginbtn.setMnemonic(KeyEvent.VK_ENTER);
		usernamelbl=new JLabel("Username:");
		passwordlbl=new JLabel("Password:");
		usernametf=new JTextField(30);
		passwordpf=new JPasswordField(30);
		setLayout(new FlowLayout());
			
		contentPane.add(usernamelbl);
		contentPane.add(usernametf);
		contentPane.add(passwordlbl);
		contentPane.add(passwordpf);
		contentPane.add(loginbtn);
		
		contentPane.setBackground(Color.ORANGE);
		setTitle("Title Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(500,200);
		setSize(400,180);
		
		loginbtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		username=usernametf.getText();
		password=passwordpf.getText();
			if(username.contentEquals("adz") && password.equals("kalnain")) {
				menu nextmenu=new menu();
				nextmenu.setVisible(true);
				this.dispose();
				JOptionPane.showMessageDialog(this, "Login Success");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Input");
				System.exit(1);
			}
	}
	public static void main(String args[]){
		LogIn LogInObject=new LogIn();
	}
}
