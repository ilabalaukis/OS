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
}
