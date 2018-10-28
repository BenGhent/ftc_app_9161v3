package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="Teleop_1", group="Iterative Opmode")
@Disabled
public class Teleop_1 extends OpMode
{
    Hardware r = new Hardware();


    @Override
    public void init() {
        r.initRobot(hardwareMap, telemetry);
    }


    @Override
    public void init_loop() {
    }


    @Override
    public void start() {


    }


    @Override
    public void loop() {
        //first we must translate the rectangular values of the joystick into polar coordinates;
        double y = -1 * gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double angle = 0;

        if(y>0 && x>0)//quadrant 1
            angle=Math.atan(y/x);
        else if(y>0 && x<0)//quadrant 2
            angle=Math.toRadians(180)+Math.atan(y/x);
        else if(y<0 && x<0)//quadrant 3
            angle=Math.toRadians(180)+Math.atan(y/x);
        else if(y<0 && x>0)//quadrant 4
            angle=Math.toRadians(360)+Math.atan(y/x);

        if(y==0 && x>1)
            angle=0;
        if(y>0 && x==0)
            angle=Math.PI/2;
        if(y==0 && x<0)
            angle=Math.PI;
        if(y<0 && x==0)
            angle=3*Math.PI/2;

        double velocity=Math.sqrt(Math.pow(gamepad1.left_stick_y, 2)+Math.pow(gamepad1.left_stick_x, 2));
        double rotation=gamepad1.right_stick_x;

        //equations taking the polar coordinates and turing them into motor powers
        double power1=velocity*Math.cos(angle+(Math.PI/4))-rotation;
        double power2=velocity*Math.sin(angle+(Math.PI/4))+rotation;
        double power3=velocity*Math.sin(angle+(Math.PI/4))-rotation;
        double power4=velocity*Math.cos(angle+(Math.PI/4))+rotation;
        r.frontLeft.setPower(power1);
        r.frontRight.setPower(power2);
        r.backLeft.setPower(power3);
        r.backRight.setPower(power4);
    }


    @Override
    public void stop() {
    }

}
