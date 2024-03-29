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

import org.usfirst.frc1305.PowerUpDemo.RobotMap;
import org.usfirst.frc1305.PowerUpDemo.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Elevator extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	double ehieght;
	private boolean armliftup = false;	
	
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX stage1L = RobotMap.elevatorStage1L;
    private final WPI_TalonSRX stage2 = RobotMap.elevatorStage2;
    private final Solenoid armLift = RobotMap.elevatorArmLift;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final WPI_TalonSRX stage1R = RobotMap.elevatorStage1R;

    private Encoder stage1L_encoder;
	//private Encoder stage1R_encoder;
	private Encoder stage2_encoder;
    

	public Elevator() {
		//stage2.setNeutralMode(arg0);
        stage1R.follow(stage1L);
 
		
		//stage1L_encoder = new Encoder(2, 3);
		//stage1R_encoder = new Encoder(0, 1, true);
		//stage2_encoder = new Encoder(0, 1, true);
		//stage1L_encoder.setDistancePerPulse(0.00148688918);
		//stage1R_encoder.setDistancePerPulse(0.00148688918);
		//stage2_encoder.setDistancePerPulse(0.00148688918);
		
		
		//stage1L.configPeakCurrentLimit(28, timeoutMs);
		
		stage1L.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		stage1L.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		stage2.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		stage2.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		
		stage1L.setNeutralMode(NeutralMode.Brake);
		stage1R.setNeutralMode(NeutralMode.Brake);
		stage2.setNeutralMode(NeutralMode.Brake);
		
		//stage1L.configOpenloopRamp(0.1, 200);
		//stage2.configOpenloopRamp(0.1, 200);

		// stage2 is on a 30 amp breaker
//		stage2.configPeakCurrentLimit(35, 10); /* 35 A */
//		stage2.configPeakCurrentDuration(200, 10); /* 200ms */
//		stage2.configContinuousCurrentLimit(30, 10); /* 30A */
//		stage2.enableCurrentLimit(true); /* turn it on */
	}
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Cmd_Elevator_Loop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void ElevatorManualMove(Joystick stick2) {  //move both stages manual with joystick
    	
    	double stgdeadband = 0.3; //need to 
    	double stg1 = stick2.getRawAxis(5)*-1;
    	double stg2 = stick2.getY()*-1;

    	
    	if (Math.abs(stg1)+Math.abs(stg2) > stgdeadband) {
        	stage1L.set(stg1);
        	stage2.set(stg2);
    	} else {
        	stage1L.set(0);
        	stage2.set(0);
    	}

    }
    

    
    public void Stage1Power(double power) {
    	stage1L.set(power*-1);
    	//stage1R.set(power);
    }

    public void Stage2Power(double power) {
    	stage2.set(power);
    }

    public void Stage1Stop() {
    	stage1L.set(0);
    	//stage1R.set(0);
    }

    public void Stage2Stop() {
    	stage2.set(0);
    }
    
    public void ArmUp() {
    	this.armLift.set(false);
    	////this.armLiftRight.set(true);
    	///armliftup = true;
    	
    }
    
    public void ArmDown() {
    	this.armLift.set(true);
    	////this.armLiftRight.set(false);
    	///armliftup = true;
    }
    
    public void toggleArm() {
    	if (armliftup) {
    		ArmDown();
        	armliftup = false;
    	} else {
    		ArmUp();
        	armliftup = true;
    	}
    	
    }
    

    
//    public boolean isArmUp() {
//    	if (armliftup) {
//    		return true;
//    	} else {
//    		return false;
//    	}
//    }

    public void setHeight(double nheight) {
    	// get current height
    	double currHeight;
    	currHeight = getHeight();
    }
    
    public double getHeight() {
    	// get height from sensors
    	double nresult;
    	nresult = 0;

		double nstage1 = stage1L_encoder.getDistance();
		double nstage2 = stage2_encoder.getDistance();

		// Convert Stage1 encoder value to height
		
		// Convert Stage1 encoder value to height
		
		// Return overall Height
		
		// Is arm up or down
		double narmheight = 0; 
//		if (isArmUp()) {
//		   narmheight = 18; // inches
//		}
		nresult = nresult + narmheight;
    	
    	
    	return nresult;
    	
    }

    public void resetEncoder(int istage) {
		if ((istage == 1) || (istage ==3)) {
			stage1L_encoder.reset();
			//stage1R_encoder.reset();
		}
		if ((istage == 2) || (istage ==3)) {
			stage2_encoder.reset();
		}
		
    	
    }	
    
    public double getDistance() {
       return 0;
    }
    
    
    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

