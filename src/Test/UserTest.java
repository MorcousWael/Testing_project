package Test;

import classes.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    @Nested
    class login{
        User x;
        @BeforeEach
        public void init(){
            x=new User();
        }
        @Nested
        class Successfully{
            @Test
            public void test1(){
                try {
                    assertEquals(x.login("marc","marcx1233"),true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void test2(){
                try {
                    assertEquals(x.login("marc2","asdasdasdasd"),true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void test3(){
                try {
                    assertEquals(x.login("normaluser","normaluser2"),true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void test4(){
                try {
                    assertEquals(x.login("philo","philo1234"),true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        @Nested
        class failed{
            @Test
            public void noUsername(){
                try {
                    assertEquals(x.login("","marcx1233"),false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void noPassword(){
                try {
                    assertEquals(x.login("marc2",""),false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void incorrectUsername(){
                try {
                    assertEquals(x.login("nrmaluser","normaluser2"),false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Test
            public void incorrectPassword(){
                try {
                    assertEquals(x.login("philo","phil1234"),false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        @AfterEach
        public void clean(){
            x=null;
        }
    }
    @Nested
    class UserAsUnit {
        User x;
        @BeforeEach
        public void init() throws Exception {
            x = new User();
            x.EnterCardNumber("123412567451234");
        }
        @Nested
        class balanceAdjustment{
            @Test
        public void adjust_in_Balance1() throws SQLException {
            x.setBalance(129);
            assertEquals (x.getBalance(), 129);
        }
            @Test
            public void adjust_in_Balance2() throws SQLException {
                x.setBalance(1000);
                assertEquals (x.getBalance(), 1000);
            }
            @Test
            public void adjust_in_Balance3() throws SQLException {
                x.setBalance(20323);
                assertEquals (x.getBalance(), 20323);
            }
        }
       @Nested
       class BalanceBoundaries{
           @Test
           public void balance_Accepted1() throws SQLException {
               assertEquals (x.setBalance(1), true);
           }
           @Test
           public void balance_Accepted2() throws SQLException {
               assertEquals (x.setBalance(1000), true);
           }
            @Test
       public void balance_cannot_be_negative1() throws SQLException {
           assertEquals (x.setBalance(-12300), false);
       }
           @Test
           public void balance_cannot_be_negative2() throws SQLException {
               assertEquals (x.setBalance(-1), false);
           }
           @Test
           public void acceptZero() throws SQLException{
                assertEquals(x.setBalance(0),true);
           }
        }
        @Nested
        class addUser{
            @Test
            public void adding_user1() throws Exception {
                User y = new User("Dummy","Dummy1234","19P3041@eng.asu.edu","49123302323213");
                y.addNewUser();
                assertEquals (x.EnterCardNumber("49123302323213"), true);
            }
            @Test
            public void adding_user2() throws Exception {
                User y = new User("Dummy2","Dummy31234","19P@eng.asu.edu","49123302453213");
                y.addNewUser();
                assertEquals (x.EnterCardNumber("49123302453213"), true);
            }
        }

            }
        }