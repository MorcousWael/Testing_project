package classes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

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
        public void correctNum() throws Exception {
            assertEquals(UserObj.EnterCardNumber("49461112131415"), true);
            assertEquals(UserObj.EnterCardNumber("49462122232426"), true);
            assertEquals(UserObj.EnterCardNumber("49463132333437"), true);
            assertEquals(UserObj.EnterCardNumber("49464142434445"), true);
            assertEquals(UserObj.EnterCardNumber("51585152535455"), true);
            assertEquals(UserObj.EnterCardNumber("51586162636465"), true);
            assertEquals(UserObj.EnterCardNumber("51587172737475"), true);
        }
    }
    @Nested
    class cardNunFail{
        @Test
        public void wrongNum() throws Exception {
            assertEquals(UserObj.EnterCardNumber("4946111213141"), false);
            assertEquals(UserObj.EnterCardNumber("79462122232426"), false);
            assertEquals(UserObj.EnterCardNumber("89468132333437"), false);
            assertEquals(UserObj.EnterCardNumber("22464142434445"), false);
            assertEquals(UserObj.EnterCardNumber("51585652535455"), false);
            assertEquals(UserObj.EnterCardNumber("51586162636257"), false);
            assertEquals(UserObj.EnterCardNumber("51127172737475"), false);
        }
    }

    @AfterEach
    public void clean(){
        UserObj= null;
    }
}