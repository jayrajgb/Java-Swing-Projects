/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp.bus.booking.system;

/**
 *
 * @author jayra
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPassanger extends JFrame implements ActionListener{
    JButton back;
    ViewPassanger(String username){
        setBounds(450,180,870,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Details");
               
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
                
        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);
        
        
        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(500,50,150,25);
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(690,110,150,25);
        add(labelgender);
        
        
        JLabel lblcity = new JLabel("City:");
        lblcity.setBounds(500,110,150,25);
        add(lblcity);
        
        JLabel labelcity = new JLabel();
        labelcity.setBounds(690,50,150,25);
        add(labelcity);
        
        
        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,300,100,25);
        back.addActionListener(this);
        add(back);
        
       
        try {
            Conn c = new Conn();
            String q1 = "select * from passangers where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(q1);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcity.setText(rs.getString("city"));
                labelphone.setText(rs.getString("phone"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    
    public static void main(String[] args) {
        new ViewPassanger("");
    }
    
}
