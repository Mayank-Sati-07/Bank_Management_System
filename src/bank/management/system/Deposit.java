package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1, b2;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("ENETR AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,400,35);
        l3.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amountTxt = textField.getText().trim();

            if (e.getSource() == b1) {
                if (amountTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter the Amount you want to Deposit");
                    return;
                }

                double amount = Double.parseDouble(amountTxt);

                Con c = new Con();
                Connection conn = c.connection;

                String sql = "INSERT INTO bank (pin, date, type, amount) "
                        + "VALUES (?, ?, 'Deposit', ?)";



                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, pin);

                    ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                    ps.setDouble(3, amount);

                    System.out.println("SQL-DEBUG → " + ps);
                    ps.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Rs. " + amount + " Deposited Successfully");

                setVisible(false);
                new main_Class(pin);

            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
                    null,
                    "Amount must be a number");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Deposit("");
    }
}
