package xorg.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.CANTalon;

public class _CANTalon extends CANTalon implements CANPID, _SpeedController
{

	public _CANTalon(int deviceNumber) {
		super(deviceNumber);
		// TODO Auto-generated constructor stub
	}
	
	public double getPercentOutput() 
	{
		double bv = getBusVoltage();
		double ov = getOutputVoltage();
		return ov/bv;
	}
	
}
