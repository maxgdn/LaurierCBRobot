/* NAME: Samer Alabi
 * CLASS: Robot.java
 * DATE: Thursday February 11, 2016
 * COURSE: Team 3756 Robotics - FRC Competition
 * DESCRIPTION: This class will run code that enables a roboRIO connected robot to be controlled using a joystick. The joystick 
 * 				itself controls the driving of the robot while the joystick buttons control different solenoids that move
 * 				different parts of the robot.
 */

package org.usfirst.frc.team3756.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;

public class Robot extends IterativeRobot {	
	//SmartDashboard Objects
	final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser autoChooser;
    
    //Declares and initializes camera
    CameraServer camera = CameraServer.getInstance();;
    
    //Declares and instantiates victors for Drive Train
    SpeedController frontLeft = new Victor(0);
    SpeedController middleLeft = new Victor(1);
    SpeedController backLeft = new Victor(2);
    SpeedController frontRight = new Victor(3);
    SpeedController middleRight = new Victor(4);
    SpeedController backRight = new Victor(5);
    
    //Connecting Left and Right SpeedControllers to act as two different motors instead of one
    SpeedController[] leftSideMotors = {frontLeft, middleLeft, backLeft};
    SpeedController[] rightSideMotors = {frontRight, middleRight, backRight};
    SpeedController leftSide = new SpeedControllerArray(leftSideMotors);
    SpeedController rightSide = new SpeedControllerArray(rightSideMotors);
    
    //Declares and instantiates intake roller victor motor
    SpeedController intakeRoller = new Victor(6);
    
    //Declares and instantiates lift mechanism victor motors
    SpeedController liftMechOne = new Victor(7);
    SpeedController liftMechTwo = new Victor(8);
    
    //Declares, instantiates and enables compressor
    Compressor mechComp = new Compressor();
    
    //Declares RobotDrive
    RobotDrive driveRobot = new RobotDrive(leftSide, rightSide);
    
    //Declares and instantiates mount shift solenoids
    DoubleSolenoid mountShift = new DoubleSolenoid(0, 1);
    
    //Declares and instantiates ball shift solenoids
    DoubleSolenoid ballShifter = new DoubleSolenoid(2, 3);
    
    //Declares and instantiates joystick and joystick buttons
    Joystick driveStick = new Joystick(0);
    Button collectButton = new JoystickButton(driveStick, 3);   
    
    //Code that initializes when robot turns on
    public void robotInit() {
    	//JavaSmartboard initialization
    	autoChooser = new SendableChooser();
    	autoChooser.addDefault("Primary Autonomous Program", defaultAuto);
    	autoChooser.addObject("Secondary Autonomous Program", customAuto);
        SmartDashboard.putData("Auto choices", autoChooser);
        
        //Sets camera quality and starts automatic capture
        camera.setQuality(50);
        camera.startAutomaticCapture("cam0");
        
        //Enables compressor
        mechComp.setClosedLoopControl(true);
    } //End of robotInit
 
    //Code that initializes when robot switches to autonomous mode
    public void autonomousInit() {
    	autoSelected = (String) autoChooser.getSelected();
		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    } //End of autonomousInit

    //Code that runs when robot is in autonomous mode
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:  
            break;
    	case defaultAuto:
    	default:
    		driveRobot.drive(0.2, 0.0);
            break;
    	} //End of switch statement 
    } //End of autonomousPeriodic 

    //Code that runs when robot is in teleoperated mode
    public void teleopPeriodic() {
    	//Drives robot in arcade style fashion using one joystick
        driveRobot.setSafetyEnabled(true);
        driveRobot.arcadeDrive(driveStick);
        
        //Shoots object from intake roller
        if (driveStick.getRawButton(1)){
        	intakeRoller.setInverted(true);
        	intakeRoller.set(2);
        } //End of if statement
        
        //Stops the intake roller
        if (driveStick.getRawButton(2)){
        	intakeRoller.set(0.00);
        } //End of if statement
        
        //Sets intake roller to collect objects on the field
        collectButton.whileHeld(new IntakeButtonHeld());
        
        //Raises lift mechanism
        if (driveStick.getRawButton(4)){
        	liftMechOne.setInverted(false);
        	liftMechOne.set(1);
        	liftMechTwo.setInverted(false);
        	liftMechTwo.set(1);
        } //End of if statement
        
        //Lowers lift mechanism
        if (driveStick.getRawButton(5)){
        	liftMechOne.setInverted(true);
        	liftMechOne.set(1);
        	liftMechTwo.setInverted(true);
        	liftMechTwo.set(1);
        } //End of if statement
        
        //Stops lift mechanism
        if (driveStick.getRawButton(6)){
        	liftMechOne.setInverted(false);
        	liftMechOne.set(0);
        	liftMechTwo.setInverted(false);
        	liftMechTwo.set(0);
        } //End of if statement
        
        //Moves the mount in up position
        if (driveStick.getRawButton(8)){
        	mountShift.set(DoubleSolenoid.Value.kForward);
        } //End of if statement
        
        //Moves the mount in down position
        if (driveStick.getRawButton(9)){
        	mountShift.set(DoubleSolenoid.Value.kReverse);;
        } //End of if statement
        
        //Sets drive train in low gear
        if (driveStick.getRawButton(10)){
        	ballShifter.set(DoubleSolenoid.Value.kReverse);
        } //End of if statement
        
        //Sets drive train in high gear
        if (driveStick.getRawButton(11)){
        	ballShifter.set(DoubleSolenoid.Value.kForward);
        } //End of if statement      
    } //End of teleopPeriodic

    //Code that runs during test period
    public void testPeriodic() {
    	LiveWindow.run();
    } //End of testPeriodic  
} //End of class