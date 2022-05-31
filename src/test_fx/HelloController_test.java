package test_fx;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.testfx.service.finder.impl.WindowFinderImpl;

import java.io.IOException;

import static org.testfx.api.FxAssert.verifyThat;
@ExtendWith(ApplicationExtension.class)
public class HelloController_test {

    //home_page_test
    @Nested
    public class Home_page_GUI_tests {
        @Start
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
            primaryStage.setScene(new Scene(root, 993, 616));
            primaryStage.show();
        }

        @Nested
        public class Home_page_button_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
                primaryStage.setScene(new Scene(root, 993, 616));
                primaryStage.show();
            }

            @Test
            void Paybill_button_in_main_page(FxRobot robot) {
                verifyThat("#PayBillButton", LabeledMatchers.hasText("Pay Bills"));
            }

            @Test
            void Transfer_button_in_main_page(FxRobot robot) {
                verifyThat("#TransferLabel", LabeledMatchers.hasText("Transfer"));
            }

            @Test
            void Statement_button_in_main_page(FxRobot robot) {
                verifyThat("#StatementButton", LabeledMatchers.hasText("Statement"));
            }

            @Test
            void BuyItems_button_in_main_page(FxRobot robot) {
                verifyThat("#BuyItemsButton", LabeledMatchers.hasText("Buy"));
            }
        }

        //home_page
        @Nested
        public class Home_page_switch_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
                primaryStage.setScene(new Scene(root, 993, 616));
                primaryStage.show();
            }

            @Test
            void correct_switch_pay_bill(FxRobot robot) {
                //when:
                robot.clickOn("#PayBillButton");
                //then:
                verifyThat("#ElectLabel", LabeledMatchers.hasText("Electricity"));
            }

            @Test
            void correct_switch_Transfer(FxRobot robot) {
                //when:
                robot.clickOn("#TransferLabel");
                //then:
                verifyThat("#confirm_button1", LabeledMatchers.hasText("Transfer"));
            }

            @Test
            void correct_switch_Statement(FxRobot robot) {
                //when:
                robot.clickOn("#StatementButton");
                //then:
                verifyThat("#Home_button_id", LabeledMatchers.hasText("Home"));
            }

            @Test
            void correct_switch_buy_items(FxRobot robot) {
                //when:
                robot.clickOn("#BuyItemsButton");
                //then:
                verifyThat("#iphone", LabeledMatchers.hasText("iPhone 13 128GB"));
            }
        }
    }


    //TransferPage
    @Nested
    public class Transfer_page {
        @Nested
        public class Transfer_page_button_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/TransferPage.fxml"));
                primaryStage.setScene(new Scene(root, 1087, 649));
                primaryStage.show();
            }

            @Test
            void confirm_button_in_transfer_page(FxRobot robot) {
                verifyThat("#confirm_button1", LabeledMatchers.hasText("Transfer"));
            }
            @Test
            void home_button_in_transfer_page(FxRobot robot) {
                verifyThat("#home_id1", LabeledMatchers.hasText("Home"));
            }
        }
    }


    //statement page
    @Nested
    public class Statement_page {
        @Nested
        public class Transfer_page_button_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/StatementPage.fxml"));
                primaryStage.setScene(new Scene(root, 1087, 649));
                primaryStage.show();
            }
            @Test
            void home_button_in_statment_page(FxRobot robot) {
                verifyThat("#Home_button_id", LabeledMatchers.hasText("Home"));
            }
        }
    }


    //pay bills page
    @Nested
    public class Pay_bills_page {
        @Nested
        public class Transfer_page_button_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/PayBillsPage.fxml"));
                primaryStage.setScene(new Scene(root, 1087, 649));
                primaryStage.show();
            }
            @Test
            void home_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#home_id2", LabeledMatchers.hasText("Home"));
            }
            @Test
            void electricity_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#ElectLabel", LabeledMatchers.hasText("Electricity"));
            }
            @Test
            void Water_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#WaterLabel", LabeledMatchers.hasText("Water"));
            }
            @Test
            void Loans_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#LoansLabel", LabeledMatchers.hasText("Loans"));
            }
            @Test
            void Gas_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#GasLabel", LabeledMatchers.hasText("Gas"));
            }
            @Test
            void Transportation_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#TransLabel", LabeledMatchers.hasText("Transportation"));
            }
            @Test
            void Grocery_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#GroceryLabel", LabeledMatchers.hasText("Grocery"));
            }
        }
    }
    //buy itens page
    @Nested
    public class buy_items_page {
        @Nested
        public class buy_items_page_button_test {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/BuyItemsPage.fxml"));
                primaryStage.setScene(new Scene(root, 1087, 649));
                primaryStage.show();
            }
            @Test
            void mac_button_in_buy_items_page(FxRobot robot) {
                verifyThat("#Mac", LabeledMatchers.hasText("MacBook 13 inch m1"));
            }

            @Test
            void buy_i_phone_buttonin_buy_items_page(FxRobot robot) {
                verifyThat("#iphone", LabeledMatchers.hasText("iPhone 13 128GB"));
            }

            @Test
            void TV_button_in_buy_items_page(FxRobot robot) {
                verifyThat("#TV", LabeledMatchers.hasText("LG Smart tv"));
            }

            @Test
            void Ps5_button_in_buy_items_page(FxRobot robot) {
                verifyThat("#ps", LabeledMatchers.hasText("Play Station 5  "));
            }
        }
    }
}

