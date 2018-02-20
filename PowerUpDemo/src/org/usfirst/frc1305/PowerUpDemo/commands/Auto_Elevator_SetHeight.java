package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto_Elevator_SetHeight extends Command {

	
	double Eheight;
	
	
    public Auto_Elevator_SetHeight(double eheight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	////requires(Robot.rgbledCAN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.resetEncoder();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  

    	Robot.elevator.SetPosition(Eheight);
    	
    	Robot.rgbledCAN.LEDblue();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//return false;
    	return (Robot.elevator.getPosition() >= Eheight) ;

    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
