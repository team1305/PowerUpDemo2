package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Elevate extends Command {

	double m_height;
	
    public Auto_Elevate(double nheight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	setTimeout(Math.abs(nheight));
    	
    	
    	  m_height = nheight;
              	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (m_height > 0) {
    	Robot.elevator.Stage1Power(-0.7);
    	} else {
    		Robot.elevator.Stage1Power(0.7);
    	}
    	//Robot.elevator.setHeight(m_height);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {    	
    	return isTimedOut(); // (Math.abs(m_height - Robot.elevator.getHeight()) < 0.5);
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
