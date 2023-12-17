
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Strategy3 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	RedKnight red ;
	BlueKnight blue1;
	BlueKnight blue2;
	BlackKnight black;
	private static Strategy3 strategy;
	
	
	public String getImageName()
	{
		String Name = "level2int.gif";
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

	

	private Strategy3()
	{
				
	}
	
	public static Strategy3 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy3();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		
		if(boatRiders.size()==0)
			return false;
		if(boatRiders.contains(red)&& boatRiders.size()==2)
			return false;
		if(boatRiders.contains(black)&& boatRiders.size()==1)
			return false;
		if(leftBankCrossers.contains(black)&& leftBankCrossers.size()==1)
			return false;
		if(rightBankCrossers.contains(black)&& rightBankCrossers.size()==1)
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

		
		red=(RedKnight) factory.createFactory("RedKnight");
		blue1=(BlueKnight) factory.createFactory("BlueKnight");
		blue2=(BlueKnight) factory.createFactory("BlueKnight");
		black=(BlackKnight) factory.createFactory("BlackKnight");
		
		list.add(red);
		list.add(blue1);
		list.add(blue2);
		list.add(black);
				
		
red.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(red);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
			
        });

blue1.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(blue1);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
	
	
	
});

blue2.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(blue2);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
		
});

black.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(black);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});

		
	}
	
	
	

}
