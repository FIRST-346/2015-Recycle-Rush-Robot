package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.Victor;

public class _Victor extends Victor implements _SpeedController
{

	public _Victor(int channel) {
		super(channel);
	}

	@Override
	public double getPercentOutput() {
		return get();
	}

}
