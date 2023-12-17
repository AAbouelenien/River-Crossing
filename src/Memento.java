import java.util.ArrayList;

public class Memento {
	ArrayList<ICrosser> rightBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> leftBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> boatRiders = new ArrayList<ICrosser>();
	boolean boatOnLeft = true;
	int getNumberOfSails;
	public Memento(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> boatRiders, boolean boatOnLeft, int getNumberOfSails) {
		super();
		this.rightBankCrossers.addAll(rightBankCrossers);
		this.leftBankCrossers.addAll(leftBankCrossers);
		this.boatRiders.addAll(boatRiders);
		this.boatOnLeft = boatOnLeft;
		this.getNumberOfSails = getNumberOfSails;
	}
	
	

}
