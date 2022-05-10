package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    private boolean initialize;


    public Robot(HardwareMap hardwareMap){
        initialize = true;
        initialize = false;
    }
    public boolean isInitialize() {return initialize;}
}
