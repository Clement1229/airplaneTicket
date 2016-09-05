package edu.depaul.cdm.se450.airline.mockdata;

import edu.depaul.cdm.se450.airline.AirportService;
import edu.depaul.cdm.se450.airline.data.Airport;
import edu.depaul.cdm.se450.airline.data.FlightInfo;
import java.util.ArrayList;
import java.util.List;

public class MockAirportService implements AirportService {
    private static final Airport AIRPORT_ORD = new Airport("ORD", "O'Hare International", "Chicago", "IL");
    private static final Airport AIRPORT_MIA = new Airport("MIA", "Miami International", "Miami", "FL");
    private static final Airport AIRPORT_MCO = new Airport("MCO", "Orlando International", "Orlando", "FL");
  
    /**
     * 
     * @param airline
     * @return list of airports serviced by the airline
     */
    @Override
    public List<Airport> getAirportsServiced(String airline) {
        List<Airport> airports = new ArrayList<>();
        airports.add(AIRPORT_ORD);
        airports.add(AIRPORT_MIA);
        airports.add(AIRPORT_MCO);
                
        return airports;
    }
    
    /**
     * Determines whether the specific airline services particular airport
     * @param airline
     * @param airport
     * @return 
     */
    @Override
    public boolean isAirportServicedBy(String airline, String airport) {
        List<Airport> airports = getAirportsServiced(airline);

        boolean isServiced = false;
        for (Airport ap : airports) {
            if (airport.equals(ap.getAirportCode())) {
                isServiced = true;
                break;
            }
        }
        return isServiced;
    }
    
    /**
     * Returns the list of Flights for a given airline for given origination and destination airport
     * @param airline
     * @param originationAirPort
     * @param destinationAirPort
     * @return 
     */
    public List<FlightInfo> getFlightsFor(String airline, String originationAirPort, String destinationAirPort) {
        List<FlightInfo> flights = getFlightsFor(airline);
        
        List<FlightInfo> retval = new ArrayList<FlightInfo>();
        for (FlightInfo flight : flights) {
            if (flight.getOrigination().getAirportCode().equals(originationAirPort) && 
                    flight.getDestination().getAirportCode().equals(destinationAirPort)) {
                retval.add(flight);
            }
        }
        
        return retval;
    }

    
    /**
     * Flight information for a given airline
     * @param airline
     * @return 
     */
    @Override
    public List<FlightInfo> getFlightsFor(String airline) {
        List<FlightInfo> flights = new ArrayList<>();
        flights.add(new FlightInfo(airline+"11", AIRPORT_ORD, AIRPORT_MIA, "1:00pm"));
        flights.add(new FlightInfo(airline+"12", AIRPORT_ORD, AIRPORT_MIA, "3:00pm"));
        flights.add(new FlightInfo(airline+"13", AIRPORT_ORD, AIRPORT_MIA, "5:00pm"));
        
        flights.add(new FlightInfo(airline+"21", AIRPORT_ORD, AIRPORT_MCO, "9:00am"));
        flights.add(new FlightInfo(airline+"22", AIRPORT_ORD, AIRPORT_MCO, "11:00pm"));
        flights.add(new FlightInfo(airline+"23", AIRPORT_ORD, AIRPORT_MCO, "2:00pm"));
        flights.add(new FlightInfo(airline+"24", AIRPORT_ORD, AIRPORT_MCO, "4:00pm"));
        
        flights.add(new FlightInfo(airline+"31", AIRPORT_MIA, AIRPORT_ORD, "9:00am"));
        flights.add(new FlightInfo(airline+"32", AIRPORT_MIA, AIRPORT_ORD, "11:00am"));
        flights.add(new FlightInfo(airline+"33", AIRPORT_MIA, AIRPORT_ORD, "1:00pm"));

        flights.add(new FlightInfo(airline+"41", AIRPORT_MCO, AIRPORT_ORD, "10:00am"));
        flights.add(new FlightInfo(airline+"42", AIRPORT_MCO, AIRPORT_ORD, "11:00am"));
        flights.add(new FlightInfo(airline+"43", AIRPORT_MCO, AIRPORT_ORD, "1:00pm"));
        flights.add(new FlightInfo(airline+"44", AIRPORT_MCO, AIRPORT_ORD, "3:00pm"));
        
        flights.add(new FlightInfo(airline+"51", AIRPORT_MIA, AIRPORT_MCO, "8:00am"));
        flights.add(new FlightInfo(airline+"52", AIRPORT_MIA, AIRPORT_MCO, "10:00am"));
        flights.add(new FlightInfo(airline+"53", AIRPORT_MIA, AIRPORT_MCO, "1:00pm"));

        flights.add(new FlightInfo(airline+"61", AIRPORT_MCO, AIRPORT_MIA, "10:00am"));
        flights.add(new FlightInfo(airline+"62", AIRPORT_MCO, AIRPORT_MIA, "11:00am"));
        flights.add(new FlightInfo(airline+"63", AIRPORT_MCO, AIRPORT_MIA, "3:00pm"));
        
        return flights;
    }
}
