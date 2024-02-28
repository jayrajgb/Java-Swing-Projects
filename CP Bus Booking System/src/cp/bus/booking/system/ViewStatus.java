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
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ViewStatus extends JFrame implements ActionListener{
    
    JButton view;
    JDateChooser dateChooser;
    JTable table;
    JTextField txtname,txtseat,txtfrom,txtto,txtdate;
    ViewStatus(){
        setBounds(100,100,940,530);
        setLayout(null);
        setTitle("Bus Status");
        
        JLabel lbldate = new JLabel("Date");
	lbldate.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbldate.setBounds(200, 30, 60, 25);
	add(lbldate);
        
        
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(70, 80, 780, 360);
	add(scrollPane);
	
	table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
	Object[] column ={"Bus No.", "Seat No.", "Status", "Name", "From", "To", "Date"};
        model.setColumnIdentifiers(column);
	table.setModel(model);
	scrollPane.setViewportView(table);
        
        
	dateChooser = new JDateChooser();
	dateChooser.setBounds(250, 30, 250, 25);
	add(dateChooser);
       
        
        view = new JButton("View");
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.setBounds(530,27,120,30);
        view.addActionListener(this);
        add(view);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==view){
            Load();
            
        }
        
    }
    
    
        public void Load(){
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String date = df.format(dateChooser.getDate());
            try{
                Conn c = new Conn();
                String query = "SELECT seat.busno,seat.seats,seat.status,busbook.passanger,busbook.froma,busbook.tob,seat.date from seat Left JOIN busbook ON seat.busno = busbook.busno AND seat.seats = busbook.seats WHERE seat.date = '"+date+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                ResultSetMetaData rsd = rs.getMetaData();
                int z;
                
                z = rsd.getColumnCount();
                
                DefaultTableModel d3 = (DefaultTableModel) table.getModel();
                d3.setRowCount(0);
                
                while(rs.next()){
                    Vector v1 = new Vector();
                    
                    for(int i=1;i<=z;i++){
                        v1.add(rs.getString("busno"));
                        v1.add(rs.getString("seats"));
                        v1.add(rs.getString("status"));
                        v1.add(rs.getString("passanger"));
                        v1.add(rs.getString("froma"));
                        v1.add(rs.getString("tob"));
                        v1.add(rs.getString("date"));
                    }
                    d3.addRow(v1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    public static void main(String[] args){
        new ViewStatus();
    }

}
