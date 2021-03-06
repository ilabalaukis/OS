 import java.util.*;
public class RealMachine extends Machine
{
	private static int[] userMemory = new int[1500];
	//Puslapiavimo lentelė:
	private static List<Integer[]> PT = new ArrayList<Integer[]>();
	//Bloko numeris 0-99; VM numeriai 5 bitai, t.y. negali viršyti 31; bloko numeris 3 bitai, t.y. negali viršyti 7.
	//PTR susideda iš 4 skaičių: VM_Skaičius 2 skaičiai ir Einamosios_VM_Numeris 2 skaičiai.
	//Segment Registers
	private int DS = 0;
	private int CS = 700;
	private int SS = 1400;
	//Other Registers
	//private int IC = 0000;
	//private int SP = 0000;
	private static int PTR = 0;
	private static boolean MODE = false;
	//private int SF = 0000;
	//Constructor
	RealMachine(){	
		while(PT.size() < 100){
			PT.add(new Integer[2]); //Bloko numeris yra indeksas
			PT.get(PT.size()-1)[0] = 0; //VM numeris > 0
			PT.get(PT.size()-1)[1] = 0; //Bloko VM-e numeris 0-7
		}
	}
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
	public void setSI(int SI)
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

	public List<Integer[]> getPT(){
		return this.PT;
	}
	public void setPT(List<Integer[]> PT){
		this.PT = PT;
	}
}

