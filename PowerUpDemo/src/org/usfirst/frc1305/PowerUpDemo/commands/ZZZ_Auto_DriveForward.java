package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZZZ_Auto_DriveForward extends Command {
	
	double distance1;
	double AnglePowerFactor;
	double RampUpDist;
	double RampDownDist;
	double MinSpeed;
	double angle1;
	double power;
	double currPos;
    double angle2, distance2;

    public ZZZ_Auto_DriveForward(double angle, double distance,  double power, double minpower,double rampup) {

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drive);
        
        this.distance1 = distance1 * 147.083;
        this.angle1 = angle1;
        this.power = power;
        this.angle2 = angle2;
        this.distance2 = distance2 * 147.083;
        
        
        MinSpeed = minpower; //set to just enough power to move bot
        AnglePowerFactor = .1; /// 0.1 = 10%
        RampUpDist = rampup * 147.083; 
      //  RampDownDist = rampdown; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    }
}
