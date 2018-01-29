This is the Master PowerUp bot code for this year. This code is still in development and has not been tested on the robot.

Some Features of Note:

1) There is a LimeLight subsystem class. This has wrapper functions to make it easy to talk to and receive data from the LimeLight vision control system.

2)The Constants class allows us to have an index.html page on your laptop or the driver station that can set constants on the robot through that web page. The auto routines use these constants to run commands so that we can set commands up on the fly without having to upload code to the RoboRio. The index.html file is in the project, just create a shortcut to that file on your desktop.

3) The Autonomous routine runs through the AutoCommands.java class. It reads the user selected option for Auto Mode (Program 1 - Scale Target, Program 2 - Switch target, etc for example) and then the auto code looks for the constant set for that Program. i.e. Program + GameDate (LRL) + Commands 1 through 10. It then executes those commands sequentially. If we need to change a command, we go to our index.html web page, change the command and send it to the RoboRio, the robot will then know the new commands to run for Auto without needing to have new code uploaded. We can have as many Programs as we'd like to handle different scenarios.

4) The Autonomous Routine has inputs from the Driver Station on what our partners will be doing in Autonomous. It could be advantageous to use that data to make smart decisions on teh fly during autonomous. That code doesn't exist yet but placeholders are there. A thought would be to create a new index2.html web page with all scouting data for an event loaded on what their auto routine does, then the driver station just has to input the team numbers (or read from game match up data) to make decisions during Auto.

5) The joystick buttons have been pre set up as Abutton, Bbutton, etc. This allows us to change the code in the corresponding button to do the desired result.

6) Subsystems Layout:
  Drive: This has the commands to drive the robot as well as get feedback from the encoders and navX gyro.
  Intake: This includes the Arm Lift Up/Down, Intake motors In/Out, and Claw Open/Close.
  Elevator: This includes the Stage 1 Motors, the Stage 2 motor and the feedback from the encoders to control our current height and  moving to a desired height.
  LimeLight: As mentioned in #1 above, this creates the initial connection to the LimeLight vision control system and allows us to get target information as well as a second camera feed for the driver station.
