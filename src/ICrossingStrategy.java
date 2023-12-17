import java.awt.List;
import java.util.ArrayList;

public interface ICrossingStrategy extends ICrossingStrategy2{
	
	public boolean isValid(ArrayList<ICrosser> rightBankCrossers, ArrayList<ICrosser> leftBankCrossers, ArrayList<ICrosser> boatRiders);

	public ArrayList<ICrosser> getInitialCrossers();
	
	public String[] getInstructions();
	
	
}
