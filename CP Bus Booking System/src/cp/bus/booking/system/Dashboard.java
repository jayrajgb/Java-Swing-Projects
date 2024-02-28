
package cp.bus.booking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton Details,addDetails,viewBus,bookBus,logout;
    
    Dashboard(String username){
        this.username = username;
        setBounds(0,0,1200,750);
        setLayout(null);
        setTitle("Dashboard");
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(144, 238, 144));
        p1.setBounds(0,0,1200,70);
        add(p1);
        
        JLabel title = new JLabel ("DASHBOARD");
        title.setBounds(40,12,250,40);
        title.setForeground(Color.BLACK);
        title.setFont(new Font ("Segoe UI",Font.BOLD,30));
        p1.add(title);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(144, 238, 144));
        p2.setBounds(0,70,250,750);
        add(p2);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("CP/Bus/Booking/System/icons/dash.jpg"));
        Image i1 = c1.getImage().getScaledInstance(935, 645,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(250, 70, 935, 645);
        add(l6);
        
        Details = new JButton("Passanger Details");
        Details.setBounds(0,0,250,50);
        Details.setBackground(Color.BLACK);
        Details.setForeground(Color.WHITE);
        Details.setFont(new Font("Segoe UI",Font.PLAIN,20));
        Details.addActionListener(this);
        p2.add(Details);
        
             
        addDetails = new JButton("Add Details");
        addDetails.setBounds(0,50,250,50);
        addDetails.setBackground(Color.BLACK);
        addDetails.setForeground(Color.WHITE);
        addDetails.setFont(new Font("Segoe UI",Font.PLAIN,20));
        addDetails.addActionListener(this);
        p2.add(addDetails);

        
        viewBus = new JButton("View Buses");
        viewBus.setBounds(0,100,250,50);
        viewBus.setBackground(Color.BLACK);
        viewBus.setForeground(Color.WHITE);
        viewBus.setFont(new Font("Segoe UI",Font.PLAIN,20));
        viewBus.addActionListener(this);
        p2.add(viewBus);
        
        bookBus = new JButton("Book/Cancel Ticket");
        bookBus.setBounds(0,150,250,50);
        bookBus.setBackground(Color.BLACK);
        bookBus.setForeground(Color.WHITE);
        bookBus.setFont(new Font("Segoe UI",Font.PLAIN,20));
        bookBus.addActionListener(this);
        p2.add(bookBus);
        
        logout = new JButton("Logout");
        logout.setBounds(0,200,250,50);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Segoe UI",Font.PLAIN,20));
        logout.addActionListener(this);
        p2.add(logout);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addDetails){
            new AddPassanger(username).setVisible(true);
        }
        else if(ae.getSource() == Details){
            new ViewPassanger(username).setVisible(true);
            
        }else if(ae.getSource() == viewBus){
            new ViewStatus().setVisible(true);
            
        }else if(ae.getSource() == bookBus){
            new BookBus().setVisible(true);
            
        }else if(ae.getSource() == logout){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        


    }
    
    public static void main(String[] args){
        new Dashboard("").setVisible(true);
    }
}
