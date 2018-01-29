package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoClaw extends Command {

	String m_command;
	double m_power;
	
    public AutoClaw(String ccommand, double npower) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	
    	m_command = ccommand;
    	m_power = npower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (m_command == "Open") {
    		Robot.intake.ClawOpen();
    	} else if (m_command == "Push") {
    		Robot.intake.intakeSpeed(m_power);
    	} else if ( m_command == "Close") {
    		Robot.intake.ClawClose();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (m_command == "Push") {
           return isTimedOut();	
        } else {
    	   return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
