import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Child extends Crosser {

	public Child()
	{
		canSail=true;
		Image img1 = new Image("file:ChildLeft.png");
		image.add(img1);
		Image img2 = new Image("file:ChildRight.png");
		image.add(img2);
		ImageView iv = new ImageView(img1);
		iv.setFitHeight(130);
		iv.setFitWidth(130);
		this.iv=iv;
		
		
	}

	
	public ICrosser makeCopy() {
		
		Child copy = new Child();
		copy.setIv(this.iv);
		copy.setWeight(weight);
		copy.setImage(this.image);
		return copy;
		
	}
}
