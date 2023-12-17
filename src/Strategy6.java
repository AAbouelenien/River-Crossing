
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Strategy6 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	OrangeTraveler oTraveler ;
        GreenTraveler gTraveler;
        PinkTraveler pTraveler;
	PinkBag pBag1;
        PinkBag pBag2;
        GreenBag gBag;
	private static Strategy6 strategy;
	
	
	
	public String getImageName()
	{
		String Name = "Traveler and bags.gif";
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

	

	private Strategy6()
	{
				
	}
	
	public static Strategy6 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy6();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		
		if(boatRiders.size()==0)
		return false;
		                        

		if(!boatRiders.contains(oTraveler) && !boatRiders.contains(pTraveler) && !boatRiders.contains(gTraveler) )
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

		
		oTraveler=(OrangeTraveler) factory.createFactory("OrangeTraveler");
		gTraveler=(GreenTraveler) factory.createFactory("GreenTraveler");
		pTraveler=(PinkTraveler) factory.createFactory("PinkTraveler");
		pBag1=(PinkBag) factory.createFactory("PinkBag");
                pBag2=(PinkBag) factory.createFactory("PinkBag");
                gBag=(GreenBag) factory.createFactory("GreenBag");


		
        list.add(pTraveler);
		list.add(pBag1);
		list.add(pBag2);
        list.add(gTraveler);
        list.add(gBag);
		list.add(oTraveler);
		
		
		
				
		
pTraveler.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(pTraveler);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
			
        });

pBag1.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(pBag1);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
	
	
	
});

pBag2.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(pBag2);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
		
});

gTraveler.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(gTraveler);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});

gBag.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(gBag);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});

oTraveler.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(oTraveler);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});



		
	}
	
	
	

}

