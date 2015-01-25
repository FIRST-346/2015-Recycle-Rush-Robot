package org.usfirst.frc.team346.robot;

import org.usfirst.frc.team346._Controllers.PairedDrive;
import org.usfirst.frc.team346._Controllers._CANTalon;
import org.usfirst.frc.team346._Mixers.MixSpeedController;
import org.usfirst.frc.team346._Mixers.NormalizationMixer;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TalonSRX;

public class Motors {
	static Preferences prefs;
    public static MixSpeedController<_CANTalon> leftDrive;
    public static MixSpeedController<_CANTalon> rightDrive;
    public static MixSpeedController<_CANTalon> xDrive;
    public static NormalizationMixer driveMixer, transMixer;
    public static PairedDrive yPairedDrive;
    public static PairedDrive yawPairedDrive;
    
    static double lastP;
    static double lastI;
    static double lastD;
    static double currentP;
    static double currentI;
    static double currentD;
    
    static double xLastP;
    static double xLastI;
    static double xLastD;
    static double xCurrentP;
    static double xCurrentI;
    static double xCurrentD;
    
    public static void initMotors() {
    	driveMixer = new NormalizationMixer();
    	transMixer = new NormalizationMixer();
    	
    	leftDrive = new MixSpeedController<_CANTalon>(new _CANTalon(6));
    	rightDrive = new MixSpeedController<_CANTalon>(new _CANTalon(4));
    	xDrive = new MixSpeedController<_CANTalon>(new _CANTalon(5));
    	
    	leftDrive.output.changeControlMode(ControlMode.Speed);
    	leftDrive.output.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftDrive.output.setPID(prefs.getDouble("P",0), prefs.getDouble("I", 0), prefs.getDouble("D",0));
    	leftDrive.output.enableControl();
    	leftDrive.setScale(1000);
    	
    	rightDrive.output.changeControlMode(ControlMode.Speed);
    	rightDrive.output.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightDrive.output.setPID(prefs.getDouble("P",0), prefs.getDouble("I", 0), prefs.getDouble("D",0));
    	rightDrive.output.enableControl();
    	rightDrive.setScale(1000);
    	
    	driveMixer.addToMix(leftDrive,rightDrive);
    	
    	xDrive.output.changeControlMode(ControlMode.Speed);
    	xDrive.output.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	xDrive.output.setPID(prefs.getDouble("xP",0), prefs.getDouble("xI", 0), prefs.getDouble("xD",0));
    	System.err.println("xP: %d xI: %d, xD: %d" +  prefs.getDouble("xP",0) + " " + prefs.getDouble("xI", 0) + " " + prefs.getDouble("xD",0));
    	xDrive.output.enableControl();
    	xDrive.setScale(1000);
    	
    	transMixer.addToMix(xDrive);
    	
    	leftDrive.output.setPosition(0);
    	rightDrive.output.setPosition(0);
    	
    	yPairedDrive = new PairedDrive(leftDrive,rightDrive);
    	yPairedDrive.slaveVoltage = false;
    	yPairedDrive.setMasterScale(-1);
    	
    	yawPairedDrive = new PairedDrive(leftDrive,rightDrive);
    	yawPairedDrive.slaveVoltage = false;
    	yawPairedDrive.setScale(1000);
    }
    
    public static void stopDriveMotors() {
        leftDrive.set(0);
        rightDrive.set(0);
    }
    
    public static void checkXPID() {
    	xCurrentP = prefs.getDouble("xP", 0);
		xCurrentI = prefs.getDouble("xI", 0);
		xCurrentD = prefs.getDouble("xD", 0);
		if(xLastP !=  xCurrentP || xLastI != xCurrentI || xLastD != xCurrentD){
			xDrive.output.setPID(xCurrentP, xCurrentI, xCurrentD);
			xLastP = xCurrentP;
			xLastI = xCurrentI;
			xLastD = xCurrentD;
		}
    }
    
    public static void checkPID() {
    	currentP = prefs.getDouble("P", 0);
		currentI = prefs.getDouble("I", 0);
		currentD = prefs.getDouble("D", 0);
		if(lastP !=  currentP || lastI != currentI || lastD != currentD){
			leftDrive.output.setPID(currentP, currentI, currentD);
			rightDrive.output.setPID(currentP, currentI, currentD);
			lastP = currentP;
			lastI = currentI;
			lastD = currentD;
		}
    }
    
    public static void controllerDrive() {
		checkPID();
		checkXPID();
    	
    	leftDrive.set(-Joysticks.getControllerLeftY());
    	rightDrive.set(Joysticks.getControllerRightY());
    	//yPairedDrive.set(Joysticks.getControllerRightY() * prefs.getDouble("JoyMult", 1000));
		//yawPairedDrive.set(Joysticks.getControllerRightY() * prefs.getDouble("JoyMult", 1000));
		xDrive.set(-Joysticks.getControllerLeftTrigger()+Joysticks.getControllerRightTrigger());
		System.err.println("Trans: " + -Joysticks.getControllerLeftTrigger()+Joysticks.getControllerRightTrigger());
		driveMixer.apply();
		transMixer.apply();
    }
}
