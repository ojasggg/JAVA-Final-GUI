/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgfinal.assignment;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Ojash
 */
public class Login extends JFrame implements ActionListener {
    JLabel lblusername,lblpass,lbllogo;
    JTextField txtusername;
    JPasswordField pass;
    JButton btnlogin,btnclose;
    
    
    public Login(){
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        setLayout(null);
        setSize(400,350);
        setTitle("Result Management System");
        
        lblusername = new JLabel("Username : ");
        lblusername.setFont(new Font("Arial",Font.ITALIC,18));
        lblusername.setBounds(50, 20, 100, 40);
        add(lblusername);
        
        lblpass = new JLabel("Password :  ");
        lblpass.setFont(new Font("Arial",Font.ITALIC,18));
        lblpass.setBounds(50, 70, 100, 40);
        add(lblpass);
        
        txtusername=new JTextField(20);
        txtusername.setBounds(150, 20, 200, 40);
        add(txtusername);
        
        pass = new JPasswordField(16);
        pass.setBounds(150, 70, 200, 40);
        add(pass);
        
        
        btnlogin = new JButton("LOGIN");
        btnlogin.setBounds(90,150,100,30);
        add(btnlogin);
        btnlogin.addActionListener(this);
        
        btnclose = new JButton("EXIT");
        btnclose.setBounds(200,150,100,30);
        add(btnclose);
        btnclose.addActionListener(this);
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e.getSource().equals(btnclose)){
            dispose();
        }
            String username = txtusername.getText();
            String password = new String(pass.getPassword());
            
            if(e.getSource().equals(btnlogin)){
                if (username.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Username Required");
                }
                else if(password.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Password Required");
             
                }
                else if((username.equals("c"))&&(password.equals("admin")) ){
                    JOptionPane.showMessageDialog(null,"Login Sucessfully");
                    dispose();
                    Main page =new Main();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Login Failed");
                }
            }
                
                
    
    }

}

    
