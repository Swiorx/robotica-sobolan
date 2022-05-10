package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.Motoare;

public class Robot {
    private boolean initialize;
    public Motoare mergatoare;

    public Robot(HardwareMap hardwareMap){
        initialize = true;
        mergatoare = new Motoare(hardwareMap);
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}
