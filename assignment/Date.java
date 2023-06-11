// Class Date implemented in Week 7 of PDI Practicals, reimplemented for FlightOperations
public class Date 
{
    // Class fields
    private int dayOfMonth, monthOfYear, year;

    // Constructor with Parameters
    public Date(int pDay, int pMonth, int pYear)
    {
        dayOfMonth = pDay;
        monthOfYear = pMonth;
        year = pYear;
    }
    // Copy Constructor
    public Date(Date pDate)
    {
        dayOfMonth  = pDate.getDay();
        monthOfYear = pDate.getMonth();
        year = pDate.getYear();
    }
   
    // Accessor Methods
    public int getDay()
    {
        return dayOfMonth;
    }

    public int getMonth()
    {
        return monthOfYear;
    }

    public int getYear()
    {
        return year;
    }

    // Mutator Methods
    public void setDay(int pDay)
    {
        dayOfMonth  = pDay;
    }

    public void setMonth(int pMonth)
    {
        monthOfYear = pMonth;
    }

    public void setYear(int pYear)
    {
        year = pYear;
    }

    // String method
    public String toString()
    {
        String dateString;
        dateString = dayOfMonth  + "/" + monthOfYear + "/" + year;
        return dateString;
    }

    // Equals method
    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Date inDate = null;
        if(inObject instanceof Date)
        {
            inDate = (Date)inObject;
            if(dayOfMonth == inDate.getDay()){
                if(monthOfYear == inDate.getMonth()){
                    if(year == inDate.getYear()){
                        isEqual = true;
                    }
                }
            }
        }
        return isEqual;
    }
}
