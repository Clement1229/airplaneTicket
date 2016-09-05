package edu.depaul.cdm.se450.airline.database.command;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IsAirportServicedByCommand implements Command {
    private final Connection con;
    private final String airline;
    private final String airport;
    private boolean result;
    
    public IsAirportServicedByCommand(Connection con, String airline, String airport) {
        this.con = con;
        this.airline = airline;
        this.airport = airport;
    }
    
    @Override
    public void execute() {
        result = false;
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from AIRPORT_AIRLINE where AIRLINE='" + airline + "' and AIRPORT='" + airport +"'");
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetFlightsWithAirportCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Boolean getResult() {
        return result;
    }
    
}
