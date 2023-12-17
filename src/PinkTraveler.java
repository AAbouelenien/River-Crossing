import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PinkTraveler extends Crosser{
	
	public PinkTraveler()
	{
		canSail=true;
		Image img1 = new Image("file:PinkGuyLeft.png");
		image.add(img1);
		Image img2 = new Image("file:PinkGuyRight.png");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		PinkTraveler copy = new PinkTraveler();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
	

}
