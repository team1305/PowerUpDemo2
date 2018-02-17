package org.usfirst.frc1305.PowerUpDemo.commands;

import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class zzzzzAuto_Drive_Curve extends Command {
	
	double distance;
	double AnglePowerFactor;
	double RampUpDist;
	double RampDownDist;
	double MinSpeed;
	double angle;
	double power;
	double currPos;

    public zzzzzAuto_Drive_Curve(double angle, double distance,  double power, double minpower, double rampup, double rampdown) {
  
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drive);
        
        this.distance = distance;
        this.angle = angle;
        this.power = power;
        
        
        MinSpeed = minpower; //set to just enough power to move bot
        AnglePowerFactor = .1; /// 0.1 = 10%
        RampUpDist = rampup; 
        RampDownDist = rampdown; 
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currPos = 0;
    	Robot.drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    	currPos =  Robot.drive.getDistance() ; 	
   	
    	double NewAngleTarget = (currPos/distance * angle );
    	double dif = NewAngleTarget - Robot.navX.getYaw();
    	    	
    	if (currPos  < RampUpDist ) {  //ramp up
    		double RampUpPercent = (currPos /RampUpDist);
    		double SetPower = (MinSpeed + ((power - MinSpeed)  * RampUpPercent)); 
    		
    		double speedleft = SetPower + dif * AnglePowerFactor; //add or subtract power to left
    		double speedright = SetPower - dif * AnglePowerFactor; //add or subtract power to right
    		
    		
    		speedleft = Math.min(speedleft, power);
    		speedright = Math.min(speedright, power);

    		Robot.drive.driveTank(speedleft, speedright);
    		
    		
    	}else if ((distance - currPos) < RampDownDist ){ //ramp down
    		double RampDownPercent =  (( distance - currPos ) / RampDownDist) ;
    		double SetPower = MinSpeed + ((power - MinSpeed)  * RampDownPercent); 
    		
  		
    		double speedleft = SetPower + dif * AnglePowerFactor; //add or subtract power to left
    		double speedright = SetPower - dif * AnglePowerFactor; //add or subtract power to right

    		
    		speedleft = Math.min(speedleft, power);
    		speedright = Math.min(speedright, power);

    		Robot.drive.driveTank(speedleft, speedright);
			
    	}else { 
    		
    		double SetPower = power;
    		
    		double speedleft = SetPower + dif * AnglePowerFactor; //add or subtract power to left
    		double speedright = SetPower - dif * AnglePowerFactor; //add or subtract power to right
    		
    		speedleft = Math.min(speedleft, power);
    		speedright = Math.min(speedright,power );
    		Robot.drive.driveTank(speedleft, speedright);
    		
        }
    	
    	SmartDashboard.putNumber("currAngle", Robot.navX.getYaw());
    	SmartDashboard.putNumber("currPos", Robot.drive.getDistance());
    	SmartDashboard.putNumber("SetDistance", distance);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	//return (( DistTravelled - SetDist  )  > 0);
       	//return (Math.abs(distance - currPos) <= .01);
       	return ((Math.abs(distance) - Math.abs(currPos)) <= .01);
    	
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.drive.driveStop();
    	    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
