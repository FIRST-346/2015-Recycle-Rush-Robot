package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.TalonSRX;

public class _TalonSRX extends TalonSRX implements _SpeedController
{

	public _TalonSRX(int channel) {
		super(channel);
	}

	@Override
	public double getPercentOutput() {
		return get();
	}

	
}
