import java.util.ArrayList;

public class commandDoMove implements Command{
Controller controller;
ArrayList<ICrosser> crosser;


public commandDoMove(Controller controller ,  ArrayList<ICrosser> crosser)
{
	this.controller=controller;
	this.crosser = crosser;
}

public void execute()
{
	controller.doMove(crosser, true);

}


}
