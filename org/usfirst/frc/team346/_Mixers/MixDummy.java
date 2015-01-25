package org.usfirst.frc.team346._Mixers;

import org.usfirst.frc.team346._Controllers._SpeedController;

public class MixDummy implements MixOutput,_SpeedController
{
	public double output = 0;
	public double scale = 1;
	public int id = 0;
	
	public MixDummy(int channel) 
	{
		id = channel;
		System.err.println("MixDummy: Constructed with id of " + id);
	}
	
	public void set(double out)
	{
		System.err.println("MixDummy: set(" + out + ")");
		setMixPercent(out);
	}

	public void setMixPercent(double v) 
	{
		System.err.println("MixDummy: setMixPercent(" + v + ")");
		output = v;
	}
	public void setMixPercentDirect(double v) 
	{
		System.err.println("MixDummy: setMixPercentDirect(" + v + ")");
		output = v;
	}
	@Override
	public double getMixPercent() 
	{
		System.err.println("MixDummy: getMixPercent()");
		return output;
	}

	@Override
	public void reset() 
	{
		System.err.println("MixDummy: reset()");
		output = 0;
	}

	@Override
	public void apply() 
	{
		System.err.println("MixDummy: apply() output:" + output + " scale:" + scale);
		System.err.println("MixDummy: An output of " + (output*scale) + " would be applied");
	}

	@Override
	public void setScale(double d) 
	{
		System.err.println("MixDummy: setScale(" + d + ")");
		scale = d;
	}

	@Override
	public double getScale() 
	{
		System.err.println("MixDummy: getScale() scale:" + scale);
		return scale;
	}

	@Override
	public double get() 
	{
		System.err.println("MixDummy: get() output:" + output + " scale:" + scale);
		// TODO Auto-generated method stub
		return output*scale;
	}

	@Override
	public void set(double speed, byte syncGroup) 
	{
		System.err.println("MixDummy: set(" + speed + "," + ((int)syncGroup) + ")");
	}

	@Override
	public void disable() 
	{
		System.err.println("MixDummy: disable()");
		
	}

	@Override
	public void pidWrite(double output) 
	{
		System.err.println("MixDummy: pidWrite()");
	}

	@Override
	public double getPercentOutput() 
	{
		System.err.println("MixDummy: getPercentOutput() output:" + output);
		return output;
	}

}
