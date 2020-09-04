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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Ojash
 */
public class Subject extends JFrame implements ActionListener{
    JLabel lblmsg,lblsid,lbls1,lbls2,lbls3,lbls4;
    JTextField txtsid;
    JComboBox jbs1,jbs2,jbs3,jbs4;
    JButton btnsubmit,btnupdate,btndelete;
    
    public Subject(){
        
        setLayout(null);
        setSize(400,350);
        setTitle("Result Management System");
        
        
        lblmsg = new JLabel("Subject Area");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(40,20,300,20);
        add(lblmsg);
        
        lblsid = new JLabel("Student ID : ");
        lblsid.setFont(new Font("Arial",Font.ITALIC,18));
        lblsid.setBounds(20,60,100,30);
        add(lblsid);
        
        lbls1 = new JLabel("Subject 1 : ");
        lbls1.setFont(new Font("Arial",Font.ITALIC,18));
        lbls1.setBounds(20,100,100,30);
        add(lbls1);
        
        lbls2 = new JLabel("Subject 2 : ");
        lbls2.setFont(new Font("Arial",Font.ITALIC,18));
        lbls2.setBounds(20,140,100,30);
        add(lbls2);
        
        lbls3 = new JLabel("Subject 3 : ");
        lbls3.setFont(new Font("Arial",Font.ITALIC,18));
        lbls3.setBounds(20,180,100,30);
        add(lbls3);
        
        lbls4 = new JLabel("Subject 4 : ");
        lbls4.setFont(new Font("Arial",Font.ITALIC,18));
        lbls4.setBounds(20,220,100,30);
        add(lbls4);
        
        txtsid = new JTextField(50);
        txtsid.setBounds(110,60,200,30);
        add(txtsid);
        
        jbs1 = new JComboBox();
        jbs1.addItem("None");
        jbs1.addItem("STW210CT-Programming Algorithms and Data Structures-M20");
        jbs1.addItem("STW205CDE-Developing the Modern Web-M20");
        jbs1.addItem("STW201CS-Effective Communication Skills2-M20");
        jbs1.addItem("STW290COM-Technology and its Legal, Social and Ethical Context-M20");
        jbs1.setBounds(110,100,200,30);
        add(jbs1);
        
        jbs2 = new JComboBox();
        jbs2.addItem("none");
        jbs2.addItem("STW210CT-Programming Algorithms and Data Structures-M20");
        jbs2.addItem("STW205CDE-Developing the Modern Web-M20");
        jbs2.addItem("STW201CS-Effective Communication Skills2-M20");
        jbs2.addItem("STW290COM-Technology and its Legal, Social and Ethical Context-M20");
        jbs2.setBounds(110,140,200,30);
        add(jbs2);
        
        jbs3 = new JComboBox();
        jbs3.addItem("None");
        jbs3.addItem("STW210CT-Programming Algorithms and Data Structures-M20");
        jbs3.addItem("STW205CDE-Developing the Modern Web-M20");
        jbs3.addItem("STW201CS-Effective Communication Skills2-M20");
        jbs3.addItem("STW290COM-Technology and its Legal, Social and Ethical Context-M20");
        jbs3.setBounds(110,180,200,30);
        add(jbs3);
        
        jbs4 = new JComboBox();
        jbs4.addItem("None");
        jbs4.addItem("STW210CT-Programming Algorithms and Data Structures-M20");
        jbs4.addItem("STW205CDE-Developing the Modern Web-M20");
        jbs4.addItem("STW201CS-Effective Communication Skills2-M20");
        jbs4.addItem("STW290COM-Technology and its Legal, Social and Ethical Context-M20");
        jbs4.setBounds(110,220,200,30);
        add(jbs4);
        
        btnsubmit = new JButton("SUBMIT");
        btnsubmit.setBounds(50, 270, 100, 30);
        add(btnsubmit);
        btnsubmit.addActionListener(this);
        
        btnupdate = new JButton("UPDATE");
        btnupdate.setBounds(160, 270, 100, 30);
        add(btnupdate);
        btnupdate.addActionListener(this);
        
        btndelete = new JButton("DELETE");
        btndelete.setBounds(270, 270, 100, 30);
        add(btndelete);
        btndelete.addActionListener(this);
        
                
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


}

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(btnsubmit)){
            
            Integer sid;
            sid = Integer.parseInt(txtsid.getText());
            String subject1 = jbs1.getSelectedItem().toString();
            String subject2 = jbs2.getSelectedItem().toString();
            String subject3 = jbs3.getSelectedItem().toString();
            String subject4 = jbs4.getSelectedItem().toString();
            
            try{
                Database db = new Database();
                int s=db.submit(sid,subject1,subject2,subject3,subject4);
                if(s>0){
                    JOptionPane.showMessageDialog(null,"Saved");
                    
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
