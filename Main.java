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
/*
		command.put("ADD", new Integer(0001));
    	command.put("SUB", new Integer(0002));
      	command.put("MUL", new Integer(0003));
      	command.put("DIV", new Integer(0004));

      	command.put("LR", new Integer(0011));
		command.put("SR", new Integer(0012));

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
*/

		System.out.println("Hello, this is Atlas machine.");
/////////////////////////////SANDBOX////////////////////////////////
////////////////////////////SANDBOX ENDS////////////////////////////
	
		while(true)
		{
			showCommands();
			String comm = input.next().toUpperCase();
			if( comm.equals("EXIT") ){
				System.out.println("Goodbye.");
				break;
			}
			switch(comm){
				case "NEWV":
					virtualMachines.add(new VirtualMachine(realMachine));
					createVMprogram();
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
						vmExecutionMode();
					}		
					break;
				default:
					System.out.println("Command not found.");
			}
			
		}
	}
	
	public static void showCommands(){
		System.out.println("Available Commands:");
		System.out.println("NEWV - creates new virtual machine.");
		System.out.println("START - start programs execution mode.");
		System.out.println("EXIT - turn off the machine.");
	}
	public static ArrayList<Integer> parseCommands(String line)
	{
		String[] parts = line.split(" ");
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0, 9999);
		int SK = 0;
		int SK1 = 0;
		int address = 0;
		int address1 = 0;
		String regex = "\\d+";
		String regexAddress = "\\[\\d+\\]";
		String str1 = "";
		String str2 = "";
		
		if (parts.length > 1)
		{
			str1 = parts[1].replaceAll("[^-?0-9]+", "");
			if (parts[1].equals("SK") || parts[1].equals("ADDRESS"))
			{
				return A;
			}
		}
		if (parts.length > 2)
		{
			str2 = parts[2].replaceAll("[^-?0-9]+", "");
			if (parts[2].equals("SK") || parts[2].equals("ADDRESS"))
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
			if (parts[2].matches(regexAddress))
			{
				address = Integer.parseInt(str2);
				parts[2] = "ADDRESS";
			}
		}
		if (parts.length > 1)
		{
			if (parts[1].matches(regex))
			{
				SK1 = Integer.parseInt(parts[1]);
				parts[1] = "SK";
			}
			if (parts[1].matches(regexAddress))
			{
				address1 = Integer.parseInt(str1);
				parts[1] = "ADDRESS";
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
						switch (parts[2])
						{
							case "DRB":
								A.clear();	
								A.add(0, 2000);
								return A;
							case "SK":
								A.clear();
								A.add(0, 2004);
								A.add(1, SK);
								return A;
							case "SF":
								A.clear();
								A.add(0, 2006);
								return A;
							case "ADDRESS":
								A.clear();
								A.add(0,2008);
								A.add(1, address);
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
								A.add(0, 2001);
								return A;  
							case "SK":
								A.clear();
								A.add(0, 2005);
								A.add(1, SK);
								return A;
							case "SF":
								A.clear();
								A.add(0, 2007);
								return A;
							case "ADDRESS":
								A.clear();
								A.add(0,2009);
								A.add(1, address);
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
								A.add(0, 2002);
								return A;  
							case "DRB":
								A.add(0, 2003);
								return A;
							case "ADDRESS":
								A.clear();
								A.add(0,2010);
								A.add(1, address);
								return A;
							case "SK":
								A.clear();
								A.add(0, 2011);
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
			case "SR":
				switch (parts[1])
				{
					case "DRA":
						switch (parts[2])
						{
							case "ADDRESS":
								A.clear();	
								A.add(0, 2100);
								A.add(1, address);
								return A;		
						}					
					case "DRB":
						switch(parts[2])
						{
							case "ADDRESS":
								A.clear();
								A.add(0, 2101);
								A.add(1, address);
								return A;	
						}
					default:
						A.clear();
						A.add(0, 9999);
						break;   
				}
				break;
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
				break;
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
				break;
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
						case "ADDRESS":
						switch (parts[2])
						{
							case "ADDRESS":
									A.clear();	
									A.add(0, 8000);
									A.add(1, address1);
									A.add(2, address);
									
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
						case "ADDRESS":
							switch (parts[2])
							{
								case "ADDRESS":
										A.clear();	
										A.add(0, 8100);
										A.add(1, address1);
										A.add(2, address);
										
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
						A.add(0, 5001);
						A.add(1, SK1);
						return A;
					case "ADDRESS":
						A.add(0, 5000);
						A.add(1, address1);
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
						A.add(0, 5101);
						A.add(1, SK1);
						return A;
					case "ADDRESS":	
						A.clear();
						A.add(0, 5100);
						A.add(1, address);
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
						A.add(0, 5201);
						A.add(1, SK1);
						return A;
					case "ADDRESS":	
						A.clear();
						A.add(0, 5200);
						A.add(1, address);
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
	public static void vmExecutionMode()
	{
		virtualMachines.get(vmIterator).realMachine.setTI(10);
		//Loopas sustos kiekvienu stepu, nebent parašysi SKIP
		String opt = "";
		boolean cont = true;
		int numberOfMachinesFinished = 0;
		while( cont == true ){
			while( realMachine.getTI() > 0 )
			{
				if( !opt.equals("SKIP"))
				{
					opt = input.next();
				}
				//Do Commands
				boolean status  = executeCommand(vmIterator);
				if( status == false ){
					numberOfMachinesFinished = 0;
				}else{
					numberOfMachinesFinished++;
				}
			}
			vmIterator =  (++vmIterator == virtualMachines.size()) ? 0 : vmIterator;
			if( numberOfMachinesFinished == virtualMachines.size() ){
				cont = false;
			}
		}
	}
	public static boolean executeCommand( int VM_ID )
	{
		
		int IC = virtualMachines.get(VM_ID).getIC();
		ArrayList<Integer> code = virtualMachines.get(VM_ID).getCS();
		System.out.println(VM_ID + " " + virtualMachines.get(VM_ID).getIC() + " DRA: " + virtualMachines.get(VM_ID).getDRA());
		switch(code.get(IC))
		{
			case 1000:
				virtualMachines.get(VM_ID).ADD("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1001:
				virtualMachines.get(VM_ID).ADD("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1002:
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1003:
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1004:
				virtualMachines.get(VM_ID).ADD("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1005: 
				virtualMachines.get(VM_ID).ADD("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1006:
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1100:
				virtualMachines.get(VM_ID).SUB("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1101:
				virtualMachines.get(VM_ID).SUB("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1102:
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1103:
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1104:
				virtualMachines.get(VM_ID).SUB("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1105: 
				virtualMachines.get(VM_ID).SUB("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1106:
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1200:
				virtualMachines.get(VM_ID).MUL("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1201:
				virtualMachines.get(VM_ID).MUL("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1202:
				virtualMachines.get(VM_ID).MUL("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1203:
				virtualMachines.get(VM_ID).MUL("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1300:
				virtualMachines.get(VM_ID).DIV("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1301:
				virtualMachines.get(VM_ID).DIV("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1302:
				virtualMachines.get(VM_ID).DIV("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 1303:
				virtualMachines.get(VM_ID).DIV("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2000:
				virtualMachines.get(VM_ID).LR("DRA", "NA",virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2001:
				virtualMachines.get(VM_ID).LR("DRB", "NA",virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2002:
				virtualMachines.get(VM_ID).LR("SF", "NA",virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2003:
				virtualMachines.get(VM_ID).LR("SF", "NA",virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2004:
				virtualMachines.get(VM_ID).LR("DRA", "NA",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2005:
				virtualMachines.get(VM_ID).LR("DRB", "NA",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2006:
				virtualMachines.get(VM_ID).LR("DRA", "NA",virtualMachines.get(VM_ID).getSF() );
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2007:
				virtualMachines.get(VM_ID).LR("DRB", "NA",virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 2008:
				virtualMachines.get(VM_ID).LR("DRA", "A",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2009:
				virtualMachines.get(VM_ID).LR("DRB", "A",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2010:
				virtualMachines.get(VM_ID).LR("SF", "A", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2011:
				virtualMachines.get(VM_ID).LR("SF", "NA", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2100:
				virtualMachines.get(VM_ID).SR("DRA", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 2101:
				virtualMachines.get(VM_ID).SR("DRB", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			/*
			case 3001:
				virtualMachines.get(VM_ID).PUSH(virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 3002:
				virtualMachines.get(VM_ID).PUSH(virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 3003:
				virtualMachines.get(VM_ID).PUSH(code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 3100:
				virtualMachines.get(VM_ID).POP("DRA");
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 3101:
				virtualMachines.get(VM_ID).POP("DRB");
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			*/
			case 4000:
				virtualMachines.get(VM_ID).OR("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4001:
				virtualMachines.get(VM_ID).OR("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4002:
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4003:
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4004:
				virtualMachines.get(VM_ID).OR("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4005: 
				virtualMachines.get(VM_ID).OR("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4006:
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4100:
				virtualMachines.get(VM_ID).AND("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4101:
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4102:
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4103:
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4104:
				virtualMachines.get(VM_ID).AND("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4105: 
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4106:
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4200:
				virtualMachines.get(VM_ID).XOR("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4201:
				virtualMachines.get(VM_ID).XOR("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4202:
				virtualMachines.get(VM_ID).XOR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4203:
				virtualMachines.get(VM_ID).XOR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4204:
				virtualMachines.get(VM_ID).XOR("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4205: 
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4206:
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4300:
				virtualMachines.get(VM_ID).NOT("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4301:
				virtualMachines.get(VM_ID).NOT("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4302:
				virtualMachines.get(VM_ID).NOT("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4400:
				virtualMachines.get(VM_ID).NEG("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4401:
				virtualMachines.get(VM_ID).NEG("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4402:
				virtualMachines.get(VM_ID).NEG("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4500:
				virtualMachines.get(VM_ID).CMP("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4501:
				virtualMachines.get(VM_ID).CMP("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4502:
				virtualMachines.get(VM_ID).CMP("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4503:
				virtualMachines.get(VM_ID).CMP("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4504:
				virtualMachines.get(VM_ID).CMP("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4505: 
				virtualMachines.get(VM_ID).CMP("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 4506:
				virtualMachines.get(VM_ID).CMP("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
			case 5000:
/*
				virtualMachines.get(VM_ID).JMP(code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 5100:
				virtualMachines.get(VM_ID).JMP(code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
			case 5200:
				virtualMachines.get(VM_ID).JMP(code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				return false;
*/
			case 6000:
				System.out.println("HALTAS");
				virtualMachines.get(VM_ID).setTI(0);
				return true;
/*
			case 7000:
				virtualMachines.get(VM_ID).PRNT("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 7001: 
				virtualMachines.get(VM_ID).PRNT("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 7002:
				virtualMachines.get(VM_ID).PRNT("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
			case 8000:
				virtualMachines.get(VM_ID).LUM(code.get(IC+1), code.get(IC+2));
				virtualMachines.get(VM_ID).setIC(IC+3);
				return false;
			case 8001: 
				virtualMachines.get(VM_ID).LEM(code.get(IC+1), code.get(IC+2));
				virtualMachines.get(VM_ID).setIC(IC+3);
				return false;*/
		}
		return false;
	}
	public static void createVirtualMachine(){
		//Sukuria mašiną
		virtualMachines.add(new VirtualMachine(realMachine));
		//Priskiria puslapiavimo lentelėje mašinai pirmąjį bloką.
		List<Integer[]> alteredPT = realMachine.getPT();
		for(int i=0 ; i<100 ; i++){
			if( alteredPT.get(i)[0] == 0 ){
				alteredPT.get(i)[0] = virtualMachines.size();
				break;
			}
		}
		realMachine.setPT(alteredPT);
		//Išskirsto pirmą bloką į virtualios mašinos segmentus
		ArrayList<Integer> DS = new ArrayList<Integer>();
		ArrayList<Integer> CS = new ArrayList<Integer>();
		ArrayList<Integer> SS = new ArrayList<Integer>();
		for(int i = 0 ; i < 4 ; i++){
			//Pirmas blokas pasidalina: 5 rezervas registrams, 4 DS, 4 CS ir 2 SS
			DS.add(0);
			CS.add(0);
			if(i > 1){
				SS.add(0);
			}
		}
		virtualMachines.get(virtualMachines.size()-1).setDS(DS);
		virtualMachines.get(virtualMachines.size()-1).setCS(CS);
		virtualMachines.get(virtualMachines.size()-1).setSS(SS);
	}
	public static void createVMprogram(){
		String currentCommand = "";
		String lastCommand = "";
		ArrayList<Integer> dataSegment = new ArrayList<Integer>();
		ArrayList<Integer> codeSegment = new ArrayList<Integer>();
		ArrayList<Integer> stackSegment = new ArrayList<Integer>();
		int wordCount = 1;
		//DS pildymas
		System.out.println("Fill data segment. When done filling, write DONE");
		while( !lastCommand.equals("DONE")){
			currentCommand = input.next();
			if(!currentCommand.equals("DONE")){
				String[] line = currentCommand.split("");
				String data = "";
				for(int i = 0; i < line.length ; i++){
					if( i%2 == 0 ){
						data = "";
						data += line[i];	
					}else{
						data += line[i];
						dataSegment.add(Integer.parseInt(line[i]));
						wordCount++;
					}
					if( i%2 == 0 && i == line.length-1){
						data += "00";
						dataSegment.add(Integer.parseInt(line[i]));
						wordCount++;
					}
				}
			}
			lastCommand = currentCommand;
		}
		lastCommand = "";
		input.nextLine();
		System.out.println("Write virtual machine program. Don't forget to write HALT at the end.");
		while( !lastCommand.equals("HALT")){
			currentCommand = input.nextLine();
			ArrayList<Integer> machineCode = parseCommands(currentCommand);
			
			lastCommand = currentCommand.substring(0, 4);
			codeSegment.addAll(machineCode);
		}
		virtualMachines.get(virtualMachines.size()-1).setDS(dataSegment);
		virtualMachines.get(virtualMachines.size()-1).setCS(codeSegment);
		virtualMachines.get(virtualMachines.size()-1).setSS(stackSegment);
		
		System.out.println("Virtual Machine created successfully." + virtualMachines.get(virtualMachines.size()-1).getCS());





	}
	public static void dealWithInterrupts(){
		if( realMachine.getPI() != 0 ){
			switch(realMachine.getPI()){
				case 1:
					//1 - adresacijos klaida (neegzistuoja adresas)
					//Killas
					break;
				case 2:
					//2 - komandų sekos pabaiga (sutikta HALT komanda)
					//gali but kad nereiks bet kolkas tegu buna
					break;
				case 3:
					//3 - neatpažinta komanda
					//kvies execute command metodas - keis nerastą komandą į halt (arba kill?)
					//tiesą sakant galima čia vietoj killint (pažymėt, kad nukillinta mašina pvz nustačius SF į 9999) ir su halt pabaigti.
					break;
				case 4:
					//4 - dalyba iš nulio
					//Killas arba dalinti iš 1
					break;
				case 5:
					//5 - per mažai žodžių steke operacijai atlikti
					//killas
					break;
				case 6:
					//Į registrą bandyta patalpinti per didelį arba per mažą skaičių ( >9999 arba <-4499 )
			}
			realMachine.setPI(0);
		}else if( realMachine.getSI() != 0 ){
			switch(realMachine.getSI()){
				case 1:
					//Mašina prašo atminties.
					//Trūksta vietos virtualiai mašinai, stekas nebetelpa. Jei mašina turi mažai blokų, tai galima
					//duoti dar vieną. Jei turi tiek kiek galima - killas?
					break;
			}
			realMachine.setSI(0);
		}else if( realMachine.getIOI() != 0 ){
			switch(realMachine.getIOI()){
				case 1:
					//Virtuali mašina prašo prieigos prie IŠVESTIES įrenginio
					//Patikrinti, ar jis nėra užimtas, jei ne, duoti prieigą, jeigu užimtas, sustabdyti mašinos darbą (TI=0)
					//ir galbūt IC grąžinti į print jei pasikeitė.
					break;
				case 2:
					//Virtuali mašina prašo prieigos prie ĮVESTIES įrenginio.
					//Patikrinti, ar jis užimtas, jei ne, duoti prieiga, jei užimtas atstatyti IC ir TI = 0
					break;
			}
			realMachine.setIOI(0);
		}
	}
}
