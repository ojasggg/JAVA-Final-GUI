/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;


import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Ojash
 */
public class Add_subject extends JFrame implements ActionListener{
    
    JLabel lblsid,lblmsg;
    JTextField txtsid;
    JButton btnrun;
    Integer sid;
    
    public Add_subject(){
        setLayout(null);
        setSize(400,350);
        setTitle("Result Management System");
        
        lblmsg = new JLabel("Enter Student ID");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(130,20,200,50);
        add(lblmsg);
        
        lblsid = new JLabel("Student ID : ");
        lblsid.setFont(new Font("Arial",Font.ITALIC,18));
        lblsid.setBounds(20,100,150,30);
        add(lblsid);
        
        txtsid = new JTextField(50);
        txtsid.setBounds(180,100,150,30);
        add(txtsid);
        
        btnrun = new JButton("ADD");
        btnrun.setBounds(160, 140, 100, 30);
        add(btnrun);
        btnrun.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(btnrun)){
           
            sid = Integer.parseInt(txtsid.getText());
            Subject sub = new Subject();
            dispose();
        }
    
    }
    public Integer send(){
        return this.sid;
    }
    
}
