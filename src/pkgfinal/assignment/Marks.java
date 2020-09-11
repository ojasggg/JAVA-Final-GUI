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
/**
 *
 * @author Ojash
 */
public class Marks extends JFrame implements ActionListener{
    
    JLabel lblmsg,lblmarks1,lblmarks2,lblmarks3,lblmarks4;
    JTextField txtmarks1,txtmarks2,txtmarks3,txtmarks4;
    JButton btnsubmit,btnupdate,btndelete;
    
    public Marks(){
        setLayout(null);
        setSize(350,400);
        setTitle("Result Management System");
        
        lblmsg = new JLabel("Marks Area");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(40,20,300,20);
        add(lblmsg);
       
        
        lblmarks1 = new JLabel("Marks of " );
        lblmarks1.setFont(new Font("Arial",Font.ITALIC,18));
        lblmarks1.setBounds(20,100,100,30);
        add(lblmarks1);
        
        lblmarks2 = new JLabel("Subject 2 : ");
        lblmarks2.setFont(new Font("Arial",Font.ITALIC,18));
        lblmarks2.setBounds(20,140,100,30);
        add(lblmarks2);
        
        lblmarks3 = new JLabel("Subject 3 : ");
        lblmarks3.setFont(new Font("Arial",Font.ITALIC,18));
        lblmarks3.setBounds(20,180,100,30);
        add(lblmarks3);
        
        lblmarks4 = new JLabel("Subject 4 : ");
        lblmarks4.setFont(new Font("Arial",Font.ITALIC,18));
        lblmarks4.setBounds(20,220,100,30);
        add(lblmarks4);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
