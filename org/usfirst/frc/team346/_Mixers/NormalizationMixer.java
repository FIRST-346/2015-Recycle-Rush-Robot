package org.usfirst.frc.team346._Mixers;

import java.util.ArrayList;
/*
 * Author: Bryant Overgard
 * NormalizationMixer a mixer norrmalizer
 * 
 * This class takes n MixOutputs and normalizes their outputs so that the
 * Highest output (Over 100%) gets scaled down to 100% and the remaining controllers get scaled down an equal percentage
 * 
 * This is accomplished by first finding the highest output over 100% and setting that as the denominator of the
 * percentage.
 * 
 * Consider the following:
 * Assume 2 MixOutputs
 * MixOutput 1 is set to 1.1 (110%)
 * MixOutput 2 is set to .5 (50%)
 * 
 * Because you cannot output more power then you have you need to scale your outputs to be proportional
 * to the highest value (as long as its over 100%)
 * 
 * MixOutput 1 is scaled to 100% by taking 1.1 and dividing it by 1.1
 * MixOutput 2 is scaled to 45.45(bar)% by taking .5 and dividing it by 1.1
 * 
 * MixOutput1 => 1.1/1.1
 * MixOutput2 => 0.5/1.1
 * 
 */
public class NormalizationMixer 
{
	public ArrayList<MixOutput> mixSet;
	
	public void init()
	{
		mixSet = new ArrayList<MixOutput>();
	}
	
	public NormalizationMixer()
	{
		init();
	}
	
	public void addToMix(MixOutput ... m)
	{
		for ( MixOutput mm : m)
			mixSet.add(mm);
	}
	
	//This should be called at the end of every loop
	public void apply()
	{
		//Normalize outputs of each controller
		//Apply outputs to each controller
		
		
		if(mixSet.size()>0)
		{
			//Get the min and max output SCALED of each output
			double max = -1;
			
			for(MixOutput m : mixSet)
			{
				//Everything needs to get pulled in
				//Using ABS allows us to keep the sinage of all the outputs and simplifies the code a tick
				if(Math.abs(m.getMixPercent()) > max)
					max = Math.abs(m.getMixPercent());
			}
			

			//For example consider 2 mixes with values of -1.1 and 0.5
			//Max will be 1.1
			//Motor 1 would be set to -1.1/1.1 = -1
			//Motor 2 would be set to 0.5/1.1 = .455
			for(MixOutput m : mixSet)
			{
				//If the max percent output is greater then 100% then scale all the outputs down
				if(max > 1)
					m.setMixPercentDirect(m.getMixPercent()/max);
				m.apply();
				m.reset();
			}
		}
	}
}
