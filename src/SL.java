import java.util.ArrayList;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.stage.Stage;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class SL {

    Media sound;
    MediaPlayer mediaPlayer;
    private String levelNum;
    private String boatOnLeft;
    private String getNumberOfSails;

    private String leftBankCrossers;
    private String rightBankCrossers;
    private String boatRiders;

    private Remote remote = Remote.getInstance();

    private Controller control = Controller.getInstance();
    private Stage stage;
    private ICrossingStrategy strategy;

    private static SL obj;


    private SL()
    {

    }

    public static SL getInstance()
    {
        if(obj == null)
            obj = new SL();

        return obj;

    }



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLevelNum(String levelNum) {
        this.levelNum = levelNum;

    }

    public void save(ICrossingStrategy s)
    {
        Controller control = Controller.getInstance();
        boatOnLeft = String.valueOf(control.boatOnLeft);
        getNumberOfSails= String.valueOf(control.getNumberOfSails);
        makeLeft(s);
        makeRight(s);
        makeBoat(s);
        saveFile();





    }


    private void makeLeft(ICrossingStrategy s)
    {

        ArrayList<ICrosser> i = s.getInitialCrossers();
        ArrayList<ICrosser> l = Controller.getInstance().leftBankCrossers;
        leftBankCrossers =" ";
        int c =0;
        while(c<l.size())
        {
            if(i.contains(l.get(c)))
            {leftBankCrossers = leftBankCrossers + String.valueOf(i.indexOf(l.get(c)));

            }
            c++;
        }



    }

    private void makeRight(ICrossingStrategy s)
    {
        ArrayList<ICrosser> i = s.getInitialCrossers();
        ArrayList<ICrosser> r = Controller.getInstance().rightBankCrossers;
        rightBankCrossers =" ";
        int c =0;
        while(c<r.size())
        {
            if(i.contains(r.get(c)))
            {rightBankCrossers = rightBankCrossers + String.valueOf(i.indexOf(r.get(c)));

            }
            c++;
        }


    }
    private void makeBoat(ICrossingStrategy s)
    {
        ArrayList<ICrosser> i = s.getInitialCrossers();
        ArrayList<ICrosser> b = Controller.getInstance().boatRiders;
        boatRiders =" ";
        int c =0;
        while(c<b.size())
        {
            if(i.contains(b.get(c)))
            {boatRiders = boatRiders + String.valueOf(i.indexOf(b.get(c)));

            }
            c++;
        }




    }






    public void saveFile() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                    doc.createElementNS("data", "level");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getLevel(doc, levelNum , leftBankCrossers , rightBankCrossers , boatRiders , boatOnLeft , getNumberOfSails));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("level.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getLevel(Document doc, String number, String left, String right, String boat , String pos , String sail) {
        Element level = doc.createElement("level");

//        //set id attribute
//        level.setAttribute("number", number);


        //create name element
        level.appendChild(getlevelElements(doc, level, "number", number));


        //create name element
        level.appendChild(getlevelElements(doc, level, "left", left));

        //create age element
        level.appendChild(getlevelElements(doc, level, "right", right));

//        //create role element
        level.appendChild(getlevelElements(doc, level, "boat", boat));

//     //create role element
        level.appendChild(getlevelElements(doc, level, "pos", pos));

//  //create role element
        level.appendChild(getlevelElements(doc, level, "sails", sail));



        return level;
    }


    //utility method to create text node
    private static Node getlevelElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }




    public void loadFile() {
        String filePath = "level.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("level");
            //now XML is loaded as Document in memory, lets convert it to Object List

            getLevel(nodeList.item(0));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }


    private  void getLevel(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;

            levelNum=getTagValue("number", element);
            System.out.println(levelNum);

            getNumberOfSails=getTagValue("sails", element);
            System.out.println(getNumberOfSails);


            leftBankCrossers = getTagValue("left", element);
            System.out.println(leftBankCrossers);


            rightBankCrossers = getTagValue("right", element);
            System.out.println(rightBankCrossers);

            boatRiders = getTagValue("boat", element);
            System.out.println(boatRiders);


            boatOnLeft = getTagValue("pos", element);
            System.out.println(boatOnLeft);




        }


    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }






    public void load()
    {
        loadFile();
        if(levelNum.equals("1"))
            level1Clicked();

        if(levelNum.equals("2"))
            level2Clicked();

        if(levelNum.equals("3"))
            level3Clicked();

        if(levelNum.equals("4"))
            level4Clicked();

        if(levelNum.equals("5"))
            level5Clicked();

        if(levelNum.equals("6"))
            level6Clicked();



    }




    public void level1Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level1");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);

    }

    public void level2Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level2");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);
    }

    public void level3Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level3");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);
    }

    public void level4Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level4");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);
    }

    public void level5Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level5");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/
        );
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);
    }

    public void level6Clicked()
    {

        StrategyFactory factory = new StrategyFactory();
        strategy = factory.createFactory("Level6");
        strategy.createActors();
        control.newGame(strategy);
        control.getNumberOfSails = Integer.parseInt(getNumberOfSails);
        Level level = new Level();
        control.setLevel(level);
        control.leftBankCrossers.removeAll(control.leftBankCrossers);
        updateLeft();
        updateRight();
        updateBoat();

        level.prepareScene(strategy,stage/*,mediaPlayer*/);
        level.updateLoad();
        stage.setScene(level.getScene());
        updateBoat(level);


    }

    public void updateBoat(Level level)
    {

        if(boatOnLeft.equals("false"))
            level.moveBoat2();

    }

    public void updateLeft()
    {
        ArrayList<ICrosser> i = strategy.getInitialCrossers();
        ArrayList<ICrosser> l = Controller.getInstance().leftBankCrossers;
        int c =0;
        while(c<i.size())
        {
            if(leftBankCrossers.contains(String.valueOf(i.indexOf(i.get(c)))))
            {
                control.leftBankCrossers.add(i.get(c));
            }
            c++;
        }


    }

    public void updateRight()
    {
        ArrayList<ICrosser> i = strategy.getInitialCrossers();
        ArrayList<ICrosser> l = Controller.getInstance().rightBankCrossers;
        int c =0;
        while(c<i.size())
        {
            if(rightBankCrossers.contains(String.valueOf(i.indexOf(i.get(c)))))
            {
                control.rightBankCrossers.add(i.get(c));
            }
            c++;
        }


    }


    public void updateBoat()
    {
        ArrayList<ICrosser> i = strategy.getInitialCrossers();
        ArrayList<ICrosser> l = Controller.getInstance().boatRiders;
        int c =0;
        while(c<i.size())
        {
            if(boatRiders.contains(String.valueOf(i.indexOf(i.get(c)))))
            {
                control.boatRiders.add(i.get(c));
            }
            c++;
        }


    }


}



