import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wolf extends Crosser {
	
	
	public Wolf()
	{
		canSail=false;
		Image img1 = new Image("file:wl.png");
		image.add(img1);
		
		Image img2 = new Image("file:wr.png");
		image.add(img2);
		
		iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}
	
	



public ICrosser makeCopy() {
	
	Wolf 	copy = new Wolf();
	copy.setIv(this.iv);
	copy.setWeight(weight);
	copy.setImage(this.image);
	return copy;
	
}


}
