package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "HardwareMapping")
public class HardwareMapping extends OpMode {
    DcMotor front_rightMotor;
    DcMotor front_leftMotor;
    DcMotor back_rightMotor;
    DcMotor back_leftMotor;
    DcMotor intakeMotor;
    DcMotor enc_right;
    DcMotor enc_left;
    DcMotor enc_x;
    Servo back_servo;

    DcMotor backIntake;
    DcMotor frontRight;
    DcMotor frontIntake;
    DcMotor backRight;
    DcMotor leftFlywheel;
    DcMotor rightFlywheel;
    DcMotor backLeft;
    DcMotor frontLeft;




    @Override
    public void init() {

    }

    @Override
    public void loop() {
        System.out.print("test");
        //front_leftMotor = hardwareMap.get(DcMotor.class, "front_left_motor");
        //front_rightMotor = hardwareMap.get(DcMotor.class, "front_right_motor");
        //back_leftMotor = hardwareMap.get(DcMotor.class, "back_left_motor");
        //back_rightMotor = hardwareMap.get(DcMotor.class, "back_right_motor");
        //back_servo = hardwareMap.get(Servo.class, "back_servo");
        //enc_right = hardwareMap.get(DcMotor.class, "enc_right");
        //enc_left = hardwareMap.get(DcMotor.class, "enc_left");
        //enc_x = hardwareMap.get(DcMotor.class, "enc_x");
        backIntake = hardwareMap.get(DcMotor.class, "backIntake");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontIntake = hardwareMap.get(DcMotor.class, "frontIntake");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        leftFlywheel = hardwareMap.get(DcMotor.class, "leftFlywheel");
        rightFlywheel = hardwareMap.get(DcMotor.class, "rightFlywheel");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");





        telemetry.addLine("Hardware initialized");
        telemetry.update();
    }
}
