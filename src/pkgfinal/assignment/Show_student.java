/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author Ojash
 */
public class Show_student extends JFrame  {
    
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl ;
    
    public Show_student() {
        
        setTitle("Student Details");
        setSize(500, 300);
        setLocationRelativeTo(null);
        jtbl = new JTable(model);
        cnt.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Class");
        model.addColumn("Section");
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/exam_registration", "root", "");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}
        



  