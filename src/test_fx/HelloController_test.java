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
        private double xOffset = 0;
        private double yOffset = 0;

        @Start
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));

            stage.initStyle(StageStyle.TRANSPARENT);

            //grab your root here
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            //move around here
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            Scene scene = new Scene(root);
            //set transparent
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }

        @Nested
        public class Home_page_button_test {
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
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
                verifyThat("#BuyItemsButton", LabeledMatchers.hasText("Buy Items"));
            }
        }

        //home_page
        @Nested
        public class Home_page_switch_test {
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }

            @Test
            void correct_switch_pay_bill(FxRobot robot) {
                //when:
                robot.clickOn("#PayBillButton");
                //then:
                verifyThat("#ElectButton", LabeledMatchers.hasText("Electricity"));
            }

            @Test
            void correct_switch_Transfer(FxRobot robot) {
                //when:
                robot.clickOn("#TransferLabel");
                //then:
                verifyThat("#confirmButton", LabeledMatchers.hasText("Confirm"));
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
                verifyThat("#buy_i_phone", LabeledMatchers.hasText("Buy"));
            }
        }
    }


    //TransferPage
    @Nested
    public class Transfer_page {
        @Nested
        public class Transfer_page_button_test {
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }

            @Test
            void confirm_button_in_transfer_page(FxRobot robot) {
                verifyThat("#confirmButton", LabeledMatchers.hasText("Confirm"));
            }
            @Test
            void home_button_in_transfer_page(FxRobot robot) {
                verifyThat("#home_id", LabeledMatchers.hasText("Home"));
            }
        }
    }


    //statement page
    @Nested
    public class Statement_page {
        @Nested
        public class Transfer_page_button_test {
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/StatementPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
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
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/PayBillsPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            }
            @Test
            void home_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#home_id2", LabeledMatchers.hasText("Home"));
            }
            @Test
            void electricity_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#ElectButton", LabeledMatchers.hasText("Electricity"));
            }
            @Test
            void Water_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#waterButton", LabeledMatchers.hasText("Water"));
            }
            @Test
            void Loans_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#LoansButton", LabeledMatchers.hasText("Loans"));
            }
            @Test
            void Gas_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#GasButton", LabeledMatchers.hasText("Gas"));
            }
            @Test
            void Transportation_button_in_pay_bills_page(FxRobot robot) {
                verifyThat("#TransButton", LabeledMatchers.hasText("Transpportation"));
            }
        }
    }

    @Nested
    public class buy_items_page {
        @Nested
        public class buy_items_page_button_test {
            private double xOffset = 0;
            private double yOffset = 0;

            @Start
            public void start(Stage stage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/BuyItemsPage.fxml"));

                stage.initStyle(StageStyle.TRANSPARENT);

                //grab your root here
                root.setOnMousePressed(event -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                //move around here
                root.setOnMouseDragged(event -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene = new Scene(root);
                //set transparent
                scene.setFill(Color.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
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

