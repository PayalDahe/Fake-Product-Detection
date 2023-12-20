/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fddb;

/**
 *
 * @author Admin
 */
import java.sql.*;
public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(name,email,password) values(?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPassword());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    public boolean checkUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "Select email,password from user where email=? and password=?";
           
           PreparedStatement pt = this.con.prepareStatement(query);
          
           pt.setString(1, user.getEmail());
           pt.setString(2, user.getPassword());
           
          // pt.execute();
          ResultSet rs = pt.executeQuery(); 
           if(rs.next())  
           set = true;
        }catch(Exception e){
           e.printStackTrace();
        }
        return set;
    }
      //for register user 
    public boolean saveStudentMarks(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into marks(sname,eno,email,mobno,gender,sem,subj1,m1,subj2,m2,subj3,m3,subj4,m4,subj5,m5,subj6,m6,subj7,m7) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEnNo());
           pt.setString(3, user.getEmail());
           pt.setString(4, user.getMobNo());
           pt.setString(5, user.getGender());
           pt.setString(6, user.getSemester());
           pt.setString(7, user.getSub1());
           pt.setString(8, user.getS1marks());
           pt.setString(9, user.getSub2());
           pt.setString(10, user.getS2marks());
           pt.setString(11, user.getSub3());
           pt.setString(12, user.getS3marks());
           pt.setString(13, user.getSub4());
           pt.setString(14, user.getS4marks());
           pt.setString(15, user.getSub5());
           pt.setString(16, user.getS5marks());
           pt.setString(17, user.getSub6());
           pt.setString(18, user.getS6marks());
           pt.setString(19, user.getSub7());
           pt.setString(20, user.getS7marks());
           
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
     
}
