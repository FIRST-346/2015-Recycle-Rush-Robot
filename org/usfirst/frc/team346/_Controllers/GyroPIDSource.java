package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Gyro;

public class GyroPIDSource implements PIDSource {
	private Gyro source;
	
	public GyroPIDSource(Gyro source) {
		this.source = source;
	}

	@Override
	public double pidGet() {
		return source.getAngle();
	}
}