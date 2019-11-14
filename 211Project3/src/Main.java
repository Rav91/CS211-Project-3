import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        File emma = new File("C:\\Users\\ravid\\Documents\\GitHub\\CS211-Project-3\\211Project3\\Emma.txt");
        HistogramAlphaBet emmaParse = new HistogramAlphaBet();
        emmaParse.mapFromFile(emma);
        emmaParse.setCharMap(emmaParse.sortHashMapByValues(emmaParse.getCharMap()));

        primaryStage.setTitle("PieChart");
        Canvas canvas = new Canvas(900, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        TextField inputBar = new TextField("Enter the number of characters to be displayed on the pie chart");
        Button button = new Button("Submit");
        root.setTop(inputBar);
        root.setLeft(button);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                int numToShow = Integer.parseInt(inputBar.getText());
                PieChart chart = new PieChart(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getHeight(), canvas.getWidth(), emmaParse);
                chart.draw(gc, numToShow);
            }
        };
        button.setOnAction(event);
    }


    public static void main(String[] args) { launch(args); }
}
