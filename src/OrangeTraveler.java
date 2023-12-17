import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OrangeTraveler extends Crosser{
	
	public OrangeTraveler()
	{
		canSail=true;
		Image img1 = new Image("file:OrangeGuyLeft.png");
		image.add(img1);
		Image img2 = new Image("file:OrangeGuyRight.png");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		OrangeTraveler copy = new OrangeTraveler();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
	

}
