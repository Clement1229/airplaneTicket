package edu.depaul.cdm.se450.airline.database.command;

import edu.depaul.cdm.se450.airline.data.Airport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetAirportsServicedCommand implements Command {

    private final Connection con;
    private final String airline;
    private final List result;

    public GetAirportsServicedCommand(Connection con, String airline) {
        this.con = con;
        this.airline = airline;
        result = new ArrayList();
    }

    @Override
    public void execute() {
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select airport from AIRPORT_AIRLINE where AIRLINE='" + airline + "' ");
            if (rs.next()) {
                result.add(new Airport(rs.getString("airport"), "", "", ""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetAirportsServicedCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getResult() {
        return result;
    }

}
