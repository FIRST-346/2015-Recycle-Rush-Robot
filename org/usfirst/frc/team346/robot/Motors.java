package org.usfirst.frc.team346.robot;

import org.usfirst.frc.team346._Controllers.PairedDrive;
import org.usfirst.frc.team346._Controllers._CANTalon;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TalonSRX;

public class Motors {
	static Preferences prefs;
    public static _CANTalon leftDrive;
    public static _CANTalon rightDrive;
    public static _CANTalon xDrive;
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
    	leftDrive = new _CANTalon(6);
    	rightDrive = new _CANTalon(4);
    	xDrive = new _CANTalon(5);
    	
    	leftDrive.changeControlMode(ControlMode.Speed);
    	leftDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftDrive.setPID(prefs.getDouble("P",0), prefs.getDouble("I", 0), prefs.getDouble("D",0));
    	leftDrive.enableControl();
    	
    	rightDrive.changeControlMode(ControlMode.Speed);
    	rightDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightDrive.setPID(prefs.getDouble("P",0), prefs.getDouble("I", 0), prefs.getDouble("D",0));
    	rightDrive.enableControl();
    	
    	xDrive.changeControlMode(ControlMode.Speed);
    	xDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	xDrive.setPID(prefs.getDouble("xP",0), prefs.getDouble("xI", 0), prefs.getDouble("xD",0));
    	xDrive.enableControl();
    	
    	leftDrive.setPosition(0);
    	rightDrive.setPosition(0);
    	
    	yPairedDrive = new PairedDrive(leftDrive,rightDrive);
    	yPairedDrive.slaveVoltage = false;
    	yPairedDrive.setMasterScale(-1);
    	
    	yawPairedDrive = new PairedDrive(leftDrive,rightDrive);
    	yawPairedDrive.slaveVoltage = false;
    }
    
    public static void stopDriveMotors() {
        leftDrive.set(0);
        rightDrive.set(0);
    }
    
    public static void controllerDrive() {
		double currentP = prefs.getDouble("P", 0);
		double currentI = prefs.getDouble("I", 0);
		double currentD = prefs.getDouble("D", 0);
		if(lastP !=  currentP || lastI != currentI || lastD != currentD){
			leftDrive.setPID(currentP, currentI, currentD);
			rightDrive.setPID(currentP, currentI, currentD);
			lastP = currentP;
			lastI = currentI;
			lastD = currentD;
		}
		
		xCurrentP = prefs.getDouble("P", 0);
		double xCurrentI = prefs.getDouble("I", 0);
		double xCurrentD = prefs.getDouble("D", 0);
		if(lastP !=  xCurrentP || lastI != xCurrentI || lastD != xCurrentD){
			xDrive.setPID(xCurrentP, xCurrentI, xCurrentD);
			xLastP = xCurrentP;
			xLastI = xCurrentI;
			xLastD = xCurrentD;
		}
    	
    	leftDrive.set(Joysticks.getControllerLeftY() * -prefs.getDouble("yMult", 1000));
    	rightDrive.set(Joysticks.getControllerRightY() * prefs.getDouble("yMult", 1000));
    	//yPairedDrive.set(Joysticks.getControllerRightY() * prefs.getDouble("JoyMult", 1000));
		//yawPairedDrive.set(Joysticks.getControllerRightY() * prefs.getDouble("JoyMult", 1000));
		xDrive.set((-Joysticks.getControllerLeftTrigger()+Joysticks.getControllerRightTrigger()) 
				* prefs.getDouble("xMulti", 1000));
    }
}
