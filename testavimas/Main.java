import java.util.*;
import java.io.*;
public class Main
{
	static int vmIterator = 0;
	static Scanner input = new Scanner(System.in);
	static RealMachine realMachine = new RealMachine();
	static ArrayList<VirtualMachine> virtualMachines = new ArrayList<VirtualMachine>();
	public static void main(String[] args)
	{		
		
		//Machine 	machine		= new Machine(); //TODO: ištrinti testavimas
		HashMap<String, Integer> command = new HashMap<String, Integer>();

		//Registras + Registras
		System.out.println("Hello, this is Atlas machine.");

/////////////////////////////SANDBOX////////////////////////////////
/**/
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
//virtualMachines.get(1).blocksTaken = 1;
//System.out.println(virtualMachines.get(3).blocksTaken);
/**/
virtualMachines.get(0).setDRA(5);
System.out.println(virtualMachines.get(1).getDRA());
System.out.println(realMachine.getDRA());
/*
//virtualMachines.get(2).realMachine.setTI(5);
//System.out.println(virtualMachines.get(1).realMachine.getTI());
//System.out.println(realMachine.getTI());

//realMachine.setMODE(true);
//System.out.println(virtualMachines.get(1).realMachine.getMODE());

*////////////////////////////SANDBOX ENDS////////////////////////////
		 ArrayList<Integer> A = parseCommands("ADD DRA 09");
		System.out.println(A.get(1));
		showCommands();
		while(true)
		{
			String comm = input.next().toUpperCase();
			if( comm.equals("EXIT") ){
				System.out.println("Goodbye.");
				break;
			}
			switch(comm){
				case "NEW":
					System.out.println("NEW called.");
					break;
				case "NEWV":
					System.out.println("NEWV called.");
					virtualMachines.add(new VirtualMachine(realMachine));
					createVMprogram(virtualMachines.get(virtualMachines.size()-1));
					break;
				case "START":
					System.out.println("START called.");
					if( virtualMachines.isEmpty() )
					{
						System.out.println("vm is empty");
						//System.out.println(vmIterator);
					}
					else
					{
						System.out.println("vm is not empty");
						vmExecutionMode(virtualMachines);
					}
					
					break;
				case "HELP":
					showCommands();
					break;
				default:
					System.out.println("Command not found.");
			}
			
		}

	}
	public static ArrayList<Integer> parseCommands(String line)
	{
		String[] parts = line.split(" ");
		ArrayList<Integer> A = new ArrayList<Integer>();
		int SK = 0;
		String regex = "\\d+";

		if (parts[2].matches(regex))
		{
			SK = Integer.parseInt(parts[2]);
			parts[2] = "SK";
		}
		switch (parts[0])
		{
			case "ADD":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 1000);
								return A;
							case "SK":
								A.clear();
								A.add(0, 1004);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								System.out.Println("Invalid command");
								break;     
						}
					break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 1001);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 1005);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								System.out.Println("Invalid command");
								break;       
						}
					break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 1002);
								return A;  
							case "DRB":
								A.add(0, 1003);
								return A;
							case "SK":
								A.clear();
								A.add(0, 1006);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								System.out.Println("Invalid command");
								break;   
						}
					break;
				}
			break;
		}
	return A;
	}

	public static void showCommands(){
		System.out.println("Available Commands:");
		System.out.println("HELP - this help page.");
		System.out.println("NEW - creates new program.");
		System.out.println("NEWV - creates new virtual machine.");
		System.out.println("START - start programs execution mode.");
		System.out.println("EXIT - turn off the machine.");
	}
	public static void vmExecutionMode(ArrayList<VirtualMachine> virtualMachines)
	{
		VirtualMachine currentMachine = virtualMachines.get(vmIterator);
		currentMachine.realMachine.setTI(10);
		//Loopas sustos kiekvienu stepu, nebent parašysi SKIP
		String dontStop = "";
		while( currentMachine.realMachine.getTI() > 0 )
		{
			if( !dontStop.equals("SKIP"))
			{
				dontStop = input.next();
			}
			//Do Commands
			//virtualMachines.get(vmIterator)
			vmIterator =  (++vmIterator == virtualMachines.size()) ? 0 : vmIterator;
			
		}

		//Set set = command.entrySet();
		
		//Iterator i = set.iterator();
		//machine.ADD("DRB", -1, 11); //TODO: ištrinti testavimas
	//System.out.println(machine.DRB); //TODO: ištrinti testavimas
	}
	public static void executeCommand( VirtualMachine virtualMachine )
	{
		int IC = virtualMachine.getIC();
	}
	public static void createVirtualMachine(){
		virtualMachines.add(new VirtualMachine(realMachine));
		// SUPRATAU! virtualMachines.get(1).realMachine.;
	}
	public static VirtualMachine addBlocks(VirtualMachine virtualMachine){
		
		return virtualMachine;
	}
	public static void createVMprogram(VirtualMachine virtualMachine){
		
	}
}
