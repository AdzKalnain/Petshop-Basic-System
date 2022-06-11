package bscs2b_group4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Pet extends JFrame implements ActionListener{
    Container contentPane;
    JLabel namelbl, agelbl, breedlbl, typelbl, genderlbl; 
    JTextField nametf, agetf, breedtf, typetf;
    JButton addbtn;
    JButton savebtn, viewbtn, nextbtn;
    JRadioButton malerb;
    JRadioButton femalerb;
    
    String petname, age, type, breed, gender;
    ArrayList<PetReciever>list;
    PetReciever pr;
    public Pet() {
        list=(ArrayList<PetReciever>)TransactionDataManagement.readObjectFile("record.dat");
        contentPane=getContentPane();
        namelbl=new JLabel("PetName:");
        agelbl=new JLabel("PetAge:");
        typelbl=new JLabel("PetType:");
        breedlbl=new JLabel("PetBreed:");
        genderlbl=new JLabel("Gender:");
        nametf=new JTextField(30);
        agetf=new JTextField(30);
        typetf=new JTextField(30);
        breedtf=new JTextField(30);
        //addbtn=new JButton("Add");
        savebtn=new JButton("Save");
        viewbtn= new JButton("View");
        nextbtn=new JButton("Next");
        ButtonGroup group=new ButtonGroup();
        
        malerb=new JRadioButton("Male");
        femalerb=new JRadioButton("Female");
        malerb.setBounds(230,235,100,20);
        femalerb.setBounds(330,235,100,20);
        genderlbl.setBounds(120,230,100,30);
        
        namelbl.setBounds(120,70,100,30);
        nametf.setBounds(230,70,300,30);
        agelbl.setBounds(120,110,100,30);
        agetf.setBounds(230,110,300,30);
        typelbl.setBounds(120,150,100,30);
        typetf.setBounds(230,150,300,30);
        breedlbl.setBounds(120,190,100,30);
        breedtf.setBounds(230,190,300,30);
        //addbtn.setBounds(210,320,100,30);
        savebtn.setBounds(320,320,100,30);
        viewbtn.setBounds(430,320,100,30);
        nextbtn.setBounds(540,320,100,30);
        group.add(malerb);
        group.add(femalerb);
        
        contentPane.setBackground(Color.ORANGE);
        contentPane.add(namelbl);
        contentPane.add(nametf);
        contentPane.add(agelbl);
        contentPane.add(agetf);
        contentPane.add(typelbl);
        contentPane.add(typetf);
        contentPane.add(breedlbl);
        contentPane.add(breedtf);
        contentPane.add(genderlbl);
        contentPane.add(malerb);
        contentPane.add(femalerb);
        //contentPane.add(addbtn);
        contentPane.add(savebtn);
        contentPane.add(viewbtn);
        contentPane.add(nextbtn);
        
        //addbtn.addActionListener(this);
        savebtn.addActionListener(this);
        viewbtn.addActionListener(this);
        nextbtn.addActionListener(this);
        
        setLayout(null);
        setTitle("Pet Info");
        setVisible(true);
        setLocation(300,200);
        setSize(700,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    public void actionPerformed(ActionEvent event) {
        petname=nametf.getText();
        age=agetf.getText();
        type=typetf.getText();
        breed=breedtf.getText();
        /*if(event.getSource()==addbtn) {
            if(malerb.isSelected()){
                gender=malerb.getText();
            }
            if(femalerb.isSelected()){
                gender=femalerb.getText();
            }
            pr=new PetReciever(petname);
            pr.setAge(age);
            pr.setBreed(breed);
            pr.setType(type);
            pr.setGender(gender);
            list.add(pr);
            
            JOptionPane.showMessageDialog(this, "Pet Info has been Added");
        }*/
        if(event.getSource()==savebtn) {
            if(malerb.isSelected()){
                gender=malerb.getText();
            }
            if(femalerb.isSelected()){
                gender=femalerb.getText();
            }
            pr=new PetReciever(petname);
            pr.setAge(age);
            pr.setBreed(breed);
            pr.setType(type);
            pr.setGender(gender);
            list.add(pr);
        
            TransactionDataManagement.createObjectFile(list,"record.dat");
            JOptionPane.showMessageDialog(this, "Pet Info has been Saved");
        }
        else if(event.getSource()==viewbtn) {
            Iterator itr=list.iterator();
            while(itr.hasNext())
                System.out.println("\n"+itr.next());
        }
        else if(event.getSource()==nextbtn) {
            Transaction TransactionObject=new Transaction();
            TransactionObject.setVisible(true);
            this.dispose();
        }
    }
    
    public static void main(String args[]){ 
        Pet PetObject=new Pet();
    
    }
}
