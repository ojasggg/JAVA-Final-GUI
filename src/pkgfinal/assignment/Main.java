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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ojash
 */
public class Main extends JFrame implements ActionListener {
   
    JLabel lblmsg,lblmsg1,lblmsg2,lblname,lbladdress,lblclass,lblsection;
    JTextField txtname,txtaddress;
    JComboBox jbclass,jbsection;
    JButton btnreg,btnupd,btndel,btnview;
    JMenuBar mb;
    JMenu m,s,m2 ;
    JMenuItem i1, i2, i3, i4, i5;
    JScrollPane scroll;
    DefaultTableModel model = new DefaultTableModel();
    JPanel jp1;
    Container cnt = this.getContentPane();
    JTable jtbl ;
    
    
    public Main(){
        
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
        setLocationRelativeTo(null);
    
        
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
        
//      Labels for the messages 

        lblmsg = new JLabel("Student Registration Form");
        lblmsg.setFont(new Font("Arial",Font.BOLD,30));
        lblmsg.setBounds(450,20,400,50);
        add(lblmsg);

        lblmsg1 = new JLabel("Enter Student details");
        lblmsg1.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg1.setBounds(70,90,300,20);
        add(lblmsg1);
        
        lblmsg2 = new JLabel("Student Detail");
        lblmsg2.setFont(new Font("Arial",Font.BOLD,20));
        lblmsg2.setBounds(770,90,300,20);
        add(lblmsg2);
        
        
//        Labels 

        lblname = new JLabel("Name : ");
        lblname.setFont(new Font("Arial",Font.ITALIC,18));
        lblname.setBounds(20,130,100,30);
        add(lblname);
        
        lbladdress = new JLabel("Address : ");
        lbladdress.setFont(new Font("Arial",Font.ITALIC,18));
        lbladdress.setBounds(20,170,100,30);
        add(lbladdress);
        
        lblclass = new JLabel("Class : ");
        lblclass.setFont(new Font("Arial",Font.ITALIC,18));
        lblclass.setBounds(20,210,100,30);
        add(lblclass);
        
        lblsection = new JLabel("Section : ");
        lblsection.setFont(new Font("Arial",Font.ITALIC,18));
        lblsection.setBounds(20,250,100,30);
        add(lblsection);
        
          

//      TextFields

        txtname = new JTextField(50);
        txtname.setBounds(110,130,200,30);
        add(txtname);
        
        
        txtaddress = new JTextField(50);
        txtaddress.setBounds(110,170,200,30);
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
        jbclass.setBounds(110,210,200,30);
        add(jbclass);
                
        jbsection = new JComboBox();
        jbsection.addItem("A");
        jbsection.addItem("B");
        jbsection.addItem("C");
        jbsection.addItem("D");
        jbsection.setBounds(110,250,200,30);
        add(jbsection);
        
//        Button for register

        btnreg = new JButton("REGISTER");
        btnreg.setBounds(40, 310, 100, 30);
        add(btnreg);
        btnreg.addActionListener(this);
        
//        Button for update

        btnupd = new JButton("UPDATE");
        btnupd.setBounds(150, 310, 100, 30);
        add(btnupd);
        btnupd.addActionListener(this);

//        Button for delete   

        btndel = new JButton("DELETE");
        btndel.setBounds(260, 310, 100, 30);
        add(btndel);
        btndel.addActionListener(this);
       
        
        
////        Table 
        
        jtbl = new JTable(model);
        cnt.setLayout(null);
        jtbl.setRowHeight(jtbl.getRowHeight()+20);
        add(jtbl);
        
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Class");
        model.addColumn("Section");
        
        jtbl.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {

            DefaultTableModel model = (DefaultTableModel)jtbl.getModel();
            int selectedRowIndex  = jtbl.getSelectedRow();
            

            txtname.setText(model.getValueAt(selectedRowIndex, 1).toString());
            txtaddress.setText(model.getValueAt(selectedRowIndex, 2).toString());
            
            
            String combo1 = model.getValueAt(selectedRowIndex,3).toString();
            for(int i=0;i<jbclass.getItemCount();i++){
                if(jbclass.getItemAt(i).toString().equalsIgnoreCase(combo1)){
                    jbclass.setSelectedIndex(i);
                }    
                    
            }
                    
            String combo2 = model.getValueAt(selectedRowIndex,3).toString();
            for(int j=0;j<jbsection.getItemCount();j++){
                if(jbsection.getItemAt(j).toString().equalsIgnoreCase(combo2)){
                    jbsection.setSelectedIndex(j);
                
                }
            }
        }    
        });
        

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/exam_registration", "root", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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

        if (e.getSource().equals(btnreg)){
            
            String name= txtname.getText();
            String address= txtaddress.getText();
            String classes = jbclass.getSelectedItem().toString();
            String section = jbsection.getSelectedItem().toString();
            
            if ((name.equals("")) || (address.equals(""))){
                JOptionPane.showMessageDialog(null,"Fillout the form correctly");
            }
            else{
                try{
                    Database db = new Database();
                    int id=db.register(name,address,classes,section);
                    if(id>0){
                        JOptionPane.showMessageDialog(null,"Saved");
                        Main page = new Main();
                        dispose();
                        

                    }else{
                        JOptionPane.showMessageDialog(null,"Unable to Save");

                    }
                }
                catch(Exception a){
                System.out.println("error found" + a);
                }
            }
        }
        
        if (e.getSource().equals(btnupd)){
            String name= txtname.getText();
            String address= txtaddress.getText();
            String classes = jbclass.getSelectedItem().toString();
            String section = jbsection.getSelectedItem().toString();
            
            
            if ((address.equals("")) || (name.equals(""))){
                JOptionPane.showMessageDialog(null,"Fillout the form correctly");
            }
            else{
                try{
                    Database db = new Database();
                    int selectedRowIndex  = jtbl.getSelectedRow();
            
                    int a = (int) model.getValueAt(selectedRowIndex,0);

                    int id=db.update(name,address,classes,section,a);
                    if(id>0){
                        JOptionPane.showMessageDialog(null,"Updated");
                        Main page = new Main();
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
            
        if (e.getSource().equals(btndel)){
            try{
                Database db = new Database();
                int selectedRowIndex  = jtbl.getSelectedRow();
            
                int a = (int) model.getValueAt(selectedRowIndex,0);

                int id=db.delete(a);
                if(id>0){
                    JOptionPane.showMessageDialog(null,"Deleted");
                    Main page = new Main();
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
    
   
    
}
            
            
                    
            
            
 
//        if (e.getSource().equals(i1)){
//            
//            AddStudent page = new AddStudent();
//            dispose();
//        }

    