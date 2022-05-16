package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motoare {
    private DcMotor motorStanga, motorDreapta;

    public Motoare(HardwareMap hardwareMap) {
        motorDreapta = hardwareMap.dcMotor.get("motorDreapta");
        motorStanga = hardwareMap.dcMotor.get("motorStanga");

        motorStanga.setDirection(DcMotorSimple.Direction.FORWARD);
        motorStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorDreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        motorDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

        public void putereStanga(double speed) {motorStanga.setPower(speed);}
        public void putereDreapta(double speed) {motorDreapta.setPower(speed);}

        public void setMotorPowers(double speedStanga, double speedDreapta){
            motorStanga.setPower(speedStanga);
            motorDreapta.setPower(speedDreapta);

        }

        public void stop(){
            motorStanga.setPower(0);
            motorDreapta.setPower(0);
        }
    }

