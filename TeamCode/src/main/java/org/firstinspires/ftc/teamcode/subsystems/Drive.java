package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {

    // Initializing Drivetrain
    public DcMotorEx frontLeft;
    public DcMotorEx backLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backRight;

    public Drive(HardwareMap hwMap, Telemetry telemetry) {

        // Defining the Motors
        frontLeft = (DcMotorEx)hwMap.dcMotor.get("FL");
        frontRight = (DcMotorEx)hwMap.dcMotor.get("FR");
        backLeft = (DcMotorEx)hwMap.dcMotor.get("BL");
        backRight = (DcMotorEx)hwMap.dcMotor.get("BR");

        // Reverse Direction if Needed
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void setDTMotorPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    public void stop() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void setDrivePowers(double y, double x, double rx) {
        frontLeft.setPower(y + x + rx); // 5 + 5
        backLeft.setPower(y - x + rx); // 5 - 5
        frontRight.setPower(y - x - rx); // 5 - 5
        backRight.setPower(y + x - rx); // 5 + 5
    }

    // takes each dir as 0 (no movement), -1, or 1 (for power)
    public void tempDrivePowers(int yDir, int xDir, double basePower) {
        if (xDir == 1) frontLeft.setPower(power);
        if (x_moved) backLeft.setPower(power);
//        if (y_moved) frontLeft.setPower(power);
//        if (y_moved) frontLeft.setPower(power);
//        if (y_moved) frontLeft.setPower(power);
    }
}