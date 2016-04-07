package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftingMech extends Subsystem {
	   public SpeedController liftMechOne;
	   public SpeedController liftMechTwo;
	   
	public LiftingMech(){
		liftMechOne = new Victor(7);
	    liftMechTwo = new Victor(8);
    }
	public void liftRobot(){
		liftMechOne.setInverted(false);
    	liftMechOne.set(1);
    	liftMechTwo.setInverted(false);
    	liftMechTwo.set(1);
	}
	public void lowerRobot(){
		liftMechOne.setInverted(true);
    	liftMechOne.set(1);
    	liftMechTwo.setInverted(true);
    	liftMechTwo.set(1);
	}
	public void stopMovingRobot(){
		liftMechOne.setInverted(false);
    	liftMechOne.set(0);
    	liftMechTwo.setInverted(false);
    	liftMechTwo.set(0);
	}

    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

