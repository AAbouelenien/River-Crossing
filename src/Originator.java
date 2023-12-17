import java.util.ArrayList;

public class Originator {
	ArrayList<ICrosser> rightBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> leftBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> boatRiders = new ArrayList<ICrosser>();
	boolean boatOnLeft = true;
	int getNumberOfSails;
	public  void setState(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders, boolean boatOnLeft, int getNumberOfSails) {
		
		this.rightBankCrossers.addAll(rightBankCrossers);
		this.leftBankCrossers.addAll(leftBankCrossers);
		this.boatRiders.addAll(boatRiders);
		this.boatOnLeft = boatOnLeft;
		this.getNumberOfSails = getNumberOfSails;
	}
	
	public Memento save()
	{
		return new Memento(rightBankCrossers, leftBankCrossers, boatRiders, boatOnLeft, getNumberOfSails);
		
	}
	

}
