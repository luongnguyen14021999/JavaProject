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
public class readFileClient {

    static Scanner scanner = new Scanner(System.in);

    //read file
    static void readFile(){

        File file = new File("clients.txt");
        Scanner input;
        String str;
        String[] data;

        try {
            input = new Scanner(file);
            while(input.hasNext()){
                Client clients = null;
                str = input.nextLine();
                data = str.split(",");
                int id = Integer.parseInt(data[0]);
                String[] name = data[1].split(" ");
                String firstname = name[0];
                String surname = name[1];
                String add = data[2];
                String suburb = data[3];
                String state = data[4];
                short postcode = Short.parseShort(data[5]);
                Address address = new Address(add,suburb,state,postcode);
                clients = new Client(id, firstname, surname, address);
                Client.clientArrayList.add(clients);
            }

        } catch (FileNotFoundException e){
            System.out.println("File is not exist!");
            e.printStackTrace();
            writeFile();
        }
    }


    // create file
    static void writeFile(){

        Client client;
        Address address;

        try {
            System.out.println("Enter file name:");
            String fileName = scanner.next();
            File file = new File(fileName+".txt");
            do{
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                };
            }while(file.createNewFile());

            PrintWriter printWriter = new PrintWriter(file);

            System.out.println("Enter Client ID: ");
            int id = scanner.nextInt();
            System.out.println("Enter Firstname: ");
            String fName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Surname: ");
            String lName = scanner.next();
            scanner.nextLine();
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
            address = new Address(street,suburb,state,postcode);
            client = new Client(id,fName,lName,address);
            Client.clientArrayList.add(client);
            printWriter.println(client.toString());
            printWriter.close();
            System.out.println("Successfully write file.");
        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}
