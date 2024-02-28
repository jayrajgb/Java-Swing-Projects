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

public class AddPassanger extends JFrame implements ActionListener{
    
    JLabel lblusername,lblname;
    JComboBox textid;
    JTextField textnumber,textcity,textphone;
    JRadioButton male,female;
    JButton add,cancel;
    
    AddPassanger(String username){
        setBounds(450,200,450,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Passanger Details");
        
        JLabel txtusername = new JLabel("Username");
        txtusername.setBounds(30,50,150,25);
        add(txtusername);
        
        lblusername = new JLabel();
        lblusername.setBounds(220,50,150,25);
        add(lblusername);
        
        JLabel txtid = new JLabel("Id");
        txtid.setBounds(30,90,150,25);
        add(txtid);
        
        textid = new JComboBox(new String [] {"Aadhar Card","PAN Card","Passport","License"});
        textid.setBounds(220,90,150,25);
        textid.setBackground(Color.WHITE);
        add(textid);
        
        JLabel txtnumber = new JLabel("Number");
        txtnumber.setBounds(30,130,150,25);
        add(txtnumber);
        
        textnumber = new JTextField();
        textnumber.setBounds(220,130,150,25);
        add(textnumber);
        
        JLabel txtlabel = new JLabel("Name");
        txtlabel.setBounds(30,170,150,25);
        add(txtlabel);
        
        lblname = new JLabel();
        lblname.setBounds(220,170,150,25);
        add(lblname);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel txtcity = new JLabel("City");
        txtcity.setBounds(30,250,150,25);
        add(txtcity);
        
        textcity = new JTextField();
        textcity.setBounds(220,250,150,25);
        add(textcity);
        
        JLabel txtphone = new JLabel("Phone");
        txtphone.setBounds(30,290,150,25);
        add(txtphone);
        
        textphone = new JTextField();
        textphone.setBounds(220,290,150,25);
        add(textphone);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,350,100,25);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select*from account where username = '"+username+"'");
            while(rs.next()){
                lblusername.setText(rs.getString("username"));
                lblname.setText(rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String username = lblusername.getText();
        if(ae.getSource() == add){
            String id = (String) textid.getSelectedItem();
            String number = textnumber.getText();
            String name = lblname.getText();
            String city = textcity.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }
            
            String phone = textphone.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into passangers values('"+username+"','"+id+"','"+number+"','"+name+"','"+city+"','"+gender+"','"+phone+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Passanger Added!");
                setVisible(false);
                new Dashboard(username).setVisible(true);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddPassanger("");
    }
}
