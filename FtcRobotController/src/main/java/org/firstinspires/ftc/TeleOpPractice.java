package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TeleOpPractice extends OpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight, frontIntake, rightFlywheel;

    @Override
    public void init() {
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontIntake = hardwareMap.get(DcMotor.class, "frontIntake");
        rightFlywheel = hardwareMap.get(DcMotor.class, "rightFlywheel");
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFlywheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontIntake.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFlywheel.setDirection(DcMotorSimple.Direction.FORWARD);
        telemetry.addData("Initialized", "Press start");
    }


    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward + strafe - rotate;
        double frontRightPower = forward - strafe + rotate;
        double backRightPower = forward - strafe - rotate;

        double max = Math.max(
                1.0,
                Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(backLeftPower),
                        Math.max(Math.abs(frontRightPower), Math.abs(backRightPower)))));

        frontLeftPower /= max;
        backLeftPower /= max;
        frontRightPower /= max;
        backRightPower /= max;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);

        if (gamepad1.a) {
            frontIntake.setPower(0.5);
        }
        else if (gamepad1.b) {
            frontIntake.setPower(0);
        }
        else if (gamepad1.x) {
            rightFlywheel.setPower(0.5);
        }
        else if (gamepad1.y) {
            rightFlywheel.setPower(0);
        }
    }
}