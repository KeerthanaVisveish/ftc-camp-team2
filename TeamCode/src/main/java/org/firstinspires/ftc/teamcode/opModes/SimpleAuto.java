package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.util.AutoCommands;
import org.firstinspires.ftc.teamcode.BrainSTEMRobot;

@Autonomous (name = "Simple Auto")
public class SimpleAuto extends LinearOpMode {

    private BrainSTEMRobot robot;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);
        AutoCommands autoCommands = new AutoCommands(robot, telemetry);

        waitForStart();

        Actions.runBlocking(
            new SequentialAction(
                autoCommands.driveRobot(0.4, 1.3),
                autoCommands.strafeRobot(-0.65, 1.25),
                    autoCommands.driveRobot(.4,2),
                    autoCommands.strafeRobot(.25,6.5),
                    autoCommands.driveRobot(.4,1.9)
            )
        );
    }
}