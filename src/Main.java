import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        String responseData;

        System.out.println("List of options");
        System.out.println("1: Get player MMR:");
        System.out.println("2: Get heroes match ID:");
        System.out.println("3: Others:");

        choice = sc.nextInt();

        switch (choice) {
            case 1: responseData = Player.getMMR();
                    writeFile(responseData);
                break;
            /*case 2: GetDota();
                break;
            case 3: GetDota();
                break;*/
        }
    }

    public static void writeFile(String responseData) {

        String csvFile =  "D:/Intellij/Dota/output.csv";

        System.out.println(responseData);
            try {
                FileWriter writer = new FileWriter(csvFile);

                // Write the header row if needed
                writer.append("Response Data\n");

                // Write the data row
                writer.append(responseData);

                writer.flush();
                writer.close();

                System.out.println("Data has been written to the CSV file.");
            }

            catch (IOException e) {
                e.printStackTrace();
            }
    }
}
