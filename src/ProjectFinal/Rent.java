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
public class Rent {
    private int propertyID;
    private float rentAmount;
    private DateTime rentDate;
    static  ArrayList<Rent> rentArrayList = new ArrayList<>();

    public Rent(int propertyID, float rentAmount, DateTime rentDate) {
        this.propertyID = propertyID;
        this.rentAmount = rentAmount;
        this.rentDate =  rentDate;
    }

    //get method
    public int getPropertyID() {
        return propertyID;
    }

    public float getRentAmount() {
        return rentAmount;
    }

    public DateTime getRentDate() {
        return rentDate;
    }

    public String toString() {

        String str = String.format(this.propertyID + "," + this.rentAmount + "," + this.rentDate);
        return str;
    }
}

