import java.awt.List;
import java.awt.image.BufferedImage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Farmer80 extends Crosser{

    public Farmer80()
    {
        canSail=true;
        Image img1 = new Image("file:fr80.gif");
        image.add(img1);
        Image img2 = new Image("file:fl80.gif");
        image.add(img2);
        ImageView iv = new ImageView(img1);
        iv.setFitHeight(160);
        iv.setFitWidth(130);
        this.iv=iv;


    }


    public ICrosser makeCopy() {

        Farmer copy = new Farmer();
        copy.setIv(this.iv);
        copy.setWeight(weight);
        copy.setImage(this.image);
        return copy;

    }


}
