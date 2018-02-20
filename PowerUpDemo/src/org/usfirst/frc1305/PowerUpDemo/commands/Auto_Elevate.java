package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Elevate extends Command {

	double m_power;

	
    public Auto_Elevate(double Power, double TimeOut) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	setTimeout(TimeOut);
    	
    	m_power = Power;
              	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
    		Robot.elevator.Stage1Power(m_power);

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
