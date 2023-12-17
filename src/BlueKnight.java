import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueKnight extends Crosser{
	
	public BlueKnight()
	{
		canSail=true;
		Image img1 = new Image("file:BlueKnightLeft.gif");
		image.add(img1);
		Image img2 = new Image("file:BlueKnightRight.gif");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		BlueKnight copy = new BlueKnight();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
	

}
