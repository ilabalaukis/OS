import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		RealMachine realMachine = new RealMachine();
		HashMap command = new HashMap();
		command.put("ADD", new int(0001));
    	command.put("SUB", new int(0002));
      	command.put("MUL", new int(0003));
      	command.put("DIV", new int(0004));

      	command.put("LR", new int(0011));
		command.put("LR", new int(0011));

		command.put("PUSH", new int(0021));
		command.put("POP", new int(0022));

		command.put("OR", new int(0031));
		command.put("AND", new int(0032));
		command.put("XOR", new int(0033));
		command.put("NOT", new int(0034));
		command.put("NEG", new int(0035));
		command.put("CMP", new int(0036));

		command.put("JMP", new int(0041));
		command.put("JMG", new int(0042));
		command.put("JME", new int(0043));

		command.put("HALT", new int(0051));

		command.put("PRNT", new int(0061));

		command.put("LUM", new int(0071));
		command.put("LEM", new int(0072));
	}
}
