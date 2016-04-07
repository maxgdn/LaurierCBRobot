
package org.usfirst.frc.team3756.robot;

import org.usfirst.frc.team3756.robot.commands.*;
import org.usfirst.frc.team3756.robot.commands.drivetrain.ShiftToHighGear;
import org.usfirst.frc.team3756.robot.commands.drivetrain.ShiftToLowGear;
import org.usfirst.frc.team3756.robot.commands.endgame.EndGameLift;
import org.usfirst.frc.team3756.robot.commands.endgame.EndGameLower;
import org.usfirst.frc.team3756.robot.commands.intake.IntakeBall;
import org.usfirst.frc.team3756.robot.commands.intake.LiftUpIntake;
import org.usfirst.frc.team3756.robot.commands.intake.PutDownIntake;
import org.usfirst.frc.team3756.robot.commands.intake.ShootLow;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
    private Joystick joy = new Joystick(0);

    public OI() {
    	 
    	//Ball Handling Control
        JoystickButton shootLowGoal = new JoystickButton(joy,1);
        shootLowGoal.whileHeld(new ShootLow());
        JoystickButton intakeButton = new JoystickButton(joy, 3);
        intakeButton.whileHeld(new IntakeBall());
        JoystickButton liftUpIntake = new JoystickButton(joy, 8);
        liftUpIntake.whileHeld(new LiftUpIntake());
        JoystickButton putDownIntake = new JoystickButton(joy, 9);
        putDownIntake.whileHeld(new PutDownIntake());
        
        //Change Gears
        JoystickButton gearUP = new JoystickButton(joy,11);
        gearUP.whileHeld(new ShiftToHighGear());
        JoystickButton gearDOWN = new JoystickButton(joy,10);
        gearDOWN.whileHeld(new ShiftToLowGear());
        
        //End Game Control
        JoystickButton liftBot = new JoystickButton(joy,4);
        liftBot.whileHeld(new EndGameLift());
        JoystickButton lowerBot = new JoystickButton(joy,5);
        lowerBot.whileHeld(new EndGameLower());
        
         
    }
   
    public Joystick getJoystick() {
        return joy;
    }
}

