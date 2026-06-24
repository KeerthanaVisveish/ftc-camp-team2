package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drive;

public class BrainSTEMRobot {

    // Initializing Subsystems
    public Drive drive;

    // Don't Touch These
    public Telemetry telemetry;
    public OpMode opMode;

    public BrainSTEMRobot(HardwareMap hwMap, Telemetry telemetry, OpMode opMode) {

        this.telemetry = telemetry;
        this.opMode = opMode;

        drive = new Drive(hwMap, telemetry);
    }
}