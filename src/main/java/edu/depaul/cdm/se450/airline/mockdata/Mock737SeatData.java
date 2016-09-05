package edu.depaul.cdm.se450.airline.mockdata;

import edu.depaul.cdm.se450.airline.data.AirplaneSeat;
import edu.depaul.cdm.se450.airline.data.SeatData;
import java.util.ArrayList;
import java.util.List;

public class Mock737SeatData implements SeatData {
    public static final String[] AVAILABLE_AISLE = {"A", "B", "C", "D", "E", "F"};
    public static final int MIN_SEAT_ROW = 1;
    public static final int MAX_SEAT_ROW = 20;
        
    /**
     * Returns all the seats and whether it is available or not
     * @param flightInfo
     * @return 
     */
    @Override
    public List<AirplaneSeat> getSeatAvailability(String flightInfo)  {
        ArrayList<AirplaneSeat> seats = new ArrayList();
        for (int row = MIN_SEAT_ROW; row < MAX_SEAT_ROW; row++) {
            for (String aisle : AVAILABLE_AISLE) {
                seats.add(new AirplaneSeat(row + aisle, row % 2 == 0));
            }
        }
        return seats;
    }
    

    /**
     * 
     * @param flightInfo
     * @param row
     * @param aisle
     * @return 
     */
    @Override
    public boolean isSeatAvailable(String flightInfo, int row, String aisle) {
        // TODO
        // Call getSeatAvailability with flightInfo and determine whether the specific seat is available or not
        List<AirplaneSeat> seats = getSeatAvailability(flightInfo);
        String seatNum = row + aisle;
        boolean isAvailable = false;
        
        for (AirplaneSeat seat : seats) {
            if (seat.getSeatNum().equals(seatNum)) {
                isAvailable = seat.isAvailable();
                break;
            }
        }
        return isAvailable;
        
    }
}
