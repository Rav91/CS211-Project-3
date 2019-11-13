import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HistogramAlphaBet {
    private HashMap<Character, Double> charMap;
    private double total;

    HistogramAlphaBet(){
        this.charMap = new HashMap<Character, Double>();
        this.total = 0;
    }

    public void increment(){
        this.total++;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public HashMap<Character, Double> getCharMap() {
        return charMap;
    }

    public void setCharMap(HashMap<Character, Double> charMap) {
        this.charMap = charMap;
    }

    public void mapFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            char[] line = scanner.nextLine().toLowerCase().toCharArray();
            for (Character character : line) {
                if (Character.isLetter(character)){
                    increment();
                    if (charMap.containsKey(character)) {
                        charMap.put(character, charMap.get(character) + 1.0);
                    } else {
                        charMap.put(character, 1.0);
                    }
                }
            }
        }
        scanner.close();
        for (Map.Entry<Character, Double> entry : charMap.entrySet()) {
            charMap.replace(entry.getKey(), (entry.getValue() / total));
        }
    }
}