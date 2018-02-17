package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Intake extends Command {

	double m_npower;
	
    public Auto_Intake(double npower) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);    	
    	
    	m_npower = npower;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1);
    	
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDmagenta();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.intakeSpeed(0 - Math.abs(m_npower));
    	Robot.intake.intakeSpeed(m_npower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDbluelow();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
