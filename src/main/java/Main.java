import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{
            Scanner consoleReader = new Scanner(System.in);
            String pathToDataJsonFile = consoleReader.nextLine();
            String pathToReportJsonFile = consoleReader.nextLine();

            Scanner dataReader = new Scanner(new FileInputStream(pathToDataJsonFile));
            String data = "";

            while(dataReader.hasNextLine()){
                data += dataReader.nextLine();
            }

            Scanner reportReader = new Scanner(new FileInputStream(pathToReportJsonFile));
            String reportContent = "";

            while (reportReader.hasNextLine()){
                reportContent += reportReader.nextLine();
            }
            

        }catch (Exception e){

        }

    }
}
