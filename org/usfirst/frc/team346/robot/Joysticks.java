/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team346.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Chris
 */
public class Joysticks {

	 
    private static Joystick leftJoystick = new Joystick(1);
    private static Joystick rightJoystick = new Joystick(2);
    private static Joystick buttonBoard = new Joystick(3);
    private static Joystick xController = new Joystick(4);    

    public static double getLeftJoyY() {
        return leftJoystick.getY();        
    }
    
    public static double getLeftJoyX() {
        return leftJoystick.getX();
    }

    public static boolean getLeftJoyButtonPushed(int button) {
        return leftJoystick.getRawButton(button);
    }

    public static double getRightJoyY() {
        return rightJoystick.getY();
    }
    
    public static double getRightJoyX() {
        return rightJoystick.getX();
    }

    public static boolean getRightJoyButtonPushed(int button) {
        return rightJoystick.getRawButton(button);
    }
    
    public static boolean getButtonBoardButtonPushed(int button) {
        return buttonBoard.getRawButton(button);
    }
    
    public static double getControllerLeftY() {
    	return xController.getRawAxis(1);
    }
    
    public static double getControllerRightY() {
    	return xController.getRawAxis(5);
    }
    
    public static double getControllerLeftTrigger() {
    	return xController.getRawAxis(2);
    }
    
    public static double getControllerRightTrigger() {
    	return xController.getRawAxis(3);
    }
    
    public static double getControllerRightX() {
    	return xController.getRawAxis(4);
    }
}
