
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laode
 */
class User {
    private int nim;
    private String name, address, email, phone, gender, classes, major;
    
    public User(int nim, String name, String address, String email, String phone, String gender, String classes, String major)
    {
        this.nim=nim;
        this.name=name;
        this.address=address;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.classes=classes;
        this.major=major;
    }

    User(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getnim(){
        return nim;
    }
    public String getname(){
        return name;
    }
    public String getaddress(){
        return address;
    }
    public String getemail(){
        return email;
    }
    public String getphone(){
        return phone;
    }
    public String getgender(){
        return gender;
    }
    public String getclasses(){
        return classes;
    }
    public String getmajor(){
        return major;
    }

    }




   

