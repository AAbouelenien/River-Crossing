
public class CrosserFactory {
	
	
	public Crosser createFactory(String name)
	{
		if(name == "Wolf")
		{
			Wolf wolf = new Wolf();
			return wolf;
			
		}
		
		if(name == "Goat")
		{
			Goat goat = new Goat();
			return goat;
			
		}
		
		if(name == "Farmer")
		{
			Farmer farmer = new Farmer();
			return farmer;
			
		}
		if(name == "Farmer90")
		{
			Farmer90 farmer = new Farmer90();
			return farmer;

		}
		if(name == "Farmer80")
		{
			Farmer80 farmer = new Farmer80();
			return farmer;

		}
		if(name == "Farmer60")
		{
			Farmer60 farmer = new Farmer60();
			return farmer;

		}
		if(name == "Farmer40")
		{
			Farmer40 farmer = new Farmer40();
			return farmer;

		}
		
		if (name == "Plant")
		{
			Plant plant = new Plant();
			return plant;
			
		}
		
		if (name == "RedKnight")
		{
			RedKnight red = new RedKnight();
			return red;
			
		}
		
		if (name == "BlueKnight")
		{
			BlueKnight blue = new BlueKnight();
			return blue;
			
		}
		
		if (name == "BlackKnight")
		{
			BlackKnight black = new BlackKnight();
			return black;
			
		}
		
		if (name == "PoliceMan")
		{
			PoliceMan police = new PoliceMan();
			return police;
			
		}
		
		if (name == "Child")
		{
			Child child = new Child();
			return child;
			
		}
		
		if (name == "Robber")
		{
			Robber robber = new Robber();
			return robber;
			
		}
		
		if (name == "OrangeTraveler")
		{
			OrangeTraveler oTraveler = new OrangeTraveler();
			return oTraveler;
			
		}
		
		if (name == "PinkTraveler")
		{
			PinkTraveler pTraveler = new PinkTraveler();
			return pTraveler;
			
		}
		
		if (name == "GreenTraveler")
		{
			GreenTraveler gTraveler = new GreenTraveler();
			return gTraveler;
			
		}
		
		if (name == "PinkBag")
		{
			PinkBag pBag = new PinkBag();
			return pBag;
			
		}
		
		if (name == "GreenBag")
		{
			GreenBag gBag = new GreenBag();
			return gBag;
			
		}
		
				
		return null;
		
		
	}

}
