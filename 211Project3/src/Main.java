import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
        File emma = new File("C:\\Users\\ravid\\Documents\\GitHub\\CS211-Project-3\\211Project3\\Emma.txt");
        HistogramAlphaBet emmaParse = new HistogramAlphaBet();
        emmaParse.mapFromFile(emma);
        System.out.println(Arrays.asList(emmaParse.getCharMap()));
    }
}
