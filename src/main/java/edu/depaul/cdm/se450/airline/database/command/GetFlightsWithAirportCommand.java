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

public class GetFlightsWithAirportCommand implements Command {
    private final Connection con;
    private final String airline;
    private final String originationAirPort;
    private final String destinationAirPort;
    private final List result;
    
    public GetFlightsWithAirportCommand(Connection con, String airline, String originationAirPort, String destinationAirport) {
        this.con = con;
        this.airline = airline;
        this.originationAirPort = originationAirPort;
        this.destinationAirPort = destinationAirport;
        result = new ArrayList();
    }

    @Override
    public void execute() {
        try (Statement stmt = con.createStatement()){
            StringBuilder sql = new StringBuilder("select FLIGHT_NUM, ORIGIN_AIRPORT,DEST_AIRPORT, FLIGHT_TIME from FLIGHT_INFO where AIRLINE='");
            sql.append(airline);
            sql.append("' and ORIGIN_AIRPORT='");
            sql.append(originationAirPort);
            sql.append("' and DEST_AIRPORT='");
            sql.append(destinationAirPort);
            sql.append("'");
            
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                String flightNum = rs.getString("FLIGHT_NUM");
                Airport originAirport = new Airport(rs.getString("ORIGIN_AIRPORT"),"", "", "");
                Airport destinationAirport = new Airport(rs.getString("DEST_AIRPORT"),"", "", "");
                String flightTime = rs.getString("FLIGHT_TIME");
                result.add(new FlightInfo(flightNum, originAirport, destinationAirport, flightTime));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetFlightsWithAirportCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List getResult() {
        return result;
    }
    
}
