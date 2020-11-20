package ProjectFinal;

/**
 * Student ID:
 * Name:
 * Campus:
 * Tutor Name:
 * Class Day:
 * Class Time:
 */
public class DateTime {
    public int day;
    public int month;
    public int year;

    public DateTime(DateTime date) {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        String string = this.year+"-"+this.month+"-"+this.day;
        return string;
    }
}
