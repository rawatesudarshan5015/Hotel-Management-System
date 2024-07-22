package hotel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton btnNewCustomerForm, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnManagerInfo, btnNewButton_4, btnNewButton_5, btnNewButton_6, btnPickUpSerice, btnSearchRoom, btnNewButton_7;

    public Reception(){

        setBounds(530, 200, 850, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        add(l1);

        btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        btnNewCustomerForm.addActionListener(this);
        contentPane.add(btnNewCustomerForm);

        btnNewButton = new JButton("Room");
        btnNewButton.setBounds(10, 70, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("Department");
        btnNewButton_1.setBounds(10, 110, 200, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.addActionListener(this);
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("All Employee Info");
        btnNewButton_2.setBounds(10, 150, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.addActionListener(this);
        contentPane.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Customer Info");
        btnNewButton_3.setBounds(10, 190, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);
        btnNewButton_3.addActionListener(this);
        contentPane.add(btnNewButton_3);

        btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.setBounds(10, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        btnManagerInfo.addActionListener(this);
        contentPane.add(btnManagerInfo);

        btnNewButton_4 = new JButton("Check Out");
        btnNewButton_4.setBounds(10, 270, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.addActionListener(this);
        contentPane.add(btnNewButton_4);

        btnNewButton_5 = new JButton("Update Check Status");
        btnNewButton_5.setBounds(10, 310, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.addActionListener(this);
        contentPane.add(btnNewButton_5);

        btnNewButton_6 = new JButton("Update Room Status");
        btnNewButton_6.setBounds(10, 350, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);
        btnNewButton_6.addActionListener(this);
        contentPane.add(btnNewButton_6);

        btnPickUpSerice = new JButton("Pick up Service");
        btnPickUpSerice.setBounds(10, 390, 200, 30);
        btnPickUpSerice.setBackground(Color.BLACK);
        btnPickUpSerice.setForeground(Color.WHITE);
        btnPickUpSerice.addActionListener(this);
        contentPane.add(btnPickUpSerice);

        btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.setBounds(10, 430, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        btnSearchRoom.addActionListener(this);
        contentPane.add(btnSearchRoom);

        btnNewButton_7 = new JButton("Log Out");
        btnNewButton_7.setBounds(10, 470, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);
        btnNewButton_7.addActionListener(this);
        contentPane.add(btnNewButton_7);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewCustomerForm) {
            try {
                AddCustomer custom = new AddCustomer();
                custom.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton) {
            try {
                Room room = new Room();
                room.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_1) {
            try {
                Department dept = new Department();
                dept.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_2) {
            try {
                Employee em = new Employee();
                em.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_3) {
            try {
                CustomerInfo customer = new CustomerInfo();
                customer.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnManagerInfo) {
            try {
                ManagerInfo mana = new ManagerInfo();
                mana.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_4) {
            try {
                CheckOut check = new CheckOut();
                check.setVisible(true);
                setVisible(false);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_5) {
            try {
                UpdateCheck update = new UpdateCheck();
                update.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_6) {
            try {
                UpdateRoom room = new UpdateRoom();
                room.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnPickUpSerice) {
            try {
                PickUp pick = new PickUp();
                pick.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnSearchRoom) {
            try {
                SearchRoom search = new SearchRoom();
                search.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnNewButton_7) {
            try {
                new Login().setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}
