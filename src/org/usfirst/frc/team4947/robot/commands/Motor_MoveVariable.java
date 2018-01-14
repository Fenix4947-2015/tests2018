package org.usfirst.frc.team4947.robot.commands;

import org.usfirst.frc.team4947.robot.Robot;
import org.usfirst.frc.team4947.robot.OI.XBoxAxis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Motor_MoveVariable extends Command {

    public Motor_MoveVariable() {
    	requires(Robot.kmotor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double commandeVitesse = Robot.m_oi.getJoystickDriverAxis(XBoxAxis.LeftStickX);
    	Robot.kmotor.MotorVariable(commandeVitesse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
