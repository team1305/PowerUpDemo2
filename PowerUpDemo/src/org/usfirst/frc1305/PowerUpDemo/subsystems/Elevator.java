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
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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

	private static boolean m_loopstate;
	private int dpadvalue;
	double ehieght;
	private boolean armliftup = false;	
	
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX stage1L = RobotMap.elevatorStage1L;
    //private final WPI_TalonSRX stage2 = RobotMap.elevatorStage2;
    private final Solenoid armLift = RobotMap.elevatorArmLift;
    private final Solenoid ironCrossSolenoid = RobotMap.ironCrossSolenoid;

    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final WPI_TalonSRX stage1R = RobotMap.elevatorStage1R;

    //private Encoder stage1L_encoder;
	//private Encoder stage1R_encoder;
	//private Encoder stage2_encoder;
     

	public Elevator() {

		////stage1L.configNominalOutputReverse(0, 0);
        stage1R.follow(stage1L);
 

        
        stage1L.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        //stage1L.setSensorPhase(true);

		
		stage1L.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		stage1L.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		//stage2.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		//stage2.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0); // enable limit switch
		
		stage1L.setNeutralMode(NeutralMode.Brake);
		stage1R.setNeutralMode(NeutralMode.Brake);
		//stage2.setNeutralMode(NeutralMode.Brake);
		
		stage1L.configNeutralDeadband(0.05, 0);
		stage1R.configNeutralDeadband(0.05, 0);
		//stage2.configNeutralDeadband(0.05, 0);
		
		//double ElevatorCorrectionMultiplier = 1 ;
		
	}
	
	 protected void initialize() {
	    	m_loopstate = true;
	    }
	    
	 public static void setloopstate(boolean bstate) {
	    	m_loopstate = bstate;
	 }
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Cmd_Elevator_Loop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void ElevatorManualMove(Joystick stick2) {  //move both stage manual with joystick
//     	if (m_loopstate) {
    	
	    	double stgdeadband = 0.10; //need to 
	    	//double stg2 = stick2.getRawAxis(5)*-1;
	    	double stg1 = stick2.getY()*-1;
	    	if (Math.abs(stg1) > stgdeadband) {
	    		stage1L.set(stg1);
	    		Robot.rgbledCAN.LEDbluePower(stg1);
	    		//stage2.set(stg2);
	    	} else {
	    		stage1L.set(0);
	   		    Robot.elevator.setPID();
	    		Robot.elevator.holdPosition(Robot.elevator.getPosition()); 
//	    	} 
    	}
    	
    	dpadvalue = Robot.oi.getJoystick2().getPOV();
    	
    	if ( dpadvalue == 0) { // UP
    		// DPAD - Up
   		    //Robot.turret.auto_fire(860, 9, 6600, true); */
            //Robot.turret.auto_fire(dpaduptarget, dpaduptilt, dpadupspeed, true, true);
 //           Robot.turret.auto_fire(dpaduptarget, dpaduptilt, dpadupspeed, false, true);
    	 } else { // RIGHT
   		    if (dpadvalue == 90) { // RIGHT11
    		   //Robot.turret.auto_fire(819.7, 91, 5600, true);
//    	       Robot.turret.auto_fire(dpadrighttarget, dpadrighttilt, dpadrightspeed, false, true);
    	    } else { 
    	       if (dpadvalue == 180) { // DOWN
    	          //Robot.turret.auto_fire(1007, 91, 5600, true);
 ///   		      Robot.turret.auto_fire(dpaddowntarget, dpaddowntilt, dpaddownspeed, false, true);
    	       } else {
    	            if (dpadvalue == 270) { // LEFT
    		        //Robot.turret.auto_fire(930.5, 36, 6380, true);
  //  		        Robot.turret.auto_fire(dpadlefttarget, dpadlefttilt, dpadleftspeed, false, true);
    	            } else { // TURN EVERYTHING OFF
  //  		           Robot.turret.FlyWheelOff();
   // 		           Robot.shooter.EggBeatersOff();
   // 		           Robot.shooter.ElevatorMotorOff();    	
    		           //Robot.shooter.SetTiltAngle(0);
    				}
    			}
    		}
    	 }	   	
    	
    	
    	
    	
    }

    public void setHeight(double nheight) {
    	Robot.elevator.setloopstate(false);
    	Robot.elevator.setPID();
    	
    	double setPos = nheight * 4096; // not real number
    	
    	//stage1L.set(ControlMode.Position, setPos );
    	
    	 
    	
    }
    
    public void resetEncoder() {
		if (stage1L.getSensorCollection().isRevLimitSwitchClosed() == false) {
     		stage1L.setSelectedSensorPosition(0, 0, 10);
     		
		}
    }
    	
    public double getPosition() {
        return stage1L.getSelectedSensorPosition(0);  
        //return stage1L.getSelectedSensorPosition(0) / 4096d * (Math.PI * 0.5);
      }
    
    public double getMotorOutputVoltage() {
        return stage1L.getMotorOutputVoltage();
        //return stage1L.getSelectedSensorPosition(0) / 4096d * (Math.PI * 0.5);
      }
    
    public void setPID () {
    	stage1L.config_kP(0, 0.01, 0);  //0.1
    	stage1L.config_kI(0, 0.001, 0);  //0.001
    	stage1L.config_kD(0, 0.01, 0); // 0.05
      }
    
    public void holdPosition(double requestedPosition) {
    	stage1L.set(ControlMode.Position, requestedPosition );
    	//stage1L.set(ControlMode.Position, requestedPosition / (Math.PI * 0.5) * 4096);
      }
    
    
    public void SetPosition(double elevatortheight) {
    	Robot.elevator.setPID();
    	stage1L.set(ControlMode.Position, elevatortheight );
    	
    	Robot.elevator.holdPosition(Robot.elevator.getPosition()); 
    	//stage1L.set(ControlMode.Position, requestedPosition / (Math.PI * 0.5) * 4096);
      }
    
    

	public boolean isEncoderConnected1() {
		return stage1L.getSensorCollection().getPulseWidthRiseToRiseUs() != 0;
		//		The isSensorPresent() routine had only supported pulse width sensors as these
		//		allow for simple detection of the sensor signal. The getPulseWidthRiseToRiseUs()
		//		routine can be used to accomplish the same task. The getPulseWidthRiseToRiseUs()
		//		routine returns zero if the pulse width signal is no longer present (120ms timeout).
	}
    
    public void Stage1Power(double power) {
    	stage1L.set(ControlMode.PercentOutput, power);
    	//stage1L.set(power*-1);
    	//stage1R.set(power);
    }

