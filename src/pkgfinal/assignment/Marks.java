/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
/**
/**
 *
 * @author Ojash
 */
public class Marks extends JFrame implements ActionListener{
    
    JLabel lblmsg,lblmarks,lblmsg1,lblmsg2,lblsid,lblcode;
    JTextField txtmarks,txtsid,txtsearch;
    JButton btnsubmit,btnupdate,btndelete,btnsearch;
    JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();
    JPanel jp1;
    Container cnt = this.getContentPane();
    JTable jtbl ;
    JMenuBar mb;
    JMenu m,s,m2 ;
    JMenuItem i1, i2, i3, i4, i5;
    JComboBox jbcode;
    
    public Marks(){
        
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
        setSize(1300,900);
        setTitle("Result Management System");
        
        //      MenuBar and Menu Items
        
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
        
        lblmsg = new JLabel("Marks Area");
        lblmsg.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg.setBounds(550,20,400,50);
        add(lblmsg);
        
        lblmsg1 = new JLabel("Enter Student Marks");
        lblmsg1.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg1.setBounds(70,90,300,20);
        add(lblmsg1);
        
        lblmsg2 = new JLabel("Student Marks");
        lblmsg2.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg2.setBounds(770,90,300,20);
        add(lblmsg2);
        
        
        lblsid = new JLabel("Student ID : ");
        lblsid.setFont(new Font("Arial",Font.ITALIC,18));
        lblsid.setBounds(20,150,150,30);
        add(lblsid);
        
        lblcode = new JLabel("Subject code : ");
        lblcode.setFont(new Font("Arial",Font.ITALIC,18));
        lblcode.setBounds(20,190,150,30);
        add(lblcode);
        
        lblmarks = new JLabel("Marks : ");
        lblmarks.setFont(new Font("Arial",Font.ITALIC,18));
        lblmarks.setBounds(20,230,150,30);
        add(lblmarks);
        
        txtmarks = new JTextField(50);
        txtmarks.setBounds(160,230,200,30);
        add(txtmarks);
        
        txtsid = new JTextField(50);
        txtsid.setBounds(160,150,200,30);
        add(txtsid);
        
        jbcode = new JComboBox();
        jbcode.addItem("STW210CT");
//        jbcode.addItem("STW205CDE");
//        jbcode.addItem("STW201CS");
//        jbcode.addItem("STW290COM");
        jbcode.setBounds(160,190,200,30);
        add(jbcode);
        
        btnsubmit = new JButton("SUBMIT");
        btnsubmit.setBounds(50, 300, 100, 30);
        add(btnsubmit);
        btnsubmit.addActionListener(this);
        
        btnupdate = new JButton("UPDATE");
        btnupdate.setBounds(160, 300, 100, 30);
        add(btnupdate);
        btnupdate.addActionListener(this);
        
        btndelete = new JButton("DELETE");
        btndelete.setBounds(270, 300, 100, 30);
        add(btndelete);
        btndelete.addActionListener(this);
        
        //        Textfield for search box.

        txtsearch = new JTextField(50);
        txtsearch.setBounds(850,120,230,30);
        add(txtsearch);
        
//        Button for search box
            
        btnsearch = new JButton("SEARCH");
        btnsearch.setBounds(1080, 120, 100, 30);
        add(btnsearch);
        btnsearch.addActionListener(this);
        
        jtbl = new JTable(model);
        cnt.setLayout(null);
        jtbl.setRowHeight(jtbl.getRowHeight()+20);
        add(jtbl);
        
        model.addColumn("Student_Id");
        model.addColumn("Subject_code");
        model.addColumn("Marks");
        model.addColumn("Grade");
        
 
        
        jtbl.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {

            DefaultTableModel model = (DefaultTableModel)jtbl.getModel();
            int selectedRowIndex  = jtbl.getSelectedRow();
            

            txtsid.setText(model.getValueAt(selectedRowIndex, 0).toString());
            
            String combo1 = model.getValueAt(selectedRowIndex,1).toString();
            for(int i=0;i<jbcode.getItemCount();i++){
                if(jbcode.getItemAt(i).toString().equalsIgnoreCase(combo1)){
                    jbcode.setSelectedIndex(i);
                }    
                    
            }
                    
            txtmarks.setText(model.getValueAt(selectedRowIndex, 2).toString());
        }    
        });
        

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/exam_registration", "root", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM marks");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setBounds(500,150,700,600);
        cnt.add(pg);
        
        
        setJMenuBar(mb);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource().equals(btnsubmit)){
            
            Integer sid;
            sid = Integer.parseInt(txtsid.getText());
            String subject_code = jbcode.getSelectedItem().toString();
            String mark = txtmarks.getText();
            int ma = Integer.parseInt(txtmarks.getText());
            String Grade = "";
            if (ma>=80){
                Grade = "A";
            }else if  (ma<80 && ma>=60){
                Grade = "B";
            }else if  (ma<60 && ma>=40){
                Grade = "B";
            }else{
                Grade = "D";
            }
            
            
            

            
            try{
                Database db = new Database();
                int s=db.submit_marks(sid,subject_code,mark,Grade);
                if(s>0){
                    JOptionPane.showMessageDialog(null,"Saved");
                    Marks page = new Marks();
                    dispose();
                        
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Unable to save.");
                    
                }
            }
            catch(Exception a){
                System.out.println("error found" + a);
            }
                    
            
            
        }
        if (e.getSource().equals(btnupdate)){
            Integer sid;
            sid = Integer.parseInt(txtsid.getText());
            String subject_code = jbcode.getSelectedItem().toString();
            String marks = txtmarks.getText();
            int ma = Integer.parseInt(txtmarks.getText());
            String Grade = "";
            if (ma>=80){
                Grade = "A";
            }else if  (ma<80 && ma>=60){
                Grade = "B";
            }else if  (ma<60 && ma>=40){
                Grade = "B";
            }else{
                Grade = "D";
            }
            
            
            if ((sid.equals("")) || (marks.equals(""))){
                JOptionPane.showMessageDialog(null,"Fillout the form correctly");
            }
            else{
                try{
                    Database db = new Database();
                    int selectedRowIndex  = jtbl.getSelectedRow();
            
                    int a = (int) model.getValueAt(selectedRowIndex,0);

                    int id=db.update_marks(sid,subject_code,marks,Grade);
                    if(id>0){
                        JOptionPane.showMessageDialog(null,"Updated");
                        Marks page = new Marks();
                        dispose();
                        

                    }else{
                        JOptionPane.showMessageDialog(null,"Unable to Update");

                    }
                }
                catch(Exception x){
                System.out.println("error found" + x);
                JOptionPane.showMessageDialog(null,"Image is necessary.");
                }
            }
        }
        if (e.getSource().equals(btndelete)){
            try{
                Database db = new Database();
                int selectedRowIndex  = jtbl.getSelectedRow();

                int a = (int) model.getValueAt(selectedRowIndex,0);
                String subject_code = jbcode.getSelectedItem().toString();

                int id=db.delete_marks(a,subject_code);
                System.out.print(a);
                if(id>0){
                    JOptionPane.showMessageDialog(null,"Deleted");
                    Marks page = new Marks();
                    dispose();


                }else{
                    JOptionPane.showMessageDialog(null,"Unable to delete");

                }
            }
            catch(Exception x){
                System.out.println("error found" + x);
                JOptionPane.showMessageDialog(null,"Image is necessary.");
            }
        }
        if(e.getSource().equals(btnsearch)){
            
            int eId= Integer.parseInt(txtsearch.getText());
            
     
            Search search;
            search = new Search();
            search.sear(eId);
        }
        if (e.getSource().equals(i1)){
            dispose();
            Main page = new Main();
        }
        if (e.getSource().equals(i2)){
            dispose();
            Subject page = new Subject();
        }
        if (e.getSource().equals(i3)){
            dispose();
            Marks page = new Marks();
        }
            
    }
    
    //    The data of Search sets on the textfield in the form section.
    
//    public void search(String eId) throws ClassNotFoundException{ 
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/abc_organization", "root", "");
//            PreparedStatement pstmt = conn.prepareStatement("SELECT ID , Name , Address ,Department, Salary FROM employee WHERE ID ='"+eId+"'");
//            ResultSet rs = pstmt.executeQuery();
//            int id=0;  
//            String names ="";  
//            String Address="";  
//            String Department="";  		
//            String Salary="";
//            while(rs.next()){
//                id = rs.getInt(1);
//                names = rs.getString(2);
//                Address = rs.getString(3);
//                Department=rs.getString(4);
//                Salary = rs.getString(5);
//            }
//            txtname.setText(names.toString());
//            txtaddress.setText(Address.toString());
//            txtsalary.setText(Salary.toString());
//            
//            String combo = Department.toString();
//            for(int i=0;i<jbdpt.getItemCount();i++){
//                if(jbdpt.getItemAt(i).toString().equalsIgnoreCase(combo)){
//                    jbdpt.setSelectedIndex(i);
//                
//                }
//            }
//            
//        }catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//        } 
//    }
    
}
