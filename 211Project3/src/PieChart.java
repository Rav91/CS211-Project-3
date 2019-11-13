import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class PieChart {
    private double x;
    private double y;
    private double height;
    private double width;
    private  HistogramAlphaBet drawSource;

    PieChart(double x, double y, double height, double width, HistogramAlphaBet drawSource){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.drawSource = drawSource;
    }

    public void draw(GraphicsContext gc, int numArcs){

    }

    public Color getRandColor(){
        Random rand = new Random();
        return Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
}
