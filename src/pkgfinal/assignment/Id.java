/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.in;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ojash
 */
public class Id extends JFrame implements ActionListener {
    JLabel lblsid;
    JTextField txtsid;
    JButton btnsubmit;
    
    public Id(){
        setLayout(null);
        setSize(400,350);
        setTitle("Result Management System");
        
        lblsid = new JLabel("Student ID : ");
        lblsid.setFont(new Font("Arial",Font.ITALIC,18));
        lblsid.setBounds(20,60,100,30);
        add(lblsid);
        
        txtsid = new JTextField(50);
        txtsid.setBounds(110,60,200,30);
        add(txtsid);
        
        btnsubmit = new JButton("SUBMIT");
        btnsubmit.setBounds(50, 270, 100, 30);
        add(btnsubmit);
        btnsubmit.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(btnsubmit)){
            
            
            int sid = Integer.parseInt(txtsid.getText());
            
            try{
                Database db = new Database();
                
                int value;
                value = db.send(sid);
                if(value==0){
                    JOptionPane.showMessageDialog(null,"No data in the Subject Table");
                    
                }
                
                if (value.equals(sid)){

                    Marks m = new Marks();
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"No data of "+value+" in the database.");
                    
                }
                
            }
            catch(Exception a){
                System.out.println("error found" + a);
            }
                    
            
            
        }
    
    }
    
}
