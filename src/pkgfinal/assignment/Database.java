/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ojash
 */
public class Database {
    
    public Connection conn;
    PreparedStatement pstmt;
    
    
    public Database(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost/exam_registration","root","");
            
                if ( true){
                    System.out.println("success.");
                }
                else{
                    System.out.println("Not connected.");
                }
            
                                
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
    public int register(String name ,String address,String classes,String section){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("insert into student values(?,?,?,?,?)");
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            pstmt.setString(4,classes);
            pstmt.setString(5,section);
            id = pstmt.executeUpdate();
            
        }catch (Exception a){
            System.out.print("Error" + a);
        }
        return id;
    }
    
    public int submit(Integer sid,String subject1,String subject2,String subject3,String subject4){
        int s = 0;
        try{
            pstmt  = conn.prepareStatement("insert into subject values(?,?,?,?,?)");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject1);
            pstmt.setString(3,subject2);
            pstmt.setString(4,subject3);
            pstmt.setString(5,subject4);
            s = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
