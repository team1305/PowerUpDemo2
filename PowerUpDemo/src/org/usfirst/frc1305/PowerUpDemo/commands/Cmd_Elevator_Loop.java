package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Cmd_Elevator_Loop extends Command {

	public double gotoHeight;
	
    public Cmd_Elevator_Loop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	////requires(Robot.rgbledCAN);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.resetEncoder();  // needs verified
   	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.elevator.ElevatorManualMove(Robot.oi.getJoystick2());

/*    	public double currPos = Robot.elevator.getPosition();
    	
    	if (currPos < gotoHeight) {
    		stage1L.set(0.8);
    	} else {
    		if (currPos > gotoheight) {
    			stage1L.set(-0.8);
    		} else {
    			stop
    		}
    	}
  */  	
    	
    	
    	SmartDashboard.putNumber("Elevator getPosition", Robot.elevator.getPosition());
    	SmartDashboard.putNumber("Elevator getMotorOutputVoltage", Robot.elevator.getMotorOutputVoltage());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.Stage1Stop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
