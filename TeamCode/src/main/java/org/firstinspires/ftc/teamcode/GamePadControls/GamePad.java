package org.firstinspires.ftc.teamcode.GamePadControls;

import android.app.AutomaticZenRule;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMapping;

@TeleOp(name ="GamePad")
public class GamePad extends OpMode {
    NewDriveIMUSetup driveIMUSetup;

    double forward, strafe, rotate;

    public GamePad(){
        NewDriveIMUSetup driveIMUSetup;
    }

    @Override
    public void init() {
        driveIMUSetup = new NewDriveIMUSetup();

        driveIMUSetup.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        telemetry.addData("forward", forward);
        telemetry.addData("strafe", strafe);
        telemetry.addData("rotate", rotate);

        driveIMUSetup.driveFieldRelavetive(forward,strafe,rotate);
        checkButtonPressed(gamepad1.a , "A button");
        checkButtonPressed(gamepad1.b, "B button");
        checkButtonPressed(gamepad1.x, "X button");
        checkButtonPressed(gamepad1.y, "Y button");
    }

    public void checkButtonPressed(boolean gamepadButton, String buttonName){
        if (gamepadButton) {
            telemetry.addData(buttonName, "Pressed!");
        }
        else{
            telemetry.addData(buttonName, "NOT Pressed");
        }
        telemetry.addData("A Button State", gamepadButton);
    }
}
