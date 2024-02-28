/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp.bus.booking.system;

/**
 *
 * @author jayra
 */
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.border.TitledBorder;

public class BookBus extends JFrame implements ActionListener{
    JButton add,check,cancel,back;
    JComboBox bus1;
    JDateChooser date2;
    JTextField name1,seat1,from1,to1;
    BookBus(){
	setBounds(100, 100, 650, 530);
	setLayout(null);
        setTitle("Booking");
        
        JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Booking/Cancellation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(40, 40, 550, 425);
        panel.setLayout(null);
	add(panel);
                     
        JLabel lblName = new JLabel("Name");
	lblName.setBounds(56, 35, 52, 19);
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	panel.add(lblName);
	
	JLabel lblseat = new JLabel("Seat No.");
	lblseat.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblseat.setBounds(56, 87, 70, 19);
	panel.add(lblseat);
	
	JLabel lblbus = new JLabel("Bus No.");
	lblbus.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblbus.setBounds(56, 191, 52, 19);
	panel.add(lblbus);
	
	JLabel lblfrom = new JLabel("From");
	lblfrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblfrom.setBounds(56, 243, 52, 19);
	panel.add(lblfrom);
	
	JLabel lblto = new JLabel("To");
	lblto.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblto.setBounds(56, 295, 52, 19);
	panel.add(lblto);
        
        JLabel lbldate2 = new JLabel("Date");
	lbldate2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lbldate2.setBounds(56, 139, 52, 19);
	panel.add(lbldate2);
	
	name1 = new JTextField();
	name1.setBounds(138, 32, 155, 30);
	panel.add(name1);
	name1.setColumns(10);
	
	seat1 = new JTextField();
	seat1.setColumns(10);
	seat1.setBounds(138, 84, 155, 30);
	panel.add(seat1);
	
	from1 = new JTextField();
	from1.setColumns(10);
	from1.setBounds(138, 240, 155, 30);
	panel.add(from1);
	
	to1 = new JTextField();
	to1.setColumns(10);
	to1.setBounds(138, 292, 155, 30);
	panel.add(to1);
        
        date2 = new JDateChooser();
	date2.setBounds(138, 135, 155, 30);
	panel.add(date2);
	
	bus1 = new JComboBox();
	bus1.setBounds(138, 188, 155, 30);
        bus1.setModel(new DefaultComboBoxModel(new String[] { "81", "82", "94", "95" }));
	panel.add(bus1);
	
	check = new JButton("Check");
        check.setFont(new Font("Tahoma", Font.BOLD, 14));
	check.setBounds(310, 182, 90, 40);
        check.addActionListener(this);
	panel.add(check);
        
        add = new JButton("Book Ticket");
	add.setFont(new Font("Tahoma", Font.BOLD, 14));
	add.setBounds(310, 290, 150, 40);
        add.addActionListener(this);
	panel.add(add);
	
	cancel = new JButton("Cancel Ticket");
	cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
	cancel.setBounds(310, 345, 150, 40);
        cancel.addActionListener(this);
	panel.add(cancel);
        
        back = new JButton("Back");
	back.setFont(new Font("Tahoma", Font.BOLD, 14));
	back.setBounds(410, 25, 85, 40);
        back.addActionListener(this);
	panel.add(back);
        
        
        setVisible(true);
        
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            if(bus1.getSelectedItem()=="81"){
                from1.setText("Pune");
                to1.setText("Banglore");
            }else if(bus1.getSelectedItem()=="82"){
                from1.setText("Banglore");
                to1.setText("Chennai");
            }else if(bus1.getSelectedItem()=="94"){
                from1.setText("Mumbai");
                to1.setText("Nagpur");
            }else if(bus1.getSelectedItem()=="95"){
                from1.setText("Nagpur");
                to1.setText("Nashik");
                
                
                
            }}
        else if(ae.getSource()==add){
            String name = name1.getText();
            int seats = Integer.parseInt(seat1.getText());
            String busno =  bus1.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(date2.getDate());
            String from = from1.getText();
            String to = to1.getText();
            String status = "Booked";
            try{
                                        
                    Conn c = new Conn();
                    String query1 = "DELETE FROM busbook WHERE seats='"+seats+"'";
                    String query4 = "DELETE FROM seat WHERE seats='"+seats+"'";
                    String query2 = "insert into busbook(busno,seats,passanger,froma,tob) values('"+busno+"','"+seats+"','"+name+"','"+from+"','"+to+"')";
                    String query3 = "insert into seat(busno,status,seats,date) values('"+busno+"','"+status+"','"+seats+"','"+date+"')";
                    c.s.executeUpdate(query1);
                    c.s3.executeUpdate(query4);
                    c.s1.executeUpdate(query2);
                    c.s2.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "Seat Booked Successfully!");
                    
                                                       
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            
            
            
        }else if(ae.getSource()==cancel){
            String name = "empty";
            int seats = Integer.parseInt(seat1.getText());
            String busno =  bus1.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(date2.getDate());
            String from = from1.getText();
            String to = to1.getText();
            String status = "UnBooked";
            try{
                                        
                    Conn c = new Conn();
                    String query1 = "DELETE FROM busbook WHERE seats='"+seats+"'";
                    String query4 = "DELETE FROM seat WHERE seats='"+seats+"'";
                    String query2 = "insert into busbook(busno,seats,passanger,froma,tob) values('"+busno+"','"+seats+"','"+name+"','"+from+"','"+to+"')";
                    String query3 = "insert into seat(busno,status,seats,date) values('"+busno+"','"+status+"','"+seats+"','"+date+"')";
                    c.s.executeUpdate(query1);
                    c.s3.executeUpdate(query4);
                    c.s1.executeUpdate(query2);
                    c.s2.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "Cancellation Successfull!");
                    
                                                       
                }catch(Exception e){
                    e.printStackTrace();
                }

        }else if(ae.getSource()==back){
          setVisible(false);

        }
    }
    
    public static void main(String[] args) {
        new BookBus();
    }
}
