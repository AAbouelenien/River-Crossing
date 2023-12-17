
public class Remote {

	private Command command;
	private static Remote remote;
	
	private Remote()
	{
	
		
	}
	
	public static Remote getInstance()
	{
		if(remote == null)
			remote = new Remote();
		
		return remote;
		
		
		
		
	}
	
	
	
	public void setCommand(Command command)
	{
		this.command=command;	
		
	}
	
	public void doCommand()
	{
		command.execute();
	}
	
	
	
	
}
