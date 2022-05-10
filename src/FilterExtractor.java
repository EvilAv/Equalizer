import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilterExtractor {
    private static String coefficientsFilename = "C:\\Users\\andre\\MATLAB\\Projects\\WindInTheElevator\\8.fcf";
    private static double[] coefficients;
    public static void main(String[] args) {
        coefficients = new double[77];
        try{
        File coefficientsFile = new File(coefficientsFilename);
        Scanner scanner = new Scanner(coefficientsFile);
        int i = 0;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            coefficients[i] = Double.parseDouble(data);
            i++;
        }
        scanner.close();
    } catch (
    FileNotFoundException e) {
        System.out.println("File not found");
        e.printStackTrace();
    }
        for (int i = 0; i < 19; i++) {
            System.out.println(coefficients[4*i] + ", " + coefficients[4*i+1] + ", "+ coefficients[4*i+2] + ", "+ coefficients[4*i+3] + ",");
        }

    }

}
