import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            Scanner consoleReader = new Scanner(System.in);
            String pathToDataJsonFile = consoleReader.nextLine();
            String pathToReportJsonFile = consoleReader.nextLine();

            Scanner dataReader = new Scanner(new FileInputStream(pathToDataJsonFile));
            String data = "";

            while (dataReader.hasNextLine()) {
                data += dataReader.nextLine();
            }

            Scanner reportReader = new Scanner(new FileInputStream(pathToReportJsonFile));
            String reportContent = "";

            while (reportReader.hasNextLine()) {
                reportContent += reportReader.nextLine();
            }

            Gson parser = new Gson();

            Employee[] employees = parser.fromJson(data, Employee[].class);
            Report report = parser.fromJson(reportContent, Report.class);

            for (int i = 0; i < employees.length; i++) {
                if (report.isUseExprienceMultiplier()) {

                    double score = employees[i].getTotalSales() / employees[i].getSalesPeriod() * employees[i].getExperienceMultiplier();
                    employees[i].setScore(score);

                } else {

                    double score = employees[i].getTotalSales() / employees[i].getSalesPeriod();
                    employees[i].setScore(score);
                }
            }

            FileWriter resultWriter = new FileWriter("result.csv");
            resultWriter.write("Name, Score\n");

            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalesPeriod() <= report.getPeriodLimit()) {
                    resultWriter.write(employees[i].getName() + ", " + employees[i].getScore() + "\n");
                }
            }

            resultWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
