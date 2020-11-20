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

public class readFileRent {

    static Scanner scanner = new Scanner(System.in);

    //read file
    static void readFile(){
        File file = new File("rents.txt");
        Scanner input;
        String str = null;
        String[] data;
        String[] dateData;

        try {
            input = new Scanner(file);
            while(input.hasNext()){
                Rent rent = null;
                str = input.nextLine();
                data = str.split(",");
                int propertyID = Integer.parseInt(data[0]);
                float rentAmount = Float.parseFloat(data[1]);
                String str_date = data[2];
                dateData = str_date.split("-");
                int year = Integer.parseInt(dateData[0]);
                int month = Integer.parseInt(dateData[1]);
                int day = Integer.parseInt(dateData[2]);
                DateTime date = new DateTime(day,month,year);
                rent = new Rent(propertyID, rentAmount, date);
                Rent.rentArrayList.add(rent);
            }
        } catch (FileNotFoundException e){
            System.out.println("File is not exist!");
            e.printStackTrace();
            writeFile();
        }
    }

    // write file
    static void writeFile(){

        try {
            System.out.println("Enter file name: ");
            String fileName = scanner.next();
            scanner.nextLine();
            File file = new File(fileName+".txt");
            do {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }while(file.createNewFile());
            PrintWriter printWriter = new PrintWriter(file);
            System.out.println("Enter PropertyID: ");
            int propertyID = scanner.nextInt();
            System.out.println("Enter Property Amount: ");
            int amount = scanner.nextInt();
            System.out.println("Enter Rent Day: ");
            int day = scanner.nextInt();
            System.out.println("Enter Rent Month: ");
            int month = scanner.nextInt();
            System.out.println("Enter Rent Year: ");
            int year = scanner.nextInt();
            DateTime date = new DateTime(day,month,year);
            Rent rent =  new Rent(propertyID,amount,date);
            Rent.rentArrayList.add(rent);
            printWriter.println(rent.toString());
            printWriter.close();
            System.out.println("Successfully write file!");

        } catch (IOException e){
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}

