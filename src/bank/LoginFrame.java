package bank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame
{
    private JPanel panel;
    private JLabel labelUser, labelPassword;
    private JTextField textUser;
    private JPasswordField textPassword;
    private JButton buttonLogin, buttonExit;
    public static String s;
    public LoginFrame()
    {
        initializeComponents();
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(null);

        labelUser = new JLabel("Username");
        labelUser.setBounds(30, 30, 100, 20);
        panel.add(labelUser);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(30, 70, 100, 20);
        panel.add(labelPassword);

        textUser = new JTextField();
        textUser.setBounds(150, 30, 100, 20);
        panel.add(textUser);

        textPassword = new JPasswordField();
        textPassword.setBounds(150, 70, 100, 20);
        panel.add(textPassword);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(150, 110, 100, 20);
        panel.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DataAccess da = new DataAccess();
                String sql = "SELECT * FROM users WHERE UserName ='"+textUser.getText()+"' AND Password ='"+textPassword.getText()+"'";
                //s=textUser.getText().toString();
                ResultSet rs = da.getResultSet(sql);

                try {
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null, rs.getString("UserName"));
                        s=rs.getString("UserName");
                        //System.out.println(s);
                        //AddCustomer ac = new AddCustomer();
                        //ac.setVisible(true);
                        success su=new success();
                        su.setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });


        buttonExit = new JButton("Exit");
        buttonExit.setBounds(30, 110, 100, 20);
        panel.add(buttonExit);
        buttonExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(panel);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



}

