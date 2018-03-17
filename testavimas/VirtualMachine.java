import java.util.*;
public class VirtualMachine extends Machine
{
	
	public static RealMachine realMachine;
	private int[] registerSpace = new int[8];
	ArrayList<Integer> dataSegment = new ArrayList<Integer>();
	ArrayList<Integer> codeSegment = new ArrayList<Integer>();
	ArrayList<Integer> stackSegment = new ArrayList<Integer>();
	private int blocksTaken = 2;
	private int[] virtualMemory = new int[15];
	public VirtualMachine(RealMachine realMachine){
		this.realMachine = realMachine;
	}
}
