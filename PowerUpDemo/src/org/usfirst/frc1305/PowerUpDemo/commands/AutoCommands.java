package org.usfirst.frc1305.PowerUpDemo.commands;


import org.usfirst.frc1305.PowerUpDemo.Constants;
import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommands extends CommandGroup {

	double m_drivedistance1, m_drivedistance2;
	String m_gamedata;
	double m_targetX;
	boolean m_istarget;
	char m_scale;
	
    public AutoCommands(int commandtorun) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
       // GET FMS DATA - i.e. LRL
    	m_gamedata = DriverStation.getInstance().getGameSpecificMessage();
    	
    	m_istarget = Robot.limeLight.isTarget();    	
    	m_targetX = Robot.limeLight.getTx();

		String cpartner1 = Constants.getAsString("partner1"); // Drive, Switch or Scale
		String cpartner2 = Constants.getAsString("partner2");
        if (m_gamedata.length() > 0) {
		   m_scale = m_gamedata.charAt(1);
        } else {
        	m_scale = 'L';
        }
        
    	// commandtorun is 1, 2, 3, 4 - preset programs		 
  //  	for (int ni=1; ni <= 10; ni++) {     			    	
  //  		run_command(Constants.getAsString("P" + m_scale + Integer.toString(commandtorun) + "C" + Integer.toString(ni)));	 
  //  	}    	   
    }

    public void run_command(String ccommand) {
    	if (ccommand.length() > 0) {
    		// ex. D0|48|90|36|0.80|0.5|20			// Drive Angle/Dist1, Drive Angle/Dist2, Power, MinPower, RampUp
    		// ex. R0, R90, R-90, R180				// Rotate to Angle
    		// ex. AUP, ADOWN						// Arm Up/Down
    		// ex. E0, E96							// Set Elevator Height
    		// ex. P0.2, P1.0						// Push using Intake Reverse
    		// ex. I0.5, I1							// Intake 
    		// ex. OPEN								// Open Claw
    		// ex. CLOSE							// Close Claw
    		
    		String theCommand = ccommand.substring(1, 1);
    		// ex. D0|48|90|36|0.80|0.5|20
    		String cparams = ccommand.substring(2);
    		// ex. 0|48|90|36|0.80|0.5|20
       
             
    	   if (theCommand == "D") {
       		   String match = "|";
       		   String[] params = new String[8];
       		   int nparam = 1;
    		   int index = cparams.indexOf(match);
    		   while (index >= 0) {  // indexOf returns -1 if no match found      
    			   params[nparam] = cparams.substring(1, index);
    			   nparam++;	
    			   cparams = cparams.substring(index);

    			   index = cparams.indexOf(match);
    		   }    
    		   nparam++;
    		   params[nparam] = cparams;
    		   System.out.println(params[1]);    		  
    		   System.out.println(params[2]);    		  
    		   System.out.println(params[3]);    		  
    		   System.out.println(params[4]);    		  
    		   System.out.println(params[5]);    		  
    		   System.out.println(params[6]);    		  
    		   System.out.println(params[7]);    		  

    		   addSequential(new NewAutoDriveStraight(Double.parseDouble(params[1]), Double.parseDouble(params[2]), Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5]), Double.parseDouble(params[6]), Double.parseDouble(params[7]) ));   		   
    	   }

    	   if (theCommand == "R") {
    		   addSequential(new AutoRotate(Double.parseDouble(cparams), 0));    		     	     
    	   }

    	   if (theCommand == "A") {
    		   if (cparams.charAt(0) == 'U') {
    			   addSequential(new AutoArmLift(true)); // Arm Up  		    	    
    		   } else if (cparams.charAt(0) == 'D') {
    			   addSequential(new AutoArmLift(false)); // Arm Down   	    	 
    		   }
    	   }

    	   if (theCommand == "P") { 
    		   addSequential(new AutoClaw("Push", Double.parseDouble(cparams)));    
    	   }

    	   if (theCommand == "O") { 
    		   addSequential(new AutoClaw("Open", 0));    
    	   }

    	   if (theCommand == "C") { 
    		   addSequential(new AutoClaw("Close", 0));    
    	   }
    	   
    	   if (theCommand == "E") { 
    		   addSequential(new AutoElevate(Double.parseDouble(cparams)));    
    	   }
    	   
    	   if (theCommand == "I") { 
    		   addSequential(new AutoIntakeIn(Double.parseDouble(cparams)));    
    	   }
    	   
       }
   	   
 	
    }
    
    protected void calc_distances() {
       double disttoswitch = 5;
/*       
       // Use Vision to calculate distance 
       m_drivedistance1 = 48;
       if (m_gamedata.charAt(1) == 'L') {
           m_drivedistance2 = 96;    	   
       } else {
           m_drivedistance2 = 48;    	   
       }
*/
           	
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
