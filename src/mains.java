
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.awt.*;

public class mains extends Application {
	public static void main(String[] args){
		launch(args);
	}
	SL sl = SL.getInstance();
	Remote remote = Remote.getInstance();
	Controller control = Controller.getInstance();
	String musicFile = "anotherDay.mp3";     // For example

	//Media sound = new Media(new File(musicFile).toURI().toString());

	//MediaPlayer mediaPlayer = new MediaPlayer(sound);

	Stage stage;

	ICrossingStrategy strategy;
	ImageView imageViewBackground;


	@Override
	public void start(Stage primaryStage )throws Exception {
    sl.setStage(primaryStage);
	primaryStage.setTitle("River Crosser");
	mainMenu main = new mainMenu(primaryStage);
	main.prepareScene();

      primaryStage.show();


	}}

