/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc.team346._Controllers;

/**
 *
 * @author officemax1100
 */
public class PairedDrive implements _SpeedController
{
   private _SpeedController MasterController;
   private _SpeedController SlaveController;
   
   private boolean MasterCan = false;
   private boolean SlaveCan = false;
   
   private boolean enable = true;
   
   private boolean isClean = false;
   
   private double masterScale = 1.0;
   private double slaveScale = 1.0;
   
   private double lastValue = 0;
   
   public boolean debug = false;
   public String debugName = "unnamedPairedDrive";
   public boolean slaveVoltage = true;
   
   	public PairedDrive(_SpeedController Master, _SpeedController Slave)
   	{
   		MasterController = Master;
   		SlaveController = Slave;
   	}
   	
   	public void setMasterScale(double s)
   	{
   		masterScale = s;
   	}
   	
   	public void setSlaveScale(double s)
   	{
   		slaveScale = s;
   	}
   	
   	public void setScale(double s)
   	{
   		masterScale = s;
   		slaveScale = s;
   	}
   	
   	public void set(double value)
   	{
   		MasterController.set(value*masterScale);
   		double lastValue = value;
   		if(slaveVoltage)
   			lastValue = MasterController.getPercentOutput();
   			SlaveController.set(lastValue*slaveScale);
   		if(debug)
   			System.out.println(debugName + " Master: " + value*masterScale + " Slave: " + lastValue*slaveScale + "(" + masterScale + "," + slaveScale  +")");
   	}
   	
   	@Override
	public void set(double value, byte syncGroup) 
	{
   		MasterController.set(value*masterScale, syncGroup);
   		lastValue = MasterController.getPercentOutput();
   		SlaveController.set(lastValue*slaveScale, syncGroup);
	}
   	
	@Override
	public double get() 
	{
		return lastValue;
	}

	

	@Override
	public void disable() 
	{
		MasterController.disable();
		SlaveController.disable();
	}

	@Override
	public void pidWrite(double output) 
	{
		set(output);
	}

	@Override
	public double getPercentOutput() 
	{
		return lastValue;
	}
	
	public double getMasterScale() {
		return masterScale;
	}
   	
}

 