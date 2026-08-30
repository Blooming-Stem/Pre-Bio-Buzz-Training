package org.firstinspires.ftc.teamcode.Odometry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GamePadControls.NewDriveIMUSetup;

@TeleOp(name = "Odometry")
public class OdometryTest extends OpMode{
    RobotLocation robotLocation =
            new RobotLocation(0);
    /*DriveIMUSetup driveIMUSetup =
            new DriveIMUSetup();*/
    NewDriveIMUSetup newDriveIMUSetUp =
            new NewDriveIMUSetup();


    double forward;
    double strafe;
    double rotate;


    @Override
    public void init() {

        robotLocation.setAngle(0);
        robotLocation.setX(0);

        robotLocation.setY(0);

        newDriveIMUSetUp.init(hardwareMap);


        telemetry.addLine("Odometry Initialized");
        telemetry.update();
    }


    @Override
    public void loop() {

        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        newDriveIMUSetUp.driveFieldRelavetive(forward, strafe, rotate);


        //int leftEncoder = newDriveIMUSetUp.getLeftEncoder();
        //int rightEncoder = newDriveIMUSetUp.getRightEncoder();
        //int xEncoder = newDriveIMUSetUp.getXEncoder();

        telemetry.addData("X",robotLocation.getX());
        telemetry.addData("Y",robotLocation.getY());
        telemetry.addData("Heading",robotLocation.getHeading());


        double heading = newDriveIMUSetUp.getHeading();


        robotLocation.updateOdometry(leftEncoder, rightEncoder, xEncoder, heading);


        telemetry.addData("X", robotLocation.getX());
        telemetry.addData("Y", robotLocation.getY());
        telemetry.addData("Heading", robotLocation.getHeading());
        //telemetry.addData("Left Encoder", leftEncoder);
        //telemetry.addData("Right Encoder", rightEncoder);
        //telemetry.addData("X Encoder", xEncoder);

        telemetry.addData("forward", forward);
        telemetry.addData("strafe", strafe);
        telemetry.addData("rotate", rotate);
        telemetry.update();
    }
}

