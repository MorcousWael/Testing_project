package classes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

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
    }
    @Nested
    class failCasses {

        @Test
        public void empty() {
            assertEquals(UserObj.isValidPassword(""), false);
        }
        @Test
        public void numsOnly() {
            assertEquals(UserObj.isValidPassword("12345678"), false);
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
        public void AllCapsOneNum() {
            assertEquals(UserObj.isValidPassword("@ABCDEFG2"), false);

        }








    }
    @AfterEach
    public void clean(){
        UserObj= null;
    }

    }