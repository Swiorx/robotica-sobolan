package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(group = "driver")
public class DriverMode extends LinearOpMode {
    private Robot robot = null;
//    private final double STICK_TRESHOLD = 0.1;
//    private double inputForward, inputSteer, outputLeft, outputRight, speed = 1;

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
//
        while (opModeIsActive()){
            if(gamepad1.right_trigger > 0){
                robot.mergatoare.putereStanga(gamepad1.right_trigger);
                robot.mergatoare.putereDreapta(gamepad1.right_trigger);
            }
            if(gamepad1.left_trigger < 0){
                robot.mergatoare.putereStanga(gamepad1.left_trigger);
                robot.mergatoare.putereDreapta(gamepad1.left_trigger);
            }
            if((gamepad1.left_trigger == 0) && (gamepad1.right_trigger == 0)){
                robot.mergatoare.setMotorPowers(0, 0);
            }
            if(gamepad1.left_stick_x < 0 ){
                robot.mergatoare.putereStanga(gamepad1.left_stick_x - 0.3);
                robot.mergatoare.putereDreapta(gamepad1.left_stick_x);
            }
            if(gamepad1.left_stick_x > 0 ){
                robot.mergatoare.putereStanga(gamepad1.left_stick_x);
                robot.mergatoare.putereDreapta(gamepad1.left_stick_x - 0.3);
            }

//            if(gamepad1.left_stick_y <= 0){
//                robot.mergatoare.putereStanga(gamepad1.left_stick_y);
//                robot.mergatoare.putereDreapta(gamepad1.left_stick_y);
//            }
        }
    }
}
