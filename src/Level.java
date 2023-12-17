import java.io.File;
import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class Level {
	ImageView imageViewBackground;
	ImageView boatImageView;
	Label moves;
	ArrayList<ICrosser> list= new ArrayList<ICrosser>();
	Controller control;
	//static Level level;
	Pane pane;
	ICrossingStrategy strategy;
	Scene scene;
	Stage stage;
	TranslateTransition trans = new TranslateTransition() ;
	TranslateTransition trans2 = new TranslateTransition() ;
	TranslateTransition trans3 = new TranslateTransition() ;
	Media sound;
	MediaPlayer mediaPlayer;


	
	
	public void prepareScene(ICrossingStrategy strategy , Stage stage/*, MediaPlayer mediaPlayer*/)
	{


		this.stage=stage;

		this.strategy =  strategy;
		control = Controller.getInstance();
		list =  strategy.getInitialCrossers();
		
		Image imageBackground = new Image("file:7.jpg");
		ImageView imageViewBackground = new ImageView(imageBackground);
		this.imageViewBackground = imageViewBackground;
		imageViewBackground.setFitWidth(1300);
		imageViewBackground.setFitHeight(800);
	
	Image imageBoat = new Image("file:b.png");
	ImageView boatImageView = new ImageView(imageBoat);
	this.boatImageView =boatImageView; 
	boatImageView.setFitHeight(200);
	boatImageView.setFitWidth(400);
	
		
		Pane pane = new Pane();
		this.pane=pane;
		pane.getChildren().add(imageViewBackground);
		pane.getChildren().add(boatImageView);

		
		

		
		
		
		boatImageView.setX(300);
		boatImageView.setY(550);
		
		addAll();
		updateAll();
		
		//HBox hbox = new HBox();
		/*Button reset = new Button("reset");
		Button undo = new Button("undo");
		Button redo = new Button("redo");
		Button instructions = new Button("Instructions");*/
        Image undo = new Image("file:undo.gif");
        ImageView un = new ImageView(undo);

        Image redo = new Image("file:redo.gif");
        ImageView re = new ImageView(redo);

        Image back = new Image("file:backB.gif");
        ImageView ba = new ImageView(back);

        Image instructions = new Image("file:instructions.gif");
        ImageView ins = new ImageView(instructions);

        Image reset = new Image("file:reset.gif");
        ImageView res = new ImageView(reset);

		Image save = new Image("file:save.gif");
		ImageView sa = new ImageView(save);



		Label label = new Label("Moves");
		moves = new Label("");


		label.setTextFill(Color.web("WHITE"));
		moves.setTextFill(Color.web("WHITE"));

		label.setFont(Font.font("Veranda", FontPosture.ITALIC,20));
		moves.setFont(Font.font("Veranda", FontPosture.ITALIC,20));


        un.setFitHeight(200);
        un.setFitWidth(150);
        un.setX(50);
        un.setY(0);

        re.setFitHeight(200);
        re.setFitWidth(150);
        re.setX(250);
        re.setY(0);

        ba.setFitHeight(200);
        ba.setFitWidth(150);
        ba.setX(450);
        ba.setY(0);

        ins.setFitHeight(200);
        ins.setFitWidth(150);
        ins.setX(650);
        ins.setY(0);

        res.setFitHeight(200);
        res.setFitWidth(150);
        res.setX(850);
        res.setY(0);

		sa.setFitHeight(200);
		sa.setFitWidth(150);
		sa.setX(1050);
		sa.setY(0);

		label.setLayoutX(1050);
		label.setLayoutY(250);

		moves.setLayoutX(1050);
		moves.setLayoutY(270);
		
	//	hbox.getChildren().add(reset);
	//	hbox.getChildren().add(un);
	//	hbox.getChildren().add(re);
		//hbox.getChildren().add(instructions);

        un.setOnMouseClicked((MouseEvent e) ->{

            undo();
        });

        re.setOnMouseClicked((MouseEvent e) ->{

            redo();
        });

        ins.setOnMouseClicked((MouseEvent e) ->{

            InstructionBox.display(strategy.getImageName(),mediaPlayer);
        });

        res.setOnMouseClicked((MouseEvent e) ->{

           reset();
        });
       ba.setOnMouseClicked((MouseEvent e) ->{

          back();

        });

		sa.setOnMouseClicked((MouseEvent e) ->{

			save();

		});


	/*	reset.setOnAction(e->reset());
		undo.setOnAction(e->undo());
		redo.setOnAction(e->redo());
		instructions.setOnAction(e->InstructionBox.display(strategy.getImageName()));*/
		
		pane.getChildren().add(re);
        pane.getChildren().add(un);
        pane.getChildren().add(ba);
        pane.getChildren().add(ins);
        pane.getChildren().add(res);
        pane.getChildren().add(sa);
		pane.getChildren().add(label);
		pane.getChildren().add(moves);
		// when i click on boat
		boatImageView.setOnMouseClicked((MouseEvent e) -> {
			boolean isValid = strategy.isValid(control.getCrossersOnRightBank(), control.getCrossersOnLeftBank(), control.getBoatRiders());
			if(!isValid)
			{
				AlertBox.display("Error", "Invalid Move", mediaPlayer);
				return;}
			control.getNumberOfSails++;
			moves.setText("");
			moves.setText(""+control.getNumberOfSails);



			moveBoat();

			Caretaker care = Caretaker.getInstance();
			
			Originator origin = new Originator();
			origin.setState(control.getCrossersOnRightBank(), control.leftBankCrossers, control.getBoatRiders(), control.boatOnLeft, control.getNumberOfSails);
			
			care.add(origin.save());
					
			
        });



		scene = new Scene(pane, 1300,800);
				
		
		
	}
	
	public Scene getScene()
	{
		
	return scene;	
	}

	public void save(){

		SL sl = SL.getInstance();
		sl.save(strategy);

	}
	public void updateLoad(){
		int size = strategy.getInitialCrossers().size();
		ArrayList<ICrosser> list = strategy.getInitialCrossers();
		int i=0;


		while(i<size)
		{



			 if(control.getCrossersOnRightBank().contains(list.get(i)))
			{


				list.get(i).getImageView().setImage(list.get(i).getImages().get(1));
				int index = control.getCrossersOnRightBank().indexOf(list.get(i));
				list.get(i).getImageView().setTranslateX(600);

			}





			i++;
		}
	}
	public void updateAll()
	{
		int size = strategy.getInitialCrossers().size();
		ArrayList<ICrosser> list = strategy.getInitialCrossers();
		int i=0;

		
		while(i<size)
		{
			
			if(control.getCrossersOnLeftBank().contains(list.get(i)))
				{
			list.get(i).getImageView().setImage(list.get(i).getImages().get(0));
				int index = control.getCrossersOnLeftBank().indexOf(list.get(i));
				list.get(i).getImageView().setX(index*100);
				list.get(i).getImageView().setY(550);
				
				}
			
		else if(control.getCrossersOnRightBank().contains(list.get(i)))
			{
			
			
			list.get(i).getImageView().setImage(list.get(i).getImages().get(1));
			int index = control.getCrossersOnRightBank().indexOf(list.get(i));
			list.get(i).getImageView().setX(300+index*100);
			list.get(i).getImageView().setY(530);
			
			}

			else if(control.getBoatRiders().contains(list.get(i)))
			{
				
			int index = control.getBoatRiders().indexOf(list.get(i));
			
			list.get(i).getImageView().setX(boatImageView.getX()+150+index*100);
			list.get(i).getImageView().setY(boatImageView.getY()+40);
			
			}
			
			
		
		i++;
		}
		
		
	}
	
	public void addAll()
	{
		int i=0;
		while(i<list.size())
		{
			pane.getChildren().add(list.get(i).getImageView());
			i++;
			
		}
		
	}

	public void reset()
	{
		
		strategy.createActors();
		control.resetGame();
		Level level = new Level();
		control.setLevel(level);
		level.prepareScene(strategy,stage/*,mediaPlayer*/);
		stage.setScene(level.getScene());	
		
	}
	public void back(){
		mainMenu main = new mainMenu(stage);
		main.prepareScene();
		mediaPlayer.setMute(true);
		stage.setScene(main.getScene());

	}
	public void moveBoat()
	{

		boolean flag1 = control.getBoatRiders().size()==1;
		boolean flag2 = control.getBoatRiders().size()==2;
		
		trans.setNode(boatImageView);
		
		if(flag1 || flag2)
			trans2.setNode(control.getBoatRiders().get(0).getImageView());
		

		if(flag2)
			trans3.setNode(control.getBoatRiders().get(1).getImageView());
		
		
		
		trans.setDuration(Duration.seconds(2));
		trans.setByY(0);
		

		trans2.setDuration(Duration.seconds(2));
		trans2.setByY(0);
		

		trans3.setDuration(Duration.seconds(2));
		trans3.setByY(0);
			
		if(	control.isBoatOnLeftBank())
		{
		trans.setByX(600);
		trans2.setByX(600);
		trans3.setByX(600);
		
		control.boatOnLeft=false;

		}
		
		else
		{
		trans.setByX(-600);
		trans2.setByX(-600);
		trans3.setByX(-600);
		control.boatOnLeft=true;

		}
		trans.play();
		if(flag1 || flag2)
			trans2.play();
		if(flag2)
			trans3.play();

		
	}

	public void moveBoat2()
	{

		boolean flag1 = control.getBoatRiders().size()==1;
		boolean flag2 = control.getBoatRiders().size()==2;

		trans.setNode(boatImageView);

		if(flag1 || flag2)
			trans2.setNode(control.getBoatRiders().get(0).getImageView());


		if(flag2)
			trans3.setNode(control.getBoatRiders().get(1).getImageView());



		trans.setDuration(Duration.seconds(0.1));
		trans.setByY(0);


		trans2.setDuration(Duration.seconds(0.1));
		trans2.setByY(0);


		trans3.setDuration(Duration.seconds(0.1));
		trans3.setByY(0);

		if(	control.isBoatOnLeftBank())
		{
			trans.setByX(600);
			trans2.setByX(600);
			trans3.setByX(600);

			control.boatOnLeft=false;

		}

		else
		{
			trans.setByX(-600);
			trans2.setByX(-600);
			trans3.setByX(-600);
			control.boatOnLeft=true;

		}
		trans.play();
		if(flag1 || flag2)
			trans2.play();
		if(flag2)
			trans3.play();


	}

	public void undo()
	{
		
		control.undo();
		moves.setText(""+control.getNumberOfSails);
	}
	
	public void redo()
	{
		control.redo();
		moves.setText(""+control.getNumberOfSails);
	}


	public Stage getStage() {
		return stage;
	}
}
