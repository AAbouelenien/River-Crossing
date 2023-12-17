import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

public class Controller implements IRiverCrossingController {
	ArrayList<ICrosser> rightBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> leftBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> boatRiders = new ArrayList<ICrosser>();
	ICrossingStrategy strategy ;
	private static Controller control;
	boolean boatOnLeft = true;
	int getNumberOfSails;

	Level level;
    Media sound;
    MediaPlayer mediaPlayer;
	private Controller()
	{
		
		
	}

	public static Controller getInstance()
	{
		if(control == null)
			control = new Controller();
		
		return control;
		
		
	}

	public void newGame(ICrossingStrategy gameStrategy) {
		leftBankCrossers.removeAll(leftBankCrossers);
		leftBankCrossers.addAll(gameStrategy.getInitialCrossers());
		strategy = gameStrategy;
		boatOnLeft = true;
		getNumberOfSails=0;

		rightBankCrossers.removeAll(rightBankCrossers);

		boatRiders.removeAll(boatRiders);
		boatOnLeft = true;
		getNumberOfSails=0;
		
		Caretaker care = Caretaker.getInstance();
		
		Originator origin = new Originator();
		origin.setState(rightBankCrossers, leftBankCrossers, boatRiders, boatOnLeft, getNumberOfSails);
		
		care.add(origin.save());
	
	}

	@Override
	public void resetGame() {
		leftBankCrossers.removeAll(leftBankCrossers);
		rightBankCrossers.removeAll(rightBankCrossers);
		boatRiders.removeAll(boatRiders);
		newGame(strategy);
		
		
		
		
	}

	@Override
	public String[] getInstructions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ICrosser> getCrossersOnRightBank() {
		return rightBankCrossers;
		
	}

	@Override
	public ArrayList<ICrosser> getCrossersOnLeftBank() {
		
		return leftBankCrossers;
	}

	@Override
	public boolean isBoatOnLeftBank() {
		// TODO Auto-generated method stub
		return boatOnLeft;
	}

	@Override
	public int getNumberOfSails() {
		// TODO Auto-generated method stub
		return getNumberOfSails;
	}

	@Override
	public boolean canMove(ArrayList<ICrosser> crossers, boolean fromLeftToRightBank) {
		
		Crosser crosser = (Crosser) crossers.get(0);
		
		if(leftBankCrossers.contains(crosser) && !boatOnLeft)
			return false;
		
		if(rightBankCrossers.contains(crosser) && boatOnLeft)
			return false;
		
		if(boatRiders.size()>=2 && !boatRiders.contains(crosser))
			return false;
		
		
		
		return true;
	}

	@Override
	public boolean canUndo() {
		

		Caretaker care = Caretaker.getInstance();
		
		return care.isTherePrev();
	
	}

	@Override
	public boolean canRedo() {
		Caretaker care = Caretaker.getInstance();
		return care.isThereNext();
	}

	@Override
	public void undo() {
		if(!canUndo())
			{
			AlertBox.display("Error", "No moves to undo", mediaPlayer);
			return;}
		Caretaker care = Caretaker.getInstance();
		
		Memento m = care.getPrev();
		boolean boat = m.boatOnLeft;
		
		if(boat != boatOnLeft)
			level.moveBoat();
		
		this.boatRiders.removeAll(boatRiders);
		boatRiders.addAll(m.boatRiders);
		
		this.leftBankCrossers.removeAll(leftBankCrossers);
		leftBankCrossers.addAll(m.leftBankCrossers);
		

		this.rightBankCrossers.removeAll(rightBankCrossers);
		rightBankCrossers.addAll(m.rightBankCrossers);
		
		this.boatOnLeft = m.boatOnLeft;

		this.getNumberOfSails = m.getNumberOfSails;

		
		level.updateAll();
	}

	@Override
	public void redo() {
Caretaker care = Caretaker.getInstance();
		
		if(!canRedo())
			{
			AlertBox.display("Error", "No moves to redo",mediaPlayer);
			return;}
		
		Memento m = care.getNext();
		boolean boat = m.boatOnLeft;
		
		if(boat != boatOnLeft)
			level.moveBoat();

		
		this.boatRiders.removeAll(boatRiders);
		boatRiders.addAll(m.boatRiders);
		
		this.leftBankCrossers.removeAll(leftBankCrossers);
		leftBankCrossers.addAll(m.leftBankCrossers);
		

		this.rightBankCrossers.removeAll(rightBankCrossers);
		rightBankCrossers.addAll(m.rightBankCrossers);
		
		this.boatOnLeft = m.boatOnLeft;
		this.getNumberOfSails = m.getNumberOfSails;

		level.updateAll();
		
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrayList<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doMove(ArrayList<ICrosser> crossers, boolean fromLeftToRightBank) {
		
		if(!canMove(crossers, true))
			{
			
			AlertBox.display("Error", "Invalid Move",mediaPlayer);
			return;}
		
		
		Crosser crosser = (Crosser) crossers.get(0);
		

		if(leftBankCrossers.contains(crosser))
		{
			leftBankCrossers.remove(crosser);
			boatRiders.add(crosser);
			
			
			
		}
		
		else if(rightBankCrossers.contains(crosser))
		{
			rightBankCrossers.remove(crosser);
			boatRiders.add(crosser);
			
			
		}
		
		else if(boatRiders.contains(crosser))
		{
			if(boatOnLeft)
			{
				boatRiders.remove(crosser);
				leftBankCrossers.add(crosser);
				
				
			}
			
			else if(!boatOnLeft)
			{
				boatRiders.remove(crosser);
				rightBankCrossers.add(crosser);
				
				
			}
			
			
			
			
		}	
		
		level.updateAll();
	Caretaker care = Caretaker.getInstance();
		
		Originator origin = new Originator();
		origin.setState(rightBankCrossers, leftBankCrossers, boatRiders, boatOnLeft, getNumberOfSails);
		
		care.add(origin.save());
	
		if(leftBankCrossers.size()==0 && boatRiders.size() ==0)
		{  AlertBox.display("Success", "Level Completed",mediaPlayer);
		level.back();
		
		}
	}

	@Override
	public ArrayList<ICrosser> getBoatRiders() {
		// TODO Auto-generated method stub
		
		return boatRiders;
	}

	@Override
	public void setLevel(Level level) {
		this.level=level;
		
	}

	public int getGetNumberOfSails() {
		return getNumberOfSails;
	}

	public void setGetNumberOfSails(int getNumberOfSails) {
		this.getNumberOfSails = getNumberOfSails;
	}
}
