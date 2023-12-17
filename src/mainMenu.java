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
import javafx.util.Duration;
import javafx.event.ActionEvent;

import java.io.File;

public class mainMenu {
    Stage stage;
    Scene scene;

    SL sl = SL.getInstance();
    ICrossingStrategy strategy;
    ImageView imageViewBackground;
    Remote remote = Remote.getInstance();
    Controller control = Controller.getInstance();
   // String musicFile = "Another.mp3";     // For example

    //Media sound = new Media(new File(musicFile).toURI().toString());

    //MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public mainMenu(Stage stage) {
        this.stage = stage;
    }

    public void level1Clicked()
    {
        sl.setLevelNum("1");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level1");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();
        control.setLevel(level);

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }

    public void level2Clicked()
    {
        sl.setLevelNum("2");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level2");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();

        control.setLevel(level);
        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }

    public void level3Clicked()
    {
        sl.setLevelNum("3");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level3");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();

        control.setLevel(level);
        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }

    public void level4Clicked()
    {
        sl.setLevelNum("4");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level4");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();

        control.setLevel(level);
        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }

    public void level5Clicked()
    {
        sl.setLevelNum("5");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level5");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();

        control.setLevel(level);
        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }

    public void level6Clicked()
    {
        sl.setLevelNum("6");
        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level6");
        strategy.createActors();
        control.newGame(strategy);
        Level level = new Level();
        control.setLevel(level);
        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        stage.setScene(level.getScene());


    }
    public void load (){
        sl.load();
    }

    public void prepareScene()  {


        Image imageBackground = new Image("file:7 copy 2.gif");
        ImageView imageViewBackground = new ImageView(imageBackground);
        this.imageViewBackground = imageViewBackground;
        imageViewBackground.setFitWidth(1300);
        imageViewBackground.setFitHeight(800);





        Image level1S = new Image("file:level1Scroll.gif");
        // level1.setGraphic(new ImageView(level1S));
        ImageView level1 = new ImageView(level1S);



        level1.setOnMouseClicked((MouseEvent e) -> {

        level1Clicked();

        });
        Image level2S = new Image("file:level2Scroll.gif");
        ImageView level2 = new ImageView(level2S);


        level2.setOnMouseClicked((MouseEvent e) -> {
            level2Clicked();


        });
        Image level3S = new Image("file:Level3.gif");
        ImageView level3 = new ImageView(level3S);


        level3.setOnMouseClicked((MouseEvent e) -> {
            level3Clicked();


        });

        Image level4S = new Image("file:Level4.gif");
        ImageView level4 = new ImageView(level4S);


        level4.setOnMouseClicked((MouseEvent e) -> {
            level4Clicked();


        });
        Image level5S = new Image("file:level5scroll.gif");
        ImageView level5 = new ImageView(level5S);


        level5.setOnMouseClicked((MouseEvent e) -> {
            level5Clicked();


        });
        Image level6S = new Image("file:level6scroll.gif");
        ImageView level6 = new ImageView(level6S);


        level6.setOnMouseClicked((MouseEvent e) -> {
            level6Clicked();


        });

        Image loadI = new Image("file:loadI.gif");
        ImageView lo = new ImageView(loadI);
        lo.setOnMouseClicked((MouseEvent e) -> {
           load();


        });

        Pane pane = new Pane();

        // HBox hbox = new HBox(level1,level2,level3,level4);
        // hbox.setSpacing(5);
        // hbox.setMaxSize(100,70);


        // hbox.setMargin(level2, new Insets(20,20,20,20));
        //hbox.setMargin(level3, new Insets(20,20,20,20));
        // hbox.setMargin(level4, new Insets(20,20,20,20));
        level1.setFitHeight(330);
        level1.setFitWidth(200);
        level1.setX(250);
        level1.setY(230);

        level2.setFitHeight(330);
        level2.setFitWidth(210);
        level2.setX(380);
        level2.setY(165);

        level3.setFitHeight(450);
        level3.setFitWidth(470);
        level3.setX(435);
        level3.setY(130);

        level4.setFitHeight(575);
        level4.setFitWidth(465);
        level4.setX(640);
        level4.setY(225);

        level5.setFitHeight(390);
        level5.setFitWidth(830);
        level5.setX(780);
        level5.setY(225);

        level6.setFitHeight(1300);
        level6.setFitWidth(1600);
        level6.setX(900);
        level6.setY(225);

        lo.setFitWidth(100);
        lo.setFitHeight(100);
       lo.setX(0);
       lo.setY(0);
    /* GridPane grid = new GridPane();

        grid.add(level1,0,0);
        grid.add(level2,1,0);
        grid.add(level3,2,0);
        grid.add(level4,3,0);*/
        //grid.setLayoutX(70);
        // grid.setLayoutY(200);
        pane.getChildren().add(imageViewBackground);

        //  pane.getChildren().add(hbox);
        pane.getChildren().add(level1);
        pane.getChildren().add(level2);
        pane.getChildren().add(level3);
        pane.getChildren().add(level4);
        pane.getChildren().add(level5);
        pane.getChildren().add(level6);
        pane.getChildren().add(lo);
        scene = new Scene(pane, 1300,800);

        stage.setScene(scene);

       // mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        //mediaPlayer.play();



    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Scene getScene() {
        return this.scene;
    }
}

