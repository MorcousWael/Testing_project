package classes;

import java.sql.*;

public class User {
    private String name;
    private String password;
    private String email;
    static final int PASSWORD_LENGTH = 8;
    private String cardNumber;
    private int balance;
    public User(String name, String password, String email,String cardNumber) throws Exception {
        this.name = name;
        if (isValidPassword(password) == true && EnterCardNumber(cardNumber)==false) {
            System.out.println("password set correctly");
            this.password = password;  this.cardNumber=cardNumber;
        } else {
            this.password = null; throw new IllegalArgumentException();}
        this.email = email;


    }
    public User(){}
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) throws SQLException {
        this.balance = balance;
        UpdateUser();
    }
    public String getName() {

        return name;
    }
    public boolean isValidPassword(String s) {
        boolean validPassword = true;
        if (s.length()>PASSWORD_LENGTH)
        {
            for (int i =0 ; i< s.length() ;i++)
            {
                if((Character.isLetterOrDigit(s.charAt(i)) == false))
                    validPassword= false;
            }
        }
        else{ validPassword=false;}
        return validPassword;
    }
    public boolean login(String name,String password) throws Exception {
        this.name=name;this.password=password;
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        ResultSet rs= stp.executeQuery("select Users.[UserName], Users.[Password], Users.[Email], Users.[CardNumber], Users.[Balance] from Users where username='"+name+"' and password='"+password+"'");
        rs.next();
        if(name.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
            EnterCardNumber(rs.getString(4));
            return true;
        }
        else return false;

    }
    public boolean EnterCardNumber(String cardNumber) throws Exception {
       this.cardNumber=cardNumber;
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        ResultSet rs= stp.executeQuery("select Users.[UserName], Users.[Password], Users.[Email], Users.[CardNumber], Users.[Balance] from Users where CardNumber ='"+cardNumber+"'");
        rs.next();
        try {
            if(rs.getString(1)==null){
                System.out.println("failed");
                return false;}
            else {
                System.out.println("Success");
                this.name=rs.getString(1);
                this.password=rs.getString(2);
                this.email=rs.getString(3);
                this.balance=rs.getInt(5);
                return true;}
        }
        catch (Exception ar){
            return false;
        }
    }
    public boolean addNewUser() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
       if(password==null)return false;
        stp.executeUpdate("INSERT INTO users (  userName, password, email,CardNumber ) values ('"+name+"','"+password+"','"+email+"','"+cardNumber+"')");
        stp.close();
        c.close();
        return true;

    }
    public void UpdateUser() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        stp.executeUpdate("UPDATE Users SET Balance = "+this.balance+" WHERE Users.CardNumber='"+cardNumber+"'");
        stp.close();
        c.close();
    }

}