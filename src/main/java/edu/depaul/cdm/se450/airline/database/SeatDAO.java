package edu.depaul.cdm.se450.airline.database;

import edu.depaul.cdm.se450.airline.data.AirplaneSeat;
import edu.depaul.cdm.se450.airline.data.SeatData;
import edu.depaul.cdm.se450.airline.database.templatemethod.GetSeatAvailability;
import edu.depaul.cdm.se450.airline.database.templatemethod.IsSeatAvailable;
import java.sql.Connection;
import java.util.List;

public class SeatDAO  implements SeatData {
    private final Connection con;
    public SeatDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public boolean isSeatAvailable(String fligthNum, int row, String aisle) {
        IsSeatAvailable template = new IsSeatAvailable(con, fligthNum, row, aisle);
        return template.getResult();
    }

    @Override
    public List<AirplaneSeat> getSeatAvailability(String flightInfo) {
        GetSeatAvailability template = new GetSeatAvailability(con, flightInfo);
        return template.getResult();
    }

}
