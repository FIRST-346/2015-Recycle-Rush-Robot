package org.usfirst.frc.team346._Mixers;

public class MixTest 
{
	static NormalizationMixer mix;
	static MixSpeedController<MixDummy> d1,d2;
	public static void init()
	{
		mix = new NormalizationMixer();
		
		d1 = new MixSpeedController<MixDummy>(new MixDummy(1));
		d2 = new MixSpeedController<MixDummy>(new MixDummy(2));
		
		d1.setScale(100);
		d2.setScale(100);
		
		mix.addToMix(d1);
		mix.addToMix(d2);
	}
	
	public static void main(String[] args)
	{
		init();
		
		
		//Test 1: Set all values within range and apply, expected output should be the input
//			d1.set(0.5);
//			d2.set(0.5);
//			mix.apply();
//			//Expected output is 0.5 0.5
//			
//			d1.set(1);
//			d2.set(0.5);
//			mix.apply();
//			//Expected output is 1.0 0.5
//			
//			d1.set(-1);
//			d2.set(0.5);
//			mix.apply();
//			//Expected output is -1.0 0.5
//			
//			d1.set(0.5);
//			d2.set(-0.5);
//			mix.apply();
//			//Expected output is 0.5 0.5
//			
//			d1.set(0.5);
//			d2.set(1);
//			mix.apply();
//			//Expected output is 1.0 0.5
//			
//			d1.set(0.5);
//			d2.set(-1);
//			mix.apply();
//			//Expected output is -1.0 0.5
//			
//			d1.set(-1);
//			d2.set(-1);
//			mix.apply();
//			//Expected output is -1.0 0.5
			
		//Test 2: One output over 100%
			d1.set(1.1);
			d2.set(0.5);
			mix.apply();
			//Expected output is 1.0 0.454545454545
	}
}
