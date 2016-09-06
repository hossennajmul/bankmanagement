package bank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferForm extends JFrame{
    private JPanel panel;
    private JLabel labelFrom, labelTo, labelAmount;
    private JButton buttonTransfer;
    private JTextField textFrom, textTo, textAmount;
    public TransferForm() {
        initializecomponents();
    }

    private void initializecomponents() {
        panel = new JPanel();
        panel.setLayout(null);

        labelFrom = new JLabel("From");
        labelFrom.setBounds(30, 30, 100, 20);
        panel.add(labelFrom);

        labelTo = new JLabel("To");
        labelTo.setBounds(30, 70, 100, 20);
        panel.add(labelTo);

        labelAmount = new JLabel("Amount");
        labelAmount.setBounds(30, 110, 100, 20);
        panel.add(labelAmount);

        textFrom = new JTextField();
        textFrom.setBounds(140, 30, 100, 20);
        panel.add(textFrom);

        textTo = new JTextField();
        textTo.setBounds(140, 70, 100, 20);
        panel.add(textTo);

        textAmount = new JTextField();
        textAmount.setBounds(140, 110, 100, 20);
        panel.add(textAmount);

        buttonTransfer = new JButton("Transfer");
        buttonTransfer.setBounds(150, 150, 100, 20);
        panel.add(buttonTransfer);
        buttonTransfer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DataAccess da = new DataAccess();
                int s4=Integer.parseInt(textAmount.getText().toString().trim());
                int s5=Integer.parseInt(textTo.getText().toString().trim());
                int s6=Integer.parseInt(textFrom.getText().toString().trim());


                String sql13="update account set acountbalance=accountbalance +'"+s4+ "' where accountno   ='"+s5+"'";
                String sql14="update account set accountbalance=accountbalance - '"+s4+ "' where accountno   ='"+s6+"'";
                da.executeSQL(sql13);
                da.executeSQL(sql14);

                JOptionPane.showMessageDialog(null, "Successfully Transfer");
            }
        });

        this.add(panel);
        this.setSize(300, 300);


    }

}

