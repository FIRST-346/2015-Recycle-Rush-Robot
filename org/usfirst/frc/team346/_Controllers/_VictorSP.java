package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.VictorSP;

public class _VictorSP extends VictorSP implements _SpeedController
{

	public _VictorSP(int channel) {
		super(channel);
	}

	@Override
	public double getPercentOutput() {
		return get();
	}

}
