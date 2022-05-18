package classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws SQLException {
        Transactions x=new Transactions();
        x.setFirstName("Marc");
        ArrayList<Transactions>y=new ArrayList<Transactions>(x.ShowRecords());
        for(int i=0;i<y.size();i++)
            System.out.println(y.get(i));
    }
}
