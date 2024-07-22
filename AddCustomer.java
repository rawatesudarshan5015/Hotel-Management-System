package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t5, t6;
    JComboBox<String> comboBox;
    JRadioButton r1, r2;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddCustomer frame = new AddCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddCustomer() {
        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 14);
        contentPane.add(lblId);

        comboBox = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        comboBox.setBounds(271, 73, 150, 20);
        contentPane.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 111, 200, 14);
        contentPane.add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        contentPane.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        contentPane.add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where available = 'Available'");
            while (rs.next()) {
                c1.add(rs.getString("room"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);

        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 316, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 359, 200, 14);
        contentPane.add(lblDeposite);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                String radio = null;

                if (r1.isSelected()) {
                    radio = "Male";
                } else if (r2.isSelected()) {
                    radio = "Female";
                }

                String s6 = c1.getSelectedItem();

                try {
                    String s1 = (String) comboBox.getSelectedItem();
                    String s2 = t1.getText();
                    String s3 = t2.getText();
                    String s4 = radio;
                    String s5 = t3.getText();
                    String s7 = t5.getText();
                    String s8 = t6.getText();

                    if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s7.isEmpty() || s8.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all the fields");
                        return;
                    }

                    String q1 = "insert into customer values(?, ?, ?, ?, ?, ?, ?, ?)";
                    String q2 = "update room set available = 'Occupied' where room = ?";

                    try (PreparedStatement pst1 = c.c.prepareStatement(q1);
                         PreparedStatement pst2 = c.c.prepareStatement(q2)) {
                        pst1.setString(1, s1);
                        pst1.setString(2, s2);
                        pst1.setString(3, s3);
                        pst1.setString(4, s4);
                        pst1.setString(5, s5);
                        pst1.setString(6, s6);
                        pst1.setString(7, s7);
                        pst1.setString(8, s8);
                        pst1.executeUpdate();

                        pst2.setString(1, s6);
                        pst2.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Database Error: " + e1.getMessage());
                    e1.printStackTrace();
                } catch (NumberFormatException s) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
