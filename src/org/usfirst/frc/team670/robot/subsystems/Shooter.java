package org.usfirst.frc.team670.robot.subsystems;
import org.usfirst.frc.team670.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Jaguar shoot;
	
	public Shooter()
	{
		shoot = new Jaguar(RobotMap.shooter);
	}
	
	public void shoot()
	{
		shoot.set(100);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ShootWithJoystick());
    }
}

