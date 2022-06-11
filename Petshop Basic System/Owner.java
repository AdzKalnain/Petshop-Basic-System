package bscs2b_group4;
import bscs2b_group4.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Owner extends JFrame implements ActionListener{
    Container contentPane;
    JLabel namelbl, addresslbl, cnlbl; //cn contact no.
    JTextField nametf, addresstf, cntf;
    JButton savebtn, viewbtn, nextbtn, cancelbtn;
    //JButton addbtn;
    String ownername, address, contactno;
    ArrayList<OwnerReceiver>o_list;
    OwnerReceiver n;
    public Owner() {
        o_list=(ArrayList<OwnerReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        contentPane=getContentPane();
        namelbl=new JLabel("OwnerName:");
        addresslbl=new JLabel("Address:");
        cnlbl=new JLabel("ContactNo.");
        nametf=new JTextField(30);
        addresstf=new JTextField(30);
        cntf=new JTextField(30);
        //addbtn=new JButton("Add");
        savebtn=new JButton("Save");
        viewbtn=new JButton("View");
        nextbtn=new JButton("Next");
        cancelbtn=new JButton("Cancel");
        
        namelbl.setBounds(100,90,100,30);
        nametf.setBounds(210,90,300,30);
        addresslbl.setBounds(100,130,100,30);
        addresstf.setBounds(210,130,300,30);
        cnlbl.setBounds(100,170,170,30);
        cntf.setBounds(210,170,300,30);
        //addbtn.setBounds(430,90,100,30);
        savebtn.setBounds(210,320,100,30);
        viewbtn.setBounds(320,320,100,30);
        nextbtn.setBounds(430,320,100,30);
        cancelbtn.setBounds(540,320,100,30);
        //setLayout(new FlowLayout());
        setLayout(null);
        contentPane.setBackground(Color.ORANGE);
        contentPane.add(namelbl);
        contentPane.add(nametf);
        contentPane.add(addresslbl);
        contentPane.add(addresstf);
        contentPane.add(cnlbl);
        contentPane.add(cntf);
        //contentPane.add(addbtn);
        contentPane.add(savebtn);
        contentPane.add(viewbtn);
        contentPane.add(nextbtn);
        contentPane.add(cancelbtn);
        
        //addbtn.addActionListener(this);
        savebtn.addActionListener(this);
        viewbtn.addActionListener(this);
        nextbtn.addActionListener(this);
        cancelbtn.addActionListener(this);
        
        setTitle("Owner Info");
        setVisible(true);
        setLocation(300,200);
        setSize(700,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    public void actionPerformed(ActionEvent event) {
        ownername=nametf.getText();
        address=addresstf.getText();
        contactno=cntf.getText();
        /*if(event.getSource()==addbtn){
            n=new OwnerReceiver(ownername);
            n.setAddress(address);              
            n.setContactNo(contactno);
            o_list.add(n);
            
            n=new OwnerReceiver(ownername);
			n.setAddress(address);				
			n.setContactNo(contactno);
			o_list.add(n);
			JOptionPane.showMessageDialog(null, "Added Completed");
        }*/
        if(event.getSource()==savebtn) {
            n=new OwnerReceiver(ownername);
            n.setAddress(address);				
            n.setContactNo(contactno);
            o_list.add(n);
			
            TransactionDataManagement.createObjectFile(o_list,"record.dat");
            JOptionPane.showMessageDialog(this,"Owner Info has been saved to file.");
        }
        else if(event.getSource()==viewbtn) {
            Iterator itr =o_list.iterator();
            while(itr.hasNext())
                System.out.println("\n"+itr.next());    
        }
        else if(event.getSource()==nextbtn) {
            Pet PetObject=new Pet();
            PetObject.setVisible(true);
            this.dispose();
        }
        else if(event.getSource()==cancelbtn) {
            menu MenuObject=new menu();
            MenuObject.setVisible(true);
            this.dispose();
        }
    }
    
    public static void main(String args[]) {
        Owner OwnerObject=new Owner();
    }
}