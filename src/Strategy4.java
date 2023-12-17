
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Strategy4 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	PoliceMan police1 ;
	PoliceMan police2 ;
	Child child1;
	Child child2;
	private static Strategy4 strategy;
	
	
	
	public String getImageName()
	{
		String Name = "worker &child.png";
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

	

	private Strategy4()
	{
				
	}
	
	public static Strategy4 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy4();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		
		if(boatRiders.size()==0)
			return false;
		if(boatRiders.contains(police1) && boatRiders.size()==2)
			return false;
		if(boatRiders.contains(police2) && boatRiders.size()==2)
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
		police2=(PoliceMan) factory.createFactory("PoliceMan");
		child1=(Child) factory.createFactory("Child");
		child2=(Child) factory.createFactory("Child");
		
		list.add(police1);
		list.add(police2);
		list.add(child1);
		list.add(child2);
				
		
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

child1.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(child1);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
		
});

child2.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(child2);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});

		
	}
	
	
	

}

