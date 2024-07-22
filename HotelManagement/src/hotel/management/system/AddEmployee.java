package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfphone,tfemail,tfsalary,tfaadhar;
    JRadioButton tfmale,tffemale;
    JComboBox jbjob;
    AddEmployee(){
        setLayout(null);
    //Name
        JLabel jblname = new JLabel("NAME");
        jblname.setBounds(60,30,120,30);
        jblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
    //Age

        JLabel jblage = new JLabel("AGE");
        jblage.setBounds(60,80,120,30);
        jblage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

    //Gender

        JLabel jblgender = new JLabel("GENDER");
        jblgender.setBounds(60,130,120,30);
        jblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblgender);

        tfmale = new JRadioButton("Male");
        tfmale.setBounds(200,130,70,30);
        tfmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfmale.setBackground(Color.WHITE);
        add(tfmale);

        tffemale = new JRadioButton("Female");
        tffemale.setBounds(280,130,70,30);
        tffemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tffemale.setBackground(Color.WHITE);
        add(tffemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(tfmale);
        bg.add(tffemale);
    //JOB

        JLabel jbljob = new JLabel("JOB");
        jbljob.setBounds(60,180,120,30);
        jbljob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jbljob);

        String str[]={"Desk Clerk","Porters","Housekeeper","chefs","Room Service","Waiter","Manager","Accountant"};
        jbjob = new JComboBox(str);
        jbjob.setBounds(200,180,150,30);
        jbjob.setBackground(Color.WHITE);
        add(jbjob);

    // Salary

        JLabel jblsalary = new JLabel("SALARY");
        jblsalary.setBounds(60,230,120,30);
        jblsalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

//        Phone
        JLabel jblphone = new JLabel("PHONE");
        jblphone.setBounds(60,270,120,30);
        jblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,270,150,30);
        add(tfphone);

        // Email

        JLabel jblemail = new JLabel("EMAIL");
        jblemail.setBounds(60,310,120,30);
        jblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,310,150,30);
        add(tfemail);

//  AADHAR
        JLabel jblaadhar = new JLabel("AADHAR");
        jblaadhar.setBounds(60,350,120,30);
        jblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(jblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,350,150,30);
        add(tfaadhar);
    //Button

        JButton submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(380,60,450,370);
        add(img);



        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender =null;

        if(tfmale.isSelected()){
            gender = "Male";
        }else if(tffemale.isSelected()){
            gender = "Female";
        }

        String job = (String) jbjob.getSelectedItem();

        try{
            Conn conn = new Conn();

            String query = "insert into employee values('"+name+"','"+age+"','"+job+"','"+gender+"','"+salary+"','"+email+"','"+phone+"','"+aadhar+"')";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
