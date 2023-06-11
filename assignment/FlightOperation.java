public class FlightOperation 
{
    // Declaring class fields
    private String flightType, arrivalDeparture, domesticIntl;
    private int flightOpsCount;
    private Date date;

    // Constructor for FlightOperation with parameters
    public FlightOperation(String pFlightType, String pArrivalDeparture, String pDomesticIntl, int pFlightOpsCount, Date pDate)
    {
        flightType = pFlightType;
        arrivalDeparture = pArrivalDeparture;
        domesticIntl = pDomesticIntl;
        flightOpsCount = pFlightOpsCount;
        date = pDate;
    }

    public FlightOperation()
    {
        flightType = "Charter";
        arrivalDeparture = "Arrival";
        domesticIntl = "Domestic";
        flightOpsCount = 0;
        date = new Date(0, 0, 0);
    }

    // Accessor methods for FlightOperation
    public String getFlightType()
    {
        return flightType;
    }

    public String getArrivalDeparture()
    {
        return arrivalDeparture;
    }

    public String getDomesticIntl()
    {
        return domesticIntl;
    }

    public int getFlightOpsCount()
    {
        return flightOpsCount;
    }

    // Date mutator methods 
    public int getDay()
    {
        return date.getDay();
    }

    public int getMonth()
    {
        return date.getMonth();
    }

    public int getYear()
    {
        return date.getYear();
    }

    // Mutator methods for FlightOperation
    public void setFlightType(String pFlightType)
    {
        flightType = pFlightType;
    }

    public void setArrivalDeparture(String pArrivalDeparture)
    {
        arrivalDeparture = pArrivalDeparture;
    }

    public void setDomesticIntl(String pDomesticIntl)
    {
        domesticIntl = pDomesticIntl;
    }

    public void setFlightOpsCount(int pFlightOpsCount)
    {
        flightOpsCount = pFlightOpsCount;
    }

    public void setDate(int pDay, int pMonth, int pYear)
    {
        date.setDay(pDay);
        date.setMonth(pMonth);
        date.setYear(pYear);
    }
}
