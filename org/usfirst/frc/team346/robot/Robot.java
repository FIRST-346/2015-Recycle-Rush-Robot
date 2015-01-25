
package org.usfirst.frc.team346.robot;

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
    public Gyro gyro;
    public Gyro temp;
    public Accelerometer accel;
    
    public void robotInit() {
    	autoChooser = new SendableChooser();
        smartDash = new SmartDashboard();
    	prefs = Preferences.getInstance();
    	gyro = new Gyro(0);
    	temp = new Gyro(1);
    	accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
    	gyro.reset();
    	gyro.initGyro();
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
    	smartDash.putNumber("Accel Y", accel.getY());
    	smartDash.putNumber("Accel X", accel.getX());
    	smartDash.putNumber("Gyro Angle", gyro.getAngle());
    	smartDash.putNumber("Gyro Rate", gyro.getRate());
    	smartDash.putNumber("Left Encoder", Motors.leftDrive.output.getSpeed());
    	smartDash.putNumber("Right Encoder", Motors.rightDrive.output.getSpeed());
    	smartDash.putNumber("Trans Encoder", Motors.xDrive.output.getSpeed());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
