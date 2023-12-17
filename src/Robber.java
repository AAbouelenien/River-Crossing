import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Robber extends Crosser{
	
	public Robber()
	{
		canSail=true;
		Image img1 = new Image("file:RobberLeft.gif");
		image.add(img1);
		Image img2 = new Image("file:RobberRight.gif");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		Robber copy = new Robber();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
	

}
