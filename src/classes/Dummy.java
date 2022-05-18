package classes;

import java.sql.*;

public class Dummy {
    int Balance;
    String Name="Dummy";
    public int getBalance() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb");
        Statement stp = c.createStatement();
        ResultSet rs = stp.executeQuery("SELECT Users.[UserName], Users.[Password], Users.[Email], Users.[CardNumber], Users.[Balance]\n" +
                "FROM Users\n" +
                "WHERE (((Users.[UserName])='"+Name+"'));");
        rs.next();

        this.Balance =rs.getInt(5);

        return this.Balance;


    }
    public void setBalance(int Balance) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        stp.executeUpdate("UPDATE Users SET Balance = "+Balance+" WHERE Users.UserName='"+Name+"'");
        stp.close();
        c.close();

    }

    public String getName() {
        return Name;
    }

    public static Boolean IsAvalibleDummy(Dummy me, int Amount){
        return true;

    }
    public  void SetBalance() {

    }

    public void setName(String name) {
        Name = name;
    }
}
