package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BrainSTEMRobot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "ProgramOp")
public class ProgramOp extends LinearOpMode {

    private BrainSTEMRobot robot;

    @Override
    public void runOpMode() throws InterruptedException {

//        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);
//
//        waitForStart();
//
//        while (opModeIsActive()) {
//
//            double y = -gamepad1.left_stick_y;
//            double x = gamepad1.left_stick_x;
//            double rx = gamepad1.right_stick_x;
//
//            int yMotion = getPowerMulti(y);
//
//            boolean yMoved = Math.abs(y) >= 10;
//
//
//            robot.drive.setDrivePowers(y, x, rx);
//
//            telemetry.addData("y move: ", yMotion);
//            telemetry.addData("x move: ", xMotion);
//            telemetry.update();
//        }
    }

//    private int getPowerMulti(double movement) {
//        boolean moved = Math.abs(movement) >= 10;
//
//        if (!moved) return 0;
//        if (movement > 0) {
//            return
//        }
//    }
}