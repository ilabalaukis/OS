public class RealMachine
{
	private int[] userMemory = int[1500];
	//Processor
	//Data Registers
	private int DRA = 0000;
	private int DRB = 0000;
	//Interrupt Registers
	private int TI = 0000;
	private int PI = 0000;
	private int IOI = 0000;
	private int SI = 0000;
	//Segment Registers
	private int DS = 0000;
	private int CS = 0700;
	private int SS = 1400;
	//Other Registers
	private int IC = 0000;
	private int SP = 0000;
	private int PTR = 0000;
	private boolean MODE = 0000;
	private int SF = 0000;
	
	//getters and setters
	private int getDRA()
	{
		return this.DRA;
	}
	private void setDRA(int DRA)
	{
		this.DRA = DRA;
	}
	private int getDRB()
	{
		return this.DRB;
	}
	private void setDRB(int DRB)
	{
		this.DRB = DRB;
	}
	private int getTI()
	{
		return this.TI;
	}
	private void setTI(int TI)
	{
		this.TI = TI;
	}
	//Commands
	public void ADD(string reg, int par1, int par2)
	{
		switch(reg){
			case "DRA":
				this.DRA = par1 + par2;
			case "DRB":
				this.DRB = par1 + par2;
		}
	} 
}
