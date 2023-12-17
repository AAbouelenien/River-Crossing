import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PoliceMan extends Crosser {

	public PoliceMan()
	{
		canSail=true;
		Image img1 = new Image("file:PoliceManLeft.gif");
		image.add(img1);
		Image img2 = new Image("file:PoliceManRight.gif");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		PoliceMan copy = new PoliceMan();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
}
