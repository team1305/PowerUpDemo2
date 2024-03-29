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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Solenoid intakeClaw;
    ////public static Solenoid intakeClawRight;
    public static WPI_TalonSRX intakeArmLeft;
    public static WPI_TalonSRX intakeArmRight;
    public static WPI_TalonSRX driveDriveLeft1;
    public static WPI_TalonSRX driveDriveRight4;
    public static DifferentialDrive driverobotdrive;
    public static WPI_TalonSRX elevatorStage1L;
    public static WPI_TalonSRX elevatorStage2;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static Solenoid elevatorArmLift;

    
    public static WPI_TalonSRX driveDriveLeft2;
    public static WPI_TalonSRX driveDriveLeft3;
    public static WPI_TalonSRX driveDriveRight5;
    public static WPI_TalonSRX driveDriveRight6;
    
    public static WPI_TalonSRX elevatorStage1R; 
    
    public static Solenoid blueSolenoid;
    public static Solenoid greenSolenoid;
    public static Solenoid redSolenoid;
    public static Solenoid commonSolenoid;
    
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        intakeClaw = new Solenoid(0, 1);
        
        ////intakeClawRight = new Solenoid(0, 2);

        
        intakeArmLeft = new WPI_TalonSRX(10);
        intakeArmRight = new WPI_TalonSRX(11);
        
        
        driveDriveLeft1 = new WPI_TalonSRX(1);
        driveDriveRight4 = new WPI_TalonSRX(4);
        
        
        driverobotdrive = new DifferentialDrive(driveDriveLeft1, driveDriveRight4);

        driverobotdrive.setSafetyEnabled(false);
        driverobotdrive.setExpiration(0.1);
        driverobotdrive.setMaxOutput(1.0);
        


        elevatorStage1L = new WPI_TalonSRX(7);
        elevatorStage2 = new WPI_TalonSRX(9);
        
       
        elevatorArmLift = new Solenoid(0, 0);
 
        blueSolenoid = new Solenoid(0, 7);
        greenSolenoid = new Solenoid(0, 6);
        redSolenoid = new Solenoid(0, 5);
        commonSolenoid = new Solenoid(0, 4);


        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        driveDriveLeft2 = new WPI_TalonSRX(2);
        driveDriveLeft3 = new WPI_TalonSRX(3);
        driveDriveRight5 = new WPI_TalonSRX(5);
        driveDriveRight6 = new WPI_TalonSRX(6);

        elevatorStage1R = new WPI_TalonSRX(8);        
        
    }
}
