package org.usfirst.frc.team346._Mixers;

import org.usfirst.frc.team346._Controllers._SpeedController;
/*
 * Author: Bryant overgard
 * MixSpeedController<E> a speed controller that hijacks other speed controller's set methods
 * 
 * This class allows for any class that implements the _SpeedController interface
 * and allows the end user to mix multiple output 'streams' into a singular channel
 */
public class MixSpeedController<E extends _SpeedController> implements _SpeedController, MixOutput
{
	public E output;
	double outPercent;
	double outScale;
	
	
	//This is used for when multiple controllers are writing to the same device.
	//For instance one controller is trying to get the robot to move forward
	//While another is trying to get it to turn
	public boolean sumSets = true;
	
	public MixSpeedController(E output)
	{
		this.output = output;
	}
	
	public E getOutput()
	{
		return output;
	}
	
	public void setSumMode()
	{
		sumSets = true;
	}
	
	public void setDirectMode()
	{
		sumSets = false;
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//_SpeedController Methods
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public double get() 
	{
		return output.get();
	}
	
	//TODO: Make this actually follow through with the application of the group
	@Override
	public void set(double speed, byte syncGroup) 
	{
		//So this is ignored atm ...
		set(speed);
	}
	@Override
	public void set(double speed) 
	{
		//This is where we do our tom foolery
		System.err.println("MixSpeedController: set(" + speed + ")");
		setMixPercent(speed);
	}
	@Override
	public void disable() {
		output.disable();
	}
	
	@Override
	public void pidWrite(double output) {
		//Again tom foolery ...
		//Not sure if this is wise ...
		setMixPercent(output);
	}
	@Override
	public double getPercentOutput() {
		return output.getPercentOutput();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//MixOutput Methods
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void setMixPercent(double v) {
		if(sumSets)
			outPercent += v;
		else
			outPercent = v;
		System.err.println("MixSpeedController: setMixPercent(" + v + ") => " + outPercent);
	}
	@Override
	public void setMixPercentDirect(double v) {
		outPercent = v;
		System.err.println("MixSpeedController: setMixPercent(" + v + ") => " + outPercent);
	}
	@Override
	public double getMixPercent() {
		return outPercent;
	}
	@Override
	public void reset() {
		outPercent = 0;
	}
	@Override
	public void apply() {
		output.set(outPercent*outScale);
	}
	@Override
	public void setScale(double d) {
		outScale = d;
	}
	@Override
	public double getScale() {
		return outScale;
	}
}
