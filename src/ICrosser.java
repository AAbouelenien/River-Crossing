import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface ICrosser extends ICrosser2{

public boolean canSail();

public double getWeight();

public ICrosser makeCopy();

public void setLabelToBeShown(String Label);

public ArrayList<Image> getImages();



public String getLabelToBeShown();

public int getEatingRank();


	 
	  
}
