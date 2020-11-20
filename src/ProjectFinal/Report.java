package ProjectFinal;

import java.util.*;
/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */
public class Report {

    static Scanner scanner = new Scanner(System.in);
    public static void portfolioReport() {

        System.out.println("1. Specific client");
        System.out.println("2. All clients");
        System.out.println("3. Specified postcode");
        System.out.print("Select a option: ");
        Date currentDate  = new Date();
        float totalRent = 0;
        float totalExpense = 0;
        float totalFee = 0;
        float totalNet = 0;

        int option = scanner.nextInt();
        if (option == 1) {
            System.out.print("Enter the client's name: ");
            String name = scanner.next();
            System.out.println();
            int i = 0;
            ArrayList<Client> foundClient = new ArrayList<>();
            for (Client clients : Client.clientArrayList) {
                if (clients.getSurname().contains(name) || clients.getFirstname().contains(name)) {
                    foundClient.add(clients);
                    i++;
                    System.out.println("Client "+i+": ");
                    System.out.print("Fullname: ");
                    System.out.println(foundClient.get(i-1).getFirstname()+" "+foundClient.get(i-1).getSurname());
                    System.out.print("Client Address: ");
                    System.out.println(foundClient.get(i-1).getAddress());
                }
            }
            if(foundClient.size() > 0) {

                System.out.print("Select a client number: ");
                int clientNumber = scanner.nextInt();
                System.out.println("\n");
                System.out.println("PORTFOLIO REPORT");
                System.out.print("Client: ");
                System.out.println(foundClient.get(clientNumber - 1).getFirstname() + " " + foundClient.get(clientNumber - 1).getSurname() + ", " + foundClient.get(clientNumber - 1).getAddress());
                System.out.println("Report Generated: " + currentDate);
                System.out.printf("%.150s\n", "--------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n", "Property", "Rent", "Expenses", "Fee Rate", "Fees", "Net");
                System.out.printf("%.150s\n", "--------------------------------------------------------------------------------------------------------------------------------------------------");

                for (Property property : Property.propertyArrayList) {
                    float expenses = 0;
                    float rents = 0;
                    if (property.getClientID() == foundClient.get(clientNumber - 1).getClientID()) {
                        for (Expense expense : Expense.expenseArrayList) {
                            if (expense.getPropertyID() == property.getPropertyID()) {
                                expenses = expenses + expense.getAmount();
                            }
                        }
                        for (Rent rent : Rent.rentArrayList) {
                            if (rent.getPropertyID() == property.getPropertyID()) {
                                rents = rents + rent.getRentAmount();
                            }
                        }
                        System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n", property.getPropertyAddress().toString(), rents, expenses, property.getManagementFee(), rents * property.getManagementFee(), (rents - expenses - rents * property.getManagementFee()));
                        totalRent = totalRent + rents;
                        totalExpense = totalExpense + expenses;
                        totalFee = totalFee + rents * property.getManagementFee();
                        totalNet = totalNet + rents - expenses - rents * property.getManagementFee();
                    }

                }
                System.out.printf("%.150s\n", "--------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|%60s|%16s|%16s|%16s|%16s|%16s|\n", "TOTAL", totalRent, totalExpense, "", totalFee, totalNet);
                System.out.printf("%.150s\n", "--------------------------------------------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Can not find your client's name!");
            }
        }
        if(option == 2) {
            sortClients(Client.clientArrayList);
            for(Client client: Client.clientArrayList){
                System.out.println("PORTFOLIO REPORT");
                System.out.print("Client: ");
                System.out.println(client.getFirstname()+" "+client.getSurname()+", "+
                        client.getAddress());
                System.out.println("Report Generated: "+currentDate);
                System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n","Property","Rent","Expenses","Fee Rate","Fees","Net");
                System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");

                for(Property property: Property.propertyArrayList){
                    float expenses = 0;
                    float rents = 0;
                    if(property.getClientID() == client.getClientID()){
                        for (Expense expense: Expense.expenseArrayList){
                            if (expense.getPropertyID()==property.getPropertyID()){
                                expenses = expenses+ expense.getAmount();
                            }
                        }
                        for(Rent rent: Rent.rentArrayList){
                            if(rent.getPropertyID()==property.getPropertyID()){
                                rents = rents + rent.getRentAmount();
                            }
                        }
                        System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n", property.getPropertyAddress().toString(), rents, expenses, property.getManagementFee(),rents*property.getManagementFee(), (rents-expenses-rents*property.getManagementFee()));

                        totalRent = totalRent + rents;
                        totalExpense = totalExpense + expenses;
                        totalFee = totalFee + rents*property.getManagementFee();
                        totalNet = totalNet +rents-expenses-rents*property.getManagementFee();
                    }

                }
                System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("|%60s|%16s|%16s|%16s|%16s|%16s|\n","TOTAL",totalRent,totalExpense,"",totalFee,totalNet);
                System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        if(option == 3) {
            System.out.print("Please enter your expected postcode: ");
            int postcode = scanner.nextInt();

            while(postcode < 1000 || postcode > 9999) {
                System.out.println("The postcode must have 4 digits!");
                System.out.print("Please enter your expected postcode again: ");
                postcode = scanner.nextInt();
            }

            ArrayList<Property> foundProperty = new ArrayList<>();

            for(Property properties : Property.propertyArrayList){
                if(properties.getPropertyAddress().getPostCode() == postcode) {
                    foundProperty.add(properties);
                }
            }
            System.out.println("PORTFOLIO REPORT");
            System.out.print("Post Code: ");
            System.out.println(postcode);
            System.out.println("Report Generated: "+currentDate);
            System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n","Property","Rent","Expenses","Fee Rate","Fees","Net");
            System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");
            for(Property property: foundProperty){
                float expenses =0;
                float rents = 0;
                for (Expense expense: Expense.expenseArrayList){
                    if (expense.getPropertyID()==property.getPropertyID()){
                        expenses = expenses + expense.getAmount();
                    }
                }
                for(Rent rent: Rent.rentArrayList){
                    if(rent.getPropertyID()==property.getPropertyID()){
                        rents = rents + rent.getRentAmount();
                    }
                }
                System.out.printf("|%60s|%16s|%16s|%16s|%16s|%16s|\n",property.getPropertyAddress().toString(), rents, expenses, property.getManagementFee(),rents*property.getManagementFee(), (rents-expenses-rents*property.getManagementFee()));
                totalRent = totalRent + rents;
                totalExpense = totalExpense + expenses;
                totalFee = totalFee + rents*property.getManagementFee();
                totalNet = totalNet +rents-expenses-rents*property.getManagementFee();
            }
            System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format("|%60s|%16s|%16s|%16s|%16s|%16s|\n","TOTAL",totalRent,totalExpense,"",totalFee,totalNet);
            System.out.printf("%.150s\n","--------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    public static void sortClients(List<Client> clientList) {
        Collections.sort(clientList, (client1, client2) -> {
            int res = client1.getSurname().compareToIgnoreCase(client2.getSurname());
            if (res != 0)
                return res;
            return client1.getSurname().compareToIgnoreCase(client2.getSurname());
        });
    }
}