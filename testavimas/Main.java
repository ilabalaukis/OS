import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		 //ArrayList<Integer> A = parseCommands("ADD DRA A");
		 try{
		File f= new File("testas.txt");
		BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
  		ArrayList<Integer> A = parseCommands(readLine);
  		if (!A.isEmpty())
  			System.out.println(A.get(0));
		}
		b.close();
		
        } catch (IOException e) {
            e.printStackTrace();
        }		
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
		A.add(0, 9999);
		int SK = 0;
		int SK1 = 0;
		String regex = "\\d+";
		if (parts.length > 1)
		{
			if (parts[1].equals("SK"))
			{
				return A;
			}
		}
		if (parts.length > 2)
		{
			if (parts[2].equals("SK"))
			{
				return A;
			}
		}
		if (parts.length > 2)
		{
			if (parts[2].matches(regex))
			{
				SK = Integer.parseInt(parts[2]);
				parts[2] = "SK";
			}
		}
		if (parts.length > 1)
		{
			if (parts[1].matches(regex))
			{
				SK1 = Integer.parseInt(parts[1]);
				parts[1] = "SK";
			}
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
								System.out.println("Invalid command");
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
								A.add(0, 9999);
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
								A.add(0, 9999);
								break;   
						}
							break;
						default:
							A.clear();
							A.add(0, 9999);
							break;   
				}
					break;
			case "SUB":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 1100);
								return A;
							case "SK":
								A.clear();
								A.add(0, 1104);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;     
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 1101);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 1105);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;       
						}
						break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 1102);
								return A;  
							case "DRB":
								A.add(0, 1103);
								return A;
							case "SK":
								A.clear();
								A.add(0, 1106);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
				break;
			case "MUL":
				switch (parts[1])
				{
					case "DRA":
						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 1200);
								return A;
							case "SK":
								A.clear();
								A.add(0,1202);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();	
								A.add(0, 1201);
								return A;
							case "SK":
								A.clear();
								A.add(0,1203);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;
						}
						break;	
				}
			case "DIV":
				switch (parts[1])
				{
					case "DRA":
						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 1300);
								return A;
							case "SK":
								A.clear();
								A.add(0,1302);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();	
								A.add(0, 1301);
								return A;
							case "SK":
								A.clear();
								A.add(0,1303);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;
						}
						break;	
				}
			case "LR":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 2000);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 2001);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
			case "SR":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 2100);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 2101);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
			case "PUSH":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 3000);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 3001);
						return A;
					case "SK":
						A.clear();
						A.add(0, 3002);
						A.add(1, SK1);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
			case "POP":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 3100);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 3101);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
			case "OR":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 4000);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4004);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;     
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 4001);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 4005);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;       
						}
						break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 4002);
								return A;  
							case "DRB":
								A.add(0, 4003);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4006);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;						
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
				break;
			case "AND":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 4100);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4104);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;     
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 4101);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 4105);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;       
						}
						break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 4102);
								return A;  
							case "DRB":
								A.add(0, 4103);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4106);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;						
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
				break;
			case "XOR":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 4200);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4204);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;     
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 4201);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 4205);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;       
						}
						break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 4202);
								return A;  
							case "DRB":
								A.add(0, 4203);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4206);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;						
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
				break;
			case "NOT":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 4300);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 4301);
						return A;
					case "SF":
						A.clear();
						A.add(0, 4302);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
				break;
			case "NEG":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 4400);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 4401);
						return A;
					case "SF":
						A.clear();
						A.add(0, 4402);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}	
				break;
			case "CMP":
				switch (parts[1])
				{
					case "DRA":

						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 4500);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4504);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;     
						}
						break;
					case "DRB":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 4501);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 4505);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;       
						}
						break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.add(0, 4502);
								return A;  
							case "DRB":
								A.add(0, 4503);
								return A;
							case "SK":
								A.clear();
								A.add(0, 4506);
								A.add(1, SK);
								return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;						
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
				break;

			case "HALT":
				A.clear();
				A.add(0, 6000);
				return A;
			case "PRNT":
				switch (parts[1])
				{
					case "DRA":
						A.clear();	
						A.add(0, 7000);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 7001);
						return A;
					case "SF":
						A.clear();
						A.add(0, 7002);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}	
				break;
			case "LUM":
					switch (parts[1])
					{
						case "SK":
						switch (parts[2])
						{
							case "SK":
									A.clear();	
									A.add(0, 8000);
									A.add(1, SK1);
									A.add(2, SK);
									return A;
							default:
								A.clear();
								A.add(0, 9999);
								break;   
						}
						break;
						default:
						A.clear();
						A.add(0, 9999);
						break;     
					}
				break;
			case "LEM":
					switch (parts[1])
					{
						case "SK":
							switch (parts[2])
							{
								case "SK":
										A.clear();	
										A.add(0, 8100);
										A.add(1, SK1);
										A.add(2, SK);
										return A;
								default:
									A.clear();
									A.add(0, 9999);
									break;   
							}
							break;
							default:
								A.clear();
								A.add(0, 9999);
						break;     
					}
				break;
			case "JMP":
				switch (parts[1])
				{
					case "SK":	
						A.clear();
						A.add(0, 5000);
						A.add(1, SK1);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
			break;	
			case "JMG":
				switch (parts[1])
				{
					case "SK":	
						A.clear();
						A.add(0, 5100);
						A.add(1, SK1);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
			break;
			case "JME":
				switch (parts[1])
				{
					case "SK":	
						A.clear();
						A.add(0, 5200);
						A.add(1, SK1);
						return A;
					default:
						A.clear();
						A.add(0, 9999);
						break;   					
				}
			break;				   					 																							
			default:
				A.clear();
				A.add(0, 9999);
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
