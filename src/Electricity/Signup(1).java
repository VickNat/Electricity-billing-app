package Electricity;

import com.mysql.cj.log.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name;
    JPasswordField password;

    Signup(){
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 213, 230), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel heading = new JLabel("Create account as");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tohama", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);



        JLabel lblMeter = new JLabel("Meter number");
        lblMeter.setBounds(100, 90, 140, 20);
        lblMeter.setForeground(Color.GRAY);
        lblMeter.setFont(new Font("Tohama", Font.BOLD, 14));
        lblMeter.setVisible(false);
        panel.add(lblMeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {

            }

            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.stmt.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while (rs.next()){
                        name.setText(rs.getString("name"));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(100, 130, 140, 20);
        lblUsername.setForeground(Color.GRAY);
        lblUsername.setFont(new Font("Tohama", Font.BOLD, 14));
        panel.add(lblUsername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tohama", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tohama", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JPasswordField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        accountType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String user = accountType.getSelectedItem();
                if(user.equals("Customer")){
                    lblMeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else {
                    lblMeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this::actionPerformed);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this::actionPerformed);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/SignUp.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String aType = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();

            try {
                Conn c = new Conn();

                String query = null;
                if(aType.equals("Admin")) {

                   query=  "insert into login values('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + aType + "')";
                } else {
                    query = "update login set username = '" + susername + "', password = '"+spassword+"', user = '"+aType+"' where meter_no = '"+smeter+"'";
                }
                c.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account created successfully.");

                setVisible(false);
                new Login();
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);

            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
