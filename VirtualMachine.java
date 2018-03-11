public class VirtualMachine extends Machine
{
	
	public static RealMachine realMachine;
	private int[] virtualMemory = new int[15];
	public VirtualMachine(RealMachine realMachine){
		this.realMachine = realMachine;
	}
}
