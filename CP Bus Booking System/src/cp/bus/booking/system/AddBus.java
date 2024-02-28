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
import javax.swing.table.DefaultTableModel;

public class AddBus extends JFrame implements ActionListener{
    JButton add,delete,check,cancel;
    JComboBox bus1;
    JDateChooser date2;
    JTextField from1,to1;
    AddBus(){
	setBounds(100, 100, 650, 450);
	setLayout(null);
        
        setTitle("Assign Bus");
        
        JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Assign Bus", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(40, 40, 550, 330);
        panel.setLayout(null);
	add(panel);
        
        
	
	JLabel lblbus = new JLabel("Bus No.");
	lblbus.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblbus.setBounds(56, 87, 52, 19);
	panel.add(lblbus);
	
	JLabel lblfrom = new JLabel("From");
	lblfrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblfrom.setBounds(56, 139, 52, 19);
	panel.add(lblfrom);
	
	JLabel lblto = new JLabel("To");
	lblto.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lblto.setBounds(56, 191, 52, 19);
	panel.add(lblto);
        
        JLabel lbldate2 = new JLabel("Date");
	lbldate2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	lbldate2.setBounds(56, 35, 52, 19);
	panel.add(lbldate2);

	
	from1 = new JTextField();
	from1.setColumns(10);
	from1.setBounds(138, 135, 155, 30);
	panel.add(from1);
	
	to1 = new JTextField();
	to1.setColumns(10);
	to1.setBounds(138, 188, 155, 30);
	panel.add(to1);
        
        date2 = new JDateChooser();
	date2.setBounds(138, 32, 155, 30);
	panel.add(date2);
	
	bus1 = new JComboBox();
	bus1.setBounds(138, 84, 155, 30);
        bus1.setModel(new DefaultComboBoxModel(new String[] { "81", "82", "94", "95" }));
	panel.add(bus1);
        
        add = new JButton("Add Seats");
	add.setFont(new Font("Tahoma", Font.BOLD, 14));
	add.setBounds(75, 245, 120, 40);
        add.addActionListener(this);
	panel.add(add);
        
        delete = new JButton("Delete Seats");
	delete.setFont(new Font("Tahoma", Font.BOLD, 14));
	delete.setBounds(230, 245, 135, 40);
        delete.addActionListener(this);
	panel.add(delete);
	
	check = new JButton("Check");
        check.setFont(new Font("Tahoma", Font.BOLD, 14));
	check.setBounds(310, 130, 90, 40);
        check.addActionListener(this);
	panel.add(check);
	
	cancel = new JButton("Cancel");
	cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
	cancel.setBounds(400, 245, 85, 40);
        cancel.addActionListener(this);
	panel.add(cancel);
        
        
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
            String name = "empty";
            String busno =  bus1.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(date2.getDate());
            String from = from1.getText();
            String to = to1.getText();
            String status = "UnBooked";
            for(int i = 1;i<=20;i++){
                int seats = i;
            try{
                                        
                    Conn c = new Conn();
                    String query1 = "insert into busbook(busno,seats,passanger,froma,tob) values('"+busno+"','"+seats+"','"+name+"','"+from+"','"+to+"')";
                    String query2 = "insert into seat(busno,status,seats,date) values('"+busno+"','"+status+"','"+seats+"','"+date+"')";
                    c.s.executeUpdate(query1);
                    c.s1.executeUpdate(query2);
                    
                                                       
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
                        JOptionPane.showMessageDialog(null, "Seats Added!");
                    
            
            
            
        }else if(ae.getSource()==delete){
            
            String busno =  bus1.getSelectedItem().toString();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(date2.getDate());
           
            
            try{
                                        
                    Conn c = new Conn();
                    String query1 = "DELETE busbook.*, seat.* FROM seat LEFT JOIN busbook ON busbook.busno = '"+busno+"' AND seat.date = '"+date+"'";
                    c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null, "Seats Deleted!");
                        setVisible(false);
                    
                                                       
                }catch(Exception e){
                    e.printStackTrace();
                }
            
        }else if(ae.getSource()==cancel){
          setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddBus();
    }
}
