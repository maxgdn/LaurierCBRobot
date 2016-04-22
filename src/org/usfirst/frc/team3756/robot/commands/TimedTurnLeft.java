package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TimedTurnLeft extends Command {

	public Timer timer;
	public double timeLimit;
    public TimedTurnLeft(double providedTL) {
    	timeLimit = providedTL;
      
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(0,-2.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timer.get() >= timeLimit){
    		return true;
    	}
    	else return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0,0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
