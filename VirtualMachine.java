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
	private static int numberOfMachines = 0;
	private int VM_Id;
	public static RealMachine realMachine;
	private int[] registerSpace = new int[5];
	private ArrayList<Integer> dataSegment = new ArrayList<Integer>();
	private ArrayList<Integer> codeSegment = new ArrayList<Integer>();
	private ArrayList<Integer> stackSegment = new ArrayList<Integer>();
	private int[] virtualMemory = new int[15];
	private int blocksTaken = 0;

	public VirtualMachine(RealMachine realMachine){
		this.realMachine = realMachine;
		VM_Id = ++numberOfMachines;
		this.addBlock();
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
	public int getID(){
		return this.VM_Id;
	}
	/**
	 * Loads Register
	 * reg - register name
	 * type - register type
	 * operand - operand id? bbz
	 */
	public void LR(String reg, String type , int operand)
	{
		switch(reg)
		{
			case "SF":
				switch(type)
				{
					//Not and adress
					case "NA":
						this.SF = operand;
						break;
					//Adress
					case "A":
// CONSTANTS - USE THEM, DONT BE IDIOTS - WTF IS 4+6*THIS.BLOCKSTAKEN - UPPER_SF_LIMIT IS MUCH MORE CLEAR
						if( operand < (4 + 6*this.blocksTaken) && operand >= 0){
							this.SF = this.dataSegment.get(operand);
						}else if( operand < (8 + 12*this.blocksTaken) && operand >= 0){
							this.SF = this.codeSegment.get(operand - (4 + 6*this.blocksTaken));
						}else if( operand < (10 + 15*this.blocksTaken) && operand >= 0){
							this.SF = this.stackSegment.get(operand - (8 + 12*this.blocksTaken));
						}else{
							System.out.println("LR method: Invalid 3rd operand.");
						}
						break;
					default:
						System.out.println("LR method: Invalid 2nd operand.");
						break;
				}
				break;
			case "DRA":
				switch(type)
				{
					//Not and adress
					case "NA":
						this.DRA = operand;
						break;
					//Adress
					case "A":
						if( operand < (4 + 6*this.blocksTaken) && operand >= 0){
							this.DRA = this.dataSegment.get(operand);
						}else if( operand < (8 + 12*this.blocksTaken) && operand >= 0){
							this.DRA = this.codeSegment.get(operand - (4 + 6*this.blocksTaken));
						}else if( operand < (10 + 15*this.blocksTaken) && operand >= 0){
							this.DRA = this.stackSegment.get(operand - (8 + 12*this.blocksTaken));
						}else{
							System.out.println("LR method: Invalid 3rd operand.");
						}
						break;
					default:
						System.out.println("LR method: Invalid 2nd operand.");
						break;
				}
				break;
			case "DRB":
				switch(type)
				{
					//Not and adress
					case "NA":
						this.DRB = operand;
						break;
					//Adress
					case "A":
						if( operand < (4 + 6*this.blocksTaken) && operand >= 0){
							this.DRB = this.dataSegment.get(operand);
						}else if( operand < (8 + 12*this.blocksTaken) && operand >= 0){
							this.DRB = this.codeSegment.get(operand - (4 + 6*this.blocksTaken));
						}else if( operand < (10 + 15*this.blocksTaken) && operand >= 0){
							this.DRB = this.stackSegment.get(operand - (8 + 12*this.blocksTaken));
						}else{
							System.out.println("LR method: Invalid 3rd operand.");
						}
						break;
					default:
						System.out.println("LR method: Invalid 2nd operand.");
						break;
				}
				break;
			default:
				System.out.println("LR method: Incorrect register");
		}
	}
	public void POP(String reg){
		if (this.SP != 0)
		{
			switch (reg)
			{
				case "DRA":
					this.DRA = this.stackSegment.get(SP);
					SP = SP - 1;
					break;
				case "DRB":
					this.DRB = this.stackSegment.get(SP);
					SP = SP - 1;
					break;
				default:
					break;
			}
		}
		else
		{
			//Interuptas
		}
	}
	public void SR(String reg, int address){
		switch(reg)
		{
			case "DRA":
				if( address < (4 + 6*this.blocksTaken) && address >= 0){
					this.dataSegment.set(address, this.DRA);
				}else if( address < (8 + 12*this.blocksTaken) && address >= 0){
					this.codeSegment.set(address - (4 + 6*this.blocksTaken), this.DRA);
				}else if( address < (10 + 15*this.blocksTaken) && address >= 0){
					this.stackSegment.set(address - (8 + 12*this.blocksTaken), this.DRA);
				}else{
					System.out.println("SR method: Invalid adress.");
				}
				break;
			case "DRB":
				if( address < (4 + 6*this.blocksTaken) && address >= 0){
					this.dataSegment.set(address, this.DRB);
				}else if( address < (8 + 12*this.blocksTaken) && address >= 0){
					this.codeSegment.set(address - (4 + 6*this.blocksTaken), this.DRB);
				}else if( address < (10 + 15*this.blocksTaken) && address >= 0){
					this.stackSegment.set(address - (8 + 12*this.blocksTaken), this.DRB);
				}else{
					System.out.println("SR method: Invalid adress.");
				}
				break;
			case "SF":
				if( address < (4 + 6*this.blocksTaken) && address >= 0){
					this.dataSegment.set(address, this.SF);
				}else if( address < (8 + 12*this.blocksTaken) && address >= 0){
					this.codeSegment.set(address - (4 + 6*this.blocksTaken), this.SF);
				}else if( address < (10 + 15*this.blocksTaken) && address >= 0){
					this.stackSegment.set(address - (8 + 12*this.blocksTaken), this.SF);
				}else{
					System.out.println("SR method: Invalid address.");
				}
				break;
		}
	}
	public void addBlock(){
		List<Integer[]> alteredPT = realMachine.getPT();
		if(this.blocksTaken < 8){
			for(int i=0 ; i<100 ; i++){
				if( alteredPT.get(i)[0] == 0 ){
					alteredPT.get(i)[0] = this.VM_Id;
					alteredPT.get(i)[1] = this.blocksTaken++;
					break;
				}
			}
			realMachine.setPT(alteredPT);
			//Išskirsto bloką į virtualios mašinos segmentus
			if( this.blocksTaken > 1 ){ 
				for(int i = 0 ; i < 6 ; i++){
					//Blokas pasidalina: 6 DS, 6 CS ir 3 SS
					this.dataSegment.add(0);
					this.codeSegment.add(0);
					if(i > 2){
						this.stackSegment.add(0);
					}
				}
			}else{
				for(int i = 0 ; i < 4 ; i++){
					//Blokas pasidalina: 4 DS, 4 CS ir 2 SS
					this.dataSegment.add(0);
					this.codeSegment.add(0);
					if(i > 1){
						this.stackSegment.add(0);
					}
				}
			}
		}
	}
}
