
package org.usfirst.frc.team3756.robot.commands;

import org.usfirst.frc.team3756.robot.commands.intake.PutDownIntake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command to pickup and deliver the
 * soda to the box.
 */
public class Autonomous extends CommandGroup {
	
    public Autonomous() {
    	//addSequential(new PutDownIntake());
    	addSequential(new TimedDriveForward(2.5,-1));
    	/*addSequential(new TimedDriveForward(1.0,0));
    	addSequential(new TimedDriveForward(2.5,1));
    	addSequential(new TimedDriveForward(1.0,0));
    	addSequential(new TimedDriveForward(2.5,-1));
    	addSequential(new TimedDriveForward(1.0,0));
    	addSequential(new TimedDriveForward(2.5,1));*/
    	

    /*	addSequential(new PrepareToPickup());
        addParallel(new SetWristSetpoint(-45));
        addSequential(new CloseClaw());*/
    }
}
