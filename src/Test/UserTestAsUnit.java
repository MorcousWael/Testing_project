package Test;

import classes.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTestAsUnit {
    @Nested
    class ValidityTests{
        @Nested
    class EnterCardUserTest {

        User UserObj ;
        @BeforeEach
        public void init(){
            UserObj= new User();
        }

        @Nested
        class cardNunPass{
            @Test
            public void correctNum0() throws Exception{assertEquals(UserObj.EnterCardNumber("49461112131415"), true);}
            @Test
            public void correctNum1() throws Exception{ assertEquals(UserObj.EnterCardNumber("49462122232426"), true);}
            @Test
            public void correctNum2() throws Exception{assertEquals(UserObj.EnterCardNumber("49463132333437"), true);}
            @Test
            public void correctNum3() throws Exception{assertEquals(UserObj.EnterCardNumber("49464142434445"), true);}
            @Test
            public void correctNum4() throws Exception{ assertEquals(UserObj.EnterCardNumber("51585152535455"), true);}
            @Test
            public void correctNum5() throws Exception{assertEquals(UserObj.EnterCardNumber("51586162636465"), true);}
            @Test
            public void correctNum6() throws Exception { assertEquals(UserObj.EnterCardNumber("51587172737475"), true); }
        }
        @Nested
        class cardNunFail{
            @Test
            public void wrongNum0() throws Exception {assertEquals(UserObj.EnterCardNumber("4946111213141"), false);}
            @Test
            public void wrongNum1() throws Exception {assertEquals(UserObj.EnterCardNumber("79462122232426"), false);}
            @Test
            public void wrongNum2() throws Exception {assertEquals(UserObj.EnterCardNumber("89468132333437"), false);}
            @Test
            public void wrongNum3() throws Exception { assertEquals(UserObj.EnterCardNumber("22464142434445"), false);}
            @Test
            public void wrongNum4() throws Exception { assertEquals(UserObj.EnterCardNumber("51585652535455"), false);}
            @Test
            public void wrongNum5() throws Exception {assertEquals(UserObj.EnterCardNumber("51586162636257"), false);}
            @Test
            public void wrongNum6() throws Exception { assertEquals(UserObj.EnterCardNumber("51127172737475"), false); }
        }

        @AfterEach
        public void clean(){
            UserObj= null;
        }
    }
        @Nested
        class UserPasswordTest_IsValid {

            User UserObj ;

            @BeforeEach
            public void init(){
                UserObj= new User();
            }
            @Nested
            class passCasses {

                @Test
                public void normal() {
                    assertEquals(UserObj.isValidPassword("1234567h"), true);
                }
                @Test
                public void normalAndLetters() {
                    assertEquals(UserObj.isValidPassword("12345hfgk"), true);
                }
                @Test
                public void capsAndNums() {
                    assertEquals(UserObj.isValidPassword("AJK4343K2"), true);
                }
                @Test
                public void numsOnly() {
                    assertEquals(UserObj.isValidPassword("12345678"), true);
                }
            }
            @Nested
            class failCasses {

                @Test
                public void empty() {
                    assertEquals(UserObj.isValidPassword(""), false);
                }

                @Test
                public void numsOnlyLssThan8() {
                    assertEquals(UserObj.isValidPassword("1234567"), false);
                }

                @Test
                public void lessThan8() {
                    assertEquals(UserObj.isValidPassword("223344a"), false);
                }

                @Test
                public void negative() {
                    assertEquals(UserObj.isValidPassword("-12345678k"), false);
                }
                @Test
                public void speacialCharcters1() {
                    assertEquals(UserObj.isValidPassword("@4567ggg"), false);
                }
                @Test
                public void speacialCharcters2() {
                    assertEquals(UserObj.isValidPassword("39567as#"), false);
                }
                @Test
                public void AllCapsNoNum() {
                    assertEquals(UserObj.isValidPassword("@ABBCDEFG"), false);
                }
                @Test
                public void speacialCharcters3() {
                    assertEquals(UserObj.isValidPassword("@ABCDEFG2"), false);

                }








            }
            @AfterEach
            public void clean(){
                UserObj= null;
            }

        }
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
                public void incorrectPassword() {
                    try {
                        assertEquals(x.login("philo", "phil1234"), false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                    @Test
                public void incorrectUsernameAndPassword(){
                    try {
                        assertEquals(x.login("nrmaluser","normalser2"),false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @AfterEach
            public void clean(){
                x=null;
            }
        }}

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
                //to delete the user
                Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
                Statement stp = c.createStatement();
                stp.executeUpdate("DELETE from Users where UserName='"+y.getName()+"'");
                stp.close();
                c.close();
            }
            @Test
            public void adding_user2() throws Exception {
                User y = new User("Dummy2","Dummy31234","19P@eng.asu.edu","49123302453213");
                y.addNewUser();
                assertEquals (x.EnterCardNumber("49123302453213"), true);
                //to delete the user
                Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
                Statement stp = c.createStatement();
                stp.executeUpdate("DELETE from Users where UserName='"+y.getName()+"'");
                stp.close();
                c.close();
            }
        }
            }
        }