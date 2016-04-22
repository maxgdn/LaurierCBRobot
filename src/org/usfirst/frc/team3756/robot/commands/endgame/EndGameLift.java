package org.usfirst.frc.team3756.robot.commands.endgame;

import org.usfirst.frc.team3756.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EndGameLift extends Command {

    public EndGameLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftMech);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("HELLO !#!##!$!$!$!s");
    	Robot.liftMech.liftRobot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.liftMech.stopMovingRobot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
