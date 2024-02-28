/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp.bus.booking.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener{

	JPanel panel;
	JTextField textField;
	JPasswordField passwordField;
        JButton b1,b2,b3;


	public Login1() {
            
	setBackground(new Color(255,182,193));
        setBounds(550, 250, 700, 400);
        setTitle("Admin Login");
		
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(124, 124, 95, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("CP/Bus/Booking/System/icons/admin.png"));
        Image i1 = c1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 70, 150, 150);
        add(l6);
        
        
	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.BLACK);
	b1.setBackground(Color.WHITE);
	b1.setBounds(149, 181, 113, 25);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(Color.BLACK);
	b2.setBackground(Color.WHITE);
	b2.setBounds(289, 181, 113, 25);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(Color.BLACK);
	b3.setBackground(new Color(255,182,193));
	b3.setBounds(199, 231, 179, 25);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(50, 235, 130, 20);
	panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
		try {
                    String username = textField.getText();
                    String password = passwordField.getText();
                    Conn c = new Conn();
                    String sql = "select * from addadmin where username='"+username+"' and password='"+password+"'";
                    
                    ResultSet rs = c.s.executeQuery(sql);
                    
                    if (rs.next()) {
                        this.setVisible(false);
                        new Dashboard1(username).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup1 su = new Signup1();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword1 forgot = new ForgotPassword1();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login1().setVisible(true);
	}

} 