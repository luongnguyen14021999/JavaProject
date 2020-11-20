package ProjectFinal;

import java.time.LocalDate;
import java.util.*;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */

public class Expense {
    static Scanner scanner = new Scanner(System.in);
    private int propertyID;
    private String description;
    private float amount;
    private DateTime date;

    static ArrayList<Expense> expenseArrayList = new ArrayList<>();
    static ArrayList <Property> property = new ArrayList<>();
    static ArrayList<Expense> expensesWithCurrentDate = new ArrayList<>();

    public Expense(int propertyID, String description, float amount, DateTime date){
        this.propertyID = propertyID;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() {
        return amount;
    }

    public DateTime getDate() {
        return date;
    }

    public String toString() {

        String string = this.propertyID+","+this.description+","+this.amount+","+this.date.toString();
        return string;
    }

    public static void recordExpense() {

        System.out.print("Please enter the expected address: ");
        String address = scanner.next();
        scanner.nextLine();

        int j = 0;
        int i = 0;
        for(Property properties : Property.propertyArrayList){
            if(properties.getPropertyAddress().toString().contains(address)){
                property.add(properties);
                i++;
                System.out.println("Property "+i+": ");
                System.out.print("Property address: ");
                System.out.println(Property.propertyArrayList.get(j).getPropertyAddress());
                System.out.print("Weekly rent charged: ");
                System.out.println(Property.propertyArrayList.get(j).getWeeklyRent());
                System.out.print("Property owner's full name: ");
                System.out.println(Client.clientArrayList.get(Property.propertyArrayList.get(j).getClientID()).getFirstname()+" "+Client.clientArrayList.get(Property.propertyArrayList.get(j).getClientID()).getSurname());
                System.out.println();

                float amountMoney = 0;
                String descriptionProperty = "";
                
                for(Expense expenses : Expense.expenseArrayList) {
                    if(Property.propertyArrayList.get(j).getPropertyID() == expenses.getPropertyID()) {
                        amountMoney = expenses.getAmount();
                        descriptionProperty = expenses.getDescription();
                        LocalDate currentTime = LocalDate.now();
                        int day = currentTime.getDayOfMonth();
                        int month = currentTime.getMonthValue();
                        int year = currentTime.getYear();
                        DateTime date = new DateTime(day,month,year);
                        DateTime expenseDate = new DateTime(date);
                        Expense expense = new Expense(Property.propertyArrayList.get(j).getPropertyID(),descriptionProperty,amountMoney,expenseDate);
                        expensesWithCurrentDate.add(expense);
                    }
                }
            }
            j++;
        }

        if(expensesWithCurrentDate.size() > 0) {
            System.out.print("Select a property number: ");
            int propertyNumber = scanner.nextInt();
            System.out.println("The details of your chosen property: ");
            System.out.print("Property address: ");
            System.out.println(property.get(propertyNumber-1).getPropertyAddress());
            System.out.println("The summary of the expense: ");
            System.out.print("The property owner’s fullname: ");
            System.out.println(Client.clientArrayList.get(property.get(propertyNumber-1).getClientID()).getFirstname()+" "+Client.clientArrayList.get(property.get(propertyNumber-1).getClientID()).getSurname());
            System.out.println("***********************************************");
            int index = 0;
            for(Expense expenses : expensesWithCurrentDate) {
                if(expenses.getPropertyID() == property.get(propertyNumber-1).getPropertyID()) {
                    System.out.print("The monetary amount: ");
                    System.out.println(expenses.getAmount()+"$");
                    System.out.print("The description of the expense: ");
                    System.out.println(expenses.getDescription());
                    System.out.print("Current date: ");
                    System.out.println(expenses.getDate().toString());
                    System.out.println("*********************************************");
                } else {
                    index++;
                }
            }

            if(index == expensesWithCurrentDate.size()) {
                System.out.print("The monetary amount: ");
                System.out.println("0$");
                System.out.print("The description of the expense: ");
                System.out.println("The property did not have any issues!");
                System.out.print("The property owner’s fullname: ");
                System.out.println(Client.clientArrayList.get(property.get(propertyNumber-1).getClientID()).getFirstname()+" "+Client.clientArrayList.get(property.get(propertyNumber-1).getClientID()).getSurname());
            }
        }
    }
}