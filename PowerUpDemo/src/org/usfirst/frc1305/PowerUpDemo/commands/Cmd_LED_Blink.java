package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_LED_Blink extends Command {
	
	Timer timer = new Timer();

    public Cmd_LED_Blink() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.rgbledpcm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (timer.get() > 0.3) {
        	Robot.rgbledpcm.LEDblue();
        if (timer.get() > 0.6) 
            Robot.rgbledpcm.LEDcyan();
        if (timer.get() > 0.9) 
            Robot.rgbledpcm.LEDgreen();
        if (timer.get() > 1.2)           
            Robot.rgbledpcm.LEDpink();
        if (timer.get() > 1.5)           
            Robot.rgbledpcm.LEDred();
        if (timer.get() > 1.8)           
            Robot.rgbledpcm.LEDwhite();
        if (timer.get() > 2.1)           
            Robot.rgbledpcm.LEDyellow();
        if (timer.get() > 2.4)
            timer.reset();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
