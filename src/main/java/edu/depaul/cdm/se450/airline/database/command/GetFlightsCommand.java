package edu.depaul.cdm.se450.airline.database.command;

import edu.depaul.cdm.se450.airline.data.Airport;
import edu.depaul.cdm.se450.airline.data.FlightInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFlightsCommand implements Command {

    private final Connection con;
    private final String airline;
    private final List result;

    public GetFlightsCommand(Connection con, String airline) {
        this.con = con;
        this.airline = airline;
        result = new ArrayList();
    }

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public void execute() {
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select FLIGHT_NUM, ORIGIN_AIRPORT,DEST_AIRPORT, FLIGHT_TIME from FLIGHT_INFO where AIRLINE='" + airline + "' ");
            while (rs.next()) {
                String flightNum = rs.getString("FLIGHT_NUM");
                Airport originAirport = new Airport(rs.getString("ORIGIN_AIRPORT"), "", "", "");
                Airport destinationAirport = new Airport(rs.getString("DEST_AIRPORT"), "", "", "");
                String flightTime = rs.getString("FLIGHT_TIME");
                result.add(new FlightInfo(flightNum, originAirport, destinationAirport, flightTime));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetFlightsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
