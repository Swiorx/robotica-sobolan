package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motoare {
    private DcMotor motorStanga, motorDreapta;

    public Motoare(HardwareMap hardwareMap){
        this.motorDreapta = hardwareMap.dcMotor.get("motorDreapta");
        this.motorStanga = hardwareMap.dcMotor.get("motorStanga");

        motorStanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorStanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorDreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorDreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
