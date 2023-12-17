import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedKnight extends Crosser{
	
	public RedKnight()
	{
		canSail=true;
		Image img1 = new Image("file:RedKnightLeft.gif");
		image.add(img1);
		Image img2 = new Image("file:RedKnightRight.gif");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		RedKnight copy = new RedKnight();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
	

}

