package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class AutoCommands {
    BrainSTEMRobot robot;
    Telemetry telemetry;
    private ElapsedTime runtime = new ElapsedTime();

    public AutoCommands(BrainSTEMRobot robot, Telemetry telemetry) {
        this.robot = robot;
        this.telemetry = telemetry;
    }

    public Action driveRobot(double power, double time) {
        return packet -> {
            runtime.reset();
            robot.drive.setDTMotorPowers(power, power, power, power);
            while (runtime.seconds() < time);
            robot.drive.stop();
            return false;
        };
    }

    public Action turnRobotRight(double power, double time) {
        return packet -> {
            runtime.reset();
            robot.drive.setDTMotorPowers(power, -power, power, -power);
            while (runtime.seconds() < time);
            robot.drive.stop();
            return false;
        };
    }

    public Action turnRobotLeft(double power, double time) {
        return packet -> {
            runtime.reset();
            robot.drive.setDTMotorPowers(-power, power, -power, power);
            while (runtime.seconds() < time);
            robot.drive.stop();
            return false;
        };
    }
}