package org.usfirst.frc.team3756.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorController extends Subsystem {
	

	public Compressor mechComp;
	public DoubleSolenoid gearShifter;
	
	public MotorController(){
		
		mechComp = new Compressor();
	    mechComp.setClosedLoopControl(true);
	    
	    gearShifter = new DoubleSolenoid(2, 3);
	    
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setLowGear(){
		gearShifter.set(DoubleSolenoid.Value.kReverse);
	}
	public void setHighGear(){
		gearShifter.set(DoubleSolenoid.Value.kForward);
	}
}

