package org.usfirst.frc1305.PowerUpDemo.commands;


//import org.usfirst.frc1305.PowerUpDemo.Constants;
import org.usfirst.frc1305.PowerUpDemo.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoCommands extends CommandGroup {

	double m_drivedistance1, m_drivedistance2;
	String m_gamedata;
	double m_targetX;
	boolean m_istarget;
	char m_scale, m_switch;
	
    public AutoCommands(int commandtorun) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
       // GET FMS DATA - i.e. LRL
    	m_gamedata = DriverStation.getInstance().getGameSpecificMessage();
    	
    	m_istarget = Robot.limeLight.isTarget();    	
    	m_targetX = Robot.limeLight.getTx();

		//String cpartner1 = Constants.getAsString("partner1"); // Drive, Switch or Scale
		//String cpartner2 = Constants.getAsString("partner2");
        
    	if (m_gamedata.length() > 0) {
		   m_scale = m_gamedata.charAt(1); // use zero if switch
		   m_switch = m_gamedata.charAt(0);
        } else {
        	m_scale = 'L';
        	m_switch = 'L';
        }
       
        SmartDashboard.putString("GameData", m_gamedata);
        
        
        addSequential(new Auto_Gyro_Reset());  //reset gyro and encoders
        
        if (commandtorun == 1) { // Cross The Line
        	if (m_switch == 'L') {
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(1));
        		addSequential(new Auto_Drive(0, 111, 0.66, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Finished());
             	
        	} else {
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(1));
        		addSequential(new Auto_Drive(0, 111, 0.65, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Finished());
        	}        	
        }
        
        if (commandtorun == 2) { // SCALE - Robot Left
        	if (m_scale == 'L') {
        		addSequential(new Auto_Drive(0,100,0.7,0.5,20 )); 
        		addParallel(new Auto_Elevate(15));
        		addSequential(new Auto_Drive(0,230,0.7,0.5,20 )); 
        		addSequential(new Auto_Rotate(25, 0, 0)); 
        		addSequential(new Auto_Drive(25,10,0.7,0.5,20 )); 
        		addSequential(new Auto_Intake(-0.8)); 
        		addParallel(new Auto_Elevate(-8));
        		
        		addSequential(new Auto_Rotate (135, 0, 0.5));
        		
        		addSequential(new Cmd_Arm_Toggle());
        		addSequential(new Auto_Drive(135,48,0.6,0.5,20 )); 
        		addParallel(new Auto_Intake(0.9));
        		//addParallel(new AutoElevate(0.5));
        		//addSequential(new AutoIntakePush(0.8)); 
        	} else {
        		
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0,250,0.7,0.5,20 )); 
        		//addParallel(new Auto_Elevate(15));
        		//addSequential(new Auto_Rotate(25, 0, 0)); 
        		addSequential(new Auto_Wait_Seconds(5));
        		//addSequential(new Auto_Drive(0, 74, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		//
        		///addSequential (new zzzzzAuto_Drive_Curve (90, 72, .7, .6, 0, 0)); //(double angle, double distance,  double power, double minpower, double rampup, double rampdown) 
        		//addParallel(new Auto_Elevate(3));
        		
        		addSequential(new Auto_Wait_Seconds(5));
        		
        		addSequential(new Auto_Drive(0,160,0.65,0.4,20 )); 
        		
        		addSequential(new Auto_Wait_Seconds(5));
        		
        		addSequential(new Auto_Rotate(0, 0, 0));
        		addSequential(new Auto_Finished());
        		
        	}        	
        }
        
        if (commandtorun == 3) { // SCALE - Robot Right
        	if (m_scale == 'L') {
        		
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(0,100,0.7,0.5,20 )); 
        		//addParallel(new Auto_Elevate(15));
        		//addSequential(new Auto_Rotate(25, 0, 0)); 

        		//addSequential(new Auto_Drive(0, 74, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		//
        		//addSequential (new zzzzzAuto_Drive_Curve (90, 36, .7, .3, 0, 6)); //(double angle, double distance,  double power, double minpower, double rampup, double rampdown) 
        		//addParallel(new Auto_Elevate(3));
        		
        		addSequential(new Auto_Finished());
        		
        	} else {
        		
        	}        	
        }
        
        if (commandtorun == 4) { // Switch - Robot Centre
        	if (m_switch == 'L') {
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(35, 74, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addParallel(new Auto_Elevate(1));
        		addSequential(new Auto_Drive(0, 80, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		//addSequential(new Auto_Elevator_SetHeight(500000));
        		addSequential(new Auto_Wait_Seconds(.5)); 		
        		addSequential(new Auto_Intake(-0.8)); 
        		addSequential(new Auto_Wait_Seconds(1));
        		addSequential(new Auto_Intake_Off());
             	addSequential(new Auto_Finished());		 
        	} else {
        		addSequential(new Auto_Start());
        		addSequential(new Auto_Wait_Seconds(0.1));
        		addSequential(new Auto_Drive(-55, 92, 0.75, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addParallel(new Auto_Elevate(1));
        		addSequential(new Auto_Drive(0, 84, 0.75, 0.4, 0 )); //(double angle1, double distance1, double power, double minpower, double rampup )
        		addSequential(new Auto_Drive_Stop());
        		//addSequential(new Auto_Elevator_SetHeight(500000));
        		addSequential(new Auto_Wait_Seconds(.5)); 		
        		addSequential(new Auto_Intake(-0.8)); 
        		addSequential(new Auto_Wait_Seconds(1));
        		addSequential(new Auto_Intake_Off());
        		addSequential(new Auto_Finished());
        	}     
            if (commandtorun == 5) { // Test - Robot Left
            	if (m_scale == 'L') {
            		
            		addSequential(new Auto_Start());
            		addSequential(new Auto_Wait_Seconds(1));
            		
            		addSequential(new Auto_Drive(0, 48, 0.6, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate (90, .4, .2, 5 ));  //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut ) 
            		
            		addSequential(new Auto_Drive(90, 48, 0.6, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate (180, .4, .2, 5 ));  //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut ) 
            		
            		addSequential(new Auto_Drive(180, 48, 0.6, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate (270, .4, .2, 5 ));  //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut ) 
            		
            		addSequential(new Auto_Drive(270, 48, 0.6, 0.4, 12 )); //(double angle1, double distance1, double power, double minpower, double rampup )
            		addSequential(new Auto_Tank_Rotate (360, .4, .2, 5 ));  //(double AutoRotateAngle, double LeftPower, double RightPower, double TimeOut ) 
            		
            		addSequential(new Auto_Finished());
            	}
            		
            	} else {
            		
            	}
        	
        	
        }
         
       // run_command(Constants.getAsString("PL1C1" ));	
        
    	// commandtorun is 1, 2, 3, 4 - preset programs		 
    	for (int ni=1; ni <= 1; ni++) {     			    	
//   		   run_command(Constants.getAsString("P" + m_scale + Integer.toString(commandtorun) + "C" + Integer.toString(ni)));	 
   		 //  run_command(Constants.getAsString("PL1C" + Integer.toString(ni)));	 

    	}    	   
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
    		
    		String theCommand = ccommand.substring(0, 1);
    		// ex. D0|48|90|36|0.80|0.5|20
    		String cparams = ccommand.substring(1);
    		// ex. 0|48|90|36|0.80|0.5|20
    		SmartDashboard.putString("Command", ccommand);
    		SmartDashboard.putString("Command Letter", theCommand);
        	SmartDashboard.putString("Params", cparams);
             
    	   if (theCommand.equalsIgnoreCase("D")) {
    		   SmartDashboard.putString("CommandD", "Running");
       		   String match = "|";
       		   String[] params = new String[10];
       		   int nparam = 1;
    		   int index = cparams.indexOf(match);
    		   while (index >= 0) {  // indexOf returns -1 if no match found      
    			   if (nparam <= 9) {
    			   params[nparam] = cparams.substring(0, index);
    			   nparam++;	
    			   cparams = cparams.substring(index);

    			   index = cparams.indexOf(match);
    			   } else {
    				   index = -1;
    			   }
    		   }    
    		   nparam++;
    		   if (nparam <= 10) {
    		   params[nparam] = cparams;
    		   }
    		   /*SmartDashboard.putString("Param1", params[1]);
    		   SmartDashboard.putString("Param2", params[2]);
    		   SmartDashboard.putString("Param3", params[3]);
    		   SmartDashboard.putString("Param4", params[4]);
    		   SmartDashboard.putString("Param5", params[5]);
    		   SmartDashboard.putString("Param6", params[6]);
    		  // SmartDashboard.putString("Param7", params[7]);*/
    		   
//    		   System.out.println(params[1]);    		  
//    		   System.out.println(params[2]);    		  
//    		   System.out.println(params[3]);    		  
//    		   System.out.println(params[4]);    		  
//    		   System.out.println(params[5]);    		  
//    		   System.out.println(params[6]);    		  
//    		   System.out.println(params[7]);    		  

    		   addSequential(new ZZZ_NewAutoDriveStraight(Double.parseDouble(params[1]), Double.parseDouble(params[2]), Double.parseDouble(params[3]), Double.parseDouble(params[4]), Double.parseDouble(params[5]), Double.parseDouble(params[6]), Double.parseDouble(params[7]) ));   		   
    	   }

    	   if (theCommand == "R") {
    		   addSequential(new Auto_Rotate(Double.parseDouble(cparams), 0, 0));    		     	     
    	   }

    	   if (theCommand == "A") {
    		   if (cparams.charAt(0) == 'U') {
    			   addSequential(new ZZZ_AutoArmLift(true)); // Arm Up  		    	    
    		   } else if (cparams.charAt(0) == 'D') {
    			   addSequential(new ZZZ_AutoArmLift(false)); // Arm Down   	    	 
    		   }
    	   }

    	   if (theCommand == "P") { 
    		   addSequential(new ZZZ_AutoClaw("Push", Double.parseDouble(cparams)));    
    	   }

    	   if (theCommand == "O") { 
    		   addSequential(new ZZZ_AutoClaw("Open", 0));    
    	   }

    	   if (theCommand == "C") { 
    		   addSequential(new ZZZ_AutoClaw("Close", 0));    
    	   }
    	   
    	   if (theCommand == "E") { 
    		   addSequential(new Auto_Elevate(Double.parseDouble(cparams)));    
    	   }
    	   
//    	   if (theCommand == "I") { 
//    		   addSequential(new Auto_Intake_Off(Double.parseDouble(cparams)));    
//    	   }
    	   
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
