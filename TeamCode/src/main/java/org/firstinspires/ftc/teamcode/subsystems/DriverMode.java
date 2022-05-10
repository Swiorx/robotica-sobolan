package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(group = "driver")
public class DriverMode extends LinearOpMode {
    private Robot robot = null;
    private final double STICK_TRESHOLD = 0.1;
    private double inputForward, inputSteer, outputLeft, outputRight, speed = 1;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()){
            if(gamepad1.left_stick_y <= STICK_TRESHOLD && gamepad1.left_stick_y >= -STICK_TRESHOLD ) inputForward = 0;
            else inputForward = gamepad1.left_stick_y;
            if(gamepad1.right_stick_x <= STICK_TRESHOLD && gamepad1.right_stick_x >= -STICK_TRESHOLD ) inputSteer = 0;
            else inputSteer = gamepad1.right_stick_x;

            if(inputSteer == 0) {
                outputRight = inputForward;
                outputLeft = inputForward;
            }
            if(inputSteer > 0){
                outputLeft = inputForward;
                outputRight = inputForward - inputSteer * inputForward;
            }
            if(inputSteer < 0){
                outputRight = inputForward;
                outputLeft = inputForward + inputSteer * inputForward;
            }
            if(inputForward == 0)
            {
                robot.mergatoare.setMotorPowers(-inputSteer, inputSteer, speed);
            }

            robot.mergatoare.setMotorPowers(outputLeft, outputRight, speed);

        }
    }
}
