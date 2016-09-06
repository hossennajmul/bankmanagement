package bank;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class AddCustomer  extends JFrame{

    private JLabel labelCustomerName;
    private JLabel labelEmail;
    private JLabel labelPhone;
    private JLabel labelAcctype;
    private JLabel labelInitialDeposit;
    private JLabel labelUsername;
    private JLabel labelPassword;

    private JTextField textCustomerName;
    private JTextField textEmail;
    private JTextField textPhone;
    private JComboBox comboAcctype;
    private JTextField textInitialDeposit;
    private JTextField textUsername;
    private JPasswordField textPassword;

    private JButton buttonAdd;
    private JPanel panel;


    public AddCustomer() {
        initializeComponents();
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(null);

        labelCustomerName = new JLabel("Customer Name:");
        labelCustomerName.setBounds(30, 30, 150, 20);
        panel.add(labelCustomerName);

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 70, 150, 20);
        panel.add(labelEmail);

        labelPhone = new JLabel("Phone No:");
        labelPhone.setBounds(30, 110, 150, 20);
        panel.add(labelPhone);

        labelAcctype = new JLabel("Account Type:");
        labelAcctype.setBounds(30, 150, 150, 20);
        panel.add(labelAcctype);

        labelInitialDeposit = new JLabel("Initial Deposit:");
        labelInitialDeposit.setBounds(30, 190, 150, 20);
        panel.add(labelInitialDeposit);

        labelUsername = new JLabel("Username:");
        labelUsername.setBounds(30, 230, 150, 20);
        panel.add(labelUsername);

        labelPassword = new JLabel("Password:");
        labelPassword.setBounds(30, 270, 150, 20);
        panel.add(labelPassword);

        textCustomerName = new JTextField();
        textCustomerName.setBounds(200, 30, 150, 20);
        panel.add(textCustomerName);

        textEmail = new JTextField();
        textEmail.setBounds(200, 70, 150, 20);
        panel.add(textEmail);

        textPhone = new JTextField();
        textPhone.setBounds(200, 110, 150, 20);
        panel.add(textPhone);

        comboAcctype = new JComboBox(new String[]{"Current","Savings","Fixed"});
        comboAcctype.setBounds(200, 150, 150, 20);
        panel.add(comboAcctype);

        textInitialDeposit = new JTextField();
        textInitialDeposit.setBounds(200, 190, 150, 20);
        panel.add(textInitialDeposit);

        textUsername = new JTextField();
        textUsername.setBounds(200, 230, 150, 20);
        panel.add(textUsername);

        textPassword = new JPasswordField();
        textPassword.setBounds(200, 270, 150, 20);
        panel.add(textPassword);

        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(150, 310,150, 20);
        panel.add(buttonAdd);
        buttonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DataAccess da = new DataAccess();
                String s1=textCustomerName.getText().trim();
                String s2=textEmail.getText().trim();
                String s3=textPhone.getText().trim();
                int s4=Integer.parseInt(textInitialDeposit.getText().toString().trim());
                String s5=textUsername.getText().trim();
                String s6=textPassword.getText().trim();
                String s7=AddCustomer.this.comboAcctype.getSelectedItem().toString();




                String sql="INSERT INTO customer(CustomerUserName,CustomerName,CustomerPhone,CustomerEmail) VALUES ('"+s5+"','"+s1+"', '"+s3+"','"+s2+"')";
                da.executeSQL(sql);

                sql= "INSERT INTO users(UserName,Password) values('"+s5+"','"+s6+"')";
                da.executeSQL(sql);
              sql="INSERT INTO account(AccountNo,AccountType,AccountName,AccountBalance,AccountInIt ) VALUES (active_offer_sequence.nextval,'"+s7+"','"+s5+"','"+s4+"','"+s4+"')";
               da.executeSQL(sql);

                sql="INSERT INTO accountcustomer VALUES (active_offer_sequence.currval,'"+s5+"')";
                da.executeSQL(sql);
                JOptionPane.showMessageDialog(null, "A new User Has been Added");






            }
        });


        this.add(panel);
        this.setSize(500, 400);

    }

}
