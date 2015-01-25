package org.usfirst.frc.team346._Controllers;

import edu.wpi.first.wpilibj.CANJaguar;

public class _CANJaguar extends CANJaguar implements CANPID,_SpeedController
{

	public _CANJaguar(int deviceNumber) {
		super(deviceNumber);
		// TODO Auto-generated constructor stub
	}
	public void setPosition(double Position)
	{
		disableControl();
		disableControl();
		enableControl(Position);
		enableControl(Position);
	}
	
	public void setF(double f)
	{
	}
	public double getF() 
	{
		return 0;
	}
	
	public void setIZone(int izone) {	
	}
	public double getIZone() {
		return 0;
	}
	@Override
	public double getPercentOutput() 
	{
		double bv = getBusVoltage();
		double ov = getOutputVoltage();
		return ov/bv;
	}
}
