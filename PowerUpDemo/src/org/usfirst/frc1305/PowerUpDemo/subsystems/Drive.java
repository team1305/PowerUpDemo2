// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1305.PowerUpDemo.subsystems;

import org.usfirst.frc1305.PowerUpDemo.Robot;
import org.usfirst.frc1305.PowerUpDemo.RobotMap;
import org.usfirst.frc1305.PowerUpDemo.commands.*;
import org.usfirst.frc1305.PowerUpDemo.Constants;

import com.ctre.phoenix.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX driveLeft1 = RobotMap.driveDriveLeft1;
    private final WPI_TalonSRX driveRight1 = RobotMap.driveDriveRight4;
    private final DifferentialDrive robotdrive = RobotMap.driverobotdrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final WPI_TalonSRX DriveLeft2 = RobotMap.driveDriveLeft2;
    private final WPI_TalonSRX DriveLeft3 = RobotMap.driveDriveLeft3;
    private final WPI_TalonSRX DriveRight2= RobotMap.driveDriveRight5;
    private final WPI_TalonSRX DriveRight3 = RobotMap.driveDriveRight6;
    
	private Encoder Left_wheel_encoder;
	private Encoder Right_Wheel_encoder;
    
    
 //   left1..setVoltageRampRate(85);
 //   left2.setVoltageRampRate(85);
	    	
 //   right1.setVoltageRampRate(85);
 //   right2.setVoltageRampRate(85);
	
 //   left1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
 //   left1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
 //   left1.reverseSensor(true); // false
    
    
	//cANTalonLeftFront.setPID(Constants.kDriveVelocityKp, Constants.kDriveVelocityKi, Constants.kDriveVelocityKd, 
	//		Constants.kDriveVelocityKf, Constants.kDriveVelocityIZone, Constants.kDriveVelocityRampRate, 0);
	//cANTalonLeftFront.enableControl();
	//Robot.drive.DropOff();
	
	//cANTalonLeftFront.configEncoderCodesPerRev(38);

	/// encoder Honeywell 600128CBL (Pulses per Revolution 128) 
	/// 4" Wheel  circumference DIA*PI (12.566370614359172)
	/// 2 CIM Ball Shifter 36:12 output to encoder drive shaft
	/// 36t Encoder Gear (1) 12t Encoder Gear  --- 36:12 gearbox to encoder  
    
   public Drive() {
   	DriveLeft2.follow(driveLeft1);
   	DriveLeft3.follow(driveLeft1);

   	DriveRight2.follow(driveRight1);
   	DriveRight3.follow(driveRight1);
   	
	Left_wheel_encoder = new Encoder(2, 3);
	Right_Wheel_encoder = new Encoder(0, 1, true);
	Left_wheel_encoder.setDistancePerPulse(0.00148688918);
	Right_Wheel_encoder.setDistancePerPulse(0.00148688918);
   	
	   
   }
    
    public AHRS ahrs;
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DrivewithJoyStick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    
    
    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    public void driveTank(double leftValue, double rightValue){ // For AutoDriveStraight and Rotate and Curve
    	Robot.intake.intakeOff();
    	
    	robotdrive.tankDrive(-leftValue, -rightValue);
		
		
	}
        
    
    public void driveTurn(double moveValue, double rotate){  // For AutoRotate
    	robotdrive.arcadeDrive(moveValue, rotate);
    	}
    
    public void driveStraight(double output, double rotate){
    	robotdrive.arcadeDrive(-output, rotate);	
	}    
    
    public void DriveWithJoyStick(Joystick stick) {
    	
    	robotdrive.arcadeDrive(stick.getY()* 1, stick.getRawAxis(4)* 1);

//		if ( (stick.getY() * -1) > 0.1) {
//			Robot.intake.IntakeMotorIn();
//		} else {			
//			Robot.intake.IntakeMotorOff();
//		}
			
	}    
    
       
    public AHRS getNAVX(){
    	return ahrs;
    }
    
    public void gyroReset() {
    	ahrs.reset();
    }
    
    public double gyroGetAngle() {
    	return ahrs.getAngle();
    }
    
    public void gyroZeroYaw() {
    	ahrs.zeroYaw();
    }
    
    public void resetEncoder() {
		Left_wheel_encoder.reset();
		Right_Wheel_encoder.reset();
    	
    }	
    
    public void driveStop() {
   	 	robotdrive.arcadeDrive(0,0);
    }    
    public double getDistance() {
		double left_wheel_rot = Left_wheel_encoder.getDistance();
		//double right_wheel_rot = Right_Wheel_encoder.getDistance();

				
    	return left_wheel_rot;
      }
    
    
    
}

