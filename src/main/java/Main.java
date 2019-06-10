import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileWriter;
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
            

        } catch (Exception e) {

        }

    }
}
