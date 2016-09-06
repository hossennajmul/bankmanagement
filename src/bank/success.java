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

public class success  extends JFrame{



    private JButton buttonAdd;
    private JButton buttonSearch;
    private JButton buttontrans;
    private JPanel panel;


    public success() {
        initializeComponents();
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(null);


        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(50, 100,120, 20);

        buttonSearch = new JButton("Search");
        buttonSearch.setBounds(200, 100,120, 20);

        buttontrans = new JButton("Transaction");
        buttontrans.setBounds(350, 100,120, 20);

        panel.add(buttonAdd);
        panel.add(buttonSearch);
        panel.add(buttontrans);
        buttonAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                AddCustomer acc=new AddCustomer();
                acc.setVisible(true);
                success.this.setVisible(false);

            }
        });

        buttontrans.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TransectionForm acct=new TransectionForm();
                acct.setVisible(true);
                success.this.setVisible(false);

            }
        });

        buttonSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Search acct=new Search();
                acct.setVisible(true);
                success.this.setVisible(false);

            }
        });


        this.add(panel);
        this.setSize(500, 400);

    }

}
