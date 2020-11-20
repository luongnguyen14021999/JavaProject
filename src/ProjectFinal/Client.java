package ProjectFinal;

import java.util.ArrayList;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */

public class Client {

    private int clientID;
    private String surname;
    private String firstname;
    private Address address;

    static ArrayList<Client> clientArrayList = new ArrayList<>();

    public Client(int clientID,String firstname, String surname, Address address){
        this.clientID = clientID;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
    }

    public int getClientID() {
        return clientID;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }
    public String toString() {

        String string = this.clientID+","+this.surname+","+this.firstname+","+this.address.toString();
        return string;
    }

}
