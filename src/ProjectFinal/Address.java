package ProjectFinal;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */

public class Address {
    private String street;
    private String suburb;
    private String state;
    private short postCode;

    public Address(String street, String suburb, String state, short postCode){
        this.street = street;
        this.suburb = suburb;
        this.state = state;
        this.postCode = postCode;
    }

    public short getPostCode() {
        return postCode;
    }

    public String toString(){
        String string = street+","+suburb+","+state+","+postCode;
        return string;
    }
}

