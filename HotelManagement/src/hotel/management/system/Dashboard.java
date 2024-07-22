package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        ImageIcon lm =  new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image l2 = lm.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon l3= new ImageIcon(l2);
        JLabel image = new JLabel(l3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel Text = new JLabel("India's Best Hotel");
        Text.setBounds(400,80,1550,50);
        Text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        Text.setForeground(Color.WHITE);
        image.add(Text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem Reception = new JMenuItem("Add Reception");
        Reception.setForeground(Color.RED);
        Reception.addActionListener(this);
        hotel.add(Reception);

        JMenu Admin = new JMenu("ADMIN");
        Admin.setForeground(Color.RED);
        mb.add(Admin);

        JMenuItem AddEmployee = new JMenuItem("Add Employee");
        AddEmployee.setForeground(Color.RED);
        AddEmployee.addActionListener(this);
        Admin.add(AddEmployee);

        JMenuItem AddDriver = new JMenuItem("Add Driver");
        AddDriver.setForeground(Color.RED);
        AddDriver.addActionListener(this);
        Admin.add(AddDriver);

        JMenuItem AddRoom = new JMenuItem("Add Room");
        AddRoom.setForeground(Color.RED);
        AddRoom.addActionListener(this);
        Admin.add(AddRoom);

        JMenuItem AddCustomer = new JMenuItem("Add Customer");
        AddCustomer.setForeground(Color.RED);
        Admin.add(AddCustomer);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getActionCommand().equals("Reception")){

        }else if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        } else if (ae.getActionCommand().equals("Add Room")) {
            new AddRoom().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Customer")) {

        } else if (ae.getActionCommand().equals("Add Driver")) {
            new AddDriver().setVisible(true);

        }
    }

    public static void main(String[] args) {

        new Dashboard();
    }
}
