package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Jaguar left1, left2, right1, right2;
	
	public DriveBase()
	{
		left1 = new Jaguar(RobotMap.leftMotor1);
		left2 = new Jaguar(RobotMap.leftMotor2);
		right1 = new Jaguar(RobotMap.rightMotor1);
		right2 = new Jaguar(RobotMap.rightMotor2);
	}
	
	public void drive(double left, double right)
	{
		left1.set(left);
		left2.set(-left);
		right1.set(right);
		right2.set(-right);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
}

