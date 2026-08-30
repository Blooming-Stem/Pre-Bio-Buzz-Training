package org.firstinspires.ftc.teamcode.Odometry;

public class RobotLocation {
    double angle;
    double x;
    double y;


    private int previousLeft = 0;
    private int previousRight = 0;
    private int previousX = 0;


    private double TICKS_PER_INCH = 2000.0;


    // Constructor
    public RobotLocation(double angle) {

        this.angle = angle;
    }

    public void updateOdometry(
            int leftEncoder,
            int rightEncoder,
            int xEncoder,
            double imuHeading) {



        int deltaLeft =
                leftEncoder - previousLeft;

        int deltaRight =
                rightEncoder - previousRight;

        int deltaXEncoder =
                xEncoder - previousX;



        previousLeft = leftEncoder;
        previousRight = rightEncoder;
        previousX = xEncoder;


        double leftDistance =
                deltaLeft / TICKS_PER_INCH;

        double rightDistance =
                deltaRight / TICKS_PER_INCH;

        double strafeDistance =
                deltaXEncoder / TICKS_PER_INCH;


        double forwardDistance =
                (leftDistance + rightDistance) / 2.0;



        angle = imuHeading;



        double headingRadians =
                Math.toRadians(angle);

        double deltaFieldX =
                strafeDistance * Math.cos(headingRadians)
                        - forwardDistance * Math.sin(headingRadians);


        double deltaFieldY =
                strafeDistance * Math.sin(headingRadians)
                        + forwardDistance * Math.cos(headingRadians);


        x += deltaFieldX;

        y += deltaFieldY;
    }


    public double getHeading() {

        double normalizedAngle = this.angle;

        while (normalizedAngle > 180) {

            normalizedAngle -= 360;
        }

        while (normalizedAngle <= -180) {

            normalizedAngle += 360;
        }

        return normalizedAngle;
    }



    public void setAngle(double angle) {

        this.angle = angle;
    }


    public double getAngle() {

        return this.angle;
    }



    public void setX(double x) {

        this.x = x;
    }


    public double getX() {

        return this.x;
    }


    public void setY(double y) {

        this.y = y;
    }


    public double getY() {

        return this.y;
    }
}
