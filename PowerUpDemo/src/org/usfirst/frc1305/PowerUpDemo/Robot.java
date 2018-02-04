// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1305.PowerUpDemo;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1305.PowerUpDemo.commands.*;
import org.usfirst.frc1305.PowerUpDemo.subsystems.*;
import org.usfirst.frc1305.PowerUpDemo.Robot;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */

public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<CommandGroup> autonomousModes;
    

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Intake intake;
    public static Drive drive;
    public static Elevator elevator;
    public static LimeLight limeLight;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   
    public static RGBledPCM rgbledpcm;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */    
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        intake = new Intake();
        drive = new Drive();
        elevator = new Elevator();
        limeLight = new LimeLight();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        rgbledpcm = new RGBledPCM();
        
        CameraServer.getInstance().startAutomaticCapture();
        /**
         * Uses the CameraServer class to automatically capture video from a USB webcam
         * and send it to the FRC dashboard without doing any vision processing. This
         * is the easiest way to get camera images to the dashboard. Just add this to
         * the robotInit() method in your program.
         */
        
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        Log.startServer(1234);
        Constants.loadFromFile();
        
        Constants.add("avalue", "0"); // a value for Drive tuning
        Constants.add("bvalue", "0"); // a value for Drive tuning 
        Constants.add("ElevatorStage1Speed", "0.8"); // value for Stage 1 Speed
        Constants.add("ElevatorStage2Speed", "0.4"); // value for Stage 1 Speed
        
        // Program 1
        Constants.add("PL1C1", " D0|48|90|96|0.80|0.5|20"); // DR0D48
        Constants.add("PL1C2", "R-90");
        Constants.add("PL1C3", "AUP");
        Constants.add("PL1C4", "P0.2");
        Constants.add("PL1C5", "I0.9");
        Constants.add("PL1C6", "");
        Constants.add("PL1C7", "");
        Constants.add("PL1C8", "");
        Constants.add("PL1C9", "");
        Constants.add("PL1C10", "");
        
        Constants.add("PR1C1", "");
        Constants.add("PR1C2", "");
        Constants.add("PR1C3", "");
        Constants.add("PR1C4", "");
        Constants.add("PR1C5", "");
        Constants.add("PR1C6", "");
        Constants.add("PR1C7", "");
        Constants.add("PR1C8", "");
        Constants.add("PR1C9", "");
        Constants.add("PR1C10", "");
        
    //    Robot.limeLight.LedOn(); // turns on LED rings
     //   Robot.limeLight.setCameraMode(0); // Set Camera Mode to Vision Tracking Mode
        
/*        Constants.add("partner1", "drive");
        Constants.add("partner2", "switch");
        
        // Program 1
        Constants.add("PL1C1", " D0|48|90|96|0.80|0.5|20"); // DR0D48
        Constants.add("PL1C2", "R-90");
        Constants.add("PL1C3", "AUP");
        Constants.add("PL1C4", "P0.2");
        Constants.add("PL1C5", "I0.9");
        Constants.add("PL1C6", "");
        Constants.add("PL1C7", "");
        Constants.add("PL1C8", "");
        Constants.add("PL1C9", "");
        Constants.add("PL1C10", "");

        Constants.add("PR1C1", "");
        Constants.add("PR1C2", "");
        Constants.add("PR1C3", "");
        Constants.add("PR1C4", "");
        Constants.add("PR1C5", "");
        Constants.add("PR1C6", "");
        Constants.add("PR1C7", "");
        Constants.add("PR1C8", "");
        Constants.add("PR1C9", "");
        Constants.add("PR1C10", "");
        
        // Program 2
        Constants.add("PL2C1", "");
        Constants.add("PL2C2", "");
        Constants.add("PL2C3", "");
        Constants.add("PL2C4", "");
        Constants.add("PL2C5", "");
        Constants.add("PL2C6", "");
        Constants.add("PL2C7", "");
        Constants.add("PL2C8", "");
        Constants.add("PL2C9", "");
        Constants.add("PL2C10", "");

        Constants.add("PR2C1", "");
        Constants.add("PR2C2", "");
        Constants.add("PR2C3", "");
        Constants.add("PR2C4", "");
        Constants.add("PR2C5", "");
        Constants.add("PR2C6", "");
        Constants.add("PR2C7", "");
        Constants.add("PR2C8", "");
        Constants.add("PR2C9", "");
        Constants.add("PR2C10", "");
        
/*      Blank Commands
 * 
 *      Constants.add("auto-switchC1", "");
        Constants.add("auto-switchC2", "");
        Constants.add("auto-switchC3", "");
        Constants.add("auto-switchC4", "");
        Constants.add("auto-switchC5", "");
        Constants.add("auto-switchC6", "");
        Constants.add("auto-switchC7", "");
        Constants.add("auto-switchC8", "");
        Constants.add("auto-switchC9", "");
        Constants.add("auto-switchC10", "");
*/
 
        
       
        oi = new OI();
        
        autonomousModes = new SendableChooser<CommandGroup>();
        autonomousModes.addDefault("Scale",new AutoCommands(1));
        //autonomousModes.addObject("Scale   Sec: Preset Location",new AutoCommands(2));
        autonomousModes.addObject("Switch",new AutoCommands(3));
        //autonomousModes.addObject("Switch   Sec: Move to Scale",new AutoCommands(4));
        SmartDashboard.putData("AUTO Modes", autonomousModes);        

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
     
    }

   
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	Log.log("general", "starting auto");

    	autonomousCommand = (Command) autonomousModes.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
        //lights.blinkLED(5);
    	//Robot.turret.LEDRingON();
    	//Robot.intake.RampOff();
        Robot.drive.gyroReset();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
    	Log.log("general", "starting teleop");
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