//    public void Stage2Power(double power) {
//    	stage2.set(power);
//    }

    public void Stage1Stop() {
    	stage1L.set(ControlMode.PercentOutput, 0);
    	//stage1R.set(0);
    }

//    public void Stage2Stop() {
//    	stage2.set(0);
//    }
    
    public void ArmUp() {
    	this.armLift.set(false);
    	////this.armLiftRight.set(true);
        armliftup = true;
    	
    }
    
    public void ArmDown() {
    	this.armLift.set(true);
    	////this.armLiftRight.set(false);
    	armliftup = false;
    }
    
    public void toggleArm() {
    	if (armliftup) {
    		ArmDown();
        	armliftup = false;
           	Robot.rgbledCAN.LEDoff();
        	Robot.rgbledCAN.LEDblue();
    	} else {
    		ArmUp();
        	armliftup = true;
           	//Robot.rgbledCAN.LEDoff();
        	//Robot.rgbledCAN.LEDbluelow();
    	}
    	

    }
    
	public void finalClimb() {
		ironCrossSolenoid.set(true);
	}
    
	public void finalClimbReset() {
		ironCrossSolenoid.set(false);
	}

    
//    public boolean isArmUp() {
//    	if (armliftup) {
//    		return true;
//    	} else {
//    		return false;
//    	}
//    }

    
    
    
//    public void setHeight(double nheight) {
//    	// get current height
//    	double currHeight;
//    	currHeight = getHeight();
//    }
//    
//    public double getHeight() {
//    	// get height from sensors
//    	double nresult;
//    	nresult = 0;
//
//		double nstage1 = stage1L_encoder.getDistance();
//		//double nstage2 = stage2_encoder.getDistance();
//
//		// Convert Stage1 encoder value to height
//		
//		// Convert Stage1 encoder value to height
//		
//		// Return overall Height
//		
//		// Is arm up or down
//		double narmheight = 0; 
////		if (isArmUp()) {
////		   narmheight = 18; // inches
////		}
//		nresult = nresult + narmheight;
//    	
//    	
//    	return nresult;
//    	
//    }
//
//    public void resetEncoder(int istage) {
//		if ((istage == 1) || (istage ==3)) {
//			stage1L_encoder.reset();
//			//stage1R_encoder.reset();
//		}
//		if ((istage == 2) || (istage ==3)) {
//			//stage2_encoder.reset();
//		}
//		
//    	
//    }	
//    
//    public double getDistance() {
//       return 0;
//    }
//    
//    
//    @Override
//    public void periodic() {
//        // Put code here to be run every loop
//
//    }
//
//    // Put methods for controlling this subsystem
//    // here. Call these from Commands.

}

