package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Collector {
    DcMotorEx collectorMotor;

    public Collector(HardwareMap hwMap, Telemetry telemetry) {
        collectorMotor = hwMap.get(DcMotorEx.class, "collectorMotor");
        collectorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        collectorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        collectorMotor.setDirection(DcMotor.Direction.FORWARD); //change direction if needed
        collectorMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorPower(double power) {
        collectorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        collectorMotor.setPower(power);
    }

    public void setMotorPosition(int position, double power) {
        collectorMotor.setPower(power);
        collectorMotor.setTargetPosition(position);
        collectorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void stopMotor() {
        setMotorPower(0);
    }
}