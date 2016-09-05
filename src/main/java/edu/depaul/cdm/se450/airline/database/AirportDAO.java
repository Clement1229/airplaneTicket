package edu.depaul.cdm.se450.airline.database;

import edu.depaul.cdm.se450.airline.AirportService;
import edu.depaul.cdm.se450.airline.data.Airport;
import edu.depaul.cdm.se450.airline.data.FlightInfo;
import edu.depaul.cdm.se450.airline.database.command.GetAirportsServicedCommand;
import edu.depaul.cdm.se450.airline.database.command.GetFlightsCommand;
import edu.depaul.cdm.se450.airline.database.command.GetFlightsWithAirportCommand;
import edu.depaul.cdm.se450.airline.database.command.IsAirportServicedByCommand;
import java.sql.Connection;
import java.util.List;

public class AirportDAO implements AirportService{
    private Connection con;
    
    public AirportDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List<Airport> getAirportsServiced(String airline) {
        GetAirportsServicedCommand cmd = new GetAirportsServicedCommand(con, airline);
        cmd.execute();
        return (List<Airport>) cmd.getResult();
    }

    @Override
    public List<FlightInfo> getFlightsFor(String airline) {
        GetFlightsCommand cmd = new GetFlightsCommand(con, airline);
        cmd.execute();
        return (List<FlightInfo>) cmd.getResult();
    }

    @Override
    public boolean isAirportServicedBy(String airline, String airport) {
        IsAirportServicedByCommand cmd = new IsAirportServicedByCommand(con, airline, airport);
        cmd.execute();
        Boolean result = cmd.getResult();
        return result.booleanValue();
    }

    @Override
    public List<FlightInfo> getFlightsFor(String airline, String originationAirPort, String destinationAirPort) {
        GetFlightsWithAirportCommand cmd = new GetFlightsWithAirportCommand(con, airline, originationAirPort, destinationAirPort);
        cmd.execute();
        return (List<FlightInfo>) cmd.getResult();
    }
    
}
