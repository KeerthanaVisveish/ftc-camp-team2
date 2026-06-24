package org.firstinspires.ftc.teamcode.util;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;

public class DriveToPoint implements Action {
    double targetX, targetY, targetHeading;
    double toleranceAxial = 3, toleranceLateral = 3, toleranceHeading = Math.toRadians(5);
    PIDController axialController = new PIDController(0.25, 0, 0);
    PIDController lateralController = new PIDController(0.25, 0, 0);
    PIDController headingController = new PIDController(1.0, 0, 0);
    ElapsedTime timer = new ElapsedTime();
    Telemetry telemetry;
    MecanumDrive drive;

    public DriveToPoint(MecanumDrive drive, Telemetry telemetry, double targetX, double targetY, double targetHeading) {
        this.drive = drive;
        this.telemetry = telemetry;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetHeading = targetHeading;

        axialController.setInputBounds(-72, 72);
        lateralController.setInputBounds(-72, 72);
        headingController.setInputBounds(-2 * Math.PI, 2 * Math.PI);

        axialController.setOutputBounds(-1, 1);
        lateralController.setOutputBounds(-1, 1);
        headingController.setOutputBounds(-1, 1);
        timer.reset();
    }

    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        drive.updatePoseEstimate();

        double worldXPosition = drive.localizer.getPose().position.x;
        double worldYPosition = drive.localizer.getPose().position.y;
        double worldAngle_rad = drive.localizer.getPose().heading.toDouble();

        double forwardError = targetX - worldXPosition;
        double lateralError = targetY - worldYPosition;
        double distanceError = Math.hypot(forwardError, lateralError);
        double distanceTolerance = Math.hypot(toleranceAxial, toleranceLateral);

        axialController.setTarget(targetX);
        lateralController.setTarget(targetY);

        double forwardOutput = -axialController.update(worldXPosition);
        double lateralOutput = -lateralController.update(worldYPosition);

        double headingError = normalizeAngle(targetHeading - worldAngle_rad);
        headingController.setTarget(0);
        double turnPower = headingController.update(headingError);

        double sin = Math.sin(worldAngle_rad);
        double cos = Math.cos(worldAngle_rad);
        double robotForward = forwardOutput * cos + lateralOutput * sin;
        double robotStrafe = -forwardOutput * sin + lateralOutput * cos;

        updateDrivetrain(robotForward, robotStrafe, turnPower);

        boolean isRunning = distanceError > distanceTolerance ||
                (Math.abs(normalizeAngle(targetHeading - worldAngle_rad)) > toleranceHeading);

        telemetry.addData("isRunning", isRunning);
        telemetry.addData("Target X (forward)", targetX);
        telemetry.addData("Target Y (lateral)", targetY);
        telemetry.addData("Pos X (forward)", worldXPosition);
        telemetry.addData("Pos Y (lateral)", worldYPosition);
        telemetry.addData("Heading", worldAngle_rad);
        telemetry.addData("robotForward", robotForward);
        telemetry.addData("robotStrafe", robotStrafe);
        telemetry.addData("turnPower", turnPower);

        if (!isRunning) updateDrivetrain(0, 0, 0);
        return isRunning;
    }

    private double normalizeAngle(double angle) {
        while (angle > Math.PI) angle -= 2 * Math.PI;
        while (angle < -Math.PI) angle += 2 * Math.PI;
        return angle;
    }

    public void updateDrivetrain(double xPower, double yPower, double turnPower){
        drive.setDrivePowers(new PoseVelocity2d(new Vector2d(xPower, yPower), turnPower));
    }
}