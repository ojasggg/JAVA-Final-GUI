/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.assignment;

/**
 *
 * @author Ojash
 */
public class Students {
    private int ID;
    private String Name,Address,Class,Section;
    
    
    public Students(int ID,String Name,String Address,String Class,String Section){
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Class = Class;
        this.Section = Section;
    }
    public int getId(){
        return ID;
    }
    public String getName(){
        return Name;
    }
    public String getAddress(){
        return Address;
    }
    public String getclass(){
        return Class;
    }
    public String getSection(){
        return Section;
    }

}
