package org.usfirst.frc.team4947.robot.subsystems;

import org.usfirst.frc.team4947.robot.Constants;
import org.usfirst.frc.team4947.robot.Robot;
import org.usfirst.frc.team4947.robot.commands.CallMoveTo;
import org.usfirst.frc.team4947.robot.commands.Motor_MoveVariable;
import org.usfirst.frc.team4947.robot.commands.motor_turn;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class motor extends Subsystem {

	private TalonSRX Bench_motor = new TalonSRX(0);
	double targetPositionRotations;
	public motor(){
		/* lets grab the 360 degree position of the MagEncoder's absolute position */
		int absolutePosition = Bench_motor.getSelectedSensorPosition(Constants.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        Bench_motor.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        
        /* choose the sensor and sensor direction */
        Bench_motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        Bench_motor.setSensorPhase(true);
        
        /* set the peak and nominal outputs, 12V means full */
        Bench_motor.configNominalOutputForward(0, Constants.kTimeoutMs);
        Bench_motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
        Bench_motor.configPeakOutputForward(1, Constants.kTimeoutMs);
        Bench_motor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        Bench_motor.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs); /* always servo */
        /* set closed loop gains in slot0 */
        Bench_motor.config_kF(Constants.kPIDLoopIdx, 0.0, Constants.kTimeoutMs);
        Bench_motor.config_kP(Constants.kPIDLoopIdx, 0.8, Constants.kTimeoutMs); //0.1
        Bench_motor.config_kI(Constants.kPIDLoopIdx, 0.003, Constants.kTimeoutMs);
        Bench_motor.config_kD(Constants.kPIDLoopIdx, 0.0, Constants.kTimeoutMs);

	}
		
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void MoveTo(double cm){
		/* lets grab the 360 degree position of the MagEncoder's absolute position */
		int absolutePosition = Bench_motor.getSelectedSensorPosition(Constants.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        Bench_motor.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        
        
		/* Position mode - button just pressed */

        double nombreToursMoteur = cm / 3.1416 * 0.8;
    	targetPositionRotations =  nombreToursMoteur * 80; /* 100 Rotations * 80 u/rev in either direction (85.42 rot/second @ free shaft)(20 per phase, quad encod) */
    	Bench_motor.set(ControlMode.Position, targetPositionRotations); /* 50 rotations in either direction */
	}
	public void MotorVariable(double desiredSpeed){
		Bench_motor.set(ControlMode.PercentOutput, desiredSpeed);
	}
	
	/*public void MotorY(){
		Bench_motor.set(ControlMode.PercentOutput, 0);
	}
	public void MotorX(){
		Bench_motor.set(ControlMode.PercentOutput, 0.5);
	}
	public void MotorB(){
		Bench_motor.set(ControlMode.PercentOutput, 0.75);
	}
	*/
	public void ChangeMotor(){
		Bench_motor.set(ControlMode.PercentOutput, 0.2);
	}
    public void initDefaultCommand() {

        // Set the defaut command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log()
    {
    
    }
}

