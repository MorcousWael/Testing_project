package Test;

        import classes.Items;
        import org.junit.jupiter.api.Test;
        import java.sql.SQLException;
        import static org.junit.jupiter.api.Assertions.assertEquals;


        public class GetPriceTest {
        @Test
            public void Found() throws SQLException{
            assertEquals(Items.getPrice("Dummy"),10000);
        }


        }
