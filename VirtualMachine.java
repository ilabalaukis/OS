import java.util.*;
//Virtuali mašina max 120 žodžių.
//Blokas - 15 žodžių.
//Dalinamas blokas taip: 6 žodžiai DS, 6 žodžiai CS, 3 žodžiai SS.
//Pirmas blokas - 5 žodžiai rezervas registrų reikšmėms, 4  DS, 4 CS ir 2 SS 
//Puslapiavimo Lentelė: Bloko numeris(0-99) [Baitas] , VM numeris [Baitas], (0..7) bloko numeris VM
//DS segmentas :Absoliutus adresas if(bloko numeris vm == 0){ absoliutus_adresas = bloko_numeris*15+5 }
//else{ absoliutus adresas = bloko_numeris*15 
public class VirtualMachine extends Machine
{
	
	public static RealMachine realMachine;
	private int[] registerSpace = new int[5];
	private ArrayList<Integer> dataSegment = new ArrayList<Integer>();
	private ArrayList<Integer> codeSegment = new ArrayList<Integer>();
	private ArrayList<Integer> stackSegment = new ArrayList<Integer>();
	private int[] virtualMemory = new int[15];
	public VirtualMachine(RealMachine realMachine){
		this.realMachine = realMachine;
	}
	public int[] getRegisterSpace(){
		return this.registerSpace;
	}
	public void saveRegisters()
	{
		this.registerSpace[0] = realMachine.getDRA();
		this.registerSpace[1] = realMachine.getDRB();
		this.registerSpace[2] = realMachine.getIC();
		this.registerSpace[3] = realMachine.getSF();
		this.registerSpace[4] = realMachine.getSP();
	}
	public void loadRegisters()
	{
		this.setDRA(this.registerSpace[0]);
		this.setDRB(this.registerSpace[1]);
		this.setIC(this.registerSpace[2]);
		this.setSF(this.registerSpace[3]);
		this.setSP(this.registerSpace[4]);
	}
	public ArrayList<Integer> getDS(){
		return this.dataSegment;
	}
	public ArrayList<Integer> getCS(){
		return this.codeSegment;
	}
	public ArrayList<Integer> getSS(){
		return this.stackSegment;
	}
	public void setDS(ArrayList<Integer> DS){
		this.dataSegment = DS;
	}
	public void setCS(ArrayList<Integer> CS){
		this.codeSegment = CS;
	}
	public void setSS(ArrayList<Integer> SS){
		this.stackSegment = SS;
	}
}
