package ProjectFinal;


import java.time.LocalDate;
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
public class Property {

    private int propertyID;
    private float weeklyRent;
    private float managementFee;
    private int clientID;
    private Address propertyAddress;

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Property> propertyArrayList = new ArrayList<>();

    static ArrayList <Property> properties = new ArrayList<>();

    static ArrayList<Rent>  collectRent = new ArrayList<>();

    public Property(int propertyID, Address propertyAddress, float weeklyRent, float managementFee, int clientID){
        this.propertyID = propertyID;
        this.propertyAddress = propertyAddress;
        this.weeklyRent = weeklyRent;
        this.managementFee = managementFee;
        this.clientID = clientID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public float getWeeklyRent() {
        return weeklyRent;
    }

    public float getManagementFee() {
        return managementFee;
    }

    public int getClientID() {
        return clientID;
    }

    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public static void recordRentCollection(){
        System.out.println();
        System.out.print("Please enter the expected address: ");
        String address = scanner.next();
        scanner.nextLine();
        int index = 0;
        for(Property property: Property.propertyArrayList){
            if(property.getPropertyAddress().toString().contains(address)){
                properties.add(property);
                index++;
                System.out.println("Property "+index+": ");
                System.out.print("Property address: ");
                System.out.println(property.getPropertyAddress());
            }
        }
        if(properties.size() > 0) {
            System.out.print("Select a property number: ");
            int propertyNumber = scanner.nextInt();
            System.out.println("The details of your property: ");
            System.out.print("The Property address: ");
            System.out.println(properties.get(propertyNumber-1).getPropertyAddress());
            System.out.print("The Weekly rent charged: ");
            System.out.println(properties.get(propertyNumber-1).getWeeklyRent());
            System.out.print("The Property Owner's Full Name: ");
            System.out.println(Client.clientArrayList.get(properties.get(propertyNumber-1).getClientID()).getFirstname()+" "+Client.clientArrayList.get(properties.get(propertyNumber-1).getClientID()).getSurname());
            System.out.println();
            System.out.print("How many weeks of rent was collected for the chosen property: ");
            int weeks = scanner.nextInt();
            System.out.print("The amount of collected renting: ");
            System.out.println(properties.get(propertyNumber-1).getWeeklyRent()*weeks+"$");
            int propertyID = properties.get(propertyNumber-1).getPropertyID();
            float amount = properties.get(propertyNumber-1).getWeeklyRent()*weeks;
            LocalDate currentDate = LocalDate.now();
            int day = currentDate.getDayOfMonth();
            int month = currentDate.getMonthValue();
            int year = currentDate.getYear();
            DateTime date = new DateTime(day,month,year);
            DateTime rentDate = new DateTime(date);
            Rent rent = new Rent(propertyID,amount,rentDate);
            collectRent.add(rent);
            System.out.println("Summary of your rent collection transaction:");
            System.out.println("The Property address: "+properties.get(propertyNumber-1).getPropertyAddress());
            System.out.println("The monetary amount: "+properties.get(propertyNumber-1).getWeeklyRent()*weeks+"$");
            System.out.println("The number of weeks rent collected: "+weeks);
            System.out.println("The property owner's name: "+Client.clientArrayList.get(properties.get(propertyNumber-1).getClientID()).getFirstname()+" "+Client.clientArrayList.get(properties.get(propertyNumber-1).getClientID()).getSurname());
            System.out.println("The current date: "+rentDate.toString());
            properties.clear();
        } else {
        	System.out.println("Your address is not exist!");
        }
    }
}
  
