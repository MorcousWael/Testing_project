package Test;

import classes.Transactions;
import classes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Integration_Test_between_USER_TRANSACTIONS {
    @Nested
    public class TransferBillUnitTest {
        User user1;
        @BeforeEach
        public void init() throws Exception {
            user1=new User();
            user1.EnterCardNumber("49461112131415");
        }
        @Nested
        class AcceptedBill {
            @Test
            public void Test1() throws SQLException {
                assertEquals(Transactions.TransferBill(user1, 1234, "Electricity"), true);
            }

            @Test
            public void Test2() throws SQLException {
                assertEquals(Transactions.TransferBill(user1,2000,"Electricity"),true);
            }
            @Test
            public void Test3() throws SQLException {
                assertEquals(Transactions.TransferBill(user1,0,"Electricity"),false);
            }
            @Test
            //Boundary (Exactly the Balance we have)
            public void Test4() throws SQLException {
                assertEquals(Transactions.TransferBill(user1,720,"Electricity"),true);
            }
        }
        @Nested
        class FailedBill{
            @Test
            public void Test1() throws SQLException {
                assertEquals(Transactions.TransferBill(user1,1000000000,"Electricity"),false);
            }
            @Test
            public void Test2() throws SQLException {
                assertEquals(Transactions.TransferBill(user1,2000000000,"Electricity"),false);
            }
        }
    }
    @Nested
    public class TransferBankUnitTest {
        User user1;
        @BeforeEach
        public void init() throws Exception {
            user1=new User();
            user1.EnterCardNumber("49461112131415");
        }
        @Nested
        class AcceptedBankTransfer {
            @Test
            public void Test1() throws SQLException {
                assertEquals(Transactions.TransferBank(user1, 2500), true);
            }

            @Test
            public void Test2() throws SQLException {
                assertEquals(Transactions.TransferBank(user1,60000000),false);
            }
            @Test
            public void Test3() throws SQLException {
                assertEquals(Transactions.TransferBank(user1,0),false);
            }
            @Test
            //Boundary (Exactly the Balance we have)
            public void Test4() throws SQLException {
                assertEquals(Transactions.TransferBank(user1,7000),true);
            }
        }
        @Nested
        class FailedBankTransfer{
            @Test
            public void Test1() throws SQLException{
                assertEquals(Transactions.TransferBank(user1,10000000),false);
            }
            @Test
            public void Test2() throws SQLException{
                assertEquals(Transactions.TransferBank(user1,3000000),false);
            }
            @Test
            public void Test3() throws SQLException{
                assertEquals(Transactions.TransferBank(user1,0),false);
            }
            @Test
            public void Test4() throws SQLException{
                assertEquals(Transactions.TransferBank(user1,-400),false);
            }

        }
    }
    @Nested
    public class TransferTest {
        User user1, user2;
        int balance2;
        @BeforeEach
        public void init() throws Exception {
            user1=new User();
            user2 =new User();
            user1.EnterCardNumber("49461112131415");
            user2.EnterCardNumber("49462122232426");
            balance2=user2.getBalance();
        }
        @Nested
        class SuccesfulTest{
            @Test
            public void NormalTest() throws SQLException{
                Transactions.Transfer(user1, user2,1500);
                assertEquals(user2.getBalance(),balance2+1500);
            }
            @Test
            public void ZeroinputTest() throws SQLException{
                Transactions.Transfer(user1, user2,0);
                assertEquals(user2.getBalance(), user2.getBalance());


            }
            @Test
            public void Negativeinput() throws SQLException{
                Transactions.Transfer(user1, user2,-234);
                assertEquals(user2.getBalance(), user2.getBalance());

            }

        }
        @Nested
        class FailedTest{
            @Test
            public void InsufficiantBalanceTest() throws SQLException{
                Transactions.Transfer(user1, user2,30000000);
                assertEquals(user2.getBalance(), user2.getBalance());
            }
            @Test
            public void ZeroinputTest() throws SQLException{
                Transactions.Transfer(user1, user2,0);
                assertEquals(user2.getBalance(), user2.getBalance());


            }
            @Test
            public void Negativeinput() throws SQLException{
                Transactions.Transfer(user1, user2,-234);
                assertEquals(user2.getBalance(), user2.getBalance());
            }

        }


    }

}
