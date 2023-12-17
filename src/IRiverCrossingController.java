import java.util.ArrayList;

public interface IRiverCrossingController extends IRiverCrossingController2 {

	public void newGame(ICrossingStrategy gameStrategy );
	
	public void resetGame();
	
	public String[] getInstructions();
	
	public ArrayList<ICrosser> getCrossersOnRightBank();
	
	public ArrayList<ICrosser> getCrossersOnLeftBank();
	
	public ArrayList<ICrosser> getBoatRiders();
	
	public boolean isBoatOnLeftBank();
	
	public int getNumberOfSails();
	
	 boolean canMove(ArrayList<ICrosser> crossers, boolean fromLeftToRightBank);
	
	public void doMove(ArrayList<ICrosser> crossers , boolean fromLeftToRightBank);
	
	public boolean canUndo();
	
	public boolean canRedo();
	
	public void undo();
	
	public void redo();
	
	public void saveGame();
	
	public void loadGame();
	
	public ArrayList<ArrayList<ICrosser>> solveGame();
	
	
	
}
