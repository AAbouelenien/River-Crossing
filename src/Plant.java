import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plant extends Crosser {
	
	
	public Plant()
	{
		canSail=false;
		Image img1 = new Image("file:p.png");
		Image img2 = new Image("file:p.png");
		image.add(img1);
		image.add(img2);
		iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}
	
	



public ICrosser makeCopy() {
	
	Plant copy = new Plant();
	copy.setIv(this.iv);
	copy.setWeight(weight);
	copy.setImage(this.image);
	return copy;
	
}


}
