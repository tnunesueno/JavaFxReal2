import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;

public class MyFxApp extends Application {
    int cookies = 0;
    int milk = 0;
    int hotCocoa = 0;
    int iceCream = 0;
    Color value = null;
    public void start(Stage primaryStage) throws Exception {
        // Construct and customize all of the Controls

        ProgressBar progressBar1 = new ProgressBar(0);
        progressBar1.setProgress(0);

        ProgressBar progressBar2 = new ProgressBar(0);
        progressBar2.setProgress(0);

        ChoiceBox choiceBox = new ChoiceBox();

        ColorPicker colorPicker = new ColorPicker();
      //  VBox vBox = new VBox(colorPicker);

        RadioButton radioButton1 = new RadioButton("Evil Mode");

        FileInputStream input1 = new FileInputStream("src/Butterscotch.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(250);
        imageView1.setFitWidth(250);

        Button button1 = new Button("Cookies", imageView1);

        FileInputStream input2 = new FileInputStream("src/milk.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(250);
        imageView2.setFitWidth(250);

        Button button2 = new Button("Milk", imageView2);

        Text cookieText = new Text ("Number of Cookies: "+ cookies);
        Text milkText = new Text ("Number of Milk: "+ milk);
        Text hotCocoaText = new Text ("Number of Hot Cocoa: "+ hotCocoa);
        Text iceCreamText = new Text("Number of Ice Cream: "+ iceCream);
        Text text = new Text("");

        // Layout all of the controls in a tree of Layouts and then place top Layout in Scene
        HBox hBox1 = new HBox(40, button1,cookieText,progressBar1);
        HBox hBox2 = new HBox(40, button2, milkText, progressBar2);
        HBox hBox3 = new HBox (40, colorPicker, radioButton1);
        hBox1.setAlignment(Pos.BASELINE_CENTER);
        hBox2.setAlignment(Pos.BASELINE_CENTER);
        VBox vBox1 = new VBox(10,hBox3, hBox1,text, hBox2);
        vBox1.setAlignment(Pos.BASELINE_CENTER);

        colorPicker.setOnAction(actionEvent -> {
            value = colorPicker.getValue();
            BackgroundFill myBackgroundFill = new BackgroundFill(value,null,null);
            Background myBackground = new Background(myBackgroundFill);
            vBox1.setBackground(myBackground);

        });

       radioButton1.setOnAction(actionEvent ->{
           value = Color.RED;
           BackgroundFill myBackgroundFill = new BackgroundFill(value,null,null);
           Background myBackground = new Background(myBackgroundFill);
           vBox1.setBackground(myBackground);
        });

        Scene myScene1 = new Scene(vBox1, 800,800);

        button1.setOnAction(actionEvent -> {
           cookies = cookies+1;
           cookieText.setText("Number of Cookies: "+ cookies);
           progressBar1.setProgress(progressBar1.getProgress()+.05);
       });

        button2.setOnAction(actionEvent -> {
            milk = milk+1;
            milkText.setText("Number of Milk: "+ milk);
            progressBar2.setProgress(progressBar2.getProgress()+.05);
        });

        // setup scene on the stage and show it
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.setScene(myScene1);
        primaryStage.show();
    }
}