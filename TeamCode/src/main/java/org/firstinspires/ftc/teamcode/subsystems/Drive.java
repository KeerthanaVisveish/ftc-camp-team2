package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {

    // Initializing Drivetrain
    public DcMotorEx frontLeft;
    public DcMotorEx backLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backRight;

    public double powerMultiplier = 1.0;

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
        double calcY = y * powerMultiplier;
        double calcX = x * powerMultiplier;
        double calcRX = rx * powerMultiplier;
        frontLeft.setPower(calcY+ calcX+ calcRX); // 5 + 5
        backLeft.setPower(calcY- calcX+ calcRX); // 5 - 5
        frontRight.setPower(calcY- calcX- calcRX); // 5 - 5
        backRight.setPower(calcY+ calcX- calcRX); // 5 + 5
    }
}