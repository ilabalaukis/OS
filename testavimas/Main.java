import java.util.*;
import java.io.*;
public class Main
{
	static int vmIterator = 0;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args)
	{
		
		RealMachine realMachine = new RealMachine();
		//Machine 	machine		= new Machine(); //TODO: ištrinti testavimas
		HashMap<String, Integer> command = new HashMap<String, Integer>();
		ArrayList<VirtualMachine> virtualMachines = new ArrayList<VirtualMachine>();
		//Registras + Registras
		command.put("ADD", new Integer(0001));
    	command.put("SUB", new Integer(0002));
      	command.put("MUL", new Integer(0003));
      	command.put("DIV", new Integer(0004));

      	command.put("LR", new Integer(0011));
		command.put("LR", new Integer(0011));

		command.put("PUSH", new Integer(0021));
		command.put("POP", new Integer(0022));

		command.put("OR", new Integer(0031));
		command.put("AND", new Integer(0032));
		command.put("XOR", new Integer(0033));
		command.put("NOT", new Integer(0034));
		command.put("NEG", new Integer(0035));
		command.put("CMP", new Integer(0036));

		command.put("JMP", new Integer(0041));
		command.put("JMG", new Integer(0042));
		command.put("JME", new Integer(0043));

		command.put("HALT", new Integer(0051));

		command.put("PRNT", new Integer(0061));

		command.put("LUM", new Integer(0071));
		command.put("LEM", new Integer(0072));
		System.out.println("Hello, this is Atlas machine.");
/////////////////////////////SANDBOX////////////////////////////////
/*
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
virtualMachines.add(new VirtualMachine(realMachine));
//virtualMachines.get(1).blocksTaken = 1;
//System.out.println(virtualMachines.get(3).blocksTaken);

virtualMachines.get(0).setDRA(5);
System.out.println(virtualMachines.get(1).getDRA());
System.out.println(realMachine.getDRA());

//virtualMachines.get(2).realMachine.setTI(5);
//System.out.println(virtualMachines.get(1).realMachine.getTI());
//System.out.println(realMachine.getTI());

//realMachine.setMODE(true);
//System.out.println(virtualMachines.get(1).realMachine.getMODE());

*////////////////////////////SANDBOX ENDS////////////////////////////
	
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
	public static void createVMprogram(VirtualMachine virtualMachine){
		
	}
}
