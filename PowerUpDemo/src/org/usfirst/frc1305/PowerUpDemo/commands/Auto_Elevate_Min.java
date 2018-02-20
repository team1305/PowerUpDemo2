package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;
import org.usfirst.frc1305.PowerUpDemo.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Elevate_Min extends Command {

	
    public Auto_Elevate_Min(double TimeOut) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);

    	setTimeout(TimeOut);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.Stage1Power(-0.7);
    }	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {    	

    	if (RobotMap.elevatorStage1L.getSensorCollection().isRevLimitSwitchClosed() == false) { 
    		return  true ;
    	}else  isTimedOut(); {
    		return  false ;  //isTimedOut();
    	}
    }

    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.Stage1Power(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
