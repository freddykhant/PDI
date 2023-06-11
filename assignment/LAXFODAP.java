import java.io.*;
import java.util.*;

// Class for Los Angeles Flight Operations Data Analysis Program
public class LAXFODAP 
{
    public static void main(String[] args)
    {
        // Intializes new scanner object
        Scanner sc = new Scanner(System.in);
        // Variable to store user choice
        int option;
        // Boolean to determine if menu should loop
        boolean shouldLoop = true;
        // Array to store flight operation objects read in from LaxData file
        FlightOperation[] flights = readFile("LaxData.csv");
        // Declares all variables for flight operation statistics
        int total, arrival, departure, domestic, intl, charter, scheduled;
        double departureRatio, arrivalRatio, domesticRatio, intlRatio, charterRatio, scheduledRatio;
        int day, month, year;
        // Counts total flight operations
        total = countTotal(flights);

        while(shouldLoop == true){
            System.out.println("Welcome to the LAX Flight Operations Data Analysis Program.");
            System.out.println("Please make a selection from the menu options below regarding the information you would like to see: \n");
            System.out.println("> 1. Percentage and count of Arrival vs Departure flights.");
            System.out.println("> 2. Percentage and count of Domestic vs International flights.");
            System.out.println("> 3. Percentage and count of Charter vs Scheduled flights.");
            System.out.println("> 4. Split of flights by above criteria for a specified date.");
            System.out.println("> 5. Percentage and count of International Scheduled Departures.");
            System.out.println("> 6. Percentage and count of Domestical Charter Arrivals.");
            System.out.println("> 7. Exit the program.");
            System.out.println("\n Enter your choice: ");
            option = sc.nextInt();
            System.out.println();

            switch(option)
            {
                // Option 1
                case 1:
                    arrival = countArrival(flights); // Counts number of arrival flights
                    departure = countDeparture(flights); // Counts number of departure flights
                    departureRatio = getPercent(departure, total); // Gets percentage of departure flights
                    arrivalRatio = getPercent(arrival, total); // Gets percentage of arrival flights
                    System.out.println("Departure Flights: " + departure + "/" + total + " (" + departureRatio + "%)");
                    System.out.println("Arrival Flights: " + arrival + "/" + total + " (" + arrivalRatio + "%)\n");
                    break;

                // Option 2
                case 2:
                    domestic = countDomestic(flights); // Counts number of domestic flights
                    intl = countIntl(flights); // Counts number of international flights
                    domesticRatio = getPercent(domestic, total); // Gets percentage of domestic flights
                    intlRatio = getPercent(intl, total); // Gets percentage of international flights
                    System.out.println("Domestic Flights: " + domestic + "/" + total + " (" + domesticRatio + "%)");
                    System.out.println("International Flights: " + intl + "/" + total + " (" + intlRatio + "%)\n");
                    break;
                
                // Option 3
                case 3:
                    charter = countCharter(flights); // Counts number of charter flights
                    scheduled = countScheduled(flights); // Counts number of scheduled flights
                    charterRatio = getPercent(charter, total); // Gets percentage of charter flights
                    scheduledRatio = getPercent(scheduled, total); // Gets percentage of scheduled flights
                    System.out.println("Charter Flights: " + charter + "/" + total + " (" + charterRatio + "%)");
                    System.out.println("Scheduled Flights: " + scheduled + "/" + total + " (" + scheduledRatio + "%)\n");
                    break;
                
                // Option 4
                case 4:
                    // Prompts user to input date 
                    System.out.println("Enter a Day: ");
                    day = sc.nextInt();
                    System.out.println("Enter a Month: ");
                    month = sc.nextInt();
                    System.out.println("Enter a Year: ");
                    year = sc.nextInt();
                    System.out.println();

                    // Declares new variables for statistics of flight operations for given date
                    int newTotal = 0;
                    int newDep = 0;
                    int newArr = 0;
                    int newDom = 0;
                    int newIntl = 0;
                    int newChart = 0;
                    int newSched = 0;

                    // Counts statistics of flight operations for given date
                    for(int i = 0; i < flights.length; i++){
                        if(flights[i].getDay() == day && flights[i].getMonth() == month && flights[i].getYear() == year){
                            newTotal += 1;
                            if(flights[i].getArrivalDeparture().equals("Departure")){
                                newDep += 1;
                            }
                            if(flights[i].getArrivalDeparture().equals("Arrival")){
                                newArr += 1;
                            }
                            if(flights[i].getDomesticIntl().equals("Domestic")){
                                newDom += 1;
                            }
                            if(flights[i].getDomesticIntl().equals("International")){
                                newIntl += 1;
                            }
                            if(flights[i].getFlightType().equals("Charter")){
                                newChart += 1;
                            }
                            if(flights[i].getFlightType().equals("Scheduled")){
                                newSched += 1;
                            }
                        }
                    }
                    // Gets total percentage statistics of flight operations for given date
                    double newDepRatio = getPercent(newDep, newTotal);
                    double newArrRatio = getPercent(newArr, newTotal);
                    double newDomRatio = getPercent(newDom, newTotal);
                    double newIntlRatio = getPercent(newIntl, newTotal);
                    double newChartRatio = getPercent(newChart, newTotal);
                    double newSchedRatio = getPercent(newSched, newTotal);

                    System.out.println("Departure Flights: " + newDep + "/" + newTotal + " (" + newDepRatio + "%)");
                    System.out.println("Arrival Flights: " + newArr + "/" + newTotal + " (" + newArrRatio + "%)\n");
                    System.out.println("Domestic Flights: " + newDom + "/" + newTotal + " (" + newDomRatio + "%)");
                    System.out.println("International Flights: " + newIntl + "/" + newTotal + " (" + newIntlRatio + "%)\n");
                    System.out.println("Charter Flights: " + newChart + "/" + newTotal + " (" + newChartRatio + "%)");
                    System.out.println("Scheduled Flights: " + newSched + "/" + newTotal + " (" + newSchedRatio + "%)\n");
                    break;

                // Option 5
                case 5:
                    // Counts total International Scheuled Departures and displays statistics
                    int intlScheduledDepartures = 0;
                    for(int i = 0; i < flights.length; i++){
                        if(flights[i].getDomesticIntl().equals("International")){
                            if(flights[i].getFlightType().equals("Scheduled")){
                                if(flights[i].getArrivalDeparture().equals("Departure")){
                                    intlScheduledDepartures += 1;
                                }
                            }
                        }
                    }
                    double isdRatio = getPercent(intlScheduledDepartures, total);
                    System.out.println("International Scheduled Departures: " + intlScheduledDepartures + "/" + total + " (" + isdRatio + "%)\n");
                    break;

                // Option 6
                case 6:
                    // Counts total Domestical Charter Arrivals and displays statistics
                    int domesticCharterArrivals = 0;
                    for(int i = 0; i < flights.length; i++){
                        if(flights[i].getDomesticIntl().equals("Domestic")){
                            if(flights[i].getFlightType().equals("Charter")){
                                if(flights[i].getArrivalDeparture().equals("Arrival")){
                                    domesticCharterArrivals += 1;
                                }
                            }
                        }
                    }
                    double dcaRatio = getPercent(domesticCharterArrivals, total);
                    System.out.println("Domestical Charter Arrivals: " + domesticCharterArrivals + "/" + total + " (" + dcaRatio + "%)\n");
                    break;

                // Option 7
                case 7:
                    // Stops menu loop and exits program
                    System.out.println("Exiting Program...");
                    shouldLoop = false;
                    break;
            }
        }
        
        sc.close();
    }
    
