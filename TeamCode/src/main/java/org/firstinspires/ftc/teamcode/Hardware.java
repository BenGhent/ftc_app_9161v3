package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Hardware
{
  public DcMotor frontLeft;
  public DcMotor backLeft;
  public DcMotor frontRight;
  public DcMotor backRight;
  
  
  Telemetry telemetry;
  HardwareMap hwMap;

  public void initRobot(HardwareMap spareMap, Telemetry tempTelemetry)
  {
      hwMap = spareMap;
      telemetry = tempTelemetry;
      initHardware();
  }

  public void initHardware()
  {
      frontLeft = hwMap.dcMotor.get("front left wheel");
      frontRight = hwMap.dcMotor.get("front right wheel");
      backLeft = hwMap.dcMotor.get("back left wheel");
      backRight = hwMap.dcMotor.get("back right wheel");

      frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
      backRight.setDirection(DcMotorSimple.Direction.REVERSE);
  }

  public void setDriveMotorMode(DcMotor.RunMode mode) {
        switch(mode) {
            case RUN_USING_ENCODER:
                if(frontLeft.getMode()==DcMotor.RunMode.RUN_USING_ENCODER)
                    break;
                frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);break;
            case RUN_WITHOUT_ENCODER:
                if(frontLeft.getMode()==DcMotor.RunMode.RUN_WITHOUT_ENCODER)
                    break;
                frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);break;
            case STOP_AND_RESET_ENCODER:
                if(frontLeft.getMode()==DcMotor.RunMode.STOP_AND_RESET_ENCODER)
                    break;
                frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);break;
            case RUN_TO_POSITION:
                if(frontLeft.getMode()==DcMotor.RunMode.RUN_TO_POSITION)
                    break;
                frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);break;
        }
    }

}

