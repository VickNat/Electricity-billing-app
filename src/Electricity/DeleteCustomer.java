package Electricity;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener{

   Choice tfmeter;
   JLabel tfname;
   JButton delete,cancel;
   String meter;

    DeleteCustomer(String meter){
        this.meter = meter;
        setSize(600, 300);
        setLocation(500, 200);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Delete Customer");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeterno = new JLabel(" Meter number");
        lblmeterno.setBounds(50, 60, 100, 20);
        p.add(lblmeterno);

        tfmeter = new Choice();
        tfmeter.setBounds(150,60,150,20);
        p.add(tfmeter);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,110,100,20);
        p.add(lblname);

        tfname = new JLabel("");
        tfname.setBounds(150,110,150,20);
        p.add(tfname);


        try {
            Conn c  = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from customer");
            while(rs.next()) {
                tfmeter.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tfmeter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.stmt.executeQuery("select * from customer where meter_no = '"+tfmeter.getSelectedItem()+"'");
                    if(rs.next()){
                        String name = rs.getString("name");
                        tfname.setText(name);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });









        delete = new JButton("Delete");
        delete.setBounds(70,180,100,25);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        p.add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,180,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete-user.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            String meter = tfmeter.getSelectedItem();

            String query1 = "delete from customer where meter_no = '"+meter+"'";
            String query2 = "delete from login where meter_no = '"+meter+"'";

            try{
                Conn c = new Conn();
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer deleted successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new DeleteCustomer("");
    }
}
