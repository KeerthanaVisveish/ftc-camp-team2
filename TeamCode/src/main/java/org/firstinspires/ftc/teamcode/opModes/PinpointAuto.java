package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.BrainSTEMRobot;
import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;
import org.firstinspires.ftc.teamcode.util.AutoCommands;
import org.firstinspires.ftc.teamcode.util.DriveToPoint;

@Autonomous (name = "Pinpoint Auto")
public class PinpointAuto extends LinearOpMode {

    private BrainSTEMRobot robot;
    private MecanumDrive drive;
    private AutoCommands autoCommands;
    private Pose2d startPose = new Pose2d(new Vector2d(61.5, -64.5), Math.toRadians(180));

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(hardwareMap, telemetry, this);
        drive = new MecanumDrive(hardwareMap, startPose);
        autoCommands = new AutoCommands(robot, telemetry);

        waitForStart();

        Actions.runBlocking(
                new SequentialAction(
                        new DriveToPoint(drive, telemetry, -50, -56, Math.toRadians(180)),
                )   new DriveToPoint(drive, telemetry, -50, -56, Math.toRadians(180))
        );
    }
}