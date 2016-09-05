package edu.depaul.cdm.se450.airline.database.templatemethod;

import edu.depaul.cdm.se450.airline.database.SeatDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractTemplate {

    private Connection con;

    protected AbstractTemplate(Connection con) {
        this.con = con;
    }

    protected abstract String getSQL();

    protected abstract void processResultSet(ResultSet rs) throws SQLException;

    protected void runQuery() {
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(getSQL());
            while (rs.next()) {
                processResultSet(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
