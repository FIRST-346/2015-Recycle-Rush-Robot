package org.usfirst.frc.team346._Mixers;

public interface MixOutput 
{
	//This should always be a percentage but can go to infinate
	//If the value is over 100% every other grouped output 
	//	gets scaled down so that the highest value is 100%
	//Same goes for under -100%
	public void setMixPercent(double v);  
	public void setMixPercentDirect(double v);
	public double getMixPercent();
	
	
	public void reset();
	public void apply();
	
	public void setScale(double d);
	public double getScale();
	
	
}
