package ProjectFinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */
public class Save {

    public static void saveRecordRentCollection() {

        String rentFile = "rents.txt";
        PrintWriter printWriter;
        FileWriter fileWriter;
        ArrayList<String> rent = new ArrayList<>();

        try {
            File file = new File(rentFile);
            for (int i = 0; i < Property.collectRent.size(); i++) {
                rent.add(Property.collectRent.get(i).getPropertyID() + "," + Property.collectRent.get(i).getRentAmount() + "," + Property.collectRent.get(i).getRentDate());
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < Property.collectRent.size(); i++) {
                printWriter.write(rent.get(i) + "\n");
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("Successfully save!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveRecordExpense() {

        String expenseFile = "expenses.txt";
        PrintWriter printWriter;
        FileWriter fileWriter;
        ArrayList<String> expense = new ArrayList<>();

        try {
            File file1 = new File(expenseFile);
            for(int i=0; i< Expense.expensesWithCurrentDate.size();i++){
                expense.add(Expense.expensesWithCurrentDate.get(i).getPropertyID()+","+Expense.expensesWithCurrentDate.get(i).getDescription()+","+Expense.expensesWithCurrentDate.get(i).getAmount()+","+Expense.expensesWithCurrentDate.get(i).getDate());
            }

                if (!file1.exists()) {
                    file1.createNewFile();
                }

                fileWriter = new FileWriter(file1, true);
                printWriter = new PrintWriter(fileWriter);
                for (int i=0; i<Expense.expensesWithCurrentDate.size();i++){
                    printWriter.write(expense.get(i)+"\n");
                }
                printWriter.close();
                fileWriter.close();
                System.out.println("Successfully save!");
            } catch (IOException e) {
                e.printStackTrace();
            }
     }
}