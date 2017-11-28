package org.usfirst.frc.team670.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	 public static int leftMotor1 = 0;
	 public static int rightMotor1 = 1;
	 public static int leftMotor2 = 2;
	 public static int rightMotor2 = 3;
	 public static int shooter = 4;

	 public static int leftJoy = 0;
	 public static int rightJoy = 1;
	 
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
