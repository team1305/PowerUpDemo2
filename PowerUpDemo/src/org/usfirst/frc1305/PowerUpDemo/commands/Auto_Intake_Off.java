package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Intake_Off extends Command {

	double m_power;
    
	public Auto_Intake_Off() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDgreen();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.intakeOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDblue();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
