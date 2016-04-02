package org.usfirst.frc.team3756.robot;

public class SubSystemIntake extends Robot {
	public void execute(){
		intakeRoller.setInverted(false);
		intakeRoller.set(1);
	}
}
