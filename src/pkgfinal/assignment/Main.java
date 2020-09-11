/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Ojash
 */
public class Main extends JFrame implements ActionListener {
   
    JLabel lblmsg,lblmsg1,lblname,lbladdress,lblclass,lblsection;
    JTextField txtname,txtaddress;
    JComboBox jbclass,jbsection;
    JButton btnreg,btnupd,btndel;
    JMenuBar mb;
    JMenu m,s,m2 ;
    JMenuItem i1, i2, i3, i4, i5;
    
    public Main(){
        
        setLayout(null);
        setSize(1300,900);
        setTitle("Result Management System");
        
        mb = new JMenuBar();
        
        m= new JMenu("Main");
        s= new JMenu("Subjects");
        m2= new JMenu("Marks");
     
        i1= new JMenuItem("Student detail");
        i2= new JMenuItem("Subjects detail");
        i3= new JMenuItem("Marks detail");
        
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);

        
        m.add(i1);
        s.add(i2);
        m2.add(i3);        
        
        mb.add(m);
        mb.add(s);
        mb.add(m2);
        
        lblmsg = new JLabel("Student Registration Form");
        lblmsg.setFont(new Font("Arial",Font.BOLD,30));
        lblmsg.setBounds(450,20,400,50);
        add(lblmsg);

        lblmsg1 = new JLabel("Enter Student details");
        lblmsg1.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg1.setBounds(70,90,300,20);
        add(lblmsg1);
        
        
//        Labels 

        lblname = new JLabel("Name : ");
        lblname.setFont(new Font("Arial",Font.ITALIC,18));
        lblname.setBounds(20,130,100,30);
        add(lblname);
        
        lbladdress = new JLabel("Address : ");
        lbladdress.setFont(new Font("Arial",Font.ITALIC,18));
        lbladdress.setBounds(20,170,100,30);
        add(lbladdress);
        
        lblclass = new JLabel("Class : ");
        lblclass.setFont(new Font("Arial",Font.ITALIC,18));
        lblclass.setBounds(20,210,100,30);
        add(lblclass);
        
        lblsection = new JLabel("Section : ");
        lblsection.setFont(new Font("Arial",Font.ITALIC,18));
        lblsection.setBounds(20,250,100,30);
        add(lblsection);
        
          

//      TextFields

        txtname = new JTextField(50);
        txtname.setBounds(110,130,200,30);
        add(txtname);
        
        
        txtaddress = new JTextField(50);
        txtaddress.setBounds(110,170,200,30);
        add(txtaddress);
        
//        ComboBox for Class and Section

        jbclass = new JComboBox();
        jbclass.addItem("26");
        jbclass.addItem("25");
        jbclass.addItem("24");
        jbclass.addItem("23");
        jbclass.addItem("22");
        jbclass.addItem("21");
        jbclass.addItem("20");
        jbclass.setBounds(110,210,200,30);
        add(jbclass);
                
        jbsection = new JComboBox();
        jbsection.addItem("A");
        jbsection.addItem("B");
        jbsection.addItem("C");
        jbsection.addItem("D");
        jbsection.setBounds(110,250,200,30);
        add(jbsection);
        
//        Button for register

        btnreg = new JButton("REGISTER");
        btnreg.setBounds(40, 310, 100, 30);
        add(btnreg);
        btnreg.addActionListener(this);
        
        btnupd = new JButton("UPDATE");
        btnupd.setBounds(150, 310, 100, 30);
        add(btnupd);
        btnupd.addActionListener(this);
        
        btndel = new JButton("DELETE");
        btndel.setBounds(260, 310, 100, 30);
        add(btndel);
        btndel.addActionListener(this);
        
        
        setJMenuBar(mb);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if (e.getSource().equals(btnreg)){
            
            String name= txtname.getText();
            String address= txtaddress.getText();
            String classes = jbclass.getSelectedItem().toString();
            String section = jbsection.getSelectedItem().toString();
            
            if ((name.equals("")) || (address.equals(""))){
                JOptionPane.showMessageDialog(null,"Fillout the form correctly");
            }
            else{
                try{
                    Database db = new Database();
                    int id=db.register(name,address,classes,section);
                    if(id>0){
                        JOptionPane.showMessageDialog(null,"Saved");

                        txtname.setText("");
                        txtaddress.setText("");
                        txtname.requestFocus();

                    }else{
                        JOptionPane.showMessageDialog(null,"Unable to Save");

                    }
                }
                catch(Exception a){
                System.out.println("error found" + a);
                }
            }
        }
    }
}
            
            
                    
            
            
 
//        if (e.getSource().equals(i1)){
//            
//            AddStudent page = new AddStudent();
//            dispose();
//        }

    