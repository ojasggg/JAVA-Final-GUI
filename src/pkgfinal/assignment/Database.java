/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Ojash
 */
public class Database {
    
    public Connection conn;
    PreparedStatement pstmt;
    ResultSet rs= null;
    
    
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
            
        }catch (SQLException a){
            System.out.print("Error" + a);
        }
        return id;
    }
    
    
    public int update(String name ,String address,String classes,String section,Integer a){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("UPDATE student SET Name=? ,Address=? ,Class=?, Section=? where ID = ? ");
            pstmt.setString(1,name);
            pstmt.setString(2,address);
            pstmt.setString(3,classes);
            pstmt.setString(4,section);
            pstmt.setInt(5,a);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    public int delete(Integer a){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("DELETE FROM student WHERE ID = ? ");
            pstmt.setInt(1,a);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    
    public int submit(Integer sid,String subject_code,String subject){
        int s = 0;
        try{
            pstmt  = conn.prepareStatement("insert into subject values(?,?,?,?)");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject_code);
            pstmt.setString(3,subject);
            
            s = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Error" + ex);
        }
        return s;
    }
    
    public int update_subject(Integer sid ,String subject_code,String subject){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("UPDATE subject SET Student_Id=? ,Subject_code=? ,Subject=? where Student_Id = ? and Subject_code = ? ");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject_code);
            pstmt.setString(3,subject);
            pstmt.setInt(4,sid);
            pstmt.setString(5,subject_code);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    public int delete_subject(Integer a,String subject_code){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("DELETE FROM subject WHERE Student_Id = ? and Subject_code = ? ");
            pstmt.setInt(1,a);
            pstmt.setString(2,subject_code);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    public int submit_marks(Integer sid,String subject_code,String mark,String Grade){
        int s = 0;
        try{
            pstmt  = conn.prepareStatement("Insert into marks values(?,?,?,?)");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject_code);
            pstmt.setString(3,mark);
            pstmt.setString(4,Grade);
            s = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print("Error" + ex);
        }
        return s;
    }
//    select last_name,course_name from courses_subodh as c,students_subodh as s where c.course_id=s.course_id and student_type = 'Overseas Student';
        public int update_marks(Integer sid ,String subject_code,String marks,String Grade){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("UPDATE marks SET Student_Id=? ,Subject_code=? ,Marks=?,Grade=? where Student_Id = ? and Subject_code = ?  ");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject_code);
            pstmt.setString(3,marks);
            pstmt.setString(4,Grade);
            pstmt.setInt(5,sid);
            pstmt.setString(6,subject_code);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    public int delete_marks(Integer sid,String subject_code){
        
        int id = 0;
        try{
            pstmt  = conn.prepareStatement("DELETE FROM marks WHERE Student_Id = ? and Subject_code = ? ");
            pstmt.setInt(1,sid);
            pstmt.setString(2,subject_code);
            id = pstmt.executeUpdate();
            
        }catch ( SQLException s){
            System.out.print("Error" + s);
        }
        return id;
    }
    
    
}
   
    

