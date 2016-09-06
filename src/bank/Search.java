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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

//import net.proteanit.sql.DbUtils;

import java.sql.*;

public class Search  extends JFrame{

    JTable table;

    private JButton buttonAdd;
    private JButton buttonSearch;
    private JButton buttontrans;
    private JPanel panel;
    private JTextField v;
    private JLabel lvl1;
    private JLabel lvl2;
    private JLabel lvl3;
    private JTextField lvl4;
    private JTextField lvl5;
    private JTextField lvl6;
    private String s1,s2,s3;

    public Search() {
        initializeComponents();
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(null);



        JComboBox comboAcctype = new JComboBox(new String[]{"By Name","By Id"});
        comboAcctype.setBounds(50, 100,120, 20);
        panel.add(comboAcctype);

        JTextField v = new JTextField();
        v.setBounds(200, 100,120, 20);
        panel.add(v);

        JButton b=new JButton("Search");
        b.setBounds(350, 100,120, 20);
        panel.add(b);

        lvl1=new JLabel("Customer Name");
        lvl1.setBounds(100, 150,100, 20);
        panel.add(lvl1);

        lvl2=new JLabel("Email");
        lvl2.setBounds(100, 190,100, 20);
        panel.add(lvl2);

        lvl3=new JLabel("Phone");
        lvl3.setBounds(100, 230,100, 20);
        panel.add(lvl3);

        lvl4=new JTextField("");
        lvl4.setBounds(220, 150,100, 20);
        panel.add(lvl4);

        lvl5=new JTextField("");
        lvl5.setBounds(220, 190,100, 20);
        panel.add(lvl5);

        lvl6=new JTextField("");
        lvl6.setBounds(220, 230,100, 20);
        panel.add(lvl6);



        b.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a)
            {
                String selection = comboAcctype.getSelectedItem().toString();
                if(selection=="By Name") {
                    DataAccess da = new DataAccess();
                    String sql = "select * from Customer  where CustomerUserName ='" + v.getText() + "' ";
                    ResultSet rs = da.getResultSet(sql);
                    try {
                        if (rs.next()) {
                            s1 = rs.getString("CustomerName");
                            lvl4.setText(s1);
                            s2 = rs.getString("CustomerEmail");
                            lvl5.setText(s2);
                            s3 = rs.getString("CustomerUserName");
                            lvl6.setText(s3);
                        } else {
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }


                }

             else{
                    DataAccess da = new DataAccess();
                    String sql ="select * from customer where CustomerPhone='"+v.getText()+"'";
                    ResultSet rs = da.getResultSet(sql);
                    try{
                        if(rs.next()){
                            lvl4.setText(rs.getString("CustomerName"));
                            lvl5.setText(rs.getString("CustomerEmail"));
                            lvl6.setText(rs.getString("CustomerUserName"));

                        }
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }


        });


        this.add(panel);
        this.setSize(500, 400);

    }

}