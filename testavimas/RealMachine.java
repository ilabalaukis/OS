public class RealMachine extends Machine
{
	private int[] userMemory = new int[1500];
	
	//Interrupt Registers
	private int TI = 0;
	private int PI = 0;
	private int IOI = 0;
	private int SI = 0;
	//Segment Registers
	private int DS = 0000;
	private int CS = 0700;
	private int SS = 1400;
	//Other Registers
	//private int IC = 0000;
	//private int SP = 0000;
	private int PTR = 0;
	private boolean MODE = false;
	//private int SF = 0000;
	
	//getters and setters
	public int getTI()
	{
		return this.TI;
	}
	public void setTI(int TI)
	{
		this.TI = TI;
	}
	public int getPI()
	{
		return this.PI;
	}
	public void setPI(int PI)
	{
		this.PI = PI;
	}
	public int getIOI()
	{
		return this.IOI;
	}
	public void setIOI(int IOI)
	{
		this.IOI = IOI;
	}
	public int getSI()
	{
		return this.SI;
	}
	public void setSI(int setSI)
	{
		this.SI = SI;
	}
	public int getDS()
	{
		return this.DS;
	}
	public void setDS(int DS)
	{
		this.DS = DS;
	}
	public int getCS()
	{
		return this.CS;
	}
	public void setCS(int CS)
	{
		this.CS = CS;
	}
	public void getSS(int SS)
	{
		this.SS = SS;
	}
	public int getIC()
	{
		return this.IC;
	}
	public void setIC(int IC)
	{
		this.IC = IC;
	}
	public int getSP()
	{
		return this.SP;
	}
	public void setSP(int SP)
	{
		this.SP = SP;
	}
	public int getPTR()
	{
		return this.PTR;
	}
	public void setPTR(int PTR)
	{
		this.PTR = PTR;
	}
	public boolean getMODE()
	{
		return this.MODE;
	}
	public void setMODE(boolean MODE)
	{
		this.MODE = MODE;
	}
	public int getSF()
	{
		return this.SF;
	}
	public void setSF(int SF)
	{
		this.SF = SF;
	}

	//Commands
	public void ADD(String reg, int par1, int par2)
	{
		switch(reg){
			case "DRA":
				this.DRA = par1 + par2;
			case "DRB":
				this.DRB = par1 + par2;
		}
	} 
}

