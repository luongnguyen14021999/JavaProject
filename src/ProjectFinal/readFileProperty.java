package ProjectFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */

public class readFileProperty {

    static Scanner scanner = new Scanner(System.in);

    // read file
    static void readFile(){

        File file = new File("properties.txt");
        Scanner input;
        String str;
        String[] data;

        try {
            input = new Scanner(file);
            while(input.hasNext()){
                Property property = null;
                str = input.nextLine();
                data = str.split(",");
                int propertyID = Integer.parseInt(data[0]);
                String add = data[1];
                String suburb = data[2];
                String state = data[3];
                short postcode = Short.parseShort(data[4]);
                Address address = new Address(add,suburb,state,postcode);
                float weeklyRent = Float.parseFloat(data[5]);
                float managementFee = Float.parseFloat(data[6]);
                int clientID = Integer.parseInt(data[7]);
                property = new Property(propertyID, address, weeklyRent, managementFee, clientID);
                Property.propertyArrayList.add(property);
            }
        } catch (FileNotFoundException e){
            System.out.println("File is not exist!");
            e.printStackTrace();
            writeFile();
        }
    }

    //create file
    static void writeFile(){

        Property property;
        Address address;
        ArrayList<Property> propertyArrayList = new ArrayList<>();

        try {
            System.out.println("Enter file name:");
            String fileName = scanner.next();
            File file = new File(fileName+".txt");
            do{
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }while(file.createNewFile());

            PrintWriter printWriter = new PrintWriter(file);
            System.out.println("Enter Client ID:");
            int clientID = scanner.nextInt();
            System.out.println("Enter Property ID: ");
            int propertyId = scanner.nextInt();
            System.out.println("Enter Street Address: ");
            String street = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Suburb: ");
            String suburb = scanner.next();
            scanner.nextLine();
            System.out.println("Enter State: ");
            String state = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Post Code: ");
            short postcode = scanner.nextShort();
            scanner.nextLine();
            System.out.println("Enter Weekly Rent:");
            float weekRent = scanner.nextFloat();
            System.out.println("Enter Management Fee:");
            float mfee = scanner.nextFloat();
            address = new Address(street,suburb,state,postcode);
            property = new Property(propertyId,address,weekRent,mfee,clientID);
            propertyArrayList.add(property);
            printWriter.println(property.toString());
            printWriter.close();
            System.out.println("Successfully write file!");
        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}

