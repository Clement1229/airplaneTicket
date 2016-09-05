package edu.depaul.cdm.se450.airline.data;

import java.util.List;

public interface SeatData {

    /**
     * Returns all the seats and whether it is available or not
     * @param flightInfo
     * @return
     */
    List<AirplaneSeat> getSeatAvailability(String flightInfo);

    
    /**
     * For given seat (RowAisle), will return whether it is available to or not
     * @param flightInfo
     * @param row
     * @param aisle
     * @return 
     */
    boolean isSeatAvailable(String flightInfo, int row, String aisle);
    
}
