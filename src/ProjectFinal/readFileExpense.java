package ProjectFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */
public class readFileExpense {

    static Scanner scanner = new Scanner(System.in);
    //read file

    static void readFile(){
        File file = new File("expenses.txt");
        Scanner input;
        String str;
        String[] data;
        String[] dateData;

        try {
            input = new Scanner(file);
            while(input.hasNext()){
                Expense expense = null;
                str = input.nextLine();
                data = str.split(",");
                int propertyID = Integer.parseInt(data[0]);
                String description = data[1];
                float amount = Float.parseFloat(data[2]);
                String str_date = data[3];
                dateData = str_date.split("-");
                int year = Integer.parseInt(dateData[0]);
                int month = Integer.parseInt(dateData[1]);
                int day = Integer.parseInt(dateData[2]);
                DateTime date = new DateTime(day,month,year);
                expense = new Expense(propertyID, description, amount, date);
                Expense.expenseArrayList.add(expense);
            }
        } catch (FileNotFoundException e){
            System.out.println("File is not exist!");
            e.printStackTrace();
            writeFile();
        }
    }

    // create file
    static void writeFile() {
        Expense expense;

        try {
            System.out.println("Enter file name: ");
            String fileName = scanner.next();
            File file = new File(fileName+".txt");
            do {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }while(file.createNewFile());
            PrintWriter printWriter = new PrintWriter(file);

            System.out.println("Enter Property ID: ");
            int propertyID = scanner.nextInt();
            System.out.println("Enter Description: ");
            String description = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Amount: ");
            Float amount = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Enter Day: ");
            int day = scanner.nextInt();
            System.out.println("Enter Month: ");
            int month = scanner.nextInt();
            System.out.println("Enter Year: ");
            int year = scanner.nextInt();
            DateTime date = new DateTime(day,month,year);
            expense = new Expense(propertyID,description,amount,date);
            Expense.expenseArrayList.add(expense);
            printWriter.println(expense.toString());
            printWriter.close();
            System.out.println("Successfully write file.");

        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}
