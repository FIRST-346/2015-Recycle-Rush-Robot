package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.PIDSource;

public class JaguarPositionPIDSource implements PIDSource {
	private _CANJaguar source;
	
	public JaguarPositionPIDSource(_CANJaguar source) {
		this.source = source;
	}

	@Override
	public double pidGet() {
		return source.getPosition();
	}
}
