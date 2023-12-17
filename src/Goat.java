import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Goat extends Crosser {
	
	
	public Goat()
	{
		canSail=false;
		Image img1 = new Image("file:gl.gif");
		image.add(img1);
		
		Image img2 = new Image("file:gr.gif");
		image.add(img2);
		
		iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}
	
	



public ICrosser makeCopy() {
	
	Goat 	copy = new Goat();
	copy.setIv(this.iv);
	copy.setWeight(weight);
	copy.setImage(this.image);
	return copy;
	
}


}
