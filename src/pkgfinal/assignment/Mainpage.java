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
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ojash
 */
public class Mainpage extends JFrame implements ActionListener {
    
    
    
    JLabel lblwelcome;
    JButton btnadd, btnview;
    
    public Mainpage(){
        setLayout(null);
        setSize(400,350);
        setTitle("Result Management System");
        
//       Label to disply messege 

        lblwelcome = new JLabel("Welcome Back!!");
        lblwelcome.setFont(new Font("Arial",Font.BOLD,25));
        lblwelcome.setBounds(90,50,200,40);
        add(lblwelcome);
        
//       Btns for add and view of student data 

        btnadd = new JButton("ADD");
        btnadd.setBounds(70,120,100,40);
        add(btnadd);
        btnadd.addActionListener(this);
                
        btnview = new JButton("View");
        btnview.setBounds(200,120,100,40);
        add(btnview);
        btnview.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     
}

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource()== btnadd){
            dispose();
            AddStudent student = new AddStudent();
        }
        
        if (e.getSource()== btnview){
            dispose();
            ViewStudent view = new ViewStudent();
        }
    
    }
    
    
    
}
