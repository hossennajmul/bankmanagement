package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransectionForm extends JFrame {
    private JPanel panel;
    private JLabel labelAmount;
    private JLabel labelAccno;
    private JLabel labelCustName;
    private JLabel labelAccType;
    private JLabel labelAccno1;
    private JLabel labelCustName1;
    private JLabel labelAccType1;
    private JLabel LabelTransection;
    private JTextField textAmount;
    private JComboBox comboTransection;
    private JButton buttonConfirm;
    private int no;
    private String ttype;
    public TransectionForm() {
        initializeComponents();
    }

    private void initializeComponents() {
        panel = new JPanel();
        panel.setLayout(null);

        labelAccno = new JLabel("Account No:");
        labelAccno.setBounds(30, 30, 100, 20);
        panel.add(labelAccno);

        labelCustName = new JLabel("Customer Name:");
        labelCustName.setBounds(30, 70, 100, 20);
        panel.add(labelCustName);

        labelAccType = new JLabel("Account Type:");
        labelAccType.setBounds(30, 110, 100, 20);
        panel.add(labelAccType);

        LabelTransection = new JLabel("Transection Type:");
        LabelTransection.setBounds(30, 150, 120, 20);
        panel.add(LabelTransection);

        labelAmount = new JLabel("Amount:");
        labelAmount.setBounds(30, 190, 100, 20);
        panel.add(labelAmount);

        DataAccess da = new DataAccess();
        String sql="Select accno from accountcustomer where acc_cust_no='"+LoginFrame.s+"'";



        ResultSet rs = da.getResultSet(sql);

        try {
            if(rs.next())
            {
                no=rs.getInt("accountno");
                System.out.println(no);
            }
            else
            {
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }





        labelAccno1 = new JLabel(""+no);
        labelAccno1.setBounds(150, 30, 200, 20);
        panel.add(labelAccno1);

        labelCustName1 = new JLabel(LoginFrame.s);
        labelCustName1.setBounds(150, 70, 200, 20);
        panel.add(labelCustName1);


        String sql1="Select accounttype from Account where accountno='"+no+"'";

        ResultSet rs1 = da.getResultSet(sql1);

        try {
            if(rs1.next())
            {
                ttype=rs1.getString("accounttype");
                //System.out.println(no);
            }
            else
            {
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }






        labelAccType1 = new JLabel(""+ttype);
        labelAccType1.setBounds(150, 110, 200, 20);
        panel.add(labelAccType1);

        comboTransection = new JComboBox(new String[]{"Deposit","Withdraw"});
        comboTransection.setBounds(150, 150, 100, 20);
        panel.add(comboTransection);


        textAmount = new JTextField();
        textAmount.setBounds(150, 190, 100, 20);
        panel.add(textAmount);

        buttonConfirm = new JButton("Confirm");
        buttonConfirm.setBounds(160, 230, 80, 20);
        panel.add(buttonConfirm);

        this.add(panel);
        this.setSize(400,400);


        buttonConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int s4=Integer.parseInt(textAmount.getText().toString().trim());

                int reply=JOptionPane.showConfirmDialog(null, "Are u sure?", "Confiramtion",JOptionPane.YES_NO_OPTION);
                if(reply==JOptionPane.YES_OPTION)
                {

                    if((String)comboTransection.getSelectedItem()=="Deposit")
                    { String sql13="update account set accountbalance=accountbalance +'"+s4+ "' where accountno ='"+no+"'";
                        da.executeSQL(sql13);


                    }
                    else if((String)comboTransection.getSelectedItem()=="Withdraw")
                    {
                        String sql4 = "update account set accountbalance=accountbalance-'"+s4+"' where accountbalance='"+no+"'";
                        da.executeSQL(sql4);
                    }


                }

                //int dialogResult = JOptionPane.showConfirmDialog (null, "Transfer Balance?","Warning",dialogButton);


            }
        });













    }

}

