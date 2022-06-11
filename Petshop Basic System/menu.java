package bscs2b_group4;
import bscs2b_group4.OwnerReceiver;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class menu extends JFrame implements ActionListener{
	Container contentPane;
	JButton add, view, close;
	JLabel logo;
	//Icon addicon, viewicon, closeicon;
	
	public menu(){
		contentPane=getContentPane();
		/*addicon=new ImageIcon("add.jpg");
		viewicon=new ImageIcon("view.jpg");
		closeicon=new ImageIcon("close.jpg");*/
		add=new JButton("Add");
		add.setMnemonic(KeyEvent.VK_A);
		view=new JButton("View");
		view.setMnemonic(KeyEvent.VK_V);
		close=new JButton("Close");
		close.setMnemonic(KeyEvent.VK_C);
		ImageIcon img=new ImageIcon("petlogo.png");
		logo=new JLabel(img,JLabel.CENTER);
		logo.setBounds(120,50,500,430);
		
		logo.setVisible(true);
		add.setSize(100,50);
		add.setLocation(190,220);
		view.setSize(100,50);
		view.setLocation(290,220);
		close.setSize(100,50);
		close.setLocation(390,220);
	
		contentPane.setBackground(Color.ORANGE);
		contentPane.add(logo);
		contentPane.setLayout(null);
		contentPane.add(add);
		contentPane.add(view, BorderLayout.CENTER);
		contentPane.add(close, BorderLayout.SOUTH);
		
		add.addActionListener(this);
		view.addActionListener(this);
		close.addActionListener(this);

		setTitle("MenuPage");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,400);
		setLocation(335,200);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==add) {
			Owner OwnerObject=new Owner();
			OwnerObject.setVisible(true);
			this.dispose();
		}
		else if(event.getSource()==view) {
			ViewRecord vr=new ViewRecord();
			vr.setVisible(true);
			this.dispose();
		}
		else if(event.getSource()==close){
			//JOptionPane.showMessageDialog(this, "");
			System.exit(1);
		}
	}
	
	public static void main(String args[]){
		menu MenuObject=new menu();
	}
} 