package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.Jaguar;

public class _Jaguar extends Jaguar implements _SpeedController
{

	public _Jaguar(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPercentOutput() {
		// TODO Auto-generated method stub
		return get();
	}
}
