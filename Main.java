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
		HashMap<String, Integer> command = new HashMap<String, Integer>();
		System.out.println("Hello, this is Atlas machine.");
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
		String regex = "-?\\d+";
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
				if (SK > 9999 || SK < -5000)
				{
					System.out.println ("Negalima");
				}
				if(SK < 0)
				{
				 	SK = (SK - 5000) * (-1);
				}
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
								A.add(0, 9999);
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
						if (parts.length > 2)
						{
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
						}
						else
						{
							A.clear();
							A.add(0, 2012);
						}	
					break;
					case "DRB":
						if (parts.length > 2)
						{
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
						}
						else
       					{
							A.clear();
							A.add(0, 2013);	
						}
					break;
					case "SF":
						switch (parts[2])
						{
							case "DRA":
								A.clear();
								A.add(0, 2002);
								return A;  
							case "DRB":
								A.clear();
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
						A.add(0, 3001);
						return A;						
					case "DRB":
						A.clear();
						A.add(0, 3002);
						return A;
					case "SK":
						A.clear();
						A.add(0, 3003);
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
		//Loopas sustos kiekvienu stepu, nebent parašysi SKIP
		String opt = "a";
		boolean cont = true;
		int numberOfMachinesFinished = 0;
		while( cont == true ){
			virtualMachines.get(vmIterator).realMachine.setTI(10);
			virtualMachines.get(vmIterator).loadRegisters();
			realMachine.setMODE(false);
			while( realMachine.getTI() > 0 )
			{
				//Do Commands
				boolean status  = executeCommand(vmIterator);
				if( !opt.equals("SKIP"))
				{	
					System.out.println("Virtual Machine No. "+virtualMachines.get(vmIterator).getID()+" work cycle."); 
					if (opt.equals("REGISTERS") || opt.equals("ALL") || opt.equals("r") || opt.equals("R") || opt.equals("A") || opt.equals("a")){
						System.out.println("DRA: " + realMachine.getDRA() + " DRB: " + realMachine.getDRB()
							+ " SP: " + realMachine.getSP() + " SF: "+realMachine.getSF() + " IC: "+realMachine.getIC()
							+ " SI: " + realMachine.getSI() + " PI: "+realMachine.getPI() + " IOI: "+realMachine.getIOI()
							+ " TI: " + realMachine.getTI() + " MODE: " + realMachine.getMODE() + " PTR: " + realMachine.getPTR());
						//System.out.println(realMachine.getCHST());
						//System.out.println(realMachine.getPTR());
						//System.out.println(realMachine.getMODE());
					} 
					if (opt.equals("DUMP") || opt.equals("ALL") || opt.equals("d") || opt.equals("D") || opt.equals("A") || opt.equals("a")){
						System.out.println("CS: " + virtualMachines.get(vmIterator).getCS());
						System.out.println("DS: " + virtualMachines.get(vmIterator).getDS());
						System.out.println("SS: " + virtualMachines.get(vmIterator).getSS());
					}
					//Išvedama vykdoma komanda
					//Išvesti registrus
					//išvesti atmintį
					opt = input.next();
				}
				if( status == false ){
					numberOfMachinesFinished = 0;
				}else{
					numberOfMachinesFinished++;
				}
			}
			realMachine.setMODE(true);
			virtualMachines.get(vmIterator).saveRegisters();
			vmIterator =  (++vmIterator == virtualMachines.size()) ? 0 : vmIterator;
			if( numberOfMachinesFinished == virtualMachines.size() ){
				cont = false;
			}
		}
	}
	public static boolean executeCommand( int VM_ID )
	{
		
		int IC = virtualMachines.get(VM_ID).getIC();
		int TI = virtualMachines.get(VM_ID).getTI();
		ArrayList<Integer> code = virtualMachines.get(VM_ID).getCS();
		switch(code.get(IC))
		{
			case 1000:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).ADD("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1001:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).ADD("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1002:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 1003:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1004:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).ADD("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1005:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).ADD("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1006:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).ADD("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1100:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).SUB("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1101:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).SUB("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1102:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1103:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1104:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).SUB("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1105: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).SUB("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1106:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).SUB("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1200:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).MUL("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1201:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).MUL("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1202:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).MUL("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1203:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).MUL("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1300:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).DIV("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1301:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).DIV("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1302:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).DIV("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 1303:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).DIV("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2000:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("DRA", "NA",virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2001:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("DRB", "NA",virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2002:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("SF", "NA",virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2003:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("SF", "NA",virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2004:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("DRA", "NA",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2005:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("DRB", "NA",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2006:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("DRA", "NA",virtualMachines.get(VM_ID).getSF() );
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2007:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).LR("DRB", "NA",virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2008:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("DRA", "A",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2009:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("DRB", "A",code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2010:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("SF", "A", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2011:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).LR("SF", "NA", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2012:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				System.out.println("Virtual Machine No. "+virtualMachines.get(vmIterator).getID()+" requests input.");
				String var = input.next();
				virtualMachines.get(VM_ID).LR("DRA", "NA", Integer.parseInt(var));
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2013: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				System.out.println("Virtual Machine No. "+virtualMachines.get(vmIterator).getID()+" requests input.");
				var = input.next();
				virtualMachines.get(VM_ID).LR("DRB", "NA", Integer.parseInt(var));
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;			
			case 2100:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).SR("DRA", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 2101:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).SR("DRB", code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 3001:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).PUSH(virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;				
			case 3002:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).PUSH(virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 3003:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).PUSH(code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 3100:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).POP("DRA");
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 3101:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).POP("DRB");
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4000:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).OR("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				return false;
			case 4001:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).OR("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4002:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4003:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4004:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).OR("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4005: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).OR("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4006:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).OR("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4100:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).AND("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4101:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4102:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4103:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4104:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).AND("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4105: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4106:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);			
				return false;
			case 4200:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).XOR("DRA", virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4201:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).XOR("DRB", virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4202:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).XOR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4203:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).XOR("SF", virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4204:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).XOR("DRA", virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4205: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).AND("DRB", virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4206:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).AND("SF", virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4300:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NOT("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4301:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NOT("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4302:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NOT("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4400:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NEG("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4401:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NEG("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4402:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).NEG("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4500:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getDRA(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4501:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getDRB(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4502:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4503:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getSF(), virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4504:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getDRA(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4505: 
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getDRB(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 4506:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).CMP(virtualMachines.get(VM_ID).getSF(), code.get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).setTI(TI-1);
			case 5001:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).JMP(code.get(IC+1));
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 5101:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).JMG(code.get(IC+1));
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 5201:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC)+" "+virtualMachines.get(VM_ID).getCS().get(IC+1));
				virtualMachines.get(VM_ID).setIC(IC+2);
				virtualMachines.get(VM_ID).JME(code.get(IC+1));
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 6000:
				System.out.println(">"+virtualMachines.get(VM_ID).getCS().get(IC));
				System.out.println("HALTAS");
				virtualMachines.get(VM_ID).setTI(0);
				return true;
/*
			case 7000:
				virtualMachines.get(VM_ID).PRNT("DRA", virtualMachines.get(VM_ID).getDRA());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 7001: 
				virtualMachines.get(VM_ID).PRNT("DRB", virtualMachines.get(VM_ID).getDRB());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 7002:
				virtualMachines.get(VM_ID).PRNT("SF", virtualMachines.get(VM_ID).getSF());
				virtualMachines.get(VM_ID).setIC(IC+1);
				virtualMachines.get(VM_ID).setTI(TI-1);
				return false;
			case 8000:
				virtualMachines.get(VM_ID).LUM(code.get(IC+1), code.get(IC+2));
				virtualMachines.get(VM_ID).setIC(IC+3);
				virtualMachines.get(VM_ID).setTI(TI-3);
				return false;
			case 8001: 
				virtualMachines.get(VM_ID).LEM(code.get(IC+1), code.get(IC+2));
				virtualMachines.get(VM_ID).setIC(IC+3);
				virtualMachines.get(VM_ID).setTI(TI-3);
				return false;*/
			case 9999:
				//interruptina - nerasta komanda
				realMachine.setPI(3);
				dealWithInterrupts();
				return true;
			default:
				virtualMachines.get(VM_ID).setTI(0);
				return true;
		}
	}
	public static void createVMprogram(){
		String currentCommand = "";
		String lastCommand = "";
		ArrayList<Integer> dataSegment = virtualMachines.get(virtualMachines.size()-1).getDS();
		ArrayList<Integer> codeSegment = virtualMachines.get(virtualMachines.size()-1).getCS();
		String regex = "\\d+";
		//DS pildymas
		int DSiterator = 0;
		System.out.println("Fill data segment. When done filling, write DONE");
		System.out.println("Maximum of 46 words are allowed in data segment.");
		while( !lastCommand.toUpperCase().equals("DONE")){
			currentCommand = input.next();
			if(!currentCommand.toUpperCase().equals("DONE")){
				if (currentCommand.matches(regex))
				{
					String[] line = currentCommand.split("");
					String data = "";
					for(int i = 0; i < line.length ; i++){									
						if( (i+1)%4 != 0 ){
							data += line[i];	
						}else{
							data += line[i];
							if( DSiterator >= (4+virtualMachines.get(virtualMachines.size()-1).getBlocks()*6)){
								virtualMachines.get(virtualMachines.size()-1).setDS(dataSegment);
								virtualMachines.get(virtualMachines.size()-1).addBlock();
								dataSegment = virtualMachines.get(virtualMachines.size()-1).getDS();
							}
							dataSegment.set(DSiterator, Integer.parseInt(data));
							DSiterator++;
							data = "";
						}
						if( (i+1)%4 != 0 && i == line.length-1 && data.length() > 0){
							if( DSiterator >= (4+virtualMachines.get(virtualMachines.size()-1).getBlocks()*6)){
								virtualMachines.get(virtualMachines.size()-1).setDS(dataSegment);
								virtualMachines.get(virtualMachines.size()-1).addBlock();
								dataSegment = virtualMachines.get(virtualMachines.size()-1).getDS();
							}
							if( data.length() == 1 ){
								data = "000"+data;
							}else if( data.length() == 2 ){
								data = "00"+data;
							}else if( data.length() == 3 ){
								data = "0"+data;
							}
							dataSegment.set(DSiterator ,Integer.parseInt(data));
							DSiterator++;
						}
					}
				}
				else
				{
					System.out.println("Input has to be a number.");
					//TODO: koduotės
				}
			}
			lastCommand = currentCommand;
		}
		lastCommand = "";
		input.nextLine();
		int CSiterator = 0;
		System.out.println("Write virtual machine program. Don't forget to write HALT at the end.");
		System.out.println("Maximum of 46 words are allowed in code segment.");
		while( !lastCommand.toUpperCase().equals("HALT")){
			currentCommand = input.nextLine();
			ArrayList<Integer> machineCode = parseCommands(currentCommand);
			String[] currentLine = currentCommand.split(" ");
			lastCommand = currentLine[0];
			for( int i = 0 ; i < machineCode.size() ; i++){
				if( CSiterator >= (4+virtualMachines.get(virtualMachines.size()-1).getBlocks()*6)){
						virtualMachines.get(virtualMachines.size()-1).setCS(codeSegment);
						virtualMachines.get(virtualMachines.size()-1).addBlock();
						codeSegment = virtualMachines.get(virtualMachines.size()-1).getCS();
				}
				codeSegment.set(CSiterator , machineCode.get(i));
				CSiterator++;
			}
			//codeSegment.addAll(machineCode);
		}
		virtualMachines.get(virtualMachines.size()-1).setDS(dataSegment);
		virtualMachines.get(virtualMachines.size()-1).setCS(codeSegment);		
		System.out.println("Virtual Machine created successfully." + virtualMachines.get(virtualMachines.size()-1).getSS());
	}

	public static void dealWithInterrupts(){
		realMachine.setMODE(true);
		if( realMachine.getPI() != 0 ){
			switch(realMachine.getPI()){
				case 1:
					//1 - adresacijos klaida (neegzistuoja adresas)
					
					break;
				case 2:
					//2 - komandų sekos pabaiga (sutikta HALT komanda)
					//gali but kad nereiks bet kolkas tegu buna
					break;
				case 3:
					//3 - neatpažinta komanda
					//kvies execute command metodas - keis nerastą komandą į halt (arba kill?)
					//tiesą sakant galima čia vietoj killint (pažymėt, kad nukillinta mašina pvz nustačius SF į 9999) ir su halt pabaigti.
					virtualMachines.get(vmIterator).setSF(9999);
					realMachine.setTI(0);
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
					break;
			}
			realMachine.setPI(0);
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
		realMachine.setMODE(true);
	}
}
