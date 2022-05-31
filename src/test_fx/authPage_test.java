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
public class authPage_test{

    private Button button;
    private Button authLogin;
    private Button authSignup;


    @Nested
    public class test_signup_button {
        @Start
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/authPage.fxml"));
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }

        @Test
        void Signup_contain_right_text(FxRobot robot) {
            verifyThat("#authSignup", LabeledMatchers.hasText("Signup"));
        }

        @Test
        void when_button_is_clicked_scene_changes(FxRobot robot) {
            // when:
            robot.clickOn("#authSignup");
            // then: since we switched scene the we can get the value for the submit button in the signup.fxml scene.
            verifyThat("#Submit_button", LabeledMatchers.hasText("Submit"));
        }

        @Nested
        public class test_login_button {
            @Start
            public void start(Stage primaryStage) throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/authPage.fxml"));
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.show();
            }
            @Test
            void login_contain_right_text(FxRobot robot) {
                verifyThat("#authLogin", LabeledMatchers.hasText("Login"));
            }
            @Test
            void when_button_is_clicked_alert_show(FxRobot robot) {
                // when:
                robot.clickOn("#authUser");
                robot.write("marc");
                robot.clickOn("#authPass");
                robot.write("marcx1233");
                robot.clickOn("#authLogin");
                // then: since we switched scene the we can get the value for the submit button in the signup.fxml scene.
                verifyThat("#TransferLabel", LabeledMatchers.hasText("Transfer"));
            }
        }
    }
}
