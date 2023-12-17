import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Crosser implements ICrosser{
	 
	 protected double weight;
		 protected String label;
		protected ArrayList<Image> image=new ArrayList<Image>();
		protected int eatingRank;
		protected boolean canSail;
		protected ImageView iv = new ImageView();
		protected int pos = 0;

		
		public boolean canSail()
		{
			return canSail;
		}
		
		public double getWeight()
		{
			return weight;
		}


		public int getPos()
		{
			return pos;
		}
		
		public void setPos(int pos)
		{
			this.pos=pos;
		}
		
		public ImageView getIv() {
			return iv;
		}

		public void setIv(ImageView iv) {
			this.iv = iv;
		}

		

		public void setLabelToBeShown(String Label)
		{
			this.label=label;
		}
		

		public String getLabelToBeShown()
		{
			return this.label;
		}
		
		public int getEatingRank()
		{
			return this.eatingRank;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public ArrayList<Image> getImages() {
			return image;
		}

		public void setImage(ArrayList<Image> image) {
			this.image = image;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public void setEatingRank(int eatingRank) {
			this.eatingRank = eatingRank;
		}


		public ImageView getImageView()
		{
			
			return iv;
		}
}
