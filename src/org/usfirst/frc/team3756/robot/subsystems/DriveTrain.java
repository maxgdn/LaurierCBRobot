package org.usfirst.frc.team3756.robot.subsystems;

import org.usfirst.frc.team3756.robot.commands.drivetrain.ArcadeWithJoystick;
import org.usfirst.frc.team3756.robot.subsystems.SpeedControllerArray;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**

 */

public class DriveTrain extends Subsystem {
	
	public SpeedController frontLeft;
	public SpeedController middleLeft;
	public SpeedController backLeft; 
	public SpeedController frontRight;
	public SpeedController middleRight;
	public SpeedController backRight;
	
	public SpeedController leftSide;
	public SpeedController rightSide;
	
	public RobotDrive driveRobot;
	
	public DriveTrain(){
			
		 	frontLeft = new Victor(0);
		    middleLeft = new Victor(1);
		    backLeft = new Victor(2);
		    frontRight = new Victor(3);
		    middleRight = new Victor(4);
		    backRight = new Victor(5);
		    		
		    //Connecting Left and Right SpeedControllers to act as two different motors instead of one
		    SpeedController[] leftSideMotors = {frontLeft, middleLeft, backLeft};
		    SpeedController[] rightSideMotors = {frontRight, middleRight, backRight};
		    leftSide = new SpeedControllerArray(leftSideMotors);
		    rightSide = new SpeedControllerArray(rightSideMotors);
		    
		    driveRobot = new RobotDrive(leftSide, rightSide);
		    driveRobot.setSafetyEnabled(false);
	      
	}
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void drive(Joystick driveStick){
		driveRobot.arcadeDrive(driveStick);
	}
	public void drive(double straight,double turn){
		driveRobot.arcadeDrive(straight,turn);
	}
	public void stopDT(){
		driveRobot.arcadeDrive(0,0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeWithJoystick());
    }
}

