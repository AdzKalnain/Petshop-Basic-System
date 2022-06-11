package bscs2b_group4;

import bscs2b_group4.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewRecord extends JFrame implements ActionListener {
    Container contentPane;
    JTextArea recordta;
    JLabel recordlb;
    JButton closebtn;
    
    
    public ViewRecord() {
        contentPane=getContentPane();
        recordta=new JTextArea();
        recordlb=new JLabel("Record:");
        closebtn=new JButton("Close");
        
        recordlb.setBounds(20,10,100,30);
        recordta.setBounds(20,40,645,270);
        closebtn.setBounds(540,320,100,30);
        
        ArrayList<PetReciever> pr_list=(ArrayList<PetReciever>)TransactionDataManagement.readObjectFile("record.dat");
        //ArrayList<OwnerReceiver> or_list=(ArrayList<OwnerReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        //ArrayList<VetReceiver>vr_list=(ArrayList<VetReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        //ArrayList<ServiceReceiver>sr_list=(ArrayList<ServiceReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        
        //recordta.setText("\n"+or_list+"\t"+pr_list+"\n"+vr_list+"\n"+sr_list);
        recordta.setText(pr_list+"\n");
        System.out.println("Record List: \n"+pr_list);
        contentPane.setBackground(Color.ORANGE);
        contentPane.add(recordlb);
        contentPane.add(recordta);
        contentPane.add(closebtn);
        
        closebtn.addActionListener(this);
    
        setLayout(null);
        setTitle("Record");
        setSize(700,400);
        setLocation(335,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==closebtn) {
            menu menuobject=new menu();
            menuobject.setVisible(true);
            this.dispose();
        }
    }
    
    public static void main(String args[]) {
        ViewRecord vr=new ViewRecord();
    }
}
