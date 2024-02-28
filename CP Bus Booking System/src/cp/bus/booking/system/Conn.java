/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp.bus.booking.system;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s,s1,s2,s3;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","3036"); 
            
            s =c.createStatement();  
            
            s1=c.createStatement();
            
            s2=c.createStatement();
            
            s3=c.createStatement();
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
