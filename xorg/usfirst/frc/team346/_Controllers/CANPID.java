package xorg.usfirst.frc.team346._Controllers;

public interface CANPID
{
	public void setP(double P);
	public void setI(double I);
	public void setD(double D);
	public void setF(double F);
	
	public double getP();
	public double getI();
	public double getD();
	public double getF();
	
	public void setPID(double p, double i, double d);
	
	public void setIZone(int izone);
	public double getIZone();
	
	public void disableControl();
	public void enableControl();
	public void setPosition(double Position);
	
	public double getOutputVoltage();
	

}
