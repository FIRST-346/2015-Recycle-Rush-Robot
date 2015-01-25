package xorg.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.Talon;

public class _Talon extends Talon implements _SpeedController
{

	public _Talon(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPercentOutput() {
		// TODO Auto-generated method stub
		return get();
	}

}
