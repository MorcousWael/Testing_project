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
public class SignupController_test {
    @Start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/Signup.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Test
    void Submit_contain_right_text(FxRobot robot) {
        verifyThat("#Submit_button", LabeledMatchers.hasText("Submit"));
    }

    @Test
    void when_button_is_clicked_scene_changes(FxRobot robot) {
        robot.clickOn("#SignUp1");
        robot.write("osaloveShisFriends123");
        robot.clickOn("#SignUp2");
        robot.write("12345678osa");
        robot.clickOn("#SignUp3");
        robot.write("osa1osa@yahoo.com");
        robot.clickOn("#SignUp4");
        robot.write("12345678912345");
        // when:
        robot.clickOn("#Submit_button");
        // then: since we switched scene the we can get the value for the submit button in the signup.fxml scene.
        verifyThat("#Submit_button", LabeledMatchers.hasText("Submit"));
    }

}
