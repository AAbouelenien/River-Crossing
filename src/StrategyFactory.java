
public class StrategyFactory {

	
	
	public ICrossingStrategy createFactory(String name)
	{

		if(name == "Level1")
		{
			Strategy1 level = Strategy1.getInstance();
			return level;
		}
		
		if(name == "Level2")
		{
			Strategy2 level = Strategy2.getInstance();
			return level;
		}
		
		if(name == "Level3")
		{
			Strategy3 level = Strategy3.getInstance();
			return level;
		}
		
		if(name == "Level4")
		{
			Strategy4 level = Strategy4.getInstance();
			return level;
		}
		

		if(name == "Level5")
		{
			Strategy5 level = Strategy5.getInstance();
			return level;
		}
		
		if(name == "Level6")
		{
			Strategy6 level = Strategy6.getInstance();
			return level;
		}
		return null;
		
		
	}

}
