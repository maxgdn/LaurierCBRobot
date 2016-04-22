
package org.usfirst.frc.team3756.robot;

import org.usfirst.frc.team3756.robot.commands.endgame.EndGameLift;
import org.usfirst.frc.team3756.robot.commands.endgame.EndGameLower;
import org.usfirst.frc.team3756.robot.commands.endgame.StopWinch;
import org.usfirst.frc.team3756.robot.commands.intake.IntakeBall;
import org.usfirst.frc.team3756.robot.commands.intake.LiftUpIntake;
import org.usfirst.frc.team3756.robot.commands.intake.PutDownIntake;
import org.usfirst.frc.team3756.robot.commands.intake.ShootLow;
import org.usfirst.frc.team3756.robot.commands.intake.StopIntake;
import org.usfirst.frc.team3756.robot.commands.motorcontroller.ShiftToHighGear;
import org.usfirst.frc.team3756.robot.commands.motorcontroller.ShiftToLowGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
    private Joystick joy = new Joystick(0);
	private int port = 0;
    public final Thread thisThread = Thread.currentThread();
    public Thread thread;
    
    public OI() {
    	 
//    	thread = new Thread() {
//    		{
//    			synchronized(thisThread) {
    	
    	//Ball Handling Control
      /*  JoystickButton shootLowGoal = new JoystickButton(getJoystick(),1);
        shootLowGoal.whileHeld(new ShootLow());
        JoystickButton stopIntakeButton = new JoystickButton(getJoystick(), 2);
        stopIntakeButton.whenPressed(new StopIntake());
        JoystickButton intakeButton = new JoystickButton(getJoystick(), 3);
       intakeButton.whileHeld(new IntakeBall());
        JoystickButton liftUpIntake = new JoystickButton(getJoystick(), 8);
        liftUpIntake.whenPressed(new LiftUpIntake());
        JoystickButton putDownIntake = new JoystickButton(getJoystick(), 9);
        putDownIntake.whenPressed(new PutDownIntake());*/
        
        //Change Gears
        JoystickButton gearDOWN = new JoystickButton(getJoystick(),10);
        gearDOWN.whenPressed(new ShiftToLowGear());
        JoystickButton gearUP = new JoystickButton(getJoystick(),11);
        gearUP.whenPressed(new ShiftToHighGear());
        
        //End Game Control
        JoystickButton liftBot = new JoystickButton(getJoystick(),6);
        liftBot.whileHeld(new EndGameLift());
        liftBot.whenReleased(new StopWinch());
        
        JoystickButton lowerBot = new JoystickButton(getJoystick(),7);
        lowerBot.whileHeld(new EndGameLower());
        lowerBot.whenReleased(new StopWinch());
        JoystickButton stopWinch = new JoystickButton(getJoystick(),5);
        stopWinch.whenPressed(new StopWinch());
//        getJoystick();
//    				}
//    			}
//    	};
//    	thread.start();
    }
   
    public Joystick getJoystick() {
        return joy;
    }
    public Thread getThread(){
		return Thread.currentThread();
		}
}

