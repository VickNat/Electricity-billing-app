package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {

    String aType,meter;
    Project(String aType,String meter){
        JFrame projectWindow = new JFrame();
        this.meter = meter;
        this.aType = aType;
        setSize(700,600);
        setLocation(300,50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Electricity.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);


        JMenu master = new JMenu("master");
        master.setForeground(Color.BLUE);


        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newCustomer.setBackground(Color.WHITE);
        newCustomer.setMnemonic('D');
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        newCustomer.addActionListener(this::actionPerformed);
        master.add(newCustomer);

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerDetails.setBackground(Color.WHITE);
        customerDetails.setMnemonic('M');
        customerDetails.addActionListener(this::actionPerformed);
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        master.add(customerDetails);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositDetails.setBackground(Color.WHITE);
        depositDetails.setMnemonic('N');
        depositDetails.addActionListener(this::actionPerformed);
        depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(depositDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculateBill.setBackground(Color.WHITE);
        calculateBill.setMnemonic('B');
        calculateBill.addActionListener(this::actionPerformed);
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        master.add(calculateBill);

        JMenuItem deleteInformation = new JMenuItem("Delete Customer");
        deleteInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        deleteInformation.setBackground(Color.WHITE);
        deleteInformation.setMnemonic('X');
        deleteInformation.addActionListener(this::actionPerformed);
        deleteInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        master.add(deleteInformation);


        JMenu info = new JMenu("Information");
        info.setForeground(Color.RED);


        JMenuItem updateInformation = new JMenuItem("Update Information");
        updateInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateInformation.setBackground(Color.WHITE);
        updateInformation.setMnemonic('U');
        updateInformation.addActionListener(this);
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateInformation);

        JMenuItem viewInformation = new JMenuItem("View Information");
        viewInformation.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewInformation.setBackground(Color.WHITE);
        viewInformation.setMnemonic('V');
        viewInformation.addActionListener(this);
        viewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(viewInformation);

        JMenu user = new JMenu("User");
        user.setForeground(Color.BLACK);


        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        payBill.setBackground(Color.WHITE);
        payBill.setMnemonic('C');
        payBill.addActionListener(this);
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        user.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        billDetails.setBackground(Color.WHITE);
        billDetails.setMnemonic('Z');
        billDetails.addActionListener(this);
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        user.add(billDetails);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.BLUE);


        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generateBill.setBackground(Color.WHITE);
        generateBill.setMnemonic('G');
        generateBill.addActionListener(this);
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);


        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        notepad.setMnemonic('P');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculator.setBackground(Color.WHITE);
        calculator.setMnemonic('O');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        utility.add(calculator);

        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.BLACK);


        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.setBackground(Color.WHITE);
        exit.setMnemonic('E');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        mexit.add(exit);
        if(aType.equals("Admin")) {
            mb.add(master);
        }else {
            mb.add(info);
            mb.add(user);
            mb.add(report);

        }
        mb.add(utility);
        mb.add(mexit);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {

            new NewCustomer();
        } else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }
        else if (msg.equals("Deposit Details")) {
            new DepositDetails();

        } else if (msg.equals("Calculate Bill")) {

            new CalculateBill();
        } else if(msg.equals("View Information")){
            setVisible(false);
            new ViewInformation(meter);
        } else if(msg.equals("Update Information")){
            setVisible(false);
            new UpdateInformation(meter);
        } else if(msg.equals("Bill Details")){
            setVisible(false);
            new BillDetails(meter);
        } else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(msg.equals("Exit")){
            setVisible(false);
            new Login();
        } else if(msg.equals("Pay Bill")){
            setVisible(false);
            new PayBill(meter);
        } else if(msg.equals("Generate Bill")){
            new GenerateBill(meter);
        } else if(msg.equals("Delete Customer")){

            new DeleteCustomer(meter);
        }
    }

    public static void main(String[] args) {
        new Project("","");
    }
}