    // Reads file, populating flight array with FlightOperation objects then returns flight array
    public static FlightOperation[] readFile(String pFileName)
    {
        FlightOperation[] flights = new FlightOperation[1531];
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        String line;
        int lineNum;

        try
        {
            fileStream = new FileInputStream(pFileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            bufRdr.readLine();
            line = bufRdr.readLine();
            lineNum = 0;

            while(line != null)
            {
                // Creates FlightOperation object
                FlightOperation flight = processLine(line);
                // Populates array at given index with object
                flights[lineNum] = flight;
                // Moves to next line
                line = bufRdr.readLine();
                lineNum += 1;
            }
            fileStream.close();
        }
        // Exception handling for invalid file format
        catch(IOException e)
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {}
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
        return flights;
    }

    // Processes a line of a file and initializes fields for FlightOperations object
    public static FlightOperation processLine(String csvRow)
    {
        String[] data;
        data = csvRow.split(",");
        FlightOperation outFO = new FlightOperation();
        outFO.setDate(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        outFO.setFlightType(data[3]);
        outFO.setArrivalDeparture(data[4]);
        outFO.setDomesticIntl(data[5]);
        outFO.setFlightOpsCount(Integer.parseInt(data[6]));
        return outFO;
    }

    // Counts total FlightOperation objects
    public static int countTotal(FlightOperation[] flightArray)
    {
        int total;
        total = 0;
        for(int i = 0; i < flightArray.length; i++){
            total += 1;
        }
        return total;
    }

    // Counts total Departure flights
    public static int countDeparture(FlightOperation[] flightArray)
    {
        int departure;
        departure = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getArrivalDeparture().equals("Departure")){
                departure += 1;
            }
        }
        return departure;
    }

    // Counts total Arrival flights
    public static int countArrival(FlightOperation[] flightArray)
    {
        int arrival;
        arrival = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getArrivalDeparture().equals("Arrival")){
                arrival += 1;
            }
        }
        return arrival;
    }

    // Counts total Domestic flights
    public static int countDomestic(FlightOperation[] flightArray){
        int domestic;
        domestic = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getDomesticIntl().equals("Domestic")){
                domestic += 1;
            }
        }
        return domestic;
    }

    // Counts total International flights
    public static int countIntl(FlightOperation[] flightArray){
        int intl;
        intl = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getDomesticIntl().equals("International")){
                intl += 1;
            }
        }
        return intl;
    }

    // Counts total Charter flights
    public static int countCharter(FlightOperation[] flightArray){
        int charter;
        charter = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getFlightType().equals("Charter")){
                charter += 1;
            }
        }
        return charter;
    }

    // Counts total Scheduled flights
    public static int countScheduled(FlightOperation[] flightArray){
        int scheduled;
        scheduled = 0;
        for(int i = 0; i < flightArray.length; i++){
            if(flightArray[i].getFlightType().equals("Scheduled")){
                scheduled += 1;
            }
        }
        return scheduled;
    }

    // Gets percentage of one value by another
    public static double getPercent(int value1, int value2)
    {
        double percent = 0;
        try{
        percent = roundAvoid((double)value1/value2 * 100, 1);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero or negative not possible");
        }
        return percent;
    }

    // Rounds a double value to a given decimal place
    public static double roundAvoid(double value, int places)
    {
        double scale = 0;
        try{
            scale = Math.pow(10, places);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero or negative not possible");
        }
        return Math.round(value * scale) / scale;
    }
} 
