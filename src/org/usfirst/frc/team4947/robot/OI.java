/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4947.robot;

import org.usfirst.frc.team4947.robot.OI.XBoxAxis;
import org.usfirst.frc.team4947.robot.commands.CallMoveTo;
import org.usfirst.frc.team4947.robot.commands.ReverseMoveTo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public enum XBoxAxis{
		LeftStickX(0),
		LeftStickY(1);
		
		private int value;
		XBoxAxis(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}	
	}
	
	public enum XBoxButton{
		A(1),
		B(2),
		X(3),
		Y(4);
		private int value;
		XBoxButton(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
 private Joystick joystickDriver = new Joystick(0);
 
	public OI(){
			 JoystickButton driverLeftStick = new JoystickButton(joystickDriver, XBoxAxis.LeftStickX.getValue());
			 JoystickButton driverA = new JoystickButton(joystickDriver, XBoxButton.A.getValue());
			 JoystickButton driverB = new JoystickButton(joystickDriver, XBoxButton.B.getValue());
			 JoystickButton driverX = new JoystickButton(joystickDriver, XBoxButton.X.getValue());
			 JoystickButton driverY = new JoystickButton(joystickDriver, XBoxButton.Y.getValue());

			 driverA.whenPressed(new CallMoveTo());
			 driverB.whenPressed(new ReverseMoveTo());
	}
	 
	public double getJoystickDriverAxis(XBoxAxis axis) {
	        return joystickDriver.getRawAxis(axis.getValue());
	    }
	
	

	
	
		 
	   
		///// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
