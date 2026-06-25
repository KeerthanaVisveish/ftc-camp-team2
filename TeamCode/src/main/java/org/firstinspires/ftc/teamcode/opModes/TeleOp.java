package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BrainSTEMRobot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {

    private BrainSTEMRobot robot;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);

        waitForStart();

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

//            boolean dPadDown = gamepad1.dpadDownWasPressed();
//            boolean dPadUp = gamepad1.dpadUpWasPressed();
            float rTrigger = gamepad1.right_trigger; // ?

            robot.drive.setDrivePowers(y, x, rx);

            if (rTrigger) {
                robot.drive.powerMultiplier = .5;
            } else {
                robot.drive.powerMultiplier = 1;
            }

//            if (dPadDown) {
//                robot.drive.powerMultiplier -= .1;
//            }
//            if (dPadUp) {
//                robot.drive.powerMultiplier += .1;
//            }
//
//            double p = robot.drive.powerMultiplier;
//            if (p >= 1) {
//                robot.drive.powerMultiplier = 1;
//            } else if (p <= .1) {
//                robot.drive.powerMultiplier =
//            }

            telemetry.addData("y-axis :", y);
            telemetry.addData("x-axis :", x);
            telemetry.addData("turn :", rx);
            telemetry.update();
        }
    }
}