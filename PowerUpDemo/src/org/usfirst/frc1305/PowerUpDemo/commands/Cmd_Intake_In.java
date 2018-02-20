package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_Intake_In extends Command {

    public Cmd_Intake_In() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	//requires(Robot.rgbledCAN);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDgreen();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.intakeSpeed(.9);
    	//Robot.rgbledCAN.LEDred();

    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.intakeSpeed(0.1);
    	
       	Robot.rgbledCAN.LEDoff();
    	Robot.rgbledCAN.LEDblue();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
