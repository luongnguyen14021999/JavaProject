package ProjectFinal;

import java.util.Scanner;
/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        readFileProperty.readFile();
        readFileClient.readFile();
        readFileRent.readFile();
        readFileExpense.readFile();
        int option;

        do{
            System.out.println("1. Record Rent Collection.");
            System.out.println("2. Record Expense. ");
            System.out.println("3. Generate Portfolio Report.");
            System.out.println("4. Save.");
            System.out.println("5. Exit Program");
            System.out.print("Select your option: ");
            option = scanner.nextInt();

            while (option < 0 || option > 5) {
                System.out.println("Your option must be range 1-5. Please select again!");
                option = scanner.nextInt();
            }
            if(option == 1) {
                Property.recordRentCollection();
            }
            if(option == 2) {
                Expense.recordExpense();
            }
            if(option == 3) {
                Report.portfolioReport();
            }
            if(option == 4) {
                Save.saveRecordExpense();
                Save.saveRecordRentCollection();
            }
        } while(option != 5);
    }
}

