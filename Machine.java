public class Machine
{
//PASTABA: skaiciai neprasideda nuliu, nes taip pasidaro astuntaine sistema...
	protected static int DRA = 0;
	protected static int DRB = 0;
	//Interrupt Registers
	protected static int TI = 0;
	protected static int PI = 0;
	protected static int IOI = 0;
	protected static int SI = 0;
	//Other Registers
	protected static int IC = 0;
	protected static int SP = 0;
	protected static int SF = 0;
	//SF reiksmes [OF][DF][NF][ZF]
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
	public int getIC()
	{
		return this.IC;
	}
	public void setIC(int IC)
	{
		this.IC = IC;
	}
	public int getTI()
	{
		return this.TI;
	}
	public void setTI(int TI)
	{
		this.TI = TI;
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
	public int negativeFlag(int sk)
	{
		if (sk < -5000)
		{
			sk = (sk % 5000) * (-1);
			this.SF = 1000;
			return sk;
		}
		if( sk < 0)
		{
			sk = (sk * (-1)) + 5000;
			this.SF = 0010;
			return sk;
		}
		return sk;
		
	}
	public int overflowFlag(int sk)
	{
		if (sk > 9999)
		{
			sk = sk % 10000;
			this.SF = 0000;
			this.SF += 1000;
		}
		return sk;
	}
	public int negativeNumber(int sk)
	{
		if (sk > 5000)
		{
			sk = sk * (-1) % 5000;
			this.setSF(10);
		}
		return sk;
	}
	public void ADD(String reg, int par1, int par2)
	{
		par1 = this.negativeNumber(par1);
		par2 = this.negativeNumber(par2);
		int add = par1 + par2;
		System.out.println(add);

		if (add > 0)
		{
			add = this.overflowFlag(add);
		}
		else
		{
			add = this.negativeFlag(add);
		}
		switch(reg)
		{
			case "DRA":
				this.DRA = add;
				break;
			case "DRB":
				this.DRB = add;
				break;
			case "SF":
				this.SF = add;
				break;
			default:
				System.out.println ("Incorrect register");
		}
	}
	public void SUB(String reg, int par1, int par2)
	{
		par1 = this.negativeNumber(par1);
		par2 = this.negativeNumber(par2);
		int sub = par1 - par2;
		if (sub > 0)
		{
			sub = this.overflowFlag(sub);
		}
		else
		{
			sub = this.negativeFlag(sub);
		}
		switch(reg)
		{
			case "DRA":
				this.DRA = sub;
				break;
			case "DRB":
				this.DRB = sub;
				break;
			case "SF":
				this.SF = sub;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void CMP(int par1, int par2)
	{
		par1 = this.negativeNumber(par1);
		par2 = this.negativeNumber(par2);
		int cmp = par1 - par2;
		this.SF = 0000;
		if( cmp < 0 ){
			this.SF = this.SF%100 != 0 ? this.SF : this.SF+10;
		}else if(cmp == 0){
			this.SF = this.SF%10 != 0 ? this.SF : this.SF+1;
		}
	}
	public void MUL(String reg, int par1, int par2)
	{
		par1 = this.negativeNumber(par1);
		par2 = this.negativeNumber(par2);
		int mul = par1 * par2;
		if (mul > 0)
		{
			mul = this.overflowFlag(mul);
		}
		else
		{
			mul = this.negativeFlag(mul);
		}
		switch(reg)
		{
			case "DRA":
				this.DRA = mul;
				break;
			case "DRB":
				this.DRB = mul;
				break;
			case "SF":
				this.SF = mul;
				break;
			default:
				System.out.println("Incorrect register");
		}
	}
	public void DIV(String reg, int par1, int par2)
	{
		par1 = this.negativeNumber(par1);
		par2 = this.negativeNumber(par2);
		int div = par1 / par2;
		if (div > 0)
		{
			div = this.overflowFlag(div);
		}
		else
		{
			div = this.negativeFlag(div);
		}
		switch(reg)
		{
			case "DRA":
				this.DRA = div;
				this.DRB = par1 % par2;
				break;
			case "DRB":
				this.DRA = div;
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
	public int validateNumber(int _par)
	{
		if (_par > 9999 || _par < -5000)
		{
			throw new IllegalArgumentException(Integer.toString(_par));
		}
		else
		{
			if (_par < 0)
			{
				_par = (_par - 5000) * (-1);
				this.setSF(10);
			}
			else
			{
				this.SF = 0000;
			}
		}
		return _par;	
	}

}
