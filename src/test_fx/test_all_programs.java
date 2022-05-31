package test_fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

import static org.testfx.api.FxAssert.assertContext;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
public class test_all_programs {
    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/authPage.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void Signup_contain_right_text(FxRobot robot) throws InterruptedException {

        robot.clickOn("#authUser");
        robot.write("marc");
        robot.clickOn("#authPass");
        robot.write("marcx1233");
        robot.clickOn("#authLogin");
        robot.clickOn("#PayBillButton");
        robot.clickOn("#ElectButton");
        robot.clickOn("#GasButton");
        robot.clickOn("#home_id2");
        robot.clickOn("#TransferLabel");
        robot.clickOn("#transid_1");
        robot.write("12345678912345");
        robot.clickOn("#transid_2");
        robot.write("normaluser");
        robot.clickOn("#confirmButton");
        robot.clickOn("#home_id");
        robot.clickOn("#StatementButton");
        robot.clickOn("#Home_button_id");
        robot.clickOn("#BuyItemsButton");
        robot.clickOn("#buy_mac");

    }
}
