/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ojash
 */
public class AddStudent extends JFrame implements ActionListener {
    JLabel lblmsg,lblname,lbladdress,lblclass,lblsection;
    JTextField txtname,txtaddress;
    JComboBox jbclass,jbsection;
    JButton btnreg;
    
    
    
    public AddStudent(){
        setLayout(null);
        setSize(1300,900);
        setTitle("Result Management System");
        
        
//        Label to Display the top Messege

        lblmsg = new JLabel("Student Registration Form");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(40,20,300,20);
        add(lblmsg);
        
        
        
//        Labels 

        lblname = new JLabel("Name : ");
        lblname.setFont(new Font("Arial",Font.ITALIC,18));
        lblname.setBounds(20,60,100,30);
        add(lblname);
        
        lbladdress = new JLabel("Address : ");
        lbladdress.setFont(new Font("Arial",Font.ITALIC,18));
        lbladdress.setBounds(20,100,100,30);
        add(lbladdress);
        
        lblclass = new JLabel("Class : ");
        lblclass.setFont(new Font("Arial",Font.ITALIC,18));
        lblclass.setBounds(20,140,100,30);
        add(lblclass);
        
        lblsection = new JLabel("Section : ");
        lblsection.setFont(new Font("Arial",Font.ITALIC,18));
        lblsection.setBounds(20,180,100,30);
        add(lblsection);
        
          

//      TextFields

        txtname = new JTextField(50);
        txtname.setBounds(110,60,200,30);
        add(txtname);
        
        
        txtaddress = new JTextField(50);
        txtaddress.setBounds(110,100,200,30);
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
        jbclass.setBounds(110,140,200,30);
        add(jbclass);
                
        jbsection = new JComboBox();
        jbsection.addItem("A");
        jbsection.addItem("B");
        jbsection.addItem("C");
        jbsection.addItem("D");
        jbsection.setBounds(110,180,200,30);
        add(jbsection);
        
//        Button for register

        btnreg = new JButton("REGISTER");
        btnreg.setBounds(120, 230, 100, 30);
        add(btnreg);
        btnreg.addActionListener(this);
        
        
        
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
