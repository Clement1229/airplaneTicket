package edu.depaul.cdm.se450.airline;



import edu.depaul.cdm.se450.airline.data.Airport;
import edu.depaul.cdm.se450.airline.data.FlightInfo;
import java.util.List;

/**
 * Provides different airport related
 */
public interface AirportService {
    /**
     *
     * @param airline
     * @return list of airports serviced by the airline
     */
    public List<Airport> getAirportsServiced(String airline);

    /**
     * Flight information for a given airline
     * @param airline
     * @return
     */
    public List<FlightInfo> getFlightsFor(String airline);

    
    /**
     * Determines whether the specific airline services particular airport
     * @param airline
     * @param airport
     * @return
     */
    public boolean isAirportServicedBy(String airline, String airport);
    
    /**
     * Returns the list of Flights for a given airline for given origination and destination airport
     * @param airline
     * @param originationAirPort
     * @param destinationAirPort
     * @return 
     */
    public List<FlightInfo> getFlightsFor(String airline, String originationAirPort, String destinationAirPort);
 }
