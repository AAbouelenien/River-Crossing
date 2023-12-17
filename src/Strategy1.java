import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Strategy1 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	Farmer farmer;
	Goat goat;
	Wolf wolf;
	Plant plant;
	private static Strategy1 strategy;
	
	
	
	
	
	public String getImageName()
	{
		String Name = "insLevel1.gif";
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

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public Goat getGoat() {
		return goat;
	}

	public void setGoat(Goat goat) {
		this.goat = goat;
	}

	public Wolf getWolf() {
		return wolf;
	}

	public void setWolf(Wolf wolf) {
		this.wolf = wolf;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	private Strategy1()
	{
				
	}
	
	public static Strategy1 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy1();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		
		
		if(!boatRiders.contains(farmer))
			return false;
		
		if(rightBankCrossers.contains(goat) && rightBankCrossers.contains(plant) && !rightBankCrossers.contains(farmer))
			return false;
		
		if(leftBankCrossers.contains(goat) && leftBankCrossers.contains(plant) && !leftBankCrossers.contains(farmer))
			return false;
		
		if(rightBankCrossers.contains(goat) && rightBankCrossers.contains(wolf) && !rightBankCrossers.contains(farmer))
			return false;
		
		if(leftBankCrossers.contains(goat) && leftBankCrossers.contains(wolf) && !leftBankCrossers.contains(farmer))
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
		Farmer farmer = (Farmer)factory.createFactory("Farmer");
		this.farmer = farmer;

		Goat goat = (Goat)factory.createFactory("Goat");
		this.goat = goat;
		
		Wolf wolf = (Wolf)factory.createFactory("Wolf");
		this.wolf = wolf;
		
		Plant plant = (Plant)factory.createFactory("Plant");
		this.plant = plant;
		
		list.add(farmer);
		list.add(goat);
		list.add(wolf);
		list.add(plant);
		
farmer.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(farmer);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
			
        });

wolf.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(wolf);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
	
	
	
});

plant.getImageView().setOnMouseClicked((MouseEvent e) -> {
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(plant);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
		
});

goat.getImageView().setOnMouseClicked((MouseEvent e) -> {

	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	list.add(goat);
	commandDoMove command = new commandDoMove(control,list);
	Remote remote = Remote.getInstance();
	remote.setCommand(command);
	remote.doCommand();
	
});

		
	}
	
	
	

}