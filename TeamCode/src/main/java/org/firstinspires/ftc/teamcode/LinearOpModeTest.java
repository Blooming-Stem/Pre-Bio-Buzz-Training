package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "LinearOpModeTest")
    public class LinearOpModeTest extends LinearOpMode {
        public void runOpMode() {
            telemetry.addLine("Initialized");
            telemetry.addLine("Hello FTC");
            telemetry.update();

            waitForStart();

            while (opModeIsActive()){
                telemetry.addLine("Running");
                telemetry.addLine("Hello FTC");
                telemetry.update();
            }

            telemetry.addLine("STOP");
            telemetry.update();
        }
}

