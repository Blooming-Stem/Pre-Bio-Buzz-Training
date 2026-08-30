package org.firstinspires.ftc.teamcode.GamePadControls;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.RADIANS;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class NewDriveIMUSetup {

        //private DcMotor backIntake,frontRight ,frontIntake,backRight,leftFlywheel,rightFlywheel,backLeft,frontLeft;
        private DcMotor frontRight,backRight,backLeft,frontLeft;

    private Servo back_servo;
        private IMU imu;
        public void init(HardwareMap hardwareMap){
            /* front_leftMotor = hardwareMap.get(DcMotor.class, "front_left_motor");
            front_rightMotor = hardwareMap.get(DcMotor.class, "front_right_motor");
            back_leftMotor = hardwareMap.get(DcMotor.class, "back_left_motor");
            back_rightMotor = hardwareMap.get(DcMotor.class, "back_right_motor");
            back_servo = hardwareMap.get(Servo.class, "back_servo");


            enc_right = hardwareMap.get(DcMotor.class, "enc_right");
            enc_left = hardwareMap.get(DcMotor.class, "enc_left");
            enc_x = hardwareMap.get(DcMotor.class, "enc_x");
/*
            front_leftMotor.setDirection(DcMotor.Direction.REVERSE);
            back_leftMotor.setDirection(DcMotor.Direction.REVERSE);

            front_leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            front_rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            back_leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            back_rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

*/

            /*enc_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            enc_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            enc_x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            enc_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            enc_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            enc_x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);*/

            //backIntake = hardwareMap.get(DcMotor.class, "backIntake");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            //frontIntake = hardwareMap.get(DcMotor.class, "frontIntake");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            //leftFlywheel = hardwareMap.get(DcMotor.class, "leftFlywheel");
            //rightFlywheel = hardwareMap.get(DcMotor.class, "rightFlywheel");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");

            //backIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //frontIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //leftFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //rightFlywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            imu = hardwareMap.get(IMU.class, "imu");

            RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                    RevHubOrientationOnRobot.LogoFacingDirection.UP,
                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
            imu.initialize(new IMU.Parameters(RevOrientation));
        }
        public void drive(double forward, double strafe, double rotate){
            double frontLeftPower = forward + strafe + rotate;
            double backLeftPower = forward - strafe + rotate;
            double frontRightPower = forward - strafe - rotate;
            double backRightPower = forward + strafe - rotate;

            double maxPower = 1.0;
            double maxSpeed = 1.0;

            //maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
            //backIntake.setPower(maxSpeed * (frontLeftPower / maxPower));

            maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
            frontRight.setPower(maxSpeed * (frontLeftPower / maxPower));

            //maxPower = Math.max(maxPower, Math.abs(backLeftPower));
            //frontIntake.setPower(maxSpeed * (backLeftPower / maxPower));

            maxPower = Math.max(maxPower, Math.abs(frontRightPower));
            backRight.setPower(maxSpeed * (frontRightPower / maxPower));

            //maxPower = Math.max(maxPower, Math.abs(backRightPower));
            //leftFlywheel.setPower(maxSpeed * (backRightPower / maxPower));

            //maxPower = Math.max(maxPower, Math.abs(backRightPower));
            //rightFlywheel.setPower(maxSpeed * (backRightPower / maxPower));

            maxPower = Math.max(maxPower, Math.abs(backRightPower));
            backLeft.setPower(maxSpeed * (backRightPower / maxPower));

            maxPower = Math.max(maxPower, Math.abs(backRightPower));
            frontLeft.setPower(maxSpeed * (backRightPower / maxPower));

            //Servo setting need help
        }


        public void driveFieldRelavetive(double forward, double strafe, double rotate) {
            double theta = Math.atan2(forward, strafe);
            double r = Math.hypot(strafe, forward);

            theta = AngleUnit.normalizeRadians(theta);
            imu.getRobotYawPitchRollAngles().getYaw(RADIANS);

            double newForward = r * Math.sin(theta);
            double newStrafe = r * Math.cos(theta);

            this.drive(newForward, newStrafe, rotate);
        }
       /*public int getLeftEncoder() {
            return enc_left.getCurrentPosition();
        }


        public int getRightEncoder() {
            return enc_right.getCurrentPosition();
        }


        public int getXEncoder() {
            return enc_x.getCurrentPosition();
        }*/


        public double getHeading() {

            return imu
                    .getRobotYawPitchRollAngles()
                    .getYaw(DEGREES);
        }


}
