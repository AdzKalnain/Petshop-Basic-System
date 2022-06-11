package bscs2b_group4;

import bscs2b_group4.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Transaction extends JFrame implements ActionListener{
    Container contentPane;
    JLabel vetnamelb, vetcontactnolb, vetidlb, recordlb;
    JCheckBox groomingcb, vaccinationcb, consultationcb;
    JTextField vetnametf, vetcontactnotf, vetidtf, recordtf;
    JTextArea recordta;
    JButton addbtn;
    JButton savebtn, viewbtn, finishbtn;
    GregorianCalendar date;
    String vetname, vetid, vetcontact, services;
    final int g=300, v=250, c=100;
    int fee=0;
    int day, month, year;
    ArrayList<VetReceiver>v_list;
    ArrayList<ServiceReceiver>sr_list;
    ServiceReceiver sr;
    VetReceiver vr;
    public Transaction() {
        v_list=(ArrayList<VetReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        sr_list=(ArrayList<ServiceReceiver>)TransactionDataManagement.readObjectFile("record.dat");
        contentPane=getContentPane();
        date=new GregorianCalendar();
        vetnamelb=new JLabel("VetName:");   //Labels
        vetcontactnolb=new JLabel("ContactNo:");
        vetidlb=new JLabel("Vet Id:");
        recordlb=new JLabel("Record:");
        groomingcb=new JCheckBox("Grooming");   //CheckBox
        vaccinationcb=new JCheckBox("Vaccination");
        consultationcb=new JCheckBox("Consultation");
        vetnametf=new JTextField(30);   //TextFields
        vetcontactnotf=new JTextField(30);
        vetidtf=new JTextField(30);
        recordta=new JTextArea();
        //addbtn=new JButton("ADD");
        savebtn=new JButton("SAVE");
        viewbtn=new JButton("VIEW");
        finishbtn=new JButton("FINISH");
        
        contentPane.setBackground(Color.ORANGE);
        contentPane.add(groomingcb);
        groomingcb.setBounds(20,10,100,20);
        
        contentPane.add(vaccinationcb);
        vaccinationcb.setBounds(20,35,100,20);
        
        contentPane.add(consultationcb);
        consultationcb.setBounds(20,60,100,20);
        
        contentPane.add(vetnamelb);
        vetnamelb.setBounds(200,5,100,30);
        
        contentPane.add(vetnametf);
        vetnametf.setBounds(300,5,300,30);
        
        contentPane.add(vetcontactnolb);
        vetcontactnolb.setBounds(200,35,100,30);
        
        contentPane.add(vetcontactnotf);
        vetcontactnotf.setBounds(300,35,300,30);
        
        contentPane.add(vetidlb);
        vetidlb.setBounds(200,65,100,30);
        
        contentPane.add(vetidtf);
        vetidtf.setBounds(300,65,300,30);
        
        contentPane.add(recordlb);
        recordlb.setBounds(20,90,100,30);
        
        contentPane.add(recordta);
        recordta.setBounds(20,120,645,170);
        
        contentPane.add(addbtn);    
        //addbtn.setBounds(300,300,80,30);
        contentPane.add(savebtn);
        savebtn.setBounds(385,300,80,30);
        contentPane.add(viewbtn);
        viewbtn.setBounds(470,300,80,30);
        contentPane.add(finishbtn);
        finishbtn.setBounds(555,300,80,30);
        
        //addbtn.addActionListener(this);
        savebtn.addActionListener(this);
        viewbtn.addActionListener(this);
        finishbtn.addActionListener(this);
        
        setLayout(null);
        setTitle("Transaction");
        setLocation(300,200);
        setSize(700,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent event) {
        vetname=vetnametf.getText();
        vetid=vetidtf.getText();
        vetcontact=vetcontactnotf.getText();
        day=date.get(Calendar.DAY_OF_MONTH);
        month=date.get(Calendar.MONTH);
        year=date.get(Calendar.YEAR);
        /*if(event.getSource()==addbtn) {
            if(groomingcb.isSelected()) {
                services=services+groomingcb.getText()+",";
                fee=fee+g;
            }
            if(vaccinationcb.isSelected()) {
                services=services+vaccinationcb.getText()+",";
                fee=fee+v;
            }
            if(consultationcb.isSelected()) {
                services=services+consultationcb.getText();
                fee=fee+c;
            }
            
            sr=new ServiceReceiver(services);
            sr.setTotalFee(Integer.toString(fee));
            sr.setDay(Integer.toString(day));
            sr.setMonth(Integer.toString(month));
            sr.setYear(Integer.toString(year));
            vr=new VetReceiver(vetname);
            vr.setVetId(vetid);
            vr.setVetContact(vetcontact);
            v_list.add(vr);
            sr_list.add(sr);
            JOptionPane.showMessageDialog(this, "Transaction Info has been added");
        }*/
        if(event.getSource()==savebtn) {
            if(groomingcb.isSelected()) {
                services=services+groomingcb.getText()+",";
                fee=fee+g;
            }
            if(vaccinationcb.isSelected()) {
                services=services+vaccinationcb.getText()+",";
                fee=fee+v;
            }
            if(consultationcb.isSelected()) {
                services=services+consultationcb.getText();
                fee=fee+c;
            }
            
            sr=new ServiceReceiver(services);
            sr.setTotalFee(Integer.toString(fee));
            sr.setDay(Integer.toString(day));
            sr.setMonth(Integer.toString(month));
            sr.setYear(Integer.toString(year));
            vr=new VetReceiver(vetname);
            vr.setVetId(vetid);
            vr.setVetContact(vetcontact);
            v_list.add(vr);
            sr_list.add(sr);
            TransactionDataManagement.createObjectFile(v_list, "record.dat");
            TransactionDataManagement.createObjectFile(sr_list, "record.dat");
            JOptionPane.showMessageDialog(this, "Transaction Info has been saved");
        }
        else if(event.getSource()==viewbtn) {
            Iterator itr = v_list.iterator();
            Iterator itr2 = sr_list.iterator();
            while(itr.hasNext() && itr2.hasNext())
                System.out.println(itr.next()+"\n"+itr2.next());
                recordta.setText("Vet Name:"+vetname+"\nVet Id: "+vetid+"\nContact No.: "+vetcontact+"\n\nServices: "+services+"\nTotal Fees: "+fee+"\nDate:"+day+"/"+month+"/"+year);
        }
        else if(event.getSource()==finishbtn) {
            menu MenuObject=new menu();
            MenuObject.setVisible(true);
            this.dispose();
        }
    }
    
    public static void main(String args[]) {
        Transaction TransactionObject=new Transaction();
    }
}
