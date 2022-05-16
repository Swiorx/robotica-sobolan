package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;
import java.lang.*;

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
            if(gamepad1.right_trigger > 0.1){
                robot.mergatoare.setMotorPowers(gamepad1.right_trigger, gamepad1.right_trigger);
            }
            if(gamepad1.left_trigger > 0.1){
                robot.mergatoare.setMotorPowers(-gamepad1.left_trigger, -gamepad1.left_trigger);
            }
            if(gamepad1.dpad_left){
                robot.mergatoare.setMotorPowers(0,1);
            }
            if(gamepad1.dpad_right){
                robot.mergatoare.setMotorPowers(1,0);
            }

            //partea 2
//            if(gamepad2.right_trigger > 0.1){
//                robot.mergatoare.putereStanga(gamepad2.right_trigger);
//                robot.mergatoare.putereDreapta(gamepad2.right_trigger);
//                telemetry.addData("right trigger", gamepad2.right_trigger);
//            }
//            if(gamepad2.left_trigger > 0.1){
//                robot.mergatoare.putereStanga(-gamepad2.left_trigger);
//                robot.mergatoare.putereDreapta(-gamepad2.left_trigger);
//                telemetry.addData("left trigger", gamepad2.left_trigger);
//            }

            if(gamepad2.left_stick_y > 0.1 || gamepad2.left_stick_y < -0.1){
                robot.mergatoare.putereStanga(-2 * gamepad2.left_stick_y);
                telemetry.addData("left stick: ", gamepad2.left_stick_y);
            }else robot.mergatoare.putereStanga(0);
            if(gamepad2.right_stick_y > 0.1 || gamepad2.right_stick_y < -0.1){
                robot.mergatoare.putereDreapta(-2 * gamepad2.right_stick_y);
                telemetry.addData("right stick: ", gamepad2.right_stick_y);
            }else robot.mergatoare.putereDreapta(0);


//            if(gamepad2.left_stick_y <= 0){
//                robot.mergatoare.putereStanga(gamepad1.left_stick_y);
//                robot.mergatoare.putereDreapta(gamepad1.left_stick_y);
//            }
            telemetry.update();
        }
    }
}
