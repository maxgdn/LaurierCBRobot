package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftingMech extends Subsystem {
	   public SpeedController liftMechOne;
	   public SpeedController liftMechTwo; 
	   
	   public Relay lift1, lift2;
	   
	public LiftingMech(){
//		liftMechOne = new Victor(7);
//	    liftMechTwo = new Victor(8);
		lift1 = new Relay(0);
		lift2 = new Relay(1);

    }
	public void liftRobot(){
//		liftMechOne.setInverted(false);
//    	liftMechOne.set(1);
//    	liftMechTwo.setInverted(false);
//    	liftMechTwo.set(1);
		lift1.set(Value.kForward);
		lift2.set(Value.kForward);
	}
	
	public void lowerRobot(){
//		liftMechOne.setInverted(true);
//    	liftMechOne.set(1);
//    	liftMechTwo.setInverted(true);
//    	liftMechTwo.set(1);
		lift1.set(Value.kReverse);
		lift2.set(Value.kReverse);
	}
	public void stopMovingRobot(){
//		liftMechOne.setInverted(false);
//    	liftMechOne.set(0);
//    	liftMechTwo.setInverted(false);
//    	liftMechTwo.set(0);
		lift1.set(Value.kOff);
		lift2.set(Value.kOff);
	}

    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

