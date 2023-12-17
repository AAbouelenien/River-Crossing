import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class InstructionBox {
	ImageView imageViewBackground;
	ImageView boatImageView;
    Media sound;
    MediaPlayer mediaPlayer;

	public static void display (String name, MediaPlayer mediaPlayer)
	{
		Image imageBackground = new Image("file:7.jpg");
		ImageView imageViewBackground = new ImageView(imageBackground);
		imageViewBackground = imageViewBackground;
		imageViewBackground.setFitWidth(900);
		imageViewBackground.setFitHeight(700);

		Stage window = new Stage();
		window.setWidth(900);
		window.setHeight(700);
		window.setTitle("Instructions");

		Pane pane = new Pane();

		Button closeButton = new Button("Close");

		closeButton.setOnAction(e -> window.close());

		Image img = new Image("File:"+name);
		ImageView iv = new ImageView(img);

		iv.setX(120);
		iv.setY(100);

		//layout.getChildren().addAll(iv , closeButton);

		//layout.setAlignment(Pos.CENTER);


		pane.getChildren().add(imageViewBackground);
		pane.getChildren().add(closeButton);
		pane.getChildren().add(iv);
		Scene scene = new Scene(pane);

		window.setScene(scene);

		window.showAndWait();

	/*	Image imageBackground = new Image("file:7.jpg");
		ImageView imageViewBackground = new ImageView(imageBackground);
		imageViewBackground = imageViewBackground;
		imageViewBackground.setFitWidth(900);
		imageViewBackground.setFitHeight(700);


		Stage window = new Stage();
		window.setWidth(400);
		window.setHeight(150);
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle("Instructions");
		
		window.setMinWidth(900);
		window.setMinHeight(700);
		
		
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		
		
		
		Image img = new Image("File:"+name);
		ImageView iv = new ImageView(img);
		
		layout.getChildren().addAll(iv , closeButton);
		
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		*/
		
		
	}

}
