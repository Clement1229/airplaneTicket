package edu.depaul.cdm.se450.airline;

import edu.depaul.cdm.se450.airline.data.AirplaneSeat;
import edu.depaul.cdm.se450.airline.data.FlightInfo;
import java.util.List;

public interface AirlineService {
    /**
     * @param flightInfo
     * @return available seat on a given flight
     */
    public List<AirplaneSeat> findAvailableSeat(FlightInfo flightInfo);
        
    /**
     * Attempts to book a flight
     * @param flightToBook
     * @return true if one was successful in booking a flight, false if was not
     */
    public boolean bookFlight(FlightInfo flightToBook, AirplaneSeat seat);
    
}
