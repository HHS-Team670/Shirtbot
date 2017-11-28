package org.usfirst.frc.team670.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.Movement;

/**
 *
 */
public class DriveWithJoystick extends Command {
	public DriveWithJoystick() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveBase);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveBase.drive(Robot.oi.getLeftJoystick().getY(), Robot.oi.getRightJoystick().getY());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
