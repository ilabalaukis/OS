import java.util.*;
//Virtuali mašina max 120 žodžių.
//Blokas - 15 žodžių.
//Dalinamas blokas taip: 6 žodžiai DS, 6 žodžiai CS, 3 žodžiai SS.
//Pirmas blokas - 5 žodžiai rezervas registrų reikšmėms, 4  DS, 4 CS ir 2 SS 
//Puslapiavimo Lentelė: Bloko numeris(0-99) [Baitas] , VM numeris [Baitas], (0..7) bloko numeris VM
//CS segmentas :Absoliutus adresas if(bloko numeris vm == 0){ absoliutus_adresas = bloko_numeris*15+5 }
//else{ absoliutus adresas = bloko_numeris*15 
public class VirtualMachine extends Machine
{
	
	public static RealMachine realMachine;
	private int[] registerSpace = new int[8];
	private ArrayList<Integer> dataSegment = new ArrayList<Integer>();
	private ArrayList<Integer> codeSegment = new ArrayList<Integer>();
	private ArrayList<Integer> stackSegment = new ArrayList<Integer>();
	public int blocksTaken = 2;
	private int[] virtualMemory = new int[15];
	public VirtualMachine(RealMachine realMachine){
		this.realMachine = realMachine;
	}
	public void saveRegisters()
	{
		
	} 
}
