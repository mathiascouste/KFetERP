package model.time;

/**
 * Provides a date object in a yyyy mm dd format
 * 
 * @author Loïc GAILLARD
 * 
 */
public class Date {
    private int year, month, day;
    private long value;
    
    /**
     * @deprecated
     */
    public Date() {
        
    }

    /**
     * Creates a new date
     * 
     * @param year
     * @param month
     * @param day
     * @throws InvalidDateException
     * 
     */
    public Date(int year, int month, int day) throws InvalidDateException {
        this.year = year;
        this.month = month;
        this.day = day;

        if (!isValid(year, month, day))
            throw new InvalidDateException(year, month, day);

        int m = (month + 9) % 12;
        int y = year - m / 10;
        value = 365 * y + y / 4 - y / 100 + y / 400 + (m * 306 + 5) / 10
                + (day - 1);
    }

    /**
     * Creates a new date
     * 
     * @param date
     *            The date "yyyy-mm-dd"
     * @throws InvalidDateException
     * 
     */
    public Date(String date) throws InvalidDateException {
        String[] inputs = date.split("-");
        if (inputs.length != 3) {
            throw new InvalidDateException(date);
        }

        this.year = Integer.parseInt(inputs[0]);
        this.month = Integer.parseInt(inputs[1]);
        this.day = Integer.parseInt(inputs[2]);

        if (!isValid(year, month, day))
            throw new InvalidDateException(date);

        int m = (month + 9) % 12;
        int y = year - m / 10;
        value = 365 * y + y / 4 - y / 100 + y / 400 + (m * 306 + 5) / 10
                + (day - 1);
    }

    /**
     * Creates a new date
     * 
     * @param value
     *            date in days
     * @author Laureen Ginier
     */
    public Date(long value) {
        this.value = value;
        long y = (10000 * value + 14780) / 3652425;
        long d = value - (365 * y + y / 4 - y / 100 + y / 400);
        if (d < 0) {
            y = y - 1;
            d = value - (365 * y + y / 4 - y / 100 + y / 400);
        }
        long m = (100 * d + 52) / 3060;
        this.month = (int) (m + 2) % 12 + 1;
        this.year = (int) (y + (m + 2) / 12);
        this.day = (int) (d - (m * 306 + 5) / 10 + 1);
    }

    /**
     * Check if the date in parameter is before the current object date
     * 
     * @param d
     *            date to compare with
     * @return if the date in parameter is before the current object date
     */
    public boolean isBefore(Date d) {
        return (d.getValue() > value);
    }

    /**
     * Check if the date in parameter is after the current object date
     * 
     * @param d
     *            date to compare with
     * @return if the date in parameter is after the current object date
     */
    public boolean isAfter(Date d) {
        return (d.getValue() < value);
    }

    /**
     * 
     * @param d
     * @return if the current object date is the s
     */
    public boolean equals(Date d) {
        return (d.getValue() == value);
    }

    /**
     * 
     * @param d1
     * @param d2
     * @return if the current object date is between the dates d1 and d2
     */
    public boolean isBetween(Date d1, Date d2) {
        return (value >= d1.getValue() && value <= d2.getValue());
    }

    /**
     * Check if a date is valid
     * 
     * @param year
     * @param month
     * @param day
     * @return validity of the date
     */
    public static boolean isValid(int year, int month, int day) {
        boolean yearOk = (year >= 1581) && (year <= 2500);
        boolean monthOk = (month >= 1) && (month <= 12);
        boolean dayOk = (day >= 1) && (day <= daysInMonth(year, month));

        return (yearOk && monthOk && dayOk);
    }

    /**
     * 
     * @param year
     * @param month
     * @return the number of days in a month (checks bissextile years)
     */
    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            daysInMonth = 31;
            break;
        case 2:
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
            break;
        default:
            daysInMonth = 30;
        }
        return daysInMonth;
    }

    /**
     * @return the year of the date yyyy - mm - dd
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the month of the date yyyy - mm - dd
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the days of the date yyyy - mm - dd
     */
    public int getDay() {
        return day;
    }

    /**
     * 
     * @return The value in days of the date
     */
    public long getValue() {
        return value;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @param value the value to set
     */
    public void setValue(long value) {
        this.value = value;
    }

    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
