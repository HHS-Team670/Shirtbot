package org.usfirst.frc.team670.robot.subsystems;
import org.usfirst.frc.team670.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Relay relay;
	
	public Shooter()
	{
		relay = new Relay(RobotMap.shooter);
	}
	
	public void shoot()
	{
		relay.set(Relay.Value.kOn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		relay.set(Relay.Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ShootWithJoystick());
    }
}

