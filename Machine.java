public class Machine
{
	protected int DRA = 0000;
	protected int DRB = 0000;
	//Interrupt Registers
//	private int TI = 0000;
//	private int PI = 0000;
//	private int IOI = 0000;
//	private int SI = 0000;
	//Segment Registers
	protected int DS = 0000;
	protected int CS = 0700;
	protected int SS = 1400;
	//Other Registers
	protected int IC = 0000;
	protected int SP = 0000;
	protected int SF = 0000;
	//getters and setters
	public int getDRA()
	{
		return this.DRA;
	}
	public void setDRA(int DRA)
	{
		this.DRA = DRA;
	}
	public int getDRB()
	{
		return this.DRB;
	}
	public void setDRB(int DRB)
	{
		this.DRB = DRB;
	}
	/*public int getTI()
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
	}*/
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
	public int getSF()
	{
		return this.SF;
	}
	public void setSF(int SF)
	{
		this.SF = SF;
	}
	//Commands
	//Virtual Machine Commands Commands
	public void ADD(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "DRA":
				this.DRA = par1 + par2;
				break;
			case "DRB":
				this.DRB = par1 + par2;
				break;
			case "SF":
				this.SF = par1 + par2;
				break;
			default:
				System.out.println ("Incorrect register");
		}
	}
	public void SUB(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "DRA":
				this.DRA = par1 - par2;
				break;
			case "DRB":
				this.DRB = par1 - par2;
				break;
			case "SF":
				this.SF = par1 - par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void MUL(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "DRA":
				this.DRA = par1 * par2;
				break;
			case "DRB":
				this.DRB = par1 * par2;
				break;
			case "SF":
				this.SF = par1 * par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void DIV(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "DRA":
				this.DRA = par1 / par2;
				this.DRB = par1 % par2;
				break;
			case "DRB":
				this.DRA = par1 / par2;
				this.DRB = par1 % par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	/*public void PUSH(int par1)
	{
		this.SS = SS + SP;
	}
	virtual memory or memory
	*/
	public void OR(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "IC":
				this.IC = par1 | par2;
				break;
			case "SF":
				this.SF = par1 | par2;
				break;
			case "DRA":
				this.DRA = par1 | par2;
				break;
			case "DRB":
				this.DRB = par1 | par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void XOR(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "IC":
				this.IC = par1 ^ par2;
				break;
			case "SF":
				this.SF = par1 ^ par2;
				break;
			case "DRA":
				this.DRA = par1 ^ par2;
				break;
			case "DRB":
				this.DRB = par1 ^ par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void AND(String reg, int par1, int par2)
	{
		switch(reg)
		{
			case "IC":
				this.IC = par1 & par2;
				break;
			case "SF":
				this.SF = par1 & par2;
				break;
			case "DRA":
				this.DRA = par1 & par2;
				break;
			case "DRB":
				this.DRB = par1 & par2;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void NOT(String reg, int par1)
	{
		switch(reg)
		{
			case "IC":
				this.IC = par1 + 1;
				break;
			case "SF":
				this.SF = par1 + 1;
				break;
			case "DRA":
				this.DRA = par1 + 1;
				break;
			case "DRB":
				this.DRB = par1 + 1;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void NEG(String reg, int par1)
	{
		switch(reg)
		{
			case "IC":
				this.IC = par1 * (-1);
				break;
			case "SF":
				this.SF = par1 * (-1);
				break;
			case "DRA":
				this.DRA = par1 * (-1);
				break;
			case "DRB":
				this.DRB = par1 * (-1);
				break;
			default:
				System.out.println("Incorrect register");
		}
	}

}
