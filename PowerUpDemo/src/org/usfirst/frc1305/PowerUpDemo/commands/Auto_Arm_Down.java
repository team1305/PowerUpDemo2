package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Arm_Down extends Command {

    public Auto_Arm_Down() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	////requires(Robot.rgbledCAN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//setTimeout(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.ArmDown();
    	////Robot.rgbledCAN.LEDyellow();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	////Robot.rgbledCAN.LEDblue();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
