package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void drive(double left, double right)
	{
		
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
}

