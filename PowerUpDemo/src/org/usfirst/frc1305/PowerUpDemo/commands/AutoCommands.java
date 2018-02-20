package org.usfirst.frc1305.PowerUpDemo.commands;


//import org.usfirst.frc1305.PowerUpDemo.Constants;
import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommands extends CommandGroup {

	double m_drivedistance1, m_drivedistance2;
	String m_gamedata;
	double m_targetX;
	boolean m_istarget;
	char m_scale, m_switch;
	
    public AutoCommands(int commandtorun) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
       // GET FMS DATA - i.e. LRL
    	m_gamedata = DriverStation.getInstance().getGameSpecificMessage();
    	
    	m_istarget = Robot.limeLight.isTarget();    	
    	m_targetX = Robot.limeLight.getTx();

		//String cpartner1 = Constants.getAsString("partner1"); // Drive, Switch or Scale
		//String cpartner2 = Constants.getAsString("partner2");
        
    	if (m_gamedata.length() > 0) {
		   m_scale = m_gamedata.charAt(1); // use zero if switch
		   m_switch = m_gamedata.charAt(0);
        } else {
        	m_scale = 'L';
        	m_switch = 'L';
        }
       
        SmartDashboard.putString("GameData", m_gamedata);
        
        
        addSequential(new Auto_Gyro_Reset());  //reset gyro and drive encoders
        
        if (commandtorun == 1) { // Cross The Line
        	if (m_switch == 'L') {
        		//WORKS!
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0, 111, 0.65, 0.5, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Finished());
             	
        	} else {
        		//WORKS!
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0, 111, 0.65, 0.5, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Finished());
        	}        	
        }
        
        if (commandtorun == 2) { // SCALE - Robot Left
        	if (m_scale == 'L') {
        		//WIP
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Drive(1, 45, 0.8, 0.4, 20 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addParallel(new Auto_Elevate_Max(5 )); // Raise elevator to max height
        		
        		addSequential(new Auto_Drive(0, 280, 0.8, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		
        		
        		addSequential(new Auto_Tank_Rotate(38, 0.65, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential(new Auto_Drive(38, 10, 0.7, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )

        		addSequential(new Auto_Drive_Stop()); // stop the drive motors
        		addSequential(new Auto_Wait_Seconds(.1)); // wait to allow time to settle		
        		
        		addSequential(new Auto_Intake(-0.7)); //spit cube out
          		addSequential(new Auto_Wait_Seconds(.25)); //continue to spit
        		
        		addSequential(new Auto_Intake(0)); // turn intake off
        		
        		addParallel(new Auto_Elevate_Min(5 )); //lower elevator to minimum height
        		addSequential(new Auto_Tank_Rotate(150, 0.3, -0.7, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, do       		
        		
        		
        		addSequential (new Auto_Arm_Down()); // lower the 4bar
        		
        		addSequential(new Auto_Drive(150, 84, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		
        		
        		addParallel(new Auto_Intake(0.7)); // intake the cube
        		
        		addSequential(new Auto_Drive(150, 30, 0.6, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop()); // stop the drive motors

        		addSequential(new Auto_Wait_Seconds(.2)); // pause to allow the cube to get sucked in
        		
        		addSequential(new Auto_Tank_Rotate(100, -0.75, 0.3, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		
        		addSequential(new Auto_Intake(0)); // turn intake off
        		addSequential (new Auto_Arm_Up()); // raise the 4bar
        		
        		addParallel(new Auto_Elevate_Max(5 )); // Raise elevator to max height
        		
        		addSequential(new Auto_Tank_Rotate(27, -0.7, 0.3, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential(new Auto_Drive(27, 69, 0.7, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )

        		addSequential(new Auto_Drive_Stop()); // stop the drive motors
        		addSequential(new Auto_Wait_Seconds(.1)); // wait to allow time to settle	
        		
        		addSequential(new Auto_Intake(-0.4)); // spit cube out
          		addSequential(new Auto_Wait_Seconds(.25)); //wait for spit
        		
        		addSequential(new Auto_Intake(0)); // turn intake off
        		
        		addParallel(new Auto_Elevate_Min(5 )); //lower elevator to minimum height
        		addSequential(new Auto_Tank_Rotate(140, 0.3, -0.7, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, do       		
        		
        		addSequential(new Auto_Finished()); // end auto

        	} else {
        		//WIP
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Drive(0, 110, 0.75, 0.4, 20 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive(0, 130, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Tank_Rotate(90, 0.7, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		
        		addSequential(new Auto_Drive(90, 60, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		
        		addParallel(new Auto_Elevate_Max(5 )); // Raise elevator to max height
        		
        		addSequential(new Auto_Drive(90, 120, 0.6, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )     		
        		

        		addSequential(new Auto_Tank_Rotate(-20, 0.0, 0.7, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		
        		//addSequential(new Auto_Drive(-10, 10, 0.6, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )     	
        		
        		addSequential(new Auto_Drive_Stop()); // stop the drive motors
        		addSequential(new Auto_Wait_Seconds(.1)); // wait to allow time to settle	
        		
        		addSequential(new Auto_Intake(-0.6)); // spit cube out
          		addSequential(new Auto_Wait_Seconds(.25)); //wait for spit
        		
        		addSequential(new Auto_Intake(0)); // turn intake off
        		
        		addParallel(new Auto_Elevate_Min(5 )); //lower elevator to minimum height

        		addSequential(new Auto_Tank_Rotate(-90, -0.65, -0.15, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )

        		addSequential(new Auto_Finished()); // end auto
        		
        	}        	
        }
        
        if (commandtorun == 3) { // SCALE - Robot Right
        	if (m_scale == 'L') {
        		//WIP
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0,48,0.7,0.5,20 )); 
        		addSequential(new Auto_Finished());
        		
        	} else {
        		//WIP
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0,48,0.7,0.5,20 )); 
        		addSequential(new Auto_Finished());
        	}        	
        }
        
        if (commandtorun == 4) { // Switch - Robot Centre
        	if (m_switch == 'L') { 
        		// WORKS!
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(-55, 60, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addParallel(new Auto_Elevate(0.5, 1));
        		addSequential(new Auto_Drive(0, 100, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		addSequential(new Auto_Wait_Seconds(.2)); 		
        		addSequential(new Auto_Intake(-0.6)); 
        		addSequential(new Auto_Wait_Seconds(.2));
        		addSequential(new Auto_Intake(0));
        		
        		addSequential(new Auto_Tank_Rotate(70, 0.02, -0.7, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential (new Auto_Arm_Down()); // lower the 4bar
        		addParallel(new Auto_Elevate_Min(2 )); //lower elevator to minimum height
        		addSequential(new Auto_Drive(70, 55, 0.8, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Intake(0.9)); 
        		addSequential(new Auto_Drive(70, 20, 0.45, 0.3, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Wait_Seconds(.3)); 
        		addSequential(new Auto_Intake(0.5));
        		addSequential(new Auto_Tank_Rotate(-5, -0.75, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential(new Auto_Intake(0));
        		addSequential (new Auto_Arm_Up()); // raise the 4bar
        		addParallel(new Auto_Elevate(0.5, 1));
        		addSequential(new Auto_Drive(-5, 45, 0.7, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		addSequential(new Auto_Wait_Seconds(.2)); 	
        		addSequential(new Auto_Intake(-0.6)); 
        		addSequential(new Auto_Wait_Seconds(.2));
        		addSequential(new Auto_Intake(0));
        		
        		addSequential(new Auto_Tank_Rotate(70, 0.02, -0.7, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential (new Auto_Arm_Down()); // lower the 4bar
        		addParallel(new Auto_Elevate_Min(2 )); //lower elevator to minimum height
        		addSequential(new Auto_Drive(70, 55, 0.8, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Intake(0.9)); 
        		addSequential(new Auto_Drive(70, 20, 0.45, 0.3, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Wait_Seconds(.3)); 
        		addSequential(new Auto_Intake(0.5));
        		addSequential(new Auto_Tank_Rotate(-5, -0.75, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential(new Auto_Intake(0));
        		addSequential (new Auto_Arm_Up()); // raise the 4bar
        		addParallel(new Auto_Elevate(0.5, 1));
        		addSequential(new Auto_Drive(-5, 45, 0.7, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		addSequential(new Auto_Wait_Seconds(.2)); 	
        		addSequential(new Auto_Intake(-0.6)); 
        		addSequential(new Auto_Wait_Seconds(.2));
        		addSequential(new Auto_Intake(0));
        		   
        		addSequential(new Auto_Finished());

        	} else {
        		// WORKS!
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(37, 74, 0.8, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addParallel(new Auto_Elevate(0.5, 1));
        		addSequential(new Auto_Drive(0, 73, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		addSequential(new Auto_Wait_Seconds(.5)); 		
        		addSequential(new Auto_Intake(-0.8)); 
        		addSequential(new Auto_Wait_Seconds(1));
        		addSequential(new Auto_Intake(0));
        		
        		addSequential(new Auto_Tank_Rotate(-70, -0.7, 0.05, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential (new Auto_Arm_Down()); // lower the 4bar
        		addParallel(new Auto_Elevate_Min(2 )); //lower elevator to minimum height
        		addSequential(new Auto_Drive(-65, 55, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Intake(0.9)); 
        		addSequential(new Auto_Drive(-65, 20, 0.4, 0.3, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Wait_Seconds(.3)); 
        		addSequential(new Auto_Intake(0.5));
        		addSequential(new Auto_Tank_Rotate(-5, 0.2, -0.8, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
        		addSequential(new Auto_Intake(0));
        		addSequential (new Auto_Arm_Up()); // raise the 4bar
        		addParallel(new Auto_Elevate(0.5, 1));
        		addSequential(new Auto_Drive(5, 40, 0.7, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		addSequential(new Auto_Wait_Seconds(.2)); 	
        		addSequential(new Auto_Intake(-0.6)); 
        		addSequential(new Auto_Wait_Seconds(.2));
        		addSequential(new Auto_Intake(0));
        		
             	addSequential(new Auto_Finished());		 

        	}
        }
        	  if (commandtorun == 5) { // TEST
              	if (m_switch == 'L') {
              		// WIP
            		addSequential(new Auto_Start());
            		addSequential(new Auto_Wait_Seconds(0.1));
            		
            		addSequential(new Auto_Drive(0, 36, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate(90, 0.7, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )

            		addSequential(new Auto_Drive(90, 36, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate(180, 0.7, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
            		
            		addSequential(new Auto_Drive(179.9, 36, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )         		
            		addSequential(new Auto_Tank_Rotate(-90, 0.7, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )

            		
            		addSequential(new Auto_Drive(-90, 36, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate(0, 0.7, 0.2, 5 )); //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut )
            		
            		addSequential(new Auto_Drive_Stop());
            		
            		addSequential(new Auto_Finished());		
                   	
              	} else {
              		// WIP
            		addSequential(new Auto_Start());
            		addSequential(new Auto_Wait_Seconds(0.1));
            		addSequential(new Auto_Elevate_Max(5 )); //timeout
            		addSequential(new Auto_Finished());		
              	}        	
              }
        	
        	
       


    	}    	   

    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
