
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Strategy5 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	PoliceMan police1 ;
	PoliceMan police2 ;
	PoliceMan police3;
	Robber robber1;
	Robber robber2;
	Robber robber3;
	private static Strategy5 strategy;
	
	
	public String getImageName()
	{
		String Name = "Cops and robbers.png";
		return Name;
		
	}
	
	
	
	public ArrayList<ICrosser> getList() {
		return list;
	}

	public void setList(ArrayList<ICrosser> list) {
		this.list = list;
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	

	private Strategy5()
	{
				
	}
	
	public static Strategy5 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy5();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		
		if(boatRiders.size()==0)
			return false;
		
		///////////// count on left /////////////
		int i=0;
		int policeLeft=0;
		int robberLeft=0;
		while (i<leftBankCrossers.size())
		{
			if (leftBankCrossers.get(i).getWeight()==0) 
				policeLeft++;
			else 
				robberLeft++;
			i++;
		}
		//////////// count on right //////////////
		
		i=0;
		int policeRight=0;
		int robberRight=0;
		while (i<rightBankCrossers.size())
		{
			if (rightBankCrossers.get(i).getWeight()==0) 
				policeRight++;
			else 
				robberRight++;
			i++;
		}
		
		
////////////count on boat //////////////
		
	i=0;
	int policeBoat=0;
	int robberBoat=0;
	while (i<boatRiders.size())
	{
		if (boatRiders.get(i).getWeight()==0) 
			policeBoat++;
		else 
			robberBoat++;
		i++;
	}
		
//////////  check ///////////////////////
	if(robberLeft > policeLeft && policeLeft != 0)
		return false;
	
	if(robberRight > policeRight && policeRight != 0)
		return false;
	
	if(control.boatOnLeft && robberRight+robberBoat > policeRight + policeBoat && (policeRight!=0 || policeBoat!=0) )
		return false;
	
	
	
	if(!control.boatOnLeft && robberLeft+robberBoat > policeLeft + policeBoat && (policeLeft!=0 || policeBoat!=0))
		return false;
	
	
		
				return true;
	}

	@Override
	public ArrayList<ICrosser> getInitialCrossers() {
		
		return list;
	}

	@Override
	public String[] getInstructions() {
		
		return null;
	}

	@Override
	public void createActors() {
		this.control=Controller.getInstance();
		CrosserFactory factory = new CrosserFactory();
		list.removeAll(list);

		
		police1=(PoliceMan) factory.createFactory("PoliceMan");
		police1.setWeight(0);
		police2=(PoliceMan) factory.createFactory("PoliceMan");
		police2.setWeight(0);
		police3=(PoliceMan) factory.createFactory("PoliceMan");
		police3.setWeight(0);

		robber1=(Robber) factory.createFactory("Robber");
		robber1.setWeight(1);
		robber2=(Robber) factory.createFactory("Robber");
		robber2.setWeight(1);
		robber3=(Robber) factory.createFactory("Robber");
		robber3.setWeight(1);

		
		
		list.add(police1);
		list.add(police2);
		list.add(police3);
		list.add(robber1);
		list.add(robber2);
		list.add(robber3);

				
		
police1.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(police1);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
			
        });

police2.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(police2);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
	
	
	
});

police3.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(police3);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
	
	
	
});

robber1.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(robber1);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
		
});

robber2.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(robber2);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});


robber3.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(robber3);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});
		
	}
	
	
	

}

