import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class AlertBox {
	ImageView imageViewBackground;
	ImageView boatImageView;
    Media sound;
    MediaPlayer mediaPlayer;

    public static void display (String title , String message,MediaPlayer mediaPlayer )
	{
		Image imageBackground;
		if (title.contains("Success"))
		 imageBackground = new Image("file:compl.gif");

		else
			 imageBackground = new Image("file:7ins.gif");

		ImageView imageViewBackground = new ImageView(imageBackground);
		imageViewBackground = imageViewBackground;
		imageViewBackground.setFitWidth(900);
		imageViewBackground.setFitHeight(700);

		Stage window = new Stage();
		window.setWidth(900);
		window.setHeight(700);
		window.setTitle("Alert Box");

	/*	Stage window = new Stage();
		window.setWidth(400);
		window.setHeight(150);
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		
		window.setMinWidth(250);*/
		

		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e -> window.close());

		Pane pane = new Pane();

		pane.getChildren().add(imageViewBackground);
		pane.getChildren().add(closeButton);

		Scene scene = new Scene(pane);
		
		window.setScene(scene);
		
		window.showAndWait();
		
		
		
		
		
	}

}
