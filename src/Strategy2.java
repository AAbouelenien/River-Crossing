import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Strategy2 implements ICrossingStrategy {
	
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	Farmer90 farmer1;
	Farmer80 farmer2;
	Farmer60 farmer3;
	Farmer40 farmer4;
	Goat goat;
	Wolf wolf;
	Plant plant;
	private static Strategy2 strategy;
	
	
	
	public String getImageName()
	{
		String Name = "level4ins.gif";
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


	public Goat getGoat() {
		return goat;
	}

	public void setGoat(Goat goat) {
		this.goat = goat;
	}

	

	private Strategy2()
	{
				
	}
	
	public static Strategy2 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy2();
		return strategy;
		
		
		
	}

	@Override
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders) {
		double weight1 =0;
		double weight2 = 0;
		
		if(control.getBoatRiders().contains(goat) && control.getBoatRiders().size()==1 ) 
			return false;
		
	 if (control.getBoatRiders().size()==0)
		 return false;
		
	 if (control.getBoatRiders().size()>=1)
		 weight1=control.boatRiders.get(0).getWeight();
     	
	 if (control.getBoatRiders().size()==2)
		 weight2=control.boatRiders.get(1).getWeight();
	 
	 if (weight1+weight2>100)
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
		
		Farmer90 farmer1 = (Farmer90) factory.createFactory("Farmer90");
		this.farmer1=farmer1;
		farmer1.setWeight(90);
		Farmer80 farmer2 = (Farmer80) factory.createFactory("Farmer80");
		this.farmer2=farmer2;
		farmer2.setWeight(80);
		Farmer60 farmer3 = (Farmer60) factory.createFactory("Farmer60");
		this.farmer3=farmer3;
		farmer3.setWeight(60);
		Farmer40 farmer4 = (Farmer40) factory.createFactory("Farmer40");
		this.farmer4=farmer4;
		farmer4.setWeight(40);
		Goat goat = (Goat) factory.createFactory("Goat");
		this.goat=goat;
		goat.setWeight(20);
		list.add(farmer1);
		list.add(farmer2);
		list.add(farmer3);
		list.add(farmer4);
		list.add(goat);
		
		
		farmer1.getImageView().setOnMouseClicked((MouseEvent e) -> {
			
			
				ArrayList<ICrosser> list= new ArrayList<ICrosser>();
				list.add(farmer1);
				commandDoMove command = new commandDoMove(control,list);
				Remote remote = Remote.getInstance();
				remote.setCommand(command);
				remote.doCommand();
				
						
					
		        });
		

		farmer2.getImageView().setOnMouseClicked((MouseEvent e) -> {
			ArrayList<ICrosser> list= new ArrayList<ICrosser>();
			list.add(farmer2);
			commandDoMove command = new commandDoMove(control,list);
			Remote remote = Remote.getInstance();
			remote.setCommand(command);
			remote.doCommand();
			
					
		        });
		

		farmer3.getImageView().setOnMouseClicked((MouseEvent e) -> {
			ArrayList<ICrosser> list= new ArrayList<ICrosser>();
			list.add(farmer3);
			commandDoMove command = new commandDoMove(control,list);
			Remote remote = Remote.getInstance();
			remote.setCommand(command);
			remote.doCommand();
			
					
		        });

		farmer4.getImageView().setOnMouseClicked((MouseEvent e) -> {
			ArrayList<ICrosser> list= new ArrayList<ICrosser>();
			list.add(farmer4);
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