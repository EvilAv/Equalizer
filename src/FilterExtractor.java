import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilterExtractor {
    private static String coefficientsFilename = "C:\\Users\\andre\\MATLAB\\Projects\\WindInTheElevator\\1.fcf";
    private static double[] coefficients;
    private static final int size = 120;
    public static void main(String[] args) {
        coefficients = new double[size+1];
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
        for (int i = 0; i < (size/4); i++) {
            System.out.println(coefficients[4*i] + ", " + coefficients[4*i+1] + ", "+ coefficients[4*i+2] + ", "+ coefficients[4*i+3] + ",");
        }
        System.out.println(coefficients[size]);
    }

}
