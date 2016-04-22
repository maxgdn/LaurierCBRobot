/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3756.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3756.robot.commands.Autonomous;
import org.usfirst.frc.team3756.robot.subsystems.BallControlSystem;
import org.usfirst.frc.team3756.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3756.robot.subsystems.LiftingMech;
import org.usfirst.frc.team3756.robot.subsystems.MotorController;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    Command autonomousCommand1;
    Command autonomousCommand2;
    
    public static DriveTrain drivetrain;
    public static BallControlSystem ballControl;
    public static LiftingMech liftMech;
    public static MotorController motorControl;
    public static OI oi;
    
    final String customAuto1 = "Custom Auto 1";
    final String customAuto2 = "Custom Auto 2";
    final String customAuto3 = "Custom Auto 3";
    String autoSelected;
    SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        drivetrain = new DriveTrain();
        ballControl = new BallControlSystem();
        liftMech = new LiftingMech();
        motorControl = new MotorController();
        oi = new OI();
        
        CameraServer camera = CameraServer.getInstance();
        camera.setQuality(50);
        camera.startAutomaticCapture("cam0");
        
        autoChooser = new SendableChooser();
    	autoChooser.addDefault("Drive Foward)", customAuto1);
    	//autoChooser.addObject("Complex Lowbar", customAuto2);
    	autoChooser.addObject("SpyBotShoot", customAuto3);
    	
        SmartDashboard.putData("Auto choices", autoChooser);
        
      // instantiate the command used for the autonomous period
        autonomousCommand1 = new Autonomous();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(ballControl);
        SmartDashboard.putData(liftMech);
        
    }

    public void autonomousInit() {
    		 autonomousCommand1.start();
    	
       // schedule the autonomous command (example)
    }
    
    /**
     * This function is called periodically during autonomous
     *
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand1.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
   
}
