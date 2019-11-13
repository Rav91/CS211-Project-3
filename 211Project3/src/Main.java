import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("PieChart");
        Canvas canvas = new Canvas(900, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Label text = new Label("Enter the number of characters to be displayed on the pie chart");
        TextField inputBar = new TextField("");
        Button button = new Button("Submit");
        inputBar.setMaxWidth(100);
        root.setAlignment(text, Pos.TOP_LEFT);
        root.setAlignment(inputBar, );
        root.setTop(text);
        root.setLeft(inputBar);
        root.setLeft(button);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int numToShow = Integer.parseInt(inputBar.getText());
                HistogramAlphaBet frequency = new HistogramAlphaBet();
                PieChart chart = new PieChart(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getHeight(), canvas.getWidth(), frequency);
                chart.draw(gc, numToShow);
            }
        };
        button.setOnAction(event);
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
        File emma = new File("C:\\Users\\ravid\\Documents\\GitHub\\CS211-Project-3\\211Project3\\Emma.txt");
        HistogramAlphaBet emmaParse = new HistogramAlphaBet();
        emmaParse.mapFromFile(emma);
        System.out.println(Arrays.asList(emmaParse.getCharMap()));
    }
}
