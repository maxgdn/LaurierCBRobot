package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallControlSystem extends Subsystem {
	
	public SpeedController intakeRoller;
	public DoubleSolenoid intakeShifter;
	
	public BallControlSystem(){
    	    intakeRoller = new Victor(6);
    	    intakeShifter = new DoubleSolenoid(0, 1);
    	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void intakeShifterUP(){
		intakeShifter.set(DoubleSolenoid.Value.kForward);
	}
	public void intakeShifterDOWN(){
		intakeShifter.set(DoubleSolenoid.Value.kReverse);
	}
	public void shootLowGoal(){
		intakeRoller.setInverted(true);
    	intakeRoller.set(1);
	}
	public void intakeBall(){
		intakeRoller.setInverted(false);
		intakeRoller.set(1);
	}
	public void stopMotor(){
		intakeRoller.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

