
package org.usfirst.frc.team346.robot;

import org.usfirst.frc.team346._Controllers.GyroPIDSource;
import org.usfirst.frc.team346._Controllers.JaguarPositionPIDSource;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	SmartDashboard smartDash;
    SendableChooser autoChooser;
    static Preferences prefs;
    
    public void robotInit() {
    	autoChooser = new SendableChooser();
        smartDash = new SmartDashboard();
    	prefs = Preferences.getInstance();
    	Motors.prefs = prefs;
    	Motors.initMotors();
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    @SuppressWarnings("static-access")
	public void teleopPeriodic() {
    	Motors.controllerDrive();
    	smartDash.putNumber("Left Encoder", Motors.leftDrive.getSpeed());
    	smartDash.putNumber("Right Encoder", Motors.rightDrive.getSpeed());
    	smartDash.putNumber("Trans Encoder", Motors.xDrive.getSpeed());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
