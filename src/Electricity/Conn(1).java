package Electricity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement stmt;
    Conn(){
        try {

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricalBillingSystem", "root", "leuldb1994");
            stmt = c.createStatement();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
