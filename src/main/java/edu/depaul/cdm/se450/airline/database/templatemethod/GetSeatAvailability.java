package edu.depaul.cdm.se450.airline.database.templatemethod;

import edu.depaul.cdm.se450.airline.data.AirplaneSeat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetSeatAvailability extends AbstractTemplate {

    private final String flightInfo;
    private List<AirplaneSeat> result = new ArrayList<>();

    public GetSeatAvailability(Connection con, String flightInfo) {
        super(con);
        this.flightInfo = flightInfo;
    }

    @Override
    protected String getSQL() {
        return "select seatnumber, is_available from AIRPLANE_SEAT where FLIGHT_NUM = '" + flightInfo + "'";
    }

    @Override
    protected void processResultSet(ResultSet rs) throws SQLException {
        String seatNumber = rs.getString("seatnumber");
        boolean isAvailable = rs.getBoolean("is_available");
        result.add(new AirplaneSeat(seatNumber, isAvailable));
    }
    
  public List<AirplaneSeat> getResult() {
        runQuery();
        return result;
    }    

}
