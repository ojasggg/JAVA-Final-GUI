/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ojash
 */
public class Search extends JFrame implements ActionListener {
    JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();
    JPanel jp1;
    JLabel lblmsg;
    Container cnt = this.getContentPane();
    JTable jtbl ;
    
    public Search(){
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
        setSize(800,700);
        setTitle("Result Management System");
        setLocationRelativeTo(null);
        
        lblmsg = new JLabel("Student Result");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(300,20,400,50);
        add(lblmsg);

        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        

    public void sear(int eId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        jtbl = new JTable(model);
        cnt.setLayout(null);
        jtbl.setRowHeight(jtbl.getRowHeight()+20);
        add(jtbl);
        
        model.addColumn("Student_Id");
        model.addColumn("Subject_code");
        model.addColumn("Marks");
        model.addColumn("Grade");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/exam_registration", "root", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM marks WHERE Student_Id ='"+eId+"'");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setBounds(30,70,700,300);
        cnt.add(pg);
    }
   
}
